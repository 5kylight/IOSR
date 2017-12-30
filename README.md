# WIEiT Math

Distributed system for mathematical computations

## Maven project structure

* wiet-math
    * wiet-math-core
        * divivders-service
        * dividers-product-service
        * ...
    * wiet-math-support
        * discovery-server
        * gateway-server
        * ...
   

### Notes

For local env:
* Eureka dashboard: http://localhost:8761/
* Zuul server: http://localhost:8765/
* Example call to service through zuul gateway: http://localhost:8765/dividers-product/10

For maven build: 
* Make sure you have docker and docer-compose installed
* Make sure you have run you local repository (or run it with command "docker run -d -p 5000:5000 --restart=always --name registry registry:2")
* Run ./build.sh (unix env, assumes mvn installed)
* Run docker-compose up
