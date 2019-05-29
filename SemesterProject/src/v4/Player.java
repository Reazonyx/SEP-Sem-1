import java.io.Serializable;

public class Player implements Serializable
{
   private int number;
   private String position;
   private String name;
   private String note;

   public Player(int number, String position, String name, String note)
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

   public Player copy()
   {
      return new Player(number, position, name, note);
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Player))
      {
         return false;
      }
      else
      {
         Player other = (Player) obj;
         boolean b = number == other.number && position.equals(other.position)
               && name.equals(other.name) && note.equals(other.note);
         return b;
      }
   }

}
