package in.lattice.faith_DB.service;

import java.io.FileOutputStream;
import java.util.Deque;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.lattice.faith.decoder.bean.HRData;
import in.lattice.faith.decoder.bean.Height;
import in.lattice.faith.decoder.bean.Nibp;
import in.lattice.faith.decoder.bean.Sp10;
import in.lattice.faith.decoder.bean.Spo2;
import in.lattice.faith.decoder.bean.Temp;
import in.lattice.faith.decoder.bean.Weight;
import in.lattice.faith_DB.constants.PacketConstant;
import in.lattice.faith_DB.dto.DBPacket;
import in.lattice.faith_DB.dto.EpisodeVitals;
import in.lattice.faith_DB.dto.ParameterName;

@Service
public class DBInsertionServiceImpl implements DBInsertionService {

	private static Deque<DBPacket> packetDeque;
	@Autowired
	private EpisodeVitalsRepository episodeVitalsRepository;

	@Override
	public synchronized void add(DBPacket packet) {
		if (packetDeque.size() == 0) {
			packetDeque = new LinkedList<DBPacket>();
		}
		packetDeque.add(packet);
		if (packetDeque.size() > 0) {
			insertValueInDB();
		}
	}

	@Override
	public synchronized void insertValueInDB() {
		if (packetDeque.size() > 0) {
			/* DBPacket foundPacket = queList.pollFirst(); */
			for (int i = 0; i < packetDeque.size(); i++) {
				System.out.println("packet size is : " + packetDeque.size());
				DBPacket packet = packetDeque.pollFirst();
				EpisodeVitals episodeVitals = new EpisodeVitals();
				episodeVitals.setUpdated(false);
				episodeVitals.setRecordedOn(packet.getPacket().getTime());
				switch (packet.getPacket().getId()) {
				case PacketConstant.HR_ID:
					HRData hrData = (HRData) packet.getPacket().getData();
					episodeVitals.setPacketId(packet.getPacket().getId());
					episodeVitals.getEpisode().setEpisodeId(packet.getEpisodeId());
					// store hr value
					insertHrPacketValues(episodeVitals, ParameterName.HR, String.valueOf(hrData.getHrValue()));
					if (hrData.isNewFlag()) {
						insertHrPacketValues(episodeVitals, ParameterName.ARRYTHMIA,
								String.valueOf(hrData.getArrType()));
					}
					break;
				case PacketConstant.NIBP_ID:
					Nibp nibpData = (Nibp) packet.getPacket().getData();
					episodeVitals.setPacketId(packet.getPacket().getId());
					episodeVitals.getEpisode().setEpisodeId(packet.getEpisodeId());
					episodeVitals.setParameterName(ParameterName.NIBP);
					episodeVitals.setVitalValue(nibpData.getSys() + "/" + nibpData.getDia());
					insertData(episodeVitals);
					break;
				case PacketConstant.SPO2_ID:
					Spo2 spo2Data = (Spo2) packet.getPacket().getData();
					episodeVitals.setPacketId(packet.getPacket().getId());
					episodeVitals.getEpisode().setEpisodeId(packet.getEpisodeId());
					episodeVitals.setParameterName(ParameterName.SPO2);
					episodeVitals.setVitalValue(spo2Data.getSpo2value() + "/" + spo2Data.getPulseValue());
					insertData(episodeVitals);
					break;
				case PacketConstant.Vesd_Auscultatory_ID: // to store this value on server, in which format I will get
					byte[] VesdAuscData = (byte[]) packet.getPacket().getData(); // to ask sagar (".riff")
					String urlOfAudio = PacketConstant.VESD_AUSCULTATORY_FILE_PATH;
					if (VesdAuscData != null) {
						urlOfAudio = saveAudioOnLocalServer(VesdAuscData);
						episodeVitals.setPacketId(packet.getPacket().getId());
						episodeVitals.getEpisode().setEpisodeId(packet.getEpisodeId());
						episodeVitals.setParameterName(ParameterName.VESD_AUSCULTATORY_PATH);
						episodeVitals.setVitalValue(urlOfAudio);
						insertData(episodeVitals);
					}
					break;
				case PacketConstant.Temperature_ID:
					Temp tempData = (Temp) packet.getPacket().getData();
					episodeVitals.setPacketId(packet.getPacket().getId());
					episodeVitals.getEpisode().setEpisodeId(packet.getEpisodeId());
					episodeVitals.setParameterName(ParameterName.TEMPERATURE);
					episodeVitals.setVitalValue(String.valueOf(tempData.getValue()));
					insertData(episodeVitals);
					break;
				case PacketConstant.Height_ID:
					Height heightData = (Height) packet.getPacket().getData();
					episodeVitals.setPacketId(packet.getPacket().getId());
					episodeVitals.getEpisode().setEpisodeId(packet.getEpisodeId());
					episodeVitals.setParameterName(ParameterName.HEIGHT);
					episodeVitals.setVitalValue(String.valueOf(heightData.getValue()));
					insertData(episodeVitals);
					break;
				case PacketConstant.Weight_ID:
					Weight weightData = (Weight) packet.getPacket().getData();
					episodeVitals.setPacketId(packet.getPacket().getId());
					episodeVitals.getEpisode().setEpisodeId(packet.getEpisodeId());
					episodeVitals.setParameterName(ParameterName.WEIGHT);
					episodeVitals.setVitalValue(String.valueOf(weightData.getValue()));
					insertData(episodeVitals);
					break;
				case PacketConstant.SP10_ID:
					Sp10 sp10Data = (Sp10) packet.getPacket().getData();
					float fev1_percent = (sp10Data.getFEV1() / sp10Data.getFVC()) * 100;
					// call insert function 8 times to insert all values
					episodeVitals.setPacketId(packet.getPacket().getId());
					episodeVitals.getEpisode().setEpisodeId(packet.getEpisodeId());
					insertSp10Values(episodeVitals, ParameterName.FVC, String.valueOf(sp10Data.getFVC()));
					insertSp10Values(episodeVitals, ParameterName.FEV1, String.valueOf(sp10Data.getFEV1()));
					insertSp10Values(episodeVitals, ParameterName.PEF, String.valueOf(sp10Data.getPEF()));
					insertSp10Values(episodeVitals, ParameterName.FEF25, String.valueOf(sp10Data.getFEF25()));
					insertSp10Values(episodeVitals, ParameterName.FEF2575, String.valueOf(sp10Data.getFEF2575()));
					insertSp10Values(episodeVitals, ParameterName.FEF75, String.valueOf(sp10Data.getFEF75()));
					insertSp10Values(episodeVitals, ParameterName.FEV1_PERCENT, String.valueOf(fev1_percent));
					insertSp10Values(episodeVitals, ParameterName.SPIROMETER_WAVE_DATA,
							String.valueOf(sp10Data.getPoints()));
					break;
				}
			}
		}
	}

	public String saveAudioOnLocalServer(byte[] bytes) {
		// sample code System.IO.File.WriteAllBytes("yourfilepath.wav", bytes);
		try {
			FileOutputStream foStream = new FileOutputStream(PacketConstant.VESD_AUSCULTATORY_FILE_PATH);
			foStream.write(bytes);
			foStream.flush();
			foStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return PacketConstant.VESD_AUSCULTATORY_FILE_PATH;
	}

	public synchronized void insertHrPacketValues(EpisodeVitals episodeVitals, ParameterName selectedParam,
			String vitalValue) {
		episodeVitals.setParameterName(selectedParam);
		episodeVitals.setVitalValue(vitalValue);
		insertData(episodeVitals);
	}

	public synchronized void insertSp10Values(EpisodeVitals episodeVitals, ParameterName selectedParam,
			String vitalValue) {
		episodeVitals.setParameterName(selectedParam);
		episodeVitals.setVitalValue(vitalValue);
		insertData(episodeVitals);
	}

	public synchronized void insertData(EpisodeVitals episodeVitals) {
		episodeVitalsRepository.save(episodeVitals);
	}

	@Override
	public synchronized void remove() {

	}

}
