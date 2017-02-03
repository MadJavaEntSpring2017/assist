# Benjamin Nisler Individual Project


### Problem Statement

I have been a part of the Madison Soccer Association as a player for the last 6 years playing on a couple of Men's 11s teams. It has only been over the last couple of years that I have been asked to be co-manager of one of the Division 2 teams. While experiencing the league as a player has its own challenges and opportunities, seeing first-hand what goes into planning for a season and the week-to-week scheduling, it became clear that the current system of paper forms and spreadsheets no longer cuts it.

This project will serve as my attempt to centralize the record keeping for establishing and maintaining a soccer team within the league. The finished project will allow users of various roles (players, managers) to log into the system. The player's perspective will allow them to designate their availability for specific matches throughout the season and enter in their contact information. The manager's perspective will allow them to see their current player list, the week's active roster, whether or not a player has been registered and the team and player contact information.

Establishing a central location for players and managers to check in will keep everyone up-to-date. Time permitting, I would like to further develop this into an organizational tool for the entire league. This would involve managing officials, schedules and locations to play the match, and allow the league manager to keep track of and register players.

### Project Technologies/Techniques

* Authorization/Authentication
  * Admin role: all access, CRUD of all data
  * User roles: Players, Managers, Officials
* Database (MySQL + Hibernate)
  * Store users and roles
  * Store player, manager, team, match information
* Spring Framework (Data, WebMVC)
* AngularJS Framework (Material Design)
* Logging
  * Configure log4j to allow error logging in production, but debug logging for development.
* Application and Database hosted on AWS
* Unit Testing
  * Test repository calls to the database
  * Test methods other than getters/setters

### Design

 * [Screen Design](docs/DesignDocs/Screens.md)

### [Project Plan](docs/ProjectPlan.md)


### [Time Log](docs/TimeLog.md)
