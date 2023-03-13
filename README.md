# Employee-Application Assigment for Internship

# Setup guide:
1. Download JavaFX from https://gluonhq.com/products/javafx/, for example im using Windows version 19.0.2.1 SDK
2. Download MySQL connector https://dev.mysql.com/downloads/connector/j/
3. If you dont have MySQL, download it from here https://www.mysql.com
4. Download the Project folder from repository, open it via Intelij or other IDE.
5. Connect the project with javafx and mysql libraries, this can be made by opening File -> Project structure -> libraries -> + -> Java -> your directory, note that its needed to select path to javafx-sdk-19.0.2.01 and mysql-connector-8.0.32 or other version, otherwise project wont start.
6. After all, open Mysql Workbench and in this repository there is a folder call mysql which needs to be opened
7. In the Navigator pane, right-click on the schema where they want to import the database, and select "Create Schema".
8. Click on the "Data Import" option in the main menu.
9. In the Data Import wizard, select the file format of the exported file and choose the location of the exported file.
10. Click the "Start Import" button to begin the import process.
11. Final step is to open the code and more especially in classes which ends with DBUtils, there can be found method openDB(), need to be changed root and password

# Architecture:
There is 3 main classes which work mostly, this are the classes which communicate with the database, they ends with DBUtils. All of those classes implements Interfaces for better maintanablity. The Project is divided on 2 packages, DBUtils package can be started locally for test or if occur problem with opening javaFX scenes, running the console version can be made from Main class in the package. In the other package, all scenes are separeted on individual class, called Controller, logic in this controller is pretty simple, to make changes on the table view, need to press buttons or to type something in text fields. This is a briefly overview.

The Java application has been enhanced with additional functionality, including MySQL and JavaFX. MySQL was chosen because i currently studying it in university and there have some experience with it. JavaFX was selected because it was covered in a Udemy course that i took, and i felt most familiar among available extensions.
