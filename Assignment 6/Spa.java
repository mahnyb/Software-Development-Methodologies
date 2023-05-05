
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 6

public class Spa extends Service {

	int days;
	double spaCost;
	
	public Spa(int customerID, int days, double spaCost ) {
		this.customerID = customerID;
		this.days = days;
		this.spaCost = spaCost;
	}
	
	@Override
	public String ServiceType() {
		
		return "Spa";
	}

	@Override
	public double calculateService() {

		return 100 * days;
	}

}
