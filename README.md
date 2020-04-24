# calculator microservice solution
This project contains 2 services communicating with each other to handle calculation requests from the client.
<h2><a id="Installation_6"></a>Installation</h2>
<p>
To run this locally we need to run consul dev agent before executing these two micro service 
Download consul from : https://www.consul.io/downloads.html, then unzip it and we will get and executable name as "consul"
Then run the following command
Here is the command:  ./consul agent -dev

we need to have maven install in the system, these two service using maven build system

Run command: mvn spring-boot:run (to be run for both applications)
</p>
<h2><a id="Usage_20"></a>Usage</h2>
<p>
<li>
<p>To access the swagger UI for client service :  <a href=http://localhost:8080/api/swagger-ui.html>http://localhost:8080/api/swagger-ui.html</a><br></p>


This is an example for communication of Micro service with service discovery
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
</p>
</li>

<li>
In this example Once we start both the services in our local machine :
in the consul dashboard (http://localhost:8500/ui/dc1/services) we will able to see the Service name listing 
and their health check status.
</li>
<li>
<p><b>Multiplication of 2 numbers</b> <a href="http://localhost:8080/api/calculate">http://localhost:8080/api/calculate</a> – This returns the result of multiplication.
This is a POST call with json body. eg: {"operandOne": 10.5,"operandTwo": 22.7,"operator": "*"}
</p>
</li>

For Ribbon Http client I have used Feign Client, And Feign readTimeout && connectTimeout is 
configured in application.properties file

For circuit breaker I have used Hystrix, In the clientservice , we have used Hystrix command at the time of calling the 
calculatorservice, if calculatorservice is not available, then Hystrix fallback command will executed and clientservice 
will provide a default response.


