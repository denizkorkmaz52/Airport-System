
public class Plane {

	private int numberOfEngines;
	private String engineType;
	private String model;
	Plane(int numberOfEngines, String engineType, String model){
		this.numberOfEngines = numberOfEngines;
		this.engineType = engineType;				
		this.model = model;
	}

	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	public void setNumberOfEngines(int numberOfEngines) {
		this.numberOfEngines = numberOfEngines;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	
	
}
