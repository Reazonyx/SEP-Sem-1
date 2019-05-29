import java.util.ArrayList;

public class VIAClub
{
   private MatchList matches;
   private PlayerList players;

   public void setMatch(Match match)
   {
      matches.addMatch(match);
   }
   
   public void setPlayersForMatch(Match match, PlayerList players,
         Player player)
   {
      match.setPLayers(player);
   }
   
   public void removeMatch(Match match)
   {
      matches.removeMatch(match);
   }
   
   
}
