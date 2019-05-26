
public class PlayerV1
{
   private int number;
   private String position;
   private String name;
   private NoteV1 note;

   public PlayerV1(int number, String position, String name)
   {
      this.name = name;
      this.number = number;
      this.position = position;
      this.note = null;
   }

   public void setPlayer(int number, String position, String name)
   {
      this.name = name;
      this.number = number;
      this.position = position;
   }

   public int getNumber()
   {
      return number;
   }

   public String getPosition()
   {
      return position;
   }

   public String getName()
   {
      return name;
   }

   public void addNotToPlayer(NoteV1 note)
   {
      this.note = note;
   }

   public void removeNoteToPlayer(NoteV1 note)
   {
      this.note = null;
   }

   public String toString()
   {
      return "Name: " + name + "\nNumber: " + number + "\nPosition: " + position
            + "\nNote: " + note;
   }

   public PlayerV1 copy()
   {
      return new PlayerV1(number, name, position);
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof PlayerV1))
      {
         return false;
      }

      PlayerV1 other = (PlayerV1) obj;

      return name.equals(other.name) && number==other.number && position.equals(other.position)
            && note.equals(other.note);
   }
}



