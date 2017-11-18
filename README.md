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
 