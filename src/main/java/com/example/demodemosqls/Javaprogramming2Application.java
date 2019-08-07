package com.example.demodemosqls;

import java.io.File;
import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Javaprogramming2Application {

	public static void main(String[] args) {
		SpringApplication.run(Javaprogramming2Application.class, args);
		ImageProcessing imp = new ImageProcessing();
		try {
			imp.scaleImage(new File("C:\\Users\\u0148565\\src_image"));
			Screen s = new Screen();
			s.click("C:\\Users\\u0148565\\targetImage");
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (FindFailed e) {
			
			e.printStackTrace();
		}
	}

}
