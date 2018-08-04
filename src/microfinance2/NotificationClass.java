/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microfinance2;

/**
 *
 * @author Ma. Eden M. Ramoneda
 */
public class NotificationClass {
     private int Client_No;
    private int Mobile;
     private String Email;
  
    
           
           
           public NotificationClass(int CID,int Mobile,String Email){
               this.Client_No = CID;
                this.Mobile = Mobile;
                 this.  Email =   Email;
              
              
           }
           public int getClient_No(){
           return Client_No;
}
         public int getMobile(){
           return Mobile;
}
         
          public String getEmail(){
           return Email;
}
  
}
