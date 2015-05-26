# AppDirect challenge

This is the AppDirect challenge application.
It's built with spring-boot and maven with JDK 8;

Events "SUBSCRIPTION_ORDER" are received and process. All received events are visible on the home page.
I don't implement OpenId, so only events can be received.

## Generate a war

As it's a maven application with spring-boot, all current maven commands will works.
    
    mvn clean package
    java -jar target/appdirect-demo-1.0-SNAPSHOT.war

##Deployement

###Local

Use spring boot plugin to start application locally

    mvn spring-boot:run

###Heroku

To deploy this application on Heroku, you need to setup Heroku : https://devcenter.heroku.com/articles/getting-started-with-java#introduction
After this, just to checkout the project from github, and use these commands :

    heroku create
    git push heroku master

##Test

This application is deploy here :

    https://stormy-crag-4518.herokuapp.com/

To test an event, you can send a request to this url

    https://stormy-crag-4518.herokuapp.com/api/create?token=dummyOrder&eventUrl=https%3A%2F%2Fwww.appdirect.com%2Fapi%2Fintegration%2Fv1%2Fevents%2FdummyOrder

Now, you can see received events on the home page

    https://stormy-crag-4518.herokuapp.com/
