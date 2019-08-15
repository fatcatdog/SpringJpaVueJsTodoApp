This is a "todo" or "task manager" CRUD app build with SpringBoot,SpringREST,Spring JPA, mySql, and VueJs. On my machine I have Java 8 and MySql 8 installed.

![Users can see all tasks](/images/pictureOfTodoApp.png)

![Users can add a task](/images/submitNew.png)

![Users can update or delete a task](/images/updateTask.png)

------------------------------------------------------------
To run with Docker
------------------------------------------------------------
If you notice the contents of application.properties difers from the following, please replace the contents of /demo/src/main/resources/application.properties with:

Change application.properties from
spring.datasource.url=jdbc:mysql://mysql-standalone:3306/tododb
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.ddl-auto = update
server.error.whitelabel.enabled=false
server.port=8081

------------------------------------------------------------
To run locally (without Docker)
------------------------------------------------------------

Clone the repo. Open your preferred Java IDE of choice, import as maven project.

Please replace the contents of /demo/src/main/resources/application.properties with:

####spring.datasource.url=jdbc:mysql://localhost:3306/whateverYourYouWantYourDBSchemaIsNamed?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC
#### spring.datasource.username=whateverYourMysqlUsernameIs
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.ddl-auto = update
server.error.whitelabel.enabled=false
server.port=8081
#### spring.datasource.url=jdbc:mysql://localhost:3306/whateverYouWantToNameTheDB
(Notice the bolded lines have variables in them that need to be changed to your setup)

Assuming you have Java8, Maven, and MySql set up correctly, you should be able to right click DemoApplication.java: run as SpringBoot project.

Or you can run with maven: CD into the project and then: mvn spring-boot:run

The demo folder is the SpringBoot project. This project runs on port 8081.To view available REST endpoints, please visit http://localhost:8081/swagger-ui.html#/ after running project which exposes the Swagger UI.

------------------------------------------------------------
The client folder in this repo is the Vue.js project. This runs on port 8080.
------------------------------------------------------------

CD into client, then do the following:
npm install
npm run serve

I am in the process of setting these projects up to work with Docker. You would need to have Docker running to do this. Here are the current commands to getting the MySql Server running, the Java app running, and the VueJs project running all in individual containers.
(I ran Docker with MySqlServer 5.7. Make sure these DB settings match your application.properties file in the Java app)
docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=tododb -e MYSQL_USER=user -e MYSQL_PASSWORD=password -d mysql:5.7

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

------------------------------------------------------------
Happy coding and feel free to message me if you have any problems/questions
