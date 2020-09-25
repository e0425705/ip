# Duke User Guide
Duke is a command-line application that helps you to keep track of tasks.
It is built to cater to the needs of University students as a mean to organise tasks such as todo, event and deadline.
More task types would be released in version 2.
This application is named after the Java mascot _Duke_. 
Given below are instructions on how to use it.

## Table of Contents
* [Quick Start] (#quick-start)
* [Features] (#features)
    * [Setting up program in Intellij] (#setting-up-program-in-intellij)
    * [Add task type todo] (#add-task-type-todo): `todo`
    * [Add task type deadline] (#add-task-type-deadline): `deadline`
    * [Add task type event] (#add-task-type-event): `event`
    * [Display task list] (#display-task-list): `list`
    * [Mark task as done] (#mark-task-as-done): `done`
    * [Delete task from list] (#delete-task-from-list): `delete`
    * [Find keyword in list] (#find-keyword-in-list): `find`
    * [Print help list] (#print-help-list): `help`
    * [Save current list to file] (#save-current-list-to-file): `save`
    * [Exit program] (#exit-program)
* [Command Summary] (#command-summary)

## Quick Start
1. Ensure that you have at least Java 11 installed in your computer and updated Intellij to the most recent version.
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/duke.Duke.java` file, right-click it, and choose `Run duke.Duke.main()`. If the setup is correct, you should see something like the below:
   
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
   
   For the "Created new file..." part, it will differ depending on where you save the application.
   
        Here are some commands you can try:
        * `todo CS2113`: Add "todo CS2113" into the task list.
        * `list`: Print out the list of all tasks.
        * `done 2`: Mark the task in index 2 of the list as done, indicated by a tick(✓).
        * `delete 3`: Deletes the task in index 3 of the list.
        * `find CS`: Searches through task list for description with the CS in it.
        * `help`: Prints out the commands available and their respective formats.
        * `save`: Saves current list into storage file.
        * `bye`: Saves current list into storage file and exits application.
   1. Do refer to Features section below for more details.

## Features
Duke has 3 types of task available. Which are `todo`, `deadline` and `event`.
The other commands available are `list`, `done`, `delete`, `find`, `help`, `save` and `bye`.

>Things to take note of:
    >1. Input format should strictly adhere to the one in the help list or in this user guide.
    >1. Input commands such as `todo`, `list`, `delete`, etc. are not case-sensitive but it is recommeneded to follow format stated in help list or this user guide.

### Setting up program in Intellij
Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/duke.Duke.java` file, right-click it, and choose `Run duke.Duke.main()`. 
   1. For first time user, if the setup is correct, the following would be printed out:
   ```
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
   ```
   This implies that a file name duke.txt has been created as a storage file, with path C:\Users\PUAH\Desktop\ceg\CS2113T\IP\duke.txt, this path differs for different user and where they save the application. 
   This file will only be created once. 
   1. For none first time user, a list of the task that you have saved in duke.txt would be shown. An example of a successful run can look like:
   ```
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
   	[T][✘] example1
   	[E][✘] example2 (at: 24 SEPTEMBER 2020, 2057)
   	[D][✘] example3 (by: 24 SEPTEMBER 2020, 2100)
   Now you have 3 tasks in the list
   --------------------------------------------------------------------------------------------
   ```
   In this example, `todo` task example1, `event` task example2 and `deadline` task example3 were loaded from file duke.txt.
   1. An example of a unsuccessful run can look like:
   ```
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
   	[T][✘] example1
   	[E][✘] example2 (at: 24 SEPTEMBER 2020, 2057)
   --------------------------------------------------------------------------------------------
   An error has occurred here!
   Do check file source if there is a corruption of data!
   --------------------------------------------------------------------------------------------
   	[D][✘] example3 (by: 24 SEPTEMBER 2020, 2100)
   Now you have 3 tasks in the list
   --------------------------------------------------------------------------------------------
   ```
   The block of error message implies that there is a line of code between task example2 and example3 that the program cannot decode.
   This requires the user to open duke.txt and check for the error.
   If the issue is due to an error in the input in duke.txt, the user can re-enter the task into the list via `todo`, `deadline` or `event`.
   Do note that the program will not keep the line in which there was an error in the Duke program.
      The whole storage file duke.txt would be overwritten by the current list in program when `save` or `bye` command inputted.
   1. The "Commands available:..." provides the help list to first time users. This also can be used as reference to users who forget what are the commands available and their format. 
   It can be pulled out once again with the command `help`.
   
### Add task type todo
Format: `todo TASK_DESCRIPTION`

Parameters:
* `TASK_DESCRIPTION`: Task desciption

Examples:
* `todo study`
```
--------------------------------------------------------------------------------------------
Got it. I've added this task:
	[T][✘] study
Now you have 1 task in the list
--------------------------------------------------------------------------------------------
```

If the `TASK_DESCRIPTION` is empty, the following would be printed out:
* `todo`
```
--------------------------------------------------------------------------------------------
The description of a todo cannot be empty.
--------------------------------------------------------------------------------------------
```

### Add task type deadline
Format: `deadline TASK_DESCRIPTION /by DATE_TIME`

Parameters:
* `TASK_DESCRIPTION`: Task description
* `DATE_TIME`: Date and time in the format YYYY-MM-DDtHHmm, 
where YYYY = year, MM = month, DD = day, HH = hour, mm = minute

Examples:
* `deadline do IP /by 2019-09-08t1700`
```
--------------------------------------------------------------------------------------------
Got it. I've added this task:
	[D][✘] do IP (by: 8 SEPTEMBER 2019, 1700)
Now you have 2 tasks in the list
--------------------------------------------------------------------------------------------
```

If an input which did not follow the format is input, the following would be printed out
* `deadline prepare oral `
--------------------------------------------------------------------------------------------
Sorry I do not understand what you mean!
Do bring out help list via the command help for the specific format!
--------------------------------------------------------------------------------------------

* `deadline`
--------------------------------------------------------------------------------------------
The task you input has missing fields!
Please do input 'help' for the commands and their respective input format.
--------------------------------------------------------------------------------------------

>Things to take note of:
>* `DATE_TIME` is according to the 24 hour clock. (e.g. 1800)

### Add task type event
Format: `event TASK_DESCRIPTION /at DATE_TIME`

Parameters:
* `TASK_DESCRIPTION`: Task description
* `DATE_TIME`: Date and time in the format YYYY-MM-DDtHHmm, 
where YYYY = year, MM = month, DD = day, HH = hour, mm = minute

Examples:
* `event study CS2113 /at 2016-09-18t1500`
```
--------------------------------------------------------------------------------------------
Got it. I've added this task:
	[E][✘] study CS2113 (at: 18 SEPTEMBER 2016, 1500)
Now you have 3 tasks in the list
--------------------------------------------------------------------------------------------
```

If an input which did not follow the format is input, the following would be printed out
* `event prepare oral `
```
--------------------------------------------------------------------------------------------
Sorry I do not understand what you mean!
Do bring out help list via the command help for the specific format!
--------------------------------------------------------------------------------------------
```

* `event`
```
--------------------------------------------------------------------------------------------
The task you input has missing fields!
Please do input 'help' for the commands and their respective input format.
--------------------------------------------------------------------------------------------
```

>Things to take note of:
>* `DATE_TIME` is according to the 24 hour clock. (e.g. 1800)

### Display task list
Format: `list`

Examples:
* `list`
```
--------------------------------------------------------------------------------------------
Here are the tasks in the list
	1.[T][✘] study
	2.[D][✘] do IP (by: 8 SEPTEMBER 2019, 1700)
	3.[E][✘] study CS2113 (at: 18 SEPTEMBER 2016, 1500)
--------------------------------------------------------------------------------------------
```

If the list is empty, the following would be printed out:
```
--------------------------------------------------------------------------------------------
Here is the task in the list
--------------------------------------------------------------------------------------------
```

### Mark task as done
Format: `done TASK_INDEX`

Parameters:
* `TASK_INDEX`: Index of task in list.

Examples:
* `done 1`
```
--------------------------------------------------------------------------------------------
Nice! I've marked this task as done:
	[T][✓] study
--------------------------------------------------------------------------------------------
```

If the `TASK_INDEX` cannot be found in list, the following would be printed out:
* `done 4`
```
--------------------------------------------------------------------------------------------
Something went wrong!! I do not understand what you mean.
There could be an error in the way of input.
Please do input 'help' for the commands and their respective input format.
--------------------------------------------------------------------------------------------
```

### Delete task from list
Format: `delete TASK_INDEX`

Parameters:
* `TASK_INDEX`: Index of task in list.

Examples:
* `delete 1`
```
--------------------------------------------------------------------------------------------
Noted. I've removed this task:
	[T][✘] study
Now you have 2 tasks in the list
--------------------------------------------------------------------------------------------
```

If `TASK_INDEX` is not found in list, the following would be printed out
* `delete 10`
```
--------------------------------------------------------------------------------------------
Sorry the index of task to be remove cannot be found!
--------------------------------------------------------------------------------------------
```

### Find keyword in list
Format: `find TASK_KEYWORD`

Parameters:
* `TASK_KEYWORD`: Keyword to search for in list.

Examples:

* `find do`
```
--------------------------------------------------------------------------------------------
Here are the matching tasks in your list:
	1.[D][✘] do IP (by: 8 SEPTEMBER 2019, 1700)
--------------------------------------------------------------------------------------------
```

If `TASK_KEYWORD` is not found, the following would be printed out:
* `find one`
```
--------------------------------------------------------------------------------------------
Here are the matching tasks in your list:
--------------------------------------------------------------------------------------------
```

>Things to take note of:
>* `TASK_KEYWORD` is case-sensitive.

### Print help list
Format: `help`

Example:
```
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
```

### Save current list to file
Format: `save`

Example:
```
--------------------------------------------------------------------------------------------
The current list has been saved.
--------------------------------------------------------------------------------------------
```

### Exit program
Format: `bye`

Example:
```
--------------------------------------------------------------------------------------------
Bye. It was a pleasure serving you.
The current list has been saved.
Hope to see you again soon!
--------------------------------------------------------------------------------------------
```

## Command Summary
| Action | Format, Example |
| :-:    |:--              |
|ToDo    | `todo TASK_DESCRIPTION`, `todo study` |
|Deadline| `deadline TASK_DESCRIPTION /by DATE_TIME`, `deadline do IP /by 2019-09-08t1700` |
|Event   | `event TASK_DESCRIPTION /at DATE_TIME`, `event study CS2113 /at 2016-09-18t1500` |
|List    | `list`, `list` |
|Done    | `done TASK_INDEX`, `done 1` |
|Delete  | `delete TASK_INDEX`, `delete 1` |
|Find    | `find KEYWORD`, `find do` |
|Help    | `help`, `help` |
|Save    | `save`, `save` |
|Exit    | `bye`, `bye` |

### --- END OF USER GUIDE ---