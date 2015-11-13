# Introduction #

Why don't use a Spring+Flex+Maven App deployed on GAE **to order your pizza**? Here you go:

  * Live demo: http://spring-flex-gae.appspot.com
  * Browse source code here: https://code.google.com/p/berlin-incubator/source/browse/trunk/spring-flex-gae/
  * Checkout source code here: http://berlin-incubator.googlecode.com/svn/trunk/spring-flex-gae/ and build it for your own with Maven: "mvn clean install"

# Technology #
  * Java 1.6, Spring 3, Flex 3.5
  * Google App Engine 1.3.1, DataNucleus 1.1.5
  * Maven 3 (supports Maven 2)

# Tooling #
  * required: Java 1.6, SVN-Client, Maven, GAE
  * extended: Eclipse Plugin

# Restrictions #
Java Enterprise Edition (Java EE) Technologies:

http://groups.google.com/group/google-appengine-java/web/will-it-play-in-app-engine

## Java ##
Whitelist: Access to the classes in the Java standard library (the Java Runtime Environment, or JRE) is limited to the following classes:

http://code.google.com/intl/de-DE/appengine/docs/java/jrewhitelist.html

## JPA ##
  * JPA1.0 implementation is used
  * No support for uniqueness constraints
  * Owned many-to-many relationships, and unowned relationships. You can implement unowned relationships using explicit Key values, though type checking is not enforced in the API.
  * "Join" queries. You cannot use a field of a child entity in a filter when performing a query on the parent kind. Note that you can test the parent's relationship field directly in query using a key.
  * Aggregation queries (group by, having, sum, avg, max, min)
  * Polymorphic queries. You cannot perform a query of a class to get instances of a subclass. Each class is represented by a separate entity kind in the datastore.

## EJB ##
not supported

## Flex ##
http://martinzoldano.blogspot.com/2009/04/appengine-adobe-blazeds-fix.html