
public class NoteV1
{
   private String note;
   
   public NoteV1(String note)
   {
      this.note = note;
   }
   
   public void setNote(String note)
   {
      this.note = note;
   }
   
   public String getNote()
   {
      return note;
   }
   
   public NoteV1 copy()
   {
      NoteV1 notes = new NoteV1(note);
      
      return notes;
   }
   
   public String toString()
   {
      return "Note: " + note;
   }

}
