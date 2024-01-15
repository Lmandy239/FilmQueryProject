# FilmQueryProject

# Description
Project using databases and java. It is a text based application that retrieves data from a database in mysql. It is menu-based, allowing the user to choose actions and submit query data.

Instructions: 

1- Run the program as a Java application or compile it using the `javac`  command from the terminal and then execute it. 

2- Once the program opens:

The user is presented with a menu in which they can choose to:

-Look up a film by its id.

-Look up a film by a search keyword.

-Exit the application.

-Simply choose as desired and follow the instructions, invalid answers will return the user to the main menu. 


** NOTE: The second option within the sub menu, to display additional info, is a stub; selecting this option will lead to termination of the program. 

# Tech used
Java

MySQL

JDBC (Java Database Connectivity)

# Lessons Learned

It is very hard to translate query data into the methods; sometimes it will result in errors that at first seem to be due to typos in MySQL; however, it is usually an invalid prompt within the result sets.

I spent a lot of the project plugging in data and playing with the methods. Sometimes my methods simply had too much going on, which led to the creation of other methods. For example, at first I tried to produce the list of actors from each movie within the respective film search methods. This would work if I printed the list within those methods, but the idea was to only print stuff in the DBO as debugging statements, and keep all the interface interaction within main.

Overall, I feel like this project challenged me in more ways than one. I'm looking forward to expanding upon this subject; some extra practice would also help.