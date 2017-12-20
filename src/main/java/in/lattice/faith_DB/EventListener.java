package in.lattice.faith_DB;

import in.lattice.faith_DB.dto.Packet;

public abstract interface EventListener
{
  public abstract void ClientStarted();
  
  public abstract void ClientConnected();
  
  public abstract void alreadyBind();
  
  public abstract void firewall();
  
  public abstract void connectionLost();
  
  public abstract void transmitterError();
  
  public abstract void transmitterStarted();
  
  public abstract void newPacketFound(Packet paramPacket);
  
  public abstract void transmitSuccessfully();
  
  public abstract void transmitterClose();
  
  public abstract void clientClosed();
}
