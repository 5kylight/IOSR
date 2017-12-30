# WIEiT Math

Distributed system for mathematical computations

## Notes

### Maven project structure

* wiet-math
    * wiet-math-core
        * divivders-service
        * dividers-product-service
        * ...
    * wiet-math-support
        * discovery-server
        * gateway-server
        * auth-server
        * ...

### Example calls

For local env:
* Eureka dashboard: http://localhost:8761/
* Zuul server: http://localhost:8765/
* Example call to service through zuul gateway: http://localhost:8765/dividers-product/10

### Build process
For maven build: 
* Make sure you have docker and docer-compose installed
* Make sure you have run you local repository, or run it with command 

```
docker run -d -p 5000:5000 --restart=always --name registry registry:2
```

* Run ./build.sh (unix env, assumes mvn installed)
* Run docker-compose up

### Authentication

#### Getting OAuth2 access-token:

* Application access:

```
    POST web_app:@localhost:8760/oauth/token?grant_type=password&username=reader&password=reader
```

```
    {
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MTQ3MDMyMjcsInVzZXJfbmFtZSI6InJlYWRlciIsImF1dGhvcml0aWVzIjpbIkZPT19SRUFEIl0sImp0aSI6IjZmZTEyNzQ5LWVkOTQtNDNlMy1hNzgwLTA3MWJjM2IwOTBlZSIsImNsaWVudF9pZCI6IndlYl9hcHAiLCJzY29wZSI6WyJGT08iXX0.skXX23--XdL7PaGsad5ccn4db5IZ5eSkmX3Dxmr2RklvNzSAnhc5FY5PttdECZ6fuEqIguPoPXQbWvjbdWH0XqSG79XUlaI8g9PaVvQliTgoCv9zDELzbbcxvAJmYxovaDKH2Z8HQkdOcdMYLxnDwR2cdTm9Ns4yH3aNSVC0vb7D1XfikUDbPQxj04laMBedCF0w9RBKsfNqoL-M2r6q7y7bRtAQPUdIMELkR4Q2VJbalVMtRC_Y54uClc4g5DbDHYr4iC33uKbzriTy4HSJd_MDghcMmnvvZHfdGao8zidAxTcyXQuNaIzLap3365SiKmxjm7-IIH_oyjJMy1wSBg",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJyZWFkZXIiLCJzY29wZSI6WyJGT08iXSwiYXRpIjoiNmZlMTI3NDktZWQ5NC00M2UzLWE3ODAtMDcxYmMzYjA5MGVlIiwiZXhwIjoxNTE3MjUyMDI3LCJhdXRob3JpdGllcyI6WyJGT09fUkVBRCJdLCJqdGkiOiIwNmVlNDRlYi0xYjYwLTQ0ODgtYjBlMy02NWNlNjczNmE5MTkiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.LTFHCs6NqH6c3mFe-SnRcOLAQ-z9hy5Jxwi7QmO0n8ZrgBgt_IXUa3lMSmElzze647-T45iuLOBBJmBjAiW6I4bncOIGmiW03HIJuHI8oxFGlPlWgLMANed31oGh9YRtEPzTNGSuObau9QkoJVbTHCa9pUggPK2eKocg4-xPwungwki18bvnnU_774LsXIXkELyrADeR_jEQtkRIsVOWepT5AQlK7MZRD-lUNzyB2sx_6_x-EkefdlaThUViU43cLeItk6p1IDxq4IJxwxSKasbyT1BCh5aHesLpo0-t0CLGH5_7XGcpDo3NDGqAN1rFnszOCQWo1gGE9c1mL9TevQ",
    "expires_in": 43199,
    "scope": "FOO",
    "jti": "6fe12749-ed94-43e3-a780-071bc3b090ee"
	}
```

* Username, password access:
```
	POST appnotuser:ala123@localhost:8760/oauth/token?grant_type=client_credentials
```

```
	{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJmb28iLCJiYXIiXSwiZXhwIjoxNTE0NzAzMzM5LCJhdXRob3JpdGllcyI6WyJhdXRob3JpdHkxIiwiYXV0aG9yaXR5MiJdLCJqdGkiOiJmZmYwNjIyYS03MzE4LTQ3Y2UtODQyMi1mYWFkMWMyZGU3ZTMiLCJjbGllbnRfaWQiOiJhcHBub3R1c2VyIn0.NJotYqU4dsLxVvasasp_PZO7rMj16ywCmX1_Ahl3Sl2Pcotu83nnwbsQE5oB4RcNW_UxeM7WshyQce-4jawV9px5mt6p0mWelw8uXPF5F4bXcAZlQRi3sj4xgx95gglvi4TkN9iYC48AzfWLrNsuNGAMSX_OuOFolNeC-MOnfsE0VDfU3yGyhuRawquPHW_gg1GRPj-PnG76i-m9QDAWhRbaEti6LSXqOgJjb_jfOiwq02BTZBsz4QzNNBUcK29p0FKyVuAPmckNAO_yC9d6-cskR6187Na8FdG0nOGdhLMjuD-bOQvBvL7Q3OQscchB-8YB0si4Q5ocndZO9h0pdA",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "foo bar",
    "jti": "fff0622a-7318-47ce-8422-faad1c2de7e3"
	}
```
#### Query app with authentication token

Call

    GET localhost:8765/dividers/100

with header

    Authorization: Bearer <access_token>

#### Keystore

Keystore generated with command (keypass and storepass should be the same - https://stackoverflow.com/questions/14606837/cannot-recover-key):

```
    keytool -genkeypair -alias jwt -keyalg RSA -dname "CN=jwt, L=Cracow, S=Cracow, C=PL" -keypass secretPass -keystore jwt.jks -storepass secretPass
 ```

 but there was recommendation to use another format:

```
    The JKS keystore uses a proprietary format. It is recommended to migrate to PKCS12 which is an industry standard format using "keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12".
```

Then public-key (in public.cert) was retrieved using: 

```
    keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey 
```