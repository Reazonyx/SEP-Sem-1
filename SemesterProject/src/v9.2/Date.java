import java.util.GregorianCalendar;

/**
 * A class representing a Date, with a date and time.
 * @author krogh
 * @version 
 */
public class Date
{
   private int year;
   private int month;
   private int day;
   private int hour;
   private int minute;
   
   /**
    * Five-argument constructor.
    * @param year is the Date's year.
    * @param month is the Date's month.
    * @param day is the Date's day.
    * @param hour is the Date's hour.
    * @param minute is the Date's minute.
    */
   public Date(int year, int month, int day, int hour, int minute)
   {
      this.year = year;
      this.month = month;
      this.day = day;
      this.hour = hour;
      this.minute = minute;
   }
   
   /**
    * 5-argument method that sets year, month, day, hour and minute to the class Date.
    * @param year what the Date's year will be set to.
    * @param month what the Date's month will be set to.
    * @param day what the Date's day will be set to.
    * @param hour what the Date's hour will be set to.
    * @param minute what the Date's minute will be set to.
    */
   public void set(int year, int month, int day, int hour, int minute)
   {
      this.year = year;
      this.month = month;
      this.day = day;
      this.hour = hour;
      this.minute = minute;
   }
   
   /**
    * Gets the Date's year.
    * @return the Date's year.
    */
   public int getYear()
   {
      return year;
   }
   
   /**
    * Gets the Date's month.
    * @return the Date's month.
    */
   public int getMonth()
   {
      return month;
   }
   
   /**
    * Gets the Date's day.
    * @return the Date's day.
    */
   public int getDay()
   {
      return day;
   }
   
   /**
    * Gets the Date's hour.
    * @return the Date's hour.
    */
   public int getHour()
   {
      return hour;
   }
   
   /**
    * Gets the Date's minute.
    * @return the Date's minute.
    */
   public int getMinute()
   {
      return minute;
   }
   
   /**
    * Gets a String representation of the Date.
    * @return a String representation of the Date in the format: "Year: year, month month, day day, hour hour, minute minute"
    */
   public String toString()
   {
      return "Year: " + year + ", month: " + month + ", day: " + day + ", hour: " + hour + ", minute: " + minute;
   }
   
   /**
    * Compares year, month, day, hour and minute of two Date's.
    * @param boolean returns true if the obj argument is equal(an instance of) to Object, otherwise false.
    * @param obj the object which is refered to comparing.
    * @return true if the given objects is equal to this Date.
    */
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Date))
      {
         return false;
      }
      
      Date other = (Date) obj;
      
      return year == other.year && month == other.month && day == other.day && hour == other.hour && minute == other.minute;
   }

   /**
    * A static method which returns object of current date
    * @return Date object (current date)
    */
   public static Date today()
   {

      GregorianCalendar currentDate = new GregorianCalendar();
      int currentDay = currentDate.get(GregorianCalendar.DATE);
      int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
      int currentYear = currentDate.get(GregorianCalendar.YEAR);
      int currentHour = currentDate.get(GregorianCalendar.HOUR);
      int currentMinute = currentDate.get(GregorianCalendar.MINUTE);

      return new Date(currentDay, currentMonth, currentYear,currentHour,currentMinute);
   }
 
   /**
    * Checks if date is before date given
    * @return boolean
    */
   public boolean isBefore()
   {
      if (year < Date.today().year)
      {
         return true;
      }
      else if (year == Date.today().year && month < Date.today().month)
      {
         return true;
      }
      else if (year == Date.today().year && month == Date.today().month && day < Date.today().day)
      {
         return true;
      }
      else if(year == Date.today().year && month == Date.today().month && day == Date.today().day && hour < Date.today().hour)
      {
         return true;
      }
      else if(year == Date.today().year && month == Date.today().month && day == Date.today().day && hour == Date.today().hour && minute < Date.today().minute) 
      {
         return true;
      }
      else 
      {
         return false;
      }
   }
   
   /**
    * Creates a copy of the Date object.
    * @return a copy of the five-argument constructor.
    */
   public Date copy()
   {
      return new Date(year, month, day, hour, minute);
   }
}