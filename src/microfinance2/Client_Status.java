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
public class Client_Status {
    private int Client_No;
     private String  Lastname;
        private String Firstname;
          private String  Middlename;
          private int   Mobile;
               private float  Balance;
                private String  Address;
                    private String  Payment_Regulation;
                     private String  Type_of_Loan;
                            private String  Client_Performance;
         
      public Client_Status(int Client_No,String  Lastname,String Firstname, String  Middlename,int Mobile,float  Balance,
          String  Address,String  Payment_Regulation,String Type_of_Loan,String  Client_Performance){
        this.Client_No= Client_No;
    this.Lastname= Lastname;
        this.Firstname= Firstname;
        this. Middlename=  Middlename;
        this. Mobile= Mobile;
      this. Balance= Balance;
   this.Address=  Address;
 this.Payment_Regulation= Payment_Regulation;
this.Type_of_Loan= Type_of_Loan;
      this.Client_Performance=  Client_Performance;
          
          
      }
      
      
      public int getClient_No(){
          return Client_No;
      }
      
          public String getLastname(){
          return Lastname;
      }
          
              public String getFirstname(){
          return Firstname;
      }
                  public String getMiddlename(){
          return Middlename;
      }
                      public int getMobile(){
          return Mobile;
      }
                          public float getBalance(){
          return Balance;
      }
                              public String getAddress(){
          return Address;
      }
                                  public String getPayment_Regulation(){
          return Payment_Regulation;
      }
                                      public String getType_of_Loan(){
          return Type_of_Loan;
      }
         
                                      public String getClient_Performance(){
          return Client_Performance;
      }
                                          
                          
                            
}
