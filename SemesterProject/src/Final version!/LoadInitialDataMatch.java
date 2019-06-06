import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A simple program used for creating binary file. 
 * Creates a MatchList object which saves it as a binary file. 
 * 
 * @author group 10
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
