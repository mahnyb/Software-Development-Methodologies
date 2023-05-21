
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 10

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Main {

	public static void main(String[] args) throws RoomTypeException{
		
		HotelGUI hotelGUI = new HotelGUI();  // GUI
		
		ArrayList<Calculable> HotelBook = new ArrayList<Calculable>(); 
		
		// Reservation Item
		
		HotelGUI.ReservationItem.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cityName = JOptionPane.showInputDialog("Enter City: ");
				String theHotelName = JOptionPane.showInputDialog("Enter the Hotel Name: ");
				String resMonth = JOptionPane.showInputDialog("Enter the Reservation Month: ");
				String ResStart = JOptionPane.showInputDialog("Reservation Start: ");
				String ResEnd = JOptionPane.showInputDialog("Reservation End: ");
				
				// change the types of the date inputs from String to int
				int ResStartDate = Integer.parseInt(ResStart);
				int ResEndDate = Integer.parseInt(ResEnd);
				
				HotelBook.add(new Reservation(cityName, theHotelName, resMonth, ResStartDate, ResEndDate));
			}
			
		});
		
		// Extra Services Item 
		
		HotelGUI.ExtraServicesItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String servicePrompt = JOptionPane.showInputDialog("\nPlease select one of the extra services from below:\r\n"
												+ "1. Laundry Service\r\n"
												+ "2. Spa Service\r\n");
				
				if(servicePrompt.equals("1")) {
					String guestID = JOptionPane.showInputDialog("Type the Reservation ID to credit this service: ");
					String numberOfClothes = JOptionPane.showInputDialog("How many clothes? ");
					
					// change the types of the inputs from String to int
					int guestIDno = Integer.parseInt(guestID);
					int numberOfClothesInt = Integer.parseInt(numberOfClothes);
					
					HotelBook.add(new Laundry(guestIDno, numberOfClothesInt));
				}
				
				else if(servicePrompt.equals("2")) {
					String guestID = JOptionPane.showInputDialog("Type the Reservation ID to credit this service: ");
					String numberOfDays = JOptionPane.showInputDialog("How many days? ");
					
					// change the types of the date inputs from String to int
					int guestIDno = Integer.parseInt(guestID);
					int numberOfDaysInt = Integer.parseInt(numberOfDays);
					
					HotelBook.add(new Spa(guestIDno, numberOfDaysInt));
				}
												
			}			
			
		});
		
		
		HotelGUI.DisplayReservationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				HotelGUI.textArea.setText(""); // to clear the text area
				
				for(Calculable Hotel: HotelBook) {
					if(Hotel instanceof Reservation) {
												
						HotelGUI.textArea.append(((Reservation) Hotel).displayInfo() + "\n");
										
					}
				}
				
			}
			
		});
		
		HotelGUI.DisplayExtraServicesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				HotelGUI.textArea.setText("");
				
				for(Calculable Hotel: HotelBook) {
					if(Hotel instanceof Laundry) {
						
						HotelGUI.textArea.append(((Laundry) Hotel).displayLaundryInfo() + "\n");
					}
					
					else if (Hotel instanceof Spa) {
						
						HotelGUI.textArea.append(((Spa) Hotel).displaySpaInfo() + "\n");
					}
				}
			}
			
		});
		
		HotelGUI.DisplayResForCityButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				HotelGUI.textArea.setText("");
								
				String NameOfCity = JOptionPane.showInputDialog("Enter City: ");
				HotelGUI.textArea.append("Reservations for " + NameOfCity + "\n");
				
				for(Calculable Hotel: HotelBook) {
					if(Hotel instanceof Reservation) {
						if(NameOfCity.equals(((Reservation) Hotel).getCityName())){
							
							HotelGUI.textArea.append(((Reservation) Hotel).displayInfo() + "\n");
						}
					}
				}																
				
			}
			
		});
			
	}

}
