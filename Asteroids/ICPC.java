/**
 * @author Mustafa Youldash <mmyouldash@uqu.edu.sa>.
 * @copyright (c) 2016 Umm Al-Qura University. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * * Neither the name of the author nor the names of its contributors may be used
 * to endorse or promote products derived from this software without specific
 * prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.lang.String;
import java.lang.Math;
import java.util.Scanner;
import java.io.*;

/**
 * An ICPC (Asteroids) Solution...
 * For complete description of the problem please visit:
 * http://icpc.baylor.edu/worldfinals/problems/icpc2015.pdf
 *
 * Created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */
class ICPC {
	
	/**
	 * Properties.
	 */
	static final boolean DEBUG = true;
	static final int NUM_MESHES = 2;
	
	/**
	 * A Vertex holds two variables:
	 * - two Cartesian (spacial) coordinates (x, y).
	 */
	static class Vertex {
	
		/**
		 * Variables.
		 */
		public double x, y;
				
		/**
		 * Default constructor.
		 */
		public Vertex() {
		
			// Set the parameters.
			this.x = 0.0;
			this.y = 0.0;
		}
	
		/**
		 * @param x
		 * @param y
		 */
		public Vertex(double x, double y) {
		
			// Pass the parameters.
			this.x = x;
			this.y = y;
		}
		
		/**
		 * @return description
		 */
		public String toString() {
	
			return "(" + this.x + ", " + this.y + ")";
		}
		
		/**
		 * Add (this + vertex).
		 *
		 * @param vertex
		 * @return the sum (this + vertex)
		 */
		public Vertex add(Vertex vertex) {
			
			// Return it.
			return new Vertex(
				this.x += vertex.x,
				this.y += vertex.y);
		}
	
		/**
		 * Subtract (this - vertex).
		 *
		 * @param vertex
		 * @return the difference (this - vertex)
		 */
		public Vertex subtract(Vertex vertex) {
			
			// Return it.
			return new Vertex(
				this.x -= vertex.x,
				this.y -= vertex.y);
		}
		
		/**
		 * Return the dot product of two vertices.
		 *
		 * @param vertex
		 * @return the dot product (double value) of the two vertices
		 */
		public double dotProduct(Vertex vertex) {
		
			// Calculate and return the dot product.
			return (this.x * vertex.x) + (this.y * vertex.y);
		}
	
		/**
		 * Compute the norm.
		 *
		 * @return the norm
		 */
		public double norm() {
		
			// Return the norm.
			return Math.sqrt(dotProduct(this));
		}
		
		/**
		 * Return the Euclidean distance between two vertices.
		 *
		 * @param vertex.
		 * @return the distance between the two vertices.
		 */
		public double distance(Vertex vertex) {
			
			// Return the distance between the two.
			return subtract(vertex).norm();
		}
	}
	
	/**
	 * An Edge holds two variables:
	 * - two Vertices (head, tail).
	 */
	static class Edge {
	
		/**
		 * Variables.
		 */
		public Vertex head, tail;
			
		/**
		 * Default constructor.
		 *
		 * @param head
		 * @param tail
		 */
		public Edge(Vertex head, Vertex tail) {
		
			// Pass the parameters.
			this.head = head;
			this.tail = tail;
		}
		
		/**
		 * @return description
		 */
		public String toString() {
	
			return this.head.toString() + " -- " + this.tail.toString();
		}
		
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
	}
	
	/**
	 * A Centroid is calculated using an equation,
	 * which in turn divides the sample space for each dimension into equal parts.
	 * depending on the "NUM_MESHES" global parameter.
	 *
	 * Class Centroid holds the same variables as a Vertex, in addition to the following:
	 * - polygon (reference).
	 */
	static class Centroid extends Vertex {
		
		/**
		 * Variables.
		 */
		private Polygon polygon;
		
