
public class Company {
	private Person companyOwner;
	private int contactNumber;
	private String country;
	private int companyID;
	
	Company(Person companyOwner, int contactNumber, String country, int companyID){
		this.companyOwner = companyOwner;
		this.contactNumber = contactNumber;
		this.country = country;
		this.companyID = companyID;
	}

	public Person getCompanyOwner() {
		return companyOwner;
	}

	public void setCompanyOwner(Person companyOwner) {
		this.companyOwner = companyOwner;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	
	
}
