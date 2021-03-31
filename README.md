# aEquilibrium

The Automation framework is built on Java,Selenium, testNG, Maven and used POM 

Steps to setup the environment in Eclipse IDE(Mars and above)

1. Clone the project from github url shared
2. Import the project into eclipse as Maven Project
3. Once the project is imported, just do a clean build Right click on the project -> Run As -> Maven Clean
4. Open the test package and class inside the package
5. Right click on the class -> Run As -> TestNG Test
6. Once it is done wait for the tests to execute
7. Once execution is done, go to the test-output folder and check for index.html
8. If there are any testcases failed because of script issue or functional issue, screenshots will be taken and stored in screenshots folder.
