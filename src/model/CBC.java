package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Mahmoud Ragab on 10/10/2016.
 */
@Entity
@Table(name = "cbc")
public class CBC {
    private int filenumber;

    public int getFilenumber() {
        return filenumber;
    }

    public void setFilenumber(int filenumber) {
        this.filenumber = filenumber;
    }

    private int HB;
    private int TLC;
    private int PLT;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
