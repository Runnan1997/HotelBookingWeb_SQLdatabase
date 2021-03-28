<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>
</head>
<body>

	<%
		String CustName = (String) request.getAttribute("CustName");
	%>
	<form method="post" action="roombook">
		<h4>
			Welcome,
			<%=CustName%><h4>
				<h4>Here are the room(s) you booked</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("bookedRooms");
						ArrayList<Room> broomList = null;
						if (obj1 instanceof ArrayList) {
							broomList = (ArrayList<Room>) obj1;
						}
						if (broomList != null) {
							String x = "";
							for (Room room : broomList) {
								if(room.isExtended()==true){
									x = "Yes";
								}
								else{x = "No";}
								String roominfo1 = "Room Number: "+room.getRoom_no();
								
								//Need to implement get hotel name by ID
								String roominfo2 = "Hotel: " + room.getHotel_ID();
								String roominfo3 = "Price: " + room.getPrice();
								String roominfo4 = "Room Capacity: " + room.getCapacity();	
								String roominfo5 = "This room is extenable: " + x;
								String roominfo6 =  "View: " + room.getView();
								String roominfo7 = "Problems: " + room.getProblem();
								String roominfo8 = "Amenities: " + room.getAmenities();
								%>
					<li><%=roominfo1%></li>
					<li><%=roominfo2%></li>
					<li><%=roominfo3%></li>
					<li><%=roominfo4%></li>
					<li><%=roominfo5%></li>
					<li><%=roominfo6%></li>
					<li><%=roominfo7%></li>
					<li><%=roominfo8%></li>
					<p><%="\n"%></p>
					<%
						}
						}
					%>
				</ul>
				<input type="hidden" name="custName" value="<%=CustName%>" />
				<form method="post" action="customerSelecting">
				<h2>Customer Select</h2>
				Choose capacity: 
				<select name = "capacity">
					<%
						Object o = request.getAttribute("allRooms");
						ArrayList<Room> rList = null;
						if (o instanceof ArrayList) {
							rList = (ArrayList<Room>) o;
						}
						if (rList != null) {
							for (Room room : rList) {
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=room.getCapacity()%></option>

					<%
						}
						}
					%>
				</select> 
				
				Choose price: 
				<select name = "price">
					<%
						Object ob = request.getAttribute("allRooms");
						ArrayList<Room> rmList = null;
						if (ob instanceof ArrayList) {
							rmList = (ArrayList<Room>) ob;
						}
						if (rmList != null) {
							for (Room room : rmList) {
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=room.getPrice()%></option>
					<%
						}
						}
					%>
				</select> 
				
				<h4>Here are available rooms</h4>

				<select name = "roomno">
					<%
						Object obj = request.getAttribute("allRooms");
						ArrayList<Room> roomList = null;
						if (obj instanceof ArrayList) {
							roomList = (ArrayList<Room>) obj;
						}
						if (roomList != null) {
							for (Room room : roomList) {
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=room.getRoom_no()%></option>

					<%
						}
						}
					%>
				</select> 
				
				
				<button type="submit" value="submit">continue</button>
	</form>


</body>
</html>