
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 9

public abstract class Service implements Calculable {
	
	public int customerID;
	public abstract String getServiceType();
	public abstract double calculateService(); 
	
	public int getCustomerID(){  
		return customerID;
	}
	public void setCustomerID(int customerID) {  
		this.customerID = customerID;
	}
	
	public void displayServiceInfo(){
		
		System.out.printf("Customer ID: %d, Service Type: %s, Cost: %.2f\n", getCustomerID(), getServiceType(), calculateService());
	}


}
