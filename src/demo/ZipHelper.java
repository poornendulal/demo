package demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ZipHelper {
public NodeList nodeList;
private ZipFile zf;
    public static void main(String[] args) {
        String zipFilePath = "c:\\file.zip";
        
        String destDir = "C:\\file";
        new ZipHelper().readZipFiles(zipFilePath);
        //unzip(zipFilePath, destDir);
    }
    public void readZipFiles(String filename)
    {
        try
        {
        	 zf = new ZipFile(filename);
           for (Enumeration<? extends ZipEntry> e = zf.entries();
                 e.hasMoreElements();) {
             ZipEntry ze = e.nextElement();
             String name = ze.getName();
             if (name.endsWith(".xml")) {
               InputStream in = zf.getInputStream(ze);
               DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
               DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
               Document doc = dbuilder.parse(in);
               XPath xPath = XPathFactory.newInstance().newXPath();
               nodeList = (NodeList) xPath.compile("/CATALOG/CD[PRICE>10]").evaluate(doc, XPathConstants.NODESET);
               for (int i = 0; i<nodeList.getLength();i++)
               {
               	System.out.println(nodeList.item(i).getTextContent());
               }
             }
             }zf.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}