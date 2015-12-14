import java.io.*;
import java.util.*;
import java.lang.*;

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
   Referee(String _firstName, String _lastName, String _email,
           boolean _returning, boolean _active,
           int _studentID, int _examMark, int _rating)
   {
       firstName = _firstName;
       lastName = _lastName;
       email = _email;

       returning = _returning;
       active = _active;

       studentID = _studentID;
       examMark = _examMark;
       rating = _rating;

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

   public void print()
   {
      System.out.println("Name: " + getFullName());
      System.out.println("Email: " + email);
      System.out.println("Returning?: " + returning);
      System.out.println("Active?: " + active);
      System.out.println("Student ID: " + studentID);
      System.out.println("Exam Mark: " + examMark);
      System.out.println("Rating: " + rating);
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
      // Read records and load into referee list
      readRosterFromFile();
      // Generate master availability table
      //printRefList();
   }


   /**
    * Reads the referee data from the file into memory in a RefereeList.
    */
   private void readRosterFromFile()
   {
      String csvFileName = "config/roster.dat";
      BufferedReader br = null;
      String line = "";
      String delimiter = ",";

      try
      {
         boolean firstLine = true;
         br = new BufferedReader(new FileReader(csvFileName));

         while ((line = br.readLine()) != null)
         {
            if(firstLine)
            {
               firstLine = false;
               continue;
            }

            String[] record = line.split(delimiter);

            Referee ref = new Referee(record[0], record[1], record[2],
                                      Boolean.parseBoolean(record[3]),
                                      Boolean.parseBoolean(record[4]),
                                      Integer.parseInt(record[5]),
                                      Integer.parseInt(record[6]),
                                      Integer.parseInt(record[7]));
            refs.add(ref);
         }
      }
      catch(Exception e)
      {
         System.err.println("Error while reading CSV file: " + e);
      }
   }


   /**
    * Prints the referee list
    */
   public void printRefList()
   {
      for(int i = 0; i < getNumReferees(); i++)
      {
         System.out.print(refs.get(i).firstName);
      }
   }


   /**
    * Collates the e-mails of all the active referees on the roster
    */
   public String getRefEmailList()
   {
      StringBuilder sb = new StringBuilder();
      // FIXME Appropriate fix on String Builder

      for(int i = 0; i < getNumReferees(); i++)
      {
          sb.append(refs.get(i).email + ";");
      }

      return sb.toString();
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