		/**
		 * Default constructor.
		 *
		 * @param polygon
		 */
		public Centroid(Polygon polygon) {
			
			// Set (x = 0.0, y = 0.0).
			super();
			
			// Set the polygon reference.
			this.polygon = polygon;
		}
		
		/**
		 * @param x
		 * @param y
		 * @param polygon
		 */
		public Centroid(double x, double y, Polygon polygon) {
			
			// Pass the parameters.
			super(x, y);
			
			// Set the polygon reference.
			this.polygon = polygon;
		}
		
		/**
		 * Calculate/recalculate its position from within a Polygon mesh.
		 * Called from within parseData().
		 */
		public void calculate() {
			
			// Get a reference to the current number of Polygon points.
			int numberOfVertices = this.polygon.vertices.length;
		
			double _x = 0.0;
			double _y = 0.0;
		
			// Reset the positions array.
			for (int i = 0; i < numberOfVertices; ++i) {
		
				// Update the current x value.
				_x += this.polygon.vertices[i].x;

				// Update the current x value.
				_y += this.polygon.vertices[i].y;
			}
		
			// Update the coordinates.
			this.x = _x / numberOfVertices;
			this.y = _y / numberOfVertices;
		}
	}
	
	/**
	 * A Polygon holds ... variables:
	 * - (n) number of Vertices,
	 */
	static class Polygon {
	
		/**
		 * Variables.
		 */
		public Vertex[] vertices;
		public Edge[] edges;
		public Vertex velocity;
		public Centroid centroid;
			
		/**
		 * Default constructor.
		 *
		 * @param vertices
		 * @param edges
		 * @param velocity
		 */
		public Polygon(Vertex[] vertices, Edge[] edges, Vertex velocity) {
		
			// Pass the total number of vertices in this polygon.
			int numberOfVertices = vertices.length;
			
			// Pass the arrays.
			this.vertices = vertices;
			this.edges = edges;
			
			// Pass the velocity.
			this.velocity = velocity;
			
			// Init the centroid of this polygon, and determine its position.
			this.centroid = new Centroid(this);
			this.centroid.calculate();
		}
		
		/**
		 * Propagate (i.e. translate or animate) the polygon over time.
		 *
		 * @param increment
		 */
		public void propagate(double increment) {
			
			double deltaX = this.velocity.x * increment;
			double deltaY = this.velocity.y * increment;
					
			// Propagate this polygon.			
			for (int i = 0; i < this.vertices.length; ++i) {
				
				this.vertices[i].x += deltaX;
				this.vertices[i].y += deltaY;
			}
			
			// Recalculate its position after propagation.
			this.centroid.calculate();
		}
		
		/**
		 * Compute/recompute the area of this polygon.
		 */
		private void calculateArea() {}
		
		/**
		 * @return x (MAX)
		 */
		public double getXMAX() {
		
			double x = this.vertices[0].x;
		
			for (int i = 0; i < this.vertices.length; ++i) {
			
				Vertex vertex = this.vertices[i];
			
				x = (vertex.x >= x) ? vertex.x : x;
			}
		
			return x;
		}
	
		/**
		 * @return y (MAX)
		 */
		public double getYMAX() {
		
			double y = this.vertices[0].y;
		
			for (int i = 0; i < this.vertices.length; ++i) {
			
				Vertex vertex = this.vertices[i];
			
				y = (vertex.y >= y) ? vertex.y : y;
			}
		
			return y;
		}

		/**
		 * @return x (MIN)
		 */
		public double getXMIN() {
		
			double x = this.vertices[0].x;
		
			for (int i = 0; i < this.vertices.length; ++i) {
			
				Vertex vertex = this.vertices[i];
			
				x = (vertex.x < x) ? vertex.x : x;
			}
		
			return x;
		}

