import java.io.Serializable;

/**
 * A class representing the Player's number, position, name and a note.
 * 
 * @author krogh
 * @version
 */
public class Player implements Serializable
{
   private int number;
   private String position;
   private String name;
   private String note;

   /**
    * Four-argument constructor.
    * 
    * @param number
    *           the Player's number.
    * @param position
    *           the Player's position.
    * @param name
    *           the Player's name.
    * @param note
    *           the Player's note.
    */
   public Player(String name, int number, String position, String note)
   {
      this.number = number;
      this.position = position;
      this.name = name;
      this.note = note;
   }

   /**
    * Sets the Player's name.
    * 
    * @param name
    *           what the Player's name will be set to.
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Sets the Player's position.
    * 
    * @param position
    *           what the Player's position will be set to.
    */
   public void setPosition(String position)
   {
      this.position = position;
   }

   /**
    * Sets the Player's number.
    * 
    * @param number
    *           what the Player's number will be set to.
    */
   public void setNumber(int number)
   {
      this.number = number;
   }

   /**
    * Sets the Player's note.
    * 
    * @param note
    *           what the Player's note will be set to.
    */
   public void setNote(String note)
   {
      this.note = note;
   }

   /**
    * Gets the Player's name.
    * 
    * @return the Player's name.
    */
   public String getName()
   {
      return name;
   }

   /**
    * Gets the Player's number.
    * 
    * @return the Player's number.
    */
   public int getNumber()
   {
      return number;
   }

   /**
    * Gets the Player's position.
    * 
    * @return the Player's position.
    */
   public String getPosition()
   {
      return position;
   }

   /**
    * Gets the Player's note.
    * 
    * @return the Player's note.
    */
   public String getNote()
   {
      return note;
   }

   /**
    * Removes a note from the list.
    * 
    * @param note
    *           the note to be removed from the Player.
    */
   public void removeNote(String note)
   {
      this.note = "";
   }

   /**
    * Gets a String representation of the Player.
    * 
    * @return a String representation of the Date in the format: "name,
    *         position, number, note".
    */
   public String toString()
   {
      return name + ", " + position + ", " + number + ", " + note;
   }

   /**
    * Creates a copy of the Player object.
    * 
    * @return a copy of the four-argument constructor.
    */
   public Player copy()
   {
      return new Player(name, number, position, note);
   }

   /**
    * Compares number, position, name and note of two Player's.
    * 
    * @param boolean
    *           returns true if the obj argument is equal(an instance of) to
    *           Object, otherwise false.
    * @param obj
    *           the object which is refered to comparing.
    * @return true if the given objects is equal to this Date.
    */
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