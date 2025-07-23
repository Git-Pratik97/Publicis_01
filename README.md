Publicis_01
==========

Overview
--------
This project provides an orchestration API to load recipe data from an external dataset into an in-memory H2 database and exposes REST endpoints for retrieving recipes based on user criteria. It also includes a ReactJS frontend for performing free-text searches, sorting, and filtering recipes.

Installation
------------

Backend API Setup:
1. Clone the Repository:
   git clone https://github.com/Git-Pratik97/Publicis_01.git --branch master
   cd Publicis_01
   git checkout master

2. Set Up Dependencies:
   Ensure Java (JDK 17+) and Maven are installed.
   mvn clean install

Frontend Setup:
1. Navigate to the frontend directory:
   cd frontend

2. Install dependencies:
   npm install

Building the Project
--------------------

Backend Build:
Compile and package the Spring Boot application:
   mvn package

This will generate a JAR file in the target/ directory.

Frontend Build:
Create a production-ready frontend build:
   npm run build

Executing the Application
-------------------------

Running Backend:
Run the Spring Boot application:
   java -jar target/Publicis_01-<version>.jar

Or, using Maven:
   mvn spring-boot:run

Running Frontend:
Start the ReactJS application:
   npm start

This will run the frontend on http://localhost:3000/.

API Endpoints
-------------

Loading Data into In-Memory H2 DB:
- POST /recipes/load
  Loads recipes from the external dataset into the in-memory H2 database.

Retrieving Recipes:
- GET /recipes?search=<name_or_cuisine>
  Retrieves recipes based on free-text search for name or cuisine.

- GET /recipes/{id}
  Fetches a specific recipe by ID.

Using Swagger for API Testing
------------------------------

1. Start the backend application.
2. Open your browser and visit:

   http://localhost:8080/swagger-ui/index.html

3. Explore and test API endpoints interactively.

Frontend Features
-----------------

- Global Search Bar: Allows users to search for recipes by name or cuisine.
- Grid Display: Shows matching recipes in a structured format.
- Client-Side Sorting: Sorts recipes by cookTimeMinutes.
- Responsive Design: Optimized for different screen sizes.
- Lazy Loading: Improves performance by dynamically loading UI components.

Clean Code Practices
--------------------

Backend:
- Modular design
- Application logging & exception handling
- Environment layering & externalized config parameters



