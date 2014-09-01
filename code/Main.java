import java.io.*;

class Main
{
    // Main method
    public static void main(String[] args)
    {
        Command c = new Command();
        c.menuScreen();
    }
}


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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Is the information for each referee up-to-date? (Yes/No)");

        try
        {
            String answer = reader.readLine();

            if(answer.equalsIgnoreCase("Yes"))
            {
                while(notQuit)
                {
                    System.out.println("Please input the game times & dates for which you would like to schedule a referee for");
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

            else if(answer.equalsIgnoreCase("No"))
            {
                System.out.println("\nPlease update referee information in the file to ensure fairness in game assignments.\n");
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
