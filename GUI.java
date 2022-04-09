import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField empnamef;
	private JTextField empsurnamef;
	private JTextField empagef;
	private JTextField empnumberf;
	private JTextField empaddressf;
	private JTextField emptitlef;
	private JTextField txtPrice;
	private JTextField txtSeatNumber;
	private JTextField txtAge;
	private JTextField txtNumber;
	private JTextField txtAddress;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtYear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setTitle("Airport Management System");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Timer timer;

	public GUI() {
		Admin admin = new Admin();
		Database database = new Database();
		Queue queue = new Queue();
		ArrayList<Ticket> ticketData = database.getTickets();
		ArrayList<Passenger> passengerData = database.getPassengers();
		ArrayList<Flight> flightData = database.getFlights();
		ArrayList<Employee> employeeData = database.getEmployees();

		for (int i = 0; i < flightData.size(); i++) {
			queue.enQueue(flightData.get(i));
		}
		System.out.println(flightData.size());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane mainTabs = new JTabbedPane(JTabbedPane.TOP);
		mainTabs.setBackground(Color.WHITE);
		mainTabs.setBounds(0, -23, 1152, 772);
		contentPane.add(mainTabs);

		JPanel panel = new JPanel();
		mainTabs.addTab("LOGIN SCREEN", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN AS ADMIN");
		lblNewLabel.setBounds(445, 29, 250, 63);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		username = new JTextField();
		username.setBounds(476, 130, 184, 42);
		panel.add(username);
		username.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("00:00:00");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(314, 10, 133, 20);
		panel.add(lblNewLabel_7);

		JButton btnNewButton_1 = new JButton("CONTINUE AS CUSTOMER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainTabs.setSelectedIndex(5);
			}
		});
		btnNewButton_1.setBounds(476, 440, 199, 54);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(523, 103, 93, 17);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(523, 212, 93, 25);
		panel.add(lblNewLabel_2);

		password = new JPasswordField();
		password.setBounds(477, 249, 183, 42);
		panel.add(password);

		// boolean isAdmin = admin.checkAdmin(username.getText(),
		// password.getPassword());
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admin.checkAdmin(username.getText(), password.getPassword())) {
					System.out.println("x");
					mainTabs.setSelectedIndex(3);
				}
			}
		});
		btnNewButton.setBounds(506, 340, 129, 54);
		panel.add(btnNewButton);

		// Employee Admin panel
		JPanel employeeAddEdit = new JPanel();
		mainTabs.addTab("employeeAddEdit", null, employeeAddEdit, null);
		employeeAddEdit.setLayout(null);

		JPanel ticketBuy = new JPanel();
		mainTabs.addTab("TicketBuy", null, ticketBuy, null);
		ticketBuy.setLayout(null);

		JPanel adminPanel = new JPanel();
		mainTabs.addTab("Admin Panel", null, adminPanel, null);
		adminPanel.setLayout(null);

		JTabbedPane adminPanelPane = new JTabbedPane(JTabbedPane.TOP);
		adminPanelPane.setBounds(10, 26, 913, 611);
		adminPanel.add(adminPanelPane);

		JScrollPane flights = new JScrollPane();
		adminPanelPane.addTab("Flights", null, flights, null);

		// Flight Display Model for flight list
		// Getting flights from Database and display on the flights list for admin
		// panel.
		DefaultListModel flightModelAdmin = database.flightModelAdmin();
		JList flightsList = new JList(flightModelAdmin);
		flightsList.setFont(new Font("Arial", Font.BOLD, 16));
		flights.setViewportView(flightsList);

		DefaultListModel userFlightModel = database.flightModelUser(); // User flight panel model

		// Ticket Display Model for ticket list
		DefaultListModel ticketModel = database.ticketModel();
		JScrollPane tickets = new JScrollPane();
		adminPanelPane.addTab("Tickets", null, tickets, null);
		// Getting tickets from Database and display on the ticket list for admin panel.
		JList ticketList = new JList(ticketModel);
		ticketList.setFont(new Font("Arial", Font.BOLD, 16));
		tickets.setViewportView(ticketList);

		// Employee Display Model for employee list
		DefaultListModel employeeModel = database.employeeModel();
		JScrollPane employees = new JScrollPane();
		adminPanelPane.addTab("Employees", null, employees, null);
		JList employeeList = new JList(employeeModel);
		employeeList.setFont(new Font("Arial", Font.BOLD, 16));
		employees.setViewportView(employeeList);

		// Timer of the airport.

		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				lblNewLabel_7.setText(sdf.format(new java.util.Date()));
				String arr[] = lblNewLabel_7.getText().split(":");
				if (Integer.parseInt(arr[2]) % 25 == 0) {
					Flight[] arr11 = new Flight[3];
					int in = 1;
					arr11[0] = queue.deQueue();
					while (queue.peek().getDepartureDate().getYear() == arr11[0].getDepartureDate().getYear()
							&& queue.peek().getDepartureDate().getMonth() == arr11[0].getDepartureDate().getMonth()
							&& queue.peek().getDepartureDate().getDay() == arr11[0].getDepartureDate().getDay()
							&& queue.peek().getDeparturetime().getHour() == arr11[0].getDeparturetime().getHour()
							&& queue.peek().getDeparturetime().getMinute() == arr11[0].getDeparturetime().getMinute()) {
						arr11[in] = queue.deQueue();
						in++;

					}
					for (int i = 0; i < arr11.length; i++) {
						if (arr11[i] != null) {
							int fnum = arr11[i].getFlightNumber();
							flightModelAdmin.remove(fnum);
							userFlightModel.remove(fnum);
							flightData.remove(fnum - 1);
						}

					}
					String flightInfo = "";
					for (int i = 0; i < arr11.length; i++) {
						if (arr11[i] != null)
							flightInfo = flightInfo + arr11[i].flightInfo() + "\n";
					}
					JOptionPane.showMessageDialog(null, flightInfo, "Current Flight", JOptionPane.CLOSED_OPTION);
				}
			}
		});

		timer.start();

		// DELETE FUNCTIONS AND PANEL

		JButton adminPanelDelete = new JButton("Delete");
		adminPanelDelete.setFont(new Font("Tahoma", Font.PLAIN, 25));
		adminPanelDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = adminPanelPane.getSelectedIndex();
				if (selected == 2) {
					int index = employeeList.getSelectedIndex();

					employeeModel.remove(index);
					employeeData.remove(index - 1);

				} else if (selected == 1) {
					int index = ticketList.getSelectedIndex();

					ticketModel.remove(index);
					ticketData.remove(index - 1);
				} else if (selected == 0) {
					int index = flightsList.getSelectedIndex();
					String temp = (String) flightsList.getSelectedValue();
					String[] arr = temp.split(" ");
					int fnumber = Integer.parseInt(arr[0]);
					for (int i = 1; i < userFlightModel.size(); i++) {
						arr = userFlightModel.getElementAt(i).toString().split(" ");
						if (Integer.parseInt(arr[0]) == fnumber)
							userFlightModel.removeElementAt(i);
					}
					Flight deletedF = flightData.get(index - 1);
					flightModelAdmin.remove(index);
					flightData.remove(index - 1);
					queue.deleteFlight(deletedF);

				}

			}
		});
		adminPanelDelete.setBounds(955, 57, 133, 43);
		adminPanel.add(adminPanelDelete);

		
		
		JButton btnNewButton33 = new JButton("Return");
		btnNewButton33.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton33.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainTabs.setSelectedIndex(0);

			}
		});
		btnNewButton33.setBounds(955, 500, 133, 43);
		adminPanel.add(btnNewButton33);
		
		// EDIT FUNCTIONS AND PANEL
		JButton adminPanelEdit = new JButton("Edit");
		adminPanelEdit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		adminPanelEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (adminPanelPane.getSelectedIndex() == 2) {
					employeeAddEdit.removeAll();
					String editEmployee = "";

					int index = employeeList.getSelectedIndex();
					editEmployee = (String) employeeList.getSelectedValue();

					mainTabs.setSelectedIndex(1);
					String[] split = editEmployee.split(" ");
					empnamef = new JTextField();
					empnamef.setBounds(152, 77, 270, 38);
					employeeAddEdit.add(empnamef);
					empnamef.setColumns(10);
					empnamef.setText(split[1]);
					System.out.println(empnamef.getText());

					empsurnamef = new JTextField();
					empsurnamef.setBounds(152, 144, 270, 38);
					employeeAddEdit.add(empsurnamef);
					empsurnamef.setColumns(10);
					empsurnamef.setText(split[2]);

					empagef = new JTextField();
					empagef.setBounds(152, 220, 270, 38);
					employeeAddEdit.add(empagef);
					empagef.setColumns(10);
					empagef.setText(split[3]);

					empnumberf = new JTextField();
					empnumberf.setBounds(152, 292, 270, 38);
					employeeAddEdit.add(empnumberf);
					empnumberf.setColumns(10);
					empnumberf.setText(split[4]);

					empaddressf = new JTextField();
					empaddressf.setBounds(152, 358, 270, 38);
					employeeAddEdit.add(empaddressf);
					empaddressf.setColumns(10);
					empaddressf.setText(split[5]);

					emptitlef = new JTextField();
					emptitlef.setBounds(152, 429, 270, 38);
					employeeAddEdit.add(emptitlef);
					emptitlef.setColumns(10);
					emptitlef.setText(split[6]);

					JLabel lblNewLabel_10 = new JLabel("Name");
					lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_10.setBounds(152, 49, 100, 30);

					employeeAddEdit.add(lblNewLabel_10);

					JLabel lblNewLabel_11 = new JLabel("Surname");
					lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_11.setBounds(152, 116, 100, 30);
					employeeAddEdit.add(lblNewLabel_11);

					JLabel lblNewLabel_12 = new JLabel("Age");
					lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_12.setBounds(152, 192, 100, 30);
					employeeAddEdit.add(lblNewLabel_12);

					JLabel lblNewLabel_13 = new JLabel("Number");
					lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_13.setBounds(152, 265, 100, 30);
					employeeAddEdit.add(lblNewLabel_13);

					JLabel lblNewLabel_14 = new JLabel("Address");
					lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_14.setBounds(152, 329, 100, 30);
					employeeAddEdit.add(lblNewLabel_14);

					JLabel lblNewLabel_15 = new JLabel("Title");
					lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_15.setBounds(152, 399, 100, 30);
					employeeAddEdit.add(lblNewLabel_15);

					JButton btnNewButton_4 = new JButton("Return");
					btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
					btnNewButton_4.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							mainTabs.setSelectedIndex(3);

						}
					});
					btnNewButton_4.setBounds(600, 200, 168, 37);
					employeeAddEdit.add(btnNewButton_4);

					JButton empeditapply = new JButton("Apply");
					empeditapply.setBounds(600, 300, 168, 37);
					empeditapply.setFont(new Font("Tahoma", Font.PLAIN, 25));
					empeditapply.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (database.checkInput(empagef.getText()) && database.checkInput(empnumberf.getText())) {
								String edited = split[0] + " " + empnamef.getText() + " " + empsurnamef.getText() + " "
										+ empagef.getText() + " " + empnumberf.getText() + " " + empaddressf.getText()
										+ " " + emptitlef.getText();

								employeeModel.set(Integer.parseInt(split[0]), edited);
								mainTabs.setSelectedIndex(3);
								adminPanelPane.setSelectedIndex(2);
							} else {
								JOptionPane.showMessageDialog(null, "Age and number must be an integer",
										"Invalid Input", JOptionPane.CLOSED_OPTION);
							}
						}
					});
					employeeAddEdit.add(empeditapply);

				} else if (adminPanelPane.getSelectedIndex() == 1) {
					employeeAddEdit.removeAll();
					String editTicket = "";

					int index = ticketList.getSelectedIndex();
					editTicket = ticketList.getSelectedValue().toString();
					mainTabs.setSelectedIndex(1);

					String[] split = editTicket.split(" ");

					empnamef = new JTextField();
					empnamef.setBounds(152, 77, 270, 38);
					employeeAddEdit.add(empnamef);
					empnamef.setColumns(10);
					empnamef.setText(split[1]);

					empsurnamef = new JTextField();
					empsurnamef.setBounds(152, 139, 270, 38);
					employeeAddEdit.add(empsurnamef);
					empsurnamef.setColumns(10);
					empsurnamef.setText(split[2]);

					empagef = new JTextField();
					empagef.setBounds(152, 205, 270, 38);
					employeeAddEdit.add(empagef);
					empagef.setColumns(10);
					empagef.setText(split[3]);

					empnumberf = new JTextField();
					empnumberf.setBounds(152, 280, 270, 38);
					employeeAddEdit.add(empnumberf);
					empnumberf.setColumns(10);
					empnumberf.setText(split[4]);

					empaddressf = new JTextField();
					empaddressf.setBounds(152, 343, 270, 38);
					employeeAddEdit.add(empaddressf);
					empaddressf.setColumns(10);
					empaddressf.setText(split[5]);

					JLabel x = new JLabel("Age");
					x.setFont(new Font("Tahoma", Font.PLAIN, 20));
					x.setBounds(152, 377, 270, 31);
					employeeAddEdit.add(x);

					emptitlef = new JTextField();
					emptitlef.setBounds(152, 407, 270, 38);
					employeeAddEdit.add(emptitlef);
					emptitlef.setColumns(10);
					emptitlef.setText(split[6]);

					JLabel lblNewLabel_16 = new JLabel("Price");
					lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_16.setBounds(153, 55, 83, 25);
					employeeAddEdit.add(lblNewLabel_16);

					JLabel lblNewLabel_17 = new JLabel("Seat Number");
					lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_17.setBounds(152, 116, 189, 25);
					employeeAddEdit.add(lblNewLabel_17);

					JLabel lblNewLabel_18 = new JLabel("Name");
					lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_18.setBounds(152, 181, 156, 25);
					employeeAddEdit.add(lblNewLabel_18);

					JLabel lblNewLabel_19 = new JLabel("Surname");
					lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_19.setBounds(152, 255, 126, 25);
					employeeAddEdit.add(lblNewLabel_19);

					JLabel lblNewLabel_20 = new JLabel("Passenger Type");
					lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_20.setBounds(152, 316, 172, 25);
					employeeAddEdit.add(lblNewLabel_20);

					JButton btnNewButton_4 = new JButton("Return");
					btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
					btnNewButton_4.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							mainTabs.setSelectedIndex(3);

						}
					});
					btnNewButton_4.setBounds(600, 200, 168, 37);
					employeeAddEdit.add(btnNewButton_4);
					
					
					

					JButton empeditapply = new JButton("Apply");
					empeditapply.setBounds(600, 400, 168, 37);
					empeditapply.setFont(new Font("Tahoma", Font.PLAIN, 25));
					empeditapply.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (database.checkInput(empagef.getText()) && database.checkInput(empnumberf.getText())) {
								Ticket currentTicket = ticketData.get(Integer.parseInt(split[0]));
								String edited = empnamef.getText() + " " + empsurnamef.getText() + " "
										+ empagef.getText() + " " + empnumberf.getText() + " " + empaddressf.getText()
										+ " " + emptitlef.getText();
								ticketModel.set(Integer.parseInt(split[0]), edited);
								currentTicket.getPassenger().setName(empnamef.getText());
								currentTicket.getPassenger().setSurname(empsurnamef.getText());
								currentTicket.getPassenger().setAge(Integer.parseInt(empagef.getText()));
								currentTicket.getPassenger().setAddress(empaddressf.getText());
								currentTicket.getPassenger().setNumber(Integer.parseInt(empnumberf.getText()));
								currentTicket.setPrice(Integer.parseInt(txtPrice.getText()));
								ticketData.set(Integer.parseInt(split[0]) - 1, currentTicket);
								mainTabs.setSelectedIndex(3);
								adminPanelPane.setSelectedIndex(1);

							} else {
								JOptionPane.showMessageDialog(null, "Age and number must be an integer",
										"Invalid Input", JOptionPane.CLOSED_OPTION);
							}

						}
					});
					employeeAddEdit.add(empeditapply);

				} else if (adminPanelPane.getSelectedIndex() == 0) {
					employeeAddEdit.removeAll();
					mainTabs.setSelectedIndex(1);
					String selectedLine = (String) flightsList.getSelectedValue();
					String[] selectedArr = selectedLine.split(" ");
					String[] dateArr = selectedArr[3].split("\\.");
					String[] hourArr = selectedArr[4].split(":");
					txtFrom = new JTextField();
					txtFrom.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtFrom.setText(selectedArr[1]);
					txtFrom.setBounds(140, 90, 226, 30);
					employeeAddEdit.add(txtFrom);
					txtFrom.setColumns(10);

					JLabel lbl1 = new JLabel("From");
					lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lbl1.setBounds(140, 63, 226, 30);
					employeeAddEdit.add(lbl1);

					txtTo = new JTextField();
					txtTo.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtTo.setText(selectedArr[2]);
					txtTo.setBounds(140, 150, 226, 30);
					employeeAddEdit.add(txtTo);
					txtTo.setColumns(10);

					JLabel lbl2 = new JLabel("To");
					lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lbl2.setBounds(140, 125, 226, 30);
					employeeAddEdit.add(lbl2);

					txtDay = new JTextField();
					txtDay.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtDay.setText(dateArr[0]);
					txtDay.setBounds(140, 211, 226, 30);
					employeeAddEdit.add(txtDay);
					txtDay.setColumns(10);

					JLabel lbl3 = new JLabel("Day");
					lbl3.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lbl3.setBounds(140, 185, 226, 30);
					employeeAddEdit.add(lbl3);

					txtMonth = new JTextField();
					txtMonth.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtMonth.setText(dateArr[1]);
					txtMonth.setBounds(140, 270, 226, 30);
					employeeAddEdit.add(txtMonth);
					txtMonth.setColumns(10);

					txtYear = new JTextField();
					txtYear.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtYear.setText(dateArr[2]);
					txtYear.setBounds(140, 334, 226, 30);
					employeeAddEdit.add(txtYear);
					txtYear.setColumns(10);

					JLabel lblNewLabel_8 = new JLabel("Month");
					lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_8.setBounds(140, 247, 184, 25);
					employeeAddEdit.add(lblNewLabel_8);

					JLabel lblNewLabel_9 = new JLabel("Year");
					lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel_9.setBounds(138, 310, 80, 18);
					employeeAddEdit.add(lblNewLabel_9);

					String[] hours = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
							"16", "17", "18", "19", "20", "21", "22", "23", "24" };
					JComboBox comboBox_3 = new JComboBox(hours);
					comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
					comboBox_3.setSelectedItem(hourArr[0]);
					comboBox_3.setBounds(505, 112, 240, 42);
					employeeAddEdit.add(comboBox_3);
					String[] minutes = { "00", "30" };
					JComboBox comboBox_4 = new JComboBox(minutes);
					comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
					comboBox_4.setBounds(505, 222, 240, 42);
					employeeAddEdit.add(comboBox_4);

					JLabel lblNewLabel_3 = new JLabel("Hour");
					lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblNewLabel_3.setBounds(505, 74, 165, 20);
					employeeAddEdit.add(lblNewLabel_3);

					JLabel lblNewLabel_4 = new JLabel("Minute");
					lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblNewLabel_4.setBounds(505, 177, 165, 35);
					employeeAddEdit.add(lblNewLabel_4);

					String[] planeTypes = { "Passenger", "Cargo", "Private" };
					JComboBox comboBox_5 = new JComboBox(planeTypes);
					comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
					comboBox_5.setBounds(505, 345, 240, 42);
					employeeAddEdit.add(comboBox_5);

					String[] planeModels = { "Airbus", "Boeing", "Fokker" };
					JLabel lblNewLabel_5 = new JLabel("Plane Type");
					lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblNewLabel_5.setBounds(505, 301, 182, 34);
					employeeAddEdit.add(lblNewLabel_5);

					JComboBox comboBox_6 = new JComboBox(planeModels);
					comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
					comboBox_6.setBounds(505, 456, 240, 48);
					employeeAddEdit.add(comboBox_6);

					JLabel lblNewLabel_6 = new JLabel("Plane Model");
					lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblNewLabel_6.setBounds(505, 407, 226, 49);
					employeeAddEdit.add(lblNewLabel_6);

					JButton btnNewButton_4 = new JButton("Return");
					btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
					btnNewButton_4.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							mainTabs.setSelectedIndex(3);

						}
					});
					btnNewButton_4.setBounds(896, 200, 168, 37);
					employeeAddEdit.add(btnNewButton_4);

					JButton btnNewButton_3 = new JButton("Apply");
					btnNewButton_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (database.checkInput(txtDay.getText()) && database.checkInput(txtMonth.getText())
									&& database.checkInput(txtYear.getText())) {
								Time time = new Time(Integer.parseInt((String) comboBox_3.getSelectedItem()),
										Integer.parseInt((String) comboBox_4.getSelectedItem()));
								Date date = new Date(Integer.parseInt(txtDay.getText()),
										Integer.parseInt(txtMonth.getText()), Integer.parseInt(txtYear.getText()));
								Flight newFlight = new Flight(Integer.parseInt(selectedArr[0]), txtFrom.getText(),
										txtTo.getText(), time, date, comboBox_5.getSelectedItem().toString(),
										comboBox_6.getSelectedItem().toString());
								if (!queue.enQueue(newFlight)) {
									JOptionPane.showMessageDialog(null,
											"Airport is full at this time!!! Change the date or time of the flight",
											"Invalid Input", JOptionPane.CLOSED_OPTION);
								} else {
									flightModelAdmin.setElementAt(newFlight.flightInfo(),
											Integer.parseInt(selectedArr[0]));
									flightData.set(Integer.parseInt(selectedArr[0]) - 1, newFlight);
									mainTabs.setSelectedIndex(3);
									queue.deleteFlight(flightData.get(Integer.parseInt(selectedArr[0])));
									adminPanelPane.setSelectedIndex(0);
								}

							} else {
								JOptionPane.showMessageDialog(null, "Day, Month and Year must be an integer",
										"Invalid Input", JOptionPane.CLOSED_OPTION);
							}

						}
					});
					btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
					btnNewButton_3.setBounds(896, 400, 168, 37);
					employeeAddEdit.add(btnNewButton_3);

				}

			}
		});
		adminPanelEdit.setBounds(955, 364, 128, 43);
		adminPanel.add(adminPanelEdit);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// ADD FUNCTIONS AND PANEL
		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adminPanelPane.getSelectedIndex() == 2) {
					employeeAddEdit.removeAll();
					mainTabs.setSelectedIndex(1);

					empnamef = new JTextField();
					empnamef.setBounds(152, 77, 270, 38);
					employeeAddEdit.add(empnamef);
					empnamef.setColumns(10);
					empnamef.setText("Name");

					empsurnamef = new JTextField();
					empsurnamef.setBounds(152, 139, 270, 38);
					employeeAddEdit.add(empsurnamef);
					empsurnamef.setColumns(10);
					empsurnamef.setText("Surname");

					empagef = new JTextField();
					empagef.setBounds(152, 205, 270, 38);
					employeeAddEdit.add(empagef);
					empagef.setColumns(10);
					empagef.setText("Age");

					empnumberf = new JTextField();
					empnumberf.setBounds(152, 280, 270, 38);
					employeeAddEdit.add(empnumberf);
					empnumberf.setColumns(10);
					empnumberf.setText("Number");

					empaddressf = new JTextField();
					empaddressf.setBounds(152, 343, 270, 38);
					employeeAddEdit.add(empaddressf);
					empaddressf.setColumns(10);
					empaddressf.setText("Address");

					emptitlef = new JTextField();
					emptitlef.setBounds(152, 407, 270, 38);
					employeeAddEdit.add(emptitlef);
					emptitlef.setColumns(10);
					emptitlef.setText("Title");

					JButton empeditapply = new JButton("Add");
					empeditapply.setBounds(462, 597, 168, 37);
					empeditapply.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							if (database.checkInput(empagef.getText()) && database.checkInput(empnumberf.getText())) {
								String add = employeeData.size() - 1 + " " + empnamef.getText() + " "
										+ empsurnamef.getText() + " " + empagef.getText() + " " + empnumberf.getText()
										+ " " + empaddressf.getText() + " " + emptitlef.getText();
								employeeModel.set(employeeData.size() - 1, add);
								employeeData.add(new Employee(empnamef.getText(), empsurnamef.getText(),
										Integer.parseInt(empagef.getText()), Integer.parseInt(empnumberf.getText()),
										empaddressf.getText(), emptitlef.getText(), employeeData.size() - 1));
								mainTabs.setSelectedIndex(3);
								adminPanelPane.setSelectedIndex(2);
							} else {
								JOptionPane.showMessageDialog(null, "Age and Number must be an integer",
										"Invalid Input", JOptionPane.CLOSED_OPTION);
							}

						}
					});
					employeeAddEdit.add(empeditapply);
				}
				if (adminPanelPane.getSelectedIndex() == 1) {
					employeeAddEdit.removeAll();
					mainTabs.setSelectedIndex(1);
					empnamef = new JTextField();
					empnamef.setBounds(152, 77, 270, 38);
					employeeAddEdit.add(empnamef);
					empnamef.setColumns(10);
					empnamef.setText("Name");

					empsurnamef = new JTextField();
					empsurnamef.setBounds(152, 139, 270, 38);
					employeeAddEdit.add(empsurnamef);
					empsurnamef.setColumns(10);
					empsurnamef.setText("Surname");

					empagef = new JTextField();
					empagef.setBounds(152, 205, 270, 38);
					employeeAddEdit.add(empagef);
					empagef.setColumns(10);
					empagef.setText("Age");

					empnumberf = new JTextField();
					empnumberf.setBounds(152, 280, 270, 38);
					employeeAddEdit.add(empnumberf);
					empnumberf.setColumns(10);
					empnumberf.setText("Number");

					empaddressf = new JTextField();
					empaddressf.setBounds(152, 343, 270, 38);
					employeeAddEdit.add(empaddressf);
					empaddressf.setColumns(10);
					empaddressf.setText("Address");

					String[] passType = { "Business", "Economy", "First" };
					JComboBox comboBox = new JComboBox(passType);
					comboBox.setBounds(152, 405, 270, 38);
					employeeAddEdit.add(comboBox);

					txtPrice = new JTextField();
					txtPrice.setText("Price");
					txtPrice.setBounds(547, 77, 219, 38);
					employeeAddEdit.add(txtPrice);
					txtPrice.setColumns(10);

					txtSeatNumber = new JTextField();
					txtSeatNumber.setText("Seat Number");
					txtSeatNumber.setBounds(547, 139, 219, 38);
					employeeAddEdit.add(txtSeatNumber);
					txtSeatNumber.setColumns(10);
					String[] comboxArr = new String[flightData.size()];
					for (int i = 0; i < flightData.size(); i++) {
						comboxArr[i] = String.valueOf(i);
					}

					JComboBox comboBox_1 = new JComboBox(comboxArr);
					comboBox_1.setBounds(844, 80, 219, 30);
					employeeAddEdit.add(comboBox_1);

					JLabel lblNewLabel_7 = new JLabel("Flight Number");
					lblNewLabel_7.setBounds(844, 57, 107, 13);
					employeeAddEdit.add(lblNewLabel_7);

					JButton empeditapply = new JButton("Add");
					empeditapply.setBounds(462, 597, 168, 37);
					empeditapply.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							if (database.checkInput(empagef.getText()) && database.checkInput(empnumberf.getText())
									&& database.checkInput(txtPrice.getText())
									&& database.checkInput(txtSeatNumber.getText())) {
								Flight selectedFlight = flightData.get(comboBox_1.getSelectedIndex());
								if (comboBox.getSelectedItem().toString().equalsIgnoreCase("First")) {
									int[] seats = selectedFlight.getFirstSeats();
									if (Integer.parseInt(txtSeatNumber.getText()) >= seats.length) {
										JOptionPane.showMessageDialog(null,
												"Seat number can be max" + (seats.length - 1), "Invalid Input",
												JOptionPane.CLOSED_OPTION);
									}
									if (seats[Integer.parseInt(txtSeatNumber.getText())] != 1) { // 0 olcak
										JOptionPane.showMessageDialog(null, "Seat is already taken", "Invalid Input",
												JOptionPane.CLOSED_OPTION);
									}

								} else if (comboBox.getSelectedItem().toString().equalsIgnoreCase("Business")) {
									int[] seats = selectedFlight.getBusinessSeats();
									if (Integer.parseInt(txtSeatNumber.getText()) >= seats.length) {
										JOptionPane.showMessageDialog(null,
												"Seat number can be max" + (seats.length - 1), "Invalid Input",
												JOptionPane.CLOSED_OPTION);
									}
									if (seats[Integer.parseInt(txtSeatNumber.getText())] != 0) { // 0 olcak
										JOptionPane.showMessageDialog(null, "Seat is already taken", "Invalid Input",
												JOptionPane.CLOSED_OPTION);
									}

								} else if (comboBox.getSelectedItem().toString().equalsIgnoreCase("Economy")) {
									int[] seats = selectedFlight.getEconomySeats();
									if (Integer.parseInt(txtSeatNumber.getText()) >= seats.length) {
										JOptionPane.showMessageDialog(null,
												"Seat number can be max" + (seats.length - 1), "Invalid Input",
												JOptionPane.CLOSED_OPTION);
									}
									if (seats[Integer.parseInt(txtSeatNumber.getText())] != 1) { // 0 olcak
										JOptionPane.showMessageDialog(null, "Seat is already taken", "Invalid Input",
												JOptionPane.CLOSED_OPTION);
									}

								}

								String add = ticketData.size() + " " + txtPrice.getText() + " "
										+ txtSeatNumber.getText() + " " + empnamef.getText() + " "
										+ empsurnamef.getText() + " " + comboBox.getSelectedItem().toString() + " "
										+ empagef.getText();
								Passenger newPassenger = new Passenger(empnamef.getText(), empsurnamef.getText(),
										Integer.parseInt(empagef.getText()), Integer.parseInt(empnumberf.getText()),
										empaddressf.getText(), comboBox.getSelectedItem().toString(),
										passengerData.size() - 1);
								passengerData.add(newPassenger);

								ticketData.add(new Ticket(Integer.parseInt(txtPrice.getText()),
										Integer.parseInt(txtSeatNumber.getText()), ticketData.size() - 1, newPassenger,
										comboBox_1.getSelectedIndex()));
								ticketModel.addElement(add);
								mainTabs.setSelectedIndex(0);

							} else {
								JOptionPane.showMessageDialog(null,
										"Age, Number, Price and Seat number must be an integer", "Invalid Input",
										JOptionPane.CLOSED_OPTION);
							}

						}
					});
					employeeAddEdit.add(empeditapply);

				}

				if (adminPanelPane.getSelectedIndex() == 0) {
					employeeAddEdit.removeAll();
					mainTabs.setSelectedIndex(1);
					txtFrom = new JTextField();
					txtFrom.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtFrom.setText("From");
					txtFrom.setBounds(140, 94, 226, 30);
					employeeAddEdit.add(txtFrom);
					txtFrom.setColumns(10);

					txtTo = new JTextField();
					txtTo.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtTo.setText("To");
					txtTo.setBounds(140, 146, 226, 30);
					employeeAddEdit.add(txtTo);
					txtTo.setColumns(10);

					txtDay = new JTextField();
					txtDay.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtDay.setText("Day");
					txtDay.setBounds(140, 201, 226, 35);
					employeeAddEdit.add(txtDay);
					txtDay.setColumns(10);

					txtMonth = new JTextField();
					txtMonth.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtMonth.setText("Month");
					txtMonth.setBounds(140, 260, 226, 35);
					employeeAddEdit.add(txtMonth);
					txtMonth.setColumns(10);

					txtYear = new JTextField();
					txtYear.setFont(new Font("Tahoma", Font.PLAIN, 25));
					txtYear.setText("Year");
					txtYear.setBounds(140, 316, 226, 35);
					employeeAddEdit.add(txtYear);
					txtYear.setColumns(10);
					String[] hours = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
							"16", "17", "18", "19", "20", "21", "22", "23", "24" };
					JComboBox comboBox_3 = new JComboBox(hours);
					comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
					comboBox_3.setBounds(505, 112, 240, 42);
					employeeAddEdit.add(comboBox_3);
					String[] minutes = { "00", "30" };
					JComboBox comboBox_4 = new JComboBox(minutes);
					comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
					comboBox_4.setBounds(505, 222, 240, 42);
					employeeAddEdit.add(comboBox_4);

					JLabel lblNewLabel_3 = new JLabel("Hour");
					lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblNewLabel_3.setBounds(505, 74, 165, 20);
					employeeAddEdit.add(lblNewLabel_3);

					JLabel lblNewLabel_4 = new JLabel("Minute");
					lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblNewLabel_4.setBounds(505, 177, 165, 35);
					employeeAddEdit.add(lblNewLabel_4);

					String[] planeTypes = { "Passenger", "Cargo", "Private" };
					JComboBox comboBox_5 = new JComboBox(planeTypes);
					comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
					comboBox_5.setBounds(505, 345, 240, 42);
					employeeAddEdit.add(comboBox_5);

					String[] planeModels = { "Airbus", "Boeing", "Fokker" };
					JLabel lblNewLabel_5 = new JLabel("Plane Type");
					lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblNewLabel_5.setBounds(505, 301, 182, 34);
					employeeAddEdit.add(lblNewLabel_5);

					JComboBox comboBox_6 = new JComboBox(planeModels);
					comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
					comboBox_6.setBounds(505, 456, 240, 48);
					employeeAddEdit.add(comboBox_6);

					JLabel lblNewLabel_6 = new JLabel("Plane Model");
					lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblNewLabel_6.setBounds(505, 407, 226, 49);
					employeeAddEdit.add(lblNewLabel_6);

					JButton btnNewButton_3 = new JButton("Add");
					btnNewButton_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							if (database.checkInput(txtDay.getText()) && database.checkInput(txtMonth.getText())
									&& database.checkInput(txtYear.getText())) {

								Time time = new Time(Integer.parseInt((String) comboBox_3.getSelectedItem()),
										Integer.parseInt((String) comboBox_4.getSelectedItem()));
								Date date = new Date(Integer.parseInt(txtDay.getText()),
										Integer.parseInt(txtMonth.getText()), Integer.parseInt(txtYear.getText()));
								Flight newFlight = new Flight(flightData.size() + 1, txtFrom.getText(), txtTo.getText(),
										time, date, comboBox_5.getSelectedItem().toString(),
										comboBox_6.getSelectedItem().toString());
								if (!queue.enQueue(newFlight)) {
									JOptionPane.showMessageDialog(null, "", "Invalid Input", JOptionPane.CLOSED_OPTION);
								} else {
									flightData.add(newFlight);
									flightModelAdmin.addElement(newFlight.flightInfo());
									mainTabs.setSelectedIndex(3);
									adminPanelPane.setSelectedIndex(0);

								}

							} else {
								JOptionPane.showMessageDialog(null, "Day Month and Year must be an integer",
										"Invalid Input", JOptionPane.CLOSED_OPTION);
							}

						}
					});
					btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
					btnNewButton_3.setBounds(896, 222, 182, 59);
					employeeAddEdit.add(btnNewButton_3);

					JButton btnNewButton_4 = new JButton("Return");
					btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
					btnNewButton_4.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							mainTabs.setSelectedIndex(3);

						}
					});
					btnNewButton_4.setBounds(900, 400, 185, 60);
					employeeAddEdit.add(btnNewButton_4);

				}

			}
		});
		addButton.setBounds(955, 204, 133, 43);
		adminPanel.add(addButton);

		JPanel flight_add_edit = new JPanel();
		mainTabs.addTab("Flight add edit", null, flight_add_edit, null);

		JPanel userFlightsPanel = new JPanel();
		mainTabs.addTab("userFlights", null, userFlightsPanel, null);
		userFlightsPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1112, 616);
		userFlightsPanel.add(scrollPane);

		// BOOKING A TICKET

		JList userFlightList = new JList(userFlightModel);
		userFlightList.setFont(new Font("Arial", Font.BOLD, 16));
		scrollPane.setViewportView(userFlightList);

		JButton ticketBookButton = new JButton("Book a Ticket");
		ticketBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = mainTabs.getSelectedIndex();
				if (selected == 5) {
					int index = userFlightList.getSelectedIndex();
					String selectedFlight = userFlightModel.get(index).toString();
					String[] arr = selectedFlight.split(" ");
					int flightNumber = Integer.parseInt(arr[0]);
					mainTabs.setSelectedIndex(2);

					txtName = new JTextField();
					txtName.setText("Name");
					txtName.setBounds(87, 93, 193, 30);
					ticketBuy.add(txtName);
					txtName.setColumns(10);

					txtSurname = new JTextField();
					txtSurname.setText("Surname");
					txtSurname.setBounds(87, 133, 193, 28);
					ticketBuy.add(txtSurname);
					txtSurname.setColumns(10);

					txtAge = new JTextField();
					txtAge.setText("Age");
					txtAge.setBounds(87, 171, 193, 30);
					ticketBuy.add(txtAge);
					txtAge.setColumns(10);

					txtNumber = new JTextField();
					txtNumber.setText("Number");
					txtNumber.setBounds(87, 211, 193, 30);
					ticketBuy.add(txtNumber);
					txtNumber.setColumns(10);

					txtAddress = new JTextField();
					txtAddress.setText("Address");
					txtAddress.setBounds(87, 254, 193, 30);
					ticketBuy.add(txtAddress);
					txtAddress.setColumns(10);

					String[] passType = { "Business", "Economy", "First" };
					JComboBox comboBox_2 = new JComboBox(passType);
					comboBox_2.setBounds(87, 304, 193, 30);
					ticketBuy.add(comboBox_2);
					System.out.println(flightData.get(flightNumber - 1).flightInfo());

					JLabel lbl3 = new JLabel("First Class Seats");
					lbl3.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lbl3.setBounds(400, 364, 193, 30);
					ticketBuy.add(lbl3);

					int[] seatArr = flightData.get(flightNumber - 1).getBusinessSeats();

					String[] seatDisplay = new String[seatArr.length];
					for (int i = 0; i < seatDisplay.length; i++) {
						if (seatArr[i] == 0) {
							seatDisplay[i] = String.valueOf(i);
						} else {
							seatDisplay[i] = "Full";
						}
					}

					JComboBox seatBox = new JComboBox(seatDisplay);
					seatBox.setBounds(87, 394, 193, 30);
					ticketBuy.add(seatBox);

					JLabel lbl1 = new JLabel("Business Class Seats");
					lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lbl1.setBounds(87, 364, 193, 30);
					ticketBuy.add(lbl1);

					seatArr = flightData.get(flightNumber - 1).getFirstSeats();
					seatDisplay = new String[seatArr.length];
					for (int i = 0; i < seatDisplay.length; i++) {
						if (seatArr[i] == 0) {
							seatDisplay[i] = String.valueOf(i);
						} else {
							seatDisplay[i] = "Full";

						}
					}

					JComboBox seatBox1 = new JComboBox(seatDisplay);
					seatBox1.setBounds(400, 394, 193, 30);
					ticketBuy.add(seatBox1);

					JLabel lbl2 = new JLabel("Economy Class Seats");
					lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lbl2.setBounds(770, 364, 193, 30);
					ticketBuy.add(lbl2);
					seatArr = flightData.get(flightNumber - 1).getEconomySeats();
					seatDisplay = new String[seatArr.length];
					for (int i = 0; i < seatDisplay.length; i++) {
						if (seatArr[i] == 0) {
							seatDisplay[i] = String.valueOf(i);
						} else {
							seatDisplay[i] = "Full";
						}
					}

					JComboBox seatBox2 = new JComboBox(seatDisplay);
					seatBox2.setBounds(770, 394, 193, 30);
					ticketBuy.add(seatBox2);

					JButton btnNewButton_2 = new JButton("Book");
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Passenger newPassenger = new Passenger(txtName.getText(), txtSurname.getText(),
									Integer.parseInt(txtAge.getText()), Integer.parseInt(txtNumber.getText()),
									txtAddress.getText(), comboBox_2.getSelectedItem().toString(),
									passengerData.size() - 1);
							passengerData.add(newPassenger);
							if (comboBox_2.getSelectedItem().toString().equalsIgnoreCase("business")) {
								if (seatBox.getSelectedItem().toString().equalsIgnoreCase("full")) {
									JOptionPane.showMessageDialog(null, "Seat is already taken", "Invalid Input",
											JOptionPane.CLOSED_OPTION);
								} else {
									ticketData
											.add(new Ticket(100, Integer.parseInt(seatBox.getSelectedItem().toString()),
													ticketData.size() - 1, newPassenger, flightNumber));
									ticketModel.addElement(
											new Ticket(100, Integer.parseInt(seatBox.getSelectedItem().toString()),
													ticketData.size() - 1, newPassenger, flightNumber).toString());
									flightData.get(flightNumber - 1).addSeat("business",
											(int) seatBox.getSelectedItem());
								}
							} else if (comboBox_2.getSelectedItem().toString().equalsIgnoreCase("first")) {
								if (seatBox1.getSelectedItem().toString().equalsIgnoreCase("full")) {
									JOptionPane.showMessageDialog(null, "Seat is already taken", "Invalid Input",
											JOptionPane.CLOSED_OPTION);
								} else {
									ticketData.add(
											new Ticket(100, Integer.parseInt(seatBox1.getSelectedItem().toString()),
													ticketData.size() - 1, newPassenger, flightNumber));
									ticketModel.addElement(
											new Ticket(100, Integer.parseInt(seatBox1.getSelectedItem().toString()),
													ticketData.size() - 1, newPassenger, flightNumber).toString());
									flightData.get(flightNumber - 1).addSeat("first", (int) seatBox.getSelectedItem());
								}
							} else if (comboBox_2.getSelectedItem().toString().equalsIgnoreCase("economy")) {
								if (seatBox2.getSelectedItem().toString().equalsIgnoreCase("full")) {
									JOptionPane.showMessageDialog(null, "Seat is already taken", "Invalid Input",
											JOptionPane.CLOSED_OPTION);
								} else {
									ticketData.add(
											new Ticket(100, Integer.parseInt(seatBox2.getSelectedItem().toString()),
													ticketData.size() - 1, newPassenger, flightNumber));
									ticketModel.addElement(
											new Ticket(100, Integer.parseInt(seatBox2.getSelectedItem().toString()),
													ticketData.size() - 1, newPassenger, flightNumber).toString());
									flightData.get(flightNumber - 1).addSeat("economy",
											(int) seatBox.getSelectedItem());
								}
							}

							mainTabs.setSelectedIndex(0);

						}
					});
					btnNewButton_2.setBounds(648, 264, 216, 47);
					ticketBuy.add(btnNewButton_2);

				}

			}
		});
		ticketBookButton.setBounds(394, 644, 266, 46);
		userFlightsPanel.add(ticketBookButton);

	}
}
