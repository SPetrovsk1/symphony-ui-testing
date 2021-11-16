# symphony-ui-testing

Please take the following steps when trying to set-up the project for the first time:

Preconditions:
1. Have java installed (version 11 or up) and the JAVA_HOME property set.
    - Useful link: https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html
2. Have maven installed(latest version) and the MAVEN_HOME property set.
    - Useful link: https://www.tutorialspoint.com/maven/maven_environment_setup.htm
3. Have IntelliJ IDE installed (I was using Intellij IDEA 2021.2.3 but they should all work). 

Steps:
1. Download or clone the project.
2. Import the project into Intellij.
    -If asked for SDK, choose the latest java version you have.
3. If the project is not automatically recognised by maven, right click the pom file and choose Maven->Reload Project
4. Run the following command in the terminal : "mvn clean install"
    -The command will also run the tests, in order to skip them use "mvn clean install -DskipTests"
5. Once everything is set up, you can run the tests by opening the Class File and clicking run manually.
    -To run the full suite (There is currently only one), right click on it and choose the run option.
6. To run the tests in different browser, change the property from chrome to either "chrome-headless" or "firefox".
7. The tests can also be run from the command line with different parameters.