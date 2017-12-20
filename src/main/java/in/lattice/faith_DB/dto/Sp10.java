package in.lattice.faith_DB.dto;
import java.util.List;

@org.springframework.stereotype.Component
public class Sp10 {
  private int FVC;
  private int FEV1;
  private int PEF;
  private int FEF25;
  private int FEF2575;
  private int FEF75;
  private List<Sp10Point> points;
  
  public Sp10() {}
  
  public int getFVC() {
    return FVC;
  }
  
  public void setFVC(int FVC) {
    this.FVC = FVC;
  }
  
  public int getFEV1() {
    return FEV1;
  }
  
  public void setFEV1(int FEV1) {
    this.FEV1 = FEV1;
  }
  
  public int getPEF() {
    return PEF;
  }
  
  public void setPEF(int PEF) {
    this.PEF = PEF;
  }
  
  public int getFEF25() {
    return FEF25;
  }
  
  public void setFEF25(int FEF25) {
    this.FEF25 = FEF25;
  }
  
  public int getFEF2575() {
    return FEF2575;
  }
  
  public void setFEF2575(int FEF2575) {
    this.FEF2575 = FEF2575;
  }
  
  public int getFEF75() {
    return FEF75;
  }
  
  public void setFEF75(int FEF75) {
    this.FEF75 = FEF75;
  }
  
  public List<Sp10Point> getPoints() {
    return points;
  }
  
  public void setPoints(List<Sp10Point> points) {
    this.points = points;
  }
  

  public String toString()
  {
    return "FVC : " + FVC + " FEV1 : " + FEV1 + " PEF " + PEF + " FEF25 " + FEF25 + " FEF2575 " + FEF2575 + " FEF75 " + FEF75 + " Point Size " + points.size();
  }
}
