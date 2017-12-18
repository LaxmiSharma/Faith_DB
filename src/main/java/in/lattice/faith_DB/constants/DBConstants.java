package in.lattice.faith_DB.constants;

public class DBConstants {
	// Table names
	public static final String TABLE_PATIENT = "faith_patient_master";
	public static final String TABLE_USER = "faith_user_master";
	public static final String TABLE_PATIENT_DATA = "faith_patient_data";
	public static final String TABLE_USER_ROLE = "faith_user_role_master";
	public static final String TABLE_EPISODE_MASTER = "faith_episode_master";
	public static final String TABLE_EPISODE_MEDICATION = "faith_episode_medication";
	public static final String TABLE_EPISODE_VITALS = "faith_episode_vitals";
	public static final String TABLE_LOCATION_MASTER = "faith_location_master";
	public static final String TABLE_MEDICATION_MASTER = "faith_medication_master";
	public static final String TABLE_PARAMETER_MASTER = "faith_parameter_master";
	public static final String TABLE_PARAMETER_GROUP_MASTER = "faith_parameter_group_master";
	public static final String TABLE_UID_TYPE_MASTER = "faith_UID_type_master";
	public static final String TABLE_MEDICATION_LOCATION_MAP = "faith_medication_location_map";

	// Table column's name
	//episode vitals
	public static final String COLUMN_PACKET_ID = "packet_id";
	
	// faith_episode_master
	public static final String COLUMN_EPISODE_ID = "episode_id";
	public static final String COLUMN_EPISODE_CREATED_ON = "episode_created_on";
	public static final String COLUMN_ADVICE = "advice";
	public static final String COLUMN_EPISODE_STATUS = "episode_status";

	// faith_episode_medication
	public static final String COLUMN_EPISODE_MEDICATION_ID = "episode_medication_id";
	public static final String COLUMN_QUANTITY = "quantity";
	public static final String COLUMN_FREQUENCY = "frequency";
	public static final String COLUMN_DURATION = "duration";

	// faith_episode_vitals
	public static final String COLUMN_VITAL_ID = "vital_id";
	public static final String COLUMN_VITAL_VALUE = "vital_value";
	public static final String COLUMN_RECORDED_ON = "recorded_on";
	// faith_location_master
	public static final String COLUMN_lOCATION_ID = "location_id";
	public static final String COLUMN_LOCATION_NAME = "location_name";
	public static final String COLUMN_IS_ACTIVE = "is_active";

	// faith_medication_master
	public static final String COLUMN_MEDICATION_ID = "medication_id";
	public static final String COLUMN_MEDICATION_NAME = "medication_name";

	// faith_parameter_master
	public static final String COLUMN_PARAMETER_ID = "parameter_id";
	public static final String COLUMN_PARAMETER_DESCRIPTION = "parameter_description";
	public static final String COLUMN_PARAMETER_NAME = "parameter_name";
	public static final String COLUMN_PARAMETER_ORDER = "parameter_order";

	// faith_parameter_group_master

	public static final String COLUMN_GROUP_ID = "group_id";
	public static final String COLUMN_GROUP_NAME = "group_name";
	public static final String COLUMN_DESCRIPTION = "group_description";

	// faith_UID_type_master
	public static final String COLUMN_UID_TYPE_ID = "uid_type_id";
	public static final String COLUMN_UID_VALUE = "uid_value";
	public static final String COLUMN_UID_TYPE_DESCRIPTION = "uid_type_description";

	// faith_medication_location_map
	public static final String COLUMN_MEDICATION_LOCATION_MAP_ID = "medication_location_map_id";

	// patient data
	public static final String COLUMN_DATA_ID = "data_id";
	public static final String COLUMN_DATA_TYPE = "data_type";
	public static final String COLUMN_DATA_NAME = "data_name";
	public static final String COLUMN_DATA_VALUE = "data_value";
	public static final String COLUMN_START_TIMESTAMP = "start_timestamp";
	public static final String COLUMN_END_TIMESTAMP = "end_timestamp";
	public static final String COLUMN_CREATED_DATE = "created_date";
	public static final String COLUMN_MID_VALUE = "mid_value";
	public static final String COLUMN_IS_UPDATED = "is_updated";

	// user role master
	public static final String COLUMN_USER_ROLE_ID = "user_role_id";
	public static final String COLUMN_USER_ROLE_DESCRIPTION = "user_role_description";
	// user master
	public static final String COLUMN_USER_ID = "user_id";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_USER_NAME = "user_name";
	public static final String COLUMN_EMAIL_ID = "email";
	// Patient
	public static final String COLUMN_PATIENT_ID = "patient_id";
	public static final String COLUMN_FIRST_NAME = "first_name";
	public static final String COLUMN_LAST_NAME = "last_name";
	public static final String COLUMN_ADDRESS_1 = "address1";
	public static final String COLUMN_ADDRESS_2 = "address2";
	public static final String COLUMN_VILLAGE = "village";
	public static final String COLUMN_CITY = "city";
	public static final String COLUMN_TEHSIL = "tehsil";
	public static final String COLUMN_STATE = "state";
	public static final String COLUMN_PIN_CODE = "pincode";
	public static final String COLUMN_AGE = "age";
	public static final String COLUMN_DOB = "dob";
	public static final String COLUMN_MOBILE_NO = "mobile_no";
	public static final String COLUMN_GENDER = "gender";
	public static final String COLUMN_PATIENT_NOTES = "patient_notes";
	public static final String COLUMN_PATIENT_UPDATED_DATE = "patient_updated_date";
	public static final String COLUMN_PATIENT_CREATED_DATE = "patient_created_date";
}
