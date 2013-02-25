Java Archetypes
=========================================
Summary
-------
The project will contain Maven archetypes for java development

Installation
------------

1. checkout from git
2. run `mvn install` to install the archetypes in your local repository

Create Spring MVC 3 project
---------------------------

    mvn archetype:generate
        -DarchetypeGroupId=com.michalvich.java-archetypes
        -DarchetypeArtifactId=spring-mvc-3-archetype
        -DarchetypeVersion=1.0.0-SNAPSHOT
        -DgroupId=your.groupid
        -DartifactId=your-artifactId
        -Dversion=version


Run the project
---------------------------

mvn jetty:run

