
public class Employee extends Person {
	private String title;
	Employee(String name, String surname, int age, long number, String address, String title, int id){
		super(name, surname, age, number, address, id);
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String employeeInfo() {
		return getId() +" "+getName()+" "+getSurname()+" "+ getAge()   +" "+ getNumber()+" "+ getAddress()   +" "+  getTitle();   
	}
	
}
