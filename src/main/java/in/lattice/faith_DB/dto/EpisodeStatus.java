package in.lattice.faith_DB.dto;

import java.util.Arrays;
import java.util.List;

public enum EpisodeStatus {
	REGISTERED("REGISTERED"), VITALS_DONE("VITALS DONE"), RX_DONE("RX DONE"), REQUEST_MEDICINE(
			"REQUEST MEDICINE"), COMPLETED("COMPLETED");

	private String name;

	EpisodeStatus() {
	}

	private EpisodeStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static EpisodeStatus getByName(String name) {
		List<EpisodeStatus> episodeList = Arrays.asList(EpisodeStatus.values());
		for (EpisodeStatus episodeStatus : episodeList) {
			if (episodeStatus.getName().equalsIgnoreCase(name)) {
				return episodeStatus;
			}
		}
		return EpisodeStatus.REGISTERED;
	}
}
