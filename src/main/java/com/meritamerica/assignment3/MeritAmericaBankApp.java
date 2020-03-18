package com.meritamerica.assignment3;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		MeritBank.readFromFile("src/test/testMeritBank_Reuben.txt");
		System.out.println(MeritBank.writeToString());
		MeritBank.writeToFile();
	}
}