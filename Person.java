/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
public class Person {
    protected String name;
	protected String idNo;
	protected String emailAddress;
	protected Long contactNo;
	protected Address address;
	public Person(String name, String idNo, String emailAddress, Long contactNo, Address address) {
		this.name = name;
		this.idNo = idNo;
		this.emailAddress = emailAddress;
		this.contactNo = contactNo;
		this.address = address;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public void displayBasicInfo() {
        System.out.println("\t\t\tGuest Name         : " + this.getName());
        System.out.println("\t\t\tID No              : " + this.getIdNo());
    }
    
}