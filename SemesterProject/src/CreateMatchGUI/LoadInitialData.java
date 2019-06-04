import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A simple program used for importing data. It reads a text file with student
 * information, creates a StudentList object with all students read from the file, 
 * and saves it as a binary file. The text file must have information of one student
 * on each line, and each line should be in the format: firstName,lastName,country
 * @author group10
 * @version 1.0
 */
public class LoadInitialData
{
   public static void main(String[] args)
   {
     
      MatchList matches = new MatchList();

      MyTextFileIO mtfio = new MyTextFileIO();
      String[] playerArray = null; /*
      try
      {
         playerArray = mtfio.readArrayFromFile("players.txt");
                      
         for(int i = 0; i<playerArray.length; i++)
         {
            String temp = playerArray[i];
            String[] tempArr = temp.split(", ");
            String name = tempArr[0];
            int number = Integer.parseInt(tempArr[1]);
            String position = tempArr[2];
            String note = tempArr[3];

            players.addPlayer(new Player(name, number, position, note));
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File was not found, or could not be opened");
      }
     */
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
