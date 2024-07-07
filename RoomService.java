/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.ArrayList;

public class RoomService {
    private String guestID;
    private String RoomNumber;
    //private ArrayList<Food> orderList;
    //private ArrayList<RoomServiceOrder> orderList;
    private ArrayList<RoomServiceOrder> orderList = new ArrayList<>();

     
    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }
    
    public void addIntoOrderF(String foodCode, int quantity){
        FoodDetails foodDetails= new FoodDetails();
        Food selectedFood= foodDetails.getFoodCode(foodCode);
        if(selectedFood != null){
            RoomServiceOrder roomServiceOrder = new RoomServiceOrder(selectedFood, quantity);
            //orderList.add(selectedFood);
            orderList.add(roomServiceOrder);
            System.out.println("");
            //System.out.println("Food has been selected:  " + selectedFood.getFoodName() + ("Quantity: " + quantity));
        }else{
            System.out.println("Invalid food code");
        }
    }
    
   
    
    public void addIntoOrderB(String beveCode, int quantity) {
        BeverageDetails beverageDetails = new BeverageDetails();
        Beverage selectedBeverages= beverageDetails.getBeveCode(beveCode);
        if(selectedBeverages != null){
            RoomServiceOrder roomServiceOrder = new RoomServiceOrder(selectedBeverages, quantity);
            orderList.add(roomServiceOrder);
            System.out.println("");
            //System.out.println("Beverage has been selected: "+ selectedBeverages.getBeveName()+ (", Quantity: "+ quantity));
            
        }else{
            System.out.print("Invalid food code");
        }
    }
    
    public void totalOrdersF(){
        if(orderList.isEmpty()){
            System.out.println("Nothing is ordered");
        }else{
            System.out.println("");
            System.out.println("Order Details: ");
            double totalAmount = 0.0;
                for (RoomServiceOrder roomServiceOrder : orderList){
                Food food= roomServiceOrder.getFood();
                
                int quantity= roomServiceOrder.getQuantity();
                double itemAmount = food.getFoodPrice() * quantity;
                System.out.println("Food Name: " + food.getFoodName());
                System.out.println("Quantity: " + quantity);
                totalAmount += itemAmount;
            }
            System.out.println("Total Amount: RM " + totalAmount);
            System.out.println("");
            System.out.println("Your food will be bring into your room shortly");
            System.out.println("THANK YOU FOR CHOOSING RELAZ HOTEL");
        }
            }
    
    public void totalOrdersB(){
        if(orderList.isEmpty()){
            System.out.println("Nothing is ordered");
        }else{
            System.out.println("Order Details: ");
            double totalAmountB = 0.0;
                for (RoomServiceOrder roomServiceOrder : orderList){
                Beverage beverage= roomServiceOrder.getBeverage();
                
                int quantity= roomServiceOrder.getQuantity();
                double itemAmountB = beverage.getBeveragePrice() * quantity;
                System.out.println("Beverage Name: " + beverage.getBeveName());
                System.out.println("Quantity: " + quantity);
                //System.out.println(beverage.getBeveName() + " (Quantity: " + quantity + ")  RM " + itemAmountB);
                totalAmountB += itemAmountB;
            }
            System.out.println("Total Amount: RM " + totalAmountB);
            System.out.println("");
            System.out.println("Your Drinks will be bring into your room");
            System.out.println("THANK YOU FOR CHOOSING RELAZ HOTEL");
        }
            }
    
    
    
        }