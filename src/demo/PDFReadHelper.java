package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFReadHelper {
	   	PDFParser parser;
	    public String PDFText;
	    PDFTextStripper pdfStripper;
	    PDDocument pdDoc;
	    COSDocument cosDoc;
	    PDDocumentInformation pdDocInfo;
	    String fileName;
	    public PDFReadHelper(String fileName)
	    {
	    	this.fileName = fileName;
	    	pdftoText();
	    }
	    public PDFReadHelper(String fileName, String outputFileName)
	    {
	    	this.fileName = fileName;
	    	writePDFtoFile(outputFileName,fileName);
	    }
	    public PDFReadHelper(String fileName, int pageNumber)
	    {
	    	this.fileName = fileName;
	    	getPDFPage(fileName, pageNumber);
	    }
	    private void getPDFPage(String fileName,
				int pageNumber) {
	    	 System.out.println("Parsing text from PDF file " + fileName + "....");
	         File f = new File(fileName);
	   
	         if (!f.isFile()) {
	             System.out.println("File " + fileName + " does not exist.");
	             return ;
	         }
	   
	         try {
	             parser = new PDFParser(new FileInputStream(f));
	         } catch (Exception e) {
	             System.out.println("Unable to open PDF Parser.");
	             return ;
	         }
	         try
	         {
	         parser.parse();
             cosDoc = parser.getDocument();
	         } catch (Exception e) {
	             System.out.println("An exception occured in parsing the PDF Document.");
	             e.printStackTrace();
	             try {
	                    if (cosDoc != null) cosDoc.close();
	                    if (pdDoc != null) pdDoc.close();
	                } catch (Exception e1) {
	                e.printStackTrace();
	             }
	         }
			try {
	    	PDFTextStripper reader;
	 		reader = new PDFTextStripper();
			reader.setStartPage(pageNumber);
	    	reader.setEndPage(pageNumber);
	    	pdDoc = new PDDocument(cosDoc);
	    	PDFText = reader.getText(pdDoc);
	    	} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		private String pdftoText() {
   
	         System.out.println("Parsing text from PDF file " + fileName + "....");
	         File f = new File(fileName);
	   
	         if (!f.isFile()) {
	             System.out.println("File " + fileName + " does not exist.");
	             return null;
	         }
	   
	         try {
	             parser = new PDFParser(new FileInputStream(f));
	         } catch (Exception e) {
	             System.out.println("Unable to open PDF Parser.");
	             return null;
	         }
	   
	         try {
	             parser.parse();
	             cosDoc = parser.getDocument();
	             pdfStripper = new PDFTextStripper();
	             pdDoc = new PDDocument(cosDoc);
	             PDFText = pdfStripper.getText(pdDoc);
	         } catch (Exception e) {
	             System.out.println("An exception occured in parsing the PDF Document.");
	             e.printStackTrace();
	             try {
	                    if (cosDoc != null) cosDoc.close();
	                    if (pdDoc != null) pdDoc.close();
	                } catch (Exception e1) {
	                e.printStackTrace();
	             }
	             return null;
	         }
	        System.out.println("Done.");
	         return PDFText;
	     }
	

	      private void writePDFtoFile(String fileName,String pdfText ) {
	   
	         System.out.println("\nWriting PDF text to output text file " + pdfText + "....");
	         try {
	             PrintWriter pw = new PrintWriter(fileName);
	             pw.print(pdfText);
	             pw.close();  
	         } catch (Exception e) {
	             System.out.println("An exception occured in writing the pdf text to file.");
	             e.printStackTrace();
	         }
	         System.out.println("Done.");
	     }
	public static void main(String[] args) {
		
		PDFReadHelper pdfread = new PDFReadHelper("C:\\Users\\IBM_ADMIN\\Downloads\\WST report 10-30.pdf");
		System.out.println(pdfread.PDFText);
	}

}
