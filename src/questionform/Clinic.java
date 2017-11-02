package questionform;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import static java.text.MessageFormat.format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jdesktop.swingx.JXDatePicker;

public class Clinic extends JFrame implements ActionListener,MouseListener,WindowListener{
    
    JPanel    descriptionPanel=new JPanel();
    JLabel    logout,home,MCQ,answer,aboutus,settings;  //left menue Items 
    JPanel    welcome,left,mcqPanel,TrueFalsePanel,settingsPanel,aboutusPanel;  //Panels For Left Menue and Welcome Message
    JLabel    header;                                   //head of my project
    JLabel    skiplabel;                                //this lable to contain imageicon
    JLabel    imageBackground;                          // Background lable 
    ImageIcon skipImageIcon;                            // Background imageIcon
    ImageIcon skipImageIcon1;
    ImageIcon backgroundImageIcon;
    JButton   skipButton;
    JLabel    descriptionText=new JLabel("<html> &nbsp &nbsp This Applicatin Help Doctors In Clinics To "
            + " Enter <br>Patient Data This "
            + "Application To Help Doctors To Put <br>"
            
            + " &nbsp &nbsp &nbsp &nbsp Data for each patient who follow with him <br>"
            + " And this application specially for Dr : Safaa Ragab <br>"
            + " &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  Final Project  </html>");
    
    int              count;
    JTextField       LoginName;
    JPasswordField   Password;
    JButton          Login;
    JComboBox RHList;
    JXDatePicker picker1,picker2,picker3;
    JScrollPane scroll;
    /**************************** MCQ Panel Component **************************************************/
        JLabel CBCHeader,mcqHeader,enterQuestion,A,B,C,D,E,F,G,H;
        JTextArea questionArea;
        JTextField chooiseA,chooiseB,chooiseC,chooiseD,chooiseE;
        JButton submit,clear,submit2,clear2;
       // JRadioButton radioA,radioB,radioC,radioD;
       // ButtonGroup BG;
    /**************************** True/False Panel Component ********************************************/
        JRadioButton True,False;
        ButtonGroup BG1;
        JLabel TrueAnswer,FalseAnswer;
        
