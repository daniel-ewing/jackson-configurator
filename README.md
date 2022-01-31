# Jackson Configurator for WildFly

### The Purpose of this Project
Build a jackson configurator artifact to add support fot JSR310 data types for Camunda Platform applications deployed to certain versions of the Camunda Platform for WildFly distribution where that support is missing.

### To Use this Project
Build the project, e.g.:

`mvn clean install`

The result will be a new artifact: 

`jackson-configurator-1.0.jar`

Install the artifact `jackson-configurator-1.0.jar` as a module in `{WILDFLY_HOME}/modules`, according to the WildFly documentation.  

Note: This usually requires the creation of a `module.xml` file.  The `module.xml` file will most likely need to include information about this artifact's two dependencies.  Be sure to see the note in the `pom.xml` file about the version of the spin artifact:
```
org.camunda.spin:camunda-spin-dataformat-json-jackson:1.10.2
com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.1
```


Add the `jackson-configurator-1.0.jar` artifact as a dependency in your WAR project, e.g.:
```
<dependency>
    <groupId>org.camunda.bpm.example</groupId>
    <artifactId>jackson-configurator</artifactId>
    <version>1.0</version>
</dependency>
```
To be able to build your WAR project, you must either:
 
* First build the `jackson-configurator-1.0.jar` project in the same development environment, so that it can be found in the `.m2` cache.

Or:

* Put the `jackson-configurator-1.0.jar` artifact into a local Nexus or other artifact repository.
