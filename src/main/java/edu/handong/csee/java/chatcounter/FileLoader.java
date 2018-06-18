package edu.handong.csee.java.chatcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 It needs to get the files from the directories. Loading Data.
 @author LeeSangHyun
 **/

//it is for loading the files from the directory 
public class FileLoader {


	private BufferedReader buffr;

	public ArrayList<String> getInfo(String path){

		File myDir = getDir(path);
		File[] files = getListDir(myDir);

		ArrayList<String> messages = readFiles(files);
		return messages; 
	}

	private File getDir(String path) {  

		File myDirectory = new File(path);
		return myDirectory;
	}

	private File[] getListDir(File fileDir) {

		for(File file : fileDir.listFiles()) {
			System.out.println(file.getAbsolutePath());
		}

		return fileDir.listFiles();
	}

	private ArrayList<String> readFiles(File[] file){

		ArrayList<String> messages = new ArrayList<String>();

		try {
			for(File e: file) {
				buffr = new BufferedReader(new InputStreamReader(new FileInputStream(e)));

				while(buffr.readLine()!=null) {
					String line = buffr.readLine();
					messages.add(line);
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.print(e.getMessage());
		} 
		return messages;
	}
}

