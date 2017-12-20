package in.lattice.faith_DB.dto;


import org.springframework.stereotype.Component;

@Component
public class EcgInfo { private boolean LA;
  private boolean RA;
  private boolean LL;
  private boolean RL;
  private boolean V1;
  private boolean V2;
  private boolean V3;
  private boolean V4;
  private boolean V5;
  private boolean V6;
  
  public EcgInfo() {}
  
  public void setValue(byte b1, byte b2) { LA = ((b1 & 0x1) == 1);
    RA = ((b1 & 0x2) == 2);
    LL = ((b1 & 0x4) == 4);
    RL = ((b1 & 0x8) == 8);
    V1 = ((b1 & 0x10) == 16);
    V2 = ((b1 & 0x20) == 32);
    V3 = ((b1 & 0x40) == 64);
    V4 = ((b1 & 0x80) == 128);
    V5 = ((b2 & 0x1) == 1);
    V6 = ((b2 & 0x2) == 2);
  }
  
  public boolean isLA() {
    return LA;
  }
  
  public boolean isRA() {
    return RA;
  }
  
  public boolean isLL() {
    return LL;
  }
  
  public boolean isRL() {
    return RL;
  }
  
  public boolean isV1() {
    return V1;
  }
  
  public boolean isV2() {
    return V2;
  }
  
  public boolean isV3() {
    return V3;
  }
  
  public boolean isV4() {
    return V4;
  }
  
  public boolean isV5() {
    return V5;
  }
  
  public boolean isV6() {
    return V6;
  }
  
  public String toString()
  {
    return "LA " + LA + " RA " + RA + " LL " + LL + " RL " + RL + " V1 " + V1 + " V2 " + V2 + " V3 " + V3 + " V4 " + V4 + " V5 " + V5 + " V6 " + V6;
  }
}
