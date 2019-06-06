import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Adapter for MathList
 * @author group 10
 *
 */
public class MatchListFileAdapter
{
   private MyFileIO mfio;
   private String fileName;

   /**
    * 1-argument constructor setting the file name.
    * @param fileName the name and path of the file where students will be saved and retrieved
    */
   public MatchListFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }
 
   
   
   
   /**
    * Uses the MyFileIO class to retrieve a StudentList object with all Students.
    * @return a StudentList object with all stored students
    */
   public MatchList getAllMatches()
   {
      MatchList matches = new MatchList();

      try
      {
         matches = (MatchList)mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return matches;
   }

   /**
    * Use the MyFileIO class to retrieve all students from a given country.
    * @param fromCountry the country to retrieve students from
    * @return a StudentList object with students from the given country
    */
   public MatchList getMatchesFrom(String fromOppo)
   {
      MatchList matches = new MatchList();

      try
      {
         MatchList result = (MatchList)mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.getNumOfMatches(); i++)
         {
            if (result.getMatch(i).getOpponent().equals(fromOppo))
            {
               matches.addMatch(result.getMatch(i));
            }
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }

      return matches;
   }

   /**
    * Use the MyFileIO class to save some students.
    * @param students the list of students that will be saved
    */
   public void saveStudents(MatchList students)
   {
      try
      {
         mfio.writeToFile(fileName, students);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }
 
}


