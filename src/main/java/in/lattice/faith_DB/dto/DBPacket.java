package in.lattice.faith_DB.dto;

import in.lattice.faith.decoder.bean.Packet;

public class DBPacket {

	private Packet packet;
	private long episodeId;
	public Packet getPacket() {
		return packet;
	}
	public void setPacket(Packet packet) {
		this.packet = packet;
	}
	public long getEpisodeId() {
		return episodeId;
	}
	public void setEpisodeId(long episodeId) {
		this.episodeId = episodeId;
	}
}
