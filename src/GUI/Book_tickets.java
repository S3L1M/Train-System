/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import train_system.employee;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import opnsrc.fcih.trainrsys.backend.Ticket;
import sendingemail.SendingEmail;
import sendingemail.*;
/**
 *
 * @author keroles samer
 */
public class Book_tickets extends javax.swing.JFrame {

    /**
     * Creates new form Book_tickets
     */
    Ticket t;
    ArrayList<JLabel> seats ;
    public Book_tickets() {
        setExtendedState(emolyee.MAXIMIZED_HORIZ);
        setResizable(false);
        initComponents();
        sendSms.setEnabled(false);
        sendmail.setEnabled(false);
        printt.setEnabled(false);
        t=new Ticket();
        seats =new ArrayList<>();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Num = new javax.swing.JComboBox<>();
        cheak_num = new javax.swing.JLabel();
        jreserve = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jemailtext = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        sendSms = new javax.swing.JButton();
        sendmail = new javax.swing.JButton();
        printt = new javax.swing.JButton();
        jname = new javax.swing.JLabel();
        jemail = new javax.swing.JLabel();
        jphone = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jerrorlabel = new javax.swing.JLabel();
        jtrip = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 204, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Num.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Num.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "num 1", "num 2", "num 3", "num 4" }));
        Num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumActionPerformed(evt);
            }
        });
        getContentPane().add(Num, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        cheak_num.setBackground(new java.awt.Color(248, 149, 32));
        cheak_num.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cheak_num.setForeground(new java.awt.Color(248, 149, 32));
        cheak_num.setText("cart num");
        getContentPane().add(cheak_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 78, 20));

        jreserve.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jreserve.setText("reserve");
        jreserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jreserveActionPerformed(evt);
            }
        });
        getContentPane().add(jreserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 91, 40));

        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 251, 30));

        jemailtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jemailtextActionPerformed(evt);
            }
        });
        getContentPane().add(jemailtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 251, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 251, 30));

        jLabel3.setFont(new java.awt.Font("MV Boli", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(248, 149, 32));
        jLabel3.setText("Passanger");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 160, 50));

        jButton1.setText("9");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, 45, -1));

        jButton2.setText("7");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 46, -1));

        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 45, -1));

        jButton4.setText("1");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 45, -1));

        jButton5.setText("5");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 44, -1));

        jButton6.setText("10");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 45, -1));

        jButton7.setText("8");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 46, -1));

        jButton8.setText("4");
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 45, -1));

        jButton9.setText("2");
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 45, -1));

        jButton10.setText("6");
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 44, -1));

        sendSms.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        sendSms.setText("send SMS");
        sendSms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendSmsActionPerformed(evt);
            }
        });
        getContentPane().add(sendSms, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 550, -1, 30));

        sendmail.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        sendmail.setText("sendE-Mail");
        sendmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendmailActionPerformed(evt);
            }
        });
        getContentPane().add(sendmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 550, -1, 30));

        printt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        printt.setText("print");
        printt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printtActionPerformed(evt);
            }
        });
        getContentPane().add(printt, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, 60, 30));

        jname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jname.setForeground(new java.awt.Color(248, 149, 32));
        jname.setText("Name");
        getContentPane().add(jname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 40, 20));

        jemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jemail.setForeground(new java.awt.Color(248, 149, 32));
        jemail.setText("Email");
        getContentPane().add(jemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 40, 20));

        jphone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jphone.setForeground(new java.awt.Color(248, 149, 32));
        jphone.setText("number");
        getContentPane().add(jphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, 20));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 130, -1));
        getContentPane().add(jerrorlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 74, 240, 30));

        jtrip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALEX_CAIRO", "CAIRO_ASWAN", "ALEX_MATROUH", "CAIRO_MATROUH", "ALEX_ASWAN", "MATROUH_ASWAN" }));
        getContentPane().add(jtrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 250, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 149, 32));
        jLabel1.setText("trip");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 50, 20));

        jLabel6.setForeground(new java.awt.Color(248, 149, 32));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logiiiin.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 910, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jemailtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jemailtextActionPerformed
       if (!jemailtext.getText().contains("@") || !jemailtext.getText().contains(".")){
           jerrorlabel.setText("un valid email");
       } 
       else{
           
       }
    }//GEN-LAST:event_jemailtextActionPerformed

    private void NumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumActionPerformed

    private void jreserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jreserveActionPerformed
        // TODO add your handling code here:
         sendSms.setEnabled(true);
        sendmail.setEnabled(true);
        printt.setEnabled(true);
    }//GEN-LAST:event_jreserveActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void printtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printtActionPerformed
        // TODO add your handling code here:
        OpenPdf e=new OpenPdf();
        e.open(jTextPane1.getText());
    }//GEN-LAST:event_printtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void sendmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendmailActionPerformed
        // TODO add your handling code here:
        String noseat="";
        SendingEmail x=new SendingEmail();
        x.Sending(
        jemail.getText(),
        jname.getText(), 
        jphone.getText(),
        noseat, jtrip.getItemAt(WIDTH));
    }//GEN-LAST:event_sendmailActionPerformed

    private void sendSmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendSmsActionPerformed
        // TODO add your handling code here:
       Sms x=new Sms();
        try {
            x.sendSMS(jphone.getText());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Book_tickets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Book_tickets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendSmsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Book_tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book_tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book_tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book_tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book_tickets().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Num;
    private javax.swing.JLabel cheak_num;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel jemail;
    private javax.swing.JTextField jemailtext;
    private javax.swing.JLabel jerrorlabel;
    private javax.swing.JLabel jname;
    private javax.swing.JLabel jphone;
    private javax.swing.JButton jreserve;
    private javax.swing.JComboBox<String> jtrip;
    private javax.swing.JButton printt;
    private javax.swing.JButton sendSms;
    private javax.swing.JButton sendmail;
    // End of variables declaration//GEN-END:variables
}
