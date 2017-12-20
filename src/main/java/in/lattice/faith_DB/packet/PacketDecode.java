package in.lattice.faith_DB.packet;

import java.nio.ByteBuffer;
import java.util.List;

import in.lattice.faith_DB.dto.*;


public class PacketDecode
{
  public PacketDecode() {}
  
  public static Object PackectDecode(byte[] packetBytes, int length, byte packageType)
  {
    StringBuilder sb = new StringBuilder();
    switch (packageType) {
    case 1: 
      return decodeECGWave7Lead(packetBytes, length);
    case 2: 
      return decodeECGInfo(packetBytes, length);
    case 3: 
      return decodeHR(packetBytes, length);
    case 4: 
      return decodeNIBP(packetBytes, length);
    case 7: 
      return decodeSPO2Wave(packetBytes, length);
    case 8: 
      return decodeSPO2(packetBytes, length);
    case 18: 
      return decodeVesdauscultatory(packetBytes, length);
    case 19: 
      return decodeTemp(packetBytes, length);
    
    case 20: 
      return decodeGlu(packetBytes, length);
    case 21: 
      return decodeHeight(packetBytes, length);
    case 22: 
      return decodeWeight(packetBytes, length);
    case 23: 
      return decodeECGWave12Lead(packetBytes, length);
    case 24: 
      return decodeSP10(packetBytes, length);
    }
    
    
    return null;
  }
  
  private static Object decodeECGInfo(byte[] packetBytes, int length) {
    EcgInfo ecgInfo = new EcgInfo();
    
    if (packetBytes.length == length) {
      ecgInfo.setValue(packetBytes[7], packetBytes[8]);
      System.out.println(ecgInfo.toString());
      return ecgInfo;
    }
    
    return null;
  }
  

