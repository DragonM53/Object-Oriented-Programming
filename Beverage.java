/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
public class Beverage extends RoomService{
    private String beveCode;
private String beveName;
private double beveragePrice;

    public String getBeveCode() {
        return beveCode;
    }

    public double getBeveragePrice() {
        return beveragePrice;
    }

    public String getBeveName() {
        return beveName;
    }
    

  public Beverage(String beveCode, String beveName, double beveragePrice){
      this.beveCode= beveCode;
      this.beveName= beveName;
      this.beveragePrice= beveragePrice;
  }
}

