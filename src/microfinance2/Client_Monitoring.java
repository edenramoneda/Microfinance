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
public class Client_Monitoring {
     private int Client_No;
     private String  Lastname;
        private String Firstname;
          private String  Middlename;
               private float  Balance;
                private String  Last_Payment;
                  private float  Amount_of_Loan;
                     private String  Type_of_Loan;
                       private float Amount_of_Payment;
                            private float Total_Principal;
                                 private float Currency;
                                      private float Interest_Rate;
                            private String  Payment_Date;
         
      public Client_Monitoring(int Client_No,String  Lastname,String Firstname,String  Middlename,float Balance,
          String  Last_Payment,float  Amount_of_Loan,String  Type_of_Loan,float Amount_of_Payment,
         float Total_Principal,float Currency,float Interest_Rate,String  Payment_Date){
     this.Client_No= Client_No;
    this.Lastname =Lastname;
       this. Firstname= Firstname;
         this.Middlename=Middlename;
            this.Balance= Balance;
               this.Last_Payment=  Last_Payment;
           this.Amount_of_Loan= Amount_of_Loan;
                   this.  Type_of_Loan=  Type_of_Loan;
                     this.Amount_of_Payment=  Amount_of_Payment;
                           this.Total_Principal=  Total_Principal;
                             this.Currency=  Currency;
                                    this.Interest_Rate= Interest_Rate;
                            this.Payment_Date=   Payment_Date;
     
          
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
           public float getBalance(){
               return Balance;
           }
              public String  getLast_Payment(){
                  return Last_Payment;
              }
           public float getAmount_of_Loan(){
               return Amount_of_Loan;
           }
                  public String getType_of_Loan(){
                      return Type_of_Loan;
                  }
                     public float getAmount_of_Payment(){
                         return Amount_of_Payment;
                     }
                           public float getTotal_Principal(){
                               return Total_Principal;
                           }
                             public float getCurrency(){
                                 return Currency;
                             }
                                   public float getInterest_Rate(){
                                       return Interest_Rate;
                                   }
                            public String getPayment_Date(){
                                return Payment_Date;
                            }
         
}
