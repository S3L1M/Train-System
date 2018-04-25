// EXPLAIN
package opnsrc.fcih.trainrsys.backend;

public abstract class Person {
    String name;
    String phone;

    public Person() {}

    public Person(String Name, String Phone) {
        name = Name;
        phone = Phone;
                
    }


    @Override
    public abstract String toString();

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getName() {
        return this.name;
    }

    public String getphone() {
        return this.phone;
    }

    public boolean loginn(String userName, String Pass) {
        if (userName.equals("root") && Pass.equals("toor")) {
            return true;
        }
        return false;
    }
}
