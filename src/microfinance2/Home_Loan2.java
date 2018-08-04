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
public class Home_Loan2 {
      private String Type_of_Loan;
             private int Client_No;
     private String Clients_Name;
      private float No_Of_Payments;
       private float Clients_Payment;
           private float Amounts_Of_Payment; 
            private String Payment_Regulation; 
            private float Remaining_Balance; 
               private String Marks; 
               private String W_Use; 
                private String Date; 
                 private String Time; 
               
           public Home_Loan2(String Type_of_Loan,int Client_No,String Clients_Name,float No_Of_Payments,float Clients_Payment,
float Amounts_Of_Payment,String Payment_Regulation,float Remaining_Balance,String Marks,String W_Use,String Date,String Time ){
           this.Type_of_Loan = Type_of_Loan;
            this. Client_No = Client_No;
      this.Clients_Name =  Clients_Name;
       this.No_Of_Payments = No_Of_Payments;
      this.Clients_Payment = Clients_Payment;
          this.Amounts_Of_Payment = Amounts_Of_Payment; 
          this.Payment_Regulation = Payment_Regulation; 
            this.Remaining_Balance = Remaining_Balance; 
            this.Marks =Marks; 
             this.W_Use = W_Use; 
               this.Date = Date; 
               this.Time = Time; 
           }
           public String getType_of_Loan(){
           return Type_of_Loan;
}
          public int getClient_No(){
              return Client_No;
          }
          
          public String getClients_Name(){
              return Clients_Name;
          }
             public float getNo_Of_Payments(){
              return No_Of_Payments;
          }
                public float getClients_Payment(){
              return Clients_Payment;
          }
                  public float getAmounts_Of_Payment(){
              return Amounts_Of_Payment;
          }
                        public String getPayment_Regulation(){
              return Payment_Regulation;
          }
                          public float getRemaining_Balance(){
              return Remaining_Balance;
          }
                             public String getMarks(){
              return Marks;
          }
                            public String getW_Use(){
              return W_Use;
          }          
           public String getDate(){
              return Date;
          }      
        public String getTime(){
              return Time;
          }     
}
