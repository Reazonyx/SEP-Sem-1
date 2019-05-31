


public class VIAClub
{
   private MatchList matches;
   private PlayerList players;

   public void setMatch(Match match)
   {
      matches.addMatch(match);
   }
   
   public void setPlayersForMatch(Match match, PlayerList players, Player player)
   {
      match.setPLayers(player);
   }
   
   public void removeMatch(Match match)
   {
      matches.removeMatch(match);
   }
   public Date getDate(int index) {
      return matches.getMatch(index).getDate();
   }
   
   public String getOpponent(int index) {
      return matches.getMatch(index).getOpponent();
   }
   
   public String getType(int index) {
      return matches.getMatch(index).getMatchType();
   }
   
   public int getSubstitute(int index) {
      return matches.getMatch(index).getSubstitutePlayer();
   }
   
   public boolean isBefore(int index) {
      return matches.getMatch(index).getDate().isBefore();
   }
   public boolean ifRelevant(int index) {
     if(!(isBefore(index))) {
         return true;
      }
      else {
         return false;
      }
   }
   
   public  String getPlayerName(int index) {
      index = matches.getSize();
      return players.getPlayer(index).getName();
   }
   
   public  String getPlayerPosition(int index) {
      index = matches.getSize();
      return players.getPlayer(index).getPosition();
   }
   
   public  int getPlayerNumber(int index) {
      index = matches.getSize();
      return players.getPlayer(index).getNumber();
   }
   
   public  String getPlayerNote(int index) {
      index = matches.getSize();
      return players.getPlayer(index).getNote();
   }
}
