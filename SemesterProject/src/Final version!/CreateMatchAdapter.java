import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Class adapter for Create match
 * @author Group 10
 *
 */
public class CreateMatchAdapter
{
   private MyFileIO mfio;
   private String fileName;
   
   /**
    * Constructor for CreateMatchAdapter
    * @param filename 
    */
  
   public CreateMatchAdapter(String filename)
   {
      mfio = new MyFileIO();
      this.fileName = filename;
   }
   
   /**
    * Uses the MyFileIO class to retrieve a PlayerList object with all Players.
    * @return a PlayerList object with all stored players
    */
   public PlayerList getAllPlayers()
   {
      PlayerList players = new PlayerList();
      
      try
      {
         players = (PlayerList)mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch(IOException e)
      {
         System.out.println("IO error reading file");
      }
      catch(ClassNotFoundException e)
      {
         System.out.println("Class not found");
      }
      
      return players;
   }
   
   /**
    * Use the MyFileIO class to save match.
    * @param match will be saved
    */

   public void saveMatch(Match match)
   {
      try
      {
         MatchList l = (MatchList)mfio.readObjectFromFile(fileName);
         l.addMatch(match);
         mfio.writeToFile(fileName, l);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
      catch (ClassNotFoundException e)
      {
         e.printStackTrace();
      }
   }
   /**
    * saves playerlist with the players to file
    * @param playerList 
    */

   public void savePlayers(PlayerList playerList)
   {
      try
      {
         mfio.writeToFile(fileName, playerList);
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
