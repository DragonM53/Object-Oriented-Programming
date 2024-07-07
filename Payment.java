/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.Scanner;
public abstract class Payment{
    int typeCode;
    static double paymentAmt;


    public Payment(double paymentAmt) {
        this.typeCode = 0;
        Payment.paymentAmt = paymentAmt;
    }

    public int setTypeCode(int typeCode) {
        this.typeCode = typeCode;
        return 0;
    }

    public int getTypeCode() {
        return typeCode;
    }

    
    public abstract void typePayment(double totalRoomCharges);

    // Getter method for paymentAmt
    public double getPaymentAmt() {
        return paymentAmt;
    }
    
    public double generatePayment(int days, RoomBooking x){
        paymentAmt = days * x.getRoomBooked().getRoomType().getRoomPrice();
        return paymentAmt;
    }  
    
   

   
//    public double processPayment(int days, RoomBooking x){
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter you Payment Type (Cash/Card/Cheque): ");
//            var paymentType = scanner.nextLine();
//            paymentType = paymentType.toUpperCase();
//                switch (paymentType) {
//                    case "CASH" -> {
//                        double cashReturn;
//                        Payment cashPayment = new CashPayment(paymentAmt);
//                        cashReturn = cashPayment.typePayment(days);
//                        paymentAmt = cashReturn;
//                    }
//                    case "CARD" ->                     {
//                            double Amount;
//                            Payment cardPayment = new CardPayment(paymentAmt);
//                            Amount = cardPayment.typePayment(days);
//                            paymentAmt = Amount;
//                        }
//                    case "CHEQUE" ->                     {
//                            double Amount;
//                            Payment chequePayment = new ChequePayment(paymentAmt);
//                            Amount = chequePayment.typePayment(days);
//                            paymentAmt = Amount;
//                        }
//                    default -> {
//                        System.out.print("Invalid input");
//                    }
//                }
//            return paymentAmt;
//    }  
}
