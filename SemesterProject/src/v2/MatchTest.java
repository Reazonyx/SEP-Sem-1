
public class MatchTestV2
{

   public static void main(String[] args)
   {
      DateV2 d1 = new DateV2(25,25,25,25,25);
      MatchListV2 ml1 = new MatchListV2();
      MatchV2 m1 = new MatchV2("Romans", 8, "Cup");
      m1.setDate(d1);
      ml1.addMatch(m1);
      
      System.out.println(m1.toString());
   }

}
