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

/**
 *
 * @author ryank
 */
public class ChequePayment extends Payment {
    private LocalDate chequeDate;
    private String bankCode;
    private Long chequeNum ;
    Scanner scan = new Scanner(System.in);
    private double amtGiven; 

    public ChequePayment(double paymentAmt) {
        super(paymentAmt);
    }

    public void typePayment(double totalRoomCharges) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("--> Enter date (dd-MM-yyyy): ");
        String dateString = scan.nextLine();

        LocalDate chequeDate = LocalDate.parse(dateString, formatter);
        

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
        System.out.print(bankCode); 
        
        if (!bankCode.equals("AMB")&&  !"CIB".equals(bankCode)&&  !"HLB".equals(bankCode)
                &&  !"MBB".equals(bankCode)&&  !"PBB".equals(bankCode)&&  !"RHB".equals(bankCode)&&  !"OTH".equals(bankCode))
        { System.out.print("\nBank Code incorrect\n"); }
        }
        
        System.out.print("--> Enter the Cheque Number: ");
        chequeNum = scan.nextLong();

        
        System.out.println();

	System.out.printf("\n\t\t\tPlease pay this amount: RM %.2f", totalRoomCharges);

        System.out.println();
    }

    
}
