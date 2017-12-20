package in.lattice.faith_DB.dto;
import org.springframework.stereotype.Component;

@Component
public class Spo2Wave {
  private byte value;
  private boolean fingerError;
  private boolean pulseSign;
  private boolean pulseSearch;
  private boolean probeDrop;
  private int barChart;
  
  public Spo2Wave() {}
  
  public void setCondition(byte condition) {
    fingerError = ((condition & 0x80) == 128);
    pulseSign = ((condition & 0x40) == 64);
    pulseSearch = ((condition & 0x20) == 32);
    probeDrop = ((condition & 0x10) == 16);
    barChart = (condition & 0xF);
  }
  
  public int getBarChart() {
    return barChart;
  }
  
  public boolean isFingerError() {
    return fingerError;
  }
  
  public boolean isPulseSign() {
    return pulseSign;
  }
  
  public boolean isPulseSearch() {
    return pulseSearch;
  }
  
  public boolean isProbeDrop() {
    return probeDrop;
  }
  
  public void setValue(byte value)
  {
    this.value = value;
  }
}
