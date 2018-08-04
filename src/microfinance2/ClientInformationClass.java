/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microfinance2;

import java.util.Date;

/**
 *
 * @author Ma. Eden M. Ramoneda
 */
public class ClientInformationClass {
       private int Client_No;
    private String Lastname;
     private String Firstname;
      private String Middlename;
       private String Gender;
         private String Birthday;
            private String Place_Of_Birth;
               private String Civil_Status;
       private String Current_Address;
       private int Mobile;
       private int Telephone;
       private String Nationality;
       private String Occupation;
       private String Source_Of_Income;
          private String Email;
      private String Company_Name;
          private String Mother_Maiden_Name;
          private float Amount_of_Payment;
          private String Date_of_Payment;
             private String CR_Full_Name;
              private int CR_Mobile;
               private String CR_Position;
                  private String CR1_Full_Name;
              private int CR1_Mobile;
               private String CR1_Position;
           private byte[] Image_CI;
           
           
           public ClientInformationClass(int Client_No,String Lastname,String Firstname,String Middlename,
  String Gender,String Birthday,String Place_Of_Birth,String Civil_Status,String Current_Address,
int Mobile,int Telephone,String Nationality,String Occupation,String Source_Of_Income,String Email,String Company_Name,
String Mother_Maiden_Name,float Amount_of_Payment,String Date_of_Payment,String CR_Full_Name,int CR_Mobile,String CR_Position,String CR1_Full_Name,int CR1_Mobile,String CR1_Position,byte[] Image_CI){
              this.Client_No =Client_No;
  this.Lastname =Lastname;
    this.Firstname =Firstname;
     this.Middlename =Middlename;
      this.Gender =Gender;
        this.Birthday =Birthday;
            this.Place_Of_Birth =Place_Of_Birth;
              this.Civil_Status =Civil_Status;
      this.Current_Address = Current_Address;
     this.Mobile =Mobile;
      this.Telephone =Telephone;
     this.Nationality =Nationality;
      this.Occupation =Occupation;
      this.Source_Of_Income =Source_Of_Income;
     this.Email= Email;
    this.Company_Name =Company_Name;
      this.Mother_Maiden_Name = Mother_Maiden_Name;
      this.Amount_of_Payment = Amount_of_Payment;
      this.Date_of_Payment = Date_of_Payment;
           this.CR_Full_Name = CR_Full_Name;
             this.CR_Mobile = CR_Mobile;
               this.CR_Position = CR_Position;
                   this.CR1_Full_Name = CR1_Full_Name;
             this.CR1_Mobile = CR1_Mobile;
               this.CR1_Position = CR1_Position;
          this.Image_CI =Image_CI;
           
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
           public String getGender(){
           return Gender;
}
           public String getBirthday(){
           return Birthday;
}
           public String getPlace_Of_Birth(){
           return Place_Of_Birth;
}
public String getCivil_Status(){
           return Civil_Status;
}
public String getCurrent_Address(){
           return Current_Address;
}
public int getMobile(){
           return Mobile;
}
public int getTelephone(){
           return Telephone;
}

public String getNationality(){
           return Nationality;
}
public String getOccupation(){
           return Occupation;
}
public String getSource_Of_Income(){
           return Source_Of_Income;
}
public String getEmail(){
           return Email;
}
public String getCompany_Name(){
           return Company_Name;
}
public String getMother_Maiden_Name(){
           return Mother_Maiden_Name;
}
public float getAmount_of_Payment(){
           return Amount_of_Payment;
}
public String getDate_of_Payment(){
           return Date_of_Payment;
}
public String getCR_Full_Name(){
           return CR_Full_Name;
}
public int getCR_Mobile(){
           return CR_Mobile;
}
public String getCR_Position(){
           return CR_Position;
}
public String getCR1_Full_Name(){
           return CR_Full_Name;
}
public int getCR1_Mobile(){
           return CR_Mobile;
}
public String getCR1_Position(){
           return CR_Position;
}
           public byte[] getImage_CI(){
           return Image_CI;
}
    
}
