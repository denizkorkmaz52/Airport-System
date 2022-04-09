import java.util.ArrayList;

public class Queue {
	ArrayList<Flight> flights = new ArrayList<Flight>();
	int front, rear;

	Queue() {
		front = -1;
		rear = -1;
	}

	// check if the queue is empty
	boolean isEmpty() {
		if (front == -1)
			return true;
		else
			return false;
	}

	// insert elements to the queue
	boolean enQueue(Flight element) {
		boolean flag = true;
		int lastIndex = flights.size()-1;
		Flight temp[] = new Flight[flights.size() + 1];
		for (int i = 0; i < temp.length - 1; i++) {
			temp[i] = flights.get(lastIndex);
			lastIndex--;

		}

		int conflictControl = 0;
		for (int i = 0; i < temp.length - 1; i++) {
			if (element.getDepartureDate().getDay() == temp[i].getDepartureDate().getDay()
					&& element.getDepartureDate().getMonth() == temp[i].getDepartureDate().getMonth()
					&& element.getDepartureDate().getYear() == temp[i].getDepartureDate().getYear()
					&& element.getDeparturetime().getHour() == temp[i].getDeparturetime().getHour()
					&& element.getDeparturetime().getMinute() == temp[i].getDeparturetime().getMinute())
				conflictControl++;
		}
		if (conflictControl < 3) {
			temp[temp.length - 1] = element;
			
			if (element.getFlightNumber() == 5) {
				System.out.println();
			}
			for (int i = 0; i < temp.length; i++) {
				for (int j = i + 1; j < temp.length; j++) {
					Flight tmp;
					if ((temp[i].getDepartureDate().getYear() > temp[j].getDepartureDate().getYear())
							|| (temp[i].getDepartureDate().getYear() >= temp[j].getDepartureDate().getYear()
									&& temp[i].getDepartureDate().getMonth() > temp[j].getDepartureDate().getMonth())
							|| (temp[i].getDepartureDate().getYear() >= temp[j].getDepartureDate().getYear()
									&& temp[i].getDepartureDate().getMonth() >= temp[j].getDepartureDate().getMonth()
									&& temp[i].getDepartureDate().getDay() > temp[j].getDepartureDate().getDay())) {
						tmp = temp[i];
						temp[i] = temp[j];
						temp[j] = tmp;
					}
				}

			}
			for (int i = 0; i < temp.length; i++) {
				for (int j = i + 1; j < temp.length; j++) {
					Flight tmp;
					if (temp[i].getDepartureDate().getYear() == temp[j].getDepartureDate().getYear()
							&& temp[i].getDepartureDate().getMonth() == temp[j].getDepartureDate().getMonth()
							&& temp[i].getDepartureDate().getDay() == temp[j].getDepartureDate().getDay()
							&& ((temp[i].getDeparturetime().getHour() > temp[j].getDeparturetime().getHour())
									|| (temp[i].getDeparturetime().getHour() >= temp[j].getDeparturetime().getHour()
											&& temp[i].getDeparturetime().getMinute() > temp[j].getDeparturetime()
													.getMinute()))) {
						tmp = temp[i];
						temp[i] = temp[j];
						temp[j] = tmp;
					}
				}

			}

			flights.clear();

			for (int i = 0; i < temp.length; i++) {
				flights.add(temp[i]);
			}
			if (front == -1) {
				// mark front denote first element of queue
				front = 0;
			}

			rear++;
			// insert element at the rear
			// System.out.println("Insert " + element);
		} else
			flag= false;
		return flag;
	}

	// delete element from the queue
	Flight deQueue() {
		Flight element;
		
		// if queue is empty
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			// remove element from the front of queue
			element = flights.get(front);

			// if the queue has only one element
			if (front >= rear) {
				front = -1;
				rear = -1;
			} else {
				// mark next element as the front
				front++;
			}
			System.out.println("Flight number " + element.getFlightNumber() + " took place");
			return (element);
		}
	}
	Flight deleteFlight(Flight element) {
        Flight[] temp = new Flight[flights.size()];
        Flight removed = null;
        for (int i = 0; i < temp.length; i++) {
            if(flights.get(i) != element)
                temp[i] = flights.get(i);
            else {
                removed = temp[i];
                System.out.println("Flight deleted");
            }
        }
        flights.clear();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i]!= null) {
                flights.add(temp[i]);
            }
        }
        return removed;
    }
    Flight peek() {
        return flights.get(front);
    }

}