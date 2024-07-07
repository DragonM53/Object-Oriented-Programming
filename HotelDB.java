/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
   import java.time.LocalDate;
import java.util.*;

//This class is implemented as a Singleton
public class HotelDB {
    private static int currBookNo = 0;  //Maintains Last Used Booking Number
	
	//Arraylists
    private static ArrayList<RoomType> rtLst = new ArrayList<RoomType>();
    private static ArrayList<Room> rmLst = new ArrayList<Room>();
    private static ArrayList<Guest> gLst = new ArrayList<Guest>();
    private static ArrayList<Booking> bkLst = new ArrayList<Booking>();
    
    private static ArrayList<SystemUser>userLst= new ArrayList<SystemUser>();
	
    private static HotelDB instance = null;  // static instance of the class
    
    private HotelDB() {}; //Prevents instantiation outside this class
	
    //Method to get the single instance of the class
	public static HotelDB getInstance() {
        if (instance == null) {  //If instance not yet created, create it.
            instance = new HotelDB();
        }
        return instance;
    }

    //Getters

    public static ArrayList<Guest> getgLst() {   //Guest list
        return gLst;
    }
	
    public static ArrayList<RoomType> getRtLst() {  //RoomType list
        return rtLst;
    }

    public static ArrayList<Room> getRmLst() {  //Room list
        return rmLst;
    }
	
    public static ArrayList<Booking> getBkLst() {  //Booking list
        return bkLst;
    }
    
    public static ArrayList<SystemUser> getUserLst() {  //SystemUser list
        return userLst;
    }

    public static int getCurrBookNo() {  //Getter for Last used Booking Number
        return currBookNo;
    }

    public static void setCurrBookNo(int currBookNo) {  //Setter for Last used Booking Number
        HotelDB.currBookNo = currBookNo;
    }    
	
	public static void appendToRoomLst(Room rm){  //Add a Room object to HotelDB Room array list
		rmLst.add(rm);
	}	
	
    public static void appendToBookLst(Booking bk){  //Add a Booking object to HotelDB Booking array list
		bkLst.add(bk);
	}	
	
	public static void appendToGuestLst(Guest gst){  //Add a Guest object to HotelDB Guest array list
		gLst.add(gst);
	}
	
    public static Guest findGuest (String inputIDNo, Boolean isLocal) {  //Searches for Guest by IDNo and isLocal flag
        Guest foundGuest = null;
        for (int j = 0; j < gLst.size(); j++) {
            if ((gLst.get(j)).getIdNo().equals(inputIDNo) && (isLocal == (gLst.get(j)).getIsMalaysian())) {
                foundGuest = gLst.get(j);
                break;
            } else {
                foundGuest = null;
            }
        }
        return foundGuest;
    }
	
