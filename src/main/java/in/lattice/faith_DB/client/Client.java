package in.lattice.faith_DB.client;

import java.io.IOException;
import java.net.ServerSocket;

import in.lattice.faith_DB.Decoder;
import in.lattice.faith_DB.packet.PacketDecoder;

public class Client
{
  private Decoder decoder;
  private static boolean flagDecoder;
  private int flagCounter;
  private long currentDataTime;
  private long previousDataTime;
  private ServerSocket serverSocket;
  private PacketDecoder packetDecoder;
  
  public Client(Decoder decoder)
  {
    this.decoder = decoder;
    packetDecoder = new PacketDecoder(decoder);
  }
  
  public void startReceiver() {
    flagDecoder = true;
    flagCounter = 0;
    
    try
    {
      serverSocket = new ServerSocket(decoder.getReceiverPort());
      decoder.getEventListener().ClientStarted();
      flagCounter += 1;
      
      java.net.Socket clientSocket = serverSocket.accept();
      decoder.getEventListener().ClientConnected();
      flagCounter += 1;
      
      currentDataTime = System.currentTimeMillis();
      previousDataTime = currentDataTime;
      

      while ((clientSocket != null) && (flagDecoder)) {
        currentDataTime = System.currentTimeMillis();
        if (currentDataTime - previousDataTime < 6000L) {
          if (clientSocket.getInputStream().available() > 0) {
            previousDataTime = currentDataTime;
            byte[] buffer = new byte[clientSocket.getInputStream().available()];
            clientSocket.getInputStream().read(buffer);
            
            for (byte aBuffer : buffer)
            {
              packetDecoder.extract(aBuffer);
            }
          }
        }
        else
        {
          System.out.println(currentDataTime + "   " + previousDataTime);
          flagDecoder = false;
          sendError(flagCounter);
          flagCounter += 1;
        }
      }
      return;
    } catch (IOException e) {
      e.printStackTrace();
      sendError(flagCounter);
    }
    finally {
      try {
        serverSocket.close();
        decoder.getEventListener().clientClosed();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  private void sendError(int i) {
    switch (i) {
    case 0: 
      decoder.getEventListener().alreadyBind();
      break;
    case 1: 
      decoder.getEventListener().firewall();
      break;
    case 2: 
      decoder.getEventListener().connectionLost();
    }
  }
  
  public static synchronized void stopReceiver()
  {
    flagDecoder = false;
  }
}
