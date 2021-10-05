# Breaking News
Breaking News is a java Application (Managed by Gradle) thats Reads the “Breaking News” from YNet new service:
http://www.ynet.co.il/Integration/StoryRss2.xml

When connecting to your Web App, the App parses and Presents the Breaking
News XML in an HTML Table Format 
## Running Breaking News locally
Breaking News is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Gradle](https://spring.io/guides/gs/gradle/). You can build a jar file and run it from the command line:


```
git clone https://github.com/AHMADSK1997/Breaking-News.git
cd Breaking-News
./gradlew build
java -jar ./build/libs/BreakingNews-0.0.1-SNAPSHOT.jar
```

You can then access Breaking-News here: http://localhost:8081/

<img width="1042" alt="BreakingNews-screenshot" src="https://imgur.com/2aOq24k.png">

Or you can run it from Maven directly using the Spring Boot gradle plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./gradlew run
```
