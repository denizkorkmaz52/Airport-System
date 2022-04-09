
public class CargoPlane extends Plane{
	private int loadCap;
	private String loadType;
	CargoPlane(String model, int loadCap, String loadType, int numberOfEngines, String engineType){
		super(numberOfEngines, engineType, model);
		this.loadCap = loadCap;
		this.loadType = loadType;		
	}
	public int getLoadCap() {
		return loadCap;
	}
	public void setLoadCap(int loadCap) {
		this.loadCap = loadCap;
	}
	public String getLoadType() {
		return loadType;
	}
	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}
	
}
