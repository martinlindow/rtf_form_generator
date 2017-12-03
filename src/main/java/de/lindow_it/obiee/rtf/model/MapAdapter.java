package de.lindow_it.obiee.rtf.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MapAdapter extends XmlAdapter<RtfVariable[], Map<String, String>> {

	@Override
	public Map<String, String> unmarshal(RtfVariable[] v) throws Exception {
		Map<String, String> variableMap = new HashMap<String, String>();
		for(RtfVariable variable : v) {
			variableMap.put( variable.getId(), variable.getValue());
		}
		return variableMap;
	}

	@Override
	public RtfVariable[] marshal(Map<String, String> v) throws Exception {
		List<RtfVariable> rtfVariables = new ArrayList<RtfVariable>();
		for (Entry<String, String> entry : v.entrySet()) {
			rtfVariables.add(new RtfVariable(entry.getKey(), entry.getValue()));
		}
		return rtfVariables.toArray(new RtfVariable[v.size()]);
	}

}
