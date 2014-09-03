import java.io.*;
import java.util.*;

// Command handler for the menu
class Command
{
   // Number of set commands
   int numCommands = 7;

   // Contains system commands
   String[] commands = new String[numCommands];
   ArrayList<String> matchedCommands = new ArrayList<String>();

   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   /**
    * Initialises the Command class.
    */
   Command()
   {
      commands[0] = "schedule games";
      commands[1] = "referee e-mail list";
      commands[2] = "view referee list";
      commands[3] = "edit referee list";
      commands[4] = "help";
      commands[5] = "quit";
      commands[6] = "schedule";
   }


   /**
    * Opens the menu screen and prompts the user for a command to execute.
    */
   void menuScreen()
   {
      String heading = "\nWelcome to RefScheduler\n";
      String welcomeLine = "This system has been designed by Harris Rasheed " +
         "and is intended to aid schedulers in assigning referees to " +
         "games by generating a ranked list of referees who most deserve " +
         "the game(s)/shift(s) available. It also provides other " +
         "functionality intended for easy use and the smooth " +
         "operation of scheduling and administration.";

      System.out.println(heading);
      System.out.println(welcomeLine);

      // Flag to keep menu screen running unless the user quits
      boolean notQuit = true;

      try
      {
         // Keep reading input
         while(notQuit)
         {
            // Marker representing that the system is awaiting input
            System.out.print("\n> ");

            String cmd = reader.readLine();

            // Attempt to match input to a specified command
            // and provide a return code
            int command = commandInterpreter(cmd);

            switch(command)
            {
               // Ambiguous command prefix
               case -2:
               System.err.println("Ambiguous command input. " +
                  "Please type a unique command prefix");
               outputAmbiguousCommands();
               break;

               // Command not found
               case -1:
               System.err.println("Error: Command not found");
               break;

               case 0:
               Scheduler sch = new Scheduler();
               sch.schedule();
               break;

               case 1:
               break;

               case 2:
               break;

               case 3:
               break;

               case 4:
               outputAllCommands();
               break;

               // User quit
               case 5:
               notQuit = false;
               break;

               default:
               break;
            }
         }
      }
      catch(Exception e)
      {
         System.err.println("An unexpected error occurred.");
         System.err.println("Details are as follows:");
         System.err.println(e);
      }

      return;
   }


   /**
    * Compares two characters and returns whether they are equal regardless of
    * case (an equivalent of equalsIgnoreCase method for strings but for
    * characters).
    * @param c1 First character to be compared
    * @param c2 Second character to be compared
    * @return if the characters match or not
    */
   boolean charMatch(char c1, char c2)
   {
      // Adjust character to lowercase
      if(c1 >= 'A' && c1 <= 'Z')
      {
         c1 += 32;
      }

      // Adjust character to lowercase
      if(c2 >= 'A' && c2 <= 'Z')
      {
         c2 += 32;
      }

      return (c1 == c2);
   }


   /**
    * Checks whether the second string is equivalent or a prefix of the first.
    * @param command matching string
    * @param input pattern string that is being tested as a prefix
    * @return if the second string is a prefix of the first string
   */
   boolean isPrefixSubstring(String command, String input)
   {
      // When the command name exactly matches the input
      if(command.equalsIgnoreCase(input))
      {
         return true;
      }

      int size = input.length();

      // When the command is longer
      if(command.length() < input.length())
      {
         // it obviously doesn't match
         return false;
      }

      // Let us cycle through both strings
      for(int i = 0; i < size; i++)
      {
         boolean characterMatch = charMatch(command.charAt(i), input.charAt(i));

         // When characters at corresponding positions don't match;
         if(!characterMatch)
         {
            // they don't match
            return false;
         }
      }

      // The command matches
      return true;
   }


   /**
    * Outputs all system commands to the user
    */
   void outputAllCommands()
   {
      System.out.println("The available system commands are:");

      for(int i = 0; i < numCommands; i++)
      {
         System.out.println("\t- " + commands[i]);
      }
   }


   /**
    * Outputs all the commands that were matched by the input.
    */
   void outputAmbiguousCommands()
   {
      for(int i = 0; i < matchedCommands.size(); i++)
      {
         System.out.print(matchedCommands.get(i));

         if(i != matchedCommands.size() - 1)
         {
            System.out.print(", ");
         }
      }
      System.out.println(" have a possible match");
   }


   /**
    * Reads in a command or prefix and interprets the command to be executed
    * @param command Command to be interpreted.
    * @return array location of the corresponding command;
    * negative numbers represent error codes
    */
   int commandInterpreter(String command)
   {
      matchedCommands.clear();

      // Number of matched commands
      int numMatchingCommands = 0;
      // Location of the last matched command
      int matchingCommand = -1;

      // Look through each command
      for(int i = 0; i < numCommands; i++)
      {
         // If the command is a prefix of a given valid command
         if(isPrefixSubstring(commands[i], command))
         {
            // Note that a command was matched
            numMatchingCommands++;
            matchedCommands.add(commands[i]);

            // Store the position of the matched command
            matchingCommand = i;
         }
      }

      // Command is ambiguous because there are multiple matches
      if(numMatchingCommands > 1)
      {
         return -2;
      }

      // Matched the command
      else if(numMatchingCommands == 1)
      {
         System.out.println("The command '" + command +
                 "' was interpreted as '" + commands[matchingCommand] + "'\n");
         return matchingCommand;
      }

      // No commands found
      return -1;
   }
}

