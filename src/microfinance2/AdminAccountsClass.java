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
public class AdminAccountsClass {
    private String firstname;
    private String lastname;
    private String middlename;
    private int phone;
      private String email;
        private String username;
          private String password;
          private byte[] image;
          
          
          public AdminAccountsClass(String firstname,String lastname,String middlename,int phone,String email,String username,String password,byte[] image){
              this.firstname=firstname;
                this.lastname=lastname;
                  this.middlename=middlename;
                    this.phone=phone;
                      this.email=email;
                        this.username=username;
                          this.password=password;
                            this.image=image;
          }
              public String getfirstname(){
                 return firstname;
              }
              public String getlastname(){
                 return lastname;
              }
              public String getmiddlename(){
                 return middlename;
              }
              public int getphone(){
                 return phone;
              }
              public String getemail(){
                 return email;
              }
                public String getusername(){
                 return username;
              }
                  public String getpassword(){
                 return password;
              }
          }
