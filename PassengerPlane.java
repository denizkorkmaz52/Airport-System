
public class PassengerPlane extends Plane{
	private int firstClassCap;
	private int businessClassCap;
	private int economyClassCap;
	PassengerPlane(String model,int economyClassCap, int firstClassCap, int businessClassCap, int numberOfEngines, String engineType){
		super(numberOfEngines, engineType, model);
		this.firstClassCap = firstClassCap;
		this.businessClassCap = businessClassCap;
		this.economyClassCap = economyClassCap;
	}
	public int getFirstClassCap() {
		return firstClassCap;
	}
	public void setFirstClassCap(int firstClassCap) {
		this.firstClassCap = firstClassCap;
	}
	public int getBusinessClassCap() {
		return businessClassCap;
	}
	public void setBusinessClassCap(int businessClassCap) {
		this.businessClassCap = businessClassCap;
	}
	public int getEconomyClassCap() {
		return economyClassCap;
	}
	public void setEconomyClassCap(int economyClassCap) {
		this.economyClassCap = economyClassCap;
	}
	
}
