
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 9

public class Bills  implements Calculable {
	
	public String type;
	public double amount;
	public String month;
	
	public Bills(String type, double amount, String month) {
		
		this.type = type;
		this.amount = amount;
		this.month = month;
	}
	
	// getters and setters for type
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		
		this.type = type;
	}
	
	// getters and setters for month
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		
		this.month = month;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public double getCost(){
		
		return amount;
	}

}
