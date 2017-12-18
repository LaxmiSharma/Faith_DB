package in.lattice.faith_DB.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import in.lattice.faith_DB.constants.DBConstants;

@Entity
@Table(name = DBConstants.TABLE_PATIENT)
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = DBConstants.COLUMN_PATIENT_ID, updatable = false)
	private long patientId;

	@Column(name = DBConstants.COLUMN_FIRST_NAME, nullable = false)
	private String firstName;
	@Column(name = DBConstants.COLUMN_LAST_NAME)
	private String lastName;
	@Column(name = DBConstants.COLUMN_ADDRESS_1, nullable = false)
	private String address1;
	@Column(name = DBConstants.COLUMN_ADDRESS_2)
	private String address2;
	@Column(name = DBConstants.COLUMN_VILLAGE)
	private String village;
	@Column(name = DBConstants.COLUMN_CITY)
	private String city;
	@Column(name = DBConstants.COLUMN_TEHSIL)
	private String tehsil;
	@Column(name = DBConstants.COLUMN_STATE)
	private String state;
	@Column(name = DBConstants.COLUMN_PIN_CODE)
	private String pincode;
	@Column(name = DBConstants.COLUMN_AGE)
	private String age;
	@Column(name = DBConstants.COLUMN_MOBILE_NO)
	private String mobileNo;
	@Column(name = DBConstants.COLUMN_GENDER)
	private String gender;
	@Column(name = DBConstants.COLUMN_PATIENT_NOTES)
	private String patientNotes;
	@Column(name = DBConstants.COLUMN_PATIENT_UPDATED_DATE)
	private long updatedDate;
	@Column(name = DBConstants.COLUMN_PATIENT_CREATED_DATE)
	private long createdDate;
	@Column(name = DBConstants.COLUMN_UID_TYPE_ID)
	private long UIDTypeId;
	@Column(name = DBConstants.COLUMN_UID_VALUE, nullable = false)
	private String UIDValue;

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTehsil() {
		return tehsil;
	}

	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(String patientNotes) {
		this.patientNotes = patientNotes;
	}

	public long getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(long updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	public long getUIDTypeId() {
		return UIDTypeId;
	}

	public void setUIDTypeId(long uIDTypeId) {
		UIDTypeId = uIDTypeId;
	}

	public String getUIDValue() {
		return UIDValue;
	}

	public void setUIDValue(String uIDValue) {
		UIDValue = uIDValue;
	}

}
