# OO Design and UML
#### Static UML diagram:
![StaticUML](images/StaticUML.png "StaticUML")

This diagram shows the relationships between the classes needed for the user to search for a specific element within the app.

Our motivation for modelling this aspect of the system was the fact that it is the most complex part of the app from a technical point of view. This is mainly due to the fact that we will be using a database to hold the specific information about each element, and at some point we will need to retrieve this data and display it for the user.

There was also some uncertainty about how the _'Search_ _ _Activity'_, _'Current_ _ _Element'_, and _'Element_ _ _View'_ will interact with each other, and specifically where the SQL fetch request will be sent from. Drawing up the static UML diagram helped us to visualise the working of the system, and decide that the most logical place for the database to be accessed from would be the  _'Element_ _ _View'_ class. This decision was based on the fact that both other classes mentioned above interact with  _'Element_ _ _View'_, but also the fact that as it will be the activity where the fetched data is displayed for the user.  

Modelling the search aspect using a static UML diagram allowed us to see the relationships between each class, and also makes us think about the methods and variables needed for each class. Additionally, having represented this part of our system visually allows us to convey how we have designed our classes to interact with each other much easier, improving communication within the team.  
Making our static UML diagram has shown us how many classes are required to make an efficient system, also allowing us to have an insight onto how we may split up the workload between our team when coding the application.  


#### Dynamic UML diagram:
![DynamicUML](images/DynamicUML.png "DynamicUML")

This diagrams dictates how the program flows when a user is searching for a specific element to view in more detail.  

We chose to model this aspect of our program because it is the most complex system within our application. Due to our use of a database within the app to store the element data, we needed to visualise which class the SQL fetch request will be sent from, and where the corresponding data will be sent to, as we were uncertain of these specifics to begin with. To improve readability, and to abstract the element data into one place, we decided to implement the _'Current_ _ _Element'_ class. The SQL fetch request will be sent from the  _'Element_ _ _View'_ class, with the data returned from the database loaded into the _'Current_ _ _Element'_ class. There will only ever be one instance of this class; if multiple elements are viewed in the same session, the variables in _'Current_ _ _Element'_ will be overridden.  
Additionally, the client wished for the search to have predictive functionality. We came up with two possible ways to implement this; SQL requests or string matching algorithm. Collectively, we decided to go with a string matching algorithm due to there already needing to be a data file with all element names. The data that we will need to string match on will therefore already be loaded into the application. The use of the dynamic UML diagram aided in this decision, as it requires less data passing throughout the program, which should hopefully improve both the predictive search speed and the efficiency of the program as a whole.

Modelling the searching aspect of our system using a dynamic UML diagram helped us to visualise the data transfer and interaction between the classes within our application, and also how the user inputs are handled and passed to the correct classed.  
Creating this dynamic UML diagram has taught us how much interaction and data transfer is required within our application. Initially we thought that there would be two transfers of data, however it has become apparent that much more will need to happen to make an efficient system.