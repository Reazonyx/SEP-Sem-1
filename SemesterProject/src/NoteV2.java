
public class NoteV2
{
   private String note;

   public NoteV2(String note)
   {
    
      this.note = note;
   }

   public String getNote()
   {
      return note;
   }

   public void setNote(String note)
   {
      this.note = note;
   }
   
   public NoteV2 copy() {
      return new NoteV2(note);
   }
   
   public String toString() {
      return "" + note;
   }
}
