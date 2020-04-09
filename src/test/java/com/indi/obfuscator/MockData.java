package com.indi.obfuscator;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class MockData {

	public JSONObject simpleOrignalNoObf() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		return obj;
	}
	
	public JSONObject simpleExpectedNoObf() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		return obj;
	}
	
	public JSONObject nestedOrignalNoObf() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		
		JSONArray mobileNumbers = new JSONArray();
		mobileNumbers.put("9988776655");
		mobileNumbers.put("7766776677");
		obj.put("mobileNumbers", mobileNumbers);
		
		JSONArray addresses = new JSONArray();
		Map<String, String> add1 = new LinkedHashMap<String, String>(2);
		add1.put("pin", "123456");
		add1.put("address", "fake 1 address");
		addresses.put(add1);
		
		Map<String, String> add2 = new LinkedHashMap<String, String>(2);
		add2.put("pin", "333344");
		add2.put("address", "fake 2 address");
		addresses.put(add2);
		
		obj.put("addresses", addresses);
		
		return obj;
	}
	
	public JSONObject nestedExpectedNoObf() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		
		JSONArray mobileNumbers = new JSONArray();
		mobileNumbers.put("9988776655");
		mobileNumbers.put("7766776677");
		obj.put("mobileNumbers", mobileNumbers);
		
		JSONArray addresses = new JSONArray();
		Map<String, String> add1 = new LinkedHashMap<String, String>(2);
		add1.put("pin", "123456");
		add1.put("address", "fake 1 address");
		addresses.put(add1);
		
		Map<String, String> add2 = new LinkedHashMap<String, String>(2);
		add2.put("pin", "333344");
		add2.put("address", "fake 2 address");
		addresses.put(add2);
		
		obj.put("addresses", addresses);
		
		return obj;
	}
	
	public JSONObject simpleOrignal() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		obj.put("email", "abc@email.com");
		obj.put("password", "123456");
		return obj;
	}
	
	public JSONObject simpleExpected() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		obj.put("email", "****");
		obj.put("password", "****");
		return obj;
	}
	
	public JSONObject nestedOrignalInsaneOne() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		obj.put("email", "abc@email.com");
		obj.put("password", "123456");
		
		JSONArray mobileNumbers = new JSONArray();
		mobileNumbers.put("9988776655");
		mobileNumbers.put("7766776677");
		obj.put("mobileNumbers", mobileNumbers);
		
		JSONArray addresses = new JSONArray();
		JSONObject add1 = new JSONObject();
		add1.put("pin", "123456");
		add1.put("address", "fake 1 address");
		add1.put("email", "e1@e.com");
		addresses.put(add1);
		
		JSONObject add2 = new JSONObject();
		add2.put("pin", "333344");
		add2.put("address", "fake 2 address");
		add2.put("email", "e2@e.com");
		addresses.put(add2);
		
		obj.put("addresses", addresses);
		
		return obj;
	}
	
	public JSONObject nestedExpectedInsaneOne() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		obj.put("email", "****");
		obj.put("password", "****");
		
		JSONArray mobileNumbers = new JSONArray();
		mobileNumbers.put("9988776655");
		mobileNumbers.put("7766776677");
		obj.put("mobileNumbers", mobileNumbers);
		
		JSONArray addresses = new JSONArray();
		JSONObject add1 = new JSONObject();
		add1.put("pin", "123456");
		add1.put("address", "fake 1 address");
		add1.put("email", "****");
		addresses.put(add1);
		
		JSONObject add2 = new JSONObject();
		add2.put("pin", "333344");
		add2.put("address", "fake 2 address");
		add2.put("email", "****");
		addresses.put(add2);
		
		obj.put("addresses", addresses);
		
		return obj;
	}
	
	public JSONObject nestedOrignalInsaneTwo() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		obj.put("password", "123456");
		
		JSONArray emails = new JSONArray();
		emails.put("s1@g.com");
		emails.put("s2@g.com");
		obj.put("emails", emails);
		
		JSONArray addresses = new JSONArray();
		
		JSONObject add1 = new JSONObject();
		add1.put("pin", "123456");
		add1.put("address", "fake 1 address");
		add1.put("email", "e1@e.com");
		
		JSONObject post = new JSONObject();
		post.put("data", 1234567890);
		JSONArray passwords = new JSONArray();
		passwords.put("234");
		passwords.put("567");
		post.put("passwords", passwords);
		
		add1.put("post", post);
		
		addresses.put(add1);
		
		JSONObject add2 = new JSONObject();
		add2.put("pin", "333344");
		add2.put("address", "fake 2 address");
		add2.put("email", "e2@e.com");
		addresses.put(add2);
		
		obj.put("addresses", addresses);
		
		return obj;
	}
	
	public JSONObject nestedExpectedInsaneTwo() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Shubham Rathi");
		obj.put("age", 25);
		obj.put("password", "****");
		obj.put("emails", "****");
		
		JSONArray addresses = new JSONArray();
		
		JSONObject add1 = new JSONObject();
		add1.put("pin", "123456");
		add1.put("address", "fake 1 address");
		add1.put("email", "****");
		
		JSONObject post = new JSONObject();
		post.put("data", 1234567890);
		post.put("passwords", "****");
		
		add1.put("post", post);
		
		addresses.put(add1);
		
		JSONObject add2 = new JSONObject();
		add2.put("pin", "333344");
		add2.put("address", "fake 2 address");
		add2.put("email", "****");
		addresses.put(add2);
		
		obj.put("addresses", addresses);
		
		return obj;
	}
	
}
