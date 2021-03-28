package eHotel.entities;

public class Room {
	
	private String room_no;
	private String room_status;
	private String customer_ssn;
	private Integer hotel_ID;
	private Integer price;
	private String capacity;
	private boolean is_extendable;
	private String view;
	private String amenities;
	private String problem;
	
	
	public Room() {
		
	}
	
	public Room(String room_no, String room_status, String customer_ssn, Integer hotel_ID,Integer price, String capacity, boolean is_extendable, String view, String amenities, String problem) {
		this.room_no = room_no;
		this.room_status = room_status;
		this.customer_ssn = customer_ssn;
		this.amenities = amenities;
		this.capacity = capacity;
		this.hotel_ID = hotel_ID;
		this.is_extendable = is_extendable;
		this.price = price;
		this.problem = problem;
		this.view = view;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getRoom_status() {
		return room_status;
	}

	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}

	public String getCustomer_ssn() {
		return customer_ssn;
	}

	public void setCustomer_ssn(String customer_ssn) {
		this.customer_ssn = customer_ssn;
	}
	
	public Integer getHotel_ID() {
		return hotel_ID;
	}

	public void setHotel_ID(Integer hotel_ID) {
		this.hotel_ID = hotel_ID;
	}
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public boolean isExtended() {
		return is_extendable;
	}

	public void setExtended(boolean is_extendable) {
		this.is_extendable = is_extendable;
	}
	
	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
	
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	
	
//	public void RoomPrint() {
//		System.out.println("Hotel ID is:" + hotel_ID);
//		System.out.println("Room Number is: " + room_no);
//	}
	
	

}
