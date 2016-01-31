# NCCC Training Material for UQU (CIS) Teams

<img src="https://raw.github.com/youldash/NCCC/master/misc/UQU-LOGO-1024x731.png" width="100%" />

Welcome to the NCCC training repository! This repository is dedicated to the CIS teams (both female and male students) whom will represent UQU at NCCC 2016. 

## Description

The repository is consisted of a Java project, which can be implemented (and solved) over several tasks. Each task can be either achieved on an individual basis, or by working as a group or a team (which is highly recommended).

The general aims are:

* To analyze a problem in an Object-Oriented manner, and then design and implement an Object-Oriented solution that conforms to given specifications.
* To practice file IO (input and output) in Java.
* To practice using abstraction and inheritance in Java.
* To practice using serialization in Java.
* To make implementations more robust through mechanisms such as exception
handling.

**A proposed [solution](https://github.com/youldash/NCCC/blob/master/solution/) will be posted later, for reference.**

## First Task

Imagine yourself having to deal with many text file reports on certain Astronomical (or rather, Celestial Objects) observed and measured by a network of space stations. One way of solving this problem is to design, and develop an application that is capable of combining and storing these reports and to query the system to find interesting facts about these objects of interest.

You are to develop a Java program (using [NetBeans](https://netbeans.org/)) for certain Celestial Objects (i.e. Stars, Planets and Moons). This program can then be used for evaluation purposes.

### Stars

![Screenshot](https://raw.github.com/youldash/NCCC/master/misc/FELNM.jpg)
[Source](http://i.imgur.com/FELNM.jpg)

Information reported on <b>Stars</b> is stored in 6 lines. For example, a typical entry (record) looks like the following:

```
Star
Betelgeuse
1180 
M 
I
430
```

* Line 1 is the "type" of the celestial object (in this case, Star).
* Line 2 is the "name" of the star (hint: may be more than one word).
* Line 3 is the "radius" of the star (in solar radius units where 1 solar radius ≈ 695,500km).
* Line 4 is a "letter" (or character) representing the spectrum (i.e. color of the star). See below:

| Letter | Description |
|:------:|:-----------:|
| A | White |
| B | Blue-White |
| F | White-Yellow |
| G | Yellow |
| K | Orange |
| M | Red |
| O | Blue |

* Line 5 represents the "luminosity" (or brightness) of the star. There are 7 possible values for this attribute, stored using Roman numerals made with uppercase letters <b>I</b> and <b>V</b>, as follows:

| Numerals | Description |
|:--------:|:-----------:|
| I | Supergiant |
| II | Bright giant |
| III | Normal giant |
| IV | Subgiant |
| V | Dwarf |
| VI | Subdwarf |
| VII | White dwarf |

* Line 6 is "how far away" the star is (measured in light years).

<hr>

### Planets

![Screenshot](https://raw.github.com/youldash/NCCC/master/misc/earth-venus compare.png)
[Source](http://1.bp.blogspot.com/-anVyVsVGkHM/TZXqhxYCWJI/AAAAAAAAAXI/LlsFrBe2Bbc/s1600/earth-venus+compare.png)

Information reported on <b>Planets</b> is stored in 6 lines. An entry might look like the following:

```
Planet
Venus
6051
4.8685 24
224.70069 
735
```

* Line 1 is the "type" of the celestial object (in this instance, a Planet).
* Line 2 is the "name" of the planet (hint: may be more than one word).
* Line 3 is the "radius" of the planet (in kilometers).
* Line 4 is the "mass" of the planet (in kilometers). This attribute contains the <b>mantissa</b> (a real
number or double), and <b>exponent</b> (an integer) of the planet's mass expressed in scientific notation. See the following description for Venus:

| Name | Mass | Description |
|:----:|:----:|:----:|
| Venus | 4.8685 24 | For the planet Venus, its mass is 4.8685 x 10^24kg |

* Line 5 is the "orbital period" of the planet in days (measuring how long it takes to orbit their parent star).
* Line 6 is the "temperature" of the planet in degrees Kelvin (stored as an integer).

<hr>

### Moons

Information reported on <b>Moons</b> is stored in 6 lines. An entry might look like the following:

```
Moon
Europa
1569
4.80 22
Jupiter
103
```

* Line 1 is the "type" of the celestial object (in this instance, a Moon).
* Line 2 is the "name" of the moon (hint: may be more than one word).
* Line 3 is the "radius" of the moon (in kilometers).
* Line 4 is the "mass" of the moon (in kilometers). This attribute contains the <b>mantissa</b>, and <b>exponent</b> of the moon's mass expressed in scientific notation. See the following description for Europa:

| Name | Mass | Description |
|:----:|:----:|:----:|
| Europa | 4.80 22 | For the moon Europa, its mass is 4.80 x 10^22kg |

* Line 5 is the "name" of the planet that the moon orbits (in other words, the moon is a satellite of this
planet).
* Line 6 is the "temperature" of the moon in degrees Kelvin (stored as an integer).

<hr>

### Objectives

While implementing your code, you may assume that user input is always correct, and files are correctly formatted. In reality however, this is **NOT** always the case as typical data sets can be stored in more-complex forms. For such cases *exception handling* are indeed helpful.

#### Task 1: Project Structure

Just before you even think of writing code, you should **ALWAYS** plan your design!

Once you have made a decision on what classes your program should include, you can then implement a class hierarchy to represent the celestial objects in your project.

As you complete the following tasks, which may require adding certain behaviors (i.e. Java methods) to your classes, consider whether any methods or classes should be abstract, or interface. See the [Menu](https://github.com/youldash/NCCC/blob/master/skeleton/Menu.java) and [CelestialObject](https://github.com/youldash/NCCC/blob/master/skeleton/CelestialObject.java) classes for illustrations.

#### Task 2: Driver Implementation

Once you complete the previous task, go right ahead and start implementing the [Driver](https://github.com/youldash/NCCC/blob/master/skeleton/Driver.java) class (which typically loads the data from text files). This class is menu-based, as it is designed to manage the information in the collection of celestial objects (which are fed into the program from file).

Note that [skeleton code](https://github.com/youldash/NCCC/blob/master/skeleton/) for the menu-based driver program is already implemented for convenience!

The main-menu is consisted of the following options:

```
******************
 NCCC Application 
******************
E) Export to a file
A) Add a celestial object
I) Import from a file
S) Submenu
D) Display collection
Q) Quit
******************
Make your choice:
```

This menu is repeatedly displayed after each **case-sensitive** user selection is executed. If the user chooses ‘Q’ to quit, the program terminates.

As the user selects "I" for example, the program is expected to prompt (or ask) her/him for the name of the text file containing the celestial objects (data set), and effectively load that information into the program's memory. If the file does not exist or there are other issues reading from the file, a warning message should be displayed to screen before the program continues by displaying the menu options.

#### Task 3: Displaying Information

As the user selects "D" the program is expected to display each celestial object's details to screen, formatted as follows for each type:

```
Star: Aldebaran A
	radius = 25.00 solar radii
	spectrum = K
	brightness = III
	distance = 65.00 ly
Moon: Iapetus
	radius = 735.60 km
	mass = 1.81 X 10^21 kg
	temp = 100 degrees K
	satellite of Saturn
Planet: Neptune
	radius = 24764.00 km
	mass = 1.02 X 10^26 kg
	temp = 48 degrees K
	orbital period = 60190.00 days
```

Note that all real numbers are truncated (or output) to **2 decimal places**.

#### Task 4: Adding Celestial Objects

As the user selects "A" the program is expected to add a new celestial object (of course depending on its type e.g. Star, Planet, Moon, etc.).

Based on each type the program is expect to prompt for the required (relevant) fields and add the celestial object to the collection.

At this stage you may wish to avoid checking on whether each newly-added celestial object is already in the collection, nor do you need to check for invalid values entered by the user (this task is entirely up to you!).

An example interaction based on choosing "Star" as the new entry is as follows:

```
Add a type [Star/Planet/Moon]? Star
	Name [string]? Bellatrix
	Radius [real, solar radius]? 5.7
	Spectrum [O/B/A/F/G/K/M]? B
	Brightness [I/II/III/IV/V/VI/VII]? III
	Distance [real, light years]? 240
```

#### Task 5: Importing from, and Exporting to a Binary File

This task implies that your program should have the ability to store the celestial objects collection in binary format **(between runs)** in a file called **"data.bin"**.

##### Importing Data

* When the program starts, it **must** check if data.bin exists or not.
* If the binary file "does not" exist, the user should be informed and the program should begin with an empty collection.
* If the binary file "does" exist it should be read in if possible, otherwise print a message to
screen that there was a problem reading the file and begin the program with an empty
collection.

##### Exporting Data

* When the user selects to quit the program, the collection should be written to the binary file **prior** termination.
* If the binary file "does" exist it should be overwritten.
* If there are problems exporting the collection, an error message should be output to the user before the program terminates.

#### Task 6: Enquiry Submenu

As the user selects "S" the program is expected to display a submenu, as follows:

```
****** SUBMENU *******
F) Furthest: Star
L) Largest: Celestial Object
A) All Moons: Planet
R) Range: Degrees
E) Exit: Submenu
**********************
Make your choice:
```

##### Option F: Furthest Star

* Output to screen all the details of the Star that is furthest away.
* You may assume there are no ties.

##### Option L: Largest Celestial Object

Output to screen all the details of the:

* Biggest star.
* Biggest planet.
* Biggest moon.

This task is determined by the radius. 

Output a message if there are no space bodies of a particular type.

Also assume there are no ties.

##### Option A: All Moons of a Planet

Ask the user for the name of a planet, and then search the collection and output to screen the name of all moons in the collection orbiting a planet of that name.

##### Option R: Temperature Ranges 

Ask the user to enter "minimum" and "maximum" temperature values (integers, degrees K) and then output to screen the "type", "name" and "temperature" of all (non-Star) celestial objects with temperatures within that (inclusive) range.

Consider this example layout:

```
Minimum temperature [int, degrees K]? 60
Maximum temperature [int, degrees K]? 130
List of celestial objects within range:
	Planet: Jupiter 120 K
	Moon: Europa 103 K
	Planet: Saturn 88 K
	Moon: Ganymede 110 K
	Moon: Io 130 K
	Moon: Titan 94 K
	Moon: Rhea 76 K
	Moon: Titania 60 K
	Moon: Oberon 61 K
	Moon: Iapetus 100 K
```

#### Task 7: Reading/Importing from Text Files

As the user selects "R" the program is expected to read (or import) the data collection from a file named **"in.txt"**.

A sample input file is listed as [in.txt](https://github.com/youldash/NCCC/blob/master/skeleton/in.txt).

#### Task 8: Writing/Exporting to Text Files

As the user selects "E" the program is expected to write (or export) the current data collection in memory to a file named **"out.txt"**.

While exporting to file, your program should produce a readable list of all celestial objects (in any order) that shows their name and their type (in brackets).

An output format "example" is shown as follows (for a small sample collection):

```
Triton (Moon)
Rhea (Moon)
Titania (Moon)
Oberon (Moon)
Proxima Centauri (Star)
Alpha Centauri A (Star)
Alpha Centauri B (Star)
Wolf 359 (Star)
Sirius A (Star)
Epsilon Eridani (Star)
Neptune (Planet)
```

* If the text file "does" exist it should be overwritten.
* If the write cannot occur, output an error message to screen.

## Bonus Tasks

Coming soon...

## Sponsors
This repository is sponsored in part by the Department of [Department of Computer Science](https://uqu.edu.sa/computer-sciences-information-en/) at Umm Al-Qura University, Mecca, Saudi Arabia.

## License

This Git repository is published under the MIT license. See [LICENSE](https://github.com/youldash/NCCC/blob/master/LICENSE.md) for details.