package com.example.demodemosqls;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class DemoTest {

	public static void main(String[] args) {
		Screen s = new Screen();
		try {
			s.click("");
		}catch (FindFailed e) {
			e.printStackTrace();
		}
	}
}
