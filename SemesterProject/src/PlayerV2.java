
public class PlayerV2
{
   private int number;
   private String position;
   private String name;
   private String note;

   public PlayerV2(int number, String position, String name, String note)
   {
      this.number = number;
      this.position = position;
      this.name = name;
      this.note = note;
   }

   public void setPlayer(String name, String position, int number)
   {
      this.name = name;
      this.position = position;
      this.number = number;
   }

   public String getName()
   {
      return name;
   }

   public int getNumber()
   {
      return number;
   }

   public String getPosition()
   {
      return position;
   }

   public String getNote()
   {
      return note;
   }

   public void removeNote(String note)
   {
      this.note = "";
   }

   public String toString()
   {
      return "" + name + position + number + note;
   }

   public PlayerV2 copy()
   {
      return new PlayerV2(number, position, name, note);
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof PlayerV2))
      {
         return false;
      }
      else
      {
         PlayerV2 other = (PlayerV2) obj;
         boolean b = number == other.number && position.equals(other.position)
               && name.equals(other.name) && note.equals(other.note);
         return b;
      }
   }

}
