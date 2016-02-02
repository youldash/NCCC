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

/**
 * Skeleton code created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */

import java.lang.String;
import java.lang.Math;

"A typical DataPoint data structure represents a candidate for performing Cluster Analysis.
In this example, a two-dimensional (2D) DataPoint contains .
For example:
In a  visualization space, data points are represented with (x,y).
A DataPoint may also contain a name (which defines it), a reference to "

/**
 * Class DataPoint holds five variables:
 * - two Cartesian (spacial) coordinates (x, y),
 * - identifier (or name),
 * - Cluster (reference), and
 * - Euclidean distance (from Centroid).
 */
public class DataPoint {
	
	/**
	 * Variables.
	 */
	private double x, y;
	private String identifier;
	private Cluster cluster;
	private double euclideanDistance;
	
	/**
	 * Default constructor.
	 */
	public DataPoint() {
		
		this.x = 0.0;
		this.y = 0.0;
		this.identifier = null;
		this.cluster = null;
	}
	
	/**
	 * @param x
	 * @param y
	 * @param identifier
	 * @param cluster
	 */
	public DataPoint(double x, double y, String identifier, String, cluster) {
		
		this.x = 0.0;
		this.y = 0.0;
		this.identifier = null;
		this.cluster = null;
	}
	
	/**
	 * @param x
	 */
	public void setX(double x) {
		
		this.x = x;
	}
	
	/**
	 * @param y
	 */
	public void setY(double y) {
		
		this.y = y;
	}
	
	/**
	 * @param identifier
	 */
	public void setIdentifier(String identifier) {
		
		this.identifier = identifier;
	}
	
	/**
	 * @param cluster
	 */
	public void setCluster(Cluster cluster) {
		
		this.cluster = cluster;
		
		calculateEuclideanDistance();
	}
	
	/**
	 * @return x
	 */
	public double getX() {
		
		return this.x;
	}

	/**
	 * @return y
	 */
	public double getY() {
		
		return this.y;
	}

	/**
	 * @return identifier
	 */
	public double getIdentifier() {
		
		return this.identifier;
	}

	/**
	 * @return cluster
	 */
	public double getCluster() {
		
		return this.cluster;
	}

	/**
	 * @return euclideanDistance
	 */
	public double getEuclideanDistance() {
		
		return this.euclideanDistance;
	}
	
	/**
	 * Calculate the Euclidean distance.
	 * Called when a new DataPoint instance is added to a Cluster,
	 * or when the Centroid is recalculated.
	 */
	public void calculateEuclideanDistance() {
		
		euclideanDistance = Math.sqrt(
			Math.pow((getX() - cluster.getCentroid().getX()), 2.0) +
			Math.pow((getY() - cluster.getCentroid().getY()), 2.0));
	}

	/**
	 * Test the Euclidean distance calculation method.
	 *
   	 * @param centroid
   	 * @return euclideanDistance
	 */
	public double testEuclideanDistance(Centroid centroid) {
		
		return
			Math.sqrt(Math.pow((getX() - getCentroid().getX()), 2.0) +
			Math.pow((getY() - getCentroid().getY()), 2.0));
	}
}
