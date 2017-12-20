package in.lattice.faith_DB.dto;
import org.springframework.stereotype.Component;

@Component
public class Sp10Point { private float fTime;
  private float fCap;
  private float fRate;
  
  public Sp10Point() {}
  
  public float getfTime() { return fTime; }
  
  public void setfTime(float fTime)
  {
    this.fTime = fTime;
  }
  
  public float getfCap() {
    return fCap;
  }
  
  public void setfCap(float fCap) {
    this.fCap = fCap;
  }
  
  public float getfRate() {
    return fRate;
  }
  
  public void setfRate(float fRate) {
    this.fRate = fRate;
  }
  
  public String toString()
  {
    return "Time " + fTime + " fCap " + fCap + " fRate " + fRate;
  }
}
