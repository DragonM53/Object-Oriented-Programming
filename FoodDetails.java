/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
import java.util.ArrayList;

public class FoodDetails extends RoomService{
    private String FoodDetails;
    private ArrayList<Food>FoodLst= new ArrayList<>();
    
    public FoodDetails(){
        Food f1= new Food("F001", "Chicken Rice", 8);
        Food f2= new Food("F002", "Pan Mee", 7);
        Food f3= new Food("F003", "Spaghetti", 8);
        Food f4= new Food("F004", "Burger", 5);
        Food f5= new Food("F005", "Chicken Chop", 8);
        Food f6= new Food("F006", "Mee Goreng", 7);
        Food f7= new Food("F007", "Curry Laksa", 7);
        Food f8= new Food("F008", "Nasi Lemak", 3);
        Food f9= new Food("F009", "Satay", 10);
        Food f10= new Food("F010", "Rendang Curry Rice", 7);
        
        FoodLst.add(f1);
        FoodLst.add(f2);
        FoodLst.add(f3);
        FoodLst.add(f4);
        FoodLst.add(f5);
        FoodLst.add(f6);
        FoodLst.add(f7);
        FoodLst.add(f8);
        FoodLst.add(f9);
        FoodLst.add(f10);
        
        
        
        
    }

    public String getFoodDetails() {
        return FoodDetails;
    }

    public void setFoodDetails(String FoodDetails) {
        this.FoodDetails = FoodDetails;
    }
    
      public void FoodMenu() {
        System.out.println("===============FOOD MENU===============");
        for (Food food : FoodLst) {
            System.out.println(food.getFoodCode() + "-" + food.getFoodName() + "-RM" + food.getFoodPrice());
        }
    }
    
    
    
    public Food getFoodCode(String foodCode){
        for(Food food: FoodLst){
            if(food.getFoodCode().equalsIgnoreCase(foodCode)){
                return food;
            }
        }
        return null;
    }
    
    
    
    /*public void FoodMenu(){
        System.out.println("FOOD CODE\t\t\tFOOD NAME\t\t\tFOOD PRICE (RM)");
        System.out.println("F001\t\t\t\tChicken Rice\t\t\t\t8");
        System.out.println("F002\t\t\t\tPan Mee\t\t\t\t\t7");
        System.out.println("F003\t\t\t\tSpaghetti\t\t\t\t8");
        System.out.println("F004\t\t\t\tBurger\t\t\t\t\t5");
        System.out.println("F005\t\t\t\tChicken Chop\t\t\t\t8");
        System.out.println("F006\t\t\t\tMee Goreng\t\t\t\t7");
        System.out.println("F007\t\t\t\tCurry Laksa\t\t\t\t7");
        System.out.println("F008\t\t\t\tNasi Lemak\t\t\t\t3");
        System.out.println("F009\t\t\t\tSatay\t\t\t\t\t10");
        System.out.println("F010\t\t\t\tRendang Curry Rice\t\t\t7");
    }*/
    
    public void SelectFood(){
        System.out.println("Chicken Rice - 1");
        System.out.println("Pan Mee - 2");
        System.out.println("Spaghetti - 3");
        System.out.println("Burger - 4");
        System.out.println("Chicken Chop - 5");
        System.out.println("Mee Goreng - 6");
        System.out.println("Curry Laksa - 7");
        System.out.println("Nasi Lemak - 8");
        System.out.println("Satay - 9");
        System.out.println("Rendang Curry Rice - 10");
    }
    
    
    
