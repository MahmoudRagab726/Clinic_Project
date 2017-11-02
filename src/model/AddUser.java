package model;


import java.util.Date;
import javax.persistence.*;


/**
 * Created by Mahmoud Ragab on 10/10/2016.
 */
@Entity
@Table(name = "patient")
public class AddUser {
    @Id
    @Column(name = "patientid")
    private int filenumber;
    @Column(name = "patientname")
    private String patientName;
    @Column(name = "age")
    private int age;
    @Column(name = "husbandname")
    private String husbandName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "notes")
    private String notes;
    @Column(name = "LMP")
    private Date LMP;
    @Column(name = "RH")
    private String RH;
    @Column(name = "EDD")
    private Date EDD;

    public int getFilenumber() {
        return filenumber;
    }

    public void setFilenumber(int filenumber) {
        this.filenumber = filenumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHusbandName() {
        return husbandName;
    }

    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getLMP() {
        
        return LMP;
    }

    public void setLMP(Date LMP) {
        this.LMP = LMP;
    }

    public String getRH() {
        return RH;
    }

    public void setRH(String RH) {
        this.RH = RH;
    }

    public Date getEDD() {
        return EDD;
    }

    public void setEDD(Date EDD) {
        this.EDD = EDD;
    }

   
}
