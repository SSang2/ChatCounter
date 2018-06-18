package edu.handong.csee.java.chatcounter;


import java.io.File;
import java.util.ArrayList;

/**
 * This is FileLoaderThread class
 * it used to loading the input files by using the Thread pool
 * @author LeeSangHyun
 *
 **/

public class FileLoaderThread implements Runnable{

	File files;
	ArrayList<String> messages = new ArrayList<String>();

	//This is constructor of DataReaderThread.
	public FileLoaderThread(File file) {
		this.files = file;

	}

	//run method
	public void run() {
	}

	//This is for getting content of message from the thread
	public ArrayList<String> ThreadbyContents(){
		return messages;
	}
}
