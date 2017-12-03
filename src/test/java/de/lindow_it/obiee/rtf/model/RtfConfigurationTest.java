package de.lindow_it.obiee.rtf.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RtfConfigurationTest {

	@Test
	public void testGetVariableValue() throws Exception {
		RtfConfiguration configuration = new RtfConfiguration();
    	configuration.getVariables().put("test", "test");
    	configuration.getVariables().put("tester", "${test} + ${test}");
    	assertTrue(configuration.getVariableValue("tester").equals("test + test"));
	}
	
}
