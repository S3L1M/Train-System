package opnsrc.fcih.trainrsys.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
//import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// File Manager
public class Data {

    public static boolean write(String txt, String path, boolean append_tupe) {
        PrintWriter w = null;
        try {
            w = new PrintWriter(new FileWriter(new File(path), append_tupe));
            Encryptor enc = new Encryptor();
            txt = enc.encrypt(txt);
            w.println(txt);
            return true;
        } catch (IOException e) {
            Error.show(e);
        } finally {
            w.close();
        }
        return false;
    }

    public static void log(String oper, boolean isErr) {
        DateFormat dateFormat = new SimpleDateFormat("[yy/MM/dd - HH:mm:ss.SSSS] ");
        Date date = new Date();
        String e = new String();
        if (isErr) {
            e = dateFormat.format(date) + "[X] " + oper;
            System.err.println(e);
        } else {
            e = dateFormat.format(date) + oper;
            System.out.println(e);
        }
        // Log file is also encrypted
        write(e, "log.txt", true);
    }

    public static ArrayList<Object> read(String path) /*throws ParseException*/ {
        Scanner Reader = null;
        try {
            Data.log("Reading from " + path + " ...", false);
            Reader = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            Error.show(e);
        }
        
        Encryptor enc = new Encryptor();
        
        switch (path) {
            case Consts.ACCOUNTS:

            case Consts.EMPLOYEES:
                ArrayList<Employee> Employees = new ArrayList<Employee>();
                while (Reader.hasNext()) {
                    String Line = Reader.nextLine();
                    Line = enc.decrypt(Line);
                    String[] s = Line.split("/");
                    // UsrName | Name | Phone | Password | Gender | Date << FixError
                    //SimpleDateFormat sd =new SimpleDateFormat();
                    //12, "mia", true, "12345678", 01232
                    Employee e = new Employee(
                            Integer.parseInt(s[0]), s[1], (s[4]),
                            s[2],
                            Boolean.parseBoolean(s[3]), s[5], Integer.parseInt(s[6])
                    //  ,sd.parse(s[5])
                    );
                    System.out.println(s[0]);
                    Employees.add(e);
                }
                return (ArrayList<Object>) (Object) Employees;

            case Consts.TRAINS:
                ArrayList<Train> trains = new ArrayList<Train>();
                while (Reader.hasNext()) {
                    String Line = Reader.nextLine();
                    Line = enc.decrypt(Line);
                    String[] s = Line.split("/");
                    // TrainID | TrainName | Strat | End | LeavingTime | ArriveTime | Speed | Seat[10][8] (X)
                    Train tmp = new Train();
                    tmp.SetTrain_ID(Integer.parseInt(s[0]));
                    tmp.SetTrain_Name(s[1]);
                    tmp.SetArraive_Point(s[3]);
                    tmp.SetStart_Point(s[2]);
                    tmp.SetArriveTime(s[5]);
                    //System.out.println(s[5]);
                    tmp.SetLeavingTime_sPoint(s[4]);
                    tmp.SetSpeed(Integer.parseInt(s[6]));
                    trains.add(tmp);
                }
                return (ArrayList<Object>) (Object) trains;

            case Consts.TICKETS:
                ArrayList<Ticket> Tickets = new ArrayList<Ticket>();
                while (Reader.hasNext()) {
                    String Line = Reader.nextLine();
                    Line = enc.decrypt(Line);
                    String[] s = Line.split("/");
                    //System.out.println(s[0]);
                    Ticket t = new Ticket();
                    t.setNo(Integer.parseInt(s[0]));
                    t.setSeat_no(Integer.parseInt(s[1]));
                    //t.getQR_code();
                    Tickets.add(t);
                }
                return (ArrayList<Object>) (Object) Tickets;

            case Consts.REPORT:
            // int[6] line1 - 6

        }
        return null;
    }

}
