/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.ArrayList;
/**
 *
 * @author ryank
 */
public class Guest extends Person{
    private Boolean isMember;
	private Boolean isMalaysian;
        private ArrayList<Booking> guestBookLst = new ArrayList<Booking>();
		
	public Guest(String name, String idNo, String emailAddress, Long contactNo, Address address, Boolean isMember, Boolean isMalaysian, ArrayList<Booking> guestBookLst) {
		super(name, idNo, emailAddress, contactNo, address);
		this.isMember = isMember;
		this.isMalaysian = isMalaysian;
		this.guestBookLst = guestBookLst;
	}

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }

    public Boolean getIsMalaysian() {
        return isMalaysian;
    }

    public void setIsMalaysian(Boolean isMalaysian) {
        this.isMalaysian = isMalaysian;
    }      
    
    public ArrayList<Booking> getGuestBookLst() {  //****************************
		return guestBookLst;
	}
	
	public void setGuestBookLst(ArrayList<Booking> guestBookLst) {  //**************************
		this.guestBookLst = guestBookLst;
	}
	
	public void appendToGuestBookLst(Booking bk) {  //*******************************
		this.guestBookLst.add(bk);
	}
        
        public void displayBasicInfo() {
            super.displayBasicInfo();
        }

    @Override
    public String toString() {
        return "Guest{" + "isMember=" + isMember + ", isMalaysian=" + isMalaysian + ", guestBookLst=" + guestBookLst + '}' + this.getName();
    }
        
    
}
