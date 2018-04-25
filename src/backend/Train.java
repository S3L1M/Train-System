// Decide, Understand
package opnsrc.fcih.trainrsys.backend;

import java.sql.Time;
import java.util.ArrayList;

public class Train {
        
    public Train() {
        this.speed=80;
    }

    public Train(int Train_ID, String Train_Name, String Start_Point, String Arraive_Point, Time LeavingTime_sPoint, Time ArriveTime, int speed) {
        this.Train_ID = Train_ID;
        this.Train_Name = Train_Name;
        this.Start_Point = Start_Point;
        this.Arraive_Point = Arraive_Point;
        this.LeavingTime_sPoint = LeavingTime_sPoint+"";
        this.ArriveTime = ArriveTime+"";
        this.speed = speed;
    }
    
    protected int Train_ID;
    protected String Train_Name;
    protected String Start_Point;
    protected String Arraive_Point;
    protected String LeavingTime_sPoint;
    protected String ArriveTime;
    protected int speed;
    protected Seat seats[][] = new Seat[10][8];
// Understand ArrayList
    public static ArrayList<Train> Trains = new ArrayList<Train>();
    // WHY >> FileManger FM=new FileManger();
    private final String TrainFileName = "Train.txt";
    Seat O_Seat;

  public  void SetTrain_ID(int Train_ID)
    {
        this.Train_ID=Train_ID;
    }
   public int GetTrain_ID()
    {
        return this.Train_ID;
    }
   public void SetTrain_Name(String Train_Name)
    {
        this.Train_Name=Train_Name;
    }
  public  String GetTrain_Name()
    {
        return this.Train_Name;
    }
  public  void SetStart_Point(String Start_Point)
    {
        this.Start_Point=Start_Point;
    }
  public  String GetStart_Point()
    {
        return this.Start_Point;
    }
  public  void SetArraive_Point(String Arraive_Point)
    {
        this.Arraive_Point=Arraive_Point;
    }
   public String GetArraive_Point()
    {
        return this.Arraive_Point;
    }
  public  void SetLeavingTime_sPoint(String LeavingTime_sPoint)
    {
        this.LeavingTime_sPoint=LeavingTime_sPoint;
    }
  public  String GetLeavingTime_sPoint()
    {
        return this.LeavingTime_sPoint;
    }
    
  public   void SetArriveTime(String ArriveTime)
    {
        this.ArriveTime=ArriveTime+"";
    }
  public  String GetArriveTime()
    {
        return this.ArriveTime;
    }
   public void SetSpeed(int Speed)
    {
        this.speed=Speed;
    }
   public int GetSpeed()
    {
        return this.speed;
    }
    private String getTrainData() {
        return this.Train_ID + "/" + this.Train_Name + "/" + this.Start_Point + "/"+this.Arraive_Point+"/" + this.LeavingTime_sPoint + "/" + this.ArriveTime + "/" + this.speed  ;
    }
    public boolean AddTrain() {
        return Data.write(this.getTrainData(), TrainFileName,true);
    }
    private int search(int Train_ID)
    //if train found return index of train in arraylist else return -1
    {
        for (int i = 0; i < Trains.size(); i++)
            if(Trains.get(i).GetTrain_ID()== Train_ID)
                return i;
        return -1;
    }
    
    private void loadFromFile() {
        try{
        Trains = (ArrayList<Train>) (Object) Data.read(TrainFileName);
        }
        catch(Exception e)
        {
            Error.show(e);
        }
    }
    private void commitToFile() {
        // Decide -> Data.write(Trains.get(0).getTrainData(), TrainFileName, false);
        for (int i = 0; i < Trains.size(); i++) {
            boolean appendtype;
            if(i==0){
            appendtype =false;
            }
            else{
            appendtype=true;
            }
            Data.write(Trains.get(i).getTrainData(), TrainFileName,appendtype);
        }
    }

    public boolean deleteTrain(int Train_ID) {
        loadFromFile();
        int index = search(Train_ID);
        if(index !=-1){
        Trains.remove(index);
        commitToFile();
        return true;
        }
        else 
            return false;
        }
    public ArrayList<Train> listTrains() {
        loadFromFile();
        return Trains;
    }
    public String displayAllTrains() {
        loadFromFile();
        String S = "\nAll Train Data:\n";
        for (Train train : Trains) {
            S = S + train.toString();
        }
        return S;
    }
    private int getTrainIndex(int num){
        for (int i = 0; i < Trains.size(); i++)
            if(Trains.get(i).GetTrain_ID()==num)
                return i;
        return -1;
    }
    public boolean updateTrain(int id, Train ValueOfTrain) {
    loadFromFile();
    
        int index = getTrainIndex(id); 
        if(index != -1){
            
            Trains.set(index, ValueOfTrain);
            
            
            commitToFile();
            return true;
        }
        return false;
    }
    //Integer.parseInt(s[0]),s[1],s[2],s[3],Time.valueOf(s[4]),Time.valueOf(s[5]),Integer.parseInt(s[6])
    @Override
    public String toString(){
        return "train id"+this.Train_ID+ "\ntrain name " +this.Train_Name +"\ntrain start point "+this.Start_Point +"\ntrain arraive point "+this.Arraive_Point+"\nleving time" +this.LeavingTime_sPoint +"\narrive time "+this.ArriveTime +"\nspeed "+this.speed+"\n";
    }

}
