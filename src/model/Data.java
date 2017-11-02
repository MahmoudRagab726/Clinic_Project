package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "patientdata")
public class Data {


    private String BP;
    private int filenumber;
    private int WT;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFilenumber() {
        return filenumber;
    }

    public void setFilenumber(int filenumber) {
        this.filenumber = filenumber;
    }
}
