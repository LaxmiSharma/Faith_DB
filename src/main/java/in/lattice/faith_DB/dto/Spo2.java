package in.lattice.faith_DB.dto;
import org.springframework.stereotype.Component;

@Component
public class Spo2 { private int spo2value;
  private int pulseValue;
  
  public Spo2() {}
  
  public int getPulseValue() { return pulseValue; }
  
  public void setPulseValue(int pulseValue)
  {
    this.pulseValue = pulseValue;
  }
  
  public int getSpo2value()
  {
    return spo2value;
  }
  
  public void setSpo2value(int spo2value) {
    this.spo2value = spo2value;
  }
  


  public String toString()
  {
    return "spo2 : " + spo2value + " pulse " + pulseValue;
  }
}
