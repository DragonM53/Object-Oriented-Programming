/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chtho
 */
public class SystemUser{
    private String Username;
    private String Password;
    //private ArrayList<SystemUser>userLst= new ArrayList<SystemUser>();
    
     public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public SystemUser(String user, String pass){
        Username= user;
        Password= pass;
    }
    
    
    //private ArrayList<User>userLst= new ArrayList<>();
    

   // public ArrayList<User> getUserLst() {
    //    return userLst;
  //  }

   // public void setUserLst(ArrayList<User> userLst) {
  //      this.userLst = userLst;
  //  }

   // public ArrayList<SystemUser> getUserLst() {
     //   return userLst;
    //}

    
   public boolean auth(String username, String password){
       for(SystemUser systemUser : HotelDB.getUserLst()) {
           if(systemUser.getUsername().equals(username) && systemUser.getPassword().equals(password)){
               return true;
           }
           }
        return false;
    } 
   
    
   // public boolean verifyUser(String name){
     //   for(SystemUser systemUser : userLst){
       //     if(systemUser.getUsername().equals(name)){
         //       return true;
           // }
        //}
        //return false;
    //}
    
  //  public boolean changePassword(String name,String nPassword){
   //     for(User user : userLst){
  //         if(user.getUsername().equals(name)){
   //            user.setPassword(nPassword);
   //            return true;
   //        }
           
   //     }
   //     return false;
   // }

   
}
    //public SystemUser(String username, String password){
        //this.username = username;
        //this.password = password;
    //}

    //public String getUsername() {
      //  return username;
   // }

   // public String getPassword() {
   //     return password;
   // }
    
    
    
   // public boolean checkUserD(String username, String password){
   //     for(User user: userList){
    //     if(user.getUsername().equals(username) && user.getPassword().equals(password)){
    //         return true;
    //     } 
   // return false;




//import java.time.LocalDate;
//import java.util.ArrayList;
//
//public class SystemUser extends Staff{
//        String userName;
//	String password;
//	char loginStatus;
//
//	public SystemUser(String userName, String password, char loginStatus, String staffId, LocalDate joinDate, String jobTitle, String department, String name, String idNo, String emailAddress, Long contactNo, Address address) {
//		super(staffId, joinDate, jobTitle, department, name, idNo, emailAddress, contactNo, address);
//		this.userName = userName;
//		this.password = password;
//		this.loginStatus = loginStatus;
//	}
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public char getLoginStatus() {
//        return loginStatus;
//    }
//
//    public void setLoginStatus(char loginStatus) {
//        this.loginStatus = loginStatus;
//    }
//
