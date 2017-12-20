package in.lattice.faith_DB.transmitter;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import in.lattice.faith_DB.Decoder;
import in.lattice.faith_DB.utils.Utils;

public class Transmit
{
  private Decoder decoder;
  private ArrayList<Socket> clients;
  private static boolean runningStatus;
  
  public Transmit(Decoder decoder)
  {
    this.decoder = decoder;
    clients = new ArrayList();
    runningStatus = true;
  }
  
  private void sendData()
  {
    try
    {
      for (Socket socket : clients) {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(Utils.convertHexToString("55550907000000"));
      }
    }
    catch (java.io.IOException e1) {
      e1.printStackTrace();
      decoder.getEventListener().transmitterError();
    }
  }
  
  public void start()
  {
    runningStatus = true;
    try {
      ServerSocket server = new ServerSocket(decoder.getTransmitterPort());
      while (runningStatus)
      {
        clients.add(server.accept());
        
        for (Socket socket : clients)
        {
          byte[] buffer = new byte[socket.getInputStream().available()];
          socket.getInputStream().read(buffer);
          sendData();
          
          for (int i = 0; i < buffer.length; i++) {
            System.out.print(Integer.toHexString(Byte.valueOf(Byte.toString(buffer[i])).byteValue() & 0xFF) + " ");
            if (buffer[i] == 9) {
              runningStatus = false;
              server.close();
              decoder.getEventListener().transmitterClose();
              decoder.getEventListener().transmitSuccessfully();
              return;
            }
          }
          

          Thread.sleep(300L);
        }
      }
      server.close();
      decoder.getEventListener().transmitterClose();
    } catch (Exception e) {
      e.printStackTrace();
      decoder.getEventListener().transmitterError();
    }
  }
  

  public static synchronized void stop()
  {
    runningStatus = false;
  }
}
