
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 7

public abstract class Service implements Calculable {
	
	public int customerID;
	public abstract String ServiceType();
	public abstract double calculateService(); 
	
	public int getCustomerID(){  
		return customerID;
	}
	public void setCustomerID(int customerID) {  
		this.customerID = customerID;
	}


}
