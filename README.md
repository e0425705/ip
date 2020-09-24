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
   		Format for DATETIME is YYYY-MM-DDtHHmm, where
   		Y = year, M = month, D = day, H = hour, m = minute
   	delete x - removes the task located at index x of the list
   	find y - looks for task description with y included
   	save - this saves the current list
   	bye - this terminates the program
   --------------------------------------------------------------------------------------------
   Created new file C:\Users\PUAH\Desktop\ceg\CS2113T\IP\duke.txt
   --------------------------------------------------------------------------------------------
   4.1 This implies that a file name duke.txt has been created as a storage file, with path C:\Users\PUAH\Desktop\ceg\CS2113T\IP\duke.txt. This file will only be created once. After that, a list of the task that you have saved in duke.txt would be shown. It will look something like this:
   --------------------------------------------------------------------------------------------
   	[T][✘] example1
   	[E][✘] example2 (at: 24 SEPTEMBER 2020, 2057)
   	[D][✘] example3 (by: 24 SEPTEMBER 2020, 2100)
   Now you have 3 tasks in the list
   --------------------------------------------------------------------------------------------
   4.3 The "Commands available" gives help list to first time users. If you forget what are the commands available and their format, it can be pulled out once again with the command "help".
5. There are only 3 types of tasks input available to users. ToDo, Event and Deadline. More task types will be released in version 2.
6. This section will run through how to input commands and the format acceptable.
   6.1 By inputting "list", it puts out the list of tasks input by user. It looks something like this:
   --------------------------------------------------------------------------------------------
   Here are the tasks in the list
   	1.[T][✘] example1
   	2.[E][✘] example2 (at: 24 SEPTEMBER 2020, 2057)
   	3.[D][✘] example3 (by: 24 SEPTEMBER 2020, 2100)
   --------------------------------------------------------------------------------------------
   6.2 By inputting "help", this prints the commands available. It looks something like this:
   --------------------------------------------------------------------------------------------
   Commands available: list, help, done, todo, deadline, event, delete, find, save, bye
   The expected format of input values: 
   	list - gives the list of data inputted
   	help - this pulls out the commands available
   	done x - x is the index of data that you want to mark as done
   	todo x - x is the task description
   	deadline x /by DATETIME - x is the task description and y is the deadline date and time
   	event x /at DATETIME - x is the task description and y is the event date and time
   		Format for DATETIME is YYYY-MM-DDtHHmm, where
   		Y = year, M = month, D = day, H = hour, m = minute
   	delete x - removes the task located at index x of the list
   	find y - looks for task description with y included
   	save - this saves the current list
   	bye - this terminates the program
   --------------------------------------------------------------------------------------------
   This help list is the same as the one printed out when you first run the program.
   6.3 By inputting "done x", this marks the task at x in the list as done. An example is:
   --------------------------------------------------------------------------------------------
   Nice! I've marked this task as done:
   	[T][✓] example1
   --------------------------------------------------------------------------------------------
   In this case, I have inputted "done 1". The task at list index 1, example1 is marked as done as indicated by the tick(✓).
   6.4 By inputting "todo x", 
   --------------------------------------------------------------------------------------------
   Got it. I've added this task:
   	[T][✘] something
   Now you have 4 tasks in the list
   --------------------------------------------------------------------------------------------
   6.5 By inputting "deadline x by y"
   --------------------------------------------------------------------------------------------
   Got it. I've added this task:
   	[D][✘] this thing (by: 8 SEPTEMBER 2019, 1700)
   Now you have 5 tasks in the list
   --------------------------------------------------------------------------------------------
   6.6 By inputting "event x by y"
   --------------------------------------------------------------------------------------------
   Got it. I've added this task:
   	[E][✘] that thing (at: 18 SEPTEMBER 2016, 1500)
   Now you have 6 tasks in the list
   --------------------------------------------------------------------------------------------
   6.7 By inputting "delete x"
   --------------------------------------------------------------------------------------------
   Noted. I've removed this task:
   	[T][✘] something
   Now you have 5 tasks in the list
   --------------------------------------------------------------------------------------------
   6.8 By inputting "find x", this 
   --------------------------------------------------------------------------------------------
   Here are the matching tasks in your list:
   	1.[T][✓] example1
   	2.[E][✘] example2 (at: 24 SEPTEMBER 2020, 2057)
   	3.[D][✘] example3 (by: 24 SEPTEMBER 2020, 2100)
   --------------------------------------------------------------------------------------------
   6.9 By inputting "save", this saves the current list into file duke.txt. If the file has been successfully saved, the following would be printed out:
   --------------------------------------------------------------------------------------------
   The current list has been saved.
   --------------------------------------------------------------------------------------------
   6.10 By inputting "bye", this saves the current list into file duke.txt and exits the program. If the file has been successfully saved and exited, the following would be printed out:
   --------------------------------------------------------------------------------------------
   Bye. It was a pleasure serving you.
   The current list has been saved.
   Hope to see you again soon!
   --------------------------------------------------------------------------------------------
   6.11 Note that the list is not auto-saved to file duke.txt unless command "save" or "bye" is given.
