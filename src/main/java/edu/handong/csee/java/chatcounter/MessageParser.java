package edu.handong.csee.java.chatcounter;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

/**public modifier class MessageParser
the Kakao chat lists need to be distinguish for the format of files. 
Also it has various patterns for sequences to count the numbers
so that, it needs to be declare from the patterns of the files.
in details i should check the time, username and the message contents.
Furthermore it needs to check the length and the number of strings to count the frequency.

@author LeeSangHyun**/


//it is for the parsing the message
public class MessageParser {


	ArrayList<Lists> chatingList = new ArrayList<Lists>();

	public ArrayList<Lists> MParser(ArrayList<String> messages) {

		messages = updatedMessages(messages);
		parseFile(messages);
		return chatingList;
	}

	private ArrayList<String> updatedMessages(ArrayList<String> messages) {
		int lengthOfM = messages.size();
		int i=lengthOfM-1;

		String txtpattern = "\\[(.[A-Za-z]+)\\]\\s\\[(.[A-Za-z]+)\\s([0-9]+)\\:([0-9]+)\\]\\s(.+)";
		String csvpattern ="([0-9]+)\\-([0-9]+)\\-([0-9]+)\\s([0-9]+)\\:([0-9]+)\\:..\\,\\\"(.+)\\\"\\,\\\"(.+)\\\"";

		Pattern p1 = Pattern.compile(txtpattern);
		Pattern p2 = Pattern.compile(csvpattern);

		while(i>=0) {

			String s = messages.get(i);

			if(s==null) {
				messages.remove(i);
				i--;
				continue;
			}

			Matcher m1 = p1.matcher(s);
			Matcher m2 = p2.matcher(s);

			if(!m1.find() && !m2.find()) {
				String preLine = messages.get(i-1);
				preLine = preLine.concat(s);
				messages.remove(i);
				i--;
				continue;
			}
			i--;
		}

		return messages;

	}

	private void parseFile(ArrayList<String> messages) {

		int year=0;
		int date=0;

		for(String fl : messages) {
			int count=0;
			char c = fl.charAt(0);
			if(c=='-') {

				String firstLine = fl;
				String firstpattern = "-+\\s([0-9]+).\\s([0-9]).\\s([0-9]+).";
				Pattern p1 = Pattern.compile(firstpattern);
				Matcher m1 = p1.matcher(firstLine);

				if(m1.find()) {
					year = Integer.parseInt(m1.group(1));
					date = Integer.parseInt(m1.group(2));

				}
			}
			if(c=='[') {
				parseTXT(count,fl,year,date);
				count++;
			}

			if(c=='2') {
				parseCSV(count,fl);
				count++;
			}
		}


	}

	//parsing the txt
	private void parseTXT(int count,String s,int year,int date) {

		String name="";
		String message="";
		int time;
		int hour =0;
		int minute =0;


		String pattern = "\\[(.[A-Za-z]+)\\]\\s\\[(.[A-Za-z]+)\\s([0-9]+)\\:([0-9]+)\\]\\s(.+)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(s);

		if(m.find()) {
			name = m.group(1);
			message = m.group(2);
			year = Integer.parseInt(m.group(3));
			hour = Integer.parseInt(m.group(4));
			minute = Integer.parseInt(m.group(5));
		}

		time= hour*60 + minute;
		chatingList.add(count,new Lists(name,message,year,date,time));


	}
	//parsing the CSV
	private void parseCSV(int count,String s) {

		String name="";
		String message="";
		int year=0;
		int month=0;
		int hour=0;
		int minute=0;
		int time=0;

		String line = s;
		String pattern ="([0-9]+)\\-([0-9]+)\\-([0-9]+)\\s([0-9]+)\\:([0-9]+)\\:..\\,\\\"(.+)\\\"\\,\\\"(.+)\\\"";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		if(m.find()) {
			year = Integer.parseInt(m.group(1));
			month = Integer.parseInt(m.group(2));
			hour = Integer.parseInt(m.group(3));
			minute = Integer.parseInt(m.group(4));
			name = m.group(5);
			message = m.group(6);
		}
		time=hour*60+minute;

		chatingList.add(count,new Lists(name,message,year,month,time));


	}
}
