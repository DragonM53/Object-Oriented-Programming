/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.Scanner;


public class ReportManager {
    private static Scanner scanner = new Scanner(System.in);

    //public static void getNewReservationsToday(List<Booking> newReservationsToday, List<Booking> allBookings, LocalDate checkInDate) {
    //    Calendar today = Calendar.getInstance();
    //    
    //    for (Booking booking : allBookings) {
    //        LocalDate checkInDate = RoomBooking.getCheckInDt();
    //        if (checkInDate.isEqual(today)) {
    //            newReservationsToday.add(booking);
    //        }
    //    }
    //    System.out.println("Newly Reservation          : " + newReservationsToday);
    //}
    //public static void getDailySales(List<Booking> newReservationsToday) {
    //    double dailySales = 0.0;
    //
    //    for (Booking booking : newReservationsToday) {
    //        double bookingTotal = RoomBooking.getRoomBooked();
    //        dailySales += bookingTotal;
    //    }
    //    System.out.println("Daily Sales          : " + dailySales);
    //}
    
    //public static void getRevenueByYear(int year) {
    //    double revenue = 0;
        
    //    for (Booking booking : bookings) {
    //        Calendar calendar = Calendar.getInstance();
    //        calendar.setTime(booking.getCheckInDate());
    //        
    //         int bookingYear = calendar.get(Calendar.YEAR);
            
    //        if (bookingYear == year) {
    //            Payment payment = booking.getPayment();
    //            revenue += payment.getAmount();
    //        }
    //    }
        
    //    return revenue;
    //}
    
    public static void showreportmanager() {

        System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
        System.out.printf("%45s%n", "Check Information");
        System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("Enter 1 to check the Staff List");
        System.out.println("Enter 2 to check the Reservation Status");
        System.out.println("Enter 3 to check the Guest Information");
        System.out.println("Enter 4 to check the Booking Details");
        System.out.println("Enter 5 to Exit");
        System.out.print("Enter your choice : ");
        int yourchoice = scanner.nextInt();
        
        if(yourchoice == 1){
            System.out.println("                               Check Staff List                                ");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("* For check the staff that in our hotel");
            System.out.println("");
            //String username = SystemUser.getUsername();
            //System.out.println(staff);
            staffList();
            gobackpage();
        }else if (yourchoice == 2){
            System.out.println("                           Check Booking No Reservation                        ");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("* For check the booking no reservation date");
            System.out.println("");
            System.out.print("--> Please enter Booking No: ");
            int bookNo = scanner.nextInt();  
            int i = 0;
            
            System.out.println("\n\t\t\tBooking No         : " + HotelDB.getBkLst().get(i).getBookingNo());
            String reservStat;
              
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
                for (i = 0; i < HotelDB.getBkLst().size(); i++) {                              
                    if (bookNo == HotelDB.getBkLst().get(i).getBookingNo()) {
                        System.out.println("\t\t\tReservation Date   : " + HotelDB.getBkLst().get(i).getReservDate());
                        System.out.println("\t\t\tReservation Date   : " + HotelDB.getBkLst().get(i).getReservDate()); 
                    }
                }
            gobackpage();
        }else if (yourchoice == 3){
            System.out.println("                            Check Guest Information                            ");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("* For check the specified booking no reservation status");
            System.out.println("");
            System.out.print("--> Please enter Booking No: ");
            int bookNo = scanner.nextInt();  

                    for (int i = 0; i < HotelDB.getBkLst().size(); i++) {                              
                        if (bookNo == HotelDB.getBkLst().get(i).getBookingNo()) {
                            System.out.println("\n\t\t\tBooking No         : " + HotelDB.getBkLst().get(i).getBookingNo());                          
                            HotelDB.getBkLst().get(i).getHotelGuest().displayBasicInfo(); 
                        }
                    }
            gobackpage();
        }else if (yourchoice == 4){
            System.out.println("                           Check All Details                           ");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("* For check all the details of the booking no");
            System.out.println("");
             System.out.print("--> Please enter Booking No: ");
            int bookNo = scanner.nextInt();  

                    for (int i = 0; i < HotelDB.getBkLst().size(); i++) {                              
                        if (bookNo == HotelDB.getBkLst().get(i).getBookingNo()) {
                            System.out.println("\n\t\t\tBooking No         : " + HotelDB.getBkLst().get(i).getBookingNo());
                            String reservStat;
                            
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
                            System.out.println("\t\t\tReservation Date   : " + HotelDB.getBkLst().get(i).getReservDate());
                            HotelDB.getBkLst().get(i).getHotelGuest().displayBasicInfo();
                        }
                    }
            gobackpage();
        }else if (yourchoice == 5){
            HotelSystem.displayMainMenu();
        }else {
            System.out.println("Error: Invalid Number");
            showreportmanager(); 
        }
    }
    public static void gobackpage(){
        System.out.println("");
        System.out.println("");
        System.out.println("Press 1 to go to Main menu");
        System.out.println("Press 2 to go to the previous page");
        System.out.print("Enter your choice : ");
        int pageoption = scanner.nextInt();

        if (pageoption == 1){
            HotelSystem.displayMainMenu();
        }else if (pageoption == 2){
            showreportmanager();
        }else {
            System.out.println("Error: Invalid Number");
            showreportmanager();
        }
    }
    public static void staffList(){
        System.out.println("1. martin");
        System.out.println("2. Ryan");
        System.out.println("3. ZeeLin");
        System.out.println("4. Starla");
        System.out.println("5. Jake");
        System.out.println("6. XiaoMing");
        System.out.println("7. Ben");
        System.out.println("8. Oliver");
        System.out.println("9. AhBing");
        System.out.println("10.Felix");
        System.out.println("11.Pedro");
        System.out.println("12.Sam");
        System.out.println("13.Nelson");
        System.out.println("14.Roger");
        System.out.println("15.Xavier");
        System.out.println("16.Karen");
        System.out.println("17.Garfield");
        System.out.println("18.Ray");
        System.out.println("19.Vivian");
        System.out.println("20.Adrian");
    }
}
