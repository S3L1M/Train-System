// FixErrors Name var
// Where is date var 
package opnsrc.fcih.trainrsys.backend;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee extends Staff {
    public static ArrayList<Employee> Employees = new ArrayList<Employee>();
    public Employee() {}
                    // UsrName | Name | Phone | Password | Gender | Date << FixError
	 
    public Employee(int id,String Name,String phone,String Password,boolean gender/*,Date B_Date*/,String Adress,int qualifiction){
        super(gender,id,Name,/*B_Date,*/Password, phone,Adress,qualifiction);
    }
    private void commitToFile() {

        for (int i = 0; i < Employees.size(); i++) {
            boolean appendtype;
            if(i==0){
            appendtype =false;
            }
            else{
            appendtype=true;
            }
            
            Data.write(Employees.get(i).getEmployeeData(), Consts.EMPLOYEES,appendtype);
        }
    }

    public void loadFromFile()
    {
        Employees = (ArrayList<Employee>) (Object) Data.read(Consts.EMPLOYEES);
    }

    private String getEmployeeData() {
        return  this.id+"/"+this.name+"/"+this.Password+/*"|"+this.B_Date+*/"/"+this.Gender+"/"+this.phone+"/"+this.Adress+"/"+this.qualifiction ;
    }

    public void addNewTicket(int No, int seat_no) {
        Ticket x = new Ticket(No,seat_no);
        if (x.addTicket()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayTicket() {
        Ticket x = new Ticket();
        System.out.println(x.displayAllTicketes());
    }

    public void searchForTicket(int No) {
        Ticket x = new Ticket();
        System.out.println(x.searchTicket(No));
    }

    public void updateTicket(int oldNo, Ticket newTicketValues) {
        Ticket x = new Ticket();
        x.updateTicket(oldNo, newTicketValues);
        System.out.println("Updated Successfully ... !");
    }
        
    public boolean addemployee() {
     if (Data.write(this.getEmployeeData(), Consts.EMPLOYEES,true)) {
            return true;
        } else {
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }
        public Employee searchEmpById(int id) {
        Employee temp = new Employee();
        loadFromFile();
        int index = getEmployeeIndex(id);
        if (index != -1) {
            return Employees.get(index);
        } else {
            return temp;
        }
    }

    public ArrayList<Employee> listEmployees() {
        loadFromFile();
        return Employees;
    }
    public String displayAllEmployees() {
        loadFromFile();
        String S = "\nAll Courses Data:\n";
        for (Employee x : Employees) {
            S = S + x.toString();
        }
        return S;
    }
    public int getEmployeeIndex(int num){
        for (int i = 0; i < Employees.size(); i++)
            if(Employees.get(i).getUserName()==num)
                return i;
        return -1;
    }
    public boolean login(int id ,String password){
        loadFromFile();
        for (int i = 0; i < Employees.size(); i++)
            if(Employees.get(i).getUserName()==id && Employees.get(i).getPassword().equals(password))
                return true;
        return false;
    }
    public boolean updateEmployee(int id, Employee ValueOfEmployee) {
    loadFromFile();
    
        int index = getEmployeeIndex(id); 
        if(index != -1){
            
            Employees.set(index, ValueOfEmployee);
            
            
            commitToFile();
            return true;
        }
        return false;
    }

    public  boolean deleteemployee(int id) {
        loadFromFile();
        int index = getEmployeeIndex(id);
        if (index != -1) {
            Employees.remove(index);
            commitToFile();
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return "\nemployee id\t" +this.id +"\nemployee name\t"+this.name+"\nemployee password\t"+this.Password+"\nemployee phone\t"+this.phone+"\nemployee address\t"+this.Adress+"\nemployee Qualifiction"+this.qualifiction;      
    } 
}
