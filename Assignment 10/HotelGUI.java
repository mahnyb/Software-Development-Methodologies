
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 10

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelGUI extends JFrame{
	
	public static JTextArea textArea;
	public static  JPanel textPanel;
	public static JButton DisplayReservationButton;
	public static JButton DisplayExtraServicesButton;
	public static JButton DisplayResForCityButton;
	public static JMenuBar MenuBar;
	public static JMenu FileMenu;
	public static JMenu NewMenu;
	public static JMenu HelpMenu;
	public static JMenuItem ReservationItem;
	public static JMenuItem ExtraServicesItem;
	public static JMenuItem Contents;
	public static JMenuItem About;
	public static JMenuItem ExitProgram;
	
	HotelGUI(){
		
		
		// text area		
		textArea = new JTextArea();
		textArea.setRows(24);
		textArea.setColumns(45);
		textArea.setEditable(false);		
							
		// Panel	
		textPanel = new JPanel(); // for the texts
		textPanel.setBackground(Color.white);
		textPanel.add(textArea);
		
		
		// Buttons
		DisplayReservationButton = new JButton();
		DisplayReservationButton.setText("Display Reservations");
		DisplayReservationButton.setFocusable(false);
		
		
		DisplayExtraServicesButton = new JButton();
		DisplayExtraServicesButton.setText("Display Extra Services");
		DisplayExtraServicesButton.setFocusable(false);
		
		DisplayResForCityButton = new JButton();
		DisplayResForCityButton.setText("Display Res. For City");
		DisplayResForCityButton.setFocusable(false);
		
				
		
		// create the menu bar
		MenuBar = new JMenuBar();
		
		// creates the File, New, and Help options and add to the MenuBar
				
		FileMenu = new JMenu("File"); // File Menu
		MenuBar.add(FileMenu);	// add the File option to the MenuBar
				
		NewMenu = new JMenu("New"); // New Menu
		MenuBar.add(NewMenu);	// add the File option to the MenuBar		
		
		HelpMenu = new JMenu("Help"); // Help Menu
		MenuBar.add(HelpMenu);  // add the Help option to the MenuBar
		
		
		// New Menu: Reservation and Extra Services
		ReservationItem = new JMenuItem("Reservation"); // create Reservation menu item and add it to the New Menu
		NewMenu.add(ReservationItem);

		ExtraServicesItem = new JMenuItem("Extra Services"); // create Extra Services menu item and add it to the New Menu
		NewMenu.add(ExtraServicesItem);
		
		
		// Help Menu: Contents and About 
		
		Contents = new JMenuItem("Contents"); // create Content menu item and add it to the Help Menu
		HelpMenu.add(Contents);
		
		Contents.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "INSTRUCTION MANUAL: \r\n"
						+ "Use New to create new reservations or add extra services to your credit\r\n"
						+ "Use the Display Reservation Button to display the reservations\r\n"
						+ "Use the Display Extra Services Button to display the extra services\r\n");
			}
			
		});
		
		
		About = new JMenuItem("About"); 		// create About menu item and add it to the Help Menu
		HelpMenu.add(About);
		
		About.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "\nAbout the Developer:\r\n"
						+ "Mahny Barazandehtar\r\n"
						+ "Student ID: 20210702004\r\n"
						+ "CSE 212 - Secion 1\r\n"
						+ "Assignment 10\r\n");
			}
			
		});
		
		
		ExitProgram = new JMenuItem("Exit");
		FileMenu.add(ExitProgram);
		
		ExitProgram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
			
		});
		
							
		
		this.setTitle("Hotel Reservation System"); // to set the title of the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of the application after pressing the red X button
		this.setLayout(new FlowLayout());
		this.setSize(500, 500); // sets the x and y dimensions of the frame
		this.getContentPane().setBackground(Color.lightGray);
		this.setJMenuBar(MenuBar);
		this.setVisible(true); // sets the visibility of the frame to true
		this.add(DisplayReservationButton);
		this.add(DisplayExtraServicesButton);
		this.add(DisplayResForCityButton);
		this.add(textPanel);
		
	}




}
