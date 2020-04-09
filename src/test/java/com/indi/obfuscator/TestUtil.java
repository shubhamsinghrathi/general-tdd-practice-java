package com.indi.obfuscator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestUtil {

	private Util util;
	
	@BeforeEach
	public void setup() {
		util = new Util();
	}
	
	@Test
	public void getJSONObjectName() {
		JSONObject obj = new JSONObject();
		assertEquals("org.json.JSONObject", util.getInstanceName(obj));
	}
	
	@Test
	public void getArrayListName() {
		Map<String, String> obj = new LinkedHashMap<String, String>();
		assertEquals("java.util.LinkedHashMap", util.getInstanceName(obj));
	}

}
