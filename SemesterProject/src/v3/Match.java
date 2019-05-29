
public class Match
{
   private String opponent;
   private int substitutePlayer;
   private String matchType;
   private Date date;
   private PlayerList players;

   public Match(String opponent, int substitutePlayer, String matchType)
   {
      this.opponent = opponent;
      this.matchType = matchType;
      this.substitutePlayer = substitutePlayer;
      this.date = null;
      this.players = null;
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
      if(isFriendly())
      {
      for(int i = 0; i < players.getNumOfPlayers();++i)
      {
         players.addPlayer(player);
      }
      }
      else if(isCup())
      {
         for(int i = 0; i <16;++i)
         {
            players.addPlayer(player);
         }
      }
      else if(isLeague())
      {
         for(int i = 0; i <15;++i)
         {
            players.addPlayer(player);
         }
      }
      else
      {
         
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
