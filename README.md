# JymJam

It’s hard to find the motivation to go to the gym alone. 
Personal trainers certainly keep you focused, but they are expensive. 
Workout buddies are the best, but often time your friends have different schedules. 
Here, we introduce JymJam, an app connecting you to either workout buddies or local gym enthusiast who are 
planning to work-out at the same time as you. 
Our application matches you with a person at a similar skill/strength level, and similar workout regime, 
and enables you to get the most of your workout.

The application has two features: it can connect you to a workout buddy, or a personal trainer. In the workout buddy feature,
you will be connected to another person planning on heading to the same gym who plans to do a similar type of workout (cardio,
 upper-body, lower-body, etc.) and has a similar fitness level. Our personal trainer feature connects you with a local gym
 enthusiast looking to make money in his/her spare time. Rates will be much cheaper than hiring a certified personal trainer.
 
 ## Inspiration
 
 The inspiration for this application primarily because two of us (who are room-mates) hated going to the gym, and completing
 repetitive exercises for what felt like forever. When we started going together, however, workouts became a lot more fun. When
 we brainstormed ideas for HackMIT, we immediately fell in love with the idea of connecting people who want to go to the gym.
 
 ## How we built it
 
 We built this app using android-studio, JAVA, XML, Node.js. We used JAVA and XML to create dynamic and aesthetic activities
  (panes) for each application window. We employed the **facebook API** for easy and fast log-in and authentification. We also
  used the facebook API to fill out survey questions (Name), as well as to display a profile picture. We leveraged many advanced
  features in Android Studio, including notifications, in building the application. 
  
  In order for the application to interact with a remote server, we used Node.js. All entries are entered in a queue, and each
  is matched accordingly based on gym location, gym time, type of workout, etc. using a matching/sorting algorithm. Finalized information
  is then sent back to paired users.
  
## Challenge we ran into

None of us had any experience with mobile app development. Thus, android studio was totally new to us. Nevertheless, we
managed to learn and implement android-studio is less than 24 hours. Our biggest challenge was implementing a remote server
communication with the application.
  
