package de.lindow_it.obiee.rtf.model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "RtfConfiguration")
/**
 * This class defines a configuration for RTF-Variables
 * 
 * @author martin@lindow-it.de
 */
public class RtfConfiguration {
	
	private static final Pattern formFieldPattern = Pattern.compile("\\$\\{([a-zA-Z0-9:]{1,})\\}");
	
	private String rtfFileName = "";
	private Map<String, String> variables = new HashMap<String, String>();

	/**
	 * @return the rtfFileName
	 */
	public String getRtfFileName() {
		return rtfFileName;
	}

	/**
	 * @param rtfFileName
	 *            the rtfFileName to set
	 */
	public void setRtfFileName(String rtfFileName) {
		this.rtfFileName = rtfFileName;
	}

	/**
	 * @return the variables
	 */
	@XmlJavaTypeAdapter(MapAdapter.class)
	@XmlElement(name="variables")
	public Map<String, String> getVariables() {
		return variables;
	}

	/**
	 * @param variables
	 *            the variables to set
	 */
	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}
	
	/**
	 * This method tries to retrieve the variable value for the given variable id. If the variable
	 * itself contains subvariables, they will be replaces as well with detected plain values.
	 * @param variableId Variable ID to detect
	 * @return value of the variable
	 * @throws Exception In case no variable found for given variableId
	 */
	public String getVariableValue(String variableId) throws Exception {
		String variableValue = variables.get( variableId);
		if(variableValue == null){
			throw new Exception(String.format("Variable '%s' not found.", variableId));
		} else {
			Matcher matcher = formFieldPattern.matcher(variableValue);
			while(matcher.find()){
				variableValue = variableValue.replace(matcher.group(0), getVariableValue(matcher.group(1)));
			}
		}
		return variableValue;
	}
}