    public static void increaseBookNo (){  //Increments Last Used Booking Number by 1
        HotelDB.currBookNo = currBookNo+1;
    }
    
	
	public static void loadDB(){  //At application startup, created selected objects and arraylists
	            
            //create systemUser objects
            SystemUser su1 = new SystemUser("Martin", "abc123");
            SystemUser su2 = new SystemUser("Ryan", "abc123");
        SystemUser su3 = new SystemUser("ZeeLin", "abc123");
        SystemUser su4 = new SystemUser("Starla", "abc123");
        SystemUser su5 = new SystemUser("Jake", "abc123");
        SystemUser su6 = new SystemUser("XiaoMing", "abc123");
        SystemUser su7 = new SystemUser("Ben", "abc123");
        SystemUser su8 = new SystemUser("Oliver", "abc123");
        SystemUser su9 = new SystemUser("AhBing", "abc123");
        SystemUser su10 = new SystemUser("Felix", "abc123");
        SystemUser su11 = new SystemUser("Pedro", "abc123");
        SystemUser su12 = new SystemUser("Sam", "abc123");
        SystemUser su13 = new SystemUser("Nelson", "abc123");
        SystemUser su14 = new SystemUser("Roger", "abc123");
        SystemUser su15 = new SystemUser("Xavier", "abc123");
        SystemUser su16 = new SystemUser("Karen", "abc123");
        SystemUser su17 = new SystemUser("Garfield", "abc123");
        SystemUser su18 = new SystemUser("Ray", "abc123");
        SystemUser su19 = new SystemUser("Vivian", "abc123");
        SystemUser su20 = new SystemUser("Adrian", "abc123");
        
        userLst.add(su1);
        userLst.add(su2);
        userLst.add(su3);
        userLst.add(su4);
        userLst.add(su5);
        userLst.add(su6);
        userLst.add(su7);
        userLst.add(su8);
        userLst.add(su9);
        userLst.add(su10);
        userLst.add(su11);
        userLst.add(su12);
        userLst.add(su13);
        userLst.add(su14);
        userLst.add(su15);
        userLst.add(su16);
        userLst.add(su17);
        userLst.add(su18);
        userLst.add(su19);
        userLst.add(su20);
	    //Arraylists associated with each Room Type
		ArrayList<Room> roomList1 = new ArrayList<Room>();
        ArrayList<Room> roomList2 = new ArrayList<Room>();
        ArrayList<Room> roomList3 = new ArrayList<Room>();
        ArrayList<Room> roomList4 = new ArrayList<Room>();
        ArrayList<Room> roomList5 = new ArrayList<Room>();
		
		ArrayList<Booking> guestBookList = new ArrayList<Booking>();
		ArrayList<RoomBooking> roomBookList = new ArrayList<RoomBooking>();
		ArrayList<Payment> payList = new ArrayList<Payment>();
		
		//Create RoomType objects
		RoomType rt1 = new RoomType("STD", "STANDARD", "SINGLE", 100.00, 1, roomList1);
		RoomType rt2 = new RoomType("DLX", "DELUXE", "QUEEN ", 150.00, 2, roomList2);
		RoomType rt3 = new RoomType("TRP", "TRIPLE", "KING  ", 200.00, 3, roomList3);
		RoomType rt4 = new RoomType("FAM", "FAMILY", "QUAD  ", 250.00, 4, roomList4);
		RoomType rt5 = new RoomType("SUI", "SUITE", "FIVE  ", 300.00, 5, roomList5);
		
		//Create the Room Type arraylist1
		rtLst.add(rt1);
		rtLst.add(rt2);
		rtLst.add(rt3);
		rtLst.add(rt4);
		rtLst.add(rt5);
		
		//Create 2 Rooms with RoomType "SUI" (assigning Room Numbers 1 and 2 respectively)
		Room rm1 = new Room(1, 5, "River View", rt5, roomBookList);
		Room rm2 = new Room(2, 5, "River View", rt5, roomBookList);
		//Add these 2 rooms to the 'SUI' room type object's rmLst arraylist
		rt5.addToRmLst(rm1);
		rt5.addToRmLst(rm2);			
		//At the same time, add also to the HotelDB Room arraylist
		HotelDB.appendToRoomLst(rm1);
		HotelDB.appendToRoomLst(rm2);
		
		//Create the rest of the Rooms for the other 4 Room Types
		for (int i=3; i <= 7; i++) { //Room Type FAM
			Room rm3 = new Room(i, 5, "River View", rt4, roomBookList);
			HotelDB.appendToRoomLst(rm3);
            rt4.addToRmLst(rm3);
		}
		for (int i=8; i <= 10; i++) { //Room Type TRIPLE
			Room rm4 = new Room(i, 4, "Town View", rt3, roomBookList);
			HotelDB.appendToRoomLst(rm4);
            rt3.addToRmLst(rm4);
		}
		for (int i=11; i <= 25; i++) { //Room Type DLX
			Room rm5 = new Room(i, 3, "Town View", rt2, roomBookList);
			HotelDB.appendToRoomLst(rm5);
            rt2.addToRmLst(rm5);
		}	
		for (int i=26; i <= 40; i++) { //Room Type STD
			Room rm6 = new Room(i, 4, "Town View", rt1, roomBookList);
			HotelDB.appendToRoomLst(rm6);
            rt1.addToRmLst(rm6);
		}
		
		//Create Guest1 who is a non-member
		Address a1 = new Address("007 Oxford Street", "London", "Greater London", 77777, "UK");
		Guest g1 = new Guest("James Bond", "007", "jbond@email.com", (long)1234567, a1, false, false, guestBookList);
		gLst.add(g1);
		
		//Create Guest2 who is a member
		Address a2 = new Address("008 Regent Street", "London", "Greater London", 88888, "UK");
		LocalDate mjDate = LocalDate.parse("2020-01-02");
		MemberGuest mg2 = new MemberGuest(100, mjDate, "Sherlock Holmes", "008", "sherlock@email.com", (long)1234567, a2, true, true, guestBookList);
		gLst.add(mg2);
		
		//Create Staff w/o address
		LocalDate sjDate = LocalDate.parse("2018-05-09");
				
		//Create 2 sets of Booking and RoomBooking objects for the 2 Rooms above with Room Type SUI
		int newBkNo = currBookNo + 1;
		Booking b1 = new Booking(newBkNo, LocalDate.parse("2023-05-01"), 'R', mg2, null, roomBookList, payList);  //create 1st Booking object
		RoomBooking rb1 = new RoomBooking(LocalDate.parse("2023-06-01"), LocalDate.parse("2023-06-05"), b1, rm1, 'R');  //create Room Booking object
		currBookNo += 1;  //Increment HotelDB Last Used Booking Number
		ArrayList<RoomBooking> rbl1 = new ArrayList<RoomBooking>();  //Create temporary RoomBooking arraylist
		rbl1 = b1.getRmBkLst();  //Get the RoomBooking array list that belongs to the Booking object b1
		rbl1.add(rb1);  //Add the RoomBooking object to it
		ArrayList<RoomBooking> rmrbl1 = new ArrayList<RoomBooking>(); //Create temporary RoomBooking arraylist
		rmrbl1 = rm1.getRmBkLst(); //Get the RoomBooking array list that belongs to the Room object rm1
		rmrbl1.add(rb1);  //Add the RoomBooking object to it
		ArrayList<Booking> bookinglist = new ArrayList<Booking>();  //Create temporary Booking arraylist
		bookinglist = g1.getGuestBookLst();  //Get the Booking array list that belongs to the Guest object g1
		bookinglist.add(b1);  //Add the Booking object to it
		bkLst.add(b1);  //Add to HotelDB booking array list
		
		//Repeat above steps for 2nd Booking
		newBkNo = currBookNo + 1;
		Booking b2 = new Booking(newBkNo, LocalDate.parse("2023-05-15"), 'R', mg2, null, roomBookList, payList);
		RoomBooking rb2 = new RoomBooking(LocalDate.parse("2023-06-09"), LocalDate.parse("2023-06-11"), b2, rm2, 'R');		
		currBookNo += 1;		
		ArrayList<RoomBooking> rbl2 = new ArrayList<RoomBooking>();
		rbl2 = b2.getRmBkLst();
		rbl2.add(rb2);		
		bookinglist = new ArrayList<Booking>();
		bookinglist = mg2.getGuestBookLst();
		bookinglist.add(b2);
		bkLst.add(b2);
	}
	
	//This method is only used during the Testing process to see if array lists n objects get updated correctly
	public static void displayLoaded () {
		for (int i = 0; i < rtLst.size(); i++) {
			RoomType rtyp = (rtLst.get(i));
			System.out.println("Room Type: " + rtyp.getRoomTypeCode());
			ArrayList<Room> roomList = rtyp.getRmLst();
			for (int j = 0; j < roomList.size(); j++) {
				Room room = roomList.get(j);
				System.out.println("Room No: " + room.getRoomNo() + " " + room.getView());
			}
        }
		for(int i = 0; i < gLst.size(); i++) {   
			System.out.println("Guest: " + (gLst.get(i)).getName() + " " + (gLst.get(i)).getIsMember());
		}
		for(int i = 0; i < rmLst.size(); i++) {   
			Room r = rmLst.get(i);
			System.out.println("Room No: " + r.getRoomNo() + " " + r.getView());
		}		
		for (int i=0; i < bkLst.size(); i++) {
			Booking b = bkLst.get(i);
			System.out.println("Booking No: " + Integer.toString(b.getBookingNo()) );
		}
	}

}