package in.lattice.faith_DB.dto;
import org.springframework.stereotype.Component;

@Component
public class Nibp { private short sys;
  private short dia;
  private short avg;
  
  public Nibp() {}
  
  public short getDia() { return dia; }
  
  public void setDia(short dia)
  {
    this.dia = dia;
  }
  
  public short getAvg() {
    return avg;
  }
  
  public void setAvg(short avg) {
    this.avg = avg;
  }
  
  public short getSys()
  {
    return sys;
  }
  
  public void setSys(short sys) {
    this.sys = sys;
  }
  


  public String toString()
  {
    return "sys : " + sys + " Dia " + dia + " avg " + avg;
  }
}
