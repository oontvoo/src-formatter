Similar to the Unix's famous tool `cat`, this `src-formatter` allows you display the content of a source file in the terminal, but you can also specify the format for it (ie., Allman or K&R)

The parser is developed based on the grammar defined in the <a href="http://www.cs.umb.edu/j--/">`j--`</a>'s compiler, which was developed at UMass Boston.
(Many thanks to professor Bill Campbell and Swami Iyer for allowing me to use it)

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