    /**************************** Settings panel component **********************************************/
        JTextField truequestionNumber,chooisequestionNumber,examPeriodtf,questionDegreetf;
        JLabel examPeriod,questionDegree;
    /***************************** About Us component ***************************************************/
        JLabel txt1,txt2,txt3,txt4,txt5,txt6;
        JLabel mahmoud,ibrahim,elanany,amr,aboali,ahmed;
        ImageIcon mahmoud1,ibrahim1,elanany1,amr1,aboali1,ahmed1;
        JPanel pickerPanel1,pickerPanel2,pickerPanel3;
    /*************************** DB Connection *********************************************************/
    Connection con;
    Statement st;
    ResultSet rs;
    /*************************** CBC Data **************************************************************/
    JLabel fileNum,BP,WT,HB,TLC,PLT,RBS,Date;
    JTextField fileNumField,BPField,WTField,HBField,TLCField,PLTField,RBSField,DateField;
    ImageIcon logoimg;
    JLabel logoLabel;
    /**************************** Show Data ************************************************************/
    JLabel fileShow,nameShow,ageShow,phoneShow,husbandShow,lmpShow,eddShow,rhShow , showHeader;
    JTextField fileShowField,nameShowField,ageShowField,phoneShowField,husbandShowField;
    JButton show,update,EnableShow,showCBC;
    JXDatePicker showPickerEdd,showPickerLMP;
    JPanel showPickerEddPanel,showPickerlmpPanel;
    JComboBox showRHList;
    JTextArea notesArea;
    JScrollPane showNoteScroll;
    // constractor 
    public Clinic(){
            /*********************** DB Connection *************************/

        
          
          
        // java.net.URL url = ClassLoader.getSystemResource("/image/logo.jpg");
       ImageIcon img = new ImageIcon("image\\logo.jpg");
       this.setIconImage(img.getImage());
        /***************************************************************/
        Login=new JButton("Login");
        skipImageIcon=new ImageIcon("image\\nn.png");
        skiplabel=new JLabel(skipImageIcon);
        backgroundImageIcon=new ImageIcon("image\\m.jpg");
        skipButton=new JButton(skipImageIcon);
        imageBackground=new JLabel(backgroundImageIcon);
        header=new JLabel("         Clinic Application");
        
        header.setFont(new Font("Serif", Font.BOLD, 48));
        descriptionText.setFont(new Font("Serif", Font.BOLD, 20));
        
        header.setForeground(Color.WHITE);
        descriptionText.setForeground(Color.WHITE);        
        skiplabel.setBounds(620, 460, 80, 80);
        descriptionPanel.setBounds(430, 130, 510, 300);
        
        imageBackground.setBounds(0, 0, 1366, 700);
        descriptionText.setBounds(30 , 0, 500, 200);
        header.setBounds(410 , 40, 800, 60);

        add(skiplabel);
        add(header);
        descriptionPanel.add(descriptionText);
        descriptionPanel.setBackground(new Color(0,0,0,150));
        add(descriptionPanel);
        add(imageBackground);
        
/*********************************************************************************/
        skipButton.addActionListener(this);
        skiplabel.addMouseListener(this);
        
/*********************************************************************************/
        descriptionPanel.setLayout(null);
              
        skipButton.setOpaque(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(2000, 730);
        setVisible(true);
        setResizable(true);
        
        
        
         TrueFalsePanel =new JPanel();
        
        TrueFalsePanel.setLayout(null);
        TrueFalsePanel.setBackground(new Color(0,0,0,150));
        TrueFalsePanel.setBounds(380, 110, 600, 550);
        
        settingsPanel =new JPanel();
        settingsPanel.setLayout(null);
        settingsPanel.setBackground(new Color(0,0,0,150));
        settingsPanel.setBounds(380, 110, 600, 550);
        
        aboutusPanel =new JPanel();
        aboutusPanel.setLayout(null);
        aboutusPanel.setBackground(new Color(0,0,0,150));
        aboutusPanel.setBounds(430, 110, 500, 550);
        
        String itemsList[]= {"          + Positive","          - Negative"};
        RHList=new JComboBox(itemsList);
        RHList.setSelectedIndex(0);
       
        
        
        mcqPanel=new JPanel();
        mcqPanel.setLayout(null);
        mcqPanel.setBackground(new Color(0,0,0,150));
        mcqPanel.setBounds(380, 110, 600, 550);
       
        /**************** patient Data *******************/
        
        questionArea =new JTextArea();
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setAutoscrolls(true);
        scroll = new JScrollPane (questionArea, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      
        chooiseA=new JTextField();
        chooiseA.setBorder(null);
        chooiseB=new JTextField();
        chooiseB.setBorder(null);
        chooiseC=new JTextField();
        chooiseC.setBorder(null);
        chooiseD=new JTextField();
        chooiseD.setBorder(null);
        chooiseE=new JTextField();
        chooiseE.setBorder(null);
                
        submit=new JButton("Submit");
        submit.setBorderPainted(false);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        clear=new JButton("clear");
        clear.setBorderPainted(false);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLUE);
     
        /**********************************/
        
        /************** CBC Data ********************/
        logoimg=new ImageIcon("image\\logo3.jpg");
        logoLabel=new JLabel(logoimg);
        logoLabel.setBounds(200, 320, 200, 150);
        pickerPanel3=new JPanel();
        
        fileNum=new JLabel("File");
        fileNum.setFont(new Font("Serif", Font.BOLD, 15));
        BP=new JLabel("B.P");
        BP.setFont(new Font("Serif", Font.BOLD, 15));
        WT=new JLabel("W.T");
        WT.setFont(new Font("Serif", Font.BOLD, 15));
        HB=new JLabel("H.B");
        HB.setFont(new Font("Serif", Font.BOLD, 15));
        TLC=new JLabel("TLC");
        TLC.setFont(new Font("Serif", Font.BOLD, 15));
        PLT=new JLabel("PLT");
        PLT.setFont(new Font("Serif", Font.BOLD, 15));
        RBS=new JLabel("RBS");
        RBS.setFont(new Font("Serif", Font.BOLD, 15));
        Date=new JLabel("Date");
        Date.setFont(new Font("Serif", Font.BOLD, 15));
        fileNum.setBounds(15, 120, 60, 20);
        BP.setBounds(295, 120, 60, 20);
        WT.setBounds(15, 170, 60, 20);
        HB.setBounds(295, 170, 60, 20);
        TLC.setBounds(15, 220, 60, 20);
        PLT.setBounds(295, 220, 60, 20);
        RBS.setBounds(15, 270, 60, 20);
        Date.setBounds(295, 270, 60, 20);
        fileNum.setForeground(Color.WHITE);
        BP.setForeground(Color.WHITE);
        WT.setForeground(Color.WHITE);
        HB.setForeground(Color.WHITE);
        TLC.setForeground(Color.WHITE);
        PLT.setForeground(Color.WHITE);
        RBS.setForeground(Color.WHITE);
        Date.setForeground(Color.WHITE);
        
        fileNumField=new JTextField();
        fileNumField.setBorder(null);
        BPField=new JTextField();
        BPField.setBorder(null);
        WTField=new JTextField();
        WTField.setBorder(null);
        HBField=new JTextField();
        HBField.setBorder(null);
        TLCField=new JTextField();
        TLCField.setBorder(null);
        PLTField=new JTextField();
        PLTField.setBorder(null);
        RBSField=new JTextField();
        RBSField.setBorder(null);
        DateField=new JTextField();
        DateField.setBorder(null);
        
        fileNumField.setBounds(90, 120, 190, 30);
        fileNumField.setFont(new Font("Serif", Font.BOLD, 15));
        BPField.setBounds(350, 120, 190, 30);
        BPField.setFont(new Font("Serif", Font.BOLD, 15));
        WTField.setBounds(90, 170, 190, 30);
        WTField.setFont(new Font("Serif", Font.BOLD, 15));
        HBField.setBounds(350, 170, 190, 30);
        HBField.setFont(new Font("Serif", Font.BOLD, 15));
        TLCField.setBounds(90, 220, 190, 30);
        TLCField.setFont(new Font("Serif", Font.BOLD, 15));
        PLTField.setBounds(90, 270, 190, 30);
        PLTField.setFont(new Font("Serif", Font.BOLD, 20));
        RBSField.setBounds(350, 220, 190, 30);
        RBSField.setFont(new Font("Serif", Font.BOLD, 20));
        pickerPanel3.setBounds(350, 270, 190, 30);
        pickerPanel3.setLayout(null);
        picker3 = new JXDatePicker();
        picker3.setDate(Calendar.getInstance().getTime());
        picker3.setFormats(new SimpleDateFormat("dd / MM / yyyy"));
        picker3.setBounds(0, 0, 190, 30);
        pickerPanel3.add(picker3);
        
        submit2=new JButton("Submit");
        submit2.setBorderPainted(false);
        submit2.setForeground(Color.WHITE);
        submit2.setBackground(Color.BLUE);
        clear2=new JButton("clear");
        clear2.setBorderPainted(false);
        clear2.setForeground(Color.WHITE);
        clear2.setBackground(Color.BLUE);
        
        /**********************************/
        /*************** Show Patient Data *******************/
        String itemsListShow[]= {"          + Positive","          - Negative"};
        showRHList=new JComboBox(itemsListShow);
        showRHList.setSelectedIndex(0); 
        
        notesArea =new JTextArea();
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);
        notesArea.setAutoscrolls(true);
        showNoteScroll = new JScrollPane (notesArea, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        showNoteScroll.setBounds(80, 380, 460, 100);
        
        fileShow=new JLabel("File");
        fileShow.setFont(new Font("Serif", Font.BOLD, 15));
        nameShow=new JLabel("Name");
        nameShow.setFont(new Font("Serif", Font.BOLD, 15));
        ageShow=new JLabel("Age");
        ageShow.setFont(new Font("Serif", Font.BOLD, 15));
        phoneShow=new JLabel("Phone");
        phoneShow.setFont(new Font("Serif", Font.BOLD, 15));
        husbandShow=new JLabel("Husband");
        husbandShow.setFont(new Font("Serif", Font.BOLD, 15));
        lmpShow=new JLabel("LMP");
        lmpShow.setFont(new Font("Serif", Font.BOLD, 15));
        eddShow=new JLabel("EDD");
        eddShow.setFont(new Font("Serif", Font.BOLD, 15));
        rhShow=new JLabel("RH");
        rhShow.setFont(new Font("Serif", Font.BOLD, 15));
        
        fileShow.setBounds(15, 120, 60, 20);
        nameShow.setBounds(15, 180, 60, 20);
        ageShow.setBounds(295, 180, 60, 20);
        husbandShow.setBounds(15, 230, 60, 20);
        phoneShow.setBounds(295, 230, 60, 20);
        lmpShow.setBounds(15, 280, 60, 20);
        rhShow.setBounds(295, 280, 60, 20);
        eddShow.setBounds(15, 330, 60, 20);
        
        
        fileShow.setForeground(Color.WHITE);
        nameShow.setForeground(Color.WHITE);
        ageShow.setForeground(Color.WHITE);
        husbandShow.setForeground(Color.WHITE);
        phoneShow.setForeground(Color.WHITE);
        lmpShow.setForeground(Color.WHITE);
        eddShow.setForeground(Color.WHITE);
        rhShow.setForeground(Color.WHITE);
        
          showPickerEddPanel=new JPanel();
          showPickerlmpPanel=new JPanel();
          showPickerEddPanel.setLayout(null);
          showPickerlmpPanel.setLayout(null);
          
                 
        showPickerEdd = new JXDatePicker();
        showPickerEdd.setDate(Calendar.getInstance().getTime());
        showPickerEdd.setFormats(new SimpleDateFormat("dd / MM / yyyy"));
        showPickerEdd.setBounds(0, 0, 190, 30);
        
        showPickerLMP = new JXDatePicker();
        showPickerLMP.setDate(Calendar.getInstance().getTime());
        showPickerLMP.setFormats(new SimpleDateFormat("dd / MM / yyyy"));
        showPickerLMP.setBounds(0, 0, 190, 30);
        showPickerEddPanel.add(showPickerEdd);
        showPickerlmpPanel.add(showPickerLMP);
        
        fileShowField=new JTextField();
        fileShowField.setBorder(null);
        nameShowField=new JTextField();
        nameShowField.setBorder(null);
        ageShowField=new JTextField();
        ageShowField.setBorder(null);
        phoneShowField=new JTextField();
        phoneShowField.setBorder(null);
        husbandShowField=new JTextField();
        husbandShowField.setBorder(null);
       
                
        fileShowField.setBounds(90, 120, 190, 30);
        nameShowField.setBounds(90, 180, 190, 30);
        ageShowField.setBounds(350, 180, 190, 30);
        husbandShowField.setBounds(90, 230, 190, 30);
        phoneShowField.setBounds(350, 230, 190, 30);
        showPickerEddPanel.setBounds(90, 280, 190, 30);
        showRHList.setBounds(350, 280, 190, 30);
        showPickerlmpPanel.setBounds(90, 330, 190, 30);
        
        showRHList.setFont(new Font("Serif", Font.BOLD, 20));
        fileShowField.setFont(new Font("Serif", Font.BOLD, 15));
        nameShowField.setFont(new Font("Serif", Font.BOLD, 15));
        ageShowField.setFont(new Font("Serif", Font.BOLD, 15));
        phoneShowField.setFont(new Font("Serif", Font.BOLD, 15));
        husbandShowField.setFont(new Font("Serif", Font.BOLD, 15));
        notesArea.setFont(new Font("Serif", Font.BOLD, 15));
        
          
        
        update=new JButton("Update");
        update.setBorderPainted(false);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLUE);
        
        EnableShow=new JButton("Enable");
        EnableShow.setBorderPainted(false);
        EnableShow.setForeground(Color.WHITE);
        EnableShow.setBackground(Color.BLUE);
        
        showCBC=new JButton("Show CBC");
        showCBC.setBorderPainted(false);
        showCBC.setForeground(Color.WHITE);
        showCBC.setBackground(Color.BLUE);
        
        show=new JButton("Show");
        show.setBorderPainted(false);
        show.setForeground(Color.WHITE);
        show.setBackground(Color.BLUE);
        
        show.setBounds(350, 120, 100, 30);
        EnableShow.setBounds(150, 510, 100, 30);
        update.setBounds(260, 510, 100, 30);
        showCBC.setBounds(370, 510, 100, 30);
        /**********************************/
          
    }
    
