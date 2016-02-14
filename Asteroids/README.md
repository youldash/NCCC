# Asteroids

You are to write a Java program (using [NetBeans](https://netbeans.org/)) to solve the overlapping asteroids problem.

A complete specification to this challenge is presented [here](http://icpc.baylor.edu/worldfinals/problems/icpc2015.pdf).

A solution to this challenge is posted in this directory.

Please note that **this is NOT the best and only solution**. As such, you may wish to optimize it, or rather, you may rewrite the whole thing from scratch :)

## Points of Improvement

### Line/Edge Intersection

A good starting point would be to consider the following pseudocode:

```
Compute the bounding boxes of both polygons, p0 and p1;

If the two bounding boxes overlap {
	
	for each edge in p0 {
		
		for each edge in p1 {
			
			if the two edges intersect {
				
				// Both p0 and p1 intersect
				return true;
			}
		}
	}
	
	// No overlap at this stage.
	return false;
	
} else {
	
	// Both bounding boxes don't intersect.
	return false;
}
```

An early implementation of edge intersection looks like the following:

``` Java
/**
 * Compute the intersection between two edges.
 * See <http://www.ahristov.com/taller/geometry/src/intersection-lines.java>
 *
 * @param edge
 * @return vertex where the segments intersect, or null if they don't
 */
public Vertex intersection(Edge edge) {
	
	// The intersection is defined by the two edges:
	double x1 = this.head.x;
	double y1 = this.head.y;
	double x2 = this.tail.x;
	double y2 = this.tail.y;
	double x3 = edge.head.x;
	double y3 = edge.head.y;
	double x4 = edge.tail.x;
	double y4 = edge.tail.y;
	
	// Establish the derivation.
	double derivation = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
				
	// The edges intersect if derivation ≠ 0.
	if (derivation == 0.0)
		return null;
	
	// Return the intersection vertex.
	return new Vertex(
		((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / derivation,
		((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / derivation);
}
```

Try improving the [existing code](https://raw.github.com/youldash/NCCC/master/Asteroids/ICPC.java) to 

### Area of a Polygon

Try improving the solution by utilizing the area calculation method:

``` Java
/**
 * Compute/recompute the area of this polygon.
 */
private void calculateArea() {}
```
