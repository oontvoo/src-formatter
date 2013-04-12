This is a simple formatter, which currently only supports Java.

The parser is derived from the <a href="http://www.cs.umb.edu/j--/">`j--`</a>'s parser developed at UMass Boston.

Usage
=======

0) To format your source file:

`java -jar src-formater.jar <input-file> > [<output-file> [<ALLMAN> | <K&R>]]`

 

Development CHEATSHEET
======================

This is a `maven` project, and  build phase requires every source file to have a header.

0) To automatically prepend a header:

`mvn license:format`

2) To check for missing headers:

`mvn license:check`

3) To build runnable jar:

`mvn clean package`

4) To run all unit tests

`mvn clean test`


