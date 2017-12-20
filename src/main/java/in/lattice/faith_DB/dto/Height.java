package in.lattice.faith_DB.dto;
import org.springframework.stereotype.Component;

@Component
public class Height {
  public Height() {}
  
  public float getValue() { return value; }
  
  public void setValue(float value)
  {
    this.value = (value / 10.0F);
  }
  


  private float value;
  
  public String toString()
  {
    return "Height : " + value;
  }
}
