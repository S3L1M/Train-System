package opnsrc.fcih.trainrsys.backend;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
//import java.util.ArrayList;
import java.util.Date;

public class Admin extends Staff{
    public Admin() {}
	 
    public Admin(boolean gender,int id,String Name,/*Date B_Date,*/String Password,String phone,String Adress,int qualifiction){
        super(gender,id,Name,/*B_Date,*/Password, phone,Adress,qualifiction);
    }
    public void  addNewEmployee(/*Date B_Date,*/int id ,String Name,boolean gender,String Password,String phone,String Adress,int qualifiction) {
        Employee x=new Employee(id,Name,phone,Password,gender,Adress,qualifiction);
       /* x.B_Date=B_Date;*/
       
        if (x.addemployee()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }  
    public void displayEmployee() {
        Employee x = new Employee();
        System.out.println(x.displayAllEmployees());
    }        
    public void updateEmployee(int id, Employee ValueOfEmployee)  {
        Employee x = new Employee();
         
        if (x.updateEmployee(id, ValueOfEmployee)) {
            System.out.println(ValueOfEmployee.toString() + "Updated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }
    }
    public void updateTrain(int id, Train ValueOfTrain)  {
        Train x = new Train();
         
        if (x.updateTrain(id, ValueOfTrain)) {
            System.out.println(ValueOfTrain.toString() + "Updated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }
    }
    public void deleteEmployee(int id) {
        Employee x = new Employee();
        if(x.deleteemployee(id))
            System.out.println("Student: "+ id + " Deleted Successfully ... !");
        else 
            System.out.println("Failed to Deleted ... !");
        }

    public void addNewTrian(String Train_Name,int  Train_ID,String ArriveATime,String Arraive_point,String Start_Point,String LeavingTime_sPoint) {
         Train x = new Train();
         x.Train_ID=Train_ID;
         x.Train_Name=Train_Name;
         x.Arraive_Point=Arraive_point;
         x.Start_Point=Start_Point;
         x.ArriveTime=""+ArriveATime;
         x.LeavingTime_sPoint=""+LeavingTime_sPoint;
        if (x.AddTrain()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }  
    public void displayTrains() {
        Train x = new Train();
        System.out.println(x.displayAllTrains());
    }
    
    public void deleteTrain(int id) {
        Train x = new Train();
        if (x.deleteTrain(id)) {
           System.out.println("Train: "+ id + " Deleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
