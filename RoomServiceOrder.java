/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
public class RoomServiceOrder {
    //private String GuestID;
    //private String DateOfOrder;
    //private int RoomNumber;
    private Food food;
    private int quantity;
    private Beverage beverage;
    
    
    public RoomServiceOrder(Food food, int quantity){
        this.food= food;
        this.quantity= quantity;
    }
    
    public RoomServiceOrder(Beverage beverage, int quantity){
        this.beverage= beverage;
        this.quantity= quantity;
    }

    public Food getFood() {
        return food;
    }
    
    
    public int getQuantity() {
        return quantity;
    }

    public Beverage getBeverage(){
        return beverage;
    }
    
   

    

    
   /* public RoomServiceOrder(String GuestID, String DateOfOrder, int RoomNumber) {
        this.GuestID = GuestID;
        this.DateOfOrder = DateOfOrder;
        this.RoomNumber = RoomNumber;
    }

    public String getGuestID() {
        return GuestID;
    }

    public void setGuestID(String GuestID) {
        this.GuestID = GuestID;
    }

    public String getDateOfOrder() {
        return DateOfOrder;
    }

    public void setDateOfOrder(String DateOfOrder) {
        this.DateOfOrder = DateOfOrder;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int RoomNumber) {
        this.RoomNumber = RoomNumber;
    }*/

}

