/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zurion.contactregistry.dao;

/**
 *
 * @author cheruiyotkelvincollins
 */
import java.time.LocalDate;

       public class Contact {
          private int id;
           private String fullName;
          private String phoneNumber;
        private String email;
        private String idNumber;
       private LocalDate dateOfBirth;
          private String gender;
         private String county;
           
           public Contact() {}
          
          public Contact(String fullName, String phoneNumber, String email, String idNumber, LocalDate dateOfBirth, String gender, String county) {
               this.fullName = fullName;
               this.phoneNumber = phoneNumber;
               this.email = email;
               this.idNumber = idNumber;
               this.dateOfBirth = dateOfBirth;
               this.gender = gender;
              this.county = county;
          }
          
         // Getters and Setters
           public int getId() { return id; }
           public void setId(int id) { this.id = id; }
           public String getFullName() { return fullName; }
           public void setFullName(String fullName) { this.fullName = fullName; }
           public String getPhoneNumber() { return phoneNumber; }
           public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
           public String getEmail() { return email; }
           public void setEmail(String email) { this.email = email; }
           public String getIdNumber() { return idNumber; }
           public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
           public LocalDate getDateOfBirth() { return dateOfBirth; }
           public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
           public String getGender() { return gender; }
           public void setGender(String gender) { this.gender = gender; }
           public String getCounty() { return county; }
           public void setCounty(String county) { this.county = county; }
       }
       