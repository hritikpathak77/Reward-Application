Rewards Program Calculator - Spring Boot
This Spring Boot application provides a RESTful endpoint to calculate reward points earned by customers based on their purchase transactions over three months. The reward points are awarded according to the rules specified by the retailer.

Problem Statement
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction.

For example, for a $120 purchase:

$50 qualifies for 1 point
$100 qualifies for 2 points
Total reward points: 1x$50 + 2x$20 = 90 points.

Technologies Used
Java
Spring Boot
Maven

How to Run the Application
Clone the repository:

git clone https://github.com/hritikpathak77/Reward-Application.git

Navigate to the project directory:
cd Reward-Application

Build the application:
mvn clean install

Run the Spring Boot application:
java -jar target/Reward-Application-1.0.0.jar

The application will start on http://localhost:8080.