    public void draw(){       
        LoginName =new JTextField();
        Password=new JPasswordField();
        Login.setBackground(Color.BLUE);
        Login.setForeground(Color.white);
        Login.setBorderPainted(false);
        
        LoginName.setBounds(450,460, 180, 30);
        Password.setBounds(640, 460, 180, 30);
        Login.setBounds(830, 460, 80, 30);
       
        LoginName.setBorder(null);
        Password.setBorder(null);
        add(Login);
        add(LoginName);
        add(Password);
      
        repaint();
        add(imageBackground);
        Login.addActionListener(this);
        
    } 
    public void welcomePage(){
            welcome =new JPanel();
            welcome.setBounds(280, 450, 800, 100);
            welcome.setOpaque(false);
            String mess=LoginName.getText();
            JLabel welcomlebLabel=new JLabel("Welcom Dr : "+mess);
            welcomlebLabel.setBounds(0  , 0, 500, 100);
            welcome.add(welcomlebLabel);
            remove(LoginName);
            remove(Password);
            remove(Login);
            remove(skiplabel);
            remove(imageBackground);
            welcomlebLabel.setFont(new Font("Serif", Font.BOLD, 20));
            welcomlebLabel.setForeground(Color.WHITE);
            add(welcome);
            add(imageBackground);
            //buttons in add new user
            submit.addActionListener(this);
            clear.addActionListener(this);
            //buttons in add CBC data
            submit2.addActionListener(this);
            clear2.addActionListener(this);
            //buttons in show data
            update.addActionListener(this);
            showCBC.addActionListener(this);
            EnableShow.addActionListener(this);
            show.addActionListener(this);
    }
    public void mcqQuestions(){
        /*******************************/
    
        pickerPanel1=new JPanel();
        pickerPanel2=new JPanel();
        picker1 = new JXDatePicker();
        picker2 = new JXDatePicker();
        picker1.setDate(Calendar.getInstance().getTime());
        picker1.setFormats(new SimpleDateFormat("dd / MM / yyyy"));
        picker2.setDate(Calendar.getInstance().getTime());
        picker2.setFormats(new SimpleDateFormat("dd / MM / yyyy"));
        pickerPanel1.setBounds(350, 270, 190, 30);
        pickerPanel1.setLayout(null);
        pickerPanel2.setBounds(350, 220, 190, 30);
        pickerPanel2.setLayout(null);
        picker1.setBounds(0, 0, 190, 30);
        picker2.setBounds(0, 0, 190, 30);
        pickerPanel1.add(picker1);
        pickerPanel2.add(picker2);

        /******************************/

         
        add(mcqPanel);
         
        mcqPanel.repaint();
        mcqHeader=new JLabel("      Add New Patient Data");
        mcqHeader.setFont(new Font("Serif", Font.BOLD, 48));
        mcqHeader.setForeground(Color.RED);
        enterQuestion=new JLabel("Enter your notes : ");
        enterQuestion.setFont(new Font("Serif", Font.BOLD, 15));
        enterQuestion.setForeground(Color.WHITE);
      
        
        A=new JLabel("File");
        A.setFont(new Font("Serif", Font.BOLD, 15));
        A.setForeground(Color.WHITE);
        B=new JLabel("Name");
        B.setFont(new Font("Serif", Font.BOLD, 15));
        B.setForeground(Color.WHITE);
        C=new JLabel("Age");
        C.setFont(new Font("Serif", Font.BOLD, 15));
        C.setForeground(Color.WHITE);
        D=new JLabel("Phone");
        D.setFont(new Font("Serif", Font.BOLD, 15));
        D.setForeground(Color.WHITE);
        E=new JLabel("Husband");
        E.setFont(new Font("Serif", Font.BOLD, 15));
        E.setForeground(Color.WHITE);
        F=new JLabel("LMP");
        F.setFont(new Font("Serif", Font.BOLD, 15));
        F.setForeground(Color.WHITE);
        G=new JLabel("RH");
        G.setFont(new Font("Serif", Font.BOLD, 15));
        G.setForeground(Color.WHITE);
        H=new JLabel("EDD");
        H.setFont(new Font("Serif", Font.BOLD, 15));
        H.setForeground(Color.WHITE);
        
    
        //////////////////////////////////////////////////
        
        mcqHeader.setBounds(20, 20, 550, 50);
        enterQuestion.setBounds(10, 325, 200, 20);
        scroll.setBounds(80, 360, 460, 100);
       
        questionArea.setFont(new Font("Serif", Font.BOLD, 15));
        
        A.setBounds(15, 120, 60, 20);
        B.setBounds(295, 120, 60, 20);
        C.setBounds(15, 170, 60, 20);
        D.setBounds(295, 170, 60, 20);
        E.setBounds(15, 220, 60, 20);
        F.setBounds(295, 220, 60, 20);
        G.setBounds(15, 270, 60, 20);
        H.setBounds(295, 270, 60, 20);
        
        chooiseA.setBounds(90, 120, 190, 30);
        chooiseA.setFont(new Font("Serif", Font.BOLD, 15));
        chooiseB.setBounds(350, 120, 190, 30);
        chooiseB.setFont(new Font("Serif", Font.BOLD, 15));
        chooiseC.setBounds(90, 170, 190, 30);
        chooiseC.setFont(new Font("Serif", Font.BOLD, 15));
        chooiseD.setBounds(350, 170, 190, 30);
        chooiseD.setFont(new Font("Serif", Font.BOLD, 15));
        chooiseE.setBounds(90, 220, 190, 30);
        chooiseE.setFont(new Font("Serif", Font.BOLD, 15));
      
        RHList.setBounds(90, 270, 190, 30);
        RHList.setFont(new Font("Serif", Font.BOLD, 20));
        
        
        
        
        submit.setBounds(230, 480, 80, 30);
        clear.setBounds(320, 480, 80, 30);
        
        
        mcqPanel.add(submit);        
        mcqPanel.add(clear);        
        mcqPanel.add(chooiseA);
        mcqPanel.add(chooiseB);
        mcqPanel.add(chooiseC);
        mcqPanel.add(chooiseD);
        mcqPanel.add(chooiseE);
        mcqPanel.add(RHList);
        
        mcqPanel.add(H);
        mcqPanel.add(G);
        mcqPanel.add(F);
        mcqPanel.add(E);
        mcqPanel.add(D);
        mcqPanel.add(C);
        mcqPanel.add(B);
        mcqPanel.add(A);
       // mcqPanel.add(enterChooise);
        mcqPanel.add(scroll);
        mcqPanel.add(enterQuestion);
        mcqPanel.add(mcqHeader);
        mcqPanel.add(pickerPanel1);
        mcqPanel.add(pickerPanel2);
        
        
    }
    