		/**
		 * @return y (MIN)
		 */
		public double getYMIN() {
		
			double y = this.vertices[0].y;
		
			for (int i = 0; i < this.vertices.length; ++i) {
			
				Vertex vertex = this.vertices[i];
			
				y = (vertex.y < y) ? vertex.y : y;
			}
		
			return y;
		}
	}
	
	/**
	 * Log (print) the argument string to console.
	 *
	 * @param args
	 */
	static void log(String args) {
		
		System.out.println(args);
	}
	
	/**
	 * Imports polygon data into app, line-by-line.
	 *
	 * @param fileString the input file name
	 */
	static void parseData(String fileString) {
				
		/*
		 * File IO scanner.
		 */
		Scanner scanner = null;
		
		/*
		 * Two polygons.
		 */
		Polygon[] polygons = new Polygon[2];
		
		// Keeps track of each polygon.
		int polygonIdx = 0;
		
		try {
			
			scanner = new Scanner(new FileInputStream(new File(fileString)));
			
			/*
			 * Assuming the input data set is consisted of one, and only one line.
			 */
			if (DEBUG)
				log("---- " + fileString + ":");
						
			while (scanner.hasNextLine()) {
				
				// Establish the string tokens.
				String[] tokens = scanner.nextLine().trim().split("\\s+");
				
				// Read the number of vertices for this polygon.
				int numberOfVertices = Integer.parseInt(tokens[0]);
				int numberOfEdges = numberOfVertices;
					
				// Init the vertices of this polygon.
				Vertex[] vertices = new Vertex[numberOfVertices];

				// Init the edges of this polygon.
				Edge[] edges = new Edge[numberOfEdges];

				// Keeps track of each token.
				int idx = 0;

				// Read vertex data.
				for (int i = 0; i < numberOfVertices; ++i) {

					vertices[i] = new Vertex(
						Double.parseDouble(tokens[++idx]),
						Double.parseDouble(tokens[++idx]));
					
					if (i == 0)
						continue;
					
					Edge edge = new Edge(vertices[i], vertices[i - 1]);
					
					edges[i - 1] = edge;
				}
				
				// Last edge.
				edges[numberOfEdges - 1] = new Edge(vertices[0], vertices[numberOfVertices - 1]);
				
				// Read velocity data.
				Vertex velocity = new Vertex(
					Double.parseDouble(tokens[++idx]),
					Double.parseDouble(tokens[++idx]));
				
				// Add a new polygon..
				polygons[polygonIdx++] = new Polygon(vertices, edges, velocity);;
			}
			
			// Reference the two polygons.
			Polygon p0 = polygons[0];
			Polygon p1 = polygons[1];
			
			// Time of possible collision (or overlap).
			double t = 0.0;
			double increment = 1E-2; /* 0.01. */
			
			// Old and current Euclidean distances.
			double oldDistance = 0.0;
			double currentDistance = p0.centroid.distance(p1.centroid);
			
			// Iterate (t) till 5.0 seconds.
			while (t <= 5.0) {
				
				oldDistance = currentDistance;
				
				// Increment (t).
				t += increment;
				
				// Propagate both polygons.
				p0.propagate(increment);
				p1.propagate(increment);
				
				// Reference the new Euclidean distance.
				currentDistance = p0.centroid.distance(p1.centroid);
				
				// Compute the delta.
				double delta = currentDistance - oldDistance;
							
				if (delta >= 0.0) { /* Collision occurred. */
				
					log(p0.centroid.toString());
					log(p1.centroid.toString());
			
					log("Time of intersection = " + t + " (" + String.format("%g", delta) + ")");
					
					break;
				}
			}
					
		} catch (Exception e) {
		
			e.printStackTrace();
			
		} finally {
		
			if (scanner != null)
				scanner.close();
			scanner = null;
		}
	}
		
	/**
	 * @param args (arguments passed via command prompt)
	 */
	public static void main(String[] args) {
				
		/*
		 * Read from INFILE.
		 */
		ICPC.parseData(ICPC.class.getName() + "1.in");
	}
}
