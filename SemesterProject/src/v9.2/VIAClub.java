import java.util.ArrayList;

/**
 * A class holds match and player lists
 * @author Smilte
 * @version
 */
public class VIAClub
{
   private MatchList matches;
   private PlayerList players;

   /**
    * Sets the match
    * @param match what the Match's match will be set to
    */
   public void setMatch(Match match)
   {
      matches.addMatch(match);
   }
   
   /**
    * A method which sets players for match
    * @param match is match will be set to
    * @param players ?????
    * @param player adds to match
    */
   public void setPlayersForMatch(Match match, PlayerList players, Player player)
   {
      match.setPLayers(player);
   }
   
   /**
    * A method which removes match
    * @param match what the Match's will be removed
    */
   public void removeMatch(Match match)
   {
      matches.removeMatch(match);
   }
}