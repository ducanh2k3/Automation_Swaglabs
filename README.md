# Swag Labs Automation Project

This project contains automated tests for the Swag Labs website. It utilizes Selenium WebDriver with Java to automate interactions with the website.


## Prerequisites

Before running the tests, ensure you have the following installed:
- Java Development Kit (JDK) 8 or higher
- Selenium WebDriver
- WebDriver compatible with your browser (e.g., ChromeDriver)
- 
You can install the JDK from [here](https://www.oracle.com/java/technologies/javase-downloads.html). To install Selenium WebDriver, you can use Maven or Gradle.

For Maven, add the following dependency to your `pom.xml`:
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.141.59</version>
</dependency>
   <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>RELEASE</version>
      <scope>test</scope>
    </dependency>
<dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.apache.poi</groupId>
      <artifactId>poi</artifactId>
      <version>5.2.3</version>
    </dependency>
    <dependency>
      <groupId>org.apache.poi</groupId>
      <artifactId>poi-ooxml</artifactId>
      <version>5.2.3</version>
  </dependency>

#Project Structure
swag-labs-automation/

│
├── src/
│   ├── main/                              # (if applicable, for application code)
│   │
│   └── test/
│       ├── java/
│          ├── Base/
│          │   ├── TestBase.java         # Base class for test cases
│          │   └── BasePage.java         # Base page class with common functionality
│          │
│          ├── Page/
│          │   ├── LoginPage.java        # Page object for login page
│          │   ├── CartPage.java         # Page object for cart page
│          │   ├── CheckoutPage.java     # Page object for checkout page
│          │   ├── CheckoutStep2Page.java# Page object for checkout step 2 page
│          │   ├── HomePage.java         # Page object for home page
│          │   ├── ItemPage.java         # Page object for individual item page
│          │   └── CompletePage.java     # Page object for complete page
│          │
│          ├── TestCase/
│          └── TestCase1.java       # Test case for scenario 1
│      
└── data.xlsx                 # Test data (Excel file)
│       
│          
│
└── README.md                            # This file

Test Case :
Test Case 1 :

Steps:
1.Access to sauce demo website
2.Login with standard user
3.Select first product
4.In production detail page, click Add to cart button
5.Navigate to cart page
6.Click on checkout button
7.Fill checkout information. Example: Lastname: Quang, firstname: Le, Zipcode: 70000
8.Click continue button
9.Double check data, compare with filled data
10.Click finish button
Expected result:
#9 The data display should be matched with filled data in step #7
#10 The order completed page should display with message "Thank you for your order!"

Test Case 2 :
Steps:
1.Access to sauce demo website
2.Login with locked_out_user
3.Verify the url
Expected result:
#1 The url shouldn't change
#2 The warning should display with message "Epic sadface: Sorry, this user has been locked out."

Test Case 3 :
Steps:
1.Access to sauce demo website
2.Login with problem_user
3.Verify the url
4.Compare the src of all images of item
Expected result:
#1 The website should navigate to Home Page
#2 The src of all images should be the same.







