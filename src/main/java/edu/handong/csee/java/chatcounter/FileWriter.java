package edu.handong.csee.java.chatcounter;

import java.io.PrintWriter;
import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;
/**
 Class is for making Output result data.
 @author LeeSangHyun
 **/

//get the output file for the result
public class FileWriter {

	public void getFile(HashMap<String,Integer> nameAndMessage) {

		String fileName = "outputResult.csv";
		PrintWriter output = null;

		try {
			output = new PrintWriter(fileName);

			for(Entry<String, Integer> in : nameAndMessage.entrySet()) {
				output.println(in.getValue());
				System.out.println(in.getValue());
			}
		} catch(FileNotFoundException e) {
			System.out.println("Error occured" + fileName);
			System.exit(0);
		}
		output.println("ID,count");
		output.close();
	}
} 
