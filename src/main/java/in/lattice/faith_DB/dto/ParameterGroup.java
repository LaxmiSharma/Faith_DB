package in.lattice.faith_DB.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import in.lattice.faith_DB.constants.DBConstants;

@Entity
@Table(name = DBConstants.TABLE_PARAMETER_GROUP_MASTER)
public class ParameterGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = DBConstants.COLUMN_GROUP_ID, insertable = false, updatable = false)
	private int groupId;
	@Column(name = DBConstants.COLUMN_GROUP_NAME)
	private String groupName;
	@Column(name = DBConstants.COLUMN_DESCRIPTION)
	private String description;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
