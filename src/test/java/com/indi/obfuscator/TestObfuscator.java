package com.indi.obfuscator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestObfuscator {

	private Obfuscator obfuscator;
	private MockData mockData;
	
	@BeforeEach
	public void setup() {
		obfuscator = new Obfuscator();
		mockData = new MockData();
	}
	
	@Test
	public void onPassingNull() {
		assertEquals(null, obfuscator.obfuscate(null), "expecting null");
	}
	
	@Test
	public void withoutObfuscateKeys() {
		assertTrue(mockData.simpleExpectedNoObf().similar(obfuscator.obfuscate(mockData.simpleOrignalNoObf())));
		assertTrue(mockData.nestedExpectedNoObf().similar(obfuscator.obfuscate(mockData.nestedOrignalNoObf())));
	}
	
	@Test
	public void oneLevelObject() {
		setObfuscatorKeys();
		assertTrue(mockData.simpleExpected().similar(obfuscator.obfuscate(mockData.simpleOrignal())));
	}
	
	@Test
	public void insaneLevelObjectFirst() {
		setObfuscatorKeys();
		assertTrue(mockData.nestedExpectedInsaneOne().similar(obfuscator.obfuscate(mockData.nestedOrignalInsaneOne())));
	}
	
	@Test
	public void insaneLevelObjectSecond() {
		setObfuscatorKeys();
		assertTrue(mockData.nestedExpectedInsaneTwo().similar(obfuscator.obfuscate(mockData.nestedOrignalInsaneTwo())));
	}
	
	private void setObfuscatorKeys() {
		Set<String> obfucatorKeys = new HashSet<String>(2);
		obfucatorKeys.add("emails");
		obfucatorKeys.add("passwords");
		obfuscator.setObfuscatorKeys(obfucatorKeys);
	}

}
