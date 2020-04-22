# java-microservice
To run this localy You need to run consul dev agent before executing these two micro service 
Download consul from : https://www.consul.io/downloads.html, then unzip it and you will get and executable name as "consul"
Then run the following command
Here is the command:  ./consul agent -dev

You need to have maven install into your system, these two service using maven build system

Build command: mvn clean install 
Run command:  java -jar clientservice-0.0.1.jar (jar file location)


To access the swagger UI for client service :  http://localhost:8080/api/swagger-ui.html

This is a Example for communication of Micro service with service discovery
in this example there are two service 
   1. clientservice
   2. calculatorservice

Clientservice service is receiving the request to operate on two Operands, after receiving the request It executes the 
the necessery Logic and call the  calculatorservice to get the calculation done

Normally in REST service we call any other services using any normal HTTP client (like RestTemplet) and We use http URL 
along with domain name or IP address ( Like : http://exaple.com/api/addition or http://127.0.0.1:8080/apa/addition) here 
Services address need to well known before we call those services.

But in this case each and every Micro service Register them self into a discovery server ( in this example I have user consul 
service discovery) And with the help of Ribbon Client we can call those micro services through discovery server.

In this example Once you start both the services in your local machine :
in the consul dashboard (http://localhost:8500/ui/dc1/services) you will able to see the Service name listing 
and their health check status.


For Ribbon Http client I have used Feign Client, And Feign readTimeout && connectTimeout is 
configured in application.properties file

For circuit breaker I have used Hystrix, In the clientservice , we have used Hystrix command at the time of calling the 
calculatorservice, if calculatorservice is not available, then Hystrix fallback command will executed and clientservice 
will provide a default response.


