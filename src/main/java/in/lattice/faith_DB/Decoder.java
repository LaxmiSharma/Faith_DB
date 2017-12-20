package in.lattice.faith_DB;
import in.lattice.faith_DB.client.*;
import in.lattice.faith_DB.transmitter.Transmit;
import in.lattice.faith_DB.transmitter.TransmitAction;

public class Decoder implements ClientAction, TransmitAction
{
  private int receiverPort;
  private int transmitterPort;
  private EventListener eventListener;
  private Client client;
  private Transmit transmit;
  
  private Decoder(Builder builder)
  {
    receiverPort = receiverPort;
    transmitterPort = transmitterPort;
    eventListener = eventListener;
    client = new Client(this);
    transmit = new Transmit(this);
  }
  
  public int getReceiverPort() {
    return receiverPort;
  }
  
  public int getTransmitterPort()
  {
    return transmitterPort;
  }
  
  public EventListener getEventListener() {
    return eventListener;
  }
  
  public void clientStart()
  {
    client.startReceiver();
  }
  
  public void clientStop()
  {
    Client.stopReceiver();
  }
  
  public void startTransmitter()
  {
    transmit.start();
  }
  
  public void stopTransmitter()
  {
    Transmit.stop();
  }
  
  public static final class Builder
  {
    private int receiverPort;
    private int transmitterPort;
    private EventListener eventListener;
    
    public Builder() {
      receiverPort = -1;
      transmitterPort = -1;
      eventListener = null;
    }
    
    public Builder receiverPort(int val) {
      receiverPort = val;
      return this;
    }
    
    public Builder transmitterPort(int val) {
      transmitterPort = val;
      return this;
    }
    
    public Builder eventListener(EventListener val) {
      eventListener = val;
      return this;
    }
    
    public Decoder build() {
      if (receiverPort == -1) {
        throw new RuntimeException("Please add Receiver Port");
      }
      
      if (transmitterPort == -1) {
        throw new RuntimeException("Please add Transmitter Port");
      }
      
      if (eventListener == null) {
        throw new RuntimeException("Please add EventListener");
      }
      return new Decoder(this);
    }
  }
}
