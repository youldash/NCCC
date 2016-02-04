# NCCC Supplementary Material

## Third Task: Cluster Analysis

Here, you are to develop a Java program (using [NetBeans](https://netbeans.org/)) to solve the problem of Clustering (or grouping of data points)...

<!-- The purpose of this project is to demonstrate the possibility of mimicking the basic functionality of a typical Standing Order System. In addition, the project is written in such a manner that demonstrates its effectiveness (using Unit Testing). -->

The general aims are:

* To solve the Clustering problem in an Object-Oriented manner, using the well-known [k-Means Clustering](https://en.wikipedia.org/wiki/K-means_clustering) algorithm.
* To demonstrate the use of Vectors and Iterators in Java.
* To demonstrate the effectiveness and usefulness of the Java Math API.

**Content is being uploaded now (Thursday Feb 4th)...**

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

* identifier (or name),
* two Cartesian (spacial) coordinates (x, y),
* Cluster (reference), and
* Euclidean distance (from Centroid). See below:

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

<!-- a set of one or more measurements on a single member of a statistical population or grouping. It it [also be referred to](http://whatis.techtarget.com/definition/data-point) as is a discrete unit of information (that could be mapped and displayed using a system of geometry). -->

<hr>


### Example

![Screenshot](https://raw.github.com/youldash/NCCC/master/misc/Before.png)
100 DataPoint objects (before).

![Screenshot](https://raw.github.com/youldash/NCCC/master/misc/After.png)
4 Clusters (25 DataPoint objects each) after running the program.
