Lab MovieLibrary

Part 1:

Create an application that acts as a library where you keep track of your Movie objects.
The library should define a collection that holds all currently owned objects.
New objects should be possible to add to the library, and old objects should be possible to
remove from the library. Your application should implement the interface Library.
The user interface should be defined at console level by a menu from which a user enters
choice of operation and supplies data as requested by the application.
There should be some kind of input control in order to spot erroneous values entered by
the user including producing an error message.

Produce a number of unit tests for the application. Make sure that they all pass.

Code coverage should be at least 80%.

Example 1: MovieLibrary
1 - Present complete contents
2 - Add Movie to library
3 - Remove Movie from library
4 - Search for a Movie by title/main actor/production year/length
0 - Exit application

Xtra 1: Allow doubles to be part of your library by storing the entries in a collection of
type Map<String, List<Movie>>

Part 2: Store all registered Movie objects in a text file triggered by a menu option.
At start up of the application the text file, if available, should be read before a
user is presented the application menu.

Example 2: MovieLibrary
1 - Present complete contents
2 - Add Movie to library
3 - Remove Movie from library
4 - Search for a Movie by title/main actor/production year/length
5 - Store current library contents in textfile
6 - Read contents from textfile to library
0 - Exit application

Xtra 2:
Store contents of the library in a serialized file. Refactor your code for reading
of file contents at start up. Make sure that all tests still pass.
