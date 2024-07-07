/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelSystem {
    public static void main(String[] args) {
        HotelDB hdb = HotelDB.getInstance();
        HotelDB.loadDB();
        Scanner input = new Scanner(System.in);
      
        String goBack = "";
        System.out.print("\tWelcome to RELAZ Hotel Reservation system!!");
        System.out.println("");
      
        System.out.println ( "\t________         ___               ________");
        System.out.println("\t|   ___ \\        |  |             /____   /");
        System.out.println("\t|   |___ \\       |  |                 /  /");
        System.out.println("\t|    ___  /      |  |                /  /");
        System.out.println("\t|   |  \\  \\      |  |               /  /");
        System.out.println("\t|   |   \\  \\     |  |______        /  /_____");
        System.out.println("\t|_  |    \\__\\    |_________|      /________/");                       
        System.out.println(" ");
        System.out.println(" ");
        sysUserLogin();
    }
    
    public static void sysUserLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\tStaff Login Page");
        System.out.println(" ");
        System.out.println("Welcome to staff login page, please enter a choice to continue: ");
        System.out.println("Press 1- to Login");
        System.out.println("Press 2- To exit ");
        System.out.print("");
        int option;    
        do {
            System.out.print("Please enter your desired option: ");
            option = input.nextInt();
            if (option != 1 && option != 2) {
                System.out.println("\t\t\t(!)Error! Please enter a valid option!");
            }                     
        } while (option != 1 && option != 2);
        
        if (option == 1) {
            System.out.print("Enter your username: ");
            String username= input.next();        
            System.out.print("Enter your password: ");
            String password= input.next();
            SystemUser systemUser = new SystemUser(username,password);
 
            if(systemUser.auth(username,password)){ 
                System.out.println("\n\n\n");
                System.out.println("WELCOME, " + username);           
                displayMainMenu();
            }
            System.out.println("USERNAME OR PASSWORD INCORRECT");
            
        } else {
            exitSystem();            
        }
        
    }
    
    public static void displayMainMenu() {
        String goBack = "";
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {

        System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
        System.out.printf("%45s%n", "Main Menu");
        System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("\t\tPress 1: Booking");
        System.out.println("\t\tPress 2: Hotel Food Descriptions");
        System.out.println("\t\tPress 3: Hotel Beverage Descriptions");
        System.out.println("\t\tPress 4: Room Service (Food or Beverage)");
        System.out.println("\t\tPress 5: Special System Maintenance");
        System.out.println("\t\tPress 6: Report");
        System.out.println("\t\tPress 7: Log Out");
        System.out.println("");
        System.out.println("");
        System.out.println("");      
        
        do {
            System.out.print("Please select 1 of the options above to proceed: ");
            option = input.nextInt();
            if (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option !=6 && option !=7) {
                System.out.println("\t\t\t(!)Error! Please enter a valid option!");
            }
        } while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option !=6 && option !=7);
        
        if (option == 1) {
            HotelBookMgr.showBookingSubMenu();                          
        } else if (option == 2) {               
            FoodDetails foodinfo = new FoodDetails();
            foodinfo.FoodDetails();
            System.out.println("");
            System.out.println("");                  
            
        } else if (option == 3) {
            BeverageDetails beverage= new BeverageDetails(); 
            beverage.beverageInfo(); 
            //System.out.print("Do you want to go back to the previous page: (y/n)");
            //goBack= input.next();

        } else if (option == 4) {
             System.out.println("===============ORDER FOOD OR DRINKS===============");
                  System.out.println("");
                  System.out.print("Please insert the Room no No before booking: ");
                  int roomno= input.nextInt();
                 // RoomService roomService =  new RoomService();
                 // roomService.getRoomno(roomno);
                  System.out.print("Do you want to order food or drink ? ");
                  System.out.println("");
                  
                          
                  System.out.println("To choose food, enter 1");
                  System.out.println("To choose drinks, enter 2");
                  
                  System.out.println("");
                  int inputRS;
                  do{
                  System.out.println("");
                  System.out.print("Please indicate the choice you want to make:");
                      inputRS=input.nextInt();
                      if(inputRS !=1 && inputRS !=2){
                          System.out.print("\t\t\tError! Please enter a valid option!");
                      }
                      
                  }while (inputRS !=1 && inputRS !=2);
                  
                  System.out.print("");
                  
                  if(inputRS==1){
                      
                      System.out.println("===============FOOD ORDER===============");
                      FoodDetails foodD = new FoodDetails();
                      foodD.FoodMenu();
                      
                      System.out.println("");
                      System.out.println("Please enter a food code to proceed: ");
                      String foodcode = input.next();
                      
                      
                      System.out.println("");
                      System.out.println("Please enter the quantity to proceed: ");
                      int quantity = input.nextInt();
                      
                      
                      RoomService rs = new RoomService();
                      rs.addIntoOrderF(foodcode, quantity);
                      
                      rs.totalOrdersF();
                      System.out.println("Your food order will be delivered to rooom no: " + roomno);
                      System.out.println("PRESS ON ANY KEY AND ENTER TO CONTINUE.....");
                      goBack= input.next();
                  }
                  
                  else if(inputRS==2){
                      System.out.println("===============DRINK ORDER===============");
                      BeverageDetails BeveD= new BeverageDetails();
                      BeveD.BeveMenu();
                      
                      System.out.println("");
                      System.out.println("Please enter a beverage code to proceed: ");
                      String bevecode = input.next();
                      
                      
                      System.out.println("");
                      System.out.println("Please enter the quantity to proceed: ");
                      int quantityB = input.nextInt();
                      
                      RoomService rs = new RoomService();
                      rs.addIntoOrderB(bevecode, quantityB);
                      
                      rs.totalOrdersB();
                      System.out.println("Your drink order will be delivered to rooom no: " + roomno);
                      System.out.println("PRESS ON ANY KEY AND ENTER TO CONTINUE.....   ");
                      goBack= input.next();
                  }
            
        } else if (option ==5){
            SpecialMaintenanceMgr.showMaintenanceSMenu();
            
        }  else if(option ==6) {
            ReportManager.showreportmanager(); 
            
            
        } else if (option ==7){
            exitSystem();
            System.exit(0);
        } else
         exitSystem();
        
            
        System.out.print("Do you want to go back to the previous page: (y/n)");
        goBack= input.next();
            
        } while (goBack.toUpperCase().equals("Y"));
        
             
        
    }
    
    public static void exitSystem () {
        System.out.println ( "\t________         ___               ________");
        System.out.println("\t|   ___ \\        |  |             /____   /");
        System.out.println("\t|   |___ \\       |  |                 /  /");
        System.out.println("\t|    ___  /      |  |                /  /");
        System.out.println("\t|   |  \\  \\      |  |               /  /");
        System.out.println("\t|   |   \\  \\     |  |______        /  /_____");
        System.out.println("\t|_  |    \\__\\    |_________|      /________/");
        System.out.println("\tThank you for using RELAZ reservation system!!!");   
    }
    
}



