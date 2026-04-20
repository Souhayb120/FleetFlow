package com.example.FleetFlow.models;

public class ChildChauffeur extends Chauffeur{
    private int phoneNumber;

   public ChildChauffeur(int phone ){
       this.phoneNumber = phone;

   }

   public int getPhoneNumber(){
       return this.phoneNumber;
   }

   public void setPhoneNumber(int phoneNumber){
       this.phoneNumber = phoneNumber;
   }



    @Override
    public String sayHi(String name , String firstName){
       ChildChauffeur childChauffeur = new ChildChauffeur(234);
        return name + firstName;
    }
}
