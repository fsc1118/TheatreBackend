# Testing the Theatre Web App Locally

## Deployment to Heroku

Though the web app was deployed to heroku @ <a href="https://cs348-theatre.herokuapp.com/">cs348-theatre.herokuapp.com</a>, Heroku's connection is currently spotty due to a recent hacker attack. Therefore, for testing of the full functionality of the web app, it would be best to set up and environment locally and test both the frontend and backend in this manner. 


## Steps to Set Up Local Testing Environment

### Step 1: Git Clone Repositories

Git clone the following repositories: 
- `https://github.com/fsc1118/TheatreBackend`
- `https://github.com/fsc1118/Theatre`
- `https://github.com/minlu21/CS348_Project_SQL`

`TheatreBackend`: Contains the Spring Boot backend server code for tha app.<br/>
`Theatre`: Contains the React frontend code for the app. <br/>
`CS348_Project_SQL`: Contains useful code for adding fake data for testing the app and the stored procedures used in the backend code.


### Step 2: Setup Database and Install Backend Code Dependencies

- Create a MySQL database called `theatre`.
- Make sure all Maven dependencies are installed.
- Under `src/main/resources`, there is an `application.properties` file. Please make sure to configure `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` to point to your own local database.


### Step 3: Create Procedures in MySQL Database

- All procedures used for the app is under the `queries` folder in the `CS348_Project_SQL` repo.
- There are also 2 procedures used to insert data inside the `data` folder in `movie_showing.sql` and `seats.sql`.
- Add all these procedures prior to the following step.


### Step 4: Run the Web App
- Run `TheatreApplication.java` under `src/main/java/com.example.theatre`.
- If the run is successful, you should see newly generated empty tables `ticket`, `movie_showing`, `movie`, `user`, `room`, and `seat`.


### Step 5: Insert Fake Data
- Insert the fake data used to test the web app. The data is located under the `data` folder in the `CS348_Project_SQL` repo.


### Step 6: Set Up Frontend
- Follow the steps in the README.md of the `Theatre` repo to set up and run the frontend.
