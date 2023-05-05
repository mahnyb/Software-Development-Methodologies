
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 8

import java.util.*;  

public class CostComparator implements Comparator<Service>{

	
	@Override
	public int compare(Service o1, Service o2) {  
		
		double costo1, costo2, comparisonResult;
		
		costo1 = o1.getCost();
		costo2 = o2.getCost();
		
		comparisonResult = costo1 - costo2;
		
		if(comparisonResult > 0) {
			return 1;
		}
		else if(comparisonResult < 0){
			return -1;
		}
		else{
			return 0;
		}
		
	}
}
