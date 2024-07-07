/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class CardPayment extends Payment {
    private String bankCode;
    private String cardNum;
    private String cardHolderName;
    private LocalDate expiryDate;
    Scanner scan = new Scanner(System.in);
    private double amtGiven; 
    
    public CardPayment(double paymentAmt) {
        super(paymentAmt);
    }
    


    /**
     *
     * 
     */
    
    public void typePayment(double totalRoomCharges) {
        var type = 0;
        
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("\n--> Enter expiry date (dd-MM-yyyy): ");
        String dateString = scan.nextLine();

        LocalDate expiryDate = LocalDate.parse(dateString, formatter);
        
        for(bankCode = "";!bankCode.equals("AMB")&& !"CIB".equals(bankCode)&&  !"HLB".equals(bankCode)
                &&  !"MBB".equals(bankCode)&&  !"PBB".equals(bankCode)&&  !"RHB".equals(bankCode)&& !"OTH".equals(bankCode);){
        System.out.print("--> Bank Code:\n"
                + "\t 1.Ambank Berhad(AMB)\n" +
                                "\t 2.Cimb Bank Berhad(CIB)\n" +
                                "\t 3.Hong Leong Bank Berhad(HLB)\n" +
                                "\t 4.Malayan Banking Berhad (MBB)\n" +
                                "\t 5.Public Bank Berhad(PBB)\n" +
                                "\t 6.RHB Bank Berhad(RHB)\n" +
                                "\t 7.Other(OTH)\n"
                                + "\t Enter Bank Code: ");
        bankCode = scan.nextLine();
        bankCode = bankCode.toUpperCase();
        //System.out.print(bankCode); 
        
        if (!bankCode.equals("AMB")&&  !"CIB".equals(bankCode)&&  !"HLB".equals(bankCode)
                &&  !"MBB".equals(bankCode)&&  !"PBB".equals(bankCode)&&  !"RHB".equals(bankCode)&&  !"OTH".equals(bankCode))
        { System.out.print("\nBank Code incorrect\n"); }
        }

        
        for(cardNum = "";cardNum.length()!=16;){
            System.out.print("--> Enter Card Number: ");
            cardNum = scan.nextLine();
            if (cardNum.length() != 16){ System.out.print("input must be 16 number\n"); }
            }
        
        System.out.print("--> Enter Card Holder Name: ");
        cardHolderName = scan.nextLine();
        
        System.out.printf("\n\t\t\tPlease pay this amount: RM %.2f", totalRoomCharges);

        System.out.println();
        
      
        
    }
    
//    public void typePayment() {
//        
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//        System.out.print("--> Enter expiry date (dd-MM-yyyy): ");
//        String dateString = scan.nextLine();
//
//        LocalDate expiryDate = LocalDate.parse(dateString, formatter);
//        
//        System.out.print("--> Enter Bank Code: ");
//        bankCode = scan.nextLine();
//        
//        System.out.print("--> Enter Card Number: ");
//        cardNum = scan.nextLine();
//        
//        System.out.print("--> Enter Card Holder Name: ");
//        cardHolderName = scan.nextLine();
//        
//        System.out.print("--> Enter amount you wish to pay: RM ");
//        amtGiven = scan.nextDouble();
//        
//        System.out.println();
//        
//    }

    private String typeOf(int z) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    


}


