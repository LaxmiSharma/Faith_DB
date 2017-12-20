package in.lattice.faith_DB.packet;

import in.lattice.faith_DB.Decoder;
import in.lattice.faith_DB.dto.Packet;
import in.lattice.faith_DB.utils.Utils;

public class PacketDecoder
{
  private byte[] packetBytes;
  private long packetLength;
  private int packetPos;
  private int i;
  private byte headerHigh;
  private byte headerLow;
  private byte packageType;
  private byte[] length;
  private int data;
  private int enterFlag;
  private Decoder decoder;
  
  public PacketDecoder(Decoder decoder)
  {
    this.decoder = decoder;
    i = 11591;
    data = 1;
    length = new byte[4];
    packetLength = -1L;
    packetPos = 2;
    enterFlag = 0;
  }
  
  public void extract(byte b)
  {
    try
    {
      if (i-- < 1) {
        if (((b == 85 ? 1 : 0) & (packetLength == -1L ? 1 : 0)) != 0) {
          enterFlag += 1;
        }
        if (enterFlag == 2) {
          if ((packetLength == -1L) && (data < 7))
          {
            switch (data) {
            case 0: 
              headerHigh = Utils.signedByte(b);
              break;
            case 1: 
              headerLow = Utils.signedByte(b);
              break;
            case 2: 
              packageType = Utils.signedByte(b);
              break;
            case 3: 
              length = new byte[4];
              length[3] = Utils.signedByte(b);
              break;
            case 4: 
              length[2] = Utils.signedByte(b);
              break;
            case 5: 
              length[1] = Utils.signedByte(b);
              break;
            case 6: 
              length[0] = Utils.signedByte(b);
              packetLength = java.nio.ByteBuffer.wrap(length).getInt();
              packetBytes = new byte[Math.toIntExact(packetLength)];
            }
            
            data += 1;
            packetPos += 1;

          }
          else if (packetPos == packetLength) {
            packetBytes[(packetPos - 1)] = Utils.signedByte(b);
            
            Object o = PacketDecode.PackectDecode(packetBytes, Math.toIntExact(packetLength), packageType);
            Packet packet = new Packet();
            packet.setData(o);
            packet.setId(packageType);
            decoder.getEventListener().newPacketFound(packet);
            
            packetLength = -1L;
            data = 1;
            packetPos = 2;
            enterFlag = 0;
          }
          else {
            packetBytes[(packetPos - 1)] = Utils.signedByte(b);
            packetPos += 1;
          }
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      packetLength = -1L;
    }
  }
}
