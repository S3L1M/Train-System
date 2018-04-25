// Review
package opnsrc.fcih.trainrsys.backend;

import java.util.ArrayList;

public class Ticket {
    private int no ;
    private int seat_no;
   // private String QR_code;
    public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public Ticket(int no, int seat_no) {
        this.no = no;
        this.seat_no = seat_no;
    }

    public Ticket() {}
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    /*public String getQR_code() {
        return QR_code;
    }

    public void setQR_code(String QR_code) {
        this.QR_code = QR_code;
    }*/
    public boolean addTicket() {
        if (Data.write(this.getTicketData(), Consts.TICKETS,true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getTicketData() {
        return this.no + "/" + this.seat_no + "/" ;
    }
    // Check all commits 
    private void commitToFile() {
        for (int i = 0; i < tickets.size(); i++) {
            boolean appendtype;
            if(i==0){
            appendtype =false;
            }
            else{
            appendtype=true;
            }
            Data.write(tickets.get(i).getTicketData(), Consts.TICKETS,appendtype);
        }

    }

    private int getTicketIndex(int num){
        for (int i = 0; i < tickets.size(); i++)
            if(tickets.get(i).getNo()==num)
                return i;
        
        return -1;
    }
    public String displayAllTicketes() {
        loadFromFile();
        
        String S = "\nAll tickets Data:\n";
        for (Ticket x : tickets) {
            S = S + x.toString();
        }
        return S;
    }
    /*public String displayAllEmployees() {
        loadFromFile();
        String S = "\nAll Courses Data:\n";
        for (Employee x : Employees) {
            S = S + x.toString();
        }
        return S;
    }*/
    
    public String searchTicket(int No){
        loadFromFile();
        int index = getTicketIndex(No);
        if(index != -1)
            return "\nFound ...!" + tickets.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    public void updateTicket(int No, Ticket x){
        loadFromFile();
        int index = getTicketIndex(No);
        tickets.set(index, x);
        commitToFile();
    } 
    
    public void deleteTicket(int No){
        loadFromFile();
        int index = getTicketIndex(No);
        tickets.remove(index);
        commitToFile();
    }
    private void loadFromFile() {
        try{
           
            tickets = (ArrayList<Ticket>) (Object) Data.read(Consts.TICKETS);
            
        }
        catch(Exception e)
        {
            Error.show(e);
        }
    }
    @Override
    public String toString() {
        return  this.no + "|" + this.seat_no + "|\n" ;
    }
}
    
