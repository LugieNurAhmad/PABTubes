package com.example.pabtubes;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class DataRegis implements Serializable {
    private String nama, email, pass, phone, gender;
    private String key;

    public DataRegis(){

    }

    public String getKey(){
        return key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPass(){
        return pass;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    @Override
    public String toString(){
        return " " + nama + "\n" +
                " " + email + "\n" +
                " " + pass + "\n" +
                " " + phone + "\n" +
                " " + gender;
    }

    public DataRegis(String nm, String eml, String psw, String phn, String gndr){
        nama = nm;
        email = eml;
        pass = psw;
        phone = phn;
        gender = gndr;
    }
}
