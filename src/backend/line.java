/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opnsrc.fcih.trainrsys.backend;

import java.io.*;
import java.util.ArrayList;


/**
 *
 * @author h
 */
public class line {
    public static ArrayList<line> lines = new ArrayList<line>();
    public line()
    {
        
    }
    
    public line(String linename)
    {
        this.linename=linename;
        
        
    }
    public line(String linename,int nofpass)
    {
        this.linename=linename;
        
        this.no_ofpass=nofpass;
    }
    String linename ;
    int no_ofpass;
    public void setlinename(String linename)
    {
     this.linename=linename;   
    }
    public void setno_ofpass(int no_ofpass)
    {
        this.no_ofpass=no_ofpass;
    }
    public String  Getlinename()
            {
                return this.linename;
                
            }
    public int  Getno_ofpass()
    {
        return this.no_ofpass;
    }
        
        public String getlinedata()
        {
            return this.linename +"/"+this.no_ofpass;
        }
        public String getlinedatafirstone(String linename)
        {
            return (this.linename=linename) +"/"+(this.no_ofpass=1);
        }

    public void WriteLine(String linename)
            {
                Data.write(linename, Consts.REPORT , true);
            }
    public int[] getreporet()
    {
        int arr[]={0,0,0,0};
        loadFromFile();
        for (int i = 0; i < lines.size(); i++)
        {
            if("line1".equals(lines.get(i).Getlinename()))
                arr[0]++;
            if("line2".equals(lines.get(i).Getlinename()))
                arr[1]++;
            if("line3".equals(lines.get(i).Getlinename()))
                arr[2]++;
             if("line4".equals(lines.get(i).Getlinename()))
                arr[3]++;
        }
        return arr;
    }
    private void loadFromFile()
    {
        lines = (ArrayList<line>) (Object) Data.read(Consts.REPORT);
    }
            }
    

