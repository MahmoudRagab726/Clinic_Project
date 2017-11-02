package model;

import javax.persistence.*;

@Entity
@Table(name = "patientdata")
public class Data {
    @Id
    @Column(name = "id")
    
    private int id;
    @Column(name = "patientid")
    private int filenumber;
    @Column(name = "BP")
    private String BP;
    @Column(name = "WT")
    private int WT;
    @Column(name = "HB")
    private int HB;
    @Column(name = "TLC")
    private int TLC;
    @Column(name = "PLT")
    private int PLT;
    @Column(name = "RBS")
    private int RBS;
    @Column(name = "date")
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getBP() {
        return BP;
    }

    public void setBP(String BP) {
        
        this.BP = BP;
        
    }

    public int getWT() {
        return WT;
    }

    public void setWT(int WT) {
        
        this.WT = WT;
        
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
       
        this.date = date;

    }

    public int getFilenumber() {
        return filenumber;
    }

    public void setFilenumber(int filenumber) {
       
        this.filenumber = filenumber;
       
    }

    public int getHB() {
        return HB;
    }

    public void setHB(int HB) {
        this.HB = HB;
    }

    public int getTLC() {
        return TLC;
    }

    public void setTLC(int TLC) {
        this.TLC = TLC;
     
    }

    public int getPLT() {
        return PLT;
    }

    public void setPLT(int PLT) {
        this.PLT = PLT;
        
    }

    

   

    public int getRBS() {
        return RBS;
    }

    public void setRBS(int RBS) {
        this.RBS = RBS;
    }
}
    
