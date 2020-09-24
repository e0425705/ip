# duke.Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
2. Set up the correct JDK version, as follows:
   2.1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   2.2. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   2.3. Click `OK`
3. Import the project into Intellij as follows:
   3.1. Click `Open or Import`.
   3.2. Select the project directory, and click `OK`
   3.3. If there are any further prompts, accept the defaults.
4. After the importing is complete, locate the `src/main/java/duke.Duke.java` file, right-click it, and choose `Run duke.Duke.main()`. If the setup is correct, you should see something like the below:

   --------------------------------------------------------------------------------------------
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   
   --------------------------------------------------------------------------------------------
   Hello! I'm Duke.
   What can I do for you today?
   --------------------------------------------------------------------------------------------
   Commands available: list, help, done, todo, deadline, event, delete, find, save, bye
   The expected format of input values: 
   	list - gives the list of data inputted
   	help - this pulls out the commands available
   	done x - x is the index of data that you want to mark as done
   	todo x - x is the task description
   	deadline x /by DATETIME - x is the task description and y is the deadline date and time
   	event x /at DATETIME - x is the task description and y is the event date and time
   		the format for DATETIME is YYYY-MM-DDtHHmm, where
   		Y = year, M = month, D = day, H = hour, m = minute
   	delete x - removes the task located at index x of the list
   	find y - looks for task description with y included
   	save - this saves the current list
   	bye - this terminates the program
   --------------------------------------------------------------------------------------------
   Now you have 0 task in the list
   --------------------------------------------------------------------------------------------
   
5. 