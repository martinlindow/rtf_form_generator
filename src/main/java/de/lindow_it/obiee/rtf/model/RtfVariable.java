package de.lindow_it.obiee.rtf.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RtfVariable")
public class RtfVariable {
	
	private String id;
	private String value;
	
	/**
	 * Default constructor
	 */
	public RtfVariable() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor to create a new variable with specified id and value
	 * @param id
	 * @param value
	 */
	public RtfVariable(String id, String value) {
		setId(id);
		setValue(value);
	}
	
	/**
	 * @return the id
	 */
	@XmlAttribute
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the value
	 */
	@XmlAttribute
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
