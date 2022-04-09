import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Database {
	int ticketNumber = 0;
	int flightNumber = 0;
	int passengerId= 0;
	int employeeId = 0;
	
	private DefaultListModel passengerModel = new DefaultListModel();
	private DefaultListModel flightModel = new DefaultListModel();
	private DefaultListModel employeeModel = new DefaultListModel();
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>(); // Create an ArrayList object
	private ArrayList<Flight> flights = new ArrayList<Flight>();
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>(); // Create an ArrayList object
	public ArrayList<PassengerPlane> passengerPlanes = new ArrayList<PassengerPlane>(); // Create an ArrayList object
	private ArrayList<Employee> employees = new ArrayList<Employee>(); // Create an ArrayList object
	
	public Database() {
		//tickets.add(new Ticket(approved, price, seatNumber, ticketNumber, passenger, travelType);
		//string başında sonunda boşlukları ignore eden fonksiyon var;
		
		flights.add(new Flight(1, "İzmir", "İstanbul", new Time(13, 30), new Date(10, 05, 2021), "Private"));
		flights.add(new Flight(2, "İzmir", "Münih", new Time(14, 30), new Date(10, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(3, "İzmir", "Ankara", new Time(15, 00), new Date(10, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(4, "Ankara", "İzmir", new Time(16, 00), new Date(10, 05, 2021), "Cargo"));
		flights.add(new Flight(5, "Antalya", "İzmir", new Time(13, 30), new Date(10, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(6, "İzmir", "Antalya", new Time(14, 30), new Date(10, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(7, "İzmir", "Ankara", new Time(15, 00), new Date(10, 05, 2021), "Private"));
		flights.add(new Flight(8, "Londra", "İzmir", new Time(16, 00), new Date(10, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(9, "İstanbul", "İzmir", new Time(13, 30), new Date(10, 05, 2021), "Cargo"));
		flights.add(new Flight(10, "İzmir", "Londra", new Time(14, 30), new Date(10, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(11, "Paris", "İzmir", new Time(15, 00), new Date(10, 05, 2021), "Private"));
		flights.add(new Flight(12, "Ankara", "İzmir", new Time(16, 00), new Date(10, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(13, "Ankara", "İzmir", new Time(15, 30), new Date(10, 05, 2021), "Cargo"));
		flights.add(new Flight(14, "Londra", "İzmir", new Time(13, 30), new Date(11, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(15, "İzmir", "Paris", new Time(14, 30), new Date(11, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(16, "Ankara", "İzmir", new Time(15, 00), new Date(11, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(17, "Paris", "İzmir", new Time(16, 00), new Date(11, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(18, "Münih", "İzmir", new Time(13, 30), new Date(11, 05, 2021), "Private"));
		flights.add(new Flight(19, "İzmir", "Antalya", new Time(14, 30), new Date(11, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(20, "Antalya", "İzmir", new Time(15, 00), new Date(11, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(21, "İzmir", "Paris", new Time(16, 00), new Date(11, 05, 2021), "Cargo"));
		flights.add(new Flight(22, "Londra", "İzmir", new Time(13, 30), new Date(11, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(23, "İzmir", "Paris", new Time(14, 30), new Date(11, 05, 2021), "Private"));
		flights.add(new Flight(24, "İzmir", "Lüksemburg", new Time(15, 00), new Date(11, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(25, "İzmir", "Kampala", new Time(16, 00), new Date(11, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(26, "Kampala", "İzmir", new Time(13, 30), new Date(12, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(27, "Moskova", "İzmir", new Time(14, 30), new Date(12, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(28, "Moskova", "İzmir", new Time(15, 00), new Date(12, 05, 2021), "Private"));
		flights.add(new Flight(29, "İzmir", "İstanbul", new Time(16, 00), new Date(12, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(30, "İzmir", "Londra", new Time(13, 30), new Date(12, 05, 2021), "Cargo"));
		flights.add(new Flight(31, "Pekin", "İzmir", new Time(14, 30), new Date(12, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(32, "Wuhan", "İzmir", new Time(15, 00), new Date(12, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(33, "İzmir", "Antalya", new Time(16, 00), new Date(12, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(34, "Stuttgart", "İzmir", new Time(13, 30), new Date(12, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(35, "İzmir", "Stuttgart", new Time(14, 30), new Date(12, 05, 2021), "Cargo"));
		flights.add(new Flight(36, "İzmir", "Berlin", new Time(15, 00), new Date(12, 05, 2021), "Private"));
		flights.add(new Flight(37, "Kiev", "İzmir", new Time(16, 00), new Date(12, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(38, "İzmir", "Kiev", new Time(13, 30), new Date(13, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(39, "İzmir", "Kharkiv", new Time(14, 30), new Date(13, 05, 2021), "Cargo"));
		flights.add(new Flight(40, "New York", "İzmir", new Time(15, 00), new Date(13, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(41, "İzmir", "Los Angeles", new Time(16, 00), new Date(13, 05, 2021), "Passenger","Airbus"));
		flights.add(new Flight(42, "İzmir", "Teksas", new Time(13, 30), new Date(13, 05, 2021), "Private"));
		
/////////////////////////////////
		
		
		
		passengerPlanes.add(new PassengerPlane("Airbus", 20, 10, 6, 4, "jet"));
		passengerPlanes.add(new PassengerPlane("Boeing", 10, 2, 2, 2, "jet"));
		passengerPlanes.add(new PassengerPlane("Fokker", 30, 8, 6, 4, "jet"));
	
		passengers.add(new Passenger("Deniz","Korkmaz", 21 ,12345678901L ,"Ordu", "first" ,0));
		passengers.add(new Passenger("Tunahan", "Akdoğan", 31, 12345678902L, "İzmir" , "economy" , 1));
		passengers.add(new Passenger("Batuhan", "Şahin", 20 ,12345678903L, "Çanakkale" ,"business", 2));
		passengers.add(new Passenger("John",  "Cena" ,38, 12345678904L, "California" ,"first" ,3));
		passengers.add(new Passenger("Rey" ,"Misterio", 37, 12345678905L, "Kahramanmaraş", "economy" ,4));
		passengers.add(new Passenger("Ajdar", "Anık", 42, 12345678906L, "İstanbul" ,"economy" ,5));
		passengers.add(new Passenger("Erol", "Büyükburç" ,57 ,12345678907L, "İstanbul" ,"business", 6));
		passengers.add(new Passenger("Maraz", "Ali", 40, 12345678908L, "Denizli", "economy", 7));
		passengers.add(new Passenger("Yavuz", "Başkomiser", 45, 12345678909L, "Adana", "business", 8));
		passengers.add(new Passenger("Bezbebek", "Nana", 18, 12345678909L, "Konya", "first", 9));
		passengers.add(new Passenger("Şahin", "Deniz", 41, 12345678909L, "Artvin", "economy", 10));	
		passengers.add(new Passenger("Büyük", "Troll", 1000, 31234567892L, "Alpler", "economy", 11));
		passengers.add(new Passenger("Ahmet", "Acar", 78, 21234567898L, "Antalya", "business", 12));
		passengers.add(new Passenger("Fatma", "Çakmak", 17, 11234567895L, "Samsun", "economy", 13));
		passengers.add(new Passenger("Ayşegül", "Taşar", 30, 21234567894L, "Yalova", "first", 14));
		passengers.add(new Passenger("Busenur", "Tuna", 22, 11234567896L, "İzmir", "business", 15));		
		passengers.add(new Passenger("Koray", "Avcı", 38, 21234567897L, "Aydın", "business", 16));
		passengers.add(new Passenger("Buray", "Kıbrıslı", 27, 11234567898L, "Kıbrıs", "economy", 17));
		passengers.add(new Passenger("Sedef", "Çolak", 20, 41234567899L, "Ankara", "economy", 18));
		passengers.add(new Passenger("Under", "Taker", 101, 11234567890L, "Ankara", "economy", 19));
		passengers.add(new Passenger("Selana", "Gomez", 29, 11234567891L, "Philedelphia", "first", 20));
		passengers.add(new Passenger("Taylor", "Swift", 29, 11234567892L, "New York", "first", 21));
		passengers.add(new Passenger("Oğuzhan", "Koç", 33, 11234567894L, "İstanbul", "business", 22));
		passengers.add(new Passenger("Murat", "Boz", 30, 11234567895L, "Zonguldak", "first", 23));
		passengers.add(	new Passenger("Jhonny", "Depp", 51, 11234567896L, "Hakkari", "economy", 24));
		passengers.add(new Passenger("İbrahim", "Acıses", 26, 11234567897L, "Şanlıurfa", "economy", 25));
		passengers.add(new Passenger("Furkan", "Pekyakın", 25, 11234567898L, "Trabzon", "business", 26));
		passengers.add(new Passenger("Dua", "Lipa", 25, 11234567893L, "Diyarbakır", "economy", 27));
		passengers.add(new Passenger("İzzet", "Yanık", 21, 11234567899L, "Batman", "business", 28));
		passengers.add(new Passenger("Berat", "Damat", 31, 21234567890L, "Karaman", "first", 29));

		
		employees.add(new Employee("Pilot","Pilotoğlu",42,5053332255L,"Muğla","Pilot",1));
		employees.add(new Employee("Hande","Kara",30,5056334233L,"Ankara","Hostess",2));
		employees.add(new Employee("Metin","Tekin",32,5053431265L,"Kars","Hostess",3));
		employees.add(new Employee("Mert","Sert",36,5053332185L,"Muğla","Hostess",4));
		employees.add(new Employee("Halil","Yardımcı",36,5063435257L,"İzmir","CoPilot",5));
		employees.add(new Employee("Merve","Tek",34,5054352785L,"Bursa","Hostess",6));
		employees.add(new Employee("Selin","Bakır",26,5751335245L,"Ordu","Hostess",7));
		employees.add(new Employee("Melih","Uçan",42,5053432156L,"Muş","Pilot",8));
		employees.add(new Employee("Kadir","Kopilot",43,5053736255L,"Antalya","CoPilot",9));
		employees.add(new Employee("Mehmet","Kaplan",35,5052636255L,"Denizli","Hostess",10));
		employees.add(new Employee("İrfan","Yarasa",46,5352636255L,"İzmir","Hostess",11));
		employees.add(new Employee("Şenol","Güneş",50,5052536455L,"Trabzon","Hostess",12));
		employees.add(new Employee("Çağlardan","Çağlara",35,5052636255L,"Kilis","Hostess",13));
		employees.add(new Employee("Şahin","Beşvites",33,5052247255L,"Aydın","Hostess",14));
		employees.add(new Employee("Turgut","Boral",38,5052346158L,"Mersin","Hostess",15));
		employees.add(new Employee("Tolga","Terlik",32,5052635255L,"Denizli","Hostess",16));
		employees.add(new Employee("Vecihi","Hürkuş",42,5062432783L,"Tokat","Pilot",17));
		employees.add(new Employee("Çelik","Yerlerde",30,5072421763L,"İstanbul","CoPilot",18));
		employees.add(new Employee("Burhan","Turhan",32,5062432783L,"Mardin","Hostess",19));
		employees.add(new Employee("Sabri","Sarıoğlu",55,5062422186L,"Yalova","Hostess",20));
		employees.add(new Employee("Dursun","Durmaz",46,5062532783L,"Mardin","Hostess",21));
		employees.add(new Employee("Hande","Yener",50,5062432783L,"Ankara","Hostess",22));
		employees.add(new Employee("Aleyna","Tilki",27,5052132683L,"Antalya","Hostess",23));
		employees.add(new Employee("İbrahim","Tatlıses",44,5064433785L,"Urfa","Hostess",24));
		employees.add(new Employee("Selahattin","Özdemir",42,5042537743L,"Maraş","Pilot",25));
		employees.add(new Employee("Cengiz","Kurtoğlu",52,5042537743L,"Konya","CoPilot",26));
		employees.add(new Employee("Ümit","Besen",46,5062532783L,"Aksaray","Hostess",27));
		employees.add(new Employee("Hamit","Altıntop",40,5032552683L,"Van","Hostess",28));
		employees.add(new Employee("Ercan","Ahmetler",36,5062532783L,"Tokat","Hostess",29));
		employees.add(new Employee("Ajda","Pekkan",21,5052432673L,"Sivas","Hostess",30));
		employees.add(new Employee("Sertab","Erener",36,5022552788L,"Niğde","Hostess",31));
		employees.add(new Employee("Tarkan","Tevetoğlu",46,5032522573L,"Bolu","Hostess",32));
		employees.add(new Employee("Cem","Karaca",43,5042532583L,"İstanbul","Hostess",33));
/*
		tickets.add(new Ticket(100,6,1,passengers.get(0),1));
		tickets.add(new Ticket(200,15,2,passengers.get(1),1));
		tickets.add(new Ticket(300,2,3,passengers.get(2),1));
		tickets.add(new Ticket(150,35,4,passengers.get(3),1));
		tickets.add(new Ticket(300,4,5,passengers.get(4),1));
		tickets.add(new Ticket(150,32,6,passengers.get(5),1));
		tickets.add(new Ticket(250,24,7,passengers.get(6),1));
		tickets.add(new Ticket(300,8,8,passengers.get(7),1));
		tickets.add(new Ticket(400,5,9,passengers.get(8),1));
		tickets.add(new Ticket(200,15,10,passengers.get(9),1));
		tickets.add(new Ticket(300,6,11,passengers.get(10),1));
		tickets.add(new Ticket(100,38,12,passengers.get(11),1));
		tickets.add(new Ticket(100,37,13,passengers.get(12),1));
		tickets.add(new Ticket(100,31,14,passengers.get(13),1));
		tickets.add(new Ticket(200,16,15,passengers.get(14),1));
		tickets.add(new Ticket(200,14,16,passengers.get(15),1));
		tickets.add(new Ticket(100,40,17,passengers.get(16),1));
		tickets.add(new Ticket(200,12,18,passengers.get(17),1));
		tickets.add(new Ticket(100,33,19,passengers.get(18),1));
		tickets.add(new Ticket(200,17,20,passengers.get(19),1));
		tickets.add(new Ticket(400,3,21,passengers.get(20),1));
		tickets.add(new Ticket(300,5,22,passengers.get(21),1));
		tickets.add(new Ticket(200,18,23,passengers.get(22),1));
		tickets.add(new Ticket(200,21,24,passengers.get(23),1));
		tickets.add(new Ticket(400,1,25,passengers.get(24),1));
		tickets.add(new Ticket(200,25,26,passengers.get(25),1));
		tickets.add(new Ticket(100,44,27,passengers.get(26),1));
		tickets.add(new Ticket(100,41,28,passengers.get(27),1));
		tickets.add(new Ticket(200,26,29,passengers.get(28),1));
		tickets.add(new Ticket(100,39,30,passengers.get(29),1));*/
		//Flight get indexi 1 fazlasına denk geliyor ekrandaki listede
		tickets.add(new Ticket(100,30,0,passengers.get(0),2));
		flights.get(1).getFirstSeats()[0]=1;//airbus f0
		tickets.add(new Ticket(200,15,1,passengers.get(1),3));
		flights.get(2).getEconomySeats()[0]=1;//boeing e0
		tickets.add(new Ticket(300,2,2,passengers.get(2),5));
		flights.get(4).getBusinessSeats()[0]=1;//fokker b0
		tickets.add(new Ticket(150,35,3,passengers.get(3),6));
		flights.get(5).getFirstSeats()[1]=1;//airbus f1
		tickets.add(new Ticket(300,4,4,passengers.get(4),8));
		flights.get(7).getEconomySeats()[0]=1;//airbus e0
		tickets.add(new Ticket(150,32,5,passengers.get(5),10));
		flights.get(9).getEconomySeats()[0]=1;//fokker e0
		tickets.add(new Ticket(250,24,6,passengers.get(6),12));
		flights.get(11).getBusinessSeats()[0]=1;//airbus b0
		tickets.add(new Ticket(300,8,7,passengers.get(7),14));
		flights.get(13).getEconomySeats()[1]=1; //airbus e1
		tickets.add(new Ticket(400,5,8,passengers.get(8),15));
		flights.get(14).getBusinessSeats()[1]=1; //airbus b1
		tickets.add(new Ticket(200,15,9,passengers.get(9),16));
		flights.get(15).getFirstSeats()[0]=1; //fokker f0
		tickets.add(new Ticket(300,6,10,passengers.get(10),17));
		flights.get(16).getEconomySeats()[2]=1;//airbus e2
		tickets.add(new Ticket(100,38,11,passengers.get(11),19));
		flights.get(18).getEconomySeats()[1]=1;//boeing e1
		tickets.add(new Ticket(100,37,12,passengers.get(12),20));
		flights.get(19).getBusinessSeats()[2]=1;//airbus b2
		tickets.add(new Ticket(100,31,13,passengers.get(13),22));
		flights.get(21).getEconomySeats()[3]=1;//airbus e3
		tickets.add(new Ticket(200,16,14,passengers.get(14),24));
		flights.get(23).getFirstSeats()[1]=1;//fokker f1
		tickets.add(new Ticket(200,14,15,passengers.get(15),25));
		flights.get(24).getBusinessSeats()[3]=1;//airbus b3
		tickets.add(new Ticket(100,40,16,passengers.get(16),26));
		flights.get(25).getBusinessSeats()[1]=1;//fokker b1
		tickets.add(new Ticket(200,12,17,passengers.get(17),27));
		flights.get(26).getEconomySeats()[4]=1;//airbus e4
		tickets.add(new Ticket(100,33,18,passengers.get(18),29));
		flights.get(28).getEconomySeats()[2]=1;//boeing e1
		tickets.add(new Ticket(200,17,19,passengers.get(19),31));
		flights.get(30).getEconomySeats()[1]=1;//fokker e1
		tickets.add(new Ticket(400,3,20,passengers.get(20),32));
		flights.get(31).getFirstSeats()[2]=1; //airbus f2
		tickets.add(new Ticket(300,5,21,passengers.get(21),33));
		flights.get(32).getFirstSeats()[3]=1;//airbus f3
		tickets.add(new Ticket(200,18,22,passengers.get(22),34));
		flights.get(33).getBusinessSeats()[4]=1;//airbus b4
		tickets.add(new Ticket(200,21,23,passengers.get(23),37));
		flights.get(36).getFirstSeats()[4]=1;//airbus f4
		tickets.add(new Ticket(400,1,24,passengers.get(24),38));
		flights.get(37).getEconomySeats()[2]=1;//fokker e2
		tickets.add(new Ticket(200,25,25,passengers.get(25),40));
		flights.get(39).getEconomySeats()[5]=1;//airbus e5
		tickets.add(new Ticket(100,44,26,passengers.get(26),41));
		flights.get(40).getBusinessSeats()[5]=1;//airbus b5
		
		//sıkıntı olabilir
		tickets.add(new Ticket(100,41,27,passengers.get(27),2));
		flights.get(1).getEconomySeats()[6]=1;//airbus e6
		tickets.add(new Ticket(200,26,28,passengers.get(28),3));
		flights.get(2).getBusinessSeats()[0]=1; //boeing b0
		tickets.add(new Ticket(100,39,29,passengers.get(29),5));
		flights.get(4).getFirstSeats()[2]=1; //fokker f2
	}
	//

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

	public DefaultListModel ticketModel(){
		DefaultListModel ticketModel = new DefaultListModel();
		ticketModel.addElement("ID-PRICE-SEAT-NAME-SURNAME-TYPE-FLIGHT");
		for (int i = 0; i < tickets.size(); i++) {
			ticketModel.addElement(tickets.get(i).ticketInfo());
		}
		return ticketModel;
	}
	
	public boolean checkInput(String input) {
		boolean flag = true;
		try {
			Integer.parseInt(input);
			
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public DefaultListModel flightModelUser() {
		DefaultListModel flightModel = new DefaultListModel();
		flightModel.addElement("FLIGHT ID-FROM-TO-DATE-HOUR");
		for (int i = 0; i < flights.size(); i++) {
			if(flights.get(i).getPlaneType().toString().equalsIgnoreCase("passenger")) {
		
				flightModel.addElement(flights.get(i).flightInfo());
			}
		}
		return flightModel;
	}
	public DefaultListModel flightModelAdmin() {
		DefaultListModel flightModel = new DefaultListModel();
		flightModel.addElement("ID-FROM-TO-DATE-HOUR");
		for (int i = 0; i < flights.size(); i++) {
			flightModel.addElement(flights.get(i).flightInfoAdmin());
			
		}
		return flightModel;
	}
	
	
	public DefaultListModel employeeModel() {
		DefaultListModel employeeModel = new DefaultListModel();
		employeeModel.addElement("ID-NAME-SURNAME-AGE-TEL NO-ADDRESS-TITLE");
		for (int i = 0; i < employees.size(); i++) {
			employeeModel.addElement(employees.get(i).employeeInfo());
			
		}
		return employeeModel;
	}
	
	
	public int getTicketNumber() {
		return ticketNumber;
	}


	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}


	public int getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}


	public int getPassengerId() {
		return passengerId;
	}


	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public ArrayList<Ticket> getTickets() {
		return tickets;
	}


	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}


	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}


	public ArrayList<PassengerPlane> getPassengerPlanes() {
		return passengerPlanes;
	}


	public void setPassengerPlanes(ArrayList<PassengerPlane> passengerPlanes) {
		this.passengerPlanes = passengerPlanes;
	}

	
}
