package in.lattice.faith_DB.dto;


import org.springframework.stereotype.Component;
@Component
public class EcgWave
{
  private int lead1;
  private int lead2;
  private int lead3;
  private int leadaVR;
  private int leadaVL;
  private int leadaVF;
  private int leadV1;
  
  public EcgWave() {}
  
  public int getLead1() { return lead1; }
  
  private int leadV2;
  
  public void setLead1(int lead1) { this.lead1 = lead1; }
  
  private int leadV3;
  
  public int getLead2() { return lead2; }
  
  private int leadV4;
  
  public void setLead2(int lead2) { this.lead2 = lead2; }
  
  private int leadV5;
  
  public int getLead3() { return lead3; }
  
  private int leadV6;
  
  public void setLead3(int lead3) { this.lead3 = lead3; }
  
  private int hearbeatPos;
  private int pacemakerPos;
  public int getLeadaVR() { return leadaVR; }
  
  public void setLeadaVR(int leadaVR)
  {
    this.leadaVR = leadaVR;
  }
  
  public int getLeadaVL() {
    return leadaVL;
  }
  
  public void setLeadaVL(int leadaVL) {
    this.leadaVL = leadaVL;
  }
  
  public int getLeadaVF() {
    return leadaVF;
  }
  
  public void setLeadaVF(int leadaVF) {
    this.leadaVF = leadaVF;
  }
  
  public int getLeadV1() {
    return leadV1;
  }
  
  public void setLeadV1(int leadV1) {
    this.leadV1 = leadV1;
  }
  
  public int getLeadV2() {
    return leadV2;
  }
  
  public void setLeadV2(int leadV2) {
    this.leadV2 = leadV2;
  }
  
  public int getLeadV3() {
    return leadV3;
  }
  
  public void setLeadV3(int leadV3) {
    this.leadV3 = leadV3;
  }
  
  public int getLeadV4() {
    return leadV4;
  }
  
  public void setLeadV4(int leadV4) {
    this.leadV4 = leadV4;
  }
  
  public int getLeadV5() {
    return leadV5;
  }
  
  public void setLeadV5(int leadV5) {
    this.leadV5 = leadV5;
  }
  
  public int getLeadV6() {
    return leadV6;
  }
  
  public void setLeadV6(int leadV6) {
    this.leadV6 = leadV6;
  }
  
  public int getHearbeatPos() {
    return hearbeatPos;
  }
  
  public void setHearbeatPos(int hearbeatPos) {
    this.hearbeatPos = hearbeatPos;
  }
  
  public int getPacemakerPos() {
    return pacemakerPos;
  }
  
  public void setPacemakerPos(int pacemakerPos) {
    this.pacemakerPos = pacemakerPos;
  }
}