    public void sidePanel(){
        left=new JPanel();
        left.setLayout(new GridLayout(6, 1, 10, 20));
        logout=new JLabel("    LogOut");
        logout.setFont(new Font("Serif", Font.BOLD, 20));
        logout.setForeground(Color.WHITE);
        
        home=new JLabel("      Home");
        home.setFont(new Font("Serif", Font.BOLD, 20));
        home.setForeground(Color.WHITE);
        
        MCQ=new JLabel("  add patient");
        MCQ.setFont(new Font("Serif", Font.BOLD, 20));
        MCQ.setForeground(Color.WHITE);
        
        answer=new JLabel("  CBC Data");
        answer.setFont(new Font("Serif", Font.BOLD, 20));
        answer.setForeground(Color.WHITE);
        
        settings=new JLabel("  Show Data");
        settings.setFont(new Font("Serif", Font.BOLD, 20));
        settings.setForeground(Color.WHITE);
        
        aboutus=new JLabel("   About Us");
        aboutus.setFont(new Font("Serif", Font.BOLD, 20));
        aboutus.setForeground(Color.WHITE);
        
        logout.addMouseListener(this);
        home.addMouseListener(this);
        MCQ.addMouseListener(this);
        answer.addMouseListener(this);
        settings.addMouseListener(this);
        aboutus.addMouseListener(this);
        
      // add component on left panel which contain the menue (Logout 
        
        left.add(logout);
        left.add(home);
        left.add(MCQ);
        left.add(answer);
        left.add(settings);
        left.add(aboutus);
        
        left.setBackground(new Color(0,0,0,250));
        left.setBounds(0, 0, 120, 700);
        remove(imageBackground);
        add(left);
        add(imageBackground);
        
    }
    
