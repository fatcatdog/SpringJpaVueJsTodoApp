This is a "todo" or "task manager" CRUD app. For those who want to run these projects locally without Docker, on my local machine I have Node.js, npm, Maven, Java 8, and MySql 8 running. Towards the bottom of this page I provide instructions on how to configure the SpringBoot project to run locally (requires one file change). I was on a Mac when I built these apps so Windows terminal commands might differ.

This full-stack application contains the following:

-MySql database

-Java 8, SpringBoot, JPA backend project with an embedded Tomcat server (located in the demo folder of this repo)

-VueJs frontend  (located in the client folder of this repo)

At the top of this README.md i provide instructions to run with Docker Compose, below that i provided instructions for just Docker, and below that I provided instructions on how to run these applications locally without Docker.

I assume to get these projects running successfully you will need to have ports 8080, 8081, and 3306 open.

This was my first time implementing Jest so those tests probably could use a lot of work. Furthermore, this Vue project is basically screaming to be refactored. Currently there is a lot of unnecessary code that could be shared, and the app should probably share some kind of data (or state in React terms) as currently it doesn't.

![Users can see all tasks](/images/pictureOfTodoApp.png)

# To Run Project with Docker Compose

Please clone this repo. Please CD into project. (You could also just copy the docker-compose.yml from repo into a folder of your choice on local and CD into that folder) Run:

## docker-compose up

At this point the projects should be pulled and ran. It might take a few minutes if your internet connection is slow. To confirm our three Docker containers are running, please open a new tab in terminal and run:

docker ps

You should see three docker containers running.

#### Our client VueJs is running at: http://localhost:8080

#### You can view more information about the task REST API running in our SpringBoot project at our Swagger UI which is hosted at: http://localhost:8081/swagger-ui.html

# If you do not want to use Docker Compose, here are instructions to run with just Docker:

------------------------------------------------------------
1. Pull MySql container and run MySql Server container
------------------------------------------------------------
#### docker pull mysql:5.7

#### docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=tododb -e MYSQL_USER=user -e MYSQL_PASSWORD=password -d mysql:5.7

------------------------------------------------------------
2. Pull Java app container and run app linked to MySql Server container
------------------------------------------------------------

#### docker pull ducheman/ourjavaapp:latest

#### docker run -p 8081:8081 --name ourjavaapp --link mysql-standalone:mysql -d ducheman/ourjavaapp:latest

------------------------------------------------------------
3. Pull VueJs client container and run container
------------------------------------------------------------

#### docker run -it -p 8080:8080 --rm --name client ducheman/vuejsclient:latest

<!---
------------------------------------------------------------
We are first going to get our MySql Server running in Docker.
------------------------------------------------------------

docker pull mysql:5.7

docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=tododb -e MYSQL_USER=user -e MYSQL_PASSWORD=password -d mysql:5.7

------------------------------
CD into the demo(the java app) directory
------------------------------

mvn clean package -DskipTests

docker build . -t ourjavaapp

docker run -p 8081:8081 --name ourjavaapp --link mysql-standalone:mysql -d ourjavaapp

------------------------------
CD into the client(the VueJs app) directory
------------------------------

docker build -t client .

docker run -it -p 8080:8080 --rm --name client client

------------------------------------------------------------

At this point you should have three containers running after you type this command in terminal:

Docker ps

If you see three images running, maybe the application is running and you should check the Vue.js' app's logs to see where it is hosted!
-->

------------------------------------------------------------
# To run locally (without Docker)
------------------------------------------------------------

Clone the repo. Open your preferred Java IDE of choice, import as maven project.

Comment the code that was not commented.
Uncomment the code that was commented.

Assuming you have Java8, Maven, and MySql set up correctly, you should be able to right click DemoApplication.java: run as SpringBoot project.

Or you can run with maven: CD into the project and then: mvn spring-boot:run

The demo folder is the SpringBoot project. This project runs on port 8081.To view available REST endpoints, please visit http://localhost:8081/swagger-ui.html#/ after running project which exposes the Swagger UI.

------------------------------------------------------------
The client folder in this repo is the Vue.js project. This runs on port 8080.
------------------------------------------------------------

UI was not a priority for this project. In public/index.html of the client app, I simply imported: unpkg.com/primitive-ui/dist/css/main.css in the header

CD into client, then do the following:
#### npm install
#### npm run serve

If you want to run the Jest unit tests in the VueJs project,

### npm test

If you ran the java app previously, you should now be able to see some pre-populated items in our task list. If you havent ran the java app yet, you hopefully can see an empty todoApp with no tasks inputted yet (and no database...)!

![Users can add a task](/images/submitNew.png)

Image of adding new Task

![Users can update or delete a task](/images/updateTask.png)

Image of updating or deleting a task.

------------------------------------------------------------
Happy coding and feel free to message me if you have any problems/questions