    public void FoodDetails(){
    System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
    System.out.printf("%45s%n", "Food Information");
    System.out.printf("%60s%n", "----------------------------------------------------------------------------------");
    // beverage 1
    System.out.println("Name of food\t\t\tPrice (RM)");
    System.out.println("1.Chicken Rice\t\t\t8.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Chicken rice is a popular dish that is originated in Hainan.
                       China and has become a beloved staple in many Southeast Asian countries, 
                       particularly in Singapore, Malaysia, and Thailand. It consists of succulent 
                       poached or roasted chicken served with fragrant rice cooked in chicken broth 
                       and a variety of accompanying condiments.""");
    System.out.println("");
    System.out.println("");
    // beverage 2
    System.out.println("2.Pan Mee\t\t\t7.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Pan mee is known as noodles with soya juice, minced meat and soup.
                       The noodles are handmade and it is very popular in Malaysian and Singaporean 
                       dish that originated from the Hakka Chinese community.""");
     System.out.println("");
    System.out.println("");
    // beverage 3
    System.out.println("3.Spaghetti\t\t\t7.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Spaghetti is a classic and widely beloved Italian pasta dish that has 
                       gained popularity worldwide. It consists of long, slender pasta noodles made from 
                       durum wheat semolina, typically cooked until tender and served with a variety of 
                       sauces and toppings.""");
     System.out.println("");
    System.out.println("");
    //beverage 4
    System.out.println("4.Burger\t\t\t5.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: A burger, short for hamburger, is a popular and iconic American dish that 
                       has gained worldwide recognition and appreciation. It consists of a ground meat patty, 
                       typically beef, placed between two slices of a soft bun, along with a variety of flavorful 
                       toppings and condiments.""");
     System.out.println("");
    System.out.println("");
    //beverage 5
    System.out.println("5.Chicken Chop\t\t\t8.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Chicken chop is a delectable and hearty dish that features a tender and juicy chicken cutlet, 
                       typically served with a variety of complementary accompaniments. It is a popular dish found in 
                       Western-style restaurants and cafes.""");
     System.out.println("");
    System.out.println("");
    //beverage 6
    System.out.println("6.Mee Goreng\t\t\t7.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Mee goreng, also known as fried noodles, is a popular and flavorful dish that 
                       originated in Southeast Asia, particularly in Malaysia, Singapore, and Indonesia. It is a 
                       stir-fried noodle dish that combines a harmonious blend of ingredients, spices, and sauces 
                       to create a satisfying and aromatic meal.""");
     System.out.println("");
    System.out.println("");
    //beverage 7
    System.out.println("7.Curry Laksa\t\t\t7.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Curry laksa, also known as laksa lemak, is a popular and aromatic noodle soup that 
                       originated in Southeast Asia, particularly in Malaysia and Singapore. It is a fusion of Chinese 
                       and Malay flavors, combining a rich and fragrant curry broth with noodles, seafood, meat, and an 
                       array of toppings.""");
     System.out.println("");
    System.out.println("");
    //beverage 8
    System.out.println("8.Nasi Lemak\t\t\t3.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Nasi lemak is a beloved and iconic dish that hails from Malaysia and is also popular 
                       in neighboring countries like Singapore and Indonesia. It is a fragrant and flavorful rice dish 
                       cooked in coconut milk and served with a variety of accompaniments, creating a satisfying and 
                       balanced meal.""");
     System.out.println("");
    System.out.println("");
    //beverage 9
    System.out.println("9.Satay\t\t\t\t10.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Satay is a popular and delicious grilled meat skewer dish that originated in Southeast 
                       Asia, particularly in countries like Malaysia, Indonesia, Thailand, and Singapore. It is a flavorful 
                       and aromatic street food that has gained international recognition and is enjoyed by people worldwide.""");
     System.out.println("");
    System.out.println("");
    //beverage 10
    System.out.println("10.Rendang Curry Rice\t\t7.00");
    System.out.println("");
    System.out.println("");
    System.out.println("""
                       Description: Rendang curry rice is a flavorful and aromatic dish that combines tender meat simmered in a rich, 
                       spiced coconut-based sauce, served with steamed rice. It is a traditional Indonesian and Malaysian dish known 
                       for its complex flavors and slow cooking process.""");
    }}
