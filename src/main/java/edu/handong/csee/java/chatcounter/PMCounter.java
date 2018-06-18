package edu.handong.csee.java.chatcounter;

import java.util.HashMap;
import java.util.ArrayList;
/**
 It used to setting files in fixed format
 @author LeeSangHyun
 **/

//It is for the count the number of list files
public class PMCounter {

	public HashMap<String,Integer> countMessage(ArrayList<Lists> list) {
		HashMap<String,Integer> nameAndMessage = new HashMap<String,Integer>();
		int length = list.size();


		for(int i=0 ; i<length ; i++){

			int count=0;
			Lists person = list.get(i);

			if(nameAndMessage.containsKey(person.username)) continue;
			System.out.println(person.username + count);
		}

		return nameAndMessage;

	}

}

