package in.lattice.faith_DB;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import in.lattice.faith_DB.utils.Utils;

public class Server
{
  public static ServerSocket server;
  public static ArrayList<Socket> clients = new ArrayList();
  
  public Server() {}
  
  public static void broadcast(String message) { try { for (Socket socket : clients) {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        out.println(message);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    try {
      server = new ServerSocket(8051);
      for (;;)
      {
        clients.add(server.accept());
        
        for (Socket socket : clients)
        {
          byte[] buffer = new byte[socket.getInputStream().available()];
          socket.getInputStream().read(buffer);
          

          for (int i = 0; i < buffer.length; i++) {
            System.out.print((Byte.valueOf(Byte.toString(buffer[i])).byteValue() & 0xFF) + " ");
          }
          System.out.println(" " + socket.getPort());
          
          broadcast(Utils.convertHexToString("55552707000000"));
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
