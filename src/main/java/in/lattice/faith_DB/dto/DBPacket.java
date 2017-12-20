package in.lattice.faith_DB.dto;

import org.springframework.stereotype.Component;

@Component
public class DBPacket {

	private Packet packet;
	private Long episodeId;


	public Packet getPacket() {
		return packet;
	}

	public void setPacket(Packet packet) {
		this.packet = packet;
	}

	public long getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(Long episodeId) {
		this.episodeId = episodeId;
	}
}
