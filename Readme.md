# ROBOT apocalypse
The year is 2050 and the world as we know it has been taken over by robots. Created as
once friendly robots, have now turned against humankind, especially software engineers
like yourself. Their mission is to transform everyone into mindless zombies for their
entertainment.

### Features
- Add survivors to the database
- Update survivor location
- Flag survivor as infected 
- Connect to the Robot CPU system

### How to Run the Application
Clone the git Repo(if you are can see this you are past this step)

#### As a Jar File
```shell
git clone https://github.com/timnjonjo/survivors-robot-apocalypse.git
cd  survivors-robot-apocalypse
#Build the Jar file
mvn clean package
java -jar target/robot-apocalypse-1.0.0.jar
```

#### As a Docker Container

```shell
# Build jar file
mvn clean package
docker build -t robot-apocalypse:1.0.0 .
docker run --rm  -p 8080:8080 robot-apocalypse:1.0.0 
```
Access the app on ; localhost:8080/swagger-ui/index.html


