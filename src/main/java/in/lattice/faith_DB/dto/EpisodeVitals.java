package in.lattice.faith_DB.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import in.lattice.faith_DB.constants.DBConstants;

@Entity
@Table(name = DBConstants.TABLE_EPISODE_VITALS)
public class EpisodeVitals {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = DBConstants.COLUMN_VITAL_ID, insertable = false, updatable = false)
	private long vitalId;

	@Column(name = DBConstants.COLUMN_PACKET_ID)
	private int packetId;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = DBConstants.COLUMN_EPISODE_ID)
	private Episode episode;

	@Column(name = DBConstants.COLUMN_PARAMETER_NAME)
	@Enumerated(EnumType.STRING)
	private ParameterName ParameterName;

	@Column(name = DBConstants.COLUMN_VITAL_VALUE)
	private String vitalValue;

	@Column(name = DBConstants.COLUMN_RECORDED_ON)
	private long recordedOn;

	@Column(name = DBConstants.COLUMN_IS_UPDATED)
	private boolean isUpdated;

	public int getPacketId() {
		return packetId;
	}

	public void setPacketId(int packetId) {
		this.packetId = packetId;
	}

	public long getVitalId() {
		return vitalId;
	}

	public void setVitalId(long vitalId) {
		this.vitalId = vitalId;
	}

	public Episode getEpisode() {
		return episode;
	}

	public void setEpisode(Episode episode) {
		this.episode = episode;
	}

	public ParameterName getParameterName() {
		return ParameterName;
	}

	public void setParameterName(ParameterName parameterName) {
		ParameterName = parameterName;
	}

	public String getVitalValue() {
		return vitalValue;
	}

	public void setVitalValue(String vitalValue) {
		this.vitalValue = vitalValue;
	}

	public long getRecordedOn() {
		return recordedOn;
	}

	public void setRecordedOn(long recordedOn) {
		this.recordedOn = recordedOn;
	}

	public boolean isUpdated() {
		return isUpdated;
	}

	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

}
