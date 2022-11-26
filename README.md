# UI Automation using Java and Cucumber

# REST API Automation with Rest Assured (Java)


Below are the required steps in order to setup the project 

## Table of Contents
1. [Setup process](#setup)
2. [Running the project](#running)

# Setup process

1. Install Java on the system, currently I am using Java 11 

2. Install Maven or Gradle on the system, I am using Maven where it can be downloaded from https://maven.apache.org/download.cgi

3. Open a terminal and create a new project for cucumber automation using this command

```
mvn archetype:generate                      \
   "-DarchetypeGroupId=io.cucumber"           \
   "-DarchetypeArtifactId=cucumber-archetype" \
   "-DarchetypeVersion=7.5.0"               \
   "-DgroupId=hellocucumber"                  \
   "-DartifactId=hellocucumber"               \
   "-Dpackage=hellocucumber"                  \
   "-Dversion=1.0.0-SNAPSHOT"                 \
   "-DinteractiveMode=false"
```

4. Download a chromedriver from https://chromedriver.chromium.org/downloads and choose the appropriate version for your browser
Currently I am using chrome version 107 thus if you have a different version then you should download and replace the chromedriver
located in this repo

5. Open pom.xml and write down the required dependencies

# Running the project

1. Open up a terminal or command prompt and navigate to the project directory

2. Run the following command

```
mvn test
```

3. The execution of automation will be executed via the browser driver

