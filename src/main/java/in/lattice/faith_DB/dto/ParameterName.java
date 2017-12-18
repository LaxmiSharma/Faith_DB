package in.lattice.faith_DB.dto;

import java.util.Arrays;
import java.util.List;

public enum ParameterName {
	HR("HR"), HEIGHT("Height"), WEIGHT("Weight"), SPO2("SpO2"), PULSE_RATE("Pulse rate"), TEMPERATURE(
			"Temperature"), GLUCOSE_FASTING("Glucose(Fasting)"), GLUCOSE_PP("Glucose(PP)"), GLUCOSE_RANDOM(
					"Glucose(Random)"), ARRYTHMIA("Arrythmia"), URO("URO"), PH("PH"), NIT("NIT"), BLD("BLD"), BIL(
							"BIL"), SG("SG"), KET("KET"), VC(
									"VC"), GLU("GLU"), MAL("MAL"), PRO("PRO"), CR("CR"), LEU("LEU"), UCA("UCA")// SPIROMETER
	, FVC("FVC"), FEV1("FEV1"), PEF("PEF"), FEV1_PERCENT("FEV1%"), FEF25("FEF25"), FEF2575("FEF2575"), FEF75("FEF75")// NIBP
	, NIBP("NIBP");

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	ParameterName() {

	}

	private ParameterName(String name) {
		this.name = name;
	}

	public static ParameterName getParameterNameByName(String name) {
		List<ParameterName> parameterNames = Arrays.asList(ParameterName.values());
		for (ParameterName parameterName : parameterNames) {
			if (parameterName.getName().equalsIgnoreCase(name)) {
				return parameterName;
			}
		}
		return ParameterName.HR;
	}
}
