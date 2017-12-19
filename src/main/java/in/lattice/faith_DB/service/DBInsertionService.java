package in.lattice.faith_DB.service;


import in.lattice.faith_DB.dto.DBPacket;

public interface DBInsertionService {

	public  void add(DBPacket packet);
	public void insertValueInDB();
	public void remove();
}
