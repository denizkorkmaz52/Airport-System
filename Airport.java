
public class Airport {
	
	private int planeCap;
	private int numberOfAirfields;
	private String address;
	private Employee authorizedPerson;
	private int contactNumber;
	//Flight flights[];
	Airport(int planeCap, int numberOfAirfields, String address, Employee authorizedPerson, int contactNumber){
		this.planeCap = planeCap;
		this.numberOfAirfields = numberOfAirfields;
		this.address = address;
		this.authorizedPerson = authorizedPerson;
		this.contactNumber = contactNumber;
		//this.flights = new Flights[24];
	}

	public int getPlaneCap() {
		return planeCap;
	}

	public void setPlaneCap(int planeCap) {
		this.planeCap = planeCap;
	}

	public int getNumberOfAirfields() {
		return numberOfAirfields;
	}

	public void setNumberOfAirfields(int numberOfAirfields) {
		this.numberOfAirfields = numberOfAirfields;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee getAuthorizedPerson() {
		return authorizedPerson;
	}

	public void setAuthorizedPerson(Employee authorizedPerson) {
		this.authorizedPerson = authorizedPerson;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
}
