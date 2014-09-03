/*
 * The custom Time class was created rather than using the in-built class
 * as there were several unnecessary fields that were not required and
 * more convenient to only use what is needed with my own custom methods.
 */

import java.util.*;

class Time
{
   int hour;               // Hour in 24-time format
   int minute;

   String day;
   int dayDate;
   int monthDate;


   /**
    * Outputs the Time object for testing purposes.
    */
   void output()
   {
      System.out.println("Time is as follows");
      System.out.println("hour: " + hour);
      System.out.println("minute: " + minute);
      System.out.println("day: " + day);
      System.out.println("dayDate: " + dayDate);
      System.out.println("monthDate: " + monthDate);
   }


   /**
    * Initialises the Time object.
    * @param time Expected format for time is "8:00 PM"
    * @param date Expected format for date is "Mon Sep 27"
    */
   Time(String time, String date)
   {
      StringTokenizer st = new StringTokenizer(time, ": ");

      hour = Integer.parseInt(st.nextToken());
      minute = Integer.parseInt(st.nextToken());

      if(st.nextToken().equalsIgnoreCase("PM") && hour != 12)
      {
         hour += 12;
      }

      validateTime();

      StringTokenizer token = new StringTokenizer(date);

      day = token.nextToken();
      monthDate = getMonth(token.nextToken());
      dayDate = Integer.parseInt(token.nextToken());
   }


   /**
    * Ensures that the time information read and interpreted in the Time object
    * is appropriate and valid.
    */
   void validateTime()
   {
      if(hour < 0 || hour > 23)
      {
         System.err.println("ERROR: Cannot have an hour"
            + " not in the bounds of 0 and 23. Given hour time: " + hour);
         System.exit(1);
      }
      if(minute < 0 || minute > 59)
      {
         System.err.println("ERROR: Cannot have the minute"
            + " not in the bounds of 0 and 59. Given minute time: " + minute);
         System.exit(1);
      }
   }


   /**
    * Finds the relevant code (array column that the availability will be
    * stored depending on the day that the time refers to.
    * @return Relevant index of day of the week starting on Monday
    */
   int getDay()
   {
      if(day.equals("Mon"))
         return 0;
      else if(day.equals("Tue"))
         return 1;
      else if(day.equals("Wed"))
         return 2;
      else if(day.equals("Thu"))
         return 3;
      else if(day.equals("Fri"))
         return 4;
      else if(day.equals("Sat"))
         return 5;
      else if(day.equals("Sun"))
         return 6;
      else
      {
         System.err.println("Invalid day provided in the date. Given day: "
            + day);
         System.exit(1);
         return -1;
      }
   }


   /**
    * Finds the indices of the given month appropriately according to its
    * appropriate order in the calendar.
    * @param month Three character short-form of the name of the month
    * @return The index of the month in the Gregorian calendar
    */
   int getMonth(String month)
   {
      if(month.equals("Jan"))
         return 1;
      else if(month.equals("Feb"))
         return 2;
      else if(month.equals("Mar"))
         return 3;
      else if(month.equals("Apr"))
         return 4;
      else if(month.equals("May"))
         return 5;
      else if(month.equals("Jun"))
         return 6;
      else if(month.equals("Jul"))
         return 7;
      else if(month.equals("Aug"))
         return 8;
      else if(month.equals("Sep"))
         return 9;
      else if(month.equals("Oct"))
         return 10;
      else if(month.equals("Nov"))
         return 11;
      else if(month.equals("Dec"))
         return 12;
      else
      {
         System.err.println("Invalid month provided in the date. Given month: "
            + month);
         System.exit(1);
         return -1;
      }
   }


   /**
    * Checks whether the Time is on the hour of the clock
    * @return Whether the time is on the hour
    */
   boolean onTheHour()
   {
      if(minute != 0)
      {
         return false;
      }

      return true;
   }


   //Useful for testing
   /*public static void main(String[] args)
   {
      Time t = new Time("8:00 PM", "Mon Sep 27");
      t.output();
   }*/
}

