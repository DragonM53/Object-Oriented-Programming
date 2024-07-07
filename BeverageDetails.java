
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
public class BeverageDetails extends RoomService{
     private String beverageInfo;
    private ArrayList<Beverage>beveLst= new ArrayList<>();
    
    public BeverageDetails(){
        Beverage b1= new Beverage("B001", "Sparking Lemon Juice", 3);
        Beverage b2 = new Beverage("B002", "Cappuccino coffee" , 5);
        Beverage b3 = new Beverage("B003", "Fruit smoothie", 3);
        Beverage b4 = new Beverage("B004","Herbal Tea", 1);
        Beverage b5 = new Beverage("B005","Cabonated drinks", 2 );
        Beverage b6 = new Beverage("B006", "Bubble Milk Tea", 3);
        Beverage b7 = new Beverage("B007", "Ice Cream Soda", 4 );
        Beverage b8 = new Beverage("B008", "Coconut Milk Shake", 5 );
        Beverage b9 = new Beverage("B009", "Milo Dinasour", 3);
        Beverage b10 = new Beverage("B010", "Sirup Bundong", 2);
        
        beveLst.add(b1);
        beveLst.add(b2);
        beveLst.add(b3);
        beveLst.add(b4);
        beveLst.add(b5);
        beveLst.add(b6);
        beveLst.add(b7);
        beveLst.add(b8);
        beveLst.add(b9);
        beveLst.add(b10);
        
    }

    public ArrayList<Beverage> getBeveLst() {
        return beveLst;
    }

    public void setBeveLst(ArrayList<Beverage> beveLst) {
        this.beveLst = beveLst;
    }
    
    public void BeveMenu(){
         System.out.println("===============FOOD MENU===============");
        for (Beverage beverage : beveLst) {
            System.out.println(beverage.getBeveCode() + "-" + beverage.getBeveName() + "-RM" + beverage.getBeveragePrice());
        }
    }
    
    public Beverage getBeveCode(String beveCode){
        for(Beverage beverage: beveLst){
            if(beverage.getBeveCode().equalsIgnoreCase(beveCode)){
                return beverage;
            }
        }
        return null;
    }
 
    
    public String getBeverageInfo() {
        return beverageInfo;
    }

    public void setBeverageInfo(String beverageInfo) {
        this.beverageInfo = beverageInfo;
    }
    
    public void beverageInfo(){
    System.out.println("====================BEVERAGE INFORMATION====================");
    // beverage 1
    System.out.println("Name of drink\t\t\tPrice (RM)");
    System.out.println("1.Sparking Lemon Juice\t\t3.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Sparkling Lemon Juice that helps refreshens up your day! comes with 
                       many benefits such as: helps for better digestion, better blood circulation, reomove 
                       inflamation from the body and keep your day more full of joy.""");
    System.out.println("");
    System.out.println("");
    // beverage 2
    System.out.println("2.Cappuccino coffee\t\t5.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Cappuccino coffee is the most famous drink in RELAZ hotel, made from  
                       100% genuine coffee powder bended with amora that can blast your taste buds, many  
                       benefits of drinking coffee, such as making your awareness more shaeper, keep you
                       more awake after a long day of work, boost productivity. """);
     System.out.println("");
    System.out.println("");
    // beverage 3
    System.out.println("3.Fruit smoothie\t\t3.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Fruit smoothie is also quite popular in RELAZ hotel ususlly, made from  
                       100% genuine fruits imported from Malaysia, other countries, the most popluar fruit 
                       drink is banana, we do also offer more variety such as: orange, apple, cranberry and more.""");
     System.out.println("");
    System.out.println("");
    //beverage 4
    System.out.println("4.Herbal Tea\t\t\t1.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Cheap and affordable at all ages, brings more benefits such as 
                       more awareness, better digestion and contain no calories, which can help people
                       that wants to loose weight to help them to achieve the goal more faster and easier.""");
     System.out.println("");
    System.out.println("");
    //beverage 5
    System.out.println("5.Cabonated drinks\t\t2.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Suitable for all ages to drink, many varieties to choose from such as
                       Coke, Pepsi, 7-Up, Ice Lemon Tea and more. Drinks that come with refreshingness all
                       around, can be bought at only 2 ringgit""");
     System.out.println("");
    System.out.println("");
    //beverage 6
    System.out.println("6.Bubble Milk Tea\t\t5.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Bubble milk tea that only is a limited time offer for users in RELAZ to
                       purchase, becasue we want to have a survey whether it is famous in the hotel. Only comes 
                       with a large size. No selections to choose from""");
     System.out.println("");
    System.out.println("");
    //beverage 7
    System.out.println("7.Ice Cream Soda\t\t4.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: When we are kids, surely we will remember the ice cream with our favourite
                       soda, it peaks with the most delicous and yummy experience on your life, compared to
                       outside, some hotel or restorents don't even have these kinds of drinks. But avaiable
                       in RELAZ hotel.""");
     System.out.println("");
    System.out.println("");
    //beverage 8
    System.out.println("8.Coconut Milk shake\t\t5.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Healthy and refreshing mixed together in a drink fill with happiness
                       and joy, with weather that is hot in Malaysia, get yourself a glass of RELAZ coconut
                       Milk shake at only RM5.""");
     System.out.println("");
    System.out.println("");
    //beverage 9
    System.out.println("9.Milo Dinosaur\t\t\t3.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Made in Malaysia, foreign visitors will be able to enjoy our local drink.
                       The milo dinosuar drink can make us as Malaysian proud that we have a drink that is
                       so delicous and nutricious. We believe that when we are young, we have drinked before
                       milo.""");
     System.out.println("");
    System.out.println("");
    //beverage 10
    System.out.println("10.Sirup Bundong\t\t2.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Sirup bundong is a drink is made from rose petals and its taste every 
                       good when it's your first time tasting it, it can be sold in anywhere if you have
                       been to our local mamak store. They will definitely sell this drink. This drink is
                       also very widely loved by Malaysians.""");
    
}
}
