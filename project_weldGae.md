# Introduction #

> It's a sample weld project running on Google App Engine. The project was created with the help of great tutorial by Shane Bryzak: http://in.relation.to/Bloggers/WeldJSF20AndGoogleAppEngineNavigatingTheMinefieldPart1


# Content #

> There is a simple Hello-World-CDI-Bean with el-access and JPA access to create and list employees.

## JPA-Access ##

### Configuration ###
"The App Engine Java SDK includes an implementation of JPA 1.0 for the App Engine datastore. The implementation is based on DataNucleus Access Platform. Since JPA presents a standard interface for interacting with relational databases and the App Engine datastore is not a relational database, there are features of JPA that the App Engine implementation simply cannot support. We have done our best to call attention to these features wherever possible."

See here for how to access JPA with GAE:
http://code.google.com/intl/de-DE/appengine/docs/java/datastore/usingjpa.html

### Data Viewer ###
![http://berlin-incubator.googlecode.com/files/screenshot_gae_dataviewer.png](http://berlin-incubator.googlecode.com/files/screenshot_gae_dataviewer.png)

# Development #

## Technology ##
  * weld-1.0.1.FINAL (CDI reference implementation)
  * Mojarra 2.0.1 (JSF 2.0 reference implementation)
  * datanucleus-jpa-1.1.5 (JPA 1.0 implementation required for use with Google BigTable)

## Environment ##

  * deployed on Google App Engine 1.3.1
  * based on Java 6
  * powered by Jetty
  * data storage with Google BigTable
  * build with ant (or Google Plugin)

## IDE ##

  * eclipse-jee-galileo-SR1-win32
    * Google Plugin for Eclipse 3.5 1.2.0
    * Subclipse 1.6/Subversion 1.6.5
    * Maven Plugin 0.9.9

## Deployment ##

> The project is deployed on Google App Engine cloud: http://weld-gae.appspot.com

> https://appengine.google.com is used to manage apps.

# Restrictions #
## Java ##
  * Whitelist

## JPA ##
  * JPA1.0 implementation is used
  * Google restrictions --> link
  * java.lang.UnsupportedOperationException: No support for uniqueness constraints
  * No support for many to many relation ships

## EJB ##
> --> not avaiable --> double check
