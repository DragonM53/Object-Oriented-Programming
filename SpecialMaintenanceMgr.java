/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SpecialMaintenanceMgr {
  private String Room;
  private String RoomType;
  private double PricePerRoom;
  private String DateChange;
  private String StaffName;
  private static ArrayList<RoomType> rtLst = new ArrayList<RoomType>();
  //private static ArrayList<Guest> gLst = new ArrayList<Guest>();

  private static Scanner input = new Scanner(System.in);
  //private static boolean checkSMM = false;
  private SpecialMaintenanceMgr() {};
  
  private static SpecialMaintenanceMgr instance = null;
  
  public static SpecialMaintenanceMgr getInstance(){
      if (instance == null) {
            instance = new SpecialMaintenanceMgr();
        }
        return instance;
  }
  
   //public static void main(String[] args){
        //HotelDB hdb = HotelDB.getInstance();
	//HotelDB.loadDB();
	//HotelDB.displayLoaded();
        //showMaintenanceSMenu();
    //}

   
  
   
    public static ArrayList<RoomType> getRtLst() {
        return rtLst;
    }

    public static void setRtLst(ArrayList<RoomType> rtLst) {
        SpecialMaintenanceMgr.rtLst = rtLst;
    }

    

    

    public String getRoom() {
        return Room;
    }

    public void setRoom(String Room) {
        this.Room = Room;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public double getPricePerRoom() {
        return PricePerRoom;
    }

    public void setPricePerRoom(double PricePerRoom) {
        this.PricePerRoom = PricePerRoom;
    }

    public String getDateChange() {
        return DateChange;
    }

    public void setDateChange(String DateChange) {
        this.DateChange = DateChange;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }
    
    
    
   public static void showMaintenanceSMenu(){
       //HotelDB hdb = HotelDB.getInstance();
	//HotelDB.loadDB();
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
        System.out.printf("%45s%n", "\t\tSpecial Maintenance Sub Menu");
        System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
        System.out.print("\t\t\t\t1: Alter room type code\n\t\t\t\t2: Alter user password\n\t\t\t\t3: Go main menu\n\t\t\t\t4: Exit the system\n");
  	/*while (!checkSMM) { 
            try{                
                System.out.print("\t\t\t--> Please enter an option: ");
                int inputMtc = input.nextInt();
                showOptionsForMtc(inputMtc); 
                checkSMM = true;
            }catch(InputMismatchException e){
                input.nextLine();
                System.out.println("\t\t\t(!)Error! Please enter an integer");
            }         
	}*/
        
        /*while (!checkSMM) {
    try {
        System.out.print("\t\t\t--> Please enter an option: ");
        int inputMtc = input.nextInt();
        showOptionsForMtc(inputMtc);
        checkSMM = true;
    } catch (InputMismatchException e) {
        input.nextLine();
        System.out.println("\t\t\t(!)Error! Please enter an integer");
        checkSMM = true; // Set checkSMM to true to exit the loop
    }
}*/
        System.out.print("\t\t\t--> Please enter an option: ");
        int inputMtc = input.nextInt();
        showOptionsForMtc(inputMtc);
   }
   
   
   
   private static void showOptionsForMtc(int inputMtc){
       if(inputMtc==1){
           alterRTC();
       }
       else if(inputMtc==2){
           alterUP();
       }
       else if(inputMtc==3){
           HotelSystem.displayMainMenu();
           //HotelSystem.exitSystem();
       }
       else if(inputMtc==4){
           HotelSystem.exitSystem();
           System.exit(0);
       }else
          System.out.println("Invalid input"); 
   }
   
   
   private static void alterRTC(){
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       System.out.printf("%45s%n", "ALTER ROOM TYPE CODE");
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       System.out.println("");
       System.out.println("ROOM TYPE CODE\t\tROOM TYPE NAME");
       System.out.println("STD\t\t\tSTANDARD");
       System.out.println("DLX\t\t\tDELUXE");
       System.out.println("TRP\t\t\tTRIPLE");
       System.out.println("FAM\t\t\tFAMILY");
       System.out.println("SUI\t\t\tSUITE");
       //Scanner input= new Scanner(System.in);
       System.out.print("please enter the room type code you want to enter: ");
       String roomTypeCode = input.next();
       
       SpecialMaintenanceMgr maintenanceMgr = SpecialMaintenanceMgr.getInstance();
       maintenanceMgr.checkRoomTypeCode(roomTypeCode);
               
       if(maintenanceMgr.checkRoomTypeCode(roomTypeCode)){
           System.out.print("You have entered: " +roomTypeCode);
           System.out.println("");
           System.out.print("Please enter the new changes for " + roomTypeCode + ": ");
           
           String newRoomTypeCode= input.next();
           
           //maintenanceMgr.updateRoomTypeCode("DLX", "DEL", "DELUXE");
           System.out.println("");
           //System.out.println("The old room type code is: "+roomTypeCode);
           //System.out.println("The new room type code is: "+newRoomTypeCode);
           
           System.out.println("");
           
           maintenanceMgr.updateArrayListRTC();
           System.out.println("");
           
       }
       else{
           System.out.print("The room type code you entered is invalid!");
       }
            
    }
   
   private static void alterUP(){
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       System.out.printf("%45s%n", "ALTER PASSWORD FOR USERNAME");
       System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
       System.out.println("");
       System.out.println("Please enter the username you want to change password: ");
       String username = input.next();
       
       SpecialMaintenanceMgr maintenanceMgr = SpecialMaintenanceMgr.getInstance();
       int userIndex= maintenanceMgr.checkUsername(username);
       
       if(userIndex != -1){
           System.out.println("The username is found in the arrayList: " + username);
           System.out.println("");
           System.out.println("Please enter a new password for this user: ");
           String password = input.next();
           maintenanceMgr.updatePassword(username, password);
           System.out.println("Password updated successfully for user: " + username);
           
           System.out.println("");
           maintenanceMgr.updateArrayListUS();
           System.out.println("");
    } else {
        System.out.println("Username not found in the arrayList: " + username);
    }
       
       
   }
   
   public int checkUsername(String username){
       ArrayList<SystemUser> userLst = HotelDB.getUserLst();
    for (int i = 0; i < userLst.size(); i++) {
        SystemUser su = userLst.get(i);
        if (su.getUsername().equals(username)) {
            return i; 
        }
    }
    return -1;
}
   
   public boolean updatePassword(String username, String password){
       ArrayList<SystemUser> userLst = HotelDB.getUserLst();
    for (SystemUser su : userLst) {
        if (su.getUsername().equals(username)) {
            su.setPassword(password); // Update the password
            return true;
        }
    }
    return false; // User not found
}
   
   public boolean checkRoomTypeCode(String roomTypeCode){
        for(RoomType rt : HotelDB.getRtLst()){
            if(rt.getRoomTypeCode().equals(roomTypeCode)){
                return true;
            }
        }
        return false;
        }
  

  public String updateRoomTypeCode(String newRoomTypeCode){
       //update the room type code for a specific guest
       for(RoomType rt : rtLst){
           if(rt.getRoomTypeCode().equals(RoomType))
           {
               rt.setRoomTypeCode(newRoomTypeCode);
               RoomType = newRoomTypeCode;
           }
       }
       return newRoomTypeCode;
   }
   
 //  public void updateRoomTypeCode(String roomTypeCode, String newRoomTypeCode, String newRoomTypeName) {
    // Update the room type code for a specific room type
 //   for (RoomType rt : rtLst) {
   //     if (rt.getRoomTypeCode().equals(roomTypeCode)) {
  //          rt.setRoomTypeCode(newRoomTypeCode);
  //          rt.setRoomTypeName(newRoomTypeCode);
  //      }
 //   }
//}
   
  //  public void updateArrayListRTC(String roomTypeCode, String newRoomTypeCode){
   
   public void updateArrayListRTC(){
     //  for (RoomType roomType : rtLst){
      //     if(roomType.getRoomTypeCode().equals(roomTypeCode)){
     //         roomType.setRoomTypeCode(newRoomTypeCode);
     //      }
     //  }
       for(RoomType roomType : HotelDB.getRtLst()){
            System.out.println("Room Type Code: " + roomType.getRoomTypeCode());
        System.out.println("Room Type Name: " + roomType.getRoomTypeName());
        System.out.println("");
       }
   }
   
   
   public void updateArrayListUS(){
     //  for (RoomType roomType : rtLst){
      //     if(roomType.getRoomTypeCode().equals(roomTypeCode)){
     //         roomType.setRoomTypeCode(newRoomTypeCode);
     //      }
     //  }
       for(SystemUser systemUser : HotelDB.getUserLst()){
            System.out.println("Username: " + systemUser.getUsername());
        System.out.println("Password: " + systemUser.getPassword());
        System.out.println("");
       }
   }
   
}


  //public double changePricePerRoom(){
       
  //}
   
  // public String DisplayDateChange(){
       //change the date of the check-in or check-out dates
       
   //}
   
  // public String DisplayStaffName(){
       //update he staff that change the date
   //}
   
  // public String updatemaxOccupants(){
       
  // }
   
 
  
  