    public void trueFalseQuestions(){
         submit2.setBounds(205, 480, 92, 30);
         clear2.setBounds(305, 480, 92, 30);
        
         questionArea.setText("");
            chooiseA.setText("");
            chooiseB.setText("");
            chooiseC.setText("");
            chooiseD.setText("");
            chooiseE.setText("");
   
        CBCHeader=new JLabel("      Add New CBC Data ");
        CBCHeader.setFont(new Font("Serif", Font.BOLD, 48));
        CBCHeader.setForeground(Color.RED);
        CBCHeader.setBounds(20, 20, 550, 50);
  
//        submit2.setBounds(200, 500, 80, 30);
//        

          TrueFalsePanel.add(fileNum);
          TrueFalsePanel.add(BP);
          TrueFalsePanel.add(WT);
          TrueFalsePanel.add(HB);
          TrueFalsePanel.add(TLC);
          TrueFalsePanel.add(PLT);
          TrueFalsePanel.add(RBS);
          TrueFalsePanel.add(Date);
          TrueFalsePanel.add(fileNumField);
          TrueFalsePanel.add(BPField);
          TrueFalsePanel.add(WTField);
          TrueFalsePanel.add(HBField);
          TrueFalsePanel.add(TLCField);
          TrueFalsePanel.add(PLTField);
          TrueFalsePanel.add(RBSField);
          TrueFalsePanel.add(pickerPanel3);
          TrueFalsePanel.add(CBCHeader);
          TrueFalsePanel.add(submit2);
          TrueFalsePanel.add(clear2);
          TrueFalsePanel.add(logoLabel);
         add(TrueFalsePanel);
         TrueFalsePanel.repaint();
       
    }
    public void SettingsPanel(){
         
            
            showHeader=new JLabel("        Show Patient Data  ");
            showHeader.setFont(new Font("Serif", Font.BOLD, 48));
            showHeader.setForeground(Color.RED);
            showHeader.setBounds(20, 20, 550, 50);
            settingsPanel.add(showHeader);
            
            nameShowField.setEnabled(false);
            ageShowField.setEnabled(false);
            husbandShowField.setEnabled(false);
            phoneShowField.setEnabled(false);
            showPickerLMP.setEnabled(false);
            showPickerEdd.setEnabled(false);
            showRHList.setEnabled(false);
            notesArea.setEnabled(false);
            
            settingsPanel.add(fileShow);
            settingsPanel.add(nameShow);
            settingsPanel.add(ageShow);
            settingsPanel.add(phoneShow);
            settingsPanel.add(husbandShow);
            settingsPanel.add(lmpShow);
            settingsPanel.add(rhShow);
            settingsPanel.add(eddShow);
            settingsPanel.add(fileShowField);
            settingsPanel.add(nameShowField);
            settingsPanel.add(ageShowField);
            settingsPanel.add(phoneShowField);
            settingsPanel.add(husbandShowField);
            settingsPanel.add(showPickerEddPanel);
            settingsPanel.add(showPickerlmpPanel);
            settingsPanel.add(show);
            settingsPanel.add(EnableShow);
            settingsPanel.add(update);
            settingsPanel.add(showCBC);
            settingsPanel.add(showNoteScroll);
            settingsPanel.add(showRHList);
            
            add(settingsPanel);
       
    }
    public void aboutUs(){
         
        txt1=new JLabel("ENG: Mahmoud Ragab Sakr");
        txt2=new JLabel("ENG: Ibrahim Mohamed ");
        
        mahmoud1=new ImageIcon("image\\mahmoudragab.jpg");
        ibrahim1=new ImageIcon("image\\ibrahim.jpg");
        
       
        
        
        mahmoud=new JLabel(mahmoud1);
        ibrahim=new JLabel(ibrahim1);
        txt1.setBounds(10, 60, 250, 40);
        txt2.setBounds(10, 205, 250, 40);
        
        
        
        
        mahmoud.setBounds(300, 30, 100, 100);
        ibrahim.setBounds(300, 170, 100, 100);
        
        //aboutusPanel.add(ibrahim);
        aboutusPanel.add(mahmoud);
        aboutusPanel.add(txt1);
        txt1.setFont(new Font("Serif", Font.BOLD, 20));
        txt1.setForeground(Color.WHITE);
       // aboutusPanel.add(txt2);
        txt2.setFont(new Font("Serif", Font.BOLD, 20));
        txt2.setForeground(Color.WHITE);
        
        add(aboutusPanel);
        
//        
    }
     static public void main(String[] args) {
         DB.Connect.config();
         
         
       Clinic n= new Clinic();
       
    }

     
     /////////////////////////////////////////////////////////////////////
     
    @Override 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Login){
        try{
            
            Session session=DB.Connect.openSessions();
            
                String usrlogin=LoginName.getText();
                String usrpsw=Password.getText();
                model.Login l=(model.Login)session.get(model.Login.class, usrlogin);
                 
                        if (usrlogin.equals(l.getName()) & usrpsw.equals(l.getPassword())) {
                            sidePanel();
                            welcomePage();
                            repaint();
                            revalidate();
                        
                    }
            
            DB.Connect.closeSessions();
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "User not found try again" ,"Error message",0);
        }
        }else if(e.getSource()==submit){
            try{
            int file=Integer.parseInt(chooiseA.getText());
            String name=chooiseB.getText();
            int age=Integer.parseInt(chooiseC.getText());
            String phone=chooiseD.getText();
            String husband=chooiseE.getText();
            
            String rh="";
            if(RHList.getSelectedIndex()==0){
             rh="+";
            }else if(RHList.getSelectedIndex()==1){
                rh="-";
            }
            
            
            
            Date edd = picker1.getDate();
            Date lmp=picker2.getDate();
            String note=questionArea.getText();
            Session session=DB.Connect.openSessions();
            AddUser user=new AddUser();
            user.setFilenumber(file);
            user.setPatientName(name);
            user.setAge(age);
            user.setPhone(phone);
            user.setHusbandName(husband);
            user.setNotes(note);
            user.setLMP(lmp);
            user.setRH(rh);
            user.setEDD(edd);
            session.save(user);
            DB.Connect.closeSessions();
            JOptionPane.showMessageDialog(null, "Data stored correctly well done !!");
            questionArea.setText("");
            chooiseA.setText("");
            chooiseB.setText("");
            chooiseC.setText("");
            chooiseD.setText("");
            chooiseE.setText("");
            
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "There are error with dataplz don't repeate file number", "Error Message",0);
            }
        }else if(e.getSource()==clear){
            JOptionPane.showMessageDialog(null, "Clear done !!");
            questionArea.setText("");
            chooiseA.setText("");
            chooiseB.setText("");
            chooiseC.setText("");
            chooiseD.setText("");
            chooiseE.setText("");
            
        }else if(e.getSource()==submit2){
            try{
            if(!fileNumField.getText().trim().isEmpty()){
            int file=Integer.parseInt(fileNumField.getText());
            String BP=BPField.getText();
            int wt=Integer.parseInt(WTField.getText());
            int hb=Integer.parseInt(HBField.getText());
            int tlc=Integer.parseInt(TLCField.getText());
            int plt=Integer.parseInt(PLTField.getText());
            int rbs=Integer.parseInt(RBSField.getText());
            SimpleDateFormat formater = new SimpleDateFormat("dd / MM / yyyy");
            String date =formater.format(picker3.getDate());
            Session session=DB.Connect.openSessions();
            Data data=new Data();
            data.setFilenumber(file);
            data.setBP(BP);
            data.setWT(wt);
            data.setHB(hb);
            data.setTLC(tlc);
            data.setPLT(plt);
            data.setRBS(rbs);
            data.setDate(date);
            ArrayList<AddUser> listA = new ArrayList<AddUser>();
          //  List patientdata=(List)session.createSQLQuery("SELECT * FROM patientdata WHERE patientid ='"+file+"'").list();
            
            listA=(ArrayList)session.createSQLQuery("SELECT * FROM patient WHERE patientid ='"+file+"'").addEntity(AddUser.class).list();
            
            if(listA.size()==1){ 
                AddUser ss=listA.get(0);
                System.out.println(ss.getPatientName());
            session.save(data);
            DB.Connect.closeSessions();
            JOptionPane.showMessageDialog(null, "Data stored correctly well done !!");
            }else{
                JOptionPane.showMessageDialog(null, "There is no data for that user plz add patient data first","Error Message",0);
            }
            }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Enter Correct Data PLZ !!","Error Message",0);
            }
        }else if (e.getSource()==clear2){
            fileNumField.setText("");
            BPField.setText("");
            WTField.setText("");
            HBField.setText("");
            TLCField.setText("");
            PLTField.setText("");
            RBSField.setText("");
            JOptionPane.showMessageDialog(null, "Clear data done !!");
            
        }else if(e.getSource()==EnableShow){
            nameShowField.setEnabled(true);
            ageShowField.setEnabled(true);
            husbandShowField.setEnabled(true);
            phoneShowField.setEnabled(true);
            showPickerLMP.setEnabled(true);
            showPickerEdd.setEnabled(true);
            showRHList.setEnabled(true);
            notesArea.setEnabled(true);
            
        }else if (e.getSource()==show){
            if(!fileShowField.getText().trim().equals("")){
             int file=Integer.parseInt(fileShowField.getText());
            Session session=DB.Connect.openSessions();
            ArrayList<AddUser> listA = new ArrayList();
          //  List patientdata=(List)session.createSQLQuery("SELECT * FROM patientdata WHERE patientid ='"+file+"'").list();
            
            listA=(ArrayList)session.createSQLQuery("SELECT * FROM patient WHERE patientid ='"+file+"'").addEntity(AddUser.class).list();
            if(listA.size()==1){ 
//                 try {
                     AddUser ss=listA.get(0);
                     
                     String name=ss.getPatientName();
                     int age=ss.getAge();
                     String husband=ss.getHusbandName();
                     String phone=ss.getPhone();
                     Date edd=ss.getEDD();
                     Date lmp=ss.getLMP();
                     String rh=ss.getRH();
                     String note=ss.getNotes();
                     nameShowField.setText(name);
                     ageShowField.setText(""+age);
                     husbandShowField.setText(husband);
                     phoneShowField.setText(phone);
                     if(rh.equals("+")){
                         showRHList.setSelectedIndex(0);
                     }else if(rh.equals("-")){
                         showRHList.setSelectedIndex(1);
                     }
                     notesArea.setText(note);
                     DateFormat df = new SimpleDateFormat("dd / MM / yyyy");
                
                     
                      showPickerLMP.setFormats(new SimpleDateFormat("dd / MM / yyyy"));
                      showPickerLMP.setDate(lmp);
                      showPickerEdd.setFormats(new SimpleDateFormat("dd / MM / yyyy"));
                      showPickerEdd.setDate(edd);
                 
                    
                    
                     DB.Connect.closeSessions();
                     JOptionPane.showMessageDialog(null, "Data stored correctly well done !!");
//                 } catch (Exception ex) {
//                   //  JOptionPane.showMessageDialog(null, "There is no data for that user plz add patient data first","Error Message",0);
//                 }
            }else{
                JOptionPane.showMessageDialog(null, "There is no data for that user plz add patient data first","Error Message",0);
            }
            }
        }
        else if(e.getSource()==update){
        try{
                    Session session=DB.Connect.openSessions();
                    int file=Integer.parseInt(fileShowField.getText());
                     String name=nameShowField.getText();
                     int age=Integer.parseInt(ageShowField.getText());
                     String husband=husbandShowField.getText();
                     String phone=phoneShowField.getText();
                   //  SimpleDateFormat f = new SimpleDateFormat("dd / MM / yyyy");
                     Date edd=showPickerEdd.getDate();
                     Date lmp=showPickerLMP.getDate();
                     System.out.println(edd);
                     System.out.println(lmp);
                     
                     String rh="";
                     if(showRHList.getSelectedIndex()==0){
                       rh="+";
                     }else if(showRHList.getSelectedIndex()==1){
                        rh="-";
                     }
                     String note=notesArea.getText();
                     Query query=session.createSQLQuery("UPDATE patient SET  notes = '" + note + "' WHERE patientid = '"+file+ "'");
                    query.executeUpdate();
//                     AddUser user=new AddUser();
//                     user.setPatientName(name);
//                     user.setAge(age);
//                     user.setPhone(phone);
//                     user.setEDD(edd);
//                     user.setLMP(lmp);
//                     user.setHusbandName(husband);
//                     user.setNotes(note);
//                     user.setRH(rh);
//                     session.update(user);
                     
                     
        }catch(Exception ex){
           ex.printStackTrace();
//  JOptionPane.showMessageDialog(null, "Make sure from data u want to update !!","Error Message",0);
        }finally{
                     DB.Connect.closeSessions();
            
        }
            
        }else if (e.getSource()==showCBC){
            ShowTable t= new ShowTable();
            int file=Integer.parseInt(fileShowField.getText());
            t.addTable(file);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
        if(me.getSource()==skiplabel){
           draw();
          skiplabel.setVisible(false);
          
        }
        
          else if(me.getSource()==logout){
              
   /******************* this to make a new object from the class ***********************/
              
              this.setVisible(false);
              Clinic m=new Clinic();
              remove(skiplabel);
             
          }
          else if(me.getSource()==home){
              remove(imageBackground);
                if(mcqPanel.isShowing()){
                   remove(mcqPanel);
               }
               if(TrueFalsePanel.isShowing()){
                   remove(TrueFalsePanel);
               }
               if(settingsPanel.isShowing()){
                   remove(settingsPanel);
               }
               if(aboutusPanel.isShowing()){
                   remove(aboutusPanel);
               }
                 remove(welcome);
                 add(descriptionPanel);
                 repaint();
                 add(imageBackground);
                 repaint();
                 revalidate();
                 add(imageBackground);
                 
              
          }
          else if(me.getSource()==MCQ){
              remove(descriptionPanel);
              
              if(TrueFalsePanel.isShowing()){
                  remove(TrueFalsePanel);
              }
              if(settingsPanel.isShowing()){
                  remove(settingsPanel);
                  
              }
              if(aboutusPanel.isShowing()){
                   remove(aboutusPanel);
               }
              remove(welcome);
              mcqQuestions();
              repaint();
              revalidate();
              add(imageBackground);
              mcqPanel.repaint();
              mcqPanel.revalidate();
             
          }
          else if(me.getSource()==answer){
               remove(descriptionPanel);
               if(mcqPanel.isShowing()){
                   remove(mcqPanel);
               }
               if(settingsPanel.isShowing()){
                   remove(settingsPanel);
               }
               if(aboutusPanel.isShowing()){
                   remove(aboutusPanel);
               }
               
              remove(mcqPanel);
              remove(welcome);
              trueFalseQuestions();
              repaint();
              TrueFalsePanel.repaint();
              TrueFalsePanel.revalidate();
              
              add(imageBackground);
          }
          else if(me.getSource()==settings){
               remove(descriptionPanel);
               if(mcqPanel.isShowing()){
                   remove(mcqPanel);
               }
               if(TrueFalsePanel.isShowing()){
                   remove(TrueFalsePanel);
               }
               if(aboutusPanel.isShowing()){
                   remove(aboutusPanel);
               }
                 remove(mcqPanel);
                 remove(welcome);
                 SettingsPanel();
                 repaint();
                 revalidate();
                 add(imageBackground);
          }
          else if(me.getSource()==aboutus){
              
               remove(descriptionPanel);
               remove(welcome);
               if(mcqPanel.isShowing()){
                   remove(mcqPanel);
               }
               if(TrueFalsePanel.isShowing()){
                   remove(TrueFalsePanel);
               }
               if(settingsPanel.isShowing()){
                   remove(settingsPanel);
               }
              aboutUs();
              repaint();
                 add(imageBackground);
          }

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent m) {
        if(m.getSource()==logout){
            logout.setForeground(Color.RED);
            logout.repaint();
        }
        else if(m.getSource()==home){
            home.setForeground(Color.RED);
            home.repaint();
        }
        else if(m.getSource()==MCQ){
            MCQ.setForeground(Color.RED);
            MCQ.repaint();
        }
        else if(m.getSource()==answer){
            answer.setForeground(Color.RED);
            answer.repaint();
        }
        else if(m.getSource()==aboutus){
            aboutus.setForeground(Color.RED);
            aboutus.repaint();
        }
        else if(m.getSource()==settings){
            settings.setForeground(Color.RED);
            settings.repaint();
        }
    
    }

    @Override
    public void mouseExited(MouseEvent m) {
        if(m.getSource()==logout){
        logout.setForeground(Color.WHITE);
        logout.repaint();
        if(TrueFalsePanel.isShowing()){
            System.out.println(">>>>>>");
        }else{
            System.out.println("mmmmm");
        }
        }
        else if(m.getSource()==home){
            home.setForeground(Color.WHITE);
            home.repaint();
        }
        else if(m.getSource()==MCQ){
            MCQ.setForeground(Color.WHITE);
            MCQ.repaint();
        }
        else if(m.getSource()==answer){
            answer.setForeground(Color.WHITE);
            answer.repaint();
        }
        else if(m.getSource()==aboutus){
            aboutus.setForeground(Color.WHITE);
            aboutus.repaint();
        }
        else if(m.getSource()==settings){
            settings.setForeground(Color.WHITE);
            settings.repaint();
        }
       
            
        
    }

    @Override
    public void windowOpened(WindowEvent we) {
        

    }

    @Override
    public void windowClosing(WindowEvent we) {
        JOptionPane.showMessageDialog(null, "Closed");
    }

    @Override
    public void windowClosed(WindowEvent we) {
        JOptionPane.showMessageDialog(null, "Closed");
    }

    @Override
    public void windowIconified(WindowEvent we) {

    }

    @Override
    public void windowDeiconified(WindowEvent we) {

    }

    @Override
    public void windowActivated(WindowEvent we) {
    
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }
}