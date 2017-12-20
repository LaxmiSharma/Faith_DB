package in.lattice.faith_DB.dto;
import org.springframework.stereotype.Component;

@Component
public class HRData {
  private int hrValue;
  private byte arrType;
  private boolean newFlag;
  
  public HRData() {}
  
  public int getHrValue() { return hrValue; }
  
  public void setHrValue(int hrValue)
  {
    this.hrValue = hrValue;
  }
  
  public byte getArrType() {
    return arrType;
  }
  
  public void setArrType(byte arrType) {
    this.arrType = arrType;
  }
  
  public boolean isNewFlag() {
    return newFlag;
  }
  
  public void setNewFlag(boolean newFlag) {
    this.newFlag = newFlag;
  }
  


  public String toString()
  {
    return "hrValue : " + hrValue + " Arr : " + arrType + " Flag: " + newFlag;
  }
}
