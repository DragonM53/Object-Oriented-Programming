/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.time.LocalDate;
public class RoomBooking {
    LocalDate checkInDt;
	LocalDate checkOutDt;
	Booking reservation;
	Room roomBooked;
    char rmBookStatus;
	//add room service list later

    public RoomBooking(LocalDate checkInDt, LocalDate checkOutDt, Booking reservation, Room roomBooked, char rmBookStatus) {
        this.checkInDt = checkInDt;
        this.checkOutDt = checkOutDt;
        this.reservation = reservation;
        this.roomBooked = roomBooked;
        this.rmBookStatus = rmBookStatus;
    }

    public char getRmBookStatus() {
        return rmBookStatus;
    }

    public void setRmBookStatus(char rmBookStatus) {
        this.rmBookStatus = rmBookStatus;
    }
    
    

    public LocalDate getCheckInDt() {
        return checkInDt;
    }

    public void setCheckInDt(LocalDate checkInDt) {
        this.checkInDt = checkInDt;
    }

    public LocalDate getCheckOutDt() {
        return checkOutDt;
    }

    public void setCheckOutDt(LocalDate checkOutDt) {
        this.checkOutDt = checkOutDt;
    }

    public Booking getReservation() {
        return reservation;
    }

    public void setReservation(Booking reservation) {
        this.reservation = reservation;
    }

    public Room getRoomBooked() {
        return roomBooked;
    }

    public void setRoomBooked(Room roomBooked) {
        this.roomBooked = roomBooked;
    }
    
    
}