  private static Object decodeVesdauscultatory(byte[] packetBytes, int length)
  {
    byte[] bytes = new byte[packetBytes.length - 7];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = packetBytes[(i + 7)];
    }
    return bytes;
  }
  
  private static Object decodeSP10(byte[] packetBytes, int length) {
    Sp10 sp10 = new Sp10();
    List<Sp10Point> sp10Points = new java.util.ArrayList();
    if (packetBytes.length == length) {
      byte[] shortData = new byte[4];
      shortData[2] = ((byte)(packetBytes[8] & 0xFF));
      shortData[3] = ((byte)(packetBytes[7] & 0xFF));
      sp10.setFVC(ByteBuffer.wrap(shortData).getInt());
      
      shortData = new byte[4];
      shortData[2] = ((byte)(packetBytes[10] & 0xFF));
      shortData[3] = ((byte)(packetBytes[9] & 0xFF));
      sp10.setFEV1(ByteBuffer.wrap(shortData).getInt());
      
      shortData = new byte[4];
      shortData[2] = ((byte)(packetBytes[12] & 0xFF));
      shortData[3] = ((byte)(packetBytes[11] & 0xFF));
      sp10.setPEF(ByteBuffer.wrap(shortData).getInt());
      
      shortData = new byte[4];
      shortData[2] = ((byte)(packetBytes[14] & 0xFF));
      shortData[3] = ((byte)(packetBytes[13] & 0xFF));
      sp10.setFEF25(ByteBuffer.wrap(shortData).getInt());
      
      shortData = new byte[4];
      shortData[2] = ((byte)(packetBytes[16] & 0xFF));
      shortData[3] = ((byte)(packetBytes[15] & 0xFF));
      sp10.setFEF75(ByteBuffer.wrap(shortData).getInt());
      
      shortData = new byte[4];
      shortData[2] = ((byte)(packetBytes[18] & 0xFF));
      shortData[3] = ((byte)(packetBytes[17] & 0xFF));
      sp10.setFEF2575(ByteBuffer.wrap(shortData).getInt());
      
      for (int i = 19; i < packetBytes.length; i += 12) {
        if (packetBytes.length - i >= 12) {
          Sp10Point sp10Point = new Sp10Point();
          
          shortData = new byte[4];
          shortData[3] = ((byte)(packetBytes[i] & 0xFF));
          shortData[2] = ((byte)(packetBytes[(i + 1)] & 0xFF));
          shortData[1] = ((byte)(packetBytes[(i + 2)] & 0xFF));
          shortData[0] = ((byte)(packetBytes[(i + 3)] & 0xFF));
          sp10Point.setfTime(ByteBuffer.wrap(shortData).getFloat());
          
          shortData = new byte[4];
          shortData[3] = ((byte)(packetBytes[(i + 4)] & 0xFF));
          shortData[2] = ((byte)(packetBytes[(i + 5)] & 0xFF));
          shortData[1] = ((byte)(packetBytes[(i + 6)] & 0xFF));
          shortData[0] = ((byte)(packetBytes[(i + 7)] & 0xFF));
          sp10Point.setfCap(ByteBuffer.wrap(shortData).getFloat());
          
          shortData = new byte[4];
          shortData[3] = ((byte)(packetBytes[(i + 8)] & 0xFF));
          shortData[2] = ((byte)(packetBytes[(i + 9)] & 0xFF));
          shortData[1] = ((byte)(packetBytes[(i + 10)] & 0xFF));
          shortData[0] = ((byte)(packetBytes[(i + 11)] & 0xFF));
          sp10Point.setfRate(ByteBuffer.wrap(shortData).getFloat());
          sp10Points.add(sp10Point);
        }
      }
      
      sp10.setPoints(sp10Points);
      
      return sp10;
    }
    
    return null;
  }
  
  private static Temp decodeTemp(byte[] packetBytes, int length) {
    Temp temp = new Temp();
    
    if (packetBytes.length == length) {
      byte[] shortData = new byte[4];
      shortData[2] = ((byte)(packetBytes[8] & 0xFF));
      shortData[3] = ((byte)(packetBytes[7] & 0xFF));
      temp.setValue(ByteBuffer.wrap(shortData).getInt());
      
      return temp;
    }
    
    return null;
  }
  
  private static Glucose decodeGlu(byte[] packetBytes, int length)
  {
    Glucose glucose = new Glucose();
    if (packetBytes.length == length) {
      byte[] shortData = new byte[4];
      shortData[2] = packetBytes[8];
      shortData[3] = packetBytes[7];
      glucose.setValue(ByteBuffer.wrap(shortData).getInt());
      return glucose;
    }
    
    return null;
  }
  
  private static Weight decodeWeight(byte[] packetBytes, int length) {
    Weight weight = new Weight();
    if (packetBytes.length == length) {
      byte[] shortData = new byte[4];
      shortData[2] = packetBytes[8];
      shortData[3] = packetBytes[7];
      weight.setValue(ByteBuffer.wrap(shortData).getInt());
      
      return weight;
    }
    
    return null;
  }
  
  private static Height decodeHeight(byte[] packetBytes, int length) {
    Height height = new Height();
    if (packetBytes.length == length) {
      byte[] shortData = new byte[4];
      shortData[2] = packetBytes[8];
      shortData[3] = packetBytes[7];
      height.setValue(ByteBuffer.wrap(shortData).getInt());
      
      return height;
    }
    
    return null;
  }
  
  private static Spo2 decodeSPO2(byte[] packetBytes, int length) {
    Spo2 spo2 = new Spo2();
    
    if (packetBytes.length == length) {
      byte[] shortData = new byte[2];
      shortData[0] = packetBytes[8];
      shortData[1] = packetBytes[7];
      spo2.setSpo2value(ByteBuffer.wrap(shortData).getShort());
      
      shortData = new byte[2];
      shortData[0] = packetBytes[10];
      shortData[1] = packetBytes[9];
      spo2.setPulseValue(ByteBuffer.wrap(shortData).getShort());
      System.out.println(spo2.toString());
      return spo2;
    }
    
    return null;
  }
  
  private static List<Spo2Wave> decodeSPO2Wave(byte[] packetBytes, int length) {
    List<Spo2Wave> spo2Waves = new java.util.ArrayList();
    if (packetBytes.length == length) {
      for (int i = 7; i < length - 1; i += 2)
      {
        Spo2Wave spo2Wave = new Spo2Wave();
        
        spo2Wave.setValue((byte)(packetBytes[i] & 0xFF));
        spo2Wave.setCondition(packetBytes[(i + 1)]);
        spo2Waves.add(spo2Wave);
      }
      
      return spo2Waves;
    }
    return null;
  }
  
  private static HRData decodeHR(byte[] packetBytes, int length) {
    HRData hrData = new HRData();
    
    if (packetBytes.length == length) {
      byte[] shortData = new byte[4];
      shortData[2] = packetBytes[8];
      shortData[3] = packetBytes[7];
      hrData.setHrValue(ByteBuffer.wrap(shortData).getInt());
      hrData.setArrType((byte)(packetBytes[9] & 0x3F));
      hrData.setNewFlag((packetBytes[9] >> 8 & 0x1) == 1);
      System.out.println(hrData.toString());
      return hrData;
    }
    return null;
  }
  
  private static Nibp decodeNIBP(byte[] packetBytes, int length)
  {
    Nibp nibp = new Nibp();
    
    if (packetBytes.length == length) {
      byte[] shortData = new byte[2];
      shortData[0] = packetBytes[8];
      shortData[1] = packetBytes[7];
      nibp.setSys(ByteBuffer.wrap(shortData).getShort());
      
      shortData = new byte[2];
      shortData[0] = packetBytes[10];
      shortData[1] = packetBytes[9];
      nibp.setAvg(ByteBuffer.wrap(shortData).getShort());
      
      shortData = new byte[2];
      shortData[0] = packetBytes[12];
      shortData[1] = packetBytes[11];
      nibp.setDia(ByteBuffer.wrap(shortData).getShort());
      System.out.println(nibp.toString());
      return nibp;
    }
    return null;
  }
  
  private static List<EcgWave> decodeECGWave7Lead(byte[] bytes, int length) {
    List<EcgWave> ecgWaves = new java.util.ArrayList();
    byte[] intData = new byte[4];
    if (bytes.length == length) {
      for (int i = 7; i < length - 1; i += 15)
      {
        EcgWave ecgWave = new EcgWave();
        intData[3] = bytes[i];
        intData[2] = bytes[(i + 1)];
        ecgWave.setLead1(ByteBuffer.wrap(intData).getInt());
        

        intData = new byte[4];
        intData[3] = bytes[(i + 2)];
        intData[2] = bytes[(i + 3)];
        ecgWave.setLead2(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 4)];
        intData[2] = bytes[(i + 5)];
        ecgWave.setLead3(ByteBuffer.wrap(intData).getInt());
        

        intData = new byte[4];
        intData[3] = bytes[(i + 6)];
        intData[2] = bytes[(i + 7)];
        ecgWave.setLeadaVR(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 8)];
        intData[2] = bytes[(i + 9)];
        ecgWave.setLeadaVL(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 10)];
        intData[2] = bytes[(i + 11)];
        ecgWave.setLeadaVF(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 12)];
        intData[2] = bytes[(i + 13)];
        ecgWave.setLeadV1(ByteBuffer.wrap(intData).getInt());
        
        ecgWave.setHearbeatPos(bytes[(i + 14)] & 0x1);
        ecgWave.setPacemakerPos(bytes[(i + 14)] & 0x3);
        
        ecgWaves.add(ecgWave);
      }
      return ecgWaves;
    }
    return null;
  }
  
  private static List<EcgWave> decodeECGWave12Lead(byte[] bytes, int length)
  {
    List<EcgWave> ecgWaves = new java.util.ArrayList();
    byte[] intData = new byte[4];
    if (bytes.length == length) {
      for (int i = 7; i < length - 1; i += 25)
      {
        EcgWave ecgWave = new EcgWave();
        intData[3] = bytes[i];
        intData[2] = bytes[(i + 1)];
        ecgWave.setLead1(ByteBuffer.wrap(intData).getInt());
        

        intData = new byte[4];
        intData[3] = bytes[(i + 2)];
        intData[2] = bytes[(i + 3)];
        ecgWave.setLead2(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 4)];
        intData[2] = bytes[(i + 5)];
        ecgWave.setLead3(ByteBuffer.wrap(intData).getInt());
        

        intData = new byte[4];
        intData[3] = bytes[(i + 6)];
        intData[2] = bytes[(i + 7)];
        ecgWave.setLeadaVR(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 8)];
        intData[2] = bytes[(i + 9)];
        ecgWave.setLeadaVL(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 10)];
        intData[2] = bytes[(i + 11)];
        ecgWave.setLeadaVF(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 12)];
        intData[2] = bytes[(i + 13)];
        ecgWave.setLeadV1(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 14)];
        intData[2] = bytes[(i + 15)];
        ecgWave.setLeadV2(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 16)];
        intData[2] = bytes[(i + 17)];
        ecgWave.setLeadV3(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 18)];
        intData[2] = bytes[(i + 19)];
        ecgWave.setLeadV4(ByteBuffer.wrap(intData).getInt());
        
        intData = new byte[4];
        intData[3] = bytes[(i + 20)];
        intData[2] = bytes[(i + 21)];
        ecgWave.setLeadV5(ByteBuffer.wrap(intData).getInt());
        

        intData = new byte[4];
        intData[3] = bytes[(i + 22)];
        intData[2] = bytes[(i + 23)];
        ecgWave.setLeadV6(ByteBuffer.wrap(intData).getInt());
        
        ecgWave.setHearbeatPos(bytes[(i + 24)] & 0x1);
        ecgWave.setPacemakerPos(bytes[(i + 24)] & 0x3);
        
        ecgWaves.add(ecgWave);
      }
      
      return ecgWaves;
    }
    return null;
  }
}
