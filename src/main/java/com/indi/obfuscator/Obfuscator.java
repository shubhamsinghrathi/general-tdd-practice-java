package com.indi.obfuscator;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class Obfuscator {

	private Set<String> obfucatorKeys = new HashSet<String> ();
	
	private Util util = new Util();
	
	public void setObfuscatorKeys(Set<String> obfucatorKeys) {
		this.obfucatorKeys = obfucatorKeys;
	}
	
	public JSONObject obfuscate(JSONObject obj) {
		if (obj == null) return obj;
		
		objTraverser(obj);
		
		return obj;
	}
	
	private void objTraverser(Object obj) {
		switch (util.getInstanceName(obj)) {
			case "org.json.JSONObject":
				traverseJSONObject((JSONObject) obj);
				break;
			case "org.json.JSONArray":
				traverseJSONArray((JSONArray) obj);
				break;
		}
	}
	
	private void traverseJSONObject(JSONObject obj) {
		obj.keySet().forEach(key -> {
			if (hasKey(key)) {
				obj.put(key, "****");
			} else {
				objTraverser(obj.get(key));
			}
		});
	}
	
	private void traverseJSONArray(JSONArray arr) {
		arr.forEach(ele -> {
			objTraverser(ele);
		});
	}
	
	private boolean hasKey(String key) {
		if (obfucatorKeys.contains(key) || obfucatorKeys.contains(key + "s")) {
			return true;
		}
		return false;
	}

}
