package questionform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import model.Data;
import org.hibernate.Session;


public class ShowTable extends JFrame{
    String arr[][];

        JTable table;
    public ShowTable(){
       
        
        
        
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(700, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    public void addTable(int file){
        String header[]={"Date","BP","WT","HB","TLC","RBS","PLT"};
        DB.Connect.config();
         Session session= DB.Connect.openSessions();
         ArrayList<Data> listA=new ArrayList();
         listA=(ArrayList)session.createSQLQuery("SELECT * FROM patientdata WHERE patientid ='"+file+"'").addEntity(Data.class).list();
         
          arr=new String[1000][7];
          table=new JTable(arr, header);
          JScrollPane scrollPane = new JScrollPane(table);
          table.setBackground(Color.white);
          table.setForeground(Color.red);
          table.setRowHeight(20);
          table.setRowMargin(5);
          table.setFont(new Font("Serif", Font.BOLD, 15));
          
           JTableHeader headerv = table.getTableHeader();
           headerv.setBackground(Color.BLUE);
           headerv.setForeground(Color.WHITE);
           headerv.setFont(new Font("Serif", Font.BOLD, 20));
           add(scrollPane, BorderLayout.CENTER);
          repaint();
          revalidate();
        // add(table);
        for (int i = 0; i < listA.size(); i++) {
            Data data=listA.get(i);
            arr[i][0]=data.getDate();
            arr[i][1]=data.getBP();
            arr[i][2]=String.valueOf(data.getWT());
            arr[i][3]=String.valueOf(data.getHB());
            arr[i][4]=String.valueOf(data.getTLC());
            arr[i][5]=String.valueOf(data.getRBS());
            arr[i][6]=String.valueOf(data.getPLT());
            
        }
        
        
        DB.Connect.closeSessions();
    }
    
    
    
}
