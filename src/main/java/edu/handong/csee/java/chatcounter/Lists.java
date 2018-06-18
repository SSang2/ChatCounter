package edu.handong.csee.java.chatcounter;
/**
 * This is Lists class
 * It has name, message, year, month, date, time members
	@author leesanghyun499
 *
 */

//the list what we have to check
public class Lists {

	String username="";
	String message="";
	int year=0;
	int month=0;
	int date=0;
	int time=0;

	public Lists(String username, String message, int year, int date, int time) {
		this.username = username;
		this.message = message;
		this.year = year;
		this.date = date;
		this.time = time;
	}
	//Lists getter
	public String getUserName() {
		return username;
	}

	public String getMessage() {
		return message;
	}

	public int getYear() {
		return year;
	}

	public int getDate() {
		return date;
	}

	public int getTime() {
		return time;
	}

	//Lists getter
	public String setUserName() {
		return username;
	}

	public String setMessage() {
		return message;
	}

	public int setYear() {
		return year;
	}

	public int setDate() {
		return date;
	}

	public int setTime() {
		return time;
	}
}