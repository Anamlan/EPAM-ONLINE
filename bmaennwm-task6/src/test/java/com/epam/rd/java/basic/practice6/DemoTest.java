package com.epam.rd.java.basic.practice6;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotNull;


public class DemoTest {

	PrintStream old = System.out;
	
	
	@Test(timeout=200)
	public void testDefaultOutput() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		Demo.main(new String[0]);
		System.out.flush();
		System.setOut(old);
	    String actual = baos.toString();
	    assertNotNull(actual);
	}
	
}
