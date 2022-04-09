
public class PrivatePlane extends Plane{

	private int passengerCap;
	private String purposeOfUsage;
	private Person owner;
	
	PrivatePlane(String model, int passengerCap, String purposeOfUsage, Person owner, int loadCap, String loadType, int firstClassCap, int businessClassCap, int numberOfEngines, String engineType){
		super(numberOfEngines, engineType, model);
		this.passengerCap = passengerCap;
		this.purposeOfUsage = purposeOfUsage;
		this.owner = owner;
		
	}
	public int getPassengerCap() {
		return passengerCap;
	}
	public void setPassengerCap(int passengerCap) {
		this.passengerCap = passengerCap;
	}
	public String getPurposeOfUsage() {
		return purposeOfUsage;
	}
	public void setPurposeOfUsage(String purposeOfUsage) {
		this.purposeOfUsage = purposeOfUsage;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
}
