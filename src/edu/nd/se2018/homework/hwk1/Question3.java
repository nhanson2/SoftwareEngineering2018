package edu.nd.se2018.homework.hwk1;
//Author: Nathaniel Hanson
//Date: 9/3/2018
public class Question3 {
	public Question3(){}	
    public int getMirrorCount(int[] numbers){
    	int offset = 0, maxCount = 0, i=0, j=numbers.length-1, numLength=numbers.length;
    	boolean interrupt = false;
    	boolean started = false;
    	// Start iterating through the array, forwards and backwards
    	while(i<numLength && j>-1 && i<=j) {
    		//Check for gaps in the mirrored sequence
    		if(i==j && interrupt) {
    		} else if(numbers[i]==numbers[j]) {
    			if(!started) { started = true; }
    			maxCount ++;
    		} else if(started && !interrupt) { interrupt=true; }
    		i++;
    		j--;
    	}
    	// Even case to match logic
    	if((numLength%2)==0 && maxCount==numLength/2) {
    		return maxCount*2;
    	// Odd case to match logic
    	}else if((numLength%2)==1 && maxCount==numLength/2+1) {
    		return numLength;
    	// Always one item in a mirrored sequence
    	}else if(maxCount == 0) {
    		return 1;
    	}
    	return maxCount;
	}
}