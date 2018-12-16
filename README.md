# myRetailApp
Spring boot  Retail Service <br><br>
<b>Pre-requisite</b>: Java-8, Maven 3.5.4, MongoDB 4.0.4
This application is developed in Java and Spring boot 2.

<b>How to run app</b>

1. Clone code in local
2. run mongodb 
3. Open command prompt mvn spring-boot:run
4. Above shall run Spring boot APP at 8080 port, make sure this port is not occupied.


<b>What APIs contains</b>
1. To get all products

curl -X GET \
  http://localhost:8080/products/ \
  -u 'myRetailUser:myRetailUser' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json'

2. To save a product 

curl -X POST \
  http://localhost:8080/products/ \
  -H 'accept: application/json' \
  -u 'myRetailUser:myRetailUser' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{"id":13860421,"current_price":{"value":13.49,"currency_code":"RS"}}'
  
  3. To update a product
  
  curl -X PUT \
  http://localhost:8080/products/13860421 \
  -H 'accept: application/json' \
  -u 'myRetailUser:myRetailUser' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{"id":13860421,"current_price":{"value":13.49,"currency_code":"RS"}}'
  
  4. To remove a product
  
  curl -X DELETE \
  http://localhost:8080/products/13860428 \
  -u 'myRetailUser:myRetailUser' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{"id":13860421,"current_price":{"value":13.49,"currency_code":"RS"}}'
  
  
  
