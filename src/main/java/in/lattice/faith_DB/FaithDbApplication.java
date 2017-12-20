package in.lattice.faith_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.listener.DataListener;
import com.google.gson.*;
import in.lattice.faith_DB.dto.*;
import in.lattice.faith_DB.service.DBInsertionServiceImpl;

@SpringBootApplication
public class FaithDbApplication implements EventListener {

	Decoder decoder;
	SocketIOServer server;
	@Autowired
	private DBInsertionServiceImpl dbInsertionServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(FaithDbApplication.class, args);
		FaithDbApplication main = new FaithDbApplication();
		main.setup();
		main.start();

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				main.stopocket();
				System.out.println("close+123");
			}
		}));
	}

	private void stopocket() {
		server.stop();
		decoder.clientStop();
		decoder.stopTransmitter();
	}

	private void start() {
		decoder.clientStart();

	}

	private void setup() {
		Configuration config = new Configuration();
		config.setHostname("0.0.0.0");
		config.setPort(9092);
		server = new SocketIOServer(config);
		server.addEventListener("chatevent", ChatObject.class, new DataListener<ChatObject>() {
			@Override
			public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
				// broadcast messages to all clients
				server.getBroadcastOperations().sendEvent("chatevent", data);
			}
		});
		server.addEventListener("nibp", ChatObject.class, new DataListener<ChatObject>() {
			@Override
			public void onData(SocketIOClient client, ChatObject data, AckRequest ackSender) throws Exception {
				System.out.println(data.getMessage() + " nibp");
				server.getBroadcastOperations().sendEvent("nibp", data);
				if (data.getMessage().toLowerCase().equals("start")) {
					decoder.clientStop();
					decoder.startTransmitter();
				}

			}
		});

		server.addEventListener("client", ChatObject.class, new DataListener<ChatObject>() {
			@Override
			public void onData(SocketIOClient client, ChatObject data, AckRequest ackSender) throws Exception {
				System.out.println(data.getMessage() + " client");
				server.getBroadcastOperations().sendEvent("client", data);
				if (data.getMessage().equals("clientstart")) {
					decoder.clientStart();
				}
			}
		});

		server.start();
		decoder = new Decoder.Builder().receiverPort(8050).transmitterPort(8051).eventListener(this).build();

	}

	@Override
	public void ClientStarted() {
		ChatObject data = new ChatObject();
		data.setMessage("start");
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("client", data);
	}

	@Override
	public void ClientConnected() {
		ChatObject data = new ChatObject();
		data.setMessage("connect");
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("client", data);
	}

	@Override
	public void alreadyBind() {
		ChatObject data = new ChatObject();
		data.setMessage("already");
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("client", data);
	}

	@Override
	public void firewall() {

	}

	@Override
	public void connectionLost() {
		ChatObject data = new ChatObject();
		data.setMessage("disconnect");
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("client", data);

	}

	@Override
	public void transmitterError() {
		ChatObject data = new ChatObject();
		data.setMessage("error");
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("nibp", data);
	}

	@Override
	public void transmitterStarted() {

		ChatObject data = new ChatObject();
		data.setMessage("start");
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("nibp", data);
	}

	@Override
	public void newPacketFound(Packet packet) {
		// if (packet.getId() == 0x04) {
		ChatObject data = new ChatObject();
		Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
		data.setMessage(gson.toJson(packet));
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("chatevent", data);
		DBPacket dbPacket = new DBPacket();
		dbPacket.setPacket(packet);
		dbPacket.setEpisodeId(1L);
		dbInsertionServiceImpl.add(dbPacket);
		// }
	}

	@Override
	public void transmitSuccessfully() {
		ChatObject data = new ChatObject();
		Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
		data.setMessage("done");
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("nibp", data);

		// try{
		// Thread.sleep(22000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		// decoder.stopTransmitter();
		// decoder.clientStart();
	}

	@Override
	public void transmitterClose() {

		ChatObject data = new ChatObject();
		data.setMessage("nibpdecode");
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("nibp", data);
	}

	@Override
	public void clientClosed() {
		ChatObject data = new ChatObject();
		data.setMessage("close");
		data.setUserName("ABC");
		server.getBroadcastOperations().sendEvent("client", data);
		decoder.clientStart();
	}

}
