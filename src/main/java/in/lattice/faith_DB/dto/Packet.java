package in.lattice.faith_DB.dto;
import org.springframework.stereotype.Component;

@Component
public class Packet
{
  private int id;
  private Object data;
  private long time;
  
  public Packet() {
    time = System.currentTimeMillis();
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public Object getData() {
    return data;
  }
  
  public void setData(Object data) {
    this.data = data;
  }
  
  public long getTime() {
    return time;
  }
}
