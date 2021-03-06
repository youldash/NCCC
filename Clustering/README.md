# NCCC Supplementary Material

## Third Task: Cluster Analysis

Here, you are to develop a Java program (using [NetBeans](https://netbeans.org/)) to solve the problem of Clustering (or grouping of data points)...

<!-- The purpose of this project is to demonstrate the possibility of mimicking the basic functionality of a typical Standing Order System. In addition, the project is written in such a manner that demonstrates its effectiveness (using Unit Testing). -->

The general aims are:

* To solve the Clustering problem in an Object-Oriented manner, using the well-known [k-Means Clustering](https://en.wikipedia.org/wiki/K-means_clustering) algorithm.
* To demonstrate the use of Vectors and Iterators in Java.
* To demonstrate the effectiveness and usefulness of the Java Math API.

![Screenshot](https://raw.github.com/youldash/NCCC/master/misc/cIDB3.png)
[Source](http://i.stack.imgur.com/cIDB3.png)

**A proposed [solution](https://github.com/youldash/NCCC/tree/master/Clustering/solution/) to the problem is now available.**

### DataPoint

A [DataPoint](https://en.wikipedia.org/wiki/Data_point), in statistical terms, refers to a set of one or more measurements on a single member of a statistical population or grouping. It it [also be referred to](http://whatis.techtarget.com/definition/data-point) as is a discrete unit of information (that could be mapped and displayed using a system of geometry).

In this task, information reported on a <b>DataPoint</b> is stored in 1 line. For example, a typical entry (record) looks like the following:

```
P2, 1.897, 1.989
```

* The first parameter (before the comma) is an "identifier" (or name) of the point.
* The second parameter (after the first comma) is the "x" geometrical coordinate of the point.
* The third parameter (after the second comma) is the "y" geometrical coordinate of the point. Both "x" and "y" coordinates are typically used for both mapping and visualization purposes. See below:

| Parameter | Value |
|:---------:|:-----:|
| identifier | P2 |
| x | 1.897 |
| y | 1.989 |

A [DataPoint](https://raw.github.com/youldash/NCCC/master/Clustering/skeleton/DataPoint.java) class holds five variables:

* `identifier` (or name),
* two Cartesian (spacial) coordinates `(x, y)`,
* `cluster` (reference), and
* `euclideanDistance` (from Centroid). See below:

| Parameter | Type |
|:---------:|:----:|
| identifier | String |
| x | double |
| y | double |
| cluster | Cluster (see below) |
| euclideanDistance | double (computed) |

<hr>

### Cluster

A [Cluster](https://en.wikipedia.org/wiki/Cluster_analysis), in the Exploratory Data Mining and Machine Learning literature, refers to a grouping (or set) of DataPoint objects in such a manner that objects in the same cluster are more similar (in some sense or another) to each other than to those in other clusters.

A [Cluster](https://raw.github.com/youldash/NCCC/master/Clustering/skeleton/DataPoint.java) class in this task (which is formed using k-Means and similar algorithms), holds four variables:

* `identifier` (or name),
* `centroid` (see below),
* `sumOfSquares` (double), and
* `dataPoints` (collection). See below:

| Parameter | Type |
|:---------:|:----:|
| identifier | String |
| centroid | Centroid (see below) |
| sumOfSquares | double |
| dataPoints | Vector |

<hr>

### Centroid

A [Centroid](https://en.wikipedia.org/wiki/Centroid) (or geometric center) refers to the mean (or middle) position of all the DataPoint objects in all of the coordinate directions (i.e. in both "x" and "y").

A [Centroid](https://raw.github.com/youldash/NCCC/master/Clustering/skeleton/Centroid.java) class in this task (which is formed using k-Means and similar algorithms), holds three variables:

* two Cartesian (spacial) coordinates `(x, y)`, and
* `cluster` (reference). See below:

| Parameter | Type |
|:---------:|:----:|
| x | double |
| y | double |
| cluster | Cluster |

<hr>

### Objectives

After you thoroughly inspect (and fully understand) all four Java classes, you are hereby required to **ONLY** modify [ClusteringAlgorithm.java](https://raw.github.com/youldash/NCCC/master/Clustering/skeleton/ClusteringAlgorithm.java) to **CORRECTLY** read from the [ClusteringAlgorithm.in](https://raw.github.com/youldash/NCCC/master/Clustering/skeleton/ClusteringAlgorithm.in) data set (text file). Then, display the output in the standard console of NetBeans... Yep, as simple as that! :)

#### Data Set: Input Format

Information reported for <b>DataPoint</b> objects is stored in multiple lines (depending on the size of the data set -- which is typically defined by the number of DataPoint objects needed for the algorithm).

See the following sample input:

```
6
2
10
P1 10.0 10.0
Q1 -10.0 -1.0
P2 15.0 12.0
Q2 -5.0 -10.0
P3 9.0 30.0
Q3 -7.5 -12.5
```

In this data set:
* Line 1 defines the "size" of the DataPoint objects (that are to be created). Based on this attribute, the `getNumberOfDataPoints()` method of the ClusteringAlgorithm class **SHOULD** return this **EXACT** value. 
* Line 2 defines the `numberOfClusters` needed for ClusteringAlgorithm class. In particular, it specifies the "Number of Clusters" needed for the k-Means Clustering algorithm to work. In this given example, the number is **DELIBERATELY** set to 2: One for **P**-labelled points, and another for **Q**-labelled points.
* Line 3 defines the `numberOfIterations` for the ClusteringAlgorithm class. In particular, it specifies the "Number of Iterations" needed for the k-Means Clustering algorithm to work. The accuracy of such an algorithm is bound by such a parameter.
* Lines 4-9 define each `DataPoint` entry. As you created new instances, you define each attribute based on the description that is explained above (under **DataPoint**).

#### ClusteringAlgorithm.java: Sample Output

After you create your project and import all four classes of this task (all are listed in [skeleton code](https://github.com/youldash/NCCC/blob/master/Clustering/skeleton/)), you should be able to obtain a similar console output:

```
---- Cluster[0]
P1 (10.0, 10.0)
P2 (15.0, 12.0)
P3 (9.0, 30.0)
---- Cluster[1]
Q1 (-10.0, -1.0)
Q2 (-5.0, -10.0)
Q3 (-7.5, -12.5)
```

As shown, the output tells us that k-Means was executed successfully, and in turn was able to cluster all 6 `DataPoint` objects into two DISTINCT groups:

##### Cluster[0]

* Identified by its 3 `DataPoint` objects: **P1**, **P2**, and **P3**.
* Grouped by calculating the `Centroid` object that belongs to this Cluster. Each of the three points were determined **CLOSER** to the Centroid based their `euclideanDistance` value from Centroid.

##### Cluster[1]

* Identified by its 3 `DataPoint` objects: **Q1**, **Q2**, and **Q3**.
* Grouped by calculating the `Centroid` object that belongs to this Cluster. Each of the three points were determined **CLOSER** to the Centroid based their `euclideanDistance` value from Centroid.

### HINT

To fully understand how the algorithm works, have a closer look at:

* The `initializeCentroids()` method of [ClusteringAlgorithm.java](https://raw.github.com/youldash/NCCC/master/Clustering/skeleton/ClusteringAlgorithm.java)
* The `calculateSumOfWCSS()` method of [ClusteringAlgorithm.java](https://raw.github.com/youldash/NCCC/master/Clustering/skeleton/ClusteringAlgorithm.java)
* The `invoke()` method of [ClusteringAlgorithm.java](https://raw.github.com/youldash/NCCC/master/Clustering/skeleton/ClusteringAlgorithm.java) (which forms the heart/engine of the algorithm).
