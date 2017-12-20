package in.lattice.faith_DB.utils;

public class Utils {
  public Utils() {}
  
  public static String convertHexToString(String hex) {
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < hex.length() - 1; i += 2) {
      String output = hex.substring(i, i + 2);
      int decimal = Integer.parseInt(output, 16);
      sb.append((char)decimal);
    }
    
    return sb.toString();
  }
  
  public static String bytesToHex(byte[] in)
  {
    StringBuilder builder = new StringBuilder();
    for (byte b : in) {
      builder.append(String.format("%02x", new Object[] { Byte.valueOf(b) }));
    }
    return builder.toString();
  }
  
  public static byte signedByte(byte b)
  {
    return b;
  }
}
