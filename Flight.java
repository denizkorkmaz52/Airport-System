import java.util.ArrayList;

public class Flight {
	private int flightNumber;
	private String from;
	private String to;
	private Time departuretime;
	private String planeType;
	private String planeModel;
	private int[] economySeats;
	private int[] firstSeats;
	private int[] businessSeats;
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>(); // hashmap yapılabilir
	private Date departureDate;
	public Flight(int flightNumber, String from, String to, Time departuretime, Date departureDate, String planeType) {
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.departuretime = departuretime;
		this.departureDate = departureDate;
		this.planeType = planeType;
	}
	public Flight(int flightNumber, String from, String to, Time departuretime, Date departureDate, String planeType, String planeModel) {
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.departuretime = departuretime;
		this.departureDate = departureDate;
		this.planeType = planeType;
		
		if(planeType.equalsIgnoreCase("passenger")) {
			if(planeModel.equalsIgnoreCase("airbus")) {
				economySeats  = new int[20];
				firstSeats = new int[10];
				businessSeats = new int[6];
			}
			if(planeModel.equalsIgnoreCase("boeing")) {
				economySeats  = new int[10];
				firstSeats = new int[2];
				businessSeats = new int[2];
			}
			if(planeModel.equalsIgnoreCase("fokker")) {
				economySeats  = new int[30];
				firstSeats = new int[8];
				businessSeats = new int[6];
			}
			for (int i = 0; i < economySeats.length; i++) {
				economySeats[i] = 0;
			}
			for (int i = 0; i < businessSeats.length; i++) {
				economySeats[i] = 0;
			}
			for (int i = 0; i < firstSeats.length; i++) {
				economySeats[i] = 0;
			}
		}
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Time getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(Time departuretime) {
		this.departuretime = departuretime;
	}

	public String getPlaneModel() {
		return planeModel;
	}
	public void setPlaneModel(String planeModel) {
		this.planeModel = planeModel;
	}
	public int[] getEconomySeats() {
		return economySeats;
	}
	public void setEconomySeats(int[] economySeats) {
		this.economySeats = economySeats;
	}
	public int[] getFirstSeats() {
		return firstSeats;
	}
	public void setFirstSeats(int[] firstSeats) {
		this.firstSeats = firstSeats;
	}
	public int[] getBusinessSeats() {
		return businessSeats;
	}
	public void setBusinessSeats(int[] businessSeats) {
		this.businessSeats = businessSeats;
	}
	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public String getPlaneType() {
		return planeType;
	}
	
	public void addSeat(String type, int seat) {
		if(type.equalsIgnoreCase("business")) {
			businessSeats[seat] = 1;
		}
		else if(type.equalsIgnoreCase("first")) {
			firstSeats[seat] = 1;
		}
		else if(type.equalsIgnoreCase("economy")) {
			economySeats[seat] = 1;
		}
	}
	
	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}
	
	public String flightInfo() {
		return (flightNumber+" "+from+" "+ to +" "+ departureDate.getDay() +"."+ departureDate.getMonth() +"."+ departureDate.getYear()+" "+ departuretime.getHour()    +":"+  departuretime.getMinute());
	}
	
	public String flightInfoAdmin() {
		return (flightNumber+" "+from+" "+ to +" "+ departureDate.getDay() +"."+ departureDate.getMonth() +"."+ departureDate.getYear()+" "+ departuretime.getHour()    +":"+  departuretime.getMinute() +" "+ planeType);
	}
	
}
