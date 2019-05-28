
public class MatchV2
{
   private String opponent;
   private int substitutePlayer;
   private String matchType;
   private DateV2 date;

   public MatchV2(String opponent, int substitutePlayer, String matchType)
   {
      this.opponent = opponent;
      this.matchType = matchType;
      this.substitutePlayer = substitutePlayer;
      this.date = null;
   }

   public void setSubstitutePlayer(int substitutePlayer)
   {
      this.substitutePlayer = substitutePlayer;
   }

   public void setOpponent(String opponent)
   {
      this.opponent = opponent;
   }

   public void setDate(DateV2 date)
   {
      this.date = date;
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

   public int numOfsubPlayers()
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
      if (!(obj instanceof MatchV2))
      {
         return false;
      }

      MatchV2 other = (MatchV2) obj;

      return opponent.equals(other.opponent)
            && matchType.equals(other.matchType)
            && substitutePlayer == other.substitutePlayer
            && date.equals(other.date);
   }
}
