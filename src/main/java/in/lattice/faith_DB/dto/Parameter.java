package in.lattice.faith_DB.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lattice.faith.restapi.constants.DBConstants;

@Entity
@Table(name = DBConstants.TABLE_PARAMETER_MASTER)
public class Parameter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = DBConstants.COLUMN_PARAMETER_ID, insertable = false, updatable = false)
	private int parameterId;

	@Column(name = DBConstants.COLUMN_DESCRIPTION)
	private String description;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = DBConstants.COLUMN_GROUP_ID)
	private ParameterGroup parameterGroup;

	public int getParameterId() {
		return parameterId;
	}

	public void setParameterId(int parameterId) {
		this.parameterId = parameterId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ParameterGroup getParameterGroup() {
		return parameterGroup;
	}

	public void setParameterGroup(ParameterGroup parameterGroup) {
		this.parameterGroup = parameterGroup;
	}
}
