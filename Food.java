/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
public class Food extends RoomService{
    private String foodCode;
    private String foodName;
    private double foodPrice;
    
    public Food(String foodCode, String foodName, double foodPrice){
        this.foodCode= foodCode;
        this.foodName= foodName;
        this.foodPrice= foodPrice;
                
    }
    
    
    
    public String getFoodCode() {
        return foodCode;
    }

    

    public String getFoodName() {
        return foodName;
    }

   

    public double getFoodPrice() {
        return foodPrice;
    }


   
   

   
    
    
}
