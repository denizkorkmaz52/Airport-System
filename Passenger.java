
public class Passenger extends Person {
	private String passengerType;
	
	Passenger(String name, String surname, int age, long number, String address, String passengerType, int id){
		super(name, surname, age, number, address, id);
		this.passengerType = passengerType;
	}

	public String getPassType() {
		return passengerType;
	}

	public void setPassType(String passengerType) {
		this.passengerType = passengerType;
	}
	
	
}
