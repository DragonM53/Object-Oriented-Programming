/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.ArrayList;
public class RoomType {
    private String roomTypeCode;
	private String roomTypeName;
	private String bedType;
	private double roomPrice;
	private int maxOccupants;
	private ArrayList<Room> rmLst = new ArrayList<Room>();

	public RoomType(String roomTypeCode, String roomTypeName, String bedType, double roomPrice, int maxOccupants, ArrayList<Room> rmLst) {
		this.roomTypeCode = roomTypeCode;
		this.roomTypeName = roomTypeName;
		this.bedType = bedType;
		this.roomPrice = roomPrice;
		this.maxOccupants = maxOccupants;
                this.rmLst = rmLst;
	}

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getMaxOccupants() {
        return maxOccupants;
    }

    public void setMaxOccupants(int maxOccupants) {
        this.maxOccupants = maxOccupants;
    }
	
	public ArrayList<Room> getRmLst() {
		return rmLst;
	}
	
	public void setRmLst(ArrayList<Room> rmLst) {
		this.rmLst = rmLst;
	}
	
	public void addToRmLst(Room rm) {
		this.rmLst.add(rm);
	}
	
}
