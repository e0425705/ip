# User Guide for Duke
Duke is a command-line application that helps you to keep track of tasks.
It is built to cater to the needs of University students as a mean to organise tasks such as todo, event and deadline.
More task types would be released in version 2.
This application is named after the Java mascot *Duke*. 
Given below are instructions on how to use it.

## Table of Contents
* [Quick Start]
* [Features]
    * [Setting up program in Intellij](#setting-up-program-in-intellij)
    * [Adding a task type todo](#adding-a-task-type-todo): `todo`
    * [Adding a task type deadline](#adding-a-task-type-deadline): `deadline`
    * [Adding a task type event](#adding-a-task-type-event): `event`
    * [Displaying the task list](#displaying-the-task-list): `list`
    * [Marking a task as done](#marking-a-task-as-done): `done`
    * [Deleting a task from list](#deleting-a-task-from-list): `delete`
    * [Finding a keyword in list](#finding-a-keyword-in-list): `find`
    * [Printing the help list](#printing-the-help-list): `help`
    * [Saving the current list to file](#saving-the-current-list-to-file): `save`
    * [Exiting the program](#exiting-the-program): `bye`
* [Command Summary] 

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
1. After the importing is complete, locate the `src/main/java/duke.Duke.java` file, right-click it, and choose `Run duke.Duke.main()`.

        Here are some commands you can try:
        * `todo CS2113`: Adds task type todo with task description CS2113 into the list.
        * `list`: Prints out the list of all tasks.
        * `done 2`: Marks the task in index 2 of the list as done, indicated by a tick(✓).
        * `delete 3`: Deletes the task in index 3 of the list.
        * `find CS`: Searches through task list for description with the CS in it.
        * `help`: Prints out the commands available and their respective formats.
        * `save`: Saves current list into storage file duke.txt.
        * `bye`: Saves current list into storage file duke.txt and exits application.
1. Refer to Features below for more commands and their details.

## Features
* Duke has 3 types of task available. Which are `todo`, `deadline` and `event`.
* The other commands available are `list`, `done`, `delete`, `find`, `help`, `save` and `bye`.

>Things to take note of:
>* Input that look like `**this**` are parameters to be supplied by user.
>* Input format should strictly adhere to the one in the help list or in this user guide.
>* Input commands such as `todo`, `list`, `delete`, etc. are not case-sensitive but it is recommended to follow format stated in help list or this user guide.
>* It is essential to save list via command `save` or `bye` as the list do not autosave to storage file duke.txt.

## Setting up program in Intellij
* Prerequisites: JDK 11, update Intellij to the most recent version.

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
  For first time user, if the setup is correct, the following would be printed out:
   
```javascript
--------------------------------------------------------------------------------------------
Hello from
 ____        _        
|  _ \ _   _| | _____ 
| | | | | | | |/ / _ \
| |_| | |_| |   <  __/
|____/ \__,_|_|\_\___|
         
-------------------------------------------------------------------------------------------
Hello! I'm Duke.
What can I do for you today?
--------------------------------------------------------------------------------------------
Commands available: list, help, done, todo, deadline, event, delete, find, save, bye
The expected format of input values: 
	list - prints list of data inputted
	help - pulls out commands available and their input format
	done x - x is index of data that you want to mark as done
	todo x - x is task description
	deadline x /by DATETIME - x is task description, DATETIME is deadline date and time
	event x /at DATETIME - x is task description, DATETIME is event date and time
		Format for DATETIME is YYYY-MM-DDtHHmm, where
		YYYY = year, MM = month, DD = day, HH = hour, mm = minute
	delete x - removes task located at index x of the list
	find x - looks for task description with x included
	save - saves current list
	bye - terminates the program
--------------------------------------------------------------------------------------------
Created new file C:\Users\PUAH\Desktop\ceg\CS2113T\IP\duke.txt
--------------------------------------------------------------------------------------------
```
>This implies that a file name duke.txt has been created as a storage file, with path C:\Users\PUAH\Desktop\ceg\CS2113T\IP\duke.txt, this path differs for different user and where they save the application. 
>This file will only be created once.
  
   
  For none first time user, a list of the task that you have saved previously in duke.txt would be shown. An example of a successful run can look like:
   
```javascript
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
	list - prints list of data inputted
	help - pulls out commands available and their input format
	done x - x is index of data that you want to mark as done
	todo x - x is task description
	deadline x /by DATETIME - x is task description, DATETIME is deadline date and time
	event x /at DATETIME - x is task description, DATETIME is event date and time
		Format for DATETIME is YYYY-MM-DDtHHmm, where
		YYYY = year, MM = month, DD = day, HH = hour, mm = minute
	delete x - removes task located at index x of the list
	find x - looks for task description with x included
	save - saves current list
	bye - terminates the program
--------------------------------------------------------------------------------------------
    [T][✘] example1
    [E][✘] example2 (at: 24 SEPTEMBER 2020, 2057)
    [D][✘] example3 (by: 24 SEPTEMBER 2020, 2100)
Now you have 3 tasks in the list
--------------------------------------------------------------------------------------------
```
   * In this example, `todo` example1, `event` example2 and `deadline` example3 were loaded from file duke.txt.
   
   
   An example of a run with error can look like:
   
```javascript
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
	list - prints list of data inputted
	help - pulls out commands available and their input format
	done x - x is index of data that you want to mark as done
	todo x - x is task description
	deadline x /by DATETIME - x is task description, DATETIME is deadline date and time
	event x /at DATETIME - x is task description, DATETIME is event date and time
		Format for DATETIME is YYYY-MM-DDtHHmm, where
		YYYY = year, MM = month, DD = day, HH = hour, mm = minute
	delete x - removes task located at index x of the list
	find x - looks for task description with x included
	save - saves current list
	bye - terminates the program
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
   * The block of error message implies that there is a line of code between task example2 and example3 in the storage file duke.txt that the program cannot decode.
   * The other lines that the program can decode would be added into list and program is ready for input.
   * To solve the error, the user is required to open duke.txt and check for the error.
   * If the issue is due to an error in the input in duke.txt, the user will have to re-enter the task into the list via `todo`, `deadline` or `event`.
   * Else if the issue is due to an unwanted line, it can be ignored.
   * Do note that the program will not keep the line in which there was an error in the Duke program.
      * The whole storage file duke.txt would be overwritten by the current list in the program when `save` or `bye` command is inputted.
      
   
   The "Commands available:..." provides the help list to first time users. This also can be used as reference to users who forget what are the commands available and their format. 
   It can be printed out once again with the command `help`.
   
## Adding a task type todo
Adds a task of type todo to the list.

Format: `todo **TASK_DESCRIPTION**`

Parameters:
* `**TASK_DESCRIPTION**`: Description of task.

Examples:
* `todo study`
```javascript
--------------------------------------------------------------------------------------------
Got it. I've added this task:
	[T][✘] study
Now you have 1 task in the list
--------------------------------------------------------------------------------------------
```

If the `**TASK_DESCRIPTION**` is empty, the following would be printed out:
* `todo`
```javascript
--------------------------------------------------------------------------------------------
The description of a todo cannot be empty.
--------------------------------------------------------------------------------------------
```

## Adding a task type deadline
Adds a task of type deadline to the list.

Format: `deadline **TASK_DESCRIPTION** /by **DATE_TIME**`

Parameters:
* `**TASK_DESCRIPTION**`: Description of task.
* `**DATE_TIME**`: Date and time in the format YYYY-MM-DDtHHmm, 
* where YYYY = year, MM = month, DD = day, HH = hour, mm = minute.

Examples:
* `deadline do IP /by 2019-09-08t1700`
```javascript
--------------------------------------------------------------------------------------------
Got it. I've added this task:
	[D][✘] do IP (by: 8 SEPTEMBER 2019, 1700)
Now you have 2 tasks in the list
--------------------------------------------------------------------------------------------
```

If an input which did not follow the format is inputted, the following are examples of what would be printed out:
* `deadline prepare oral `
```javascript
--------------------------------------------------------------------------------------------
Sorry I do not understand what you mean!
Do bring out help list via the command 'help' for the specific format!
--------------------------------------------------------------------------------------------
```

* `deadline study /at 2013-08-09tyyy`
```javascript
--------------------------------------------------------------------------------------------
Something went wrong!! I do not understand what you mean.
There could be an error in the way of input.
Please do input 'help' for the commands and their respective input format.
--------------------------------------------------------------------------------------------
```

* `deadline`
```javascript
--------------------------------------------------------------------------------------------
The task you input has missing fields!
Please do input 'help' for the commands and their respective input format.
--------------------------------------------------------------------------------------------
```

>Things to take note of:
>* `**DATE_TIME**` is according to the 24-hour clock. (e.g. 1800)

## Adding a task type event
Adds a task of type event to the list.

Format: `event **TASK_DESCRIPTION** /at **DATE_TIME**`

Parameters:
* `**TASK_DESCRIPTION**`: Description of task.
* `**DATE_TIME**`: Date and time in the format YYYY-MM-DDtHHmm, 
* where YYYY = year, MM = month, DD = day, HH = hour, mm = minute.

Examples:
* `event study CS2113 /at 2016-09-18t1500`
```javascript
--------------------------------------------------------------------------------------------
Got it. I've added this task:
	[E][✘] study CS2113 (at: 18 SEPTEMBER 2016, 1500)
Now you have 3 tasks in the list
--------------------------------------------------------------------------------------------
```

If an input which did not follow the format is inputted, the following are examples of what would be printed out:
* `event prepare oral `
```javascript
--------------------------------------------------------------------------------------------
Sorry I do not understand what you mean!
Do bring out help list via the command 'help' for the specific format!
--------------------------------------------------------------------------------------------
```

* `event study for mid terms /at 2013-08-09txxx`
```javascript
--------------------------------------------------------------------------------------------
Something went wrong!! I do not understand what you mean.
There could be an error in the way of input.
Please do input 'help' for the commands and their respective input format.
--------------------------------------------------------------------------------------------
```

* `event`
```javascript
--------------------------------------------------------------------------------------------
The task you input has missing fields!
Please do input 'help' for the commands and their respective input format.
--------------------------------------------------------------------------------------------
```

>Things to take note of:
>* `**DATE_TIME**` is according to the 24-hour clock. (e.g. 1800)

## Displaying the task list
Prints out all tasks added to list.

Format: `list`

Examples:
* `list`
```javascript
--------------------------------------------------------------------------------------------
Here are the tasks in the list
	1.[T][✘] study
	2.[D][✘] do IP (by: 8 SEPTEMBER 2019, 1700)
	3.[E][✘] study CS2113 (at: 18 SEPTEMBER 2016, 1500)
--------------------------------------------------------------------------------------------
```

If the list is empty, the following would be printed out:
* `list`
```javascript
--------------------------------------------------------------------------------------------
Here is the task in the list
--------------------------------------------------------------------------------------------
```

## Marking a task as done
Marks the specified task as completed.

Format: `done **TASK_INDEX**`

Parameters:
* `**TASK_INDEX**`: Index of task in list.

Examples:
* `done 1`
```javascript
--------------------------------------------------------------------------------------------
Nice! I've marked this task as done:
	[T][✓] study
--------------------------------------------------------------------------------------------
```

If the `**TASK_INDEX**` cannot be found in list, the following would be printed out:
* `done 4`
```javascript
--------------------------------------------------------------------------------------------
Something went wrong!! I do not understand what you mean.
There could be an error in the way of input.
Please do input 'help' for the commands and their respective input format.
--------------------------------------------------------------------------------------------
```

## Deleting a task from list
Deletes the specified task from the list.

Format: `delete **TASK_INDEX**`

Parameters:
* `**TASK_INDEX**`: Index of task in list.

Examples:
* `delete 1`
```javascript
--------------------------------------------------------------------------------------------
Noted. I've removed this task:
	[T][✓] study
Now you have 2 tasks in the list
--------------------------------------------------------------------------------------------
```

If `**TASK_INDEX**` is not found in list, the following are examples of what would be printed out
* `delete 10`
```javascript
--------------------------------------------------------------------------------------------
Sorry the index of task to be remove cannot be found!
--------------------------------------------------------------------------------------------
```

* `delete a`
```javascript
--------------------------------------------------------------------------------------------
Something went wrong!! I do not understand what you mean.
There could be an error in the way of input.
Please do input 'help' for the commands and their respective input format.
--------------------------------------------------------------------------------------------
```

## Finding a keyword in list
Find tasks with the keyword included in the task description.

Format: `find **TASK_KEYWORD**`

Parameters:
* `**TASK_KEYWORD**`: Keyword to search for in tasks description in list.

Examples:
* `find do`
```javascript
--------------------------------------------------------------------------------------------
Here are the matching tasks in your list:
	2.[E][✘] study CS2113 (at: 18 SEPTEMBER 2016, 1500)
--------------------------------------------------------------------------------------------
```

If `**TASK_KEYWORD**` is not found, the following would be printed out:
* `find one`
```javascript
--------------------------------------------------------------------------------------------
Here are the matching tasks in your list:
--------------------------------------------------------------------------------------------
```

>Things to take note of:
>* `**TASK_KEYWORD**` is case-sensitive.
>* the indexes printed out is the index of the respective tasks in the list.
    >* In the case of the 1st example, the index of `event study CS2113` is found in index 2 of the list.

## Printing the help list
Prints out the commands available and their respective input format.

Format: `help`

Example:
* `help`
```javascript
--------------------------------------------------------------------------------------------
Commands available: list, help, done, todo, deadline, event, delete, find, save, bye
The expected format of input values: 
	list - prints list of data inputted
	help - pulls out commands available and their input format
	done x - x is index of data that you want to mark as done
	todo x - x is task description
	deadline x /by DATETIME - x is task description, DATETIME is deadline date and time
	event x /at DATETIME - x is task description, DATETIME is event date and time
		Format for DATETIME is YYYY-MM-DDtHHmm, where
		YYYY = year, MM = month, DD = day, HH = hour, mm = minute
	delete x - removes task located at index x of the list
	find x - looks for task description with x included
	save - saves current list
	bye - terminates the program
--------------------------------------------------------------------------------------------
```

## Saving the current list to file
Saves current list to file without exiting program.

Format: `save`

Example:
* `save`
```javascript
--------------------------------------------------------------------------------------------
The current list has been saved.
--------------------------------------------------------------------------------------------
```

## Exiting the program
Saves the current list to file and exits program.

Format: `bye`

Example:
* `bye`
```javascript
--------------------------------------------------------------------------------------------
Bye. It was a pleasure serving you.
The current list has been saved.
Hope to see you again soon!
--------------------------------------------------------------------------------------------
```

## Command Summary

 Action    | Format, Example 
---------- | ----------              
ToDo | `todo TASK_DESCRIPTION`, `todo study` 
Deadline | `deadline TASK_DESCRIPTION /by DATE_TIME`, `deadline do IP /by 2019-09-08t1700`
Event | `event TASK_DESCRIPTION /at DATE_TIME`, `event study CS2113 /at 2016-09-18t1500`
List | `list`
Done | `done TASK_INDEX`, `done 1`
Delete | `delete TASK_INDEX`, `delete 1`
Find | `find KEYWORD`, `find do`
Help | `help`
Save | `save`
Exit | `bye`

### --- END OF USER GUIDE ---