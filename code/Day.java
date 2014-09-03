import java.util.*;

// Schedule is the parent class
class Schedule
{
   ArrayList<Day> days;

   /**
    * Finds the number of days in the schedule.
    * @return the number of days in the schedule
    */
   int getNumDays()
   {
      return days.size();
   }
}



// Day in the schedule
class Day
{
   ArrayList<Game> games;
   ArrayList<Shift> shifts;

   /**
    * Finds the number of games in the day.
    * @return the number of games in the day
    */
   int getNumGames()
   {
      return games.size();
   }


   void shiftSplit()
   {
   }
}



// Shift in a day
class Shift
{
   ArrayList<Game> games;
}

