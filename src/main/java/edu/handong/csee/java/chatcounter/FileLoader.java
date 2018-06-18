package edu.handong.csee.java.chatcounter;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 It needs to get the files from the directories. Loading Data files by thread
 @author LeeSangHyun
 **/

//it is for loading the files from the directory 
public class FileLoader {

	public ArrayList<String> getFiles(String path, String number){

		File listPathDir = getDir(path);
		File[] files = ListDir(listPathDir);
		int Thread = Integer.parseInt(number);

		ExecutorService executor = Executors.newFixedThreadPool(Thread);

		for(File f : files) {
			FileLoaderThread fileloader = new FileLoaderThread(f);
			executor.execute(fileloader);
		}
		executor.shutdown();
		return null;
	}


	private File getDir(String path) {  

		File myDirectory = new File(path);
		return myDirectory;
	}

	private File[] ListDir(File filesDir) {
		return filesDir.listFiles();
	}
}



