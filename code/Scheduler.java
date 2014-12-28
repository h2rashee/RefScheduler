import java.io.*;
import java.util.*;

// Scheduler
class Scheduler
{
   /*
    * Schedules referees for games in the schedule
    *
    * @param none
    * @return returns the completed schedule and relevant flags
   */
   public void schedule()
   {
      boolean notQuit = true;

      BufferedReader reader =
         new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Is the information for referees up-to-date? (Y/n)");

      try
      {
         String answer = reader.readLine();

         if(answer.equalsIgnoreCase("Y") || answer.equals(""))
         {
            while(notQuit)
            {
               System.out.println("Please input the game date & time");
               String input = reader.readLine();

               if(input.equalsIgnoreCase("q"))
               {
                  notQuit = false;
               }

               else if(input.equalsIgnoreCase(""))
               {
                  //Some command TODO
               }
            }
         }

         else if(answer.equalsIgnoreCase("N"))
         {
            System.out.println("\nPlease update the roster info.\n");
         }

         else
         {
            System.err.println("Please answer with either Yes/No");
            schedule();
         }
      }
      catch(Exception e)
      {
         System.err.println("An unexpected error occurred as follows: " + e);
      }
   }
}

