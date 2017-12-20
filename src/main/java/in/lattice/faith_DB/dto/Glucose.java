package in.lattice.faith_DB.dto;
import org.springframework.stereotype.Component;

@Component
public class Glucose { public Glucose() {}
  
  public float getValue() { return value; }
  
  public void setValue(float value)
  {
    this.value = value;
  }
  

  private float value;
  public String toString()
  {
    return "glucose : " + value;
  }
}
