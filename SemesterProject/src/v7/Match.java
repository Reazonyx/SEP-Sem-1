import java.io.Serializable;

/**
 * A class representing the match, opponent, date, which players are going to play and which are substitue players.
 * @author krogh
 * @version 
 */

public class Match implements Serializable
{
   private String opponent;
   private int substitutePlayer;
   private String matchType;
   private Date date;
   private PlayerList players;

   private final int CUP = 16;
   private final int LEAGUE = 15;
   
   /**
    * Four-argument constructor.
    * @param opponent the Match's opponent.
    * @param substitutePlayer the Match's substitute players.
    * @param matchType the Match's match type.
    * @param date the Match's date.
    */

   public Match(String opponent, int substitutePlayer, String matchType,
         Date date)
   {
      this.opponent = opponent;
      this.matchType = matchType;
      this.substitutePlayer = substitutePlayer;
      this.date = date;
      this.players = new PlayerList();
   }
   
   /**
    * Sets an integer of the substitue players for the Match.
    * @param substitutePlayer what the Match's substitute players will be set to.
    */

   public void setSubstitutePlayer(int substitutePlayer)
   {
      this.substitutePlayer = substitutePlayer;
   }
   
   /**
    * Sets a String of the Match's opponent.
    * @param opponent what the Match's opponent will be set to.
    */

   public void setOpponent(String opponent)
   {
      this.opponent = opponent;
   }
   
   /**
    * Sets the date for the Match
    * @param date what the date and time of the Date object will be set to.
    */

   public void setDate(Date date)
   {
      this.date = date;
   }
   
   /**
    * Sets a Player object if players does not contain a player.
    * @param player the player details of the Player object.
    * @param players consist of object Playerlist. 
    * @param isFriendly add Player objcets to the PlayerList.
    * @param isCup add Player objcets to the PlayerList, if PlayerList consist of 16 or less Player objects.
    * @param isLeague add Player objcets to the PlayerList, if PlayerList consist of 15 or less Player objects.
    */

   public void setPLayers(Player player)
   {
      if (!players.contains(player))
      {

         if (isFriendly())
         {
               players.addPlayer(player);
         }
         else if (isCup())
         {
            if (players.getNumOfPlayers() < CUP)
            {
               players.addPlayer(player);
            }
         }
         else if (isLeague())
         {
            if (players.getNumOfPlayers() < LEAGUE)
            {
               players.addPlayer(player);
            }
         }
         else
         {

         }
      }
   }
   
   /**
    * Creates an Player object array.
    * @return all players from the PlayerList object to array. 
    */

   public Player[] getMatchPlayerList()
   {
      return players.getAllPlayers();
   }
   
   /**
    * Gets the number of substitute players.
    * @return integers of Match's substitute players.
    */

   public int getSubstitutePlayer()
   {
      return substitutePlayer;
   }
   
   /**
    * Gets the Match's opponent.
    * @return String of Match's opponent.
    */

   public String getOpponent()
   {
      return opponent;
   }
   
   /**
    * Gets the Match's match type.
    * @return String of Match's match type.
    */

   public String getMatchType()
   {
      return matchType;
   }
   
   /**
    * Checks which match type is selected.
    * @return true if Friendly is selected, otherwise false.
    */

   public boolean isFriendly()
   {
      if (matchType.equals("Friendly"))
      {
         return true;
      }
      return false;
   }
   
   /**
    * Checks which match type is selected.
    * @return true if Cup is selected, otherwise false.
    */

   public boolean isCup()
   {
      if (matchType.equals("Cup"))
      {
         return true;
      }
      return false;
   }
   
   /**
    * Checks which match type is selected.
    * @return true if League is selected, otherwise false.
    */

   public boolean isLeague()
   {
      if (matchType.equals("League"))
      {
         return true;
      }
      return false;
   }
   
   /**
    * Gets the number of substitute players that are in the Match.
    * @return the number of substitute players, otherwise -1.
    */

   public int numOfSubPlayers()
   {

      if (isCup())
      {
         if (substitutePlayer <= 5)
         {
            return substitutePlayer;
         }
         return substitutePlayer = -1;
      }
      else if (isLeague())
      {
         if (substitutePlayer <= 4)
         {
            return substitutePlayer;
         }
         return substitutePlayer = -1;
      }
      else if (isFriendly())
      {
         return substitutePlayer;
      }
      return substitutePlayer = -1;
   }
   
   /**
    * Gets a String representation of the Match
    * @return a String representation of the Match in the format: "opponent match type substitutePlayer date"
    */

   public String toString()
   {
      return opponent + " " + matchType + " " + substitutePlayer + " " + date;
   }
   
   /**
    * Compares opponent, matchType, substitutePlayer and date of two Match's
    * @param boolean returns true if the obj argument is equal(an instance of) to Object, otherwise false.
    * @param obj the object which is refered to comparing.
    * @return true if the given objects is equal to this Date.
    */

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Match))
      {
         return false;
      }

      Match other = (Match) obj;

      return opponent.equals(other.opponent)
            && matchType.equals(other.matchType)
            && substitutePlayer == other.substitutePlayer
            && date.equals(other.date);
   }
}
