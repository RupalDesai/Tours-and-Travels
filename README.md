# Tours-and-Travels

It is a web application to book travel packages online. It has a feature to get the estimate price of the trip for free as guest user. This feature was added in order to increase the search result ranking of the website. Also, there is an Admin side to maintain tour packages, images related to tours, list of locations were service are provided, flight and hotel prices, to handle feature packages. Tomcat HTTP Server is used as a localhost on post 8080 to communicate between client and server. PHPmyAdmin is used for backend database. Technologies used were Java, JavaScript, SQL, CSS, HTML. MVC architecture is used for development to maintain the modular structure.

Landing page URL - localhost:8080/Tours

Features offered on front-end were
1. Calculate the estimate of the round trip, the factors taken into consideration are
        1. Which country is selected
        2. Number of days to visit
        3. Number of people 
are taken as input to calculate the approximate price of the trip 
(fligtPrice * numberOfPeople + hotelPrice * numberOfPeople * numberOfDays)

2. Shows all the featured tours and give them access to book tour using a form submission (payment method was not implements). 
The inputs were validated and displayed a success message.

3. Register and login functionality

Admin - localhost:8080/Tours/Admin

The task admin can controll from backend features like
1. Add/Modify/Delete Tour Packages - (Like hotel prices, flight price)
2. Add/Delete images to Packages - (used apache commons to handle file upload)
3. Add/Modify/Delete List of Countries
4. Can alterate featured packages on front-end

There are total four database tables
1. Continent (Id, Name)
2. Country (Id, Country_Name, flight_price, star2, star3, star5, continent_id)
3. Images (imageId, Name, package_id)
4. Package (Id, Pname, Pdetails, price, continent_id, Pfeatured)

To improve:
1. Data Management like flight prices, hotel prices was handled manually by Admin but could be handled with live data
2. Payment method to book packages was not implemented.
