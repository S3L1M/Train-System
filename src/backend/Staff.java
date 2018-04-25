// EXPLAIN
package opnsrc.fcih.trainrsys.backend;

import java.util.Date;

public class Staff extends Person {
    protected int id;
    protected String Password;
    protected boolean Gender;
   // protected Date B_Date;
    protected  String Adress;
    protected int qualifiction;
    public Staff() {}
    
    public Staff(boolean gender, int id, String name, /*Date B_Date,*/ String Password, String phone,String Adress,int qualifiction) {
        super(name, phone);
            this.id = id;
            this.Adress=Adress;
            this.Gender = gender;
            this.Password = Password;
            this.Password = Password;
            this.qualifiction=qualifiction;
    }

    public void setUserName(int ID) {
        this.id = ID;
    }

    public int getQualifiction() {
        return qualifiction;
    }

    public void setQualifiction(int qualifiction) {
        this.qualifiction = qualifiction;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.qualifiction;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Staff other = (Staff) obj;
        return true;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }
    
    public int getUserName() {
        return this.id;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public boolean getGender() {
        return this.Gender;
    }

   /* public void setB_Date(Date B_Date) {
        this.B_Date = B_Date;
    }

    public Date getB_Date() {
        return this.B_Date;
    }*/

    @Override
    public String toString() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.id+"|"+this.name+"|"+this.Password+"|"+this.Gender+"|"+this.phone+"|";
    }
}
