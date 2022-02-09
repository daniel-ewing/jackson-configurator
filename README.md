# Jackson Configurator for WildFly

### The Purpose of this Project
Build a jackson configurator artifact to add support fot JSR310 data types for Camunda Platform applications deployed to certain versions of the Camunda Platform for WildFly distribution where that support is missing.

### To Use this Project
Build the project, e.g.:

`mvn clean install`

The result will be a new artifact: 

`jackson-configurator-1.0.jar`

Install the artifact `jackson-configurator-1.0.jar` as a module in `{WILDFLY_HOME}/modules`, according to the WildFly documentation.  

Note: This requires the creation of a `module.xml` file.  The `module.xml` file will need to include information about this artifact's dependencies.  Be sure to see the note in the `pom.xml` file about the versions of the artifacts.  As a convenience, see the `module-definitions` directory for:
* The required directory structure and `module.xml` for this artifact
* The required directory structure, artifact jar file, and `module.xml` for all dependencies.

To use this artifact in your project, add the `jackson-configurator-1.0.jar` artifact as a dependency in your project's `pom.xml` file, e.g.:
```
<dependency>
    <groupId>org.camunda.bpm.example</groupId>
    <artifactId>jackson-configurator</artifactId>
    <version>1.0</version>
</dependency>
```
To be able to build your project, you must either:
 
* First build the `jackson-configurator-1.0.jar` project in the same development environment, so that it can be found in the `.m2` cache.

Or:

* Put the `jackson-configurator-1.0.jar` artifact into a local Nexus or other artifact repository.
