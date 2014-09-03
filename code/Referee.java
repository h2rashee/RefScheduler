import java.io.*;
import java.util.*;

// Referee (represents a person)
class Referee
{
   String firstName;
   String lastName;
   String email;
   boolean returning;
   boolean active;
   int studentID;
   int examMark;
   int assigningFactor;
   int rating;
   ArrayList<Time> gamesAssigned;
   Availability availb;


   // Constructor
   Referee(String firstName1, String lastName1, String email1,
           boolean returning1, boolean active1,
           int studentID1, int examMark1, int rating1)
   {
       firstName = firstName1;
       lastName = lastName1;
       email = email1;

       returning = returning1;
       active = active1;

       studentID = studentID1;
       examMark = examMark1;
       rating = rating1;

       availb = new Availability();

       /*
        * Compute assigning factor
        * Fill up availability array
        */
   }


   /**
    * Checks whether a referee is available during a particular time based
    * on what they have specified on the availability spreadsheet.
    * @param time Time for which availability is being checked for
    * @return Referee's availability status
    */
   boolean isGeneralAvailable(Time time)
   {
       //TODO if referee's general availability says yes based on time/game
       int col = time.getDay();
       int row = 1;//time.getHour();    FIXME
       return true;//FIXME availability[row][col];
   }


   /**
    * Gets the full name of the referee.
    * @return Full name of Referee
    */
   String getFullName()
   {
      return firstName + " " + lastName;
   }


   /**
    * Checks whether the referee is active
    * @return Active status of a Referee
    */
   boolean isActive()
   {
      return active;
   }
}



class Availability
{
   boolean[][] avail;

   public Availability()
   {
      int numDays = 7;
      int numHours = 24;

      avail = new boolean[numDays][numHours*2];
   }
}



// Object associated with a roster of referees
class RefereeList
{
   ArrayList<Referee> refs = new ArrayList<Referee>();

   RefereeList()
   {
      //TODO Initialise referee list with referees from random access file
      //Read records and load into referee list
   }


   /**
    * Finds the number of referees in the list.
    * @return Number of referees in the list
    */
   int getNumReferees()
   {
      return refs.size();
   }


   /**
    * Removes active/inactive referees from the RefereeList.
    * @param active Whether active (false) or inactive (true) referees
    * should be removed from the list
    */
   void filterInactive(boolean active)
   {
      for(int i = 0; i < getNumReferees(); i++)
      {
         // If the referee's status is not active, remove him from the list
         if(refs.get(i).isActive() != active)
         {
            refs.remove(i);
            i--;
         }
      }
   }


   /**
    * Removes referees from the RefereeList that are unavailable according to
    * their general availability.
    * @param gameTimes ...TODO
    */
   void filterUnavailable(ArrayList<Time> gameTimes)
   {
      for(int i = 0; i < gameTimes.size(); i++)
      {
         for(int j = 0; j < getNumReferees(); j++)
         {
            // If referee is not available at this time, remove him TODO
         }
      }
   }
}

