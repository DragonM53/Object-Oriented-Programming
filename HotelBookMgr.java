/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelBookMgr {  //Implemented as singleton
    private static Scanner scanner = new Scanner(System.in);
    private static boolean quitBooking;
    private HotelBookMgr() {};
    // static instance of the class
    private static HotelBookMgr instance = null;
    // method to get the instance of the class
    public static HotelBookMgr getInstance() {
        if (instance == null) {
            instance = new HotelBookMgr();
        }
        return instance;
    }
        
   public static void showBookingSubMenu() {
        quitBooking = false;
        System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
        System.out.printf("%45s%n", "Booking Sub Menu");
        System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
        System.out.print("\t\t\t\t1: New Booking\n\t\t\t\t2: Cancel Booking\n\t\t\t\t3: Check In\n\t\t\t\t4: Check Out\n\t\t\t\t5: Exit\n\n");
  	    while (!quitBooking) { 
            try{                
                System.out.print("\t\t\t--> Please enter an option: ");
                int bookOpt = scanner.nextInt();
                procBookingSubMenuOption(bookOpt); 
                quitBooking = true;
            }catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("\t\t\t(!)Error! Please enter an integer");
            }         
	    }
    }

    private static void procBookingSubMenuOption(int bookOpt) {
      if(bookOpt == 1) 
          newBooking();
      else if (bookOpt == 2) 
          cancelBooking();
      else if (bookOpt == 3) 
          checkIn();
      else if (bookOpt == 4) 
          checkOut();
      else if (bookOpt == 5) {
          quitBooking();
      }
      else
         System.out.println("Invalid Option");
   }
   
   private static void newBooking() {
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       System.out.printf("%45s%n", "New Booking");
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       registerGuest();        
   }
   //for validation
   
    
    private static Boolean validateEmail(String input) {
        String regPat = "^[A-Za-z0-9+_.-]+@(.+)$"; 
        Pattern pattern = Pattern.compile(regPat); 
        Matcher matcher = pattern.matcher(input);  
        return matcher.matches();
    }
    
    private static int checkContactNoLength(long Input){
        long num = Input; // a temporary variable to perform divisions later on to count number of digits in contact number
        int count = 0;
        do // counts the number of digits in contact number
        {
            num /= 10;
            count++;
        } while (num != 0);    
        
        return count;    
    }
   
   
   
   
   private static void registerGuest() {
    //For Guest & Member Registration
    Boolean valid = false;
    Boolean isMsiaBool = false;
    char isMsia = 'N';
    LocalDate today = LocalDate.now();
    
    
    Boolean isMemberBool = false;
    char isMember = 'N';
    
    String IDType;
    String IDNo;    
    
    //String name, String idNo, String emailAddress, Long contactNo, Address address, Boolean isMember, Boolean isMalaysian
    //String street, String city, String state, int postalCode, String country
    //User input
    String guestNameInput = "";
    String guestIdNoInput = "";
    String emailInput = "";
    char isMemberInput;
    char isMsiaInput;
    long contactNumInput = 0;
    String streetInput;
    String cityInput;
    String stateInput;
    int postInput;
    String countryInput;
    Address addressInput = null;
    
    //for validation
    Boolean validEmail = false;
    int contactNumLength = 0;
    
    
    //MemberGuest and Guest objects
    MemberGuest newMember;
    Guest newGuest;
    
    //Which object to return
    Guest guestBooking = null;
    
    Boolean registerNewGuest = true;
    //
    
    //Booking Details
    LocalDate checkInDate = null;
    LocalDate checkOutDate = null;
    String dateInput;
    int numPeople;
    long numDays;
    Booking newBooking;
    String roomTypeCode;
    ArrayList<String> roomTypeCodes = new ArrayList<String>();
    Boolean validRTC = false;
    int noRooms;
    RoomType interestedRt = null;
    int availRmCtr = 0;
    Boolean conflictFound;
    
    char proceed;
    char firstTime = 'Y';
    Booking bk = null;
    char retry = ' ';
    char exitBooking = 'N';
	
	ArrayList<Booking> emptyBkLst = new ArrayList<Booking>();   
	ArrayList<RoomBooking> emptyRmBkLst = new ArrayList<RoomBooking>();  
	ArrayList<Payment> emptyPayLst = new ArrayList<Payment>();
        
	Address emptyAdr = new Address(null,null, null, 0, null);	
	
    //1. Guest Registration
    
    do {
       try {
           System.out.print("--> Is the guest Malaysian (y/n)?: ");
           isMsia = scanner.next().charAt(0);
           isMsia = Character.toUpperCase(isMsia);
           if (isMsia == 'Y' || isMsia == 'N') {
               valid = true;
           } else {
               valid = false;
               System.out.println("(!)Error! Please enter Y, y, N or n");
           }
       } catch (InputMismatchException e){
           scanner.nextLine();
           System.out.println("(!)Error! Please enter an integer");           
       }      
    }while(valid == false);
    
    if (isMsia == 'Y') {
        IDType = "IC Number: ";
        isMsiaBool = true;
    } else {
        IDType = "Passport Number: ";
        isMsiaBool = false;
    }
    scanner.nextLine();
    
    System.out.print("--> Please enter guest's " + IDType);
    IDNo = scanner.nextLine();
    Guest guestFound = HotelDB.findGuest(IDNo, isMsiaBool);
    
    
    //if guests already exists
    if (guestFound != null) {
        System.out.println("\n\t\t\tGuest exists in the system!");
        System.out.println("\t\t\tGuest Name : " + guestFound.getName());
        System.out.println("\t\t\tID Number  : " + guestFound.getIdNo());
        System.out.println("\t\t\tEmail      : " + guestFound.getEmailAddress());
        System.out.println("\t\t\tContact No : " + guestFound.getContactNo());
        if (guestFound.getIsMember() == true) {
            isMember = 'Y';
            isMemberBool = true;
        }
        else
            isMember = 'N';
        System.out.println("\t\t\tIs Member  : " + isMember + "\n");
        
    } else { //if guest is new
        System.out.println("\n\t\t\tGuest not found in the system!");
        System.out.println("Please enter the guest details below:");
        
        System.out.print("--> Enter guest name: ");
        guestNameInput = scanner.nextLine(); 
          
        
        System.out.print("--> Enter the Guest's ID Number: ");
        guestIdNoInput = scanner.nextLine();        
        
        do {
            System.out.print("--> Enter email address: ");
            emailInput = scanner.nextLine();
            validEmail = validateEmail(emailInput);
            
            if (validEmail == false) {
                System.out.println("(!)Error! Please enter a valid email!");             
            }            
        } while(validEmail == false);
        
        do {
            System.out.print("--> Enter contact number: ");
            contactNumInput = scanner.nextLong();
            scanner.nextLine();
            contactNumLength = checkContactNoLength(contactNumInput);
            
            if (contactNumLength > 20) {
                System.out.println("(!)Error! Contact Number is too long!");       
            }            
        } while (contactNumLength > 20);
        
        
        
        
        
        //String street, String city, String state, int postalCode, String country
        System.out.print("--> Enter street address: ");
        streetInput = scanner.nextLine();
        System.out.print("--> Enter city          : ");
        cityInput = scanner.nextLine();
        System.out.print("--> Enter state         : ");
        stateInput = scanner.nextLine();
        System.out.print("--> Enter postal code   : ");
        postInput = scanner.nextInt();
        scanner.nextLine();
        System.out.print("--> Enter country       : ");
        countryInput = scanner.nextLine();
        addressInput = new Address(streetInput, cityInput, stateInput, postInput, countryInput);
    }
    //End of Guest Registration
    
    //2. Member Registration
    
    if (isMember == 'N') {
        System.out.print("--> Does Guest want to be a Member (y/n)?: ");
        isMemberInput = scanner.next().charAt(0);
        scanner.nextLine();
        if (guestFound == null) {
            if (Character.toUpperCase(isMemberInput) == 'Y') {
                newMember = new MemberGuest(0, today, guestNameInput, guestIdNoInput, emailInput, contactNumInput, addressInput,true , isMsiaBool, emptyBkLst);
                (HotelDB.getgLst()).add(newMember);  
                guestBooking = newMember;
            } else {
            //String name, String idNo, String emailAddress, Long contactNo, Address address, Boolean isMember, Boolean isMalaysian
                newGuest = new Guest(guestNameInput, guestIdNoInput, emailInput, contactNumInput, addressInput, false, isMsiaBool, emptyBkLst);
                (HotelDB.getgLst()).add(newGuest);  
                guestBooking = newGuest;
            }       
            
        } else {
            if (Character.toUpperCase(isMemberInput) == 'Y') {
                newMember = new MemberGuest(0, today, guestFound.getName(), guestFound.getIdNo(), guestFound.getEmailAddress(), guestFound.getContactNo(), guestFound.getAddress(), true, isMsiaBool, guestFound.getGuestBookLst());
                (HotelDB.getgLst()).add(newMember);
                (HotelDB.getgLst()).remove(guestFound);                              
            } 
            guestBooking = guestFound;            
        }
    } else {
        guestBooking = guestFound;
    }
    
    //End of member registration
    
    
	//Loop until user requested to exit
    while (exitBooking == 'N') {
      
    
      //3. Get Booking Requirements
      
      System.out.println("[These are the Room Types that can be Selected]\n");
      System.out.printf("%30s  %10s  %6s  %4s  %10s%n", "Room Type Name", "Room Type Code", "Bed Type", "Price (RM)", "Max Occupants");
      System.out.printf("%30s  %10s  %8s  %4s  %10s%n", "--------------", "--------------", "--------", "----------", "-------------");
    
    
      for (int i = 0; i < (HotelDB.getRtLst()).size(); i++) {
           RoomType roomTypeItem = (HotelDB.getRtLst()).get(i);
           System.out.printf("%16s%-10s%10s%6s%12s\t%.2f\t\t%1s%n", "", roomTypeItem.getRoomTypeName(), roomTypeItem.getRoomTypeCode(), " ",roomTypeItem.getBedType(), roomTypeItem.getRoomPrice(), roomTypeItem.getMaxOccupants());
           roomTypeCodes.add(roomTypeItem.getRoomTypeCode());
      }    
      System.out.println();
    
      //Get Room Type Code
      System.out.println("\nPlease enter the booking requirements:");
      do {
         System.out.print("--> Enter desired Room Type Code: ");
         roomTypeCode = scanner.nextLine();
         roomTypeCode = roomTypeCode.toUpperCase();
         for (int j = 0; j < roomTypeCodes.size(); j++) {
              if (((roomTypeCode).toUpperCase()).equals(roomTypeCodes.get(j))) {
                   validRTC = true;
                   break;
               } 
          }
          if (validRTC == false) {
               System.out.println("(!)Error! Please enter a valid room type code!"); 
          }
       } while (validRTC != true);    
    
       //Get number of rooms1
    
       do {
          System.out.print("--> Enter the number of rooms for the Room Type: ");
          noRooms = scanner.nextInt();
          if (noRooms <= 0) {
              System.out.println("(!)Error! Please enter a valid number!"); 
          }      
       } while (noRooms <= 0);
    
       //Get the interested Room Type Code
       for (int i = 0; i < (HotelDB.getRtLst()).size(); i++) {
          if (((HotelDB.getRtLst()).get(i)).getRoomTypeCode().equals(roomTypeCode.toUpperCase())){
             interestedRt = (HotelDB.getRtLst()).get(i);
             break;            
          }   
       }
    
       //Enter check in & check out dates
    
       DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
       scanner.nextLine();
       Boolean expInDate = false;
       Boolean expOutDate = false;
       
       
    
       do {        
          do {
              try {
                  System.out.print("--> Enter Check In Date (dd-mm-yyyy): ");
                  dateInput = scanner.nextLine();
                  checkInDate = LocalDate.parse(dateInput, format); 
                  expInDate = true;
              } catch (DateTimeParseException e) {
                  System.out.println("(!)Error! Invalid Date!"); 
                  expInDate = false;
              
              }              
          } while (expInDate == false);
          
          do {
              try {
                  System.out.print("--> Enter Check Out Date (dd-mm-yyyy): ");
                  dateInput = scanner.nextLine();
                  checkOutDate = LocalDate.parse(dateInput, format);  
                  expOutDate = true;
              } catch (DateTimeParseException e) {
                  System.out.println("(!)Error! Invalid Date!"); 
                  expOutDate = false;                  
              }  
          } while(expOutDate == false);         
                 
         
          if (checkInDate.isBefore(today) || checkOutDate.isBefore(today) || checkOutDate.isEqual(today) || checkOutDate.isEqual(checkInDate) || checkOutDate.isBefore(checkInDate)) {
              System.out.println("(!)Error! Please enter valid Check in and Check out Dates!"); 
          }
       } while (checkInDate.isBefore(today) || checkOutDate.isBefore(today) || checkOutDate.isEqual(today) || checkOutDate.isEqual(checkInDate) || checkOutDate.isBefore(checkInDate));   
       
       // = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
       ArrayList<Room> rmLst = new ArrayList<Room>();
       rmLst = interestedRt.getRmLst();
     
       ArrayList<RoomBooking> rmBkLst = new ArrayList<RoomBooking>();
       RoomBooking rmBooking;
       ArrayList<Room> availRmLst = new ArrayList<Room>();
      
       System.out.print("Size : " + rmLst.size());
       for (int k = 0; k < rmLst.size();k++) {
         conflictFound = false;
         rmBkLst = rmLst.get(k).getRmBkLst();
         for (int l = 0; l < rmBkLst.size() ; l++) {
                rmBooking = rmBkLst.get(l);
                if (rmBooking.getRmBookStatus() == 'I' || rmBooking.getRmBookStatus() == 'R') {
				   //If any of the conditions is met, the Room being checked is not available so stop and proceed to next room
                   if ((checkOutDate.isAfter(rmBooking.getCheckInDt())  && ( checkOutDate.isBefore(rmBooking.getCheckOutDt()) || checkOutDate.isEqual(rmBooking.getCheckOutDt()) )) ||  ((checkInDate.isAfter(rmBooking.getCheckInDt()) || checkInDate.isEqual(rmBooking.getCheckInDt())) &&  checkInDate.isBefore(rmBooking.getCheckOutDt()))   ||  (checkInDate.isBefore(rmBooking.getCheckInDt())     ||     checkInDate.isEqual(rmBooking.getCheckInDt()))  &&  (checkOutDate.isAfter(rmBooking.getCheckOutDt())   ||   checkOutDate.isEqual(rmBooking.getCheckOutDt()))) {
                        conflictFound = true;
                        break;                                             
                    }
                    
                }
         }
         if (conflictFound == false) {
            //System.out.println("Avail here");
            availRmLst.add(rmLst.get(k));
            availRmCtr++;
            if (availRmCtr == noRooms) {
                break;
            }    
         }
      }
    
      if (availRmCtr < noRooms) {
        System.out.print("Only " + availRmCtr + " Rooms of Room Type " + roomTypeCode + " available to be booked. Proceed to book (Y/N)?: ");
        proceed = scanner.next().charAt(0);
        if (Character.toUpperCase(proceed) == 'Y') {
            if (firstTime == 'Y') {
                HotelDB.increaseBookNo();
                bk = new Booking((HotelDB.getCurrBookNo()), today, 'R', guestBooking, null , emptyRmBkLst,emptyPayLst);
                guestBooking.appendToGuestBookLst(bk);
                firstTime = 'N';
                HotelDB.setCurrBookNo(HotelDB.getCurrBookNo()+1);
	            HotelDB.getBkLst().add(bk);
            }
            String displayInDate = checkInDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            String displayOutDate = checkOutDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            
            for (int m = 0; m < availRmLst.size(); m++) {
            //LocalDate checkInDt, LocalDate checkOutDt, Booking reservation, Room roomBooked
                RoomBooking rb = new RoomBooking(checkInDate, checkOutDate, bk, availRmLst.get(m), 'R');
                bk.getRmBkLst().add(rb);
                availRmLst.get(m).getRmBkLst().add(rb);
                System.out.println("\n\t\t\tBooking No     : " + (bk.getBookingNo()+1));
                System.out.println("\t\t\tGuest Name     : " + guestBooking.getName());
                System.out.println("\t\t\tCheck In Date  : " + displayInDate);
                System.out.println("\t\t\tCheck Out Date : " + displayOutDate);
                System.out.println("\t\t\tRoom Type      : " + interestedRt.getRoomTypeName());
                System.out.printf("\t\t\tRoom Rate      : RM %.2f",interestedRt.getRoomPrice());
                System.out.println();
                System.out.println("\t\t\tRoom No        : " + availRmLst.get(m).getRoomNo());
                System.out.println();
            }
            System.out.println("Booking " + Integer.toString(HotelDB.getCurrBookNo() + 1) + " has been successfully created");
        } else {
            do {
                System.out.print("--> Do you want to select another Room Type (y/n)?: " );
                retry = scanner.next().charAt(0);
                if (Character.toUpperCase(retry) != 'Y' || Character.toUpperCase(retry) != 'N') {
                    System.out.println("(!)Error! Please enter either y, Y, N or n!"); 
                }             
                
            } while (Character.toUpperCase(retry) != 'Y' || Character.toUpperCase(retry) != 'N');
            
            if (Character.toUpperCase(retry) == 'N') {
                exitBooking = 'N';
            }
            
        }
    } else {
        if (firstTime == 'Y') {
            HotelDB.increaseBookNo();
            bk = new Booking((HotelDB.getCurrBookNo()), today, 'R', guestBooking, null,emptyRmBkLst, emptyPayLst );
            guestBooking.appendToGuestBookLst(bk);
            firstTime = 'N';
            HotelDB.setCurrBookNo(HotelDB.getCurrBookNo());
	        HotelDB.getBkLst().add(bk);
            System.out.println("\nBooking Successfully Created!");
        }
        String displayInDate = checkInDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String displayOutDate = checkOutDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        
        for (int n = 0; n < availRmLst.size(); n++) {
            //LocalDate checkInDt, LocalDate checkOutDt, Booking reservation, Room roomBooked
                RoomBooking rb = new RoomBooking(checkInDate, checkOutDate, bk, availRmLst.get(n), 'R');
                bk.getRmBkLst().add(rb);
                availRmLst.get(n).getRmBkLst().add(rb);
                System.out.println("\n\t\t\tBooking No     : " + HotelDB.getCurrBookNo());
                System.out.println("\t\t\tGuest Name     : " + guestBooking.getName());
                System.out.println("\t\t\tCheck In Date  : " + displayInDate);
                System.out.println("\t\t\tCheck Out Date : " + displayOutDate);
                System.out.println("\t\t\tRoom Type      : " + interestedRt.getRoomTypeName());
                System.out.printf("\t\t\tRoom Rate      : RM %.2f",interestedRt.getRoomPrice());
                System.out.println();
                System.out.println("\t\t\tRoom No        : " + availRmLst.get(n).getRoomNo());
                System.out.println();
        }
        System.out.println("Booking " + HotelDB.getCurrBookNo() + " has been successfully created");
    }
    
    do {
        System.out.print("--> Do you want to end booking process (y/n)?: ");
        exitBooking = scanner.next().charAt(0);
        exitBooking = Character.toUpperCase(exitBooking);
        if (exitBooking != 'Y' && exitBooking != 'N') {
            System.out.println("(!)Error! Please enter either y, Y, N or n!"); 
        }
        scanner.nextLine();    
    } while(exitBooking != 'Y' && exitBooking != 'N');
	
    //reset values
        
    validRTC = false;
    noRooms = 0;
    availRmCtr = 0;
    availRmLst.clear();
    
    rmBkLst.clear();
    rmBkLst.clear();
    rmBooking = null;
    
  }
  showBookingSubMenu();  
}
   //end of booking
   

   private static void quitBooking() {  
     quitBooking = true;
     System.out.println("Exiting Room Booking Sub Menu");
   }
   
   private static void cancelBooking() {
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       System.out.printf("%45s%n", "Cancel Booking");
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       char exitLoop = 'N';
       int bookNo;
       Boolean validDT = false;
       Boolean validBookNo = false;
       String reservStat;
       char confirm;
       int idx = 0;
       
       while (exitLoop == 'N') {    
           do {
               try {
                    System.out.print("--> Please enter Booking No: ");
                    bookNo = scanner.nextInt();  
                    validDT = true;
                    for (int i = 0; i < HotelDB.getBkLst().size(); i++) {                              
                        if (bookNo == HotelDB.getBkLst().get(i).getBookingNo()) {
                            validBookNo = true;
                            idx = i;
                            System.out.println("\n\t\t\tBooking No         : " + HotelDB.getBkLst().get(i).getBookingNo());
                            
                            if (HotelDB.getBkLst().get(i).getReservStat() == 'R') {
                                reservStat = "Reserved";
                            } else if (HotelDB.getBkLst().get(i).getReservStat() == 'C') {
                                reservStat = "Cancelled";
                            } else if (HotelDB.getBkLst().get(i).getReservStat() == 'I') {
                                reservStat = "Checked In";
                            } else if (HotelDB.getBkLst().get(i).getReservStat() == 'O') {
                                reservStat = "Checked Out";
                            } else {
                                reservStat = "Unknown";
                            }
                            
                            System.out.println("\t\t\tReservation Status : " + reservStat);
                            System.out.println("\t\t\tReservation Date   : " + HotelDB.getBkLst().get(i).getReservDate());
                            HotelDB.getBkLst().get(i).getHotelGuest().displayBasicInfo();      
                            break;
                        } else {
                            if (i == HotelDB.getBkLst().size() - 1) {
                                validBookNo = false;
                                System.out.println("(!)This Booking Number does not exist!");                                 
                            }                            
                        }
                    }                     
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("(!)Error! Please enter integer only!");  
                    validDT = false;
                }               
           } while (validDT == false || validBookNo == false);
           
           if (HotelDB.getBkLst().get(idx).getReservStat() == 'R') {
               do {
                    System.out.print("\n--> Are you sure about cancelling this booking (y/n)?: ");
                    confirm = scanner.next().charAt(0);
                    confirm = Character.toUpperCase(confirm);
                    if (confirm != 'N' && confirm != 'Y') {
                        System.out.println("(!)Error! Please enter either y, Y, N or n!");                    
                    }              
                } while(confirm != 'N' && confirm != 'Y');     
           
                if (confirm == 'Y') {
                    HotelDB.getBkLst().get(idx).setReservStat('C');
                }       
               
           } else {
               System.out.println("(!)Error! Booking cannot be cancelled!"); 
           }       
 
           do {
               System.out.print("--> Do you want to end this process (y/n)?: ");
               exitLoop = scanner.next().charAt(0);
               exitLoop = Character.toUpperCase(exitLoop);
               if (exitLoop != 'Y' && exitLoop != 'N') {
                    System.out.println("(!)Error! Please enter either y, Y, N or n!"); 
               }
               scanner.nextLine();               
               
           } while (exitLoop != 'N' && exitLoop != 'Y');
       }
       showBookingSubMenu();
       
       
       
   }
   
   private static void checkIn() {
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       System.out.printf("%45s%n", "Check In");
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       char exitLoop = 'N';
       int bookNo;
       Boolean validDT = false;
       Boolean validBookNo = false;
       int memPts = 0;
       String reservStat;
       int idx = 0;
       int chosenPay = 0;
       Booking chosenBook = null;
       ArrayList<RoomBooking> chosenRoomBk = new ArrayList<RoomBooking>();
       LocalDate cinDate;
       LocalDate coutDate;      
       
       while (exitLoop == 'N') {    
           do {
               try {
                    System.out.print("--> Please enter Booking No: ");
                    bookNo = scanner.nextInt();  
                    validDT = true;
                    for (int i = 0; i < HotelDB.getBkLst().size(); i++) {                              
                        if (bookNo == HotelDB.getBkLst().get(i).getBookingNo()) {
                            validBookNo = true;
                            chosenBook = HotelDB.getBkLst().get(i);
                            System.out.println("\n\t\t\tBooking No         : " + HotelDB.getBkLst().get(i).getBookingNo());
                            idx = i;
                            if (HotelDB.getBkLst().get(i).getReservStat() == 'R') {
                                reservStat = "Reserved";
                            } else if (HotelDB.getBkLst().get(i).getReservStat() == 'C') {
                                reservStat = "Cancelled";
                            } else if (HotelDB.getBkLst().get(i).getReservStat() == 'I') {
                                reservStat = "Checked In";
                            } else if (HotelDB.getBkLst().get(i).getReservStat() == 'O') {
                                reservStat = "Checked Out";
                            } else {
                                reservStat = "Unknown";
                            }                          
                            System.out.println("\t\t\tReservation Status : " + reservStat);
                            System.out.println("\t\t\tReservation Date   : " + HotelDB.getBkLst().get(i).getReservDate());                            
                            HotelDB.getBkLst().get(i).getHotelGuest().displayBasicInfo();      
                            break;
                        } else {
                            if (i == HotelDB.getBkLst().size() - 1) {
                                validBookNo = false;
                                System.out.println("(!)This Booking Number does not exist!");                                 
                            }                            
                        }
                    }                     
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("(!)Error! Please enter integer only!");  
                    validDT = false;
                }               
           } while (validDT == false || validBookNo == false);
           
           if (HotelDB.getBkLst().get(idx).getReservStat() == 'I' || HotelDB.getBkLst().get(idx).getReservStat() == 'C' || HotelDB.getBkLst().get(idx).getReservStat() == 'O' ) {
               System.out.println("(!)Error! You are not allowed to check in!"); 
           } else {
               chosenRoomBk = chosenBook.getRmBkLst();
               System.out.println("\n\t\t\tPlease choose preferred payment type ");
               System.out.println("\t\t\t1. Card Payment");
               System.out.println("\t\t\t2. Cash Payment");
               System.out.println("\t\t\t3. Cheque Payment");
               System.out.println();
               
               double grandTotal = 0;
               double subtotal = 0;
               MemberGuest tempMember = null;
               //COME BACK HERE
               do {
                   System.out.print("--> Please enter preferred payment type: ");
                   chosenPay = scanner.nextInt();
                   System.out.println();
                   
                   if(chosenPay != 1 && chosenPay != 2 && chosenPay != 3) {
                       System.out.println("(!)Error! Please enter valid choice!");  
                   } else {
                       if (chosenPay == 1) {
                           CardPayment payType = new CardPayment(0);
                           for (int i = 0; i < chosenRoomBk.size(); i++) {
                               cinDate = chosenRoomBk.get(i).getCheckInDt();
                               coutDate = chosenRoomBk.get(i).getCheckOutDt();
                               long numDays = ChronoUnit.DAYS.between(cinDate, coutDate);
                               subtotal = payType.generatePayment((int)numDays, chosenRoomBk.get(i));
                               grandTotal += subtotal;
                               System.out.printf("\t\t\tRoom Booking %d: RM %.2f%n", (i+1),subtotal);                               
                           }
                           System.out.printf("\t\t\tGrand Total: RM %.2f%n", grandTotal);
                           payType.typePayment(grandTotal);                         
                           
                       } else if (chosenPay == 2) {
                           CashPayment payType = new CashPayment(0);
                           for (int i = 0; i < chosenRoomBk.size(); i++) {
                               cinDate = chosenRoomBk.get(i).getCheckInDt();
                               coutDate = chosenRoomBk.get(i).getCheckOutDt();
                               long numDays = ChronoUnit.DAYS.between(cinDate, coutDate);
                               subtotal = payType.generatePayment((int)numDays, chosenRoomBk.get(i));
                               grandTotal += subtotal;
                               System.out.printf("\t\t\tRoom Booking %d: RM %.2f%n", (i+1),subtotal);                               
                           }
                           System.out.printf("\t\t\tGrand Total: RM %.2f%n", grandTotal);  
                           payType.typePayment(grandTotal);
                           
                       } else {
                           ChequePayment payType = new ChequePayment(0);
                           for (int i = 0; i < chosenRoomBk.size(); i++) {
                               cinDate = chosenRoomBk.get(i).getCheckInDt();
                               coutDate = chosenRoomBk.get(i).getCheckOutDt();
                               long numDays = ChronoUnit.DAYS.between(cinDate, coutDate);
                               subtotal = payType.generatePayment((int)numDays, chosenRoomBk.get(i));
                               grandTotal += subtotal;
                               System.out.printf("\t\t\tRoom Booking %d: RM %.2f%n", (i+1), subtotal);                               
                           }
                           System.out.printf("\t\t\tGrand Total: RM %.2f%n", grandTotal);
                           payType.typePayment(grandTotal);
                           
                       }
                       if (chosenBook.getHotelGuest().getIsMember() == true) {
                           tempMember = (MemberGuest)chosenBook.getHotelGuest();
                           System.out.println("Previous Membership Points: " + tempMember.getMemPoints());
                           tempMember.setMemPoints(tempMember.getMemPoints() + (int)(grandTotal * 0.01));
                           System.out.println("Now Membership Points (after including 1% of Grand Total Charges): " + tempMember.getMemPoints());
                           System.out.println();
                           
                       }
                       
                       chosenBook.setReservStat('I');
                       System.out.println("\nGuest has successfully checked in!\n");
                   }
                                     
               } while (chosenPay != 1 && chosenPay != 2 && chosenPay != 3);
               
           }
           
           do {
               System.out.print("--> Do you want to end this process (y/n)?: ");
               exitLoop = scanner.next().charAt(0);
               exitLoop = Character.toUpperCase(exitLoop);
               if (exitLoop != 'Y' && exitLoop != 'N') {
                    System.out.println("(!)Error! Please enter either y, Y, N or n!"); 
               }
               scanner.nextLine();               
               
           } while (exitLoop != 'N' && exitLoop != 'Y');        
 
       }
       showBookingSubMenu();
       
   }
   
   private static void checkOut() {
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       System.out.printf("%45s%n", "Check Out");
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       char exitLoop = 'N';
       int bookNo;
       Boolean validDT = false;
       Boolean validBookNo = false;
       Booking chosenBook = null;
       int memPts = 0;
       String reservStat;
       int idx = 0;      
       
       while (exitLoop == 'N') {    
           do {
               try {
                    System.out.print("--> Please enter Booking No: ");
                    bookNo = scanner.nextInt();  
                    validDT = true;
                    for (int i = 0; i < HotelDB.getBkLst().size(); i++) {                              
                        if (bookNo == HotelDB.getBkLst().get(i).getBookingNo()) {
                            validBookNo = true;
                            chosenBook = HotelDB.getBkLst().get(i);
                            System.out.println("\n\t\t\tBooking No         : " + HotelDB.getBkLst().get(i).getBookingNo());
                            idx = i;
                            if (HotelDB.getBkLst().get(i).getReservStat() == 'R') {
                                reservStat = "Reserved";
                            } else if (HotelDB.getBkLst().get(i).getReservStat() == 'C') {
                                reservStat = "Cancelled";
                            } else if (HotelDB.getBkLst().get(i).getReservStat() == 'I') {
                                reservStat = "Checked In";
                            } else if (HotelDB.getBkLst().get(i).getReservStat() == 'O') {
                                reservStat = "Checked Out";
                            } else {
                                reservStat = "Unknown";
                            }
                            
                            System.out.println("\t\t\tReservation Status : " + reservStat);
                            System.out.println("\t\t\tReservation Date   : " + HotelDB.getBkLst().get(i).getReservDate());
                            
                            HotelDB.getBkLst().get(i).getHotelGuest().displayBasicInfo();      
                            break;
                        } else {
                            if (i == HotelDB.getBkLst().size() - 1) {
                                validBookNo = false;
                                System.out.println("(!)This Booking Number does not exist!");                                 
                            }                            
                        }
                    }                     
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("(!)Error! Please enter integer only!");  
                    validDT = false;
                }               
           } while (validDT == false || validBookNo == false);
           
           if (HotelDB.getBkLst().get(idx).getReservStat() == 'R' || HotelDB.getBkLst().get(idx).getReservStat() == 'O' || HotelDB.getBkLst().get(idx).getReservStat() == 'C')  {
               System.out.println("(!)Error! You are not allowed to check out!"); 
           } else {
               chosenBook.setReservStat('O');
               System.out.println("\nGuest has successfully checked out!\n");
  
           }
           
           do {
               System.out.print("--> Do you want to end this process (y/n)?: ");
               exitLoop = scanner.next().charAt(0);
               exitLoop = Character.toUpperCase(exitLoop);
               if (exitLoop != 'Y' && exitLoop != 'N') {
                    System.out.println("(!)Error! Please enter either y, Y, N or n!"); 
               }
               scanner.nextLine();               
               
           } while (exitLoop != 'N' && exitLoop != 'Y');            
       
   }showBookingSubMenu();  
 }
}

