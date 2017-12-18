package in.lattice.faith_DB.service;

import java.util.Deque;

import in.lattice.faith_DB.dto.DBPacket;

public interface DBInsertionService {

	public  void add(DBPacket packet);
	public void insertValueInDB(Deque<DBPacket> queList);
	public void remove();
}
