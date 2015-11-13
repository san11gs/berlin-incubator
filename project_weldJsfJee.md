# Introduction #

> This is your project! It's a sample, deployable Maven 2 project to help you
> get your foot in the door developing with Java EE 6. This project is setup to
> allow you to create a compliant **Java EE 6 application using JSF 2.0, CDI 1.0,
> EJB 3.1 and JPA 2.0**) that can run on a certified application server (Complete
> or Web Profile). It includes a persistence unit and some sample persistence
> and transaction code to help you get your feet wet with database access in
> enterprise Java.

# Content #

> This dummy project provides a ready to go structure: Maven, persistence, transaction and Java EE dependencies are all configured. That is how Seam 3 might gonna look - So Seam 3 will be not more than a Weld SPI extension (which covers Seam Security, drools-, jbpm-, spring-, groovy-, guice- support, ..).

> To highlight the CDI features a simple customer-CRUD-application is implemented. Furthermore you can see how native JSF2 AJAX-support works.

# Development #

## Technology ##

  * weld-1.0.0.SP1 (CDI reference implementation)
  * Mojarra 2.0.1 (JSF 2.0 reference implementation)
  * Hibernate-validator 4.0.0.GA (Bean validation reference implementation)
  * jboss-ejb3 3.1.0 (EJB 3.1 implementation)


## Environment ##

  * Server: jboss-6.0.0.M1
  * Database: embedded hsql 1.8.0
  * Java: jdk 1.6.0\_18
  * Build management: Maven 2.2.1

## IDE ##

  * eclipse-jee-galileo-SR1-win32
    * JBossTools-3.1.0.CR1
    * M2Eclipse 0.9.9
    * Subclipse 1.6/Subversion 1.6.5
    * TestNG 5.12.0.3


## Maven Archetype ##
> The project is build up on this maven archetype:
```
<archetype>
      <groupId>org.jboss.weld.archetypes</groupId>
      <artifactId>weld-jsf-jee</artifactId>
      <version>1.0.0-BETA1</version>
      <description>Weld archetype for creating a Java EE 6 application using JSF 2.0, CDI 1.0, EJB 3.1 and JPA 2.0 (persistence unit included)</description>
    </archetype>
```

## Deployment ##

  * Runs on JBoss 6.0.0.M1
  * build and deploy with Maven (set ${jboss.home} first):
```
clean package jboss:hard-deploy
```