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
public class DT_HomeLoan {
     private String Type_of_Loan;
             private int Client_No;
     private String Clients_Name;
    private String Payment_Regulation;
    private int No_of_Months;
        private String Term;
                private float Amount_of_Loan;
                     private float Interest_Rate;
                       private float Currency;
                            private float Total_Principal;
                      private String Date;
                            private String Time;
            
            
               
           public DT_HomeLoan(String Type_of_Loan,int Client_No,String Clients_Name,String Payment_Regulation,int No_of_Months,
String Term,float Amount_of_Loan,float Interest_Rate,float Currency,float Total_Principal,String Date,String Time){
        this.Type_of_Loan=Type_of_Loan;
            this.Client_No= Client_No;
    this.Clients_Name=Clients_Name;
   this.Payment_Regulation=Payment_Regulation;
  this. No_of_Months= No_of_Months;
  this.Term= Term;
             this.Amount_of_Loan=Amount_of_Loan;
               this.Interest_Rate= Interest_Rate;
                this.Currency=Currency;
                  this.Total_Principal= Total_Principal;
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
             public String getPayment_Regulation(){
              return Payment_Regulation;
          }
               public int getNo_of_Months(){
              return No_of_Months;
          }
                 public String getTerm(){
              return Term;
          }
                       public float getAmount_of_Loan(){
              return Amount_of_Loan;
          }
                       public float getInterest_Rate(){
              return Interest_Rate;
          }
                        public float getCurrency(){
              return Currency;
          }
                          public float getTotal_Principal(){
              return Total_Principal;
          }
                            public String getDate(){
              return Date;
          }
                               public String getTime(){
              return Time;
          }
}
