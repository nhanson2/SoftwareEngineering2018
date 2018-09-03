package edu.nd.se2018.homework.hwk1;
import java.util.Hashtable;
//Author: Nathaniel Hanson
//Date: 9/3/2018
public class Question1 {
	public Question1(){}
	public int getSumWithoutDuplicates(int[] numbers){
		//Create a new hashtable to keep track of already seen items
		Hashtable<Integer,Integer> hashtable = new Hashtable<Integer,Integer>();
		int mysum = 0;
		for(int o : numbers) {
			if(!hashtable.containsKey(o)) {
				hashtable.put(o,1);
				mysum += o;
			}
		}
		return mysum;
	}
}