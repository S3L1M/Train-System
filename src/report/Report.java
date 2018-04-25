/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author mina
 */
public class Report {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here        
        int  [] s={1,2,3};
      
        double[] values = new double[s.length];
        String[] names = new String[s.length];
        names[0]="one";
        names[1]="two";
        names[2]="three";
        
        for (int i = 0; i < s.length; i++) {
            values[i] =i+3;
       
            
        
        }
        /*        for (int i = 0; i < 25; i++) {

            names[i] = "Item " + i;
            if (i % 2 == 0) {
                values[i] = i * 5 + 1;
            } else {
                values[i] = i * 3 + 2;
            }
        }
         */
        BarChart chart = new BarChart(" Line Report ", names, values);

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }//GEN-LAST:event_menuReportActionPerformed

    }
    

