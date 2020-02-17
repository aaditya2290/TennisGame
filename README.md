Tennis Game

Tennis Game kata which has been implemented in java ia a simple program which takes the player names and player scores as inputs
and returns the score for the tennis game.

Prerequisities:

1. Java (Version 1.6 or higher)
2. Maven (for dependency management)

To Run Test Cases:

Download project as zip file and unzip the same to a folder. Open a command prompt and goto the project(extracted) folder and 
execute below commands.

mvn clean

mvn install

After completion of above steps, test report will be available in below path.

<PROJECT_ROOT_FOLDER>\target\surefire-reports\TEST-com.bnpp.kata.tennisgame.TennisGameTest.xml

To Run Application:

After successful maven build go to \target\classes and execute below command

java -classpath .\ com.bnpp.kata.tennisgame.TennisGameMain Player1_Name Player1_Score Player2_Name Player2_Score

Here Player1_Name,Player1_Score,Player2_Name,Player2_Score are the four parameters which must be passed.

Eg: java -classpath .\ com.bnpp.kata.tennisgame.TennisGameMain John 2 Andrew 4

