
public class Ticket {
	private int price, seatNumber, ticketNumber, flightNumber;
	private Passenger passenger;
	//Flight number eklenecek.
	Ticket(int price, int seatNumber, int ticketNumber, Passenger passenger, int flightNumber){
		this.price = price;
		this.seatNumber = seatNumber;
		this.passenger = passenger;
		this.flightNumber = flightNumber;
		this.ticketNumber = ticketNumber;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	
	public void ticketUpdate(int ticketNumber) {
		
	}
	
	public String ticketInfo() {
		return (this.ticketNumber + " " + this.price + " " + this.seatNumber + " " +
				this.passenger.getName() + " " + this.passenger.getSurname() + " " + this.passenger.getPassType()
				+ " " + this.passenger.getAge());
	}
}
