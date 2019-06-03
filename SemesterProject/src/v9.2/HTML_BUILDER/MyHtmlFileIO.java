package HTML_BUILDER;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class responsible for reading and writing html files.
 * @author Smilte
 * @version 1.0 
 */
public class MyHtmlFileIO
{
	//HTML template name and path to it
	private final String TEMPLATE_NAME = "PrintMatch.html";
	
   /**
   * Writes the given string to a file with the given file name.
   * @param fileName the name and path of the file to write to
   * @param replaceFrom replacement key
   * @param replaceTo replacement of the key
   * @throws FileNotFoundException if the file with fileName is not found
   */
   public void writeToFile(String fileName, String replaceFrom, String replaceTo) throws FileNotFoundException
   {
	   //reading the HTML template
	   String htmlTemplate = readHtmlTemplateContents(TEMPLATE_NAME);
	   //inserting table contents and generating the file
	   write(fileName, htmlTemplate.replace(replaceFrom, replaceTo));
   }
   
   /**
    * Writes content to a file specified
    * @param fileName name of the output file
    * @param str content for the file
    * @throws FileNotFoundException
    */
   private void write(String fileName, String str) throws FileNotFoundException
   {
      PrintWriter writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName, false);
         writeToFile = new PrintWriter(fileOutStream);
         writeToFile.println(str);
      }
      finally
      {
         if (writeToFile != null)
         {
            writeToFile.close();
         }
      }
   }

   /**
    * Reads the content from the HTML template file with the given file name.
    * @param fileName the name and path of the file that is read
    * @return a String containing the content read from the file
    * @throws FileNotFoundException if the file with fileName is not found
    */
   public String readHtmlTemplateContents(String fileName) throws FileNotFoundException
   {
      Scanner readFromFile = null;
      String htmlContent = "";
  
      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new Scanner(fileInStream);

         while (readFromFile.hasNext())
         {
            htmlContent += readFromFile.nextLine();
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            readFromFile.close();
         }
      }
      
      return htmlContent;
   }
}