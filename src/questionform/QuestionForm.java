package questionform;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class QuestionForm extends JFrame implements ActionListener,MouseListener,WindowListener{
    
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
    JLabel    descriptionText=new JLabel("<html>This Applicatin Help Doctors In Our Faclty To "
            + "  Enter <br> Exam Questions This "
            + "Application To Help Doctors <br> To Put "
            + "  Different"
            + " Question Multi Chooise Or True/False <br>"
            + " And This Is Our Team Project  At Software Enginnering <br>"
            + " &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  Final Project  </html>");
    
    int              count;
    JTextField       LoginName;
    JPasswordField   Password;
    JButton          Login;
    
    /**************************** MCQ Panel Component **************************************************/
        JLabel mcqHeader,enterQuestion,enterChooise,A,B,C,D;
        JTextArea questionArea;
        JTextField chooiseA,chooiseB,chooiseC,chooiseD;
        JButton submit;
        JRadioButton radioA,radioB,radioC,radioD;
        ButtonGroup BG;
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
        
    /*************************** DB Connection *********************************************************/
    Connection con;
    Statement st;
    ResultSet rs;
    public QuestionForm(){
            /*********************** DB Connection *************************/

        
        


        /***************************************************************/
        Login=new JButton("Login");
        skipImageIcon=new ImageIcon("image\\nn.png");
        skiplabel=new JLabel(skipImageIcon);
        backgroundImageIcon=new ImageIcon("image\\m.jpg");
        skipButton=new JButton(skipImageIcon);
        imageBackground=new JLabel(backgroundImageIcon);
        header=new JLabel("         Exam Application");
        
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
        TrueFalsePanel.setBounds(430, 110, 500, 550);
        
        settingsPanel =new JPanel();
        settingsPanel.setLayout(null);
        settingsPanel.setBackground(new Color(0,0,0,150));
        settingsPanel.setBounds(430, 110, 500, 550);
        
        aboutusPanel =new JPanel();
        aboutusPanel.setLayout(null);
        aboutusPanel.setBackground(new Color(0,0,0,150));
        aboutusPanel.setBounds(430, 110, 500, 550);
        
        
        
        mcqPanel=new JPanel();
        mcqPanel.setLayout(null);
        mcqPanel.setBackground(new Color(0,0,0,150));
        mcqPanel.setBounds(430, 110, 500, 550);
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
            
    }
    public void mcqQuestions(){
//        mcqPanel=new JPanel();
//        mcqPanel.setLayout(null);
//        mcqPanel.setBackground(new Color(0,0,0,150));
//        mcqPanel.setBounds(430, 110, 500, 550);
        add(mcqPanel);
//        mcqPanel.repaint();
        mcqHeader=new JLabel("This Form To Enter MCQ Quetions");
        mcqHeader.setFont(new Font("Serif", Font.BOLD, 20));
        mcqHeader.setForeground(Color.WHITE);
        enterQuestion=new JLabel("Enter a question : *");
        enterQuestion.setFont(new Font("Serif", Font.BOLD, 15));
        enterQuestion.setForeground(Color.WHITE);
        enterChooise=new JLabel("Enter Multi Chooise : *");
        enterChooise.setFont(new Font("Serif", Font.BOLD, 15));
        enterChooise.setForeground(Color.WHITE);
        
        A=new JLabel("A");
        A.setFont(new Font("Serif", Font.BOLD, 15));
        A.setForeground(Color.WHITE);
        B=new JLabel("B");
        B.setFont(new Font("Serif", Font.BOLD, 15));
        B.setForeground(Color.WHITE);
        C=new JLabel("C");
        C.setFont(new Font("Serif", Font.BOLD, 15));
        C.setForeground(Color.WHITE);
        D=new JLabel("D");
        D.setFont(new Font("Serif", Font.BOLD, 15));
        D.setForeground(Color.WHITE);
        
        questionArea =new JTextArea();
        chooiseA=new JTextField();
        chooiseA.setBorder(null);
        chooiseB=new JTextField();
        chooiseB.setBorder(null);
        chooiseC=new JTextField();
        chooiseC.setBorder(null);
        chooiseD=new JTextField();
        chooiseD.setBorder(null);
        submit=new JButton("Submit");
        submit.setBorderPainted(false);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        
        radioA=new JRadioButton();
        radioA.setBorderPainted(false);
        radioB=new JRadioButton();
        radioB.setBorderPainted(false);
        radioC=new JRadioButton();
        radioC.setBorderPainted(false);
        radioD=new JRadioButton();
        radioD.setBorderPainted(false);
        
        BG=new ButtonGroup();
        
        
        //////////////////////////////////////////////////
        mcqHeader.setBounds(80, 20, 300, 40);
        enterQuestion.setBounds(10, 70, 200, 20);
        questionArea.setBounds(20, 100, 460, 80);
        enterChooise.setBounds(10, 210, 200, 20);
        questionArea.setFont(new Font("Serif", Font.BOLD, 15));
        
        
        A.setBounds(15, 250, 20, 20);
        B.setBounds(260, 250, 20, 20);
        C.setBounds(15, 330, 20, 20);
        D.setBounds(260, 330, 20, 20);
        
        chooiseA.setBounds(40, 250, 160, 30);
        chooiseB.setBounds(285, 250, 160, 30);
        chooiseC.setBounds(40, 330, 160, 30);
        chooiseD.setBounds(285, 330, 160, 30);
        
        radioA.setBounds(210, 255, 20, 20);
        radioB.setBounds(460, 255, 20, 20);
        radioC.setBounds(210, 335, 20, 20);
        radioD.setBounds(460, 335, 20, 20);
        
        submit.setBounds(200, 500, 80, 30);
        
        
        mcqPanel.add(submit);
        
        BG.add(radioA);
        BG.add(radioB);
        BG.add(radioC);
        BG.add(radioD);
        
        mcqPanel.add(radioA);
        mcqPanel.add(radioB);
        mcqPanel.add(radioC);
        mcqPanel.add(radioD);
        
        mcqPanel.add(chooiseA);
        mcqPanel.add(chooiseB);
        mcqPanel.add(chooiseC);
        mcqPanel.add(chooiseD);
        
        mcqPanel.add(D);
        mcqPanel.add(C);
        mcqPanel.add(B);
        mcqPanel.add(A);
        mcqPanel.add(enterChooise);
        mcqPanel.add(questionArea);
        mcqPanel.add(enterQuestion);
        mcqPanel.add(mcqHeader);
        
        
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
        
        MCQ=new JLabel("      New patient");
        MCQ.setFont(new Font("Serif", Font.BOLD, 20));
        MCQ.setForeground(Color.WHITE);
        
        answer=new JLabel("  Find Patient");
        answer.setFont(new Font("Serif", Font.BOLD, 20));
        answer.setForeground(Color.WHITE);
        
        settings=new JLabel("     Settings");
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
//        TrueFalsePanel =new JPanel();
//        
//        TrueFalsePanel.setLayout(null);
//        TrueFalsePanel.setBackground(new Color(0,0,0,150));
//        TrueFalsePanel.setBounds(430, 110, 500, 550);
        mcqHeader=new JLabel("This Form To Enter True/False Quetions");
        questionArea=new JTextArea();
        enterQuestion=new JLabel("Enter a question : *");
        enterChooise=new JLabel("Enter The Correct Answer : *");
        
        TrueAnswer=new JLabel("True");
        FalseAnswer=new JLabel("False");
        
        submit=new JButton("Submit");
        submit.setBorderPainted(false);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
       
        
        
        mcqHeader.setFont(new Font("Serif", Font.BOLD, 20));
        mcqHeader.setForeground(Color.WHITE);
        enterQuestion.setFont(new Font("Serif", Font.BOLD, 20));
        enterQuestion.setForeground(Color.WHITE);
        enterChooise.setFont(new Font("Serif", Font.BOLD, 20));
        enterChooise.setForeground(Color.WHITE);
        TrueAnswer.setFont(new Font("Serif", Font.BOLD, 20));
        TrueAnswer.setForeground(Color.WHITE);
        FalseAnswer.setFont(new Font("Serif", Font.BOLD, 20));
        FalseAnswer.setForeground(Color.WHITE);
        mcqHeader.setBounds(80, 20, 400, 40);
        True=new JRadioButton();
        False=new JRadioButton();
        BG1=new ButtonGroup();
        
        
        enterQuestion.setBounds(10, 70, 200, 20);
        questionArea.setBounds(20, 100, 460, 80);
        questionArea.setFont(new Font("Serif", Font.BOLD, 15));
        enterChooise.setBounds(10, 210, 300, 20);
        True.setBounds(170, 265, 20, 20);
        False.setBounds(420, 265, 20, 20);
        TrueAnswer.setBounds(110, 255, 100, 30);
        FalseAnswer.setBounds(360  , 255, 100, 30);
        submit.setBounds(200, 500, 80, 30);
        
        TrueFalsePanel.add(submit);
        TrueFalsePanel.add(mcqHeader);
        TrueFalsePanel.add(enterQuestion);
        TrueFalsePanel.add(questionArea);
        TrueFalsePanel.add(enterChooise);
        BG1.add(True);
        BG1.add(False);
        TrueFalsePanel.add(True);
        TrueFalsePanel.add(False);
        TrueFalsePanel.add(TrueAnswer);
        TrueFalsePanel.add(FalseAnswer);
        add(TrueFalsePanel);
        TrueFalsePanel.repaint();
        
        
    }
    public void SettingsPanel(){
        mcqHeader=new JLabel("This Form to set qurestion settings and exam settings");
        enterQuestion=new JLabel("Enter Number Of Multi Chooise Question *");
        enterChooise=new JLabel("Enter Number Of True/False Questions *");
        examPeriod=new JLabel("Enter The Time For The Exam *");
        questionDegree=new JLabel("Enter The Degree For A Question *");
        
        truequestionNumber=new JTextField();
        chooisequestionNumber=new JTextField();
        examPeriodtf=new JTextField();
        questionDegreetf=new JTextField();
        
        submit=new JButton("Submit");
        submit.setBorderPainted(false);
        submit.setBounds(200, 500, 80, 30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        
        
        truequestionNumber.setBounds(300, 130, 150, 30);
        truequestionNumber.setBorder(null);
        chooisequestionNumber.setBounds(300, 220, 150, 30);
        chooisequestionNumber.setBorder(null);
        
        examPeriod.setBounds(10, 260, 500, 40);
        examPeriod.setFont(new Font("Serif", Font.BOLD, 20));
        examPeriod.setForeground(Color.WHITE);
        
        questionDegree.setBounds(10, 340, 500, 30);
        questionDegree.setFont(new Font("Serif", Font.BOLD, 20));
        questionDegree.setForeground(Color.WHITE);
        
       
        
        questionDegreetf.setBounds(300, 380, 150, 30);
        questionDegreetf.setBorder(null);
        
        examPeriodtf.setBounds(300, 300, 150, 30);
        examPeriodtf.setBorder(null);
        
        
        mcqHeader.setBounds(20, 20, 500, 40);
        mcqHeader.setFont(new Font("Serif", Font.BOLD, 20));
        mcqHeader.setForeground(Color.WHITE);
        
        enterQuestion.setFont(new Font("Serif", Font.BOLD, 20));
        enterQuestion.setForeground(Color.WHITE);
        enterQuestion.setBounds(10, 100, 500, 20);
        
        enterChooise.setFont(new Font("Serif", Font.BOLD, 20));
        enterChooise.setForeground(Color.WHITE);
        enterChooise.setBounds(10, 190, 500, 20);
        
        settingsPanel.add(truequestionNumber);
        settingsPanel.add(enterQuestion);
        settingsPanel.add(mcqHeader);
        settingsPanel.add(enterChooise);
        settingsPanel.add(chooisequestionNumber);
        settingsPanel.add(examPeriod);
        settingsPanel.add(examPeriodtf);
        settingsPanel.add(questionDegree);
        settingsPanel.add(questionDegreetf);
        settingsPanel.add(questionDegreetf);
        settingsPanel.add(submit);
      
        add(settingsPanel);
        
    }
    public void aboutUs(){
        txt1=new JLabel("ENG: Mahmoud Ragab Sakr");
        txt2=new JLabel("ENG: Ibrahim Mohamed ");
        
        mahmoud1=new ImageIcon("E:\\NetBeansProjects\\QuestionForm\\image\\mahmoudragab.jpg");
        ibrahim1=new ImageIcon("E:\\NetBeansProjects\\QuestionForm\\image\\ibrahim.jpg");
        
       
        elanany1=new ImageIcon();
        ahmed1=new ImageIcon();
        amr1=new ImageIcon();
        aboali1=new ImageIcon();
        
        mahmoud=new JLabel(mahmoud1);
        ibrahim=new JLabel(ibrahim1);
        txt1.setBounds(10, 60, 250, 40);
        txt2.setBounds(10, 205, 250, 40);
        
        
        
        
        mahmoud.setBounds(300, 30, 100, 100);
        ibrahim.setBounds(300, 170, 100, 100);
        
        aboutusPanel.add(ibrahim);
        aboutusPanel.add(mahmoud);
        aboutusPanel.add(txt1);
        txt1.setFont(new Font("Serif", Font.BOLD, 20));
        txt1.setForeground(Color.WHITE);
        aboutusPanel.add(txt2);
        txt2.setFont(new Font("Serif", Font.BOLD, 20));
        txt2.setForeground(Color.WHITE);
        
        add(aboutusPanel);
        
    }
     static public void main(String[] args) {
       QuestionForm n= new QuestionForm();
    }

     
     /////////////////////////////////////////////////////////////////////
     
    @Override 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Login){
            try {
                String usrlogin=LoginName.getText();
                String usrpsw=Password.getText();
                  String sql = "Select*from Login";
                   con=DriverManager.getConnection("jdbc:odbc:ProjectDT");
                   st = con.createStatement();
                   rs=st.executeQuery(sql);
                    String sname;
                    String sPAs;
                    while (rs.next()) {
                        sname = rs.getString(1);
                        sPAs = rs.getString(2);
                        if (usrlogin.equals(sname) & usrpsw.equals(sPAs)) {
////
                            sidePanel();
                            welcomePage();
                            repaint();
                            revalidate();
                        }
//                        else{
//                            System.out.println("Error !!!!");
//                           JOptionPane.showMessageDialog(null, "Error", "Error Message", ERROR_MESSAGE);
//                           break;
//                        }
                    }
            } catch (SQLException ex) {
                System.out.println("Error in DB connection ");
                
            }
            
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
              QuestionForm m=new QuestionForm();
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
              add(imageBackground);
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