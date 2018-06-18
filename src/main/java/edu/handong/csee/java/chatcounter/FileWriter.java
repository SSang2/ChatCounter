package edu.handong.csee.java.chatcounter;

import java.io.PrintWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
/**
 Class is for making Output result data.
 @author LeeSangHyun
 **/

//get the output file for the result
public class FileWriter {

	public void getFile(HashMap<String,Integer> nameAndMessage) {

		ArrayList<String> sortAscen = new ArrayList<String>();
		sortAscen.addAll(nameAndMessage.keySet());
		String fileName = "outputResult.csv";
		PrintWriter output = null;
		Collections.sort(sortAscen, new Comparator<Object>() {

			public int compare(Object obj1, Object obj2) {
				Object v1 = nameAndMessage.get(obj1);
				Object v2 = nameAndMessage.get(obj2);
				Comparable<Object> comparable = (Comparable<Object>) v1;
				return comparable.compareTo(v2);
			}	
		});

		try {
			output = new PrintWriter(fileName);

			for(Entry<String, Integer> in : nameAndMessage.entrySet()) {
				output.println(in.getValue());
				System.out.println(in.getValue());
			}
		} catch(FileNotFoundException e) {
			System.out.println("Error occured to open " + fileName);
			System.exit(0);
		}
		output.println("ID,count");
		
		for(int i=0; i<sortAscen.size(); i++) {
			output.println(","+nameAndMessage.get(sortAscen.get(i)));
		}
	
		output.close();
	}
} 
