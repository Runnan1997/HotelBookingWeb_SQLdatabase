package eHotel.connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import eHotel.entities.Room; 


public class  PostgreSqlConn{
	
		Connection db = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Statement st = null;
	    String sql;


		public void getConn(){
			
			try {
				
				Class.forName("org.postgresql.Driver"); 
								
				db = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/group_b02_g11", "hjia088", "Z5BUtzJxzQ");
															
			}catch(Exception e) {
				System.out.print("error catched");
			}
						
		}
		
		public void closeDB() {
				try {
					if(rs != null){
						rs.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(st!=null){
						st.close();
					}
					if(db!=null){
						db.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		
		public String getpwdbyUname(String param){
			getConn();

			String pwd = "";
			
	        try{
	            ps = db.prepareStatement("select employee_password from ehotel.employee where fullname=?");
	            
	            ps.setString(1, param);	
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd = rs.getString("employee_password");
				}
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return pwd;       
	    }
		
		
		public String[] getuserinforbycustSSN(String param){
			getConn();

			String[] pwd = new String[2];
			
	        try{
	            ps = db.prepareStatement("select * from ehotel.customer where customer_sin=?");
	            
	            ps.setString(1, param);	               
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd[0] = rs.getString("fullname");
					pwd[1] = rs.getString("customer_password");
				}
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return pwd;       
	    }
		
		public boolean insertNewCustomer(String[] param){
			getConn();

			
	        try{
	        	st = db.createStatement();
	        	sql = "insert into ehotel.customer values('"+param[0]+"','"+param[1]+"','"+param[2]+"','"+param[3]+"','"+param[4]+"','"+param[5]+"')";
	        	System.out.print(sql);
	            
	            st.executeUpdate(sql);
	            
	            return true;

	        }catch(SQLException e){
	            e.printStackTrace();
	            return false;
	        }finally {
	        	closeDB();
	        }	       
	    }
		
		public  ArrayList<Room> getAllAvailRooms(){
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			
			try {
				ps = db.prepareStatement("select * from ehotel.room where status='available'" );
				rs = ps.executeQuery();
				while(rs.next()){
					String room_no = rs.getString("roomid");
					String room_status = rs.getString("status");
					String customer_sin = rs.getString("customer_sin");
					String capacity = rs.getString("capacity");
					Integer hotel_ID = rs.getInt("hotel_ID");
					Integer price = rs.getInt("price");
					boolean is_extendable = rs.getBoolean("extenable");
					String view = rs.getString("room_view");
					String problem = rs.getString("problem");
					String amenities = rs.getString("amenities");
					
					Room room = new Room(room_no, room_status, customer_sin, hotel_ID, price, capacity,is_extendable, view, amenities,problem);
					Rooms.add(room);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;
			
		}
		
		public  ArrayList<Room> getbookedRooms(String custSSN){
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			
			try {
				ps = db.prepareStatement("select * from ehotel.room where customer_sin='"+custSSN+"'");
				System.out.println(ps);
				rs = ps.executeQuery();
				while(rs.next()){
					String room_no = rs.getString("roomid");
					String room_status = rs.getString("status");
					String customer_sin = rs.getString("customer_sin");
					String capacity = rs.getString("capacity");
					Integer hotel_ID = rs.getInt("hotel_ID");
					Integer price = rs.getInt("price");
					boolean is_extendable = rs.getBoolean("extenable");
					String view = rs.getString("room_view");
					String problem = rs.getString("problem");
					String amenities = rs.getString("amenities");
					
					Room room = new Room(room_no, room_status, customer_sin, hotel_ID, price, capacity,is_extendable, view, amenities,problem);
					Rooms.add(room);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;
			
		}
		
		public String bookRoom(String custName, String roomno){
			getConn();
			String custSSN="";
			
	        try{
	        	
	        	ps = db.prepareStatement("select customer_sin from ehotel.customer where fullname='"+custName+"'");
				rs = ps.executeQuery();
				
				while(rs.next()){
					custSSN = rs.getString("customer_sin");
				}
				
				
	        	st = db.createStatement();
	        	sql = "update ehotel.room set customer_sin='"+custSSN+"', status='booked' where roomid='"+roomno+"'";
	        	System.out.println(sql);
	            st.executeUpdate(sql);
	            
	            
	            return custSSN;

	        }catch(SQLException e){
	            e.printStackTrace();
	            return "";	 
	        }finally {
	        	closeDB();
	        }
			      
	    }
		
		
		
		
		
//		public static void main(String []args) {
//			PostgreSqlConn con = new PostgreSqlConn();
//			con.getConn();
//			String pwd = con.getpwdbyUname("8366341");
//			
//			System.out.println(pwd);
//				
//			
//			
//		}

		
	}

