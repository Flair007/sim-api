package com.sim.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Sim {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String sim_card_no;
    private long mobile_no;
    private String status;
    private Date expiry_date;
    private String state_of_registration;
    private boolean kyc;
    private String telecom_provider;
    private String full_name;
    public Sim(){

    }
    public Sim(String sim_card_no, long mobile_no, String status, Date expiry_date, String state_of_registration, boolean kyc, String telecom_provider, String full_Name) {
        this.sim_card_no = sim_card_no;
        this.mobile_no = mobile_no;
        this.status = status;
        this.expiry_date = expiry_date;
        this.state_of_registration = state_of_registration;
        this.kyc = kyc;
        this.telecom_provider = telecom_provider;
        this.full_name = full_Name;
    }

    @Override
    public String toString() {
        return "Sim{" +
                "id=" + id +
                ", sim_card_no='" + sim_card_no + '\'' +
                ", mobile_no=" + mobile_no +
                ", status='" + status + '\'' +
                ", expiry_date=" + expiry_date +
                ", state_of_registration='" + state_of_registration + '\'' +
                ", kyc=" + kyc +
                ", telecom_provider='" + telecom_provider + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSim_card_no() {
        return sim_card_no;
    }

    public void setSim_card_no(String sim_card_no) {
        this.sim_card_no = sim_card_no;
    }

    public long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getState_of_registration() {
        return state_of_registration;
    }

    public void setState_of_registration(String state_of_registration) {
        this.state_of_registration = state_of_registration;
    }

    public boolean isKyc() {
        return kyc;
    }

    public void setKyc(boolean kyc) {
        this.kyc = kyc;
    }

    public String getTelecom_provider() {
        return telecom_provider;
    }

    public void setTelecom_provider(String telecom_provider) {
        this.telecom_provider = telecom_provider;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
