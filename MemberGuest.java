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
public class MemberGuest extends Guest {
    int memPoints;
	LocalDate joinDate;

    public MemberGuest(int memPoints, LocalDate joinDate, String name, String idNo, String emailAddress, Long contactNo, Address address, Boolean isMember, Boolean isMalaysian, ArrayList<Booking> gBkLst) {
        super(name, idNo, emailAddress, contactNo, address, isMember, isMalaysian, gBkLst);
        this.memPoints = memPoints;
        this.joinDate = joinDate;
    }

    public int getMemPoints() {
        return memPoints;
    }

    public void setMemPoints(int memPoints) {
        this.memPoints = memPoints;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
    
    
    public void displayBasicInfo() {
        super.displayBasicInfo();
        System.out.println("\t\t\tMembership Points  : " + this.getMemPoints());
        System.out.println("\t\t\tJoin Date          : " + this.getJoinDate());
    }
    
}


