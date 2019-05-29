import java.io.Serializable;

public class Match implements Serializable
{
   private String opponent;
   private int substitutePlayer;
   private String matchType;
   private Date date;
   private PlayerList players;

   private final int CUP = 16;
   private final int LEAGUE = 15;

   public Match(String opponent, int substitutePlayer, String matchType,
         Date date)
   {
      this.opponent = opponent;
      this.matchType = matchType;
      this.substitutePlayer = substitutePlayer;
      this.date = date;
      this.players = new PlayerList();
   }

   public void setSubstitutePlayer(int substitutePlayer)
   {
      this.substitutePlayer = substitutePlayer;
   }

   public void setOpponent(String opponent)
   {
      this.opponent = opponent;
   }

   public void setDate(Date date)
   {
      this.date = date;
   }

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

   public Player[] getMatchPlayerList()
   {
      return players.getAllPlayers();
   }

   public int getSubstitutePlayer()
   {
      return substitutePlayer;
   }

   public String getOpponent()
   {
      return opponent;
   }

   public String getMatchType()
   {
      return matchType;
   }

   public boolean isFriendly()
   {
      if (matchType.equals("Friendly") || matchType.equals("friendly"))
      {
         return true;
      }
      return false;
   }

   public boolean isCup()
   {
      if (matchType.equals("Cup") || matchType.equals("cup"))
      {
         return true;
      }
      return false;
   }

   public boolean isLeague()
   {
      if (matchType.equals("League") || matchType.equals("league"))
      {
         return true;
      }
      return false;
   }

   public String displayType()
   {
      if (isFriendly())
      {
         return "Friendly";
      }
      else if (isCup())
      {
         return "Cup";
      }
      else if (isLeague())
      {
         return "League";
      }
      return "Non-specified Match";
   }

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

   public String toString()
   {
      return opponent + " " + matchType + substitutePlayer + date;
   }

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
