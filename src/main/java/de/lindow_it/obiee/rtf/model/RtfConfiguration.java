package de.lindow_it.obiee.rtf.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "RtfConfiguration")
/**
 * This class defines a configuration for RTF-Variables
 * 
 * @author martin@lindow-it.de
 */
public class RtfConfiguration {
	
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
	
	

}
