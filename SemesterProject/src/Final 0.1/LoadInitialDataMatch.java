import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A simple program used for importing data. It reads a text file with student
 * information, creates a StudentList object with all students read from the
 * file, and saves it as a binary file. The text file must have information of
 * one student on each line, and each line should be in the format:
 * firstName,lastName,country
 * 
 * @author Allan Henriksen
 * @version 1.0
 */
public class LoadInitialDataMatch
{
   public static void main(String[] args)
   {

      MatchList matches = new MatchList();
      
      MyFileIO mfio = new MyFileIO();

      try
      {
         mfio.writeToFile("matches.bin", matches);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Error opening file ");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file ");
      }

      System.out.println("Done");
   }
}
