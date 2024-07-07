/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.Scanner;
public class CashPayment extends Payment {
    double cashGive;
    double cashReturn;
    
    Scanner scan = new Scanner(System.in);
    
    public CashPayment(double paymentAmt) {
        super(paymentAmt);
    }



    public void typePayment(double totalRoomCharges) {
        //System.out.print("--> Enter the amount of cash to be given: RM ");
        //cashGive = scan.nextDouble();
        //System.out.println();
        

	System.out.printf("\n\t\t\tPlease pay this amount: RM %.2f", totalRoomCharges);

        System.out.println();
        
        //cashReturn = cashGive - paymentAmt*days;
                
        //return cashReturn;
    }

}

