# NCCC Training Material for UQU (CIS) Teams

<img src="https://raw.github.com/youldash/NCCC/master/UQU-LOGO-1024x731.png" width="100%" />

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

**Proposed solutions will be posted later, for reference.**

## Implementation

Imagine yourself having to deal with many text file reports on certain Astronomical (or rather, Celestial Objects) observed and measured by a network of space stations. One way of solving this problem is to design, and develop an application that is capable of combining and storing these reports and to query the system to find interesting facts about these objects of interest.

You are to develop a Java program (using [NetBeans](https://netbeans.org/)) for certain Celestial Objects (i.e. Stars, Planets and Moons). This program can then be used for evaluation purposes.

### Stars

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


<hr>

### Objectives

#### Task 1

TBA.

#### Task 2

TBA.

#### Task 3

TBA.

## Sponsor
This repository is sponsored in part by the Department of [Department of Computer Science](https://uqu.edu.sa/computer-sciences-information-en/) at Umm Al-Qura University, Mecca, Saudi Arabia.

## License

This Git repository is published under the MIT license.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

* Neither the name of the author nor the names of its contributors may be used
to endorse or promote products derived from this software without specific
prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
