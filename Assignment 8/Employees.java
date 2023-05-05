
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 8

public class Employees implements Calculable{
	
	public String Name;
	public String Surname;
	public double MonthlyPayment;
	public int ID;
	
	public Employees(String Name, String Surname, double MonthlyPayment, int ID) {
		
		this.Name = Name;
		this.Surname = Surname;
		this.MonthlyPayment = MonthlyPayment;
		this.ID = ID;
	}

	// name
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		
		this.Name = Name;
	}
	
	// surname
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String Surname) {
		
		this.Surname = Surname;
	}
	
	// monthly payment
	public double getMonthlyPayment() {
		return MonthlyPayment;
	}
	public void setMonthlyPayment(double MonthlyPayment) {
		
		this.MonthlyPayment = MonthlyPayment;
	}
	
	// ID
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		
		this.ID = ID;
	}
	
	
	@Override
	public double getCost() {
		
		return MonthlyPayment;
	}
	
	
}
