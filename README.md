## MusalaSoft-Task
The Framwork is built using Selenium WebDriver in Java Language and Designed using Page Object Model design pattern.
Class for each web page which includes its element locators and methods.
Base class to keep generic methods and Configuration File is created to keep info like URL , Files xpath .
The Framwork support parallel execution and data driven testing from an Excel file.

# Tools 
Selenium Webdriver, Maven, TestNG, Apache POI and Extent Reports

# Packages 

Pages Package : Includes classes which contain webpages.
Helpers Package :Includes Classes which help
Tests Package : Includes all tests .

![Packages](https://user-images.githubusercontent.com/78497060/146079390-47cef272-b5c2-48f2-9b7c-94c2e405d807.PNG)

# Configuration File
This file stores the information which is used during testing  browser-specific information to support two browsers -chrome&firefox-, ScreenShots Folder Path, Base URL  and Test data path.


![configu](https://user-images.githubusercontent.com/78497060/146080153-669e7323-dd23-4cc5-98a5-e5d9144dc4f4.PNG)

# Parallel Execution

Using TestNG XML file.

![parrel](https://user-images.githubusercontent.com/78497060/146079546-2f764f2e-a429-46dd-ad88-bde477411181.PNG)
# Reporting

Using Extent Report .

![extent](https://user-images.githubusercontent.com/78497060/146079382-99c533ed-cfb1-4e76-bb42-fb594350e146.PNG)
![extent1](https://user-images.githubusercontent.com/78497060/146079387-d722026c-f13e-49e8-ab46-58ff1697c1f6.PNG)
