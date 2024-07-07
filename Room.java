/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.ArrayList;
public class Room {
    int roomNo;
	int roomFlr;
	String view;
	RoomType roomType;
	ArrayList<RoomBooking> rmBkLst = new ArrayList<RoomBooking>();
	
	public Room(int roomNo, int roomFlr, String view, RoomType roomType, ArrayList<RoomBooking> rmBkLst ) {
		this.roomNo = roomNo;
		this.roomFlr = roomFlr;
		this.view = view;
		this.roomType = roomType;
		this.rmBkLst = rmBkLst;
	}
    public int getRoomNo() {
        return roomNo;
    }
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    public int getRoomFlr() {
        return roomFlr;
	}
    public void setRoomFlr(int roomFlr) {
        this.roomFlr = roomFlr;
    }
    public String getView() {
        return view;
    }
    public void setView(String view) {
        this.view = view;
    }
    public RoomType getRoomType() {
        return roomType;
    }
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public ArrayList<RoomBooking> getRmBkLst() {
		return rmBkLst;
	}
	public void setRmBkLst(ArrayList<RoomBooking> rmBkLst) {
		this.rmBkLst = rmBkLst;
	}
    
}
