/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendingemail;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import java.io.FileOutputStream;
import java.util.Date;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Writeinpdf {
    
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
    /*Hena ana ba3rf catFont we subfont kano3 font ely howa times_roman we badelo font style */

    public static void Writeinpdff(String Name,String Phone,String NumofSeat,String Dest) {
         String FILE = Name+".pdf";//hena el file path
        try {
            Document document = new Document();
            /*Hena ba3mel object mn el class Doucnment el howa builtIn by7towee 3ala 7agat kter awe masln zy el margin left 
            ,right,top,bottom we Kaman 3add el chapter we 3add el saf7at  */
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            //deh zy write fe el file bta5od el doucmnet we el file path 
            document.open();
            addMetaData(document);
        //deh 3ashn a7ot meta data le pdf
            addTitlePage(document);
            addContent(document,Name,Phone,NumofSeat,Dest);
           //add contant to pdf
            document.close();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
   
    private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("mina");
        document.addCreator("mina");
    }
    /*Hena bn3mel meta data ll pdf */

    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        
        document.add(preface);
        // Start a new page
        
    }

    private static void addContent(Document document, String Name,  String  Phone,String NumofSeat,String Dest) throws DocumentException, WriterException, IOException, IOException, IOException, NotFoundException {
        
       
          QRcode x=new QRcode();
        x.QR(Name,Phone);
          //x.wr
        // Second parameter is the number of the chapter
      //  Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph p = new Paragraph("", subFont);
      //  Section subCatPart = catPart.addSection(subPara);
   
        // add a table
        createTable(p,
                Dest,NumofSeat,Name);

        // now add all this to the document
       

        // now add all this to the document
        document.add(p);

    }

    private static void createTable(Paragraph subCatPart,String Dest, String NumofSeat, String Name) throws BadElementException {
        try {
            PdfPTable table = new PdfPTable(2);
            /*hena bn3mel table we bndelo rakm el cells*/
            PdfPCell c1 = new PdfPCell(new Phrase("\n"+"\n"+"\n"+"\n"+"Your Destination is:"+Dest+" "+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"your seat:"+NumofSeat+""));
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(c1);
            /*hena bn7ot el 7aga elyy 3ayzneha fe cell one*/
            
            Image img = Image.getInstance( Name+".png");
            
            table.addCell(img);
            
            
            
            c1 = new PdfPCell(new Phrase("TrainRSys@gmail.com"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);
            
            table.addCell("@AllCopyRight");
            
            subCatPart.add(table);
        } catch ( IOException ex) {
            Logger.getLogger(Writeinpdf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
    

