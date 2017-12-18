package in.lattice.faith_DB.service;

import java.util.Deque;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.lattice.faith.decoder.bean.HRData;
import in.lattice.faith.decoder.bean.Nibp;
import in.lattice.faith.decoder.bean.Packet;
import in.lattice.faith_DB.constants.PacketConstant;
import in.lattice.faith_DB.dto.DBPacket;
import in.lattice.faith_DB.dto.EpisodeVitals;

@Service
public class DBInsertionServiceImpl implements DBInsertionService {

	private Deque<DBPacket> packetDeque;
	@Autowired
	private EpisodeVitalsRepository episodeVitalsRepository;

	@Override
	public synchronized void add(DBPacket packet) {
		if (packetDeque.size() == 0) {
			packetDeque = new LinkedList<DBPacket>();
		}
		packetDeque.add(packet);
		if (packetDeque.size() == 8) {
			insertValueInDB(packetDeque);
		}
	}

	@Override
	public synchronized void insertValueInDB(Deque<DBPacket> queList) {
		if (queList.size() > 0) {
			DBPacket foundPacket = queList.pollFirst();
		}
		for (DBPacket packet : queList) {
			EpisodeVitals episodeVitals = new EpisodeVitals();
			episodeVitals.setRecordedOn(packet.getPacket().getTime());
			switch (packet.getPacket().getId()) {
			case PacketConstant.HR_ID:
				HRData hrData=(HRData) packet.getPacket().getData();
				return decodeHR(packetBytes, length);
				break;
			case PacketConstant.NIBP_ID:
				Nibp nibpData=(Nibp) packet.getPacket().getData();
				episodeVitals.setPacketId(packet.getPacket().getId());
				
				return decodeNIBP(packetBytes, length);
				break;
			case PacketConstant.SPO2Wave_ID:
				break;
			case PacketConstant.SPO2_ID:
				return decodeSPO2(packetBytes, length);
				break;
			case PacketConstant.Vesd_Auscultatory_ID:
				return decodeVesdauscultatory(packetBytes, length);
				break;
			case PacketConstant.Temperature_ID:
				return decodeTemp(packetBytes, length);
				break;
			case PacketConstant.Glucose_ID:
				return decodeGlu(packetBytes, length);
				break;
			case PacketConstant.Height_ID:
				return decodeHeight(packetBytes, length);
				break;
			case PacketConstant.Weight_ID:
				return decodeWeight(packetBytes, length);
				break;
			case PacketConstant.ECGWave12Lead_ID:
				break;
			case PacketConstant.SP10_ID:
				return decodeSP10(packetBytes, length);
				break;
			}
		}
	}

	public void insertData(EpisodeVitals episodeVitals) {
		episodeVitalsRepository.save(episodeVitals);
	}

	@Override
	public synchronized void remove() {

	}

}
