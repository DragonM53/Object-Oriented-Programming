/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author ryank
 */
public class Booking {
    private int bookingNo;
    private LocalDate reservDate;
    private char reservStat;
    private Guest hotelGuest;
    private SystemUser hotelStaff;
    private ArrayList<RoomBooking> rmBkLst = new ArrayList<RoomBooking>();
    private ArrayList<Payment> bkPayLst = new ArrayList<Payment>();

    public Booking(int bookingNo, LocalDate reservDate, char reservStat, Guest hotelGuest, SystemUser hotelStaff, ArrayList<RoomBooking> rmBkLst, ArrayList<Payment> bkPayLst) {
        this.bookingNo = bookingNo;
        this.reservDate = reservDate;
        this.reservStat = reservStat;
        this.hotelGuest = hotelGuest;
        this.hotelStaff = hotelStaff;
		this.rmBkLst = rmBkLst;
		this.bkPayLst = bkPayLst;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
    }

    public LocalDate getReservDate() {
        return reservDate;
    }

    public void setReservDate(LocalDate reservDate) {
        this.reservDate = reservDate;
    }

    public char getReservStat() {
        return reservStat;
    }

    public void setReservStat(char reservStat) {
        this.reservStat = reservStat;
    }

    public Guest getHotelGuest() {
        return hotelGuest;
    }

    public void setHotelGuest(Guest hotelGuest) {
        this.hotelGuest = hotelGuest;
    }

    public SystemUser getHotelStaff() {
        return hotelStaff;
    }

    public void setHotelStaff(SystemUser hotelStaff) {
        this.hotelStaff = hotelStaff;
    }

    public ArrayList<RoomBooking> getRmBkLst() {
        return rmBkLst;
    }

    public void setRmBkLst(ArrayList<RoomBooking> rmBkLst) {
        this.rmBkLst = rmBkLst;
    }
    
}

