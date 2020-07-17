# Device Management Tool
Objective of this Java application, is to demonstrate basic functionality offered by Data Generation library.
It offers short examples of implemented interfaces of Sensor, SimpleSensor, Actuator, and ActiveDevice.
Application incorporates simple show-case of functions: deserialization process and Device in a position of CoAP Server.

## Prerequisites
This project requires at least Java version 11

Before installing you need to download, compile and install Data Generation library:

```
git clone --branch v1.0-thesis https://github.com/jsmolar/patriot-data-generator.git
cd patriot-data-generator
mvn clean install
```

## Getting Started
First step, is to compile and package the application:
```
mvn clean package
```

For execution invoke command:
 ```
mvn exec:java
```

Or to build and execute single distributable archive:
```
mvn assembly:single
java -jar target/dmt-example.jar
```


### Build With

* [Maven](https://maven.apache.org/) - Dependency Management