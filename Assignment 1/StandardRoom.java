// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 1

package assigments1;
import java.util.Scanner;

public class StandardRoom{
	
	static int Rooms[][] = new int[100][3]; // 100 rooms, 3 variables for each (0: id, 1: price, 2: personCount)
	/*
	int id; // the number of rooms
	int price; // per person
	int personCount;
	*/
	public static int i = 0;
	public void createRoom(int countIn, int priceIn){
		Rooms[i][0] = i + 1; // equals to id
		Rooms[i][1] = priceIn;
		Rooms[i][2] = countIn;
		i++;
		System.out.printf("Room %d created.\n", i);
	}
	
	
	public int calculatePrice(int n){
		
		int total = Rooms[n][1] * Rooms[n][2];
		return total;
		
	}
	
	public void displayInfo(){
		
		for(int j = 0; j < i; j++){
			
			int roomID = Rooms[j][0];
			int personCount = Rooms[j][2];
			int totalPrice = calculatePrice(j);
			System.out.printf("Room #%d has %d people with a total price of %d$. \n", roomID, personCount, totalPrice);
			
		}
	}
	
	
}
