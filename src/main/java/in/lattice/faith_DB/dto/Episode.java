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
@Table(name = DBConstants.TABLE_EPISODE_MASTER)
public class Episode {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = DBConstants.COLUMN_EPISODE_ID, updatable = false, insertable = false)
	private long episodeId;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = DBConstants.COLUMN_PATIENT_ID, nullable = false, updatable = false)
	private Patient patient;// patient_id FK

	@Column(name = DBConstants.COLUMN_EPISODE_CREATED_ON)
	private long episodeCreatedOn;
	@Column(name = DBConstants.COLUMN_ADVICE)
	private String advice;

	@Enumerated(EnumType.STRING)
	@Column(name = DBConstants.COLUMN_EPISODE_STATUS)
	private EpisodeStatus episodeStatus;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public long getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(long episodeId) {
		this.episodeId = episodeId;
	}

	public long getEpisodeCreatedOn() {
		return episodeCreatedOn;
	}

	public void setEpisodeCreatedOn(long episodeCreatedOn) {
		this.episodeCreatedOn = episodeCreatedOn;
	}

	public String getEpisodeStatus() {
		return episodeStatus.getName();
	}

	public void setEpisodeStatus(String episodeStatus) {
		this.episodeStatus = EpisodeStatus.getByName(episodeStatus);
	}

}
