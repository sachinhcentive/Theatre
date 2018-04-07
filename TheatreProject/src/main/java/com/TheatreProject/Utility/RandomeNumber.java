package com.TheatreProject.Utility;

import java.util.Random;

public class RandomeNumber {
	
	public String RandomNumber()
	
	{
	
	Random rand = new Random();
	 String value = "Sachin2"+rand.nextInt(100);
	
	return value;
}}