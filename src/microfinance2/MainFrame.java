/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microfinance2;

import com.sun.glass.events.KeyEvent;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import net.proteanit.sql.DbUtils;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author john
 */
public class MainFrame extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String ImgPath = null;
    DefaultTableModel dm;

    public MainFrame() {
        initComponents();
        ShowDataInClientInformationTable();
        ShowDataInNotificationTable();
       ShowDataInPersonalLoan2Table();
        ShowDataInOFW_Loan2Table();
        ShowDataInSalary_Loan2Table() ;
         ShowDataInHome_Loan2Table();
      ShowDataInBusiness_Loan2Table();
    ShowDataInDT_BusinessLoanTable();
    ShowDataInDT_PersonalLoanTable();
    ShowDataInDT_HomeLoanTable();
    ShowDataInDT_OFWLoanTable();
    ShowDataInDT_SalaryLoanTable();
    ShowDataInClient_StatusTable();
    ShowDataInClient_MonitoringTable();
   New1.hide();
    Edit_Button2.hide();
     Save_Button2.hide();
      Update_Button2.hide();
       Attach_Photo1.hide();
        del_Button1.hide();
        con = MainFrame.getConnectionDB();
        jComboBox2.setSelectedItem((null));
        jComboBox4.setSelectedItem((null));
        jComboBox1.setSelectedItem((null));
        cmpanel.hide();
        socialmonitoring.hide();
        saving.hide();
        consolidation.hide();
        InitDate();
        InitTime();
        ClientInformationTable.setAutoResizeMode(ClientInformationTable.AUTO_RESIZE_OFF);
         NotificationTable.setAutoResizeMode(NotificationTable.AUTO_RESIZE_OFF);
            Personal_Loan2.setAutoResizeMode(Personal_Loan2.AUTO_RESIZE_OFF);
        Client_Status.setAutoResizeMode(Client_Status.AUTO_RESIZE_OFF);
             Client_Monitoring.setAutoResizeMode(Client_Monitoring.AUTO_RESIZE_OFF);
    
         OFW_Loan2.setAutoResizeMode(OFW_Loan2.AUTO_RESIZE_OFF);
          Salary_Loan2.setAutoResizeMode(Salary_Loan2.AUTO_RESIZE_OFF);
         Home_Loan2.setAutoResizeMode(Home_Loan2.AUTO_RESIZE_OFF);
           Business_Loan2.setAutoResizeMode(Business_Loan2.AUTO_RESIZE_OFF);
            jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
            Home_Loan.setAutoResizeMode(Home_Loan.AUTO_RESIZE_OFF);
            Salary_Loan.setAutoResizeMode(Salary_Loan.AUTO_RESIZE_OFF);
             OFW_Loan.setAutoResizeMode(Salary_Loan.AUTO_RESIZE_OFF);
             Personal_Loan.setAutoResizeMode(Salary_Loan.AUTO_RESIZE_OFF);
             
    }
    int xMouse;
    int yMouse;
    String driver = "com.microsoft.sqlserver.jdbc.SQLDriverManager";
    String url = "jdbc:sqlserver://EDENRAMONEDA:1433;databaseName=Core2";
    String user = "sa";
    String pass = "edenrams";
   

    //for Settings
    public void InitDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
        Date.setText(s.format(d));
    }

    //initialize time
    public void InitTime() {
        new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                Time.setText(sdf.format(d));
            }
        }) {
        }.start();
    }

    public static Connection getConnectionDB() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://EDENRAMONEDA:1433;databaseName=core2", "sa", "edenrams");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    //FOR SEARCH DATA IN CLIENTS TRANSACTION
         public ResultSet businessloan(String businessloan){
                Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
           try{
           con = DriverManager.getConnection("jdbc:sqlserver://EDENRAMONEDA:1433;databasename=core2","sa","edenrams");
           ps = con.prepareStatement("select * from CT_BusinessLoan where Client_No = ?");
           ps.setString(1,businessloan);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
          public ResultSet HomeLoan(String homeloan){
                Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
           try{
            con = DriverManager.getConnection("jdbc:sqlserver://EDENRAMONEDA:1433;databasename=core2","sa","edenrams");
             ps = con.prepareStatement("select * from CT_HomeLoan where Client_No = ?");
           ps.setString(1,homeloan);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
          public ResultSet OFWLoan(String ofwloan){
                Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
           try{
            con = DriverManager.getConnection("jdbc:sqlserver://EDENRAMONEDA:1433;databasename=core2","sa","edenrams");
             ps = con.prepareStatement("select * from CT_OFWLoan where Client_No = ?");
           ps.setString(1,ofwloan);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
              public ResultSet PersonalLoan(String personalloan){
                Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
           try{
            con = DriverManager.getConnection("jdbc:sqlserver://EDENRAMONEDA:1433;databasename=core2","sa","edenrams");
             ps = con.prepareStatement("select * from CT_PersonalLoan where Client_No = ?");
           ps.setString(1,personalloan);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
               public ResultSet SalaryLoan(String salaryloan){
                Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
           try{
            con = DriverManager.getConnection("jdbc:sqlserver://EDENRAMONEDA:1433;databasename=core2","sa","edenrams");
             ps = con.prepareStatement("select * from CT_SalaryLoan where Client_No = ?");
           ps.setString(1,salaryloan);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }

    //for scaling image that photo will not move
    private Image scalingImage(byte[] image, int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        try {
            Graphics2D icon = img.createGraphics();
            icon.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            //convert byte array to bufferedImage
            ByteArrayInputStream img1 = new ByteArrayInputStream(image);
            BufferedImage bImageFromConvert = ImageIO.read(in);

            icon.drawImage(bImageFromConvert, 0, 0, w, h, null);
            icon.dispose();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return img;
    }
    // Resize Image

    public ImageIcon ResizeImage(String imagePath, byte[] image) {
        ImageIcon myImage = null;

        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(image);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_DisplayImage.getWidth(), lbl_DisplayImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon picture = new ImageIcon(img2);
        return picture;
    }

    //Load Admin INFO in Settings
    public ArrayList<AdminAccountsClass> getAdminAccountsClassList() {
        ArrayList<AdminAccountsClass> AdminAccountsClassList = new ArrayList<AdminAccountsClass>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM adaccounts";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
            AdminAccountsClass AdminAccountsClass;
            while (rs.next()) {

                AdminAccountsClass = new AdminAccountsClass(rs.getString("firstname"), rs.getString("lastname"), rs.getString("middlename"), rs.getInt("phone"),
                        rs.getString("email"), rs.getString("username"),
                        rs.getString("password"), rs.getBytes("image"));
                AdminAccountsClassList.add(AdminAccountsClass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminAccountsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AdminAccountsClassList;
    }
    //for showing data in ClientInformationTable 

    public ArrayList<ClientInformationClass> getClientInformationClassList() {
        ArrayList<ClientInformationClass> ClientInformationClassList = new ArrayList<ClientInformationClass>();//calling clientInformationClass.java
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM ClientInformation";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
            ClientInformationClass ClientInformationClass;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
                ClientInformationClass = new ClientInformationClass(rs.getInt("Client_No"), rs.getString("Lastname"), rs.getString("Firstname"), rs.getString("Middlename"), rs.getString("Gender"),
                        rs.getString("Birthday"), rs.getString("Place_Of_Birth"), rs.getString("Civil_Status"), rs.getString("Current_Address"), rs.getInt("Mobile"), rs.getInt("Telephone"), rs.getString("Nationality"), rs.getString("Occupation"),
                        rs.getString("Source_Of_Income"), rs.getString("Email"), rs.getString("Company_Name"), rs.getString("Mother_Maiden_Name"),rs.getFloat("Amount_of_Payment"),rs.getString("Date_of_Payment"),rs.getString("CR_Full_Name"), rs.getInt("CR_Mobile"), rs.getString("CR_Position"),rs.getString("CR1_Full_Name"), rs.getInt("CR1_Mobile"), rs.getString("CR1_Position"), rs.getBytes("Image_CI"));
                ClientInformationClassList.add(ClientInformationClass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientInformationClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ClientInformationClassList;
    }

    public void ShowDataInClientInformationTable() {
        ArrayList<ClientInformationClass> list = getClientInformationClassList();
        DefaultTableModel model = (DefaultTableModel) ClientInformationTable.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[25];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getClient_No();
            row[1] = list.get(i).getLastname();
            row[2] = list.get(i).getFirstname();
            row[3] = list.get(i).getMiddlename();
            row[4] = list.get(i).getGender();
            row[5] = list.get(i).getBirthday();
            row[6] = list.get(i).getPlace_Of_Birth();
            row[7] = list.get(i).getCivil_Status();
            row[8] = list.get(i).getCurrent_Address();
            row[9] = list.get(i).getMobile();
            row[10] = list.get(i).getTelephone();
            row[11] = list.get(i).getNationality();
            row[12] = list.get(i).getOccupation();
            row[13] = list.get(i).getSource_Of_Income();
            row[14] = list.get(i).getEmail();
            row[15] = list.get(i).getCompany_Name();
            row[16] = list.get(i).getMother_Maiden_Name();
               row[17] = list.get(i).getAmount_of_Payment();
                 row[18] = list.get(i).getDate_of_Payment();
            row[19] = list.get(i).getCR_Full_Name();
            row[20] = list.get(i).getCR_Mobile();
            row[21] = list.get(i).getCR_Position();
             row[22] = list.get(i).getCR1_Full_Name();
            row[23] = list.get(i).getCR1_Mobile();
            row[24] = list.get(i).getCR1_Position();
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInClientInformation(int index) {

        jTextField21.setText(Integer.toString(getClientInformationClassList().get(index).getClient_No()));
        jTextField77.setText(getClientInformationClassList().get(index).getLastname());
        jTextField78.setText(getClientInformationClassList().get(index).getFirstname());
        jTextField79.setText(getClientInformationClassList().get(index).getMiddlename());
        jComboBox4.setSelectedItem(getClientInformationClassList().get(index).getGender());
        try {
            Date addDate = null;
            addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) getClientInformationClassList().get(index).getBirthday());
            jDateChooser3.setDate(addDate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        jTextField150.setText(getClientInformationClassList().get(index).getPlace_Of_Birth());
        jComboBox2.setSelectedItem(getClientInformationClassList().get(index).getCivil_Status());
        jTextField84.setText(getClientInformationClassList().get(index).getCurrent_Address());
        jTextField83.setText(Integer.toString(getClientInformationClassList().get(index).getMobile()));
        jTextField151.setText(Integer.toString(getClientInformationClassList().get(index).getTelephone()));
        jTextField85.setText(getClientInformationClassList().get(index).getNationality());
        jTextField80.setText(getClientInformationClassList().get(index).getOccupation());
        jTextField81.setText(getClientInformationClassList().get(index).getSource_Of_Income());
        jTextField82.setText(getClientInformationClassList().get(index).getEmail());
        jTextField152.setText(getClientInformationClassList().get(index).getCompany_Name());
        jTextField153.setText(getClientInformationClassList().get(index).getMother_Maiden_Name());
         jTextField29.setText(Float.toString(getClientInformationClassList().get(index).getAmount_of_Payment()));
       jTextField30.setText(getClientInformationClassList().get(index).getDate_of_Payment());
        jTextField154.setText(getClientInformationClassList().get(index).getCR_Full_Name());
        jTextField155.setText(Integer.toString(getClientInformationClassList().get(index).getCR_Mobile()));
        jTextField156.setText(getClientInformationClassList().get(index).getCR_Position());
         jTextField158.setText(getClientInformationClassList().get(index).getCR1_Full_Name());
        jTextField159.setText(Integer.toString(getClientInformationClassList().get(index).getCR1_Mobile()));
        jTextField160.setText(getClientInformationClassList().get(index).getCR1_Position());
        lbl_DisplayImage.setIcon(ResizeImage(null, getClientInformationClassList().get(index).getImage_CI()));
    }
    //for NOTIFICATIONTABLE

    public ArrayList<NotificationClass> getNotificationClassList() {
        ArrayList<NotificationClass> NotificationClassList = new ArrayList<NotificationClass>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM Notification";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
            NotificationClass NotificationClass;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
                NotificationClass = new NotificationClass(rs.getInt("Client_No"), rs.getInt("Mobile"), rs.getString("Email"));
                NotificationClassList.add(NotificationClass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NotificationClassList;
    }

    public void ShowDataInNotificationTable() {
        ArrayList<NotificationClass> list = getNotificationClassList();
        DefaultTableModel model = (DefaultTableModel) NotificationTable.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getClient_No();
            row[1] = list.get(i).getMobile();
            row[2] = list.get(i).getEmail();
            model.addRow(row);
        }
    }

   
    public void ShowDataInNotification(int Notification) {

        jTextField88.setText(Integer.toString(getNotificationClassList().get(Notification).getClient_No()));
        jTextField87.setText(Integer.toString(getNotificationClassList().get(Notification).getMobile()));
        jTextField86.setText(getNotificationClassList().get(Notification).getEmail());
    
    }
    
  
    public ArrayList<WithdrawalsClass> getWithdrawalsClassList() {
        ArrayList<WithdrawalsClass> WithdrawalsClassList = new ArrayList<WithdrawalsClass>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM WT_PersonalLoan2";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
           WithdrawalsClass WithdrawalsClass;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
                WithdrawalsClass = new WithdrawalsClass(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"), rs.getFloat("No_Of_Payments"),rs.getFloat("Clients_Payment"),rs.getFloat("Amounts_Of_Payment"),rs.getString("Payment_Regulation"),rs.getFloat("Remaining_Balance"),
                rs.getString("Marks"),rs.getString("W_Use"),rs.getString("Date"),rs.getString("Time"));
                WithdrawalsClassList.add(WithdrawalsClass);
            }
        } catch (SQLException ex) {
            Logger.getLogger( WithdrawalsClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  WithdrawalsClassList;
    }

    public Collection ShowDataInPersonalLoan2Table() {
        ArrayList<WithdrawalsClass> list = getWithdrawalsClassList();
        DefaultTableModel model = (DefaultTableModel) Personal_Loan2.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getNo_Of_Payments();
                    row[4] = list.get(i).getClients_Payment();
                      row[5] = list.get(i).getAmounts_Of_Payment();
                        row[6] = list.get(i).getPayment_Regulation();
                          row[7] = list.get(i).getRemaining_Balance();
                            row[8] = list.get(i).getMarks();
                              row[9] = list.get(i).getW_Use();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
        return list;
    }
public void emptytextField(){
  
       jTextField4.setText("");
        jTextField5.setText("");
          jTextField22.setText("");
            jTextField28.setText("");
              jTextField27.setText("");
               jTextField24.setText("");
                jTextField25.setText("");
                Marks.setSelectedItem((null));
                  Use.setSelectedItem((null));
                   jTextField23.setText("");
                    jTextField26.setText("");
}
public void emptytextFieldDeposits(){
  
       jTextField2.setText("");
        jTextField3.setText("");
          Payment_Regulation.setSelectedItem((null));
            jTextField20.setText("");
             Term.setSelectedItem((null));
               jTextField8.setText("");
                jTextField9.setText("");
                   jTextField10.setText("");
                    jTextField11.setText("");
                      jTextField7.setText("");
                        jTextField12.setText("");
}
//MULA DITO
    //for showing data in textField when table was clicked
    public void ShowDataInPersonalLoan2(int personal_loan2) {

        jComboBox9.setSelectedItem(getWithdrawalsClassList().get(personal_loan2).getType_of_Loan());
       jTextField4.setText(Integer.toString(getWithdrawalsClassList().get(personal_loan2).getClient_No()));
        jTextField5.setText(getWithdrawalsClassList().get(personal_loan2).getClients_Name());
          jTextField22.setText(Float.toString(getWithdrawalsClassList().get(personal_loan2).getNo_Of_Payments()));
            jTextField28.setText(Float.toString(getWithdrawalsClassList().get(personal_loan2).getClients_Payment()));
              jTextField27.setText(Float.toString(getWithdrawalsClassList().get(personal_loan2).getAmounts_Of_Payment()));
               jTextField24.setText(getWithdrawalsClassList().get(personal_loan2).getPayment_Regulation());
                jTextField25.setText(Float.toString(getWithdrawalsClassList().get(personal_loan2).getRemaining_Balance()));
                Marks.setSelectedItem(getWithdrawalsClassList().get(personal_loan2).getMarks());
                  Use.setSelectedItem(getWithdrawalsClassList().get(personal_loan2).getW_Use());
                   jTextField23.setText(getWithdrawalsClassList().get(personal_loan2).getDate());
                    jTextField26.setText(getWithdrawalsClassList().get(personal_loan2).getTime());
    }
 //for ofwloan2
    public ArrayList<OFWLoan2> getOFWLoan2List() {
        ArrayList<OFWLoan2> OFWLoan2List = new ArrayList<OFWLoan2>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM WT_OFWLoan2";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
         OFWLoan2 OFWLoan2;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
                OFWLoan2 = new OFWLoan2(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"), rs.getFloat("No_Of_Payments"),rs.getFloat("Clients_Payment"),rs.getFloat("Amounts_Of_Payment"),rs.getString("Payment_Regulation"),rs.getFloat("Remaining_Balance"),
                rs.getString("Marks"),rs.getString("W_Use"),rs.getString("Date"),rs.getString("Time"));
                OFWLoan2List.add(OFWLoan2);
            }
        } catch (SQLException ex) {
            Logger.getLogger( OFWLoan2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  OFWLoan2List;
    }

    public void ShowDataInOFW_Loan2Table() {
        ArrayList<OFWLoan2> list = getOFWLoan2List();
        DefaultTableModel model = (DefaultTableModel) OFW_Loan2.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getNo_Of_Payments();
                    row[4] = list.get(i).getClients_Payment();
                      row[5] = list.get(i).getAmounts_Of_Payment();
                        row[6] = list.get(i).getPayment_Regulation();
                          row[7] = list.get(i).getRemaining_Balance();
                            row[8] = list.get(i).getMarks();
                              row[9] = list.get(i).getW_Use();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInOFW_Loan2(int OFW_Loan2) {

        jComboBox9.setSelectedItem(getOFWLoan2List().get(OFW_Loan2).getType_of_Loan());
       jTextField4.setText(Integer.toString(getOFWLoan2List().get(OFW_Loan2).getClient_No()));
        jTextField5.setText(getOFWLoan2List().get(OFW_Loan2).getClients_Name());
          jTextField22.setText(Float.toString(getOFWLoan2List().get(OFW_Loan2).getNo_Of_Payments()));
            jTextField28.setText(Float.toString(getOFWLoan2List().get(OFW_Loan2).getClients_Payment()));
              jTextField27.setText(Float.toString(getOFWLoan2List().get(OFW_Loan2).getAmounts_Of_Payment()));
               jTextField24.setText(getOFWLoan2List().get(OFW_Loan2).getPayment_Regulation());
                jTextField25.setText(Float.toString(getOFWLoan2List().get(OFW_Loan2).getRemaining_Balance()));
                Marks.setSelectedItem(getOFWLoan2List().get(OFW_Loan2).getMarks());
                  Use.setSelectedItem(getOFWLoan2List().get(OFW_Loan2).getW_Use());
                   jTextField23.setText(getOFWLoan2List().get(OFW_Loan2).getDate());
                    jTextField26.setText(getOFWLoan2List().get(OFW_Loan2).getTime());
    }
   //HANGGANG SA TAAS
    //for Salary_Loan2
    public ArrayList<Salary_Loan2> getSalary_Loan2List() {
        ArrayList<Salary_Loan2> Salary_Loan2List = new ArrayList<Salary_Loan2>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM WT_Salary_Loan2";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
         Salary_Loan2 Salary_Loan2;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
                Salary_Loan2 = new Salary_Loan2(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"), rs.getFloat("No_Of_Payments"),rs.getFloat("Clients_Payment"),rs.getFloat("Amounts_Of_Payment"),rs.getString("Payment_Regulation"),rs.getFloat("Remaining_Balance"),
                rs.getString("Marks"),rs.getString("W_Use"),rs.getString("Date"),rs.getString("Time"));
                Salary_Loan2List.add(Salary_Loan2);
            }
        } catch (SQLException ex) {
            Logger.getLogger( Salary_Loan2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  Salary_Loan2List;
    }

    public void ShowDataInSalary_Loan2Table() {
        ArrayList<Salary_Loan2> list = getSalary_Loan2List();
        DefaultTableModel model = (DefaultTableModel) Salary_Loan2.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getNo_Of_Payments();
                    row[4] = list.get(i).getClients_Payment();
                      row[5] = list.get(i).getAmounts_Of_Payment();
                        row[6] = list.get(i).getPayment_Regulation();
                          row[7] = list.get(i).getRemaining_Balance();
                            row[8] = list.get(i).getMarks();
                              row[9] = list.get(i).getW_Use();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInSalary_Loan2(int Salary_Loan2) {

        jComboBox9.setSelectedItem(getSalary_Loan2List().get(Salary_Loan2).getType_of_Loan());
       jTextField4.setText(Integer.toString(getSalary_Loan2List().get(Salary_Loan2).getClient_No()));
        jTextField5.setText(getSalary_Loan2List().get(Salary_Loan2).getClients_Name());
          jTextField22.setText(Float.toString(getSalary_Loan2List().get(Salary_Loan2).getNo_Of_Payments()));
            jTextField28.setText(Float.toString(getSalary_Loan2List().get(Salary_Loan2).getClients_Payment()));
              jTextField27.setText(Float.toString(getSalary_Loan2List().get(Salary_Loan2).getAmounts_Of_Payment()));
               jTextField24.setText(getSalary_Loan2List().get(Salary_Loan2).getPayment_Regulation());
                jTextField25.setText(Float.toString(getSalary_Loan2List().get(Salary_Loan2).getRemaining_Balance()));
                Marks.setSelectedItem(getSalary_Loan2List().get(Salary_Loan2).getMarks());
                  Use.setSelectedItem(getSalary_Loan2List().get(Salary_Loan2).getW_Use());
                   jTextField23.setText(getSalary_Loan2List().get(Salary_Loan2).getDate());
                    jTextField26.setText(getSalary_Loan2List().get(Salary_Loan2).getTime());
    }
      //for Home_Loan2
    public ArrayList<Home_Loan2> getHome_Loan2List() {
        ArrayList<Home_Loan2> Home_Loan2List = new ArrayList<Home_Loan2>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM WT_HomeLoan2";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
         Home_Loan2 Home_Loan2;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
               Home_Loan2 = new Home_Loan2(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"), rs.getFloat("No_Of_Payments"),rs.getFloat("Clients_Payment"),rs.getFloat("Amounts_Of_Payment"),rs.getString("Payment_Regulation"),rs.getFloat("Remaining_Balance"),
                rs.getString("Marks"),rs.getString("W_Use"),rs.getString("Date"),rs.getString("Time"));
                Home_Loan2List.add(Home_Loan2);
            }
        } catch (SQLException ex) {
            Logger.getLogger( Salary_Loan2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  Home_Loan2List;
    }

    public void ShowDataInHome_Loan2Table() {
        ArrayList<Home_Loan2> list = getHome_Loan2List();
        DefaultTableModel model = (DefaultTableModel) Home_Loan2.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getNo_Of_Payments();
                    row[4] = list.get(i).getClients_Payment();
                      row[5] = list.get(i).getAmounts_Of_Payment();
                        row[6] = list.get(i).getPayment_Regulation();
                          row[7] = list.get(i).getRemaining_Balance();
                            row[8] = list.get(i).getMarks();
                              row[9] = list.get(i).getW_Use();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInHome_Loan2(int Home_Loan2) {

        jComboBox9.setSelectedItem(getHome_Loan2List().get(Home_Loan2).getType_of_Loan());
       jTextField4.setText(Integer.toString(getHome_Loan2List().get(Home_Loan2).getClient_No()));
        jTextField5.setText(getHome_Loan2List().get(Home_Loan2).getClients_Name());
          jTextField22.setText(Float.toString(getHome_Loan2List().get(Home_Loan2).getNo_Of_Payments()));
            jTextField28.setText(Float.toString(getHome_Loan2List().get(Home_Loan2).getClients_Payment()));
              jTextField27.setText(Float.toString(getHome_Loan2List().get(Home_Loan2).getAmounts_Of_Payment()));
               jTextField24.setText(getHome_Loan2List().get(Home_Loan2).getPayment_Regulation());
                jTextField25.setText(Float.toString(getHome_Loan2List().get(Home_Loan2).getRemaining_Balance()));
                Marks.setSelectedItem(getHome_Loan2List().get(Home_Loan2).getMarks());
                  Use.setSelectedItem(getHome_Loan2List().get(Home_Loan2).getW_Use());
                   jTextField23.setText(getHome_Loan2List().get(Home_Loan2).getDate());
                    jTextField26.setText(getHome_Loan2List().get(Home_Loan2).getTime());
    }
    //for Business_Loan2
    public ArrayList<Business_Loan2> getBusiness_Loan2List() {
        ArrayList<Business_Loan2> Business_Loan2List = new ArrayList<Business_Loan2>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM WT_BusinessLoan2";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
         Business_Loan2 Business_Loan2;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
               Business_Loan2 = new Business_Loan2(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"), rs.getFloat("No_Of_Payments"),rs.getFloat("Clients_Payment"),rs.getFloat("Amounts_Of_Payment"),rs.getString("Payment_Regulation"),rs.getFloat("Remaining_Balance"),
                rs.getString("Marks"),rs.getString("W_Use"),rs.getString("Date"),rs.getString("Time"));
                Business_Loan2List.add(Business_Loan2);
            }
        } catch (SQLException ex) {
            Logger.getLogger( Salary_Loan2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  Business_Loan2List;
    }

    public void ShowDataInBusiness_Loan2Table() {
        ArrayList<Business_Loan2> list = getBusiness_Loan2List();
        DefaultTableModel model = (DefaultTableModel) Business_Loan2.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getNo_Of_Payments();
                    row[4] = list.get(i).getClients_Payment();
                      row[5] = list.get(i).getAmounts_Of_Payment();
                        row[6] = list.get(i).getPayment_Regulation();
                          row[7] = list.get(i).getRemaining_Balance();
                            row[8] = list.get(i).getMarks();
                              row[9] = list.get(i).getW_Use();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInBusiness_Loan2(int Business_Loan2) {

        jComboBox9.setSelectedItem(getBusiness_Loan2List().get(Business_Loan2).getType_of_Loan());
       jTextField4.setText(Integer.toString(getBusiness_Loan2List().get(Business_Loan2).getClient_No()));
        jTextField5.setText(getBusiness_Loan2List().get(Business_Loan2).getClients_Name());
          jTextField22.setText(Float.toString(getBusiness_Loan2List().get(Business_Loan2).getNo_Of_Payments()));
            jTextField28.setText(Float.toString(getBusiness_Loan2List().get(Business_Loan2).getClients_Payment()));
              jTextField27.setText(Float.toString(getBusiness_Loan2List().get(Business_Loan2).getAmounts_Of_Payment()));
               jTextField24.setText(getBusiness_Loan2List().get(Business_Loan2).getPayment_Regulation());
                jTextField25.setText(Float.toString(getBusiness_Loan2List().get(Business_Loan2).getRemaining_Balance()));
                Marks.setSelectedItem(getBusiness_Loan2List().get(Business_Loan2).getMarks());
                  Use.setSelectedItem(getBusiness_Loan2List().get(Business_Loan2).getW_Use());
                   jTextField23.setText(getBusiness_Loan2List().get(Business_Loan2).getDate());
                    jTextField26.setText(getBusiness_Loan2List().get(Business_Loan2).getTime());
    }
    //for DT_BusinessLoan
    public ArrayList<DT_BusinessLoan> getDT_BusinessLoanList() {
        ArrayList<DT_BusinessLoan> DT_BusinessLoanList = new ArrayList<DT_BusinessLoan>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM DT_BusinessLoan";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
        DT_BusinessLoan DT_BusinessLoan;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
               DT_BusinessLoan = new DT_BusinessLoan(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"),rs.getString("Payment_Regulation"),rs.getInt("No_of_Months"),
                rs.getString("Term"),rs.getFloat("Amount_of_Loan"), rs.getFloat("Interest_Rate"),rs.getFloat("Currency"),rs.getFloat("Total_Principal"),rs.getString("Date"),rs.getString("Time"));
                DT_BusinessLoanList.add(DT_BusinessLoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger( DT_BusinessLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  DT_BusinessLoanList;
    }

    public void ShowDataInDT_BusinessLoanTable() {
        ArrayList<DT_BusinessLoan> list = getDT_BusinessLoanList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getPayment_Regulation();
                    row[4] = list.get(i).getNo_of_Months();
                      row[5] = list.get(i).getTerm();
                          row[6] = list.get(i).getAmount_of_Loan();
                            row[7] = list.get(i).getInterest_Rate();
                              row[8] = list.get(i).getCurrency();
                                row[9] = list.get(i).getTotal_Principal();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInDT_BusinessLoan(int DT_BusinessLoan) {

        jComboBox3.setSelectedItem(getDT_BusinessLoanList().get(DT_BusinessLoan).getType_of_Loan());
       jTextField2.setText(Integer.toString(getDT_BusinessLoanList().get(DT_BusinessLoan).getClient_No()));
        jTextField3.setText(getDT_BusinessLoanList().get(DT_BusinessLoan).getClients_Name());
         Payment_Regulation.setSelectedItem(getDT_BusinessLoanList().get(DT_BusinessLoan).getPayment_Regulation());
           jTextField20.setText(Integer.toString(getDT_BusinessLoanList().get(DT_BusinessLoan).getNo_of_Months()));
           Term.setSelectedItem(getDT_BusinessLoanList().get(DT_BusinessLoan).getTerm());
            jTextField8.setText(Float.toString(getDT_BusinessLoanList().get(DT_BusinessLoan).getAmount_of_Loan()));
              jTextField9.setText(Float.toString(getDT_BusinessLoanList().get(DT_BusinessLoan).getInterest_Rate()));
               jTextField10.setText(Float.toString(getDT_BusinessLoanList().get(DT_BusinessLoan).getCurrency()));
                jTextField11.setText(Float.toString(getDT_BusinessLoanList().get(DT_BusinessLoan).getTotal_Principal()));
                   jTextField7.setText(getDT_BusinessLoanList().get(DT_BusinessLoan).getDate());
                    jTextField12.setText(getDT_BusinessLoanList().get(DT_BusinessLoan).getTime());
    }
    
     //for DT_HomeLoan
    public ArrayList<DT_HomeLoan> getDT_HomeLoanList() {
        ArrayList<DT_HomeLoan> DT_HomeLoanList = new ArrayList<DT_HomeLoan>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM DT_HomeLoan";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
       DT_HomeLoan DT_HomeLoan;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
              DT_HomeLoan = new DT_HomeLoan(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"),rs.getString("Payment_Regulation"),rs.getInt("No_of_Months"),
                rs.getString("Term"),rs.getFloat("Amount_of_Loan"), rs.getFloat("Interest_Rate"),rs.getFloat("Currency"),rs.getFloat("Total_Principal"),rs.getString("Date"),rs.getString("Time"));
               DT_HomeLoanList.add(DT_HomeLoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger( DT_HomeLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  DT_HomeLoanList;
    }

    public void ShowDataInDT_HomeLoanTable() {
        ArrayList<DT_HomeLoan> list = getDT_HomeLoanList();
        DefaultTableModel model = (DefaultTableModel) Home_Loan.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getPayment_Regulation();
                    row[4] = list.get(i).getNo_of_Months();
                      row[5] = list.get(i).getTerm();
                          row[6] = list.get(i).getAmount_of_Loan();
                            row[7] = list.get(i).getInterest_Rate();
                              row[8] = list.get(i).getCurrency();
                                row[9] = list.get(i).getTotal_Principal();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInDT_HomeLoan(int DT_HomeLoan) {

        jComboBox3.setSelectedItem(getDT_HomeLoanList().get(DT_HomeLoan).getType_of_Loan());
       jTextField2.setText(Integer.toString(getDT_HomeLoanList().get(DT_HomeLoan).getClient_No()));
        jTextField3.setText(getDT_HomeLoanList().get(DT_HomeLoan).getClients_Name());
         Payment_Regulation.setSelectedItem(getDT_HomeLoanList().get(DT_HomeLoan).getPayment_Regulation());
           jTextField20.setText(Integer.toString(getDT_HomeLoanList().get(DT_HomeLoan).getNo_of_Months()));
           Term.setSelectedItem(getDT_HomeLoanList().get(DT_HomeLoan).getTerm());
            jTextField8.setText(Float.toString(getDT_HomeLoanList().get(DT_HomeLoan).getAmount_of_Loan()));
              jTextField9.setText(Float.toString(getDT_HomeLoanList().get(DT_HomeLoan).getInterest_Rate()));
               jTextField10.setText(Float.toString(getDT_HomeLoanList().get(DT_HomeLoan).getCurrency()));
                jTextField11.setText(Float.toString(getDT_HomeLoanList().get(DT_HomeLoan).getTotal_Principal()));
                   jTextField7.setText(getDT_HomeLoanList().get(DT_HomeLoan).getDate());
                    jTextField12.setText(getDT_HomeLoanList().get(DT_HomeLoan).getTime());
    }
       //for DT_PERSONAL
    public ArrayList<DT_PersonalLoan> getDT_PersonalLoanList() {
        ArrayList<DT_PersonalLoan> DT_PersonalLoanList = new ArrayList<DT_PersonalLoan>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM DT_PersonalLoan";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
      DT_PersonalLoan DT_PersonalLoan;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
              DT_PersonalLoan = new DT_PersonalLoan(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"),rs.getString("Payment_Regulation"),rs.getInt("No_of_Months"),
                rs.getString("Term"),rs.getFloat("Amount_of_Loan"), rs.getFloat("Interest_Rate"),rs.getFloat("Currency"),rs.getFloat("Total_Principal"),rs.getString("Date"),rs.getString("Time"));
              DT_PersonalLoanList.add(DT_PersonalLoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger( DT_PersonalLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DT_PersonalLoanList;
    }

    public void ShowDataInDT_PersonalLoanTable() {
        ArrayList<DT_PersonalLoan> list = getDT_PersonalLoanList();
        DefaultTableModel model = (DefaultTableModel) Personal_Loan.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getPayment_Regulation();
                    row[4] = list.get(i).getNo_of_Months();
                      row[5] = list.get(i).getTerm();
                          row[6] = list.get(i).getAmount_of_Loan();
                            row[7] = list.get(i).getInterest_Rate();
                              row[8] = list.get(i).getCurrency();
                                row[9] = list.get(i).getTotal_Principal();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInDT_PersonalLoan(int DT_PersonalLoan) {

        jComboBox3.setSelectedItem(getDT_PersonalLoanList().get(DT_PersonalLoan).getType_of_Loan());
       jTextField2.setText(Integer.toString(getDT_PersonalLoanList().get(DT_PersonalLoan).getClient_No()));
        jTextField3.setText(getDT_PersonalLoanList().get(DT_PersonalLoan).getClients_Name());
         Payment_Regulation.setSelectedItem(getDT_PersonalLoanList().get(DT_PersonalLoan).getPayment_Regulation());
           jTextField20.setText(Integer.toString(getDT_PersonalLoanList().get(DT_PersonalLoan).getNo_of_Months()));
           Term.setSelectedItem(getDT_PersonalLoanList().get(DT_PersonalLoan).getTerm());
            jTextField8.setText(Float.toString(getDT_PersonalLoanList().get(DT_PersonalLoan).getAmount_of_Loan()));
              jTextField9.setText(Float.toString(getDT_PersonalLoanList().get(DT_PersonalLoan).getInterest_Rate()));
               jTextField10.setText(Float.toString(getDT_PersonalLoanList().get(DT_PersonalLoan).getCurrency()));
                jTextField11.setText(Float.toString(getDT_PersonalLoanList().get(DT_PersonalLoan).getTotal_Principal()));
                   jTextField7.setText(getDT_PersonalLoanList().get(DT_PersonalLoan).getDate());
                    jTextField12.setText(getDT_PersonalLoanList().get(DT_PersonalLoan).getTime());
    }
     //for DT_SalaryLoan
    public ArrayList<DT_SalaryLoan> getDT_SalaryLoanList() {
        ArrayList<DT_SalaryLoan> DT_SalaryLoanList = new ArrayList<DT_SalaryLoan>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM DT_SalaryLoan";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
      DT_SalaryLoan DT_SalaryLoan;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
              DT_SalaryLoan = new DT_SalaryLoan(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"),rs.getString("Payment_Regulation"),rs.getInt("No_of_Months"),
                rs.getString("Term"),rs.getFloat("Amount_of_Loan"), rs.getFloat("Interest_Rate"),rs.getFloat("Currency"),rs.getFloat("Total_Principal"),rs.getString("Date"),rs.getString("Time"));
              DT_SalaryLoanList.add(DT_SalaryLoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger( DT_SalaryLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  DT_SalaryLoanList;
    }

    public void ShowDataInDT_SalaryLoanTable() {
        ArrayList<DT_SalaryLoan> list = getDT_SalaryLoanList();
        DefaultTableModel model = (DefaultTableModel) Salary_Loan.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getPayment_Regulation();
                    row[4] = list.get(i).getNo_of_Months();
                      row[5] = list.get(i).getTerm();
                          row[6] = list.get(i).getAmount_of_Loan();
                            row[7] = list.get(i).getInterest_Rate();
                              row[8] = list.get(i).getCurrency();
                                row[9] = list.get(i).getTotal_Principal();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInDT_SalaryLoan(int DT_SalaryLoan) {

        jComboBox3.setSelectedItem(getDT_SalaryLoanList().get(DT_SalaryLoan).getType_of_Loan());
       jTextField2.setText(Integer.toString(getDT_SalaryLoanList().get(DT_SalaryLoan).getClient_No()));
        jTextField3.setText(getDT_SalaryLoanList().get(DT_SalaryLoan).getClients_Name());
         Payment_Regulation.setSelectedItem(getDT_SalaryLoanList().get(DT_SalaryLoan).getPayment_Regulation());
           jTextField20.setText(Integer.toString(getDT_SalaryLoanList().get(DT_SalaryLoan).getNo_of_Months()));
           Term.setSelectedItem(getDT_SalaryLoanList().get(DT_SalaryLoan).getTerm());
            jTextField8.setText(Float.toString(getDT_SalaryLoanList().get(DT_SalaryLoan).getAmount_of_Loan()));
              jTextField9.setText(Float.toString(getDT_SalaryLoanList().get(DT_SalaryLoan).getInterest_Rate()));
               jTextField10.setText(Float.toString(getDT_SalaryLoanList().get(DT_SalaryLoan).getCurrency()));
                jTextField11.setText(Float.toString(getDT_SalaryLoanList().get(DT_SalaryLoan).getTotal_Principal()));
                   jTextField7.setText(getDT_SalaryLoanList().get(DT_SalaryLoan).getDate());
                    jTextField12.setText(getDT_SalaryLoanList().get(DT_SalaryLoan).getTime());
    }
    
     //for DT_OFW
    public ArrayList<DT_OFWLoan> getDT_OFWLoanList() {
        ArrayList<DT_OFWLoan> DT_OFWLoanList = new ArrayList<DT_OFWLoan>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM DT_OFWLoan";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
      DT_OFWLoan DT_OFWLoan;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
              DT_OFWLoan = new DT_OFWLoan(rs.getString("Type_Of_Loan"), rs.getInt("Client_No"), rs.getString("Clients_Name"),rs.getString("Payment_Regulation"),rs.getInt("No_of_Months"),
                rs.getString("Term"),rs.getFloat("Amount_of_Loan"), rs.getFloat("Interest_Rate"),rs.getFloat("Currency"),rs.getFloat("Total_Principal"),rs.getString("Date"),rs.getString("Time"));
              DT_OFWLoanList.add(DT_OFWLoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger( DT_OFWLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  DT_OFWLoanList;
    }

    public void ShowDataInDT_OFWLoanTable() {
        ArrayList<DT_OFWLoan> list = getDT_OFWLoanList();
        DefaultTableModel model = (DefaultTableModel) OFW_Loan.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getType_of_Loan();
              row[1] = list.get(i).getClient_No();
                row[2] = list.get(i).getClients_Name();
                  row[3] = list.get(i).getPayment_Regulation();
                    row[4] = list.get(i).getNo_of_Months();
                      row[5] = list.get(i).getTerm();
                          row[6] = list.get(i).getAmount_of_Loan();
                            row[7] = list.get(i).getInterest_Rate();
                              row[8] = list.get(i).getCurrency();
                                row[9] = list.get(i).getTotal_Principal();
                                row[10] = list.get(i).getDate();
                                  row[11] = list.get(i).getTime();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInDT_OFWLoan(int DT_OFWLoan) {

        jComboBox3.setSelectedItem(getDT_OFWLoanList().get(DT_OFWLoan).getType_of_Loan());
       jTextField2.setText(Integer.toString(getDT_OFWLoanList().get(DT_OFWLoan).getClient_No()));
        jTextField3.setText(getDT_OFWLoanList().get(DT_OFWLoan).getClients_Name());
         Payment_Regulation.setSelectedItem(getDT_OFWLoanList().get(DT_OFWLoan).getPayment_Regulation());
           jTextField20.setText(Integer.toString(getDT_OFWLoanList().get(DT_OFWLoan).getNo_of_Months()));
           Term.setSelectedItem(getDT_OFWLoanList().get(DT_OFWLoan).getTerm());
            jTextField8.setText(Float.toString(getDT_OFWLoanList().get(DT_OFWLoan).getAmount_of_Loan()));
              jTextField9.setText(Float.toString(getDT_OFWLoanList().get(DT_OFWLoan).getInterest_Rate()));
               jTextField10.setText(Float.toString(getDT_OFWLoanList().get(DT_OFWLoan).getCurrency()));
                jTextField11.setText(Float.toString(getDT_OFWLoanList().get(DT_OFWLoan).getTotal_Principal()));
                   jTextField7.setText(getDT_OFWLoanList().get(DT_OFWLoan).getDate());
                    jTextField12.setText(getDT_OFWLoanList().get(DT_OFWLoan).getTime());
    }
    
    //for Client_Status
    public ArrayList<Client_Status> getClient_StatusList() {
        ArrayList<Client_Status> Client_StatusList = new ArrayList<Client_Status>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM Client_Status";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
      Client_Status Client_Status;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
            Client_Status = new Client_Status(rs.getInt("Client_No"),rs.getString("Lastname"),rs.getString("Firstname"),rs.getString("Middlename"),rs.getInt("Mobile"),
            rs.getFloat("Balance"),rs.getString("Address"),rs.getString("Payment_Regulation"),rs.getString("Type_of_Loan"),rs.getString("Client_Performance"));
             Client_StatusList.add(Client_Status);
            }
        } catch (SQLException ex) {
            Logger.getLogger( Client_Status.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Client_StatusList;
    }

    public void ShowDataInClient_StatusTable() {
        ArrayList<Client_Status> list = getClient_StatusList();
        DefaultTableModel model = (DefaultTableModel) Client_Status.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getClient_No();
              row[1] = list.get(i).getLastname();
                row[2] = list.get(i).getFirstname();
                  row[3] = list.get(i).getMiddlename();
                    row[4] = list.get(i).getMobile();
                      row[5] = list.get(i).getBalance();
                          row[6] = list.get(i).getAddress();
                            row[7] = list.get(i).getPayment_Regulation();
                              row[8] = list.get(i).getType_of_Loan();
                                row[9] = list.get(i).getClient_Performance();

                                  
                              
            model.addRow(row);
        }
    }
      public void ShowDataInClient_Status(int Client_Status) {

        
       jTextField115.setText(Integer.toString(getClient_StatusList().get( Client_Status).getClient_No()));
        jTextField117.setText(getClient_StatusList().get( Client_Status).getLastname());
         jTextField120.setText(getClient_StatusList().get( Client_Status).getFirstname());
        jTextField116.setText(getClient_StatusList().get( Client_Status).getMiddlename());
         jTextField157.setText(Integer.toString(getClient_StatusList().get( Client_Status).getMobile()));
          jTextField194.setText(Float.toString(getClient_StatusList().get( Client_Status).getBalance()));
           jTextField195.setText(getClient_StatusList().get( Client_Status).getAddress());
            jTextField196.setText(getClient_StatusList().get( Client_Status).getPayment_Regulation());
             jTextField197.setText(getClient_StatusList().get( Client_Status).getType_of_Loan());
              jTextField198.setText(getClient_StatusList().get( Client_Status).getClient_Performance());
    }
    
     //for Client_Monitoring
    public ArrayList<Client_Monitoring> getClient_MonitoringList() {
        ArrayList<Client_Monitoring>Client_MonitoringList = new ArrayList<Client_Monitoring>();
        Connection con = getConnectionDB();
        String getConnection = "SELECT * FROM Client_Monitoring";
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(getConnection);
      Client_Monitoring Client_Monitoring;
            while (rs.next()) {
                //calling the constructor from ClientInformation.java
           Client_Monitoring = new Client_Monitoring(rs.getInt("Client_No"),rs.getString("Lastname"),rs.getString("Firstname"),rs.getString("Middlename"),
            rs.getFloat("Balance"),rs.getString("Last_Payment"),rs.getFloat("Amount_of_Loan"),rs.getString("Type_of_Loan"),rs.getFloat("Amount_of_Payment")
            ,rs.getFloat("Total_Principal"),rs.getFloat("Currency"),rs.getFloat("Interest_Rate"),rs.getString("Payment_Date"));
             Client_MonitoringList.add(Client_Monitoring);
            }
        } catch (SQLException ex) {
            Logger.getLogger( DT_PersonalLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Client_MonitoringList;
    }

    public void ShowDataInClient_MonitoringTable() {
        ArrayList<Client_Monitoring> list = getClient_MonitoringList();
        DefaultTableModel model = (DefaultTableModel) Client_Monitoring.getModel();
        //clear jTableContent
        model.setRowCount(0);

        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getClient_No();
                row[1] = list.get(i).getLastname();
                   row[2] = list.get(i).getFirstname();
                      row[3] = list.get(i).getMiddlename();
                         row[4] = list.get(i).getBalance();
                            row[5] = list.get(i).getLast_Payment();
                               row[5] = list.get(i).getAmount_of_Loan();
                                  row[6] = list.get(i).getType_of_Loan();
                                     row[7] = list.get(i).getAmount_of_Payment();
                                        row[8] = list.get(i).getTotal_Principal();
                                           row[9] = list.get(i).getCurrency();
                                              row[10] = list.get(i).getInterest_Rate();
                                                 row[11] = list.get(i).getPayment_Date();
                                  
                              
            model.addRow(row);
        }
    }

    //for showing data in textField when table was clicked
    public void ShowDataInClient_Monitoring(int Client_Monitoring) {

     
       jTextField124.setText(Integer.toString(getClient_MonitoringList().get(Client_Monitoring).getClient_No()));
        jTextField123.setText(getClient_MonitoringList().get(Client_Monitoring).getLastname());
         jTextField122.setText(getClient_MonitoringList().get(Client_Monitoring).getFirstname());
          jTextField127.setText(getClient_MonitoringList().get(Client_Monitoring).getMiddlename());
          jTextField125.setText(Float.toString(getClient_MonitoringList().get(Client_Monitoring).getBalance()));
          jTextField126.setText(getClient_MonitoringList().get(Client_Monitoring).getLast_Payment());
           jTextField128.setText(Float.toString(getClient_MonitoringList().get(Client_Monitoring).getAmount_of_Loan()));
            jTextField129.setText(getClient_MonitoringList().get(Client_Monitoring).getType_of_Loan());
             jTextField199.setText(Float.toString(getClient_MonitoringList().get(Client_Monitoring).getAmount_of_Payment()));
              jTextField200.setText(Float.toString(getClient_MonitoringList().get(Client_Monitoring).getTotal_Principal()));
               jTextField201.setText(Float.toString(getClient_MonitoringList().get(Client_Monitoring).getCurrency()));
                jTextField202.setText(Float.toString(getClient_MonitoringList().get(Client_Monitoring).getInterest_Rate()));
                 jTextField203.setText(getClient_MonitoringList().get(Client_Monitoring).getPayment_Date());
              
    }
     public PageFormat getPageFormat(PrinterJob pj)
{
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double middleHeight =8.0;  
    double headerHeight = 2.0;                  
    double footerHeight = 2.0;                  
    double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
    double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(                    
        0,
        10,
        width,            
        height - convert_CM_To_PPI(1)
    );   //define boarder size    after that print area width is about 180 points
            
    pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
    pf.setPaper(paper);    

    return pf;
}
    
    protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}
 
protected static double toPPI(double inch) {            
	        return inch * 72d;            
}






public class BillPrintable implements Printable {
    
   
    
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      
                
        
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

            double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            ////////// code by alqama//////////////

            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
        //    int idLength=metrics.stringWidth("000000");
            //int idLength=metrics.stringWidth("00");
            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

        //    int idPosition=0;
        //    int productPosition=idPosition + idLength + 2;
        //    int pricePosition=productPosition + prodLength +10;
        //    int qtyPosition=pricePosition + priceLength + 2;
        //    int amtPosition=qtyPosition + qtyLength + 2;
            
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
            
              
        try{
            /*Draw Header*/
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
            int headerRectHeighta=40;
            
            ///////////////// Product names Get ///////////
               
              String  CNo=jTextField6.getText();
                String CName=jTextField13.getText();
            String  pn1a=jLabel56.getText();
                String pn2a=jLabel54.getText();
                String pn3a=jLabel55.getText();
                String pn4a=jLabel59.getText();
                  String pn6a=jLabel60.getText();
                  String pn7a=jLabel62.getText();
                  
                  
                  
             
            ///////////////// Product names Get ///////////
                
            
            ///////////////// Product price Get ///////////
                float pp1a=Integer.valueOf(pp1.getText());
                float pp2a=Integer.valueOf(pp2.getText());
                float pp3a=Integer.valueOf(pp3.getText());
                float pp4a=Integer.valueOf(pp4.getText());
               float pp6a=Integer.valueOf(pp6.getText());
               String pp7a=jDateChooser1.getDate().toString();
                float sum=pp1a+pp2a+pp3a+pp4a+pp6a;
            ///////////////// Product price Get ///////////
                
             g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("-------------------------------------",12,y);y+=yShift;
            g2d.drawString("             Debt Statement       ",12,y);y+=yShift;
            g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;
            g2d.drawString("   "+CNo+"                           ",12,y);y+=yShift;
            g2d.drawString("   "+CName+"                        ",12,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Type of Loan         Total Principal",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
            g2d.drawString(" "+pn1a+"             "+pp1a+"       ",10,y);y+=yShift;
            g2d.drawString(" "+pn2a+"             "+pp2a+"       ",10,y);y+=yShift;
            g2d.drawString(" "+pn3a+"             "+pp3a+"       ",10,y);y+=yShift;
            g2d.drawString(" "+pn4a+"             "+pp4a+"       ",10,y);y+=yShift;
              g2d.drawString(" "+pn6a+"           "+pp6a+"       ",10,y);y+=yShift;
              
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total amount: "+sum+"               ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Date Issued:      "+pp7a+"          ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
        
//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
          
    }
    catch(Exception r){
    r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        SidePane = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        consolidation = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        client_Transaction = new javax.swing.JPanel();
        CT_SalaryLoan = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jTextField104 = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jTextField181 = new javax.swing.JTextField();
        jTextField182 = new javax.swing.JTextField();
        jTextField183 = new javax.swing.JTextField();
        jTextField184 = new javax.swing.JTextField();
        jTextField185 = new javax.swing.JTextField();
        jTextField186 = new javax.swing.JTextField();
        jTextField187 = new javax.swing.JTextField();
        jTextField188 = new javax.swing.JTextField();
        jTextField189 = new javax.swing.JTextField();
        jTextField190 = new javax.swing.JTextField();
        jTextField191 = new javax.swing.JTextField();
        jTextField192 = new javax.swing.JTextField();
        jTextField193 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        CT_PersonalLoan = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jTextField103 = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jTextField168 = new javax.swing.JTextField();
        jTextField169 = new javax.swing.JTextField();
        jTextField170 = new javax.swing.JTextField();
        jTextField171 = new javax.swing.JTextField();
        jTextField172 = new javax.swing.JTextField();
        jTextField173 = new javax.swing.JTextField();
        jTextField174 = new javax.swing.JTextField();
        jTextField175 = new javax.swing.JTextField();
        jTextField176 = new javax.swing.JTextField();
        jTextField177 = new javax.swing.JTextField();
        jTextField178 = new javax.swing.JTextField();
        jTextField179 = new javax.swing.JTextField();
        jTextField180 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        CT_OFWLoan = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jTextField102 = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jTextField144 = new javax.swing.JTextField();
        jTextField145 = new javax.swing.JTextField();
        jTextField146 = new javax.swing.JTextField();
        jTextField147 = new javax.swing.JTextField();
        jTextField148 = new javax.swing.JTextField();
        jTextField149 = new javax.swing.JTextField();
        jTextField161 = new javax.swing.JTextField();
        jTextField162 = new javax.swing.JTextField();
        jTextField163 = new javax.swing.JTextField();
        jTextField164 = new javax.swing.JTextField();
        jTextField165 = new javax.swing.JTextField();
        jTextField166 = new javax.swing.JTextField();
        jTextField167 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        CT_HomeLoan = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jTextField101 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jTextField131 = new javax.swing.JTextField();
        jTextField132 = new javax.swing.JTextField();
        jTextField133 = new javax.swing.JTextField();
        jTextField134 = new javax.swing.JTextField();
        jTextField135 = new javax.swing.JTextField();
        jTextField136 = new javax.swing.JTextField();
        jTextField137 = new javax.swing.JTextField();
        jTextField138 = new javax.swing.JTextField();
        jTextField139 = new javax.swing.JTextField();
        jTextField140 = new javax.swing.JTextField();
        jTextField141 = new javax.swing.JTextField();
        jTextField142 = new javax.swing.JTextField();
        jTextField143 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        CT_BusinessLoan = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jTextField100 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jTextField106 = new javax.swing.JTextField();
        jTextField107 = new javax.swing.JTextField();
        jTextField108 = new javax.swing.JTextField();
        jTextField109 = new javax.swing.JTextField();
        jTextField110 = new javax.swing.JTextField();
        jTextField111 = new javax.swing.JTextField();
        jTextField112 = new javax.swing.JTextField();
        jTextField113 = new javax.swing.JTextField();
        jTextField114 = new javax.swing.JTextField();
        jTextField118 = new javax.swing.JTextField();
        jTextField119 = new javax.swing.JTextField();
        jTextField121 = new javax.swing.JTextField();
        jTextField130 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Client_Report = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        pp4 = new javax.swing.JTextField();
        pp1 = new javax.swing.JTextField();
        pp2 = new javax.swing.JTextField();
        pp3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        pp6 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        socialmonitoring = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        cstatus = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Client_Status = new javax.swing.JTable();
        jTextField115 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jTextField116 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jTextField117 = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jTextField120 = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        jTextField157 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel166 = new javax.swing.JLabel();
        jTextField194 = new javax.swing.JTextField();
        jTextField195 = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jTextField196 = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        jTextField197 = new javax.swing.JTextField();
        jTextField198 = new javax.swing.JTextField();
        jLabel170 = new javax.swing.JLabel();
        cmonitoring = new javax.swing.JPanel();
        jTextField122 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jTextField123 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jTextField124 = new javax.swing.JTextField();
        jTextField125 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jTextField126 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        Client_Monitoring = new javax.swing.JTable();
        jTextField127 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jTextField128 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jTextField129 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jTextField199 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jTextField200 = new javax.swing.JTextField();
        jLabel171 = new javax.swing.JLabel();
        jTextField201 = new javax.swing.JTextField();
        jLabel172 = new javax.swing.JLabel();
        jTextField202 = new javax.swing.JTextField();
        jLabel173 = new javax.swing.JLabel();
        jTextField203 = new javax.swing.JTextField();
        saving = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Withdrawal_Transaction = new javax.swing.JPanel();
        panelloan2 = new javax.swing.JPanel();
        Business2 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        Business_Loan2 = new javax.swing.JTable();
        Homeloan2 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        Home_Loan2 = new javax.swing.JTable();
        salary2 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        Salary_Loan2 = new javax.swing.JTable();
        OFWloan2 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        OFW_Loan2 = new javax.swing.JTable();
        personalloan2 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        Personal_Loan2 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        Use = new javax.swing.JComboBox<>();
        Marks = new javax.swing.JComboBox<>();
        Deposit_Transaction = new javax.swing.JPanel();
        panelloan = new javax.swing.JPanel();
        Business = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Homeloan = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Home_Loan = new javax.swing.JTable();
        salary = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Salary_Loan = new javax.swing.JTable();
        OFWloan = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        OFW_Loan = new javax.swing.JTable();
        personalloan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Personal_Loan = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        Term = new javax.swing.JComboBox<>();
        Payment_Regulation = new javax.swing.JComboBox<>();
        cmpanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        clientsinfo = new javax.swing.JPanel();
        jTextField21 = new javax.swing.JTextField();
        CID2 = new javax.swing.JLabel();
        Lastname2 = new javax.swing.JLabel();
        jTextField77 = new javax.swing.JTextField();
        Firstname2 = new javax.swing.JLabel();
        jTextField78 = new javax.swing.JTextField();
        Middlename2 = new javax.swing.JLabel();
        jTextField79 = new javax.swing.JTextField();
        Gender2 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        Occupation8 = new javax.swing.JLabel();
        jTextField80 = new javax.swing.JTextField();
        Status4 = new javax.swing.JLabel();
        jTextField82 = new javax.swing.JTextField();
        Email1 = new javax.swing.JLabel();
        Mobile3 = new javax.swing.JLabel();
        jTextField83 = new javax.swing.JTextField();
        jTextField84 = new javax.swing.JTextField();
        Address3 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        ClientInformationTable = new javax.swing.JTable();
        Update_Button2 = new javax.swing.JButton();
        Save_Button2 = new javax.swing.JButton();
        Edit_Button2 = new javax.swing.JButton();
        del_Button1 = new javax.swing.JButton();
        lbl_DisplayImage = new javax.swing.JLabel();
        Attach_Photo1 = new javax.swing.JButton();
        Status5 = new javax.swing.JLabel();
        jTextField85 = new javax.swing.JTextField();
        Status7 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        New1 = new javax.swing.JButton();
        Occupation16 = new javax.swing.JLabel();
        jTextField150 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        Mobile6 = new javax.swing.JLabel();
        jTextField151 = new javax.swing.JTextField();
        Occupation17 = new javax.swing.JLabel();
        jTextField81 = new javax.swing.JTextField();
        Email2 = new javax.swing.JLabel();
        jTextField152 = new javax.swing.JTextField();
        Email4 = new javax.swing.JLabel();
        jTextField153 = new javax.swing.JTextField();
        Email5 = new javax.swing.JLabel();
        jTextField154 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Email7 = new javax.swing.JLabel();
        Email8 = new javax.swing.JLabel();
        jTextField155 = new javax.swing.JTextField();
        jTextField156 = new javax.swing.JTextField();
        Email9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Email10 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField158 = new javax.swing.JTextField();
        Email11 = new javax.swing.JLabel();
        Email12 = new javax.swing.JLabel();
        jTextField159 = new javax.swing.JTextField();
        jTextField160 = new javax.swing.JTextField();
        Email13 = new javax.swing.JLabel();
        notif = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField86 = new javax.swing.JTextField();
        jTextField87 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        Mobile4 = new javax.swing.JLabel();
        Message1 = new javax.swing.JLabel();
        jTextField88 = new javax.swing.JTextField();
        CIDFK1 = new javax.swing.JLabel();
        Email3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Email6 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        NotificationTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        MenuBar = new javax.swing.JPanel();
        winClose_btn = new javax.swing.JLabel();
        Maintenance_btn = new javax.swing.JLabel();
        winRes_Max_btn = new javax.swing.JLabel();
        winMinimize_btn = new javax.swing.JLabel();
        Settings_btn = new javax.swing.JLabel();
        winMinimize_btn1 = new javax.swing.JLabel();
        winClose_btn1 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SidePane.setBackground(new java.awt.Color(51, 51, 51));
        SidePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SidePane.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 39, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/user.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        SidePane.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 120));

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/tele4.png"))); // NOI18N
        jLabel6.setText("Communication Management");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel6MouseReleased(evt);
            }
        });
        SidePane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 220, 40));

        jLabel10.setBackground(new java.awt.Color(51, 173, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/ss.png"))); // NOI18N
        jLabel10.setText("Social Performance Monitoring");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        SidePane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 220, 40));

        jLabel12.setBackground(new java.awt.Color(79, 163, 252));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/conso.png"))); // NOI18N
        jLabel12.setText("Consolidation");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        SidePane.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 220, 40));

        jLabel22.setBackground(new java.awt.Color(79, 163, 252));
        jLabel22.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/logout.png"))); // NOI18N
        jLabel22.setText("Logout");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });
        SidePane.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 220, 31));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ADMINISTRATOR");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        SidePane.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 142, 210, 31));

        Date.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        Date.setForeground(new java.awt.Color(255, 255, 255));
        Date.setText("     Date");
        SidePane.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 140, 40));

        Time.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setText("     Time");
        SidePane.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 140, 40));

        jLabel11.setBackground(new java.awt.Color(79, 163, 252));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/save2.png"))); // NOI18N
        jLabel11.setText("Savings Tracking");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        SidePane.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 250, 290, 40));

        getContentPane().add(SidePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 710));

        consolidation.setBackground(new java.awt.Color(255, 255, 255));
        consolidation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane4.setBackground(new java.awt.Color(255, 255, 255));

        client_Transaction.setBackground(new java.awt.Color(255, 255, 255));
        client_Transaction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CT_SalaryLoan.setBackground(new java.awt.Color(204, 204, 204));
        CT_SalaryLoan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salary Loan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        CT_SalaryLoan.setForeground(new java.awt.Color(51, 51, 51));
        CT_SalaryLoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel153.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(51, 51, 51));
        jLabel153.setText("Client No");
        CT_SalaryLoan.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel154.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(51, 51, 51));
        jLabel154.setText("Client Name");
        CT_SalaryLoan.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel155.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(51, 51, 51));
        jLabel155.setText("Total Amount Paid");
        CT_SalaryLoan.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel156.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(51, 51, 51));
        jLabel156.setText("Loan Amount");
        CT_SalaryLoan.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel157.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(51, 51, 51));
        jLabel157.setText("Interest Rate");
        CT_SalaryLoan.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel158.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(51, 51, 51));
        jLabel158.setText("Currency");
        CT_SalaryLoan.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jTextField104.setEnabled(false);
        CT_SalaryLoan.add(jTextField104, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 140, -1));

        jLabel159.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(51, 51, 51));
        jLabel159.setText("Total Principal");
        CT_SalaryLoan.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel160.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(51, 51, 51));
        jLabel160.setText("Date of Client Pay");
        CT_SalaryLoan.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel161.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(51, 51, 51));
        jLabel161.setText("Amount of Payment");
        CT_SalaryLoan.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel162.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(51, 51, 51));
        jLabel162.setText("Date of Payment");
        CT_SalaryLoan.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel163.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(51, 51, 51));
        jLabel163.setText("Remaining Balance");
        CT_SalaryLoan.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel164.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(51, 51, 51));
        jLabel164.setText("Total of Principal");
        CT_SalaryLoan.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel165.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(51, 51, 51));
        jLabel165.setText("No. of Months");
        CT_SalaryLoan.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));
        CT_SalaryLoan.add(jTextField181, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, -1));

        jTextField182.setEnabled(false);
        CT_SalaryLoan.add(jTextField182, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, -1));

        jTextField183.setEnabled(false);
        CT_SalaryLoan.add(jTextField183, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, -1));

        jTextField184.setEnabled(false);
        CT_SalaryLoan.add(jTextField184, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, -1));

        jTextField185.setEnabled(false);
        CT_SalaryLoan.add(jTextField185, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, -1));

        jTextField186.setEnabled(false);
        CT_SalaryLoan.add(jTextField186, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, -1));

        jTextField187.setEnabled(false);
        CT_SalaryLoan.add(jTextField187, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, -1));

        jTextField188.setEnabled(false);
        CT_SalaryLoan.add(jTextField188, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, -1));

        jTextField189.setEnabled(false);
        CT_SalaryLoan.add(jTextField189, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 140, -1));

        jTextField190.setEnabled(false);
        CT_SalaryLoan.add(jTextField190, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 140, -1));

        jTextField191.setEnabled(false);
        CT_SalaryLoan.add(jTextField191, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 140, -1));

        jTextField192.setEnabled(false);
        CT_SalaryLoan.add(jTextField192, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 140, -1));

        jTextField193.setEnabled(false);
        CT_SalaryLoan.add(jTextField193, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 140, -1));

        jLabel31.setBackground(new java.awt.Color(51, 173, 255));
        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("   RESET");
        jLabel31.setOpaque(true);
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel31MouseExited(evt);
            }
        });
        CT_SalaryLoan.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 70, 30));

        jLabel32.setBackground(new java.awt.Color(51, 173, 255));
        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("   SEARCH");
        jLabel32.setOpaque(true);
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel32MouseExited(evt);
            }
        });
        CT_SalaryLoan.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 30));

        client_Transaction.add(CT_SalaryLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 290, 510));

        CT_PersonalLoan.setBackground(new java.awt.Color(204, 204, 204));
        CT_PersonalLoan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Loan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        CT_PersonalLoan.setForeground(new java.awt.Color(51, 51, 51));
        CT_PersonalLoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel140.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(51, 51, 51));
        jLabel140.setText("Client No");
        CT_PersonalLoan.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel141.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(51, 51, 51));
        jLabel141.setText("Client Name");
        CT_PersonalLoan.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel142.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(51, 51, 51));
        jLabel142.setText("Total Amount Paid");
        CT_PersonalLoan.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel143.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(51, 51, 51));
        jLabel143.setText("Loan Amount");
        CT_PersonalLoan.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel144.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(51, 51, 51));
        jLabel144.setText("Interest Rate");
        CT_PersonalLoan.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel145.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(51, 51, 51));
        jLabel145.setText("Currency");
        CT_PersonalLoan.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jTextField103.setEnabled(false);
        CT_PersonalLoan.add(jTextField103, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 140, -1));

        jLabel146.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(51, 51, 51));
        jLabel146.setText("Total Principal");
        CT_PersonalLoan.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel147.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(51, 51, 51));
        jLabel147.setText("Date of Client Pay");
        CT_PersonalLoan.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel148.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(51, 51, 51));
        jLabel148.setText("Amount of Payment");
        CT_PersonalLoan.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel149.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(51, 51, 51));
        jLabel149.setText("Date of Payment");
        CT_PersonalLoan.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel150.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(51, 51, 51));
        jLabel150.setText("Remaining Balance");
        CT_PersonalLoan.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel151.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(51, 51, 51));
        jLabel151.setText("Total of Principal");
        CT_PersonalLoan.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel152.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(51, 51, 51));
        jLabel152.setText("No. of Months");
        CT_PersonalLoan.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));
        CT_PersonalLoan.add(jTextField168, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 130, -1));

        jTextField169.setEnabled(false);
        CT_PersonalLoan.add(jTextField169, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, -1));

        jTextField170.setEnabled(false);
        CT_PersonalLoan.add(jTextField170, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, -1));

        jTextField171.setEnabled(false);
        CT_PersonalLoan.add(jTextField171, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, -1));

        jTextField172.setEnabled(false);
        CT_PersonalLoan.add(jTextField172, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, -1));

        jTextField173.setEnabled(false);
        CT_PersonalLoan.add(jTextField173, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, -1));

        jTextField174.setEnabled(false);
        CT_PersonalLoan.add(jTextField174, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, -1));

        jTextField175.setEnabled(false);
        CT_PersonalLoan.add(jTextField175, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, -1));

        jTextField176.setEnabled(false);
        CT_PersonalLoan.add(jTextField176, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 140, -1));

        jTextField177.setEnabled(false);
        CT_PersonalLoan.add(jTextField177, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 140, -1));

        jTextField178.setEnabled(false);
        CT_PersonalLoan.add(jTextField178, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 140, -1));

        jTextField179.setEnabled(false);
        CT_PersonalLoan.add(jTextField179, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 140, -1));

        jTextField180.setEnabled(false);
        CT_PersonalLoan.add(jTextField180, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 140, -1));

        jLabel29.setBackground(new java.awt.Color(51, 173, 255));
        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("   RESET");
        jLabel29.setOpaque(true);
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });
        CT_PersonalLoan.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 70, 30));

        jLabel30.setBackground(new java.awt.Color(51, 173, 255));
        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("   SEARCH");
        jLabel30.setOpaque(true);
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
        });
        CT_PersonalLoan.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 30));

        client_Transaction.add(CT_PersonalLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 290, 510));

        CT_OFWLoan.setBackground(new java.awt.Color(204, 204, 204));
        CT_OFWLoan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OFW Loan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        CT_OFWLoan.setForeground(new java.awt.Color(51, 51, 51));
        CT_OFWLoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(51, 51, 51));
        jLabel126.setText("Client No");
        CT_OFWLoan.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel127.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(51, 51, 51));
        jLabel127.setText("Client Name");
        CT_OFWLoan.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel128.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(51, 51, 51));
        jLabel128.setText("Total Amount Paid");
        CT_OFWLoan.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel129.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(51, 51, 51));
        jLabel129.setText("Loan Amount");
        CT_OFWLoan.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel130.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(51, 51, 51));
        jLabel130.setText("Interest Rate");
        CT_OFWLoan.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel131.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(51, 51, 51));
        jLabel131.setText("Currency");
        CT_OFWLoan.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jTextField102.setEnabled(false);
        CT_OFWLoan.add(jTextField102, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 140, -1));

        jLabel133.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(51, 51, 51));
        jLabel133.setText("Total Principal");
        CT_OFWLoan.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel134.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(51, 51, 51));
        jLabel134.setText("Date of Client Pay");
        CT_OFWLoan.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel135.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(51, 51, 51));
        jLabel135.setText("Amount of Payment");
        CT_OFWLoan.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel136.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(51, 51, 51));
        jLabel136.setText("Date of Payment");
        CT_OFWLoan.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel137.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(51, 51, 51));
        jLabel137.setText("Remaining Balance");
        CT_OFWLoan.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel138.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(51, 51, 51));
        jLabel138.setText("Total of Principal");
        CT_OFWLoan.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel139.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(51, 51, 51));
        jLabel139.setText("No. of Months");
        CT_OFWLoan.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));
        CT_OFWLoan.add(jTextField144, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 130, -1));

        jTextField145.setEnabled(false);
        CT_OFWLoan.add(jTextField145, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, -1));

        jTextField146.setEnabled(false);
        CT_OFWLoan.add(jTextField146, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, -1));

        jTextField147.setEnabled(false);
        CT_OFWLoan.add(jTextField147, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, -1));

        jTextField148.setEnabled(false);
        CT_OFWLoan.add(jTextField148, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, -1));

        jTextField149.setEnabled(false);
        CT_OFWLoan.add(jTextField149, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, -1));

        jTextField161.setEnabled(false);
        CT_OFWLoan.add(jTextField161, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, -1));

        jTextField162.setEnabled(false);
        CT_OFWLoan.add(jTextField162, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, -1));

        jTextField163.setEnabled(false);
        CT_OFWLoan.add(jTextField163, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 140, -1));

        jTextField164.setEnabled(false);
        CT_OFWLoan.add(jTextField164, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 140, -1));

        jTextField165.setEnabled(false);
        CT_OFWLoan.add(jTextField165, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 140, -1));

        jTextField166.setEnabled(false);
        CT_OFWLoan.add(jTextField166, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 140, -1));

        jTextField167.setEnabled(false);
        CT_OFWLoan.add(jTextField167, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 140, -1));

        jLabel27.setBackground(new java.awt.Color(51, 173, 255));
        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("   RESET");
        jLabel27.setOpaque(true);
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        CT_OFWLoan.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 70, 30));

        jLabel28.setBackground(new java.awt.Color(51, 173, 255));
        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("   SEARCH");
        jLabel28.setOpaque(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });
        CT_OFWLoan.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 30));

        client_Transaction.add(CT_OFWLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 290, 510));

        CT_HomeLoan.setBackground(new java.awt.Color(204, 204, 204));
        CT_HomeLoan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Home Loan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        CT_HomeLoan.setForeground(new java.awt.Color(51, 51, 51));
        CT_HomeLoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel120.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(51, 51, 51));
        jLabel120.setText("Client No");
        CT_HomeLoan.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel121.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(51, 51, 51));
        jLabel121.setText("Client Name");
        CT_HomeLoan.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel122.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(51, 51, 51));
        jLabel122.setText("Total Amount Paid");
        CT_HomeLoan.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel123.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(51, 51, 51));
        jLabel123.setText("Loan Amount");
        CT_HomeLoan.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel124.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(51, 51, 51));
        jLabel124.setText("Interest Rate");
        CT_HomeLoan.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel125.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(51, 51, 51));
        jLabel125.setText("Currency");
        CT_HomeLoan.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jTextField101.setEnabled(false);
        CT_HomeLoan.add(jTextField101, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 140, -1));

        jLabel88.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(51, 51, 51));
        jLabel88.setText("Total Principal");
        CT_HomeLoan.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel89.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(51, 51, 51));
        jLabel89.setText("Date of Client Pay");
        CT_HomeLoan.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel90.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(51, 51, 51));
        jLabel90.setText("Amount of Payment");
        CT_HomeLoan.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel91.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(51, 51, 51));
        jLabel91.setText("Date of Payment");
        CT_HomeLoan.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel92.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(51, 51, 51));
        jLabel92.setText("Remaining Balance");
        CT_HomeLoan.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel93.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(51, 51, 51));
        jLabel93.setText("Total of Principal");
        CT_HomeLoan.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel94.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(51, 51, 51));
        jLabel94.setText("No. of Months");
        CT_HomeLoan.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));
        CT_HomeLoan.add(jTextField131, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 140, -1));

        jTextField132.setEnabled(false);
        CT_HomeLoan.add(jTextField132, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 140, -1));

        jTextField133.setEnabled(false);
        CT_HomeLoan.add(jTextField133, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 140, -1));

        jTextField134.setEnabled(false);
        CT_HomeLoan.add(jTextField134, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, -1));

        jTextField135.setEnabled(false);
        CT_HomeLoan.add(jTextField135, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 140, -1));

        jTextField136.setEnabled(false);
        CT_HomeLoan.add(jTextField136, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 140, -1));

        jTextField137.setEnabled(false);
        CT_HomeLoan.add(jTextField137, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 140, -1));

        jTextField138.setEnabled(false);
        CT_HomeLoan.add(jTextField138, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 140, -1));

        jTextField139.setEnabled(false);
        CT_HomeLoan.add(jTextField139, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 140, -1));

        jTextField140.setEnabled(false);
        CT_HomeLoan.add(jTextField140, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 140, -1));

        jTextField141.setEnabled(false);
        CT_HomeLoan.add(jTextField141, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 140, -1));

        jTextField142.setEnabled(false);
        CT_HomeLoan.add(jTextField142, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 140, -1));

        jTextField143.setEnabled(false);
        CT_HomeLoan.add(jTextField143, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 140, -1));

        jLabel21.setBackground(new java.awt.Color(51, 173, 255));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("   SEARCH");
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });
        CT_HomeLoan.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 30));

        jLabel25.setBackground(new java.awt.Color(51, 173, 255));
        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("   RESET");
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
        });
        CT_HomeLoan.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 70, 30));

        client_Transaction.add(CT_HomeLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 290, 510));

        CT_BusinessLoan.setBackground(new java.awt.Color(204, 204, 204));
        CT_BusinessLoan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Business Loan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        CT_BusinessLoan.setForeground(new java.awt.Color(51, 51, 51));
        CT_BusinessLoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel114.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(51, 51, 51));
        jLabel114.setText("Client No");
        CT_BusinessLoan.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel115.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(51, 51, 51));
        jLabel115.setText("Client Name");
        CT_BusinessLoan.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel116.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(51, 51, 51));
        jLabel116.setText("Total Amount Paid");
        CT_BusinessLoan.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel117.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(51, 51, 51));
        jLabel117.setText("Loan Amount");
        CT_BusinessLoan.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel118.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(51, 51, 51));
        jLabel118.setText("Interest Rate");
        CT_BusinessLoan.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel119.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(51, 51, 51));
        jLabel119.setText("Currency");
        CT_BusinessLoan.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jTextField100.setEnabled(false);
        CT_BusinessLoan.add(jTextField100, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 140, -1));

        jLabel81.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(51, 51, 51));
        jLabel81.setText("Total Principal");
        CT_BusinessLoan.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel82.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(51, 51, 51));
        jLabel82.setText("Date of Client Pay");
        CT_BusinessLoan.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel83.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(51, 51, 51));
        jLabel83.setText("Amount of Payment");
        CT_BusinessLoan.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel84.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(51, 51, 51));
        jLabel84.setText("Date of Payment");
        CT_BusinessLoan.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel85.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(51, 51, 51));
        jLabel85.setText("Remaining Balance");
        CT_BusinessLoan.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel86.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(51, 51, 51));
        jLabel86.setText("Total of Principal");
        CT_BusinessLoan.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel87.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(51, 51, 51));
        jLabel87.setText("No. of Months");
        CT_BusinessLoan.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));
        CT_BusinessLoan.add(jTextField106, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 140, -1));

        jTextField107.setEnabled(false);
        CT_BusinessLoan.add(jTextField107, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, -1));

        jTextField108.setEnabled(false);
        CT_BusinessLoan.add(jTextField108, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, -1));

        jTextField109.setEnabled(false);
        CT_BusinessLoan.add(jTextField109, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, -1));

        jTextField110.setEnabled(false);
        CT_BusinessLoan.add(jTextField110, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, -1));

        jTextField111.setEnabled(false);
        CT_BusinessLoan.add(jTextField111, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, -1));

        jTextField112.setEnabled(false);
        CT_BusinessLoan.add(jTextField112, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, -1));

        jTextField113.setEnabled(false);
        CT_BusinessLoan.add(jTextField113, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, -1));

        jTextField114.setEnabled(false);
        CT_BusinessLoan.add(jTextField114, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 140, -1));

        jTextField118.setEnabled(false);
        CT_BusinessLoan.add(jTextField118, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 140, -1));

        jTextField119.setEnabled(false);
        CT_BusinessLoan.add(jTextField119, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 140, -1));

        jTextField121.setEnabled(false);
        CT_BusinessLoan.add(jTextField121, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 140, -1));

        jTextField130.setEnabled(false);
        CT_BusinessLoan.add(jTextField130, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 140, -1));

        jLabel20.setBackground(new java.awt.Color(51, 173, 255));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("   SEARCH");
        jLabel20.setOpaque(true);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });
        CT_BusinessLoan.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 30));

        jLabel23.setBackground(new java.awt.Color(51, 173, 255));
        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("   RESET");
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });
        CT_BusinessLoan.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 70, 30));

        client_Transaction.add(CT_BusinessLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 510));

        jScrollPane6.setViewportView(client_Transaction);

        jTabbedPane4.addTab("Client Transaction", jScrollPane6);

        Client_Report.setBackground(new java.awt.Color(255, 255, 255));
        Client_Report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 51));
        jLabel53.setText("Client Number:");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 26));

        jLabel54.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setText("Home Loan(if any)");
        jPanel1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 140, 26));

        jLabel55.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setText("OFW Loan(if any)");
        jPanel1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 130, 26));

        jLabel56.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(51, 51, 51));
        jLabel56.setText("Business Loan(if any)");
        jPanel1.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 140, 26));

        jLabel57.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setText("Type of Loan");
        jPanel1.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 99, 26));

        pp4.setEnabled(false);
        pp4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pp4KeyTyped(evt);
            }
        });
        jPanel1.add(pp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 150, 30));

        pp1.setEnabled(false);
        pp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pp1KeyTyped(evt);
            }
        });
        jPanel1.add(pp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 150, 30));

        pp2.setEnabled(false);
        pp2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pp2KeyTyped(evt);
            }
        });
        jPanel1.add(pp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 150, 30));

        pp3.setEnabled(false);
        pp3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pp3KeyTyped(evt);
            }
        });
        jPanel1.add(pp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 150, 30));

        jButton3.setBackground(new java.awt.Color(51, 173, 255));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Print Statement");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setEnabled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 140, 50));

        jTextField6.setEnabled(false);
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 250, -1));

        jLabel58.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 51, 51));
        jLabel58.setText("Clients Name:");
        jPanel1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 90, 26));

        jTextField13.setEnabled(false);
        jPanel1.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 250, -1));

        jLabel59.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setText("Personal Loan(if any)");
        jPanel1.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 140, 26));

        jLabel60.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("Salary Loan(if any)");
        jPanel1.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 140, 26));

        pp6.setEnabled(false);
        pp6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pp6KeyTyped(evt);
            }
        });
        jPanel1.add(pp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 150, 30));

        jLabel61.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("Total Principal");
        jPanel1.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 99, 26));

        jButton4.setBackground(new java.awt.Color(51, 173, 255));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("EDIT");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 140, 50));

        jLabel62.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Date Issued:");
        jPanel1.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 90, 26));

        jDateChooser1.setEnabled(false);
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 150, -1));

        Client_Report.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 550));

        jTabbedPane4.addTab("Clients Report", Client_Report);

        consolidation.add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 580));

        getContentPane().add(consolidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 720, 570));

        socialmonitoring.setBackground(new java.awt.Color(255, 255, 255));
        socialmonitoring.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));

        cstatus.setBackground(new java.awt.Color(255, 255, 255));
        cstatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Client_Status.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client_No", "Lastname", "Firstname", "Middlename", "Mobile", "Balance", "Address", "Payment Regulation", "Type of Loan", "Client Performance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Client_Status.getTableHeader().setReorderingAllowed(false);
        Client_Status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Client_StatusMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Client_Status);
        if (Client_Status.getColumnModel().getColumnCount() > 0) {
            Client_Status.getColumnModel().getColumn(0).setResizable(false);
            Client_Status.getColumnModel().getColumn(0).setPreferredWidth(150);
            Client_Status.getColumnModel().getColumn(1).setResizable(false);
            Client_Status.getColumnModel().getColumn(1).setPreferredWidth(200);
            Client_Status.getColumnModel().getColumn(2).setResizable(false);
            Client_Status.getColumnModel().getColumn(2).setPreferredWidth(200);
            Client_Status.getColumnModel().getColumn(3).setResizable(false);
            Client_Status.getColumnModel().getColumn(3).setPreferredWidth(100);
            Client_Status.getColumnModel().getColumn(4).setResizable(false);
            Client_Status.getColumnModel().getColumn(4).setPreferredWidth(150);
            Client_Status.getColumnModel().getColumn(5).setResizable(false);
            Client_Status.getColumnModel().getColumn(5).setPreferredWidth(100);
            Client_Status.getColumnModel().getColumn(6).setResizable(false);
            Client_Status.getColumnModel().getColumn(6).setPreferredWidth(200);
            Client_Status.getColumnModel().getColumn(7).setResizable(false);
            Client_Status.getColumnModel().getColumn(7).setPreferredWidth(150);
            Client_Status.getColumnModel().getColumn(8).setResizable(false);
            Client_Status.getColumnModel().getColumn(8).setPreferredWidth(150);
            Client_Status.getColumnModel().getColumn(9).setResizable(false);
            Client_Status.getColumnModel().getColumn(9).setPreferredWidth(150);
        }

        cstatus.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 670, 140));

        jTextField115.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField115.setEnabled(false);
        cstatus.add(jTextField115, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        jLabel96.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(51, 51, 51));
        jLabel96.setText("Client No");
        cstatus.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 20));

        jLabel97.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(51, 51, 51));
        jLabel97.setText("Middlename");
        cstatus.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 80, -1));

        jTextField116.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField116.setEnabled(false);
        cstatus.add(jTextField116, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 130, -1));

        jLabel98.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(51, 51, 51));
        jLabel98.setText("Firstname");
        cstatus.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 70, -1));

        jTextField117.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField117.setEnabled(false);
        cstatus.add(jTextField117, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, -1));

        jLabel101.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(51, 51, 51));
        jLabel101.setText("Lastname");
        cstatus.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 70, -1));

        jTextField120.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField120.setEnabled(false);
        cstatus.add(jTextField120, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 130, -1));

        jLabel132.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(51, 51, 51));
        jLabel132.setText("Mobile");
        cstatus.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 100, -1));

        jTextField157.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField157.setEnabled(false);
        cstatus.add(jTextField157, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 140, -1));

        jButton1.setText("History");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        cstatus.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 80, -1));

        jLabel166.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(51, 51, 51));
        jLabel166.setText("Balance");
        cstatus.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, -1));

        jTextField194.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField194.setEnabled(false);
        cstatus.add(jTextField194, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, -1));

        jTextField195.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField195.setEnabled(false);
        cstatus.add(jTextField195, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 260, -1));

        jLabel167.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(51, 51, 51));
        jLabel167.setText("Address");
        cstatus.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 100, -1));

        jLabel168.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(51, 51, 51));
        jLabel168.setText("Payment Regulation");
        cstatus.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 140, -1));

        jTextField196.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField196.setEnabled(false);
        cstatus.add(jTextField196, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 250, -1));

        jLabel169.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(51, 51, 51));
        jLabel169.setText("Type of Loan");
        cstatus.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, -1));

        jTextField197.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField197.setEnabled(false);
        cstatus.add(jTextField197, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 250, -1));

        jTextField198.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField198.setEnabled(false);
        cstatus.add(jTextField198, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 250, -1));

        jLabel170.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(51, 51, 51));
        jLabel170.setText("Client Performance");
        cstatus.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 140, -1));

        jTabbedPane3.addTab("Clients Status", cstatus);

        cmonitoring.setBackground(new java.awt.Color(255, 255, 255));
        cmonitoring.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField122.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField122.setEnabled(false);
        cmonitoring.add(jTextField122, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 200, -1));

        jLabel103.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(51, 51, 51));
        jLabel103.setText("Lastname");
        cmonitoring.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 70, -1));

        jLabel104.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(51, 51, 51));
        jLabel104.setText("Firstname");
        cmonitoring.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jTextField123.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField123.setEnabled(false);
        cmonitoring.add(jTextField123, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 190, -1));

        jLabel105.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(51, 51, 51));
        jLabel105.setText("Client No");
        cmonitoring.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, -1));

        jTextField124.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField124.setEnabled(false);
        cmonitoring.add(jTextField124, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, -1));

        jTextField125.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField125.setEnabled(false);
        jTextField125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField125ActionPerformed(evt);
            }
        });
        cmonitoring.add(jTextField125, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 120, -1));

        jLabel106.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(51, 51, 51));
        jLabel106.setText("Balance");
        cmonitoring.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 60, -1));

        jTextField126.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField126.setEnabled(false);
        cmonitoring.add(jTextField126, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 130, -1));

        jLabel107.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(51, 51, 51));
        jLabel107.setText("Last Payment ");
        cmonitoring.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 100, -1));

        Client_Monitoring.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client_No", "Lastname", "Firstname", "Middlename", "Balance", "Last_Payment", "Amount_Of_Loan", "Type_of_Loan", "Amount_of_Payment", "Total_Principal", "Currency", "Interest_Rate", "Payment_Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Client_Monitoring.getTableHeader().setReorderingAllowed(false);
        Client_Monitoring.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Client_MonitoringMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(Client_Monitoring);
        if (Client_Monitoring.getColumnModel().getColumnCount() > 0) {
            Client_Monitoring.getColumnModel().getColumn(0).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(0).setPreferredWidth(100);
            Client_Monitoring.getColumnModel().getColumn(1).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(1).setPreferredWidth(200);
            Client_Monitoring.getColumnModel().getColumn(2).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(2).setPreferredWidth(200);
            Client_Monitoring.getColumnModel().getColumn(3).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(3).setPreferredWidth(100);
            Client_Monitoring.getColumnModel().getColumn(4).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(4).setPreferredWidth(100);
            Client_Monitoring.getColumnModel().getColumn(5).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(5).setPreferredWidth(150);
            Client_Monitoring.getColumnModel().getColumn(6).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(6).setPreferredWidth(150);
            Client_Monitoring.getColumnModel().getColumn(7).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(7).setPreferredWidth(150);
            Client_Monitoring.getColumnModel().getColumn(8).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(8).setPreferredWidth(150);
            Client_Monitoring.getColumnModel().getColumn(9).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(9).setPreferredWidth(150);
            Client_Monitoring.getColumnModel().getColumn(10).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(10).setPreferredWidth(150);
            Client_Monitoring.getColumnModel().getColumn(11).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(11).setPreferredWidth(150);
            Client_Monitoring.getColumnModel().getColumn(12).setResizable(false);
            Client_Monitoring.getColumnModel().getColumn(12).setPreferredWidth(150);
        }

        cmonitoring.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 690, 190));

        jTextField127.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField127.setEnabled(false);
        cmonitoring.add(jTextField127, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, -1));

        jLabel108.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(51, 51, 51));
        jLabel108.setText("Middlename");
        cmonitoring.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, -1));

        jTextField128.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField128.setEnabled(false);
        cmonitoring.add(jTextField128, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 200, -1));

        jLabel109.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(51, 51, 51));
        jLabel109.setText("Amount of Loan");
        cmonitoring.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 120, -1));

        jLabel110.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(51, 51, 51));
        jLabel110.setText("Type of Loan");
        cmonitoring.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 120, -1));

        jTextField129.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField129.setEnabled(false);
        cmonitoring.add(jTextField129, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 170, -1));

        jLabel112.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(51, 51, 51));
        jLabel112.setText("Amount of Payment");
        cmonitoring.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 140, -1));

        jTextField199.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField199.setEnabled(false);
        cmonitoring.add(jTextField199, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 160, -1));

        jLabel113.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(51, 51, 51));
        jLabel113.setText("Total Principal");
        cmonitoring.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 110, 20));

        jTextField200.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField200.setEnabled(false);
        cmonitoring.add(jTextField200, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, -1));

        jLabel171.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(51, 51, 51));
        jLabel171.setText("Currency");
        cmonitoring.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 70, -1));

        jTextField201.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField201.setEnabled(false);
        cmonitoring.add(jTextField201, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 160, -1));

        jLabel172.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(51, 51, 51));
        jLabel172.setText("Interest Rate");
        cmonitoring.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, -1));

        jTextField202.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField202.setEnabled(false);
        cmonitoring.add(jTextField202, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 160, -1));

        jLabel173.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(51, 51, 51));
        jLabel173.setText("Payment Date");
        cmonitoring.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 110, -1));

        jTextField203.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField203.setEnabled(false);
        cmonitoring.add(jTextField203, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 160, -1));

        jTabbedPane3.addTab("Clients Monitoring", cmonitoring);

        socialmonitoring.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 580));

        getContentPane().add(socialmonitoring, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 720, 580));

        saving.setBackground(new java.awt.Color(255, 255, 255));
        saving.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        Withdrawal_Transaction.setBackground(new java.awt.Color(255, 255, 255));
        Withdrawal_Transaction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelloan2.setLayout(new java.awt.CardLayout());

        Business2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Business_Loan2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type_Of_Loan", "Client_No", "Clients_Name", "No_Of_Payments", "Clients_Payment", "Amounts_Of_Payment", "Payment_Regulation", "Remaining_Balance", "Marks", "W_Use", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Business_Loan2.getTableHeader().setReorderingAllowed(false);
        Business_Loan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Business_Loan2MouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(Business_Loan2);
        if (Business_Loan2.getColumnModel().getColumnCount() > 0) {
            Business_Loan2.getColumnModel().getColumn(0).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(0).setPreferredWidth(150);
            Business_Loan2.getColumnModel().getColumn(1).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(1).setPreferredWidth(100);
            Business_Loan2.getColumnModel().getColumn(2).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(2).setPreferredWidth(200);
            Business_Loan2.getColumnModel().getColumn(3).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(3).setPreferredWidth(150);
            Business_Loan2.getColumnModel().getColumn(4).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(4).setPreferredWidth(50);
            Business_Loan2.getColumnModel().getColumn(5).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(5).setPreferredWidth(150);
            Business_Loan2.getColumnModel().getColumn(6).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(6).setPreferredWidth(150);
            Business_Loan2.getColumnModel().getColumn(7).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(7).setPreferredWidth(150);
            Business_Loan2.getColumnModel().getColumn(8).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(8).setPreferredWidth(100);
            Business_Loan2.getColumnModel().getColumn(9).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(9).setPreferredWidth(100);
            Business_Loan2.getColumnModel().getColumn(10).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(10).setPreferredWidth(100);
            Business_Loan2.getColumnModel().getColumn(11).setResizable(false);
            Business_Loan2.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        Business2.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan2.add(Business2, "card6");

        Homeloan2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Home_Loan2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type_Of_Loan", "Client_No", "Clients_Name", "No_Of_Payments", "Clients_Payment", "Amounts_Of_Payment", "Payment_Regulation", "Remaining_Balance", "Marks", "W_Use", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Home_Loan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home_Loan2MouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(Home_Loan2);
        if (Home_Loan2.getColumnModel().getColumnCount() > 0) {
            Home_Loan2.getColumnModel().getColumn(0).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(0).setPreferredWidth(150);
            Home_Loan2.getColumnModel().getColumn(1).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(1).setPreferredWidth(100);
            Home_Loan2.getColumnModel().getColumn(2).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(2).setPreferredWidth(200);
            Home_Loan2.getColumnModel().getColumn(3).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(3).setPreferredWidth(150);
            Home_Loan2.getColumnModel().getColumn(4).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(4).setPreferredWidth(150);
            Home_Loan2.getColumnModel().getColumn(5).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(5).setPreferredWidth(150);
            Home_Loan2.getColumnModel().getColumn(6).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(6).setPreferredWidth(150);
            Home_Loan2.getColumnModel().getColumn(7).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(7).setPreferredWidth(150);
            Home_Loan2.getColumnModel().getColumn(8).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(8).setPreferredWidth(100);
            Home_Loan2.getColumnModel().getColumn(9).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(9).setPreferredWidth(100);
            Home_Loan2.getColumnModel().getColumn(10).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(10).setPreferredWidth(100);
            Home_Loan2.getColumnModel().getColumn(11).setResizable(false);
            Home_Loan2.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        Homeloan2.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan2.add(Homeloan2, "card5");

        salary2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Salary_Loan2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type_Of_Loan", "Client_No", "Clients_Name", "No_Of_Payments", "Clients_Payment", "Amounts_Of_Payment", "Payment_Regulation", "Remaining_Balance", "Marks", "W_Use", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Salary_Loan2.getTableHeader().setReorderingAllowed(false);
        Salary_Loan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Salary_Loan2MouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(Salary_Loan2);
        if (Salary_Loan2.getColumnModel().getColumnCount() > 0) {
            Salary_Loan2.getColumnModel().getColumn(0).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(0).setPreferredWidth(150);
            Salary_Loan2.getColumnModel().getColumn(1).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(1).setPreferredWidth(100);
            Salary_Loan2.getColumnModel().getColumn(2).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(2).setPreferredWidth(200);
            Salary_Loan2.getColumnModel().getColumn(3).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(3).setPreferredWidth(150);
            Salary_Loan2.getColumnModel().getColumn(4).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(4).setPreferredWidth(150);
            Salary_Loan2.getColumnModel().getColumn(5).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(5).setPreferredWidth(150);
            Salary_Loan2.getColumnModel().getColumn(6).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(6).setPreferredWidth(150);
            Salary_Loan2.getColumnModel().getColumn(7).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(7).setPreferredWidth(150);
            Salary_Loan2.getColumnModel().getColumn(8).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(8).setPreferredWidth(100);
            Salary_Loan2.getColumnModel().getColumn(9).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(9).setPreferredWidth(100);
            Salary_Loan2.getColumnModel().getColumn(10).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(10).setPreferredWidth(100);
            Salary_Loan2.getColumnModel().getColumn(11).setResizable(false);
            Salary_Loan2.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        salary2.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan2.add(salary2, "card4");

        OFWloan2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OFW_Loan2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type_Of_Loan", "Client_No", "Clients_Name", "No_Of_Payments", "Clients_Payment", "Amounts_Of_Payment", "Payment_Regulation", "Remaining_Balance", "Marks", "W_Use", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OFW_Loan2.getTableHeader().setReorderingAllowed(false);
        OFW_Loan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OFW_Loan2MouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(OFW_Loan2);
        if (OFW_Loan2.getColumnModel().getColumnCount() > 0) {
            OFW_Loan2.getColumnModel().getColumn(0).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(0).setPreferredWidth(150);
            OFW_Loan2.getColumnModel().getColumn(1).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(1).setPreferredWidth(100);
            OFW_Loan2.getColumnModel().getColumn(2).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(2).setPreferredWidth(200);
            OFW_Loan2.getColumnModel().getColumn(3).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(3).setPreferredWidth(150);
            OFW_Loan2.getColumnModel().getColumn(4).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(4).setPreferredWidth(150);
            OFW_Loan2.getColumnModel().getColumn(5).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(5).setPreferredWidth(150);
            OFW_Loan2.getColumnModel().getColumn(6).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(6).setPreferredWidth(150);
            OFW_Loan2.getColumnModel().getColumn(7).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(7).setPreferredWidth(150);
            OFW_Loan2.getColumnModel().getColumn(8).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(8).setPreferredWidth(100);
            OFW_Loan2.getColumnModel().getColumn(9).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(9).setPreferredWidth(100);
            OFW_Loan2.getColumnModel().getColumn(10).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(10).setPreferredWidth(100);
            OFW_Loan2.getColumnModel().getColumn(11).setResizable(false);
            OFW_Loan2.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        OFWloan2.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan2.add(OFWloan2, "card3");

        personalloan2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Personal_Loan2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type of Loan", "Client_No", "Clents_Name", "No_Of_Payment", "Clients_Paymemt", "Amounts_Of_Payment", "Payment_Regulation", "Remaining_Balance", "Marks", "W_Use", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Personal_Loan2.getTableHeader().setReorderingAllowed(false);
        Personal_Loan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Personal_Loan2MouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(Personal_Loan2);
        if (Personal_Loan2.getColumnModel().getColumnCount() > 0) {
            Personal_Loan2.getColumnModel().getColumn(0).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(0).setPreferredWidth(150);
            Personal_Loan2.getColumnModel().getColumn(1).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(1).setPreferredWidth(100);
            Personal_Loan2.getColumnModel().getColumn(2).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(2).setPreferredWidth(200);
            Personal_Loan2.getColumnModel().getColumn(3).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(3).setPreferredWidth(150);
            Personal_Loan2.getColumnModel().getColumn(4).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(4).setPreferredWidth(150);
            Personal_Loan2.getColumnModel().getColumn(5).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(5).setPreferredWidth(150);
            Personal_Loan2.getColumnModel().getColumn(6).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(6).setPreferredWidth(150);
            Personal_Loan2.getColumnModel().getColumn(7).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(7).setPreferredWidth(150);
            Personal_Loan2.getColumnModel().getColumn(8).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(8).setPreferredWidth(100);
            Personal_Loan2.getColumnModel().getColumn(9).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(9).setPreferredWidth(100);
            Personal_Loan2.getColumnModel().getColumn(10).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(10).setPreferredWidth(100);
            Personal_Loan2.getColumnModel().getColumn(11).setResizable(false);
            Personal_Loan2.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        personalloan2.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan2.add(personalloan2, "card2");

        Withdrawal_Transaction.add(panelloan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 370, 350));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Client No.");
        Withdrawal_Transaction.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 20));

        jTextField4.setEnabled(false);
        Withdrawal_Transaction.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 160, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Clients Name");
        Withdrawal_Transaction.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 20));

        jTextField5.setEnabled(false);
        Withdrawal_Transaction.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 160, -1));

        jLabel36.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Type of Loan");
        Withdrawal_Transaction.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 20));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Loan ", "Personal Loan", "Home Loan", "Business Loan", "Salary Loan", "OFW Loan" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });
        Withdrawal_Transaction.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 160, -1));

        jLabel37.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("No. of Payments");
        Withdrawal_Transaction.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 20));

        jTextField22.setEnabled(false);
        Withdrawal_Transaction.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 160, -1));

        jLabel38.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Date");
        Withdrawal_Transaction.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 20));

        jTextField23.setEnabled(false);
        Withdrawal_Transaction.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 100, -1));

        jLabel39.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Payment Regulation");
        Withdrawal_Transaction.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 130, 20));

        jTextField24.setEnabled(false);
        Withdrawal_Transaction.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 160, -1));

        jLabel40.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Use");
        Withdrawal_Transaction.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 40, 20));

        jTextField25.setEnabled(false);
        Withdrawal_Transaction.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 160, -1));

        jLabel41.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Amounts of Payment");
        Withdrawal_Transaction.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 20));

        jLabel42.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Time");
        Withdrawal_Transaction.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 40, 20));

        jTextField26.setEnabled(false);
        Withdrawal_Transaction.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 100, -1));

        jTextField27.setEnabled(false);
        Withdrawal_Transaction.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 160, -1));

        jLabel43.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Clients Payment");
        Withdrawal_Transaction.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 110, 20));

        jTextField28.setEnabled(false);
        Withdrawal_Transaction.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 160, -1));

        jLabel44.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Remaining Balance");
        Withdrawal_Transaction.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 130, 20));

        jLabel45.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Marks");
        Withdrawal_Transaction.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 40, 20));

        Use.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Cash" }));
        Use.setEnabled(false);
        Withdrawal_Transaction.add(Use, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 270, 100, -1));

        Marks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Advanced", "Exact Date", "Late" }));
        Marks.setEnabled(false);
        Withdrawal_Transaction.add(Marks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 100, -1));

        jTabbedPane2.addTab("Withdrawal Transaction", Withdrawal_Transaction);

        Deposit_Transaction.setBackground(new java.awt.Color(255, 255, 255));
        Deposit_Transaction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelloan.setLayout(new java.awt.CardLayout());

        Business.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type_of_Loan", "Client_No", "Clients_Name", "Payment_Regulation", "No_of_Months", "Term", "Amount_of_Loan", "Interest_Rate", "Currency", "Total_Principal", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(10).setResizable(false);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(11).setResizable(false);
            jTable1.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        Business.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan.add(Business, "card6");

        Homeloan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Home_Loan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type_of_Loan", "Client_No", "Clients_Name", "Payment_Regulation", "No_of_Months", "Term", "Amount_of_Loan", "Interest_Rate", "Currency", "Total_Principal", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Home_Loan.getTableHeader().setReorderingAllowed(false);
        Home_Loan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home_LoanMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(Home_Loan);
        if (Home_Loan.getColumnModel().getColumnCount() > 0) {
            Home_Loan.getColumnModel().getColumn(0).setResizable(false);
            Home_Loan.getColumnModel().getColumn(0).setPreferredWidth(150);
            Home_Loan.getColumnModel().getColumn(1).setResizable(false);
            Home_Loan.getColumnModel().getColumn(1).setPreferredWidth(100);
            Home_Loan.getColumnModel().getColumn(2).setResizable(false);
            Home_Loan.getColumnModel().getColumn(2).setPreferredWidth(200);
            Home_Loan.getColumnModel().getColumn(3).setResizable(false);
            Home_Loan.getColumnModel().getColumn(3).setPreferredWidth(150);
            Home_Loan.getColumnModel().getColumn(4).setResizable(false);
            Home_Loan.getColumnModel().getColumn(4).setPreferredWidth(100);
            Home_Loan.getColumnModel().getColumn(5).setResizable(false);
            Home_Loan.getColumnModel().getColumn(5).setPreferredWidth(100);
            Home_Loan.getColumnModel().getColumn(6).setResizable(false);
            Home_Loan.getColumnModel().getColumn(6).setPreferredWidth(100);
            Home_Loan.getColumnModel().getColumn(7).setResizable(false);
            Home_Loan.getColumnModel().getColumn(7).setPreferredWidth(100);
            Home_Loan.getColumnModel().getColumn(8).setResizable(false);
            Home_Loan.getColumnModel().getColumn(8).setPreferredWidth(100);
            Home_Loan.getColumnModel().getColumn(9).setResizable(false);
            Home_Loan.getColumnModel().getColumn(9).setPreferredWidth(100);
            Home_Loan.getColumnModel().getColumn(10).setResizable(false);
            Home_Loan.getColumnModel().getColumn(10).setPreferredWidth(100);
            Home_Loan.getColumnModel().getColumn(11).setResizable(false);
            Home_Loan.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        Homeloan.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan.add(Homeloan, "card5");

        salary.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Salary_Loan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type_of_Loan", "Client_No", "Clients_Name", "Payment_Regulation", "No_of_Months", "Term", "Amount_of_Loan", "Interest_Rate", "Currency", "Total_Principal", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Salary_Loan.getTableHeader().setReorderingAllowed(false);
        Salary_Loan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Salary_LoanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Salary_Loan);
        if (Salary_Loan.getColumnModel().getColumnCount() > 0) {
            Salary_Loan.getColumnModel().getColumn(0).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(0).setPreferredWidth(150);
            Salary_Loan.getColumnModel().getColumn(1).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(1).setPreferredWidth(100);
            Salary_Loan.getColumnModel().getColumn(2).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(2).setPreferredWidth(200);
            Salary_Loan.getColumnModel().getColumn(3).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(3).setPreferredWidth(150);
            Salary_Loan.getColumnModel().getColumn(4).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(4).setPreferredWidth(100);
            Salary_Loan.getColumnModel().getColumn(5).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(5).setPreferredWidth(100);
            Salary_Loan.getColumnModel().getColumn(6).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(6).setPreferredWidth(100);
            Salary_Loan.getColumnModel().getColumn(7).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(7).setPreferredWidth(100);
            Salary_Loan.getColumnModel().getColumn(8).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(8).setPreferredWidth(100);
            Salary_Loan.getColumnModel().getColumn(9).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(9).setPreferredWidth(100);
            Salary_Loan.getColumnModel().getColumn(10).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(10).setPreferredWidth(100);
            Salary_Loan.getColumnModel().getColumn(11).setResizable(false);
            Salary_Loan.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        salary.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan.add(salary, "card4");

        OFWloan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OFW_Loan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type_of_Loan", "Client_No", "Clients_Name", "Payment_Regulation", "No_of_Months", "Term", "Amount_of_Loan", "Interest_Rate", "Currency", "Total_Principal", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OFW_Loan.getTableHeader().setReorderingAllowed(false);
        OFW_Loan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OFW_LoanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(OFW_Loan);
        if (OFW_Loan.getColumnModel().getColumnCount() > 0) {
            OFW_Loan.getColumnModel().getColumn(0).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(0).setPreferredWidth(150);
            OFW_Loan.getColumnModel().getColumn(1).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(1).setPreferredWidth(100);
            OFW_Loan.getColumnModel().getColumn(2).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(2).setPreferredWidth(200);
            OFW_Loan.getColumnModel().getColumn(3).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(3).setPreferredWidth(150);
            OFW_Loan.getColumnModel().getColumn(4).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(4).setPreferredWidth(100);
            OFW_Loan.getColumnModel().getColumn(5).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(5).setPreferredWidth(100);
            OFW_Loan.getColumnModel().getColumn(6).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(6).setPreferredWidth(100);
            OFW_Loan.getColumnModel().getColumn(7).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(7).setPreferredWidth(100);
            OFW_Loan.getColumnModel().getColumn(8).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(8).setPreferredWidth(100);
            OFW_Loan.getColumnModel().getColumn(9).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(9).setPreferredWidth(100);
            OFW_Loan.getColumnModel().getColumn(10).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(10).setPreferredWidth(100);
            OFW_Loan.getColumnModel().getColumn(11).setResizable(false);
            OFW_Loan.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        OFWloan.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan.add(OFWloan, "card3");

        personalloan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Personal_Loan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type_of_Loan", "Client_No", "Clients_Name", "Payment_Regulation", "No_of_Months", "Term", "Amount_of_Loan", "Interest_Rate", "Currency", "Total_Principal", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Personal_Loan.getTableHeader().setReorderingAllowed(false);
        Personal_Loan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Personal_LoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Personal_Loan);
        if (Personal_Loan.getColumnModel().getColumnCount() > 0) {
            Personal_Loan.getColumnModel().getColumn(0).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(0).setPreferredWidth(150);
            Personal_Loan.getColumnModel().getColumn(1).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(1).setPreferredWidth(100);
            Personal_Loan.getColumnModel().getColumn(2).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(2).setPreferredWidth(200);
            Personal_Loan.getColumnModel().getColumn(3).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(3).setPreferredWidth(150);
            Personal_Loan.getColumnModel().getColumn(4).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(4).setPreferredWidth(100);
            Personal_Loan.getColumnModel().getColumn(5).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(5).setPreferredWidth(100);
            Personal_Loan.getColumnModel().getColumn(6).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(6).setPreferredWidth(100);
            Personal_Loan.getColumnModel().getColumn(7).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(7).setPreferredWidth(100);
            Personal_Loan.getColumnModel().getColumn(8).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(8).setPreferredWidth(100);
            Personal_Loan.getColumnModel().getColumn(9).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(9).setPreferredWidth(100);
            Personal_Loan.getColumnModel().getColumn(10).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(10).setPreferredWidth(100);
            Personal_Loan.getColumnModel().getColumn(11).setResizable(false);
            Personal_Loan.getColumnModel().getColumn(11).setPreferredWidth(100);
        }

        personalloan.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        panelloan.add(personalloan, "card2");

        Deposit_Transaction.add(panelloan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 370, 350));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Client No.");
        Deposit_Transaction.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 20));

        jTextField2.setEnabled(false);
        Deposit_Transaction.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 160, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Clients Name");
        Deposit_Transaction.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 20));

        jTextField3.setEnabled(false);
        Deposit_Transaction.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 160, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Type of Loan");
        Deposit_Transaction.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 20));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Loan", "Personal Loan", "Home Loan", "Business Loan", "Salary Loan", "OFW Loan" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        Deposit_Transaction.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 160, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Payment Regulation");
        Deposit_Transaction.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, 20));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Date");
        Deposit_Transaction.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 50, 20));

        jTextField7.setEnabled(false);
        Deposit_Transaction.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 100, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Amount of Loan");
        Deposit_Transaction.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 130, 20));

        jTextField8.setEnabled(false);
        Deposit_Transaction.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 160, -1));

        jTextField9.setEnabled(false);
        Deposit_Transaction.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 160, -1));

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Term");
        Deposit_Transaction.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, 20));

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Time");
        Deposit_Transaction.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 40, 20));

        jTextField12.setEnabled(false);
        Deposit_Transaction.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 100, -1));

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("No. of Months");
        Deposit_Transaction.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 20));

        jTextField20.setEnabled(false);
        Deposit_Transaction.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 160, -1));

        jLabel34.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Interest Rate");
        Deposit_Transaction.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 90, 20));

        jLabel46.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Currency");
        Deposit_Transaction.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 90, 20));

        jTextField10.setEnabled(false);
        Deposit_Transaction.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 160, -1));

        jLabel47.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Total Principal");
        Deposit_Transaction.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 90, 20));

        jTextField11.setEnabled(false);
        Deposit_Transaction.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 160, -1));

        Term.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Short", "Long", " " }));
        Term.setEnabled(false);
        Deposit_Transaction.add(Term, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 160, -1));

        Payment_Regulation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Weekly", "Monthly" }));
        Payment_Regulation.setEnabled(false);
        Deposit_Transaction.add(Payment_Regulation, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 160, -1));

        jTabbedPane2.addTab("Deposit Transaction", Deposit_Transaction);

        saving.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 580));

        getContentPane().add(saving, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 720, 580));

        cmpanel.setBackground(new java.awt.Color(255, 255, 255));
        cmpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        clientsinfo.setBackground(new java.awt.Color(255, 255, 255));
        clientsinfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField21.setEnabled(false);
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField21KeyTyped(evt);
            }
        });
        clientsinfo.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, -1));

        CID2.setBackground(new java.awt.Color(0, 0, 0));
        CID2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CID2.setForeground(new java.awt.Color(51, 51, 51));
        CID2.setText("Client No");
        clientsinfo.add(CID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 20));

        Lastname2.setBackground(new java.awt.Color(0, 0, 0));
        Lastname2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Lastname2.setForeground(new java.awt.Color(51, 51, 51));
        Lastname2.setText("Lastname");
        clientsinfo.add(Lastname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 70, 20));

        jTextField77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField77.setEnabled(false);
        clientsinfo.add(jTextField77, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 140, -1));

        Firstname2.setBackground(new java.awt.Color(0, 0, 0));
        Firstname2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Firstname2.setForeground(new java.awt.Color(51, 51, 51));
        Firstname2.setText("Firstname");
        clientsinfo.add(Firstname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 80, 20));

        jTextField78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField78.setEnabled(false);
        clientsinfo.add(jTextField78, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 150, -1));

        Middlename2.setBackground(new java.awt.Color(0, 0, 0));
        Middlename2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Middlename2.setForeground(new java.awt.Color(51, 51, 51));
        Middlename2.setText("Middlename");
        clientsinfo.add(Middlename2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 80, 20));

        jTextField79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField79.setEnabled(false);
        jTextField79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField79ActionPerformed(evt);
            }
        });
        clientsinfo.add(jTextField79, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 70, -1));

        Gender2.setBackground(new java.awt.Color(0, 0, 0));
        Gender2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Gender2.setForeground(new java.awt.Color(51, 51, 51));
        Gender2.setText("Gender");
        clientsinfo.add(Gender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 20));

        jComboBox4.setEditable(true);
        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jComboBox4.setEnabled(false);
        clientsinfo.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, -1));

        Occupation8.setBackground(new java.awt.Color(0, 0, 0));
        Occupation8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Occupation8.setForeground(new java.awt.Color(51, 51, 51));
        Occupation8.setText("Occupation");
        clientsinfo.add(Occupation8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 90, 20));

        jTextField80.setEnabled(false);
        clientsinfo.add(jTextField80, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 120, -1));

        Status4.setBackground(new java.awt.Color(0, 0, 0));
        Status4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Status4.setForeground(new java.awt.Color(51, 51, 51));
        Status4.setText("Civil Status");
        clientsinfo.add(Status4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 80, 20));

        jTextField82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField82.setEnabled(false);
        clientsinfo.add(jTextField82, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 180, -1));

        Email1.setBackground(new java.awt.Color(0, 0, 0));
        Email1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Email1.setForeground(new java.awt.Color(51, 51, 51));
        Email1.setText("Email");
        clientsinfo.add(Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 40, 20));

        Mobile3.setBackground(new java.awt.Color(0, 0, 0));
        Mobile3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Mobile3.setForeground(new java.awt.Color(51, 51, 51));
        Mobile3.setText("Mobile");
        clientsinfo.add(Mobile3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 60, 20));

        jTextField83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField83.setEnabled(false);
        jTextField83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField83MouseClicked(evt);
            }
        });
        jTextField83.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField83KeyTyped(evt);
            }
        });
        clientsinfo.add(jTextField83, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 130, -1));

        jTextField84.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField84.setEnabled(false);
        clientsinfo.add(jTextField84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 190, -1));

        Address3.setBackground(new java.awt.Color(0, 0, 0));
        Address3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Address3.setForeground(new java.awt.Color(51, 51, 51));
        Address3.setText("Current Address");
        clientsinfo.add(Address3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        ClientInformationTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ClientInformationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client_No", "Lastname", "Firstname", "Middlename", "Gender", "Birthday", "Place_Of_Birth", "Civil_Status", "Current_Address", "Mobile", "Telephone", "Nationaliity", "Occupation", "Source_Of_Income", "Email", "Company_Name", "Mother_Maiden_Name", "Amount_of_Payment", "Date_of_Payment", "CR_Full_Name", "CR_Mobile", "CR_Position", "CR1_Full_Name", "CR1_Mobile", "CR1_Position"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ClientInformationTable.getTableHeader().setReorderingAllowed(false);
        ClientInformationTable.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                ClientInformationTableComponentRemoved(evt);
            }
        });
        ClientInformationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientInformationTableMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(ClientInformationTable);
        if (ClientInformationTable.getColumnModel().getColumnCount() > 0) {
            ClientInformationTable.getColumnModel().getColumn(0).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(1).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            ClientInformationTable.getColumnModel().getColumn(2).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            ClientInformationTable.getColumnModel().getColumn(3).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            ClientInformationTable.getColumnModel().getColumn(4).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(5).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(6).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(7).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(8).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(8).setPreferredWidth(200);
            ClientInformationTable.getColumnModel().getColumn(9).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(9).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(10).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(10).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(11).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(11).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(12).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(12).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(13).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(13).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(14).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(14).setPreferredWidth(150);
            ClientInformationTable.getColumnModel().getColumn(15).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(15).setPreferredWidth(150);
            ClientInformationTable.getColumnModel().getColumn(16).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(16).setPreferredWidth(200);
            ClientInformationTable.getColumnModel().getColumn(17).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(17).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(18).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(18).setPreferredWidth(100);
            ClientInformationTable.getColumnModel().getColumn(19).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(19).setPreferredWidth(200);
            ClientInformationTable.getColumnModel().getColumn(20).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(20).setPreferredWidth(200);
            ClientInformationTable.getColumnModel().getColumn(21).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(21).setPreferredWidth(200);
            ClientInformationTable.getColumnModel().getColumn(22).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(22).setPreferredWidth(200);
            ClientInformationTable.getColumnModel().getColumn(23).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(23).setPreferredWidth(200);
            ClientInformationTable.getColumnModel().getColumn(24).setResizable(false);
            ClientInformationTable.getColumnModel().getColumn(24).setPreferredWidth(200);
        }

        clientsinfo.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 700, 100));

        Update_Button2.setBackground(new java.awt.Color(0, 153, 255));
        Update_Button2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Update_Button2.setForeground(new java.awt.Color(255, 255, 255));
        Update_Button2.setText("UPDATE");
        Update_Button2.setBorder(null);
        Update_Button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_Button2ActionPerformed(evt);
            }
        });
        clientsinfo.add(Update_Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 60, -1));

        Save_Button2.setBackground(new java.awt.Color(0, 153, 255));
        Save_Button2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Save_Button2.setForeground(new java.awt.Color(255, 255, 255));
        Save_Button2.setText("SAVE");
        Save_Button2.setBorder(null);
        Save_Button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Save_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_Button2ActionPerformed(evt);
            }
        });
        clientsinfo.add(Save_Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 60, 20));

        Edit_Button2.setBackground(new java.awt.Color(0, 153, 255));
        Edit_Button2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Edit_Button2.setForeground(new java.awt.Color(255, 255, 255));
        Edit_Button2.setText("EDIT");
        Edit_Button2.setBorder(null);
        Edit_Button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_Button2ActionPerformed(evt);
            }
        });
        clientsinfo.add(Edit_Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 60, 20));

        del_Button1.setBackground(new java.awt.Color(0, 153, 255));
        del_Button1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        del_Button1.setForeground(new java.awt.Color(255, 255, 255));
        del_Button1.setText("DELETE");
        del_Button1.setBorder(null);
        del_Button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        del_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_Button1ActionPerformed(evt);
            }
        });
        clientsinfo.add(del_Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 60, 20));

        lbl_DisplayImage.setBackground(new java.awt.Color(51, 51, 51));
        lbl_DisplayImage.setOpaque(true);
        clientsinfo.add(lbl_DisplayImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 160, 150));

        Attach_Photo1.setBackground(new java.awt.Color(0, 153, 255));
        Attach_Photo1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Attach_Photo1.setForeground(new java.awt.Color(255, 255, 255));
        Attach_Photo1.setText("ATTACH");
        Attach_Photo1.setBorder(null);
        Attach_Photo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Attach_Photo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Attach_Photo1MousePressed(evt);
            }
        });
        Attach_Photo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach_Photo1ActionPerformed(evt);
            }
        });
        clientsinfo.add(Attach_Photo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 70, 20));

        Status5.setBackground(new java.awt.Color(0, 0, 0));
        Status5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Status5.setForeground(new java.awt.Color(51, 51, 51));
        Status5.setText("Nationality");
        clientsinfo.add(Status5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 80, 20));

        jTextField85.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField85.setEnabled(false);
        clientsinfo.add(jTextField85, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 90, -1));

        Status7.setBackground(new java.awt.Color(0, 0, 0));
        Status7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Status7.setForeground(new java.awt.Color(51, 51, 51));
        Status7.setText("Birthday");
        clientsinfo.add(Status7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 70, 20));

        jDateChooser3.setEnabled(false);
        clientsinfo.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 130, 30));

        New1.setBackground(new java.awt.Color(0, 153, 255));
        New1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        New1.setForeground(new java.awt.Color(255, 255, 255));
        New1.setText("NEW");
        New1.setBorder(null);
        New1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        New1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                New1ActionPerformed(evt);
            }
        });
        clientsinfo.add(New1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 60, 20));

        Occupation16.setBackground(new java.awt.Color(0, 0, 0));
        Occupation16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Occupation16.setForeground(new java.awt.Color(51, 51, 51));
        Occupation16.setText("Place of birth");
        clientsinfo.add(Occupation16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 100, 20));

        jTextField150.setEnabled(false);
        clientsinfo.add(jTextField150, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 130, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Widowed", "Annulled" }));
        jComboBox2.setEnabled(false);
        clientsinfo.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 100, -1));

        Mobile6.setBackground(new java.awt.Color(0, 0, 0));
        Mobile6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Mobile6.setForeground(new java.awt.Color(51, 51, 51));
        Mobile6.setText("Telephone");
        clientsinfo.add(Mobile6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 80, 20));

        jTextField151.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField151.setEnabled(false);
        jTextField151.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField151MouseClicked(evt);
            }
        });
        jTextField151.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField151ActionPerformed(evt);
            }
        });
        jTextField151.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField151KeyTyped(evt);
            }
        });
        clientsinfo.add(jTextField151, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 120, -1));

        Occupation17.setBackground(new java.awt.Color(0, 0, 0));
        Occupation17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Occupation17.setForeground(new java.awt.Color(51, 51, 51));
        Occupation17.setText("Source of Income");
        clientsinfo.add(Occupation17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 130, 20));

        jTextField81.setEnabled(false);
        clientsinfo.add(jTextField81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 170, -1));

        Email2.setBackground(new java.awt.Color(0, 0, 0));
        Email2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Email2.setForeground(new java.awt.Color(51, 51, 51));
        Email2.setText("Company Name");
        clientsinfo.add(Email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 120, 20));

        jTextField152.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField152.setEnabled(false);
        clientsinfo.add(jTextField152, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 150, -1));

        Email4.setBackground(new java.awt.Color(0, 0, 0));
        Email4.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Email4.setForeground(new java.awt.Color(51, 51, 51));
        Email4.setText("Full Name");
        clientsinfo.add(Email4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 80, -1));

        jTextField153.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField153.setEnabled(false);
        clientsinfo.add(jTextField153, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 160, -1));

        Email5.setBackground(new java.awt.Color(0, 0, 0));
        Email5.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Email5.setForeground(new java.awt.Color(51, 51, 51));
        Email5.setText("Personal Information");
        clientsinfo.add(Email5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 20));

        jTextField154.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField154.setEnabled(false);
        clientsinfo.add(jTextField154, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 160, -1));

        jSeparator1.setOpaque(true);
        clientsinfo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 28, 370, -1));

        Email7.setBackground(new java.awt.Color(0, 0, 0));
        Email7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Email7.setForeground(new java.awt.Color(51, 51, 51));
        Email7.setText("Mother Maiden Name");
        clientsinfo.add(Email7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 150, 20));

        Email8.setBackground(new java.awt.Color(0, 0, 0));
        Email8.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Email8.setForeground(new java.awt.Color(51, 51, 51));
        Email8.setText("Mobile");
        clientsinfo.add(Email8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 50, -1));

        jTextField155.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField155.setEnabled(false);
        clientsinfo.add(jTextField155, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 160, -1));

        jTextField156.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField156.setEnabled(false);
        clientsinfo.add(jTextField156, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 140, -1));

        Email9.setBackground(new java.awt.Color(0, 0, 0));
        Email9.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Email9.setForeground(new java.awt.Color(51, 51, 51));
        Email9.setText("Position");
        clientsinfo.add(Email9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 60, -1));

        jSeparator2.setOpaque(true);
        clientsinfo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 530, -1));

        Email10.setBackground(new java.awt.Color(0, 0, 0));
        Email10.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Email10.setForeground(new java.awt.Color(51, 51, 51));
        Email10.setText("Character Reference");
        clientsinfo.add(Email10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 150, 20));

        jLabel48.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("Amount of Payment");
        clientsinfo.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 130, 20));

        jLabel49.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("Date of Payment");
        clientsinfo.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 110, 20));

        jTextField29.setEnabled(false);
        clientsinfo.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 130, -1));

        jTextField30.setEnabled(false);
        clientsinfo.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 110, -1));

        jTextField158.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField158.setEnabled(false);
        clientsinfo.add(jTextField158, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 160, -1));

        Email11.setBackground(new java.awt.Color(0, 0, 0));
        Email11.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Email11.setForeground(new java.awt.Color(51, 51, 51));
        Email11.setText("Full Name");
        clientsinfo.add(Email11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 80, -1));

        Email12.setBackground(new java.awt.Color(0, 0, 0));
        Email12.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Email12.setForeground(new java.awt.Color(51, 51, 51));
        Email12.setText("Mobile");
        clientsinfo.add(Email12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 50, -1));

        jTextField159.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField159.setEnabled(false);
        clientsinfo.add(jTextField159, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 160, -1));

        jTextField160.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField160.setEnabled(false);
        clientsinfo.add(jTextField160, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 140, -1));

        Email13.setBackground(new java.awt.Color(0, 0, 0));
        Email13.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Email13.setForeground(new java.awt.Color(51, 51, 51));
        Email13.setText("Position");
        clientsinfo.add(Email13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 60, -1));

        jTabbedPane1.addTab("Clients Information", clientsinfo);

        notif.setBackground(new java.awt.Color(255, 255, 255));
        notif.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setEnabled(false);
        jScrollPane14.setViewportView(jTextArea2);

        notif.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 290, 120));

        jTextField86.setEnabled(false);
        notif.add(jTextField86, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, -1));

        jTextField87.setEnabled(false);
        notif.add(jTextField87, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 140, -1));

        jLabel35.setBackground(new java.awt.Color(51, 173, 255));
        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("     SEND");
        jLabel35.setOpaque(true);
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
        });
        notif.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 80, 30));

        Mobile4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Mobile4.setForeground(new java.awt.Color(51, 51, 51));
        Mobile4.setText("Mobile");
        notif.add(Mobile4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 60, 20));

        Message1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Message1.setForeground(new java.awt.Color(51, 51, 51));
        Message1.setText("Message");
        notif.add(Message1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, 20));

        jTextField88.setEnabled(false);
        jTextField88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField88ActionPerformed(evt);
            }
        });
        notif.add(jTextField88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, -1));

        CIDFK1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CIDFK1.setForeground(new java.awt.Color(51, 51, 51));
        CIDFK1.setText("Client No");
        notif.add(CIDFK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 20));

        Email3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Email3.setForeground(new java.awt.Color(51, 51, 51));
        Email3.setText("Template");
        notif.add(Email3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 70, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Payment Reminder                                        (Name of Sender) (Name of Company or Business) (Address of Business) (Date) (Name of Person) (Address of Person)        Dear Name of A Person,  This Letter is formally to inform you that the ppayment owed by you is past due. The payment of amount was due on (Date). Kindly submit this amount by cashiers check along with your payment in return mail if your payment was already sent, please diregard this message , However if you have not yet made payment, kindly do so immediately. Thank you for attending this matter as soon as possible", "Penalty Reminder                                           (Date) (Name) (Address)     Dear (Name of a person) , In our message of(Date) it was agreed that you would settle the outstanding balance of(Amount of account Number on Date). This agreement was based on the understanding that failure so compty would result in our legal representatives taking over the matter.   Unfortunately,Settlement was not made on(Date). If we have not receive your remittance by (Date), we will instruct our legal representatiives to take immediate actiion to recover the debt.     (Name of Sender)", "Other" }));
        jComboBox1.setEnabled(false);
        jComboBox1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jComboBox1MouseMoved(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        notif.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 120, -1));

        Email6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Email6.setForeground(new java.awt.Color(51, 51, 51));
        Email6.setText("Email");
        notif.add(Email6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 20));

        jLabel50.setBackground(new java.awt.Color(51, 173, 255));
        jLabel50.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("    RESET");
        jLabel50.setOpaque(true);
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel50MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel50MouseExited(evt);
            }
        });
        notif.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 80, 30));

        NotificationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client_No", "Mobile", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        NotificationTable.getTableHeader().setReorderingAllowed(false);
        NotificationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NotificationTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(NotificationTable);
        if (NotificationTable.getColumnModel().getColumnCount() > 0) {
            NotificationTable.getColumnModel().getColumn(0).setResizable(false);
            NotificationTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            NotificationTable.getColumnModel().getColumn(1).setResizable(false);
            NotificationTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            NotificationTable.getColumnModel().getColumn(2).setResizable(false);
            NotificationTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        notif.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 340, 300));

        jTabbedPane1.addTab("Notify", notif);

        cmpanel.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 580));

        getContentPane().add(cmpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 720, 580));

        jPanel3.setBackground(new java.awt.Color(51, 173, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("EucrosiaUPC", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("(Core II)");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 120, 30));

        jLabel5.setFont(new java.awt.Font("EucrosiaUPC", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Microfinance System");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 410, 45));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/llogo.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 90, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/search.png"))); // NOI18N
        jLabel2.setText("Search");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 80, 30));

        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 170, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 730, 90));

        MenuBar.setBackground(new java.awt.Color(2, 107, 184));
        MenuBar.setFont(new java.awt.Font("Adobe Arabic", 1, 11)); // NOI18N
        MenuBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MenuBarMouseDragged(evt);
            }
        });
        MenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuBarMousePressed(evt);
            }
        });
        MenuBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winClose_btn.setBackground(new java.awt.Color(255, 51, 0));
        winClose_btn.setForeground(new java.awt.Color(255, 255, 255));
        winClose_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winClose_btn.setToolTipText("Close");
        winClose_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        winClose_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                winClose_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                winClose_btnMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                winClose_btnMouseReleased(evt);
            }
        });
        MenuBar.add(winClose_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 0, -1, -1));

        Maintenance_btn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Maintenance_btn.setForeground(new java.awt.Color(255, 255, 255));
        Maintenance_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Maintenance_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/maintenance.png"))); // NOI18N
        Maintenance_btn.setText("Maintenance");
        Maintenance_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Maintenance_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Maintenance_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Maintenance_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Maintenance_btnMouseExited(evt);
            }
        });
        MenuBar.add(Maintenance_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 117, 30));

        winRes_Max_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winRes_Max_btn.setToolTipText("");
        winRes_Max_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        winRes_Max_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                winRes_Max_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                winRes_Max_btnMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                winRes_Max_btnMouseReleased(evt);
            }
        });
        MenuBar.add(winRes_Max_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 0, -1, -1));

        winMinimize_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winMinimize_btn.setToolTipText("Minimize");
        winMinimize_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        winMinimize_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                winMinimize_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                winMinimize_btnMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                winMinimize_btnMouseReleased(evt);
            }
        });
        MenuBar.add(winMinimize_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 0, -1, -1));

        Settings_btn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Settings_btn.setForeground(new java.awt.Color(255, 255, 255));
        Settings_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Settings_btn.setToolTipText("System Settings");
        Settings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Settings_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Settings_btnMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Settings_btnMouseReleased(evt);
            }
        });
        MenuBar.add(Settings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 0, -1, -1));

        winMinimize_btn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winMinimize_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/minimize.png"))); // NOI18N
        winMinimize_btn1.setToolTipText("Minimize");
        winMinimize_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        winMinimize_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                winMinimize_btn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                winMinimize_btn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                winMinimize_btn1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                winMinimize_btn1MouseReleased(evt);
            }
        });
        MenuBar.add(winMinimize_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 40, 30));

        winClose_btn1.setBackground(new java.awt.Color(255, 51, 0));
        winClose_btn1.setForeground(new java.awt.Color(255, 255, 255));
        winClose_btn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winClose_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/close.png"))); // NOI18N
        winClose_btn1.setToolTipText("Close");
        winClose_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        winClose_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                winClose_btn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                winClose_btn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                winClose_btn1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                winClose_btn1MouseReleased(evt);
            }
        });
        MenuBar.add(winClose_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 40, 30));

        getContentPane().add(MenuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 30));

        setSize(new java.awt.Dimension(929, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jLabel9.setOpaque(true);
        jLabel9.setBackground(new java.awt.Color(102, 102, 102));//graycolor
        jLabel9.repaint();
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        jLabel9.setOpaque(false);
        jLabel9.repaint();
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered

    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited

    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed


    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased

    }//GEN-LAST:event_jLabel6MouseReleased

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered

    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited

    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered

    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited

    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered

    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited

    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        jLabel22.setOpaque(true);
        jLabel22.setBackground(new java.awt.Color(102, 102, 102));
        jLabel22.repaint();
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        jLabel22.setOpaque(false);
        jLabel22.repaint();
    }//GEN-LAST:event_jLabel22MouseExited

    private void winClose_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winClose_btnMouseEntered
        winClose_btn.setOpaque(true);
        winClose_btn.setBackground(new java.awt.Color(255, 51, 0));
        winClose_btn.repaint();
    }//GEN-LAST:event_winClose_btnMouseEntered

    private void winClose_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winClose_btnMouseExited
        winClose_btn.setOpaque(false);
        winClose_btn.repaint();
    }//GEN-LAST:event_winClose_btnMouseExited

    private void winClose_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winClose_btnMouseReleased

    }//GEN-LAST:event_winClose_btnMouseReleased

    private void Maintenance_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Maintenance_btnMouseEntered
        Maintenance_btn.setOpaque(true);
        Maintenance_btn.setBackground(new java.awt.Color(51, 173, 255));
        Maintenance_btn.repaint();
    }//GEN-LAST:event_Maintenance_btnMouseEntered

    private void Maintenance_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Maintenance_btnMouseExited
        Maintenance_btn.setOpaque(false);
        Maintenance_btn.repaint();
    }//GEN-LAST:event_Maintenance_btnMouseExited

    private void winRes_Max_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winRes_Max_btnMouseEntered
        winRes_Max_btn.setOpaque(true);
        winRes_Max_btn.setBackground(new java.awt.Color(51, 173, 255));
        winRes_Max_btn.repaint();
    }//GEN-LAST:event_winRes_Max_btnMouseEntered

    private void winRes_Max_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winRes_Max_btnMouseExited
        winRes_Max_btn.setOpaque(false);
        winRes_Max_btn.repaint();
    }//GEN-LAST:event_winRes_Max_btnMouseExited

    private void winRes_Max_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winRes_Max_btnMouseReleased
        /*if(this.isPreferredSizeSet()){
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }else{
            this.setExtendedState(JFrame.NORMAL);
        }*/
    }//GEN-LAST:event_winRes_Max_btnMouseReleased

    private void winMinimize_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winMinimize_btnMouseEntered
        winMinimize_btn.setOpaque(true);
        winMinimize_btn.setBackground(new java.awt.Color(51, 173, 255));
        winMinimize_btn.repaint();
    }//GEN-LAST:event_winMinimize_btnMouseEntered

    private void winMinimize_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winMinimize_btnMouseExited
        winMinimize_btn.setOpaque(false);
        winMinimize_btn.repaint();
    }//GEN-LAST:event_winMinimize_btnMouseExited

    private void winMinimize_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winMinimize_btnMouseReleased

    }//GEN-LAST:event_winMinimize_btnMouseReleased

    private void Settings_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Settings_btnMouseEntered
        Settings_btn.setOpaque(true);
        Settings_btn.setBackground(new java.awt.Color(51, 173, 255));
        Settings_btn.repaint();
    }//GEN-LAST:event_Settings_btnMouseEntered

    private void Settings_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Settings_btnMouseExited
        Settings_btn.setOpaque(false);
        Settings_btn.repaint();
    }//GEN-LAST:event_Settings_btnMouseExited

    private void Settings_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Settings_btnMouseReleased

    }//GEN-LAST:event_Settings_btnMouseReleased

    private void winMinimize_btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winMinimize_btn1MouseEntered
        winMinimize_btn.setOpaque(true);
        winMinimize_btn.setBackground(new java.awt.Color(51, 173, 255));
        winMinimize_btn.repaint();
    }//GEN-LAST:event_winMinimize_btn1MouseEntered

    private void winMinimize_btn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winMinimize_btn1MouseExited
        winMinimize_btn.setOpaque(false);
        winMinimize_btn.repaint();
    }//GEN-LAST:event_winMinimize_btn1MouseExited

    private void winMinimize_btn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winMinimize_btn1MouseReleased

    }//GEN-LAST:event_winMinimize_btn1MouseReleased

    private void winClose_btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winClose_btn1MouseEntered
        winClose_btn1.setOpaque(true);
        winClose_btn1.setBackground(new java.awt.Color(255, 51, 0));
        winClose_btn1.repaint();
    }//GEN-LAST:event_winClose_btn1MouseEntered

    private void winClose_btn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winClose_btn1MouseExited
        winClose_btn1.setOpaque(false);
        winClose_btn1.repaint();
    }//GEN-LAST:event_winClose_btn1MouseExited

    private void winClose_btn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winClose_btn1MouseReleased

    }//GEN-LAST:event_winClose_btn1MouseReleased

    private void winClose_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winClose_btn1MouseClicked

        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_winClose_btn1MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked

        new login().setVisible(true);
        this.hide();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseExited

    private void winMinimize_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winMinimize_btn1MouseClicked
        this.setState(MainFrame.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_winMinimize_btn1MouseClicked

    private void MenuBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_MenuBarMouseDragged

    private void MenuBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBarMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_MenuBarMousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
 
        try {         
            String ClientInformation = "Select Client_No,Lastname,Firstname,Middlename,Gender,Birthday,Place_Of_Birth,Civil_Status,Current_Address,Mobile,Telephone,Nationality,Occupation,Source_Of_Income,Email,Company_Name,Mother_Maiden_Name,CR_Full_Name,CR_Mobile,CR_Position from ClientInformation where Client_No like ?";
            
         String Notification = "Select *from Notification where Client_No like ?";
         
           String personalLoan2 = "Select * from WT_PersonalLoan2 where Client_No like ?";
           
            ps = con.prepareStatement(ClientInformation);
            ps.setString(1, jTextField1.getText() + "%");
            rs = ps.executeQuery();
            ClientInformationTable.setModel(DbUtils.resultSetToTableModel(rs));
        
              ps = con.prepareStatement(Notification);
              ps.setString(1, jTextField1.getText() + "%");
            rs = ps.executeQuery();
           NotificationTable.setModel(DbUtils.resultSetToTableModel(rs));
           
           ps = con.prepareStatement(personalLoan2);
              ps.setString(1, jTextField1.getText() + "%");
            rs = ps.executeQuery();
            Personal_Loan2.setModel(DbUtils.resultSetToTableModel(rs));    
            
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


        if (jTextField1.getText().isEmpty()) {
            jLabel2.show();
        } else {
            jLabel2.hide();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        socialmonitoring.show();
        consolidation.hide();
        saving.hide();

        cmpanel.hide();
        jLabel10.setOpaque(true);
        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.repaint();

        jLabel12.setOpaque(false);
        jLabel12.repaint();
        jLabel11.setOpaque(false);
        jLabel11.repaint();
        jLabel6.setOpaque(false);
        jLabel6.repaint();


    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        cmpanel.show();
        consolidation.hide();
        saving.hide();
        socialmonitoring.hide();

        jLabel6.setOpaque(true);
        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.repaint();

        jLabel12.setOpaque(false);
        jLabel12.repaint();
        jLabel11.setOpaque(false);
        jLabel11.repaint();
        jLabel10.setOpaque(false);
        jLabel10.repaint();

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked

        consolidation.show();
        saving.hide();
        socialmonitoring.hide();
        cmpanel.hide();
        jLabel12.setOpaque(true);
        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.repaint();

        jLabel11.setOpaque(false);
        jLabel11.repaint();
        jLabel10.setOpaque(false);
        jLabel10.repaint();
        jLabel6.setOpaque(false);
        jLabel6.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        saving.show();
        consolidation.hide();
        panelloan2.removeAll();
        panelloan.removeAll();
        socialmonitoring.hide();
        cmpanel.hide();
        jLabel11.setOpaque(true);
        jLabel11.setBackground(new java.awt.Color(102, 102, 102));
        jLabel11.repaint();

        jLabel12.setOpaque(false);
        jLabel12.repaint();
        jLabel6.setOpaque(false);
        jLabel6.repaint();
        jLabel10.setOpaque(false);
        jLabel10.repaint();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
  String Client_Information = "Select Client_No,Lastname,Firstname,Middlename,Gender,Birthday,Place_Of_Birth,Civil_Status,Current_Address,Mobile,Telephone,Nationality,Occupation,Source_Of_Income,"
             + "Email,Company_Name,Mother_Maiden_Name,CR_Full_Name,CR_Mobile,CR_Position from ClientInformation where Client_No like ?";
     
     String Notification = "Select * from Notification where Client_No like ?";
     
      String PersonalLoan2 = "Select * from WT_PersonalLoan2 where Client_No like ?";
        String BusinessLoan2 = "Select * from WT_BusinessLoan2 where Client_No like ?";
         String HomeLoan2 = "Select * from WT_HomeLoan2 where Client_No like ?";
           String OFWLoan2 = "Select * from WT_OFWLoan2 where Client_No like ?";
              String SalaryLoan2 = "Select * from WT_Salary_Loan2 where Client_No like ?";
              
              String PersonalLoan = "Select * from DT_PersonalLoan where Client_No like ?";
        String BusinessLoan = "Select * from DT_BusinessLoan where Client_No like ?";
         String HomeLoan = "Select * from DT_HomeLoan where Client_No like ?";
           String OFWLoan = "Select * from DT_OFWLoan where Client_No like ?";
              String SalaryLoan = "Select * from DT_SalaryLoan where Client_No like ?";
              
                 String ClientStatus = "Select * from Client_Status where Client_No like ?";
                    String ClientMonitoring = "Select * from Client_Monitoring where Client_No like ?";
      try{
          ps = con.prepareStatement(Client_Information);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          ClientInformationTable.setModel(DbUtils.resultSetToTableModel(rs));
         
           ps = con.prepareStatement(Notification);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          NotificationTable.setModel(DbUtils.resultSetToTableModel(rs));
  
          ps = con.prepareStatement(PersonalLoan2);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          Personal_Loan2.setModel(DbUtils.resultSetToTableModel(rs));
          
            ps = con.prepareStatement(BusinessLoan2);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          Business_Loan2.setModel(DbUtils.resultSetToTableModel(rs));
          
            ps = con.prepareStatement(HomeLoan2);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          Home_Loan2.setModel(DbUtils.resultSetToTableModel(rs));
          
           ps = con.prepareStatement(OFWLoan2);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          OFW_Loan2.setModel(DbUtils.resultSetToTableModel(rs));
          
             ps = con.prepareStatement(SalaryLoan2);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
         Salary_Loan2.setModel(DbUtils.resultSetToTableModel(rs));
         
          ps = con.prepareStatement(PersonalLoan);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          Personal_Loan.setModel(DbUtils.resultSetToTableModel(rs));
          
            ps = con.prepareStatement(BusinessLoan);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          jTable1.setModel(DbUtils.resultSetToTableModel(rs));
          
            ps = con.prepareStatement(HomeLoan);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          Home_Loan.setModel(DbUtils.resultSetToTableModel(rs));
          
           ps = con.prepareStatement(OFWLoan);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
          OFW_Loan.setModel(DbUtils.resultSetToTableModel(rs));
          
             ps = con.prepareStatement(SalaryLoan);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
         Salary_Loan.setModel(DbUtils.resultSetToTableModel(rs));
         
           ps = con.prepareStatement(ClientStatus);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
         Client_Status.setModel(DbUtils.resultSetToTableModel(rs));
         
           ps = con.prepareStatement(ClientMonitoring);
          ps.setString(1,jTextField1.getText()+ "%");
          rs = ps.executeQuery();
         Client_Monitoring.setModel(DbUtils.resultSetToTableModel(rs));
         
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }   

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21KeyTyped

    private void jTextField83KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField83KeyTyped
        char cchar = evt.getKeyChar();
        if (!Character.isDigit(cchar) || (cchar == KeyEvent.VK_BACKSPACE) || (cchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (jTextField83.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField83KeyTyped

    private void ClientInformationTableComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_ClientInformationTableComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientInformationTableComponentRemoved

    private void ClientInformationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientInformationTableMouseClicked
        int ClientInfo = ClientInformationTable.getSelectedRow();
        ShowDataInClientInformation(ClientInfo);
    }//GEN-LAST:event_ClientInformationTableMouseClicked

    private void Update_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_Button2ActionPerformed


    }//GEN-LAST:event_Update_Button2ActionPerformed

    private void Save_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_Button2ActionPerformed

        try {
            Connection con = getConnectionDB();
            PreparedStatement ps = con.prepareStatement("INSERT INTO"
                    + " ClientInformation(Client_No,Lastname,Firstname,Middlename,Gender,Birthday,Place_Of_Birth,Civil_Status,Current_Address"
                    + ",Mobile,Telephone,Nationality,Occupation,Source_Of_Income,Email,Company_Name,Mother_Maiden_Name,CR_Full_Name,CR_Mobile,CR_Position,Image_CI)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(jTextField21.getText()));//CID
            ps.setString(2, jTextField77.getText());//Lastname
            ps.setString(3, jTextField78.getText());//Firstname
            ps.setString(4, jTextField79.getText());//Middlename
            ps.setString(5, jComboBox4.getSelectedItem().toString());
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");//Birthday
            String addDate1 = dateFormat1.format(jDateChooser3.getDate());
            ps.setString(6, addDate1);//Birthday
            ps.setString(7, jTextField150.getText());//Occupation
            ps.setString(8, jComboBox2.getSelectedItem().toString());
            ps.setString(9, jTextField84.getText());
            ps.setInt(10, Integer.parseInt(jTextField83.getText()));
            ps.setInt(11, Integer.parseInt(jTextField151.getText()));
            ps.setString(12, jTextField85.getText());//Middlename
            ps.setString(13, jTextField80.getText());//Middlename
            ps.setString(14, jTextField81.getText());
            ps.setString(15, jTextField82.getText());
            ps.setString(16, jTextField152.getText());
            ps.setString(17, jTextField153.getText());//Middlename
            ps.setString(18, jTextField154.getText());
            ps.setString(19, jTextField155.getText());
            ps.setString(20, jTextField156.getText());

            InputStream img = new FileInputStream(new File(ImgPath));//IMAGE
            ps.setBlob(21, img);
            ps.executeUpdate();
            ShowDataInClientInformationTable();

            Connection conn = getConnectionDB();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO"
                    + " Notification (Client_No,Mobile,Email,Message)"
                    + "values(?,?,?,?)");
            pst.setInt(1, Integer.parseInt(jTextField21.getText()));//CID
            pst.setInt(2, Integer.parseInt(jTextField83.getText()));//Lastname
            pst.setString(3, jTextField82.getText());//Firstname
            pst.setString(4, jTextArea2.getText());//Message
            pst.executeUpdate();
            ShowDataInNotificationTable();
            
            Connection co = getConnectionDB();
            PreparedStatement p = co.prepareStatement("Insert into history(Client_No,Lastname,Firstname,Middlename,Date_Registered,Tim_eRegistered)values(?,?,?,?,?,?)");
            p.setInt(1,Integer.parseInt(jTextField21.getText()));
             p.setString(2, jTextField77.getText());//Firstname
              p.setString(3, jTextField78.getText());//Firstname
               p.setString(4, jTextField79.getText());//Firstname
               java.util.Date date = new java.util.Date();
               java.sql.Date sqlDate = new java.sql.Date(date.getTime());
               java.sql.Time sqlTime = new java.sql.Time(date.getTime());
              p.setDate(5, sqlDate);
              p.setTime(6,sqlTime);
               
            JOptionPane.showMessageDialog(null, "Data Successfully Added");
            jTextField21.setEnabled(false);
            jTextField77.setEnabled(false);
            jTextField78.setEnabled(false);
            jTextField79.setEnabled(false);
            jComboBox4.setEnabled(false);
            jDateChooser3.setEnabled(false);
            jTextField150.setEnabled(false);
            jComboBox2.setEnabled(false);
            jTextField84.setEnabled(false);
            jTextField83.setEnabled(false);
            jTextField151.setEnabled(false);
            jTextField85.setEnabled(false);
            jTextField80.setEnabled(false);
            jTextField81.setEnabled(false);
            jTextField82.setEnabled(false);
            jTextField152.setEnabled(false);
            jTextField153.setEnabled(false);
            jTextField154.setEnabled(false);
            jTextField155.setEnabled(false);
            jTextField156.setEnabled(false);

            jTextField21.setText("");
            jTextField77.setText("");
            jTextField78.setText("");
            jTextField79.setText("");
            jComboBox4.setSelectedItem((null));
            jDateChooser3.setDate((null));
            jTextField150.setText("");
            jComboBox2.setSelectedItem((null));
            jTextField84.setText("");
            jTextField83.setText("");
            jTextField151.setText("");
            jTextField85.setText("");
            jTextField80.setText("");
            jTextField81.setText("");
            jTextField82.setText("");
            jTextField152.setText("");
            jTextField153.setText("");
            jTextField154.setText("");
            jTextField155.setText("");
            jTextField156.setText("");
            lbl_DisplayImage.setIcon((null));
            jTextField88.setText("");
            jTextField87.setText("");
            jTextField86.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_Save_Button2ActionPerformed

    private void Edit_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_Button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Edit_Button2ActionPerformed

    private void del_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_Button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_del_Button1ActionPerformed

    private void Attach_Photo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Attach_Photo1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach_Photo1MousePressed

    private void Attach_Photo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach_Photo1ActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_DisplayImage.setIcon(ResizeImage(path, null));
            ImgPath = path;
        } else {
            JOptionPane.showMessageDialog(null, " No File Selected");
        }
    }//GEN-LAST:event_Attach_Photo1ActionPerformed

    private void New1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_New1ActionPerformed
        jTextField21.setEnabled(true);
        jTextField77.setEnabled(true);
        jTextField78.setEnabled(true);
        jTextField79.setEnabled(true);
        jComboBox4.setEnabled(true);
        jDateChooser3.setEnabled(true);
        jTextField150.setEnabled(true);
        jComboBox2.setEnabled(true);
        jTextField84.setEnabled(true);
        jTextField83.setEnabled(true);
        jTextField151.setEnabled(true);
        jTextField85.setEnabled(true);
        jTextField80.setEnabled(true);
        jTextField81.setEnabled(true);
        jTextField82.setEnabled(true);
        jTextField152.setEnabled(true);
        jTextField153.setEnabled(true);
        jTextField154.setEnabled(true);
        jTextField155.setEnabled(true);
        jTextField156.setEnabled(true);
        lbl_DisplayImage.setIcon((null));
        jTextField21.setText("");
        jTextField77.setText("");
        jTextField78.setText("");
        jTextField79.setText("");
        jComboBox4.setSelectedItem((null));
        jDateChooser3.setDate((null));
        jTextField150.setText("");
        jComboBox2.setSelectedItem((null));
        jTextField84.setText("");
        jTextField83.setText("");
        jTextField151.setText("");
        jTextField85.setText("");
        jTextField80.setText("");
        jTextField81.setText("");
        jTextField82.setText("");
        jTextField152.setText("");
        jTextField153.setText("");
        jTextField154.setText("");
        jTextField155.setText("");
        jTextField156.setText("");
        jTextField88.setText("");
        jTextField87.setText("");
        jTextField86.setText("");
    }//GEN-LAST:event_New1ActionPerformed

    private void jTextField125ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField125ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField125ActionPerformed

    private void jTextField83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField83MouseClicked

// TODO add your handling code here:
    }//GEN-LAST:event_jTextField83MouseClicked

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked

    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       jTextArea2.setText((String) jComboBox1.getSelectedItem());
  
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jComboBox1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseMoved

    private void jTextField151MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField151MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField151MouseClicked

    private void jTextField151KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField151KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField151KeyTyped

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if(jComboBox3.getSelectedItem().equals("Personal Loan")){
            panelloan.removeAll();
            panelloan.add(personalloan);
            panelloan.revalidate();
            panelloan.repaint();
            emptytextFieldDeposits();
        }else if(jComboBox3.getSelectedItem().equals("OFW Loan")){
            panelloan.removeAll();
            panelloan.add(OFWloan);
            panelloan.revalidate();
            panelloan.repaint();
            emptytextFieldDeposits();
        }else if(jComboBox3.getSelectedItem().equals("Business Loan")){
            panelloan.removeAll();
            panelloan.add(Business);
            panelloan.revalidate();
            panelloan.repaint();
            emptytextFieldDeposits();
        }else if(jComboBox3.getSelectedItem().equals("Salary Loan")){
            panelloan.removeAll();
            panelloan.add(salary);
            panelloan.revalidate();
            panelloan.repaint();
            emptytextFieldDeposits();
        }else if(jComboBox3.getSelectedItem().equals("Home Loan")){
            panelloan.removeAll();
            panelloan.add(Homeloan);
            panelloan.revalidate();
            panelloan.repaint();
            emptytextFieldDeposits();
        }else{
            panelloan.removeAll();
             panelloan.revalidate();
            panelloan.repaint();
            emptytextFieldDeposits();
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
           if(jComboBox9.getSelectedItem().equals("Personal Loan")){
            panelloan2.removeAll();
            panelloan2.add(personalloan2);
            panelloan2.revalidate();
            panelloan2.repaint();
            emptytextField();
        }else if(jComboBox9.getSelectedItem().equals("OFW Loan")){
            panelloan2.removeAll();
            panelloan2.add(OFWloan2);
            panelloan2.revalidate();
            panelloan2.repaint();
            emptytextField();
        }else if(jComboBox9.getSelectedItem().equals("Business Loan")){
            panelloan2.removeAll();
            panelloan2.add(Business2);
            panelloan2.revalidate();
            panelloan2.repaint();
            emptytextField();
        }else if(jComboBox9.getSelectedItem().equals("Salary Loan")){
            panelloan2.removeAll();
            panelloan2.add(salary2);
            panelloan2.revalidate();
            panelloan2.repaint();
            emptytextField();
        }else if(jComboBox9.getSelectedItem().equals("Home Loan")){
            panelloan2.removeAll();
            panelloan2.add(Homeloan2);
            panelloan2.revalidate();
            panelloan2.repaint();
            emptytextField();
        }else{
            panelloan2.removeAll();
             panelloan2.revalidate();
            panelloan2.repaint();
        }
      
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void Personal_Loan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Personal_Loan2MouseClicked
        int personalLoan2 = Personal_Loan2.getSelectedRow();
       ShowDataInPersonalLoan2(personalLoan2);
    }//GEN-LAST:event_Personal_Loan2MouseClicked

    private void jTextField88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField88ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField88ActionPerformed

    private void OFW_Loan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OFW_Loan2MouseClicked
      int ofw_loan2 = OFW_Loan2.getSelectedRow();
      ShowDataInOFW_Loan2(ofw_loan2);
    }//GEN-LAST:event_OFW_Loan2MouseClicked

    private void Salary_Loan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salary_Loan2MouseClicked
         int Salary_loan2 = Salary_Loan2.getSelectedRow();
     ShowDataInSalary_Loan2(Salary_loan2);
    }//GEN-LAST:event_Salary_Loan2MouseClicked

    private void Home_Loan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home_Loan2MouseClicked
       int HomeLoan2 = Home_Loan2.getSelectedRow();
        
        ShowDataInHome_Loan2(HomeLoan2 );
    }//GEN-LAST:event_Home_Loan2MouseClicked

    private void Business_Loan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Business_Loan2MouseClicked
  int BusinessLoan= Business_Loan2.getSelectedRow();
        ShowDataInBusiness_Loan2(BusinessLoan);
    }//GEN-LAST:event_Business_Loan2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int DT_BusinessLoan = jTable1.getSelectedRow();
       ShowDataInDT_BusinessLoan(DT_BusinessLoan);
    }//GEN-LAST:event_jTable1MouseClicked

    private void Home_LoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home_LoanMouseClicked
         int DT_HomeLoan = Home_Loan.getSelectedRow();
       ShowDataInDT_HomeLoan(DT_HomeLoan);
    }//GEN-LAST:event_Home_LoanMouseClicked

    private void Salary_LoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salary_LoanMouseClicked
          int DT_SalaryLoan = Salary_Loan.getSelectedRow();
       ShowDataInDT_SalaryLoan(DT_SalaryLoan);
    }//GEN-LAST:event_Salary_LoanMouseClicked

    private void OFW_LoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OFW_LoanMouseClicked
         int DT_OFWLoan = OFW_Loan.getSelectedRow();
       ShowDataInDT_OFWLoan(DT_OFWLoan);
    }//GEN-LAST:event_OFW_LoanMouseClicked

    private void Personal_LoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Personal_LoanMouseClicked
       int DT_PersonalLoan = Personal_Loan.getSelectedRow();
       ShowDataInDT_PersonalLoan(DT_PersonalLoan);
    }//GEN-LAST:event_Personal_LoanMouseClicked

    private void jTextField79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField79ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField79ActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
       MainFrame f = new MainFrame();

        ResultSet rs = null;

        rs = f.businessloan(jTextField106.getText());
        try{
            if(rs.next()){
                jTextField107.setText(rs.getString("Client_No"));
                jTextField108.setText(rs.getString("Client_Name"));
                jTextField109.setText(rs.getString("Total_Amount_Paid"));
                jTextField110.setText(rs.getString("Loan_Amount"));
                jTextField111.setText(rs.getString("Interest_Rate"));
                jTextField112.setText(rs.getString("Currency"));
                jTextField113.setText(rs.getString("Total_Principal"));
                jTextField114.setText(rs.getString("Date_of_Client_Pay"));
                jTextField118.setText(rs.getString("Amount_of_Payment"));
                jTextField119.setText(rs.getString("Date_of_Payment"));
                jTextField121.setText(rs.getString("Remaining_Balance"));
                jTextField130.setText(rs.getString("Total_of_Principal"));
                jTextField100.setText(rs.getString("No_of_Months"));
            }  else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS CLIENT NO");
                    jTextField106.setText("");
                jTextField107.setText("");
                jTextField108.setText("");
                jTextField109.setText("");
                jTextField110.setText("");
                jTextField111.setText("");
                jTextField112.setText("");
                jTextField113.setText("");
                jTextField114.setText("");
                jTextField118.setText("");
                jTextField119.setText("");
                jTextField121.setText("");
                jTextField130.setText("");
                jTextField100.setText("");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
          MainFrame m = new MainFrame();

        ResultSet rs = null;

        rs = m.HomeLoan(jTextField131.getText());
        try{
            if(rs.next()){

                jTextField132.setText(rs.getString("Client_No"));
                jTextField133.setText(rs.getString("Client_Name"));
                jTextField134.setText(rs.getString("Total_Amount_Paid"));
                jTextField135.setText(rs.getString("Loan_Amount"));
                jTextField136.setText(rs.getString("Interest_Rate"));
                jTextField137.setText(rs.getString("Currency"));
                jTextField138.setText(rs.getString("Total_Principal"));
                jTextField139.setText(rs.getString("Date_of_Client_Pay"));
                jTextField140.setText(rs.getString("Amount_of_Payment"));
                jTextField141.setText(rs.getString("Date_of_Payment"));
                jTextField142.setText(rs.getString("Remaining_Balance"));
                jTextField143.setText(rs.getString("Total_of_Principal"));
                jTextField101.setText(rs.getString("No_of_Months"));
            }  else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS CLIENT NO");
                   jTextField131.setText("");
                jTextField132.setText("");
                jTextField133.setText("");
                jTextField134.setText("");
                jTextField135.setText("");
                jTextField136.setText("");
                jTextField137.setText("");
                jTextField138.setText("");
                jTextField139.setText("");
                jTextField140.setText("");
                jTextField141.setText("");
                jTextField142.setText("");
                jTextField143.setText("");
                jTextField101.setText("");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
          jTextField106.setText("");
        jTextField107.setText("");
                jTextField108.setText("");
                jTextField109.setText("");
                jTextField110.setText("");
                jTextField111.setText("");
                jTextField112.setText("");
                jTextField113.setText("");
                jTextField114.setText("");
                jTextField118.setText("");
                jTextField119.setText("");
                jTextField121.setText("");
                jTextField130.setText("");
                jTextField100.setText("");
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
                 jTextField131.setText("");
        jTextField132.setText("");
                jTextField133.setText("");
                jTextField134.setText("");
                jTextField135.setText("");
                jTextField136.setText("");
                jTextField137.setText("");
                jTextField138.setText("");
                jTextField139.setText("");
                jTextField140.setText("");
                jTextField141.setText("");
                jTextField142.setText("");
                jTextField143.setText("");
                jTextField101.setText("");
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
                 jTextField144.setText("");
                 jTextField145.setText("");
                jTextField146.setText("");
                jTextField147.setText("");
                jTextField148.setText("");
                jTextField149.setText("");
                jTextField161.setText("");
                jTextField162.setText("");
                jTextField163.setText("");
                jTextField164.setText("");
                jTextField165.setText("");
                jTextField166.setText("");
                jTextField167.setText("");
                jTextField102.setText("");
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
          MainFrame m = new MainFrame();

        ResultSet rs = null;

        rs = m.OFWLoan(jTextField144.getText());
        try{
            if(rs.next()){

                jTextField145.setText(rs.getString("Client_No"));
                jTextField146.setText(rs.getString("Client_Name"));
                jTextField147.setText(rs.getString("Total_Amount_Paid"));
                jTextField148.setText(rs.getString("Loan_Amount"));
                jTextField149.setText(rs.getString("Interest_Rate"));
                jTextField161.setText(rs.getString("Currency"));
                jTextField162.setText(rs.getString("Total_Principal"));
                jTextField163.setText(rs.getString("Date_of_Client_Pay"));
                jTextField164.setText(rs.getString("Amount_of_Payment"));
                jTextField165.setText(rs.getString("Date_of_Payment"));
                jTextField166.setText(rs.getString("Remaining_Balance"));
                jTextField167.setText(rs.getString("Total_of_Principal"));
                jTextField102.setText(rs.getString("No_of_Months"));
            }  else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS CLIENT NO");
                    jTextField144.setText("");
                jTextField145.setText("");
                jTextField146.setText("");
                jTextField147.setText("");
                jTextField148.setText("");
                jTextField149.setText("");
                jTextField161.setText("");
                jTextField162.setText("");
                jTextField163.setText("");
                jTextField164.setText("");
                jTextField165.setText("");
                jTextField166.setText("");
                jTextField167.setText("");
                jTextField102.setText("");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
              jTextField168.setText("");
                jTextField169.setText("");
                jTextField170.setText("");
                jTextField171.setText("");
                jTextField172.setText("");
                jTextField173.setText("");
                jTextField174.setText("");
                jTextField175.setText("");
                jTextField176.setText("");
                jTextField177.setText("");
                jTextField178.setText("");
                jTextField179.setText("");
                jTextField180.setText("");
                jTextField103.setText("");
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
            MainFrame m = new MainFrame();

        ResultSet rs = null;

        rs = m.PersonalLoan(jTextField168.getText());
        try{
            if(rs.next()){

                jTextField169.setText(rs.getString("Client_No"));
                jTextField170.setText(rs.getString("Client_Name"));
                jTextField171.setText(rs.getString("Total_Amount_Paid"));
                jTextField172.setText(rs.getString("Loan_Amount"));
                jTextField173.setText(rs.getString("Interest_Rate"));
                jTextField174.setText(rs.getString("Currency"));
                jTextField175.setText(rs.getString("Total_Principal"));
                jTextField176.setText(rs.getString("Date_of_Client_Pay"));
                jTextField177.setText(rs.getString("Amount_of_Payment"));
                jTextField178.setText(rs.getString("Date_of_Payment"));
                jTextField179.setText(rs.getString("Remaining_Balance"));
                jTextField180.setText(rs.getString("Total_of_Principal"));
                jTextField103.setText(rs.getString("No_of_Months"));
            }  else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS CLIENT NO");
                    jTextField168.setText("");
                jTextField169.setText("");
                jTextField170.setText("");
                jTextField171.setText("");
                jTextField172.setText("");
                jTextField173.setText("");
                jTextField174.setText("");
                jTextField175.setText("");
                jTextField176.setText("");
                jTextField177.setText("");
                jTextField178.setText("");
                jTextField179.setText("");
                jTextField180.setText("");
                jTextField103.setText("");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
              jTextField181.setText("");
                jTextField182.setText("");
                jTextField183.setText("");
                jTextField184.setText("");
                jTextField185.setText("");
                jTextField186.setText("");
                jTextField187.setText("");
                jTextField188.setText("");
                jTextField189.setText("");
                jTextField190.setText("");
                jTextField191.setText("");
                jTextField192.setText("");
                jTextField193.setText("");
                jTextField104.setText("");
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
             MainFrame m = new MainFrame();

        ResultSet rs = null;

        rs = m.SalaryLoan(jTextField181.getText());
        try{
            if(rs.next()){

                jTextField182.setText(rs.getString("Client_No"));
                jTextField183.setText(rs.getString("Client_Name"));
                jTextField184.setText(rs.getString("Total_Amount_Paid"));
                jTextField185.setText(rs.getString("Loan_Amount"));
                jTextField186.setText(rs.getString("Interest_Rate"));
                jTextField187.setText(rs.getString("Currency"));
                jTextField188.setText(rs.getString("Total_Principal"));
                jTextField189.setText(rs.getString("Date_of_Client_Pay"));
                jTextField190.setText(rs.getString("Amount_of_Payment"));
                jTextField191.setText(rs.getString("Date_of_Payment"));
                jTextField192.setText(rs.getString("Remaining_Balance"));
                jTextField193.setText(rs.getString("Total_of_Principal"));
                jTextField104.setText(rs.getString("No_of_Months"));
            }  else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS CLIENT NO");
                    jTextField181.setText("");
                jTextField182.setText("");
                jTextField183.setText("");
                jTextField184.setText("");
                jTextField185.setText("");
                jTextField186.setText("");
                jTextField187.setText("");
                jTextField188.setText("");
                jTextField189.setText("");
                jTextField190.setText("");
                jTextField191.setText("");
                jTextField192.setText("");
                jTextField193.setText("");
                jTextField104.setText("");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jLabel32MouseClicked

    private void Maintenance_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Maintenance_btnMouseClicked
       JOptionPane.showMessageDialog(null,"This software is up to date");
    }//GEN-LAST:event_Maintenance_btnMouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        jLabel20.setOpaque(true);
        jLabel20.setBackground(new java.awt.Color(2, 107, 184));
        jLabel20.repaint();
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
            jLabel20.setOpaque(true);
        jLabel20.setBackground(new java.awt.Color(51, 173, 255));
        jLabel20.repaint();
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
      jLabel21.setOpaque(true);
        jLabel21.setBackground(new java.awt.Color(2, 107, 184));
        jLabel21.repaint();
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
          jLabel21.setOpaque(true);
        jLabel21.setBackground(new java.awt.Color(51, 173, 255));
        jLabel21.repaint();
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
       jLabel28.setOpaque(true);
        jLabel28.setBackground(new java.awt.Color(2, 107, 184));
        jLabel28.repaint();
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        jLabel28.setOpaque(true);
        jLabel28.setBackground(new java.awt.Color(51, 173, 255));
        jLabel28.repaint();
    }//GEN-LAST:event_jLabel28MouseExited

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
      jLabel30.setOpaque(true);
        jLabel30.setBackground(new java.awt.Color(2, 107, 184));
        jLabel30.repaint();
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
      jLabel30.setOpaque(true);
        jLabel30.setBackground(new java.awt.Color(51, 173, 255));
        jLabel30.repaint();
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseEntered
       jLabel32.setOpaque(true);
        jLabel32.setBackground(new java.awt.Color(2, 107, 184));
        jLabel32.repaint();
    }//GEN-LAST:event_jLabel32MouseEntered

    private void jLabel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseExited
        jLabel32.setOpaque(true);
        jLabel32.setBackground(new java.awt.Color(51, 173, 255));
        jLabel32.repaint();
    }//GEN-LAST:event_jLabel32MouseExited

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
     jLabel23.setOpaque(true);
        jLabel23.setBackground(new java.awt.Color(2, 107, 184));
        jLabel23.repaint();
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
       jLabel23.setOpaque(true);
        jLabel23.setBackground(new java.awt.Color(51, 173, 255));
        jLabel23.repaint();
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
     jLabel25.setOpaque(true);
        jLabel25.setBackground(new java.awt.Color(2, 107, 184));
        jLabel25.repaint();
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
           jLabel25.setOpaque(true);
        jLabel25.setBackground(new java.awt.Color(51, 173, 255));
        jLabel25.repaint();
    }//GEN-LAST:event_jLabel25MouseExited

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
      jLabel27.setOpaque(true);
        jLabel27.setBackground(new java.awt.Color(2, 107, 184));
        jLabel27.repaint();
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        jLabel27.setOpaque(true);
        jLabel27.setBackground(new java.awt.Color(51, 173, 255));
        jLabel27.repaint();
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
      jLabel29.setOpaque(true);
        jLabel29.setBackground(new java.awt.Color(2, 107, 184));
        jLabel29.repaint();
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
       jLabel29.setOpaque(true);
        jLabel29.setBackground(new java.awt.Color(51, 173, 255));
        jLabel29.repaint();
    }//GEN-LAST:event_jLabel29MouseExited

    private void jLabel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseEntered
      jLabel31.setOpaque(true);
        jLabel31.setBackground(new java.awt.Color(2, 107, 184));
        jLabel31.repaint();
    }//GEN-LAST:event_jLabel31MouseEntered

    private void jLabel31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseExited
       jLabel31.setOpaque(true);
        jLabel31.setBackground(new java.awt.Color(51, 173, 255));
        jLabel31.repaint();
    }//GEN-LAST:event_jLabel31MouseExited

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        if(jTextArea2.getText().equals("")){
        JOptionPane.showMessageDialog(null, "No Message to Sent\n\n","Error",JOptionPane.ERROR_MESSAGE);
          Message n = new Message();
        n.setVisible(false);
    }
    else if(!jTextArea2.equals(""))
    {
        Message n = new Message();
        n.setVisible(true);
        n.setLocationRelativeTo((null));//para gumitna
    }
                                       
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        jLabel35.setOpaque(true);
        jLabel35.setBackground(new java.awt.Color(2, 107, 184));
        jLabel35.repaint();

    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
      
   jLabel35.setOpaque(true);
        jLabel35.setBackground(new java.awt.Color(51, 173, 255));
        jLabel35.repaint();
    }//GEN-LAST:event_jLabel35MouseExited

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
   jTextField88.setText("");
     jTextField87.setText("");
       jTextField86.setText("");
        jComboBox1.setSelectedItem((null));
         jComboBox1.setEnabled(false);
        jTextArea2.setText("");
           jTextArea2.setEnabled(false);
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel50MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseEntered
           jLabel50.setOpaque(true);
        jLabel50.setBackground(new java.awt.Color(2, 107, 184));
        jLabel50.repaint();
    }//GEN-LAST:event_jLabel50MouseEntered

    private void jLabel50MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseExited
           
   jLabel50.setOpaque(true);
        jLabel50.setBackground(new java.awt.Color(51, 173, 255));
        jLabel50.repaint();
    }//GEN-LAST:event_jLabel50MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

 PrinterJob pj = PrinterJob.getPrinterJob();
    pj.setPrintable(new BillPrintable(),getPageFormat(pj));
    try {
        pj.print();
           jTextField6.setText("");
           jTextField13.setText("");
            pp1.setText("");
           pp2.setText("");
          pp3.setText("");
          pp4.setText("");
           pp6.setText("");
              jDateChooser1.setDate((null));
        jTextField6.setEnabled(false);
           jTextField13.setEnabled(false);
            pp1.setEnabled(false);
           pp2.setEnabled(false);
          pp3.setEnabled(false);
          pp4.setEnabled(false);
           pp6.setEnabled(false);
            jButton3.setEnabled(false);
               jDateChooser1.setEnabled(false);
    }
    catch (PrinterException ex) {
        JOptionPane.showMessageDialog(null,"No data to print");
           jTextField6.setText("");
           jTextField13.setText("");
            pp1.setText("");
           pp2.setText("");
          pp3.setText("");
          pp4.setText("");
           pp6.setText("");
            jDateChooser1.setDate((null));
            jTextField6.setEnabled(false);
           jTextField13.setEnabled(false);
            pp1.setEnabled(false);
           pp2.setEnabled(false);
          pp3.setEnabled(false);
          pp4.setEnabled(false);
           pp6.setEnabled(false);
            jButton3.setEnabled(false);
             jDateChooser1.setEnabled(false);
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
         jButton3.setOpaque(true);
        jButton3.setBackground(new java.awt.Color(2, 107, 184));
        jButton3.repaint();
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
      jButton3.setOpaque(true);
       jButton3.setBackground(new java.awt.Color(51, 173, 255));
       jButton3.repaint();
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
    jButton4.setOpaque(true);
        jButton4.setBackground(new java.awt.Color(2, 107, 184));
        jButton4.repaint();
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
         jButton4.setOpaque(true);
       jButton4.setBackground(new java.awt.Color(51, 173, 255));
       jButton4.repaint();
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTextField6.setEnabled(true);
           jTextField13.setEnabled(true);
            pp1.setEnabled(true);
           pp2.setEnabled(true);
          pp3.setEnabled(true);
          pp4.setEnabled(true);
           pp6.setEnabled(true);
            jButton3.setEnabled(true);
          jDateChooser1.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void pp1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pp1KeyTyped
            char cchar = evt.getKeyChar();
        if (!Character.isDigit(cchar) || (cchar == KeyEvent.VK_BACKSPACE) || (cchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (pp1.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_pp1KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
             char cchar = evt.getKeyChar();
        if (!Character.isDigit(cchar) || (cchar == KeyEvent.VK_BACKSPACE) || (cchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (jTextField6.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void pp2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pp2KeyTyped
             char cchar = evt.getKeyChar();
        if (!Character.isDigit(cchar) || (cchar == KeyEvent.VK_BACKSPACE) || (cchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (pp2.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_pp2KeyTyped

    private void pp3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pp3KeyTyped
            char cchar = evt.getKeyChar();
        if (!Character.isDigit(cchar) || (cchar == KeyEvent.VK_BACKSPACE) || (cchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (pp3.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_pp3KeyTyped

    private void pp4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pp4KeyTyped
                 char cchar = evt.getKeyChar();
        if (!Character.isDigit(cchar) || (cchar == KeyEvent.VK_BACKSPACE) || (cchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (pp4.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_pp4KeyTyped

    private void pp6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pp6KeyTyped
                 char cchar = evt.getKeyChar();
        if (!Character.isDigit(cchar) || (cchar == KeyEvent.VK_BACKSPACE) || (cchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (pp6.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_pp6KeyTyped

    private void NotificationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationTableMouseClicked
      int NOTIF = NotificationTable.getSelectedRow();
        ShowDataInNotification(NOTIF);
        jTextArea2.setEnabled(true);
        jComboBox1.setEnabled(true);
    }//GEN-LAST:event_NotificationTableMouseClicked

    private void Client_StatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Client_StatusMouseClicked
     int CS = Client_Status.getSelectedRow();
     ShowDataInClient_Status(CS);
    }//GEN-LAST:event_Client_StatusMouseClicked

    private void Client_MonitoringMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Client_MonitoringMouseClicked
       int CM = Client_Monitoring.getSelectedRow();
       ShowDataInClient_Monitoring(CM);
    }//GEN-LAST:event_Client_MonitoringMouseClicked

    private void jTextField151ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField151ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField151ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address3;
    private javax.swing.JButton Attach_Photo1;
    private javax.swing.JPanel Business;
    private javax.swing.JPanel Business2;
    private javax.swing.JTable Business_Loan2;
    private javax.swing.JLabel CID2;
    private javax.swing.JLabel CIDFK1;
    private javax.swing.JPanel CT_BusinessLoan;
    private javax.swing.JPanel CT_HomeLoan;
    private javax.swing.JPanel CT_OFWLoan;
    private javax.swing.JPanel CT_PersonalLoan;
    private javax.swing.JPanel CT_SalaryLoan;
    private javax.swing.JTable ClientInformationTable;
    private javax.swing.JTable Client_Monitoring;
    private javax.swing.JPanel Client_Report;
    private javax.swing.JTable Client_Status;
    private javax.swing.JLabel Date;
    private javax.swing.JPanel Deposit_Transaction;
    private javax.swing.JButton Edit_Button2;
    private javax.swing.JLabel Email1;
    private javax.swing.JLabel Email10;
    private javax.swing.JLabel Email11;
    private javax.swing.JLabel Email12;
    private javax.swing.JLabel Email13;
    private javax.swing.JLabel Email2;
    private javax.swing.JLabel Email3;
    private javax.swing.JLabel Email4;
    private javax.swing.JLabel Email5;
    private javax.swing.JLabel Email6;
    private javax.swing.JLabel Email7;
    private javax.swing.JLabel Email8;
    private javax.swing.JLabel Email9;
    private javax.swing.JLabel Firstname2;
    private javax.swing.JLabel Gender2;
    private javax.swing.JTable Home_Loan;
    private javax.swing.JTable Home_Loan2;
    private javax.swing.JPanel Homeloan;
    private javax.swing.JPanel Homeloan2;
    private javax.swing.JLabel Lastname2;
    private javax.swing.JLabel Maintenance_btn;
    private javax.swing.JComboBox<String> Marks;
    private javax.swing.JPanel MenuBar;
    private javax.swing.JLabel Message1;
    private javax.swing.JLabel Middlename2;
    private javax.swing.JLabel Mobile3;
    private javax.swing.JLabel Mobile4;
    private javax.swing.JLabel Mobile6;
    private javax.swing.JButton New1;
    private javax.swing.JTable NotificationTable;
    private javax.swing.JTable OFW_Loan;
    private javax.swing.JTable OFW_Loan2;
    private javax.swing.JPanel OFWloan;
    private javax.swing.JPanel OFWloan2;
    private javax.swing.JLabel Occupation16;
    private javax.swing.JLabel Occupation17;
    private javax.swing.JLabel Occupation8;
    private javax.swing.JComboBox<String> Payment_Regulation;
    private javax.swing.JTable Personal_Loan;
    private javax.swing.JTable Personal_Loan2;
    private javax.swing.JTable Salary_Loan;
    private javax.swing.JTable Salary_Loan2;
    private javax.swing.JButton Save_Button2;
    private javax.swing.JLabel Settings_btn;
    private javax.swing.JPanel SidePane;
    private javax.swing.JLabel Status4;
    private javax.swing.JLabel Status5;
    private javax.swing.JLabel Status7;
    private javax.swing.JComboBox<String> Term;
    private javax.swing.JLabel Time;
    private javax.swing.JButton Update_Button2;
    private javax.swing.JComboBox<String> Use;
    private javax.swing.JPanel Withdrawal_Transaction;
    private javax.swing.JPanel client_Transaction;
    private javax.swing.JPanel clientsinfo;
    private javax.swing.JPanel cmonitoring;
    private javax.swing.JPanel cmpanel;
    private javax.swing.JPanel consolidation;
    private javax.swing.JPanel cstatus;
    private javax.swing.JButton del_Button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField100;
    private javax.swing.JTextField jTextField101;
    private javax.swing.JTextField jTextField102;
    private javax.swing.JTextField jTextField103;
    private javax.swing.JTextField jTextField104;
    private javax.swing.JTextField jTextField106;
    private javax.swing.JTextField jTextField107;
    private javax.swing.JTextField jTextField108;
    private javax.swing.JTextField jTextField109;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField110;
    private javax.swing.JTextField jTextField111;
    private javax.swing.JTextField jTextField112;
    private javax.swing.JTextField jTextField113;
    private javax.swing.JTextField jTextField114;
    private javax.swing.JTextField jTextField115;
    private javax.swing.JTextField jTextField116;
    private javax.swing.JTextField jTextField117;
    private javax.swing.JTextField jTextField118;
    private javax.swing.JTextField jTextField119;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField120;
    private javax.swing.JTextField jTextField121;
    private javax.swing.JTextField jTextField122;
    private javax.swing.JTextField jTextField123;
    private javax.swing.JTextField jTextField124;
    private javax.swing.JTextField jTextField125;
    private javax.swing.JTextField jTextField126;
    private javax.swing.JTextField jTextField127;
    private javax.swing.JTextField jTextField128;
    private javax.swing.JTextField jTextField129;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField130;
    private javax.swing.JTextField jTextField131;
    private javax.swing.JTextField jTextField132;
    private javax.swing.JTextField jTextField133;
    private javax.swing.JTextField jTextField134;
    private javax.swing.JTextField jTextField135;
    private javax.swing.JTextField jTextField136;
    private javax.swing.JTextField jTextField137;
    private javax.swing.JTextField jTextField138;
    private javax.swing.JTextField jTextField139;
    private javax.swing.JTextField jTextField140;
    private javax.swing.JTextField jTextField141;
    private javax.swing.JTextField jTextField142;
    private javax.swing.JTextField jTextField143;
    private javax.swing.JTextField jTextField144;
    private javax.swing.JTextField jTextField145;
    private javax.swing.JTextField jTextField146;
    private javax.swing.JTextField jTextField147;
    private javax.swing.JTextField jTextField148;
    private javax.swing.JTextField jTextField149;
    private javax.swing.JTextField jTextField150;
    private javax.swing.JTextField jTextField151;
    private javax.swing.JTextField jTextField152;
    private javax.swing.JTextField jTextField153;
    private javax.swing.JTextField jTextField154;
    private javax.swing.JTextField jTextField155;
    private javax.swing.JTextField jTextField156;
    private javax.swing.JTextField jTextField157;
    private javax.swing.JTextField jTextField158;
    private javax.swing.JTextField jTextField159;
    private javax.swing.JTextField jTextField160;
    private javax.swing.JTextField jTextField161;
    private javax.swing.JTextField jTextField162;
    private javax.swing.JTextField jTextField163;
    private javax.swing.JTextField jTextField164;
    private javax.swing.JTextField jTextField165;
    private javax.swing.JTextField jTextField166;
    private javax.swing.JTextField jTextField167;
    private javax.swing.JTextField jTextField168;
    private javax.swing.JTextField jTextField169;
    private javax.swing.JTextField jTextField170;
    private javax.swing.JTextField jTextField171;
    private javax.swing.JTextField jTextField172;
    private javax.swing.JTextField jTextField173;
    private javax.swing.JTextField jTextField174;
    private javax.swing.JTextField jTextField175;
    private javax.swing.JTextField jTextField176;
    private javax.swing.JTextField jTextField177;
    private javax.swing.JTextField jTextField178;
    private javax.swing.JTextField jTextField179;
    private javax.swing.JTextField jTextField180;
    private javax.swing.JTextField jTextField181;
    private javax.swing.JTextField jTextField182;
    private javax.swing.JTextField jTextField183;
    private javax.swing.JTextField jTextField184;
    private javax.swing.JTextField jTextField185;
    private javax.swing.JTextField jTextField186;
    private javax.swing.JTextField jTextField187;
    private javax.swing.JTextField jTextField188;
    private javax.swing.JTextField jTextField189;
    private javax.swing.JTextField jTextField190;
    private javax.swing.JTextField jTextField191;
    private javax.swing.JTextField jTextField192;
    private javax.swing.JTextField jTextField193;
    private javax.swing.JTextField jTextField194;
    private javax.swing.JTextField jTextField195;
    private javax.swing.JTextField jTextField196;
    private javax.swing.JTextField jTextField197;
    private javax.swing.JTextField jTextField198;
    private javax.swing.JTextField jTextField199;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField200;
    private javax.swing.JTextField jTextField201;
    private javax.swing.JTextField jTextField202;
    private javax.swing.JTextField jTextField203;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField80;
    private javax.swing.JTextField jTextField81;
    private javax.swing.JTextField jTextField82;
    private javax.swing.JTextField jTextField83;
    private javax.swing.JTextField jTextField84;
    private javax.swing.JTextField jTextField85;
    private javax.swing.JTextField jTextField86;
    private javax.swing.JTextField jTextField87;
    private javax.swing.JTextField jTextField88;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbl_DisplayImage;
    private javax.swing.JPanel notif;
    private javax.swing.JPanel panelloan;
    private javax.swing.JPanel panelloan2;
    private javax.swing.JPanel personalloan;
    private javax.swing.JPanel personalloan2;
    private javax.swing.JTextField pp1;
    private javax.swing.JTextField pp2;
    private javax.swing.JTextField pp3;
    private javax.swing.JTextField pp4;
    private javax.swing.JTextField pp6;
    private javax.swing.JPanel salary;
    private javax.swing.JPanel salary2;
    private javax.swing.JPanel saving;
    private javax.swing.JPanel socialmonitoring;
    private javax.swing.JLabel winClose_btn;
    private javax.swing.JLabel winClose_btn1;
    private javax.swing.JLabel winMinimize_btn;
    private javax.swing.JLabel winMinimize_btn1;
    private javax.swing.JLabel winRes_Max_btn;
    // End of variables declaration//GEN-END:variables
}
