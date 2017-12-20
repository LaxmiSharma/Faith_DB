package in.lattice.faith_DB;
import java.io.PrintStream;

import in.lattice.faith_DB.dto.Packet;

public class DecoderTest implements EventListener { Decoder decoder;
  private int i;
  
  public DecoderTest() {}
  
  public static void main(String[] args) { DecoderTest decoderTest = new DecoderTest();
    decoderTest.setup();
    decoderTest.Start();
  }
  
  public void setup()
  {
    i = 0;
    

    decoder = new Decoder.Builder().receiverPort(8050).transmitterPort(8051).eventListener(this).build();
  }
  
  void Start() {
    decoder.clientStart();
  }
  
  void Stop() {
    decoder.clientStop();
  }
  
  void startTrasmitter() {
    decoder.startTransmitter();
  }
  
  public void ClientStarted() {
    System.out.println("ClientStarted");
  }
  
  public void ClientConnected()
  {
    System.out.println("ClientConnected");
    if (i == 0) {
      decoder.startTransmitter();
      i += 1;
    }
  }
  
  public void alreadyBind()
  {
    System.out.println("AlreadyBind");
  }
  
  public void firewall()
  {
    System.out.println("Firewall");
  }
  
  public void connectionLost()
  {
    System.out.println("ConnectionLost");
  }
  
  public void transmitterError()
  {
    System.out.println("transmitterError");
  }
  
  public void transmitterStarted()
  {
    System.out.println("transmitter");
  }
  
  public void newPacketFound(Packet packet)
  {
    if (packet.getId() == 4) {
      System.out.println("new PAckect found " + packet.getId());
    }
  }
  
  public void transmitSuccessfully() {
    System.out.println("transmitSuccessfully");
  }
  
  public void transmitterClose()
  {
    try {
      Thread.sleep(10000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  

  public void clientClosed()
  {
    decoder.clientStart();
  }
}
