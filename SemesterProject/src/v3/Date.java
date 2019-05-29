public class Date
{
   private int year;
   private int month;
   private int day;
   private int hour;
   private int minute;
   
   public Date(int year, int month, int day, int hour, int minute)
   {
      this.year = year;
      this.month = month;
      this.day = day;
      this.hour = hour;
      this.minute = minute;
   }
   
   public void set(int year, int month, int day, int hour, int minute)
   {
      this.year = year;
      this.month = month;
      this.day = day;
      this.hour = hour;
      this.minute = minute;
   }
   
   public int getYear()
   {
      return year;
   }
   
   public int getMonth()
   {
      return month;
   }
   
   public int getDay()
   {
      return day;
   }
   
   public int getHour()
   {
      return hour;
   }
   
   public int getMinute()
   {
      return minute;
   }
   
   public String toString()
   {
      return "Year: " + year + ", month: " + month + ", day: " + day + ", hour: " + hour + ", minute: " + minute;
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Date))
      {
         return false;
      }
      
      Date other = (Date) obj;
      
      return year == other.year && month == other.month && day == other.day && hour == other.hour && minute == other.minute;
   }
   
   public Date copy()
   {
      return new Date(year, month, day, hour, minute);
   }
}
