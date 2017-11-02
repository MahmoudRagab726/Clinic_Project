package model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Mahmoud Ragab on 10/10/2016.
 */
@Entity
@Table(name = "patient")
public class AddUser {
    private int filenumber;
    private String patientName;
    private int age;
    private String husbandName;
    private String phone;
    private String notes;
    private String LMP;
    private String RH;
    private String EDD;

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

    public String getLMP() {
        return LMP;
    }

    public void setLMP(String LMP) {
        this.LMP = LMP;
    }

    public String getRH() {
        return RH;
    }

    public void setRH(String RH) {
        this.RH = RH;
    }

    public String getEDD() {
        return EDD;
    }

    public void setEDD(String EDD) {
        this.EDD = EDD;
    }
}
