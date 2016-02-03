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
import java.util.Vector;

/**
 * A class is the entry point for constructing clusters of DataPoint instances (using k-Means).
 * Each algorithm instance is associated with one or more Cluster instances.
 *
 * Class ClusteringAlgorithm holds five variables:
 * - numberOfClusters,
 * - clusters (as an array),
 * - dataPoints (as a Vector),
 * - numberOfIterations (denoting the parameter "k" in the Cluster Analysis literature), and
 * - sumOfWCSS (or the Sum of Within-Cluster Sums of Squares).
 */
public class ClusteringAlgorithm {
	
	/**
	 * Variables.
	 */
	private int numberOfClusters;
	private Cluster[] clusters;
	private int numberOfIterations;
	private Vector dataPoints;
	private double sumOfWCSS;
	
	/**
	 * Default constructor for the k-Means Clustering algorithm.
	 *
	 * @param numberOfClusters
	 * @param numberOfIterations
	 * @param dataPoints
	 */
	public ClusteringAlgorithm(
		int numberOfClusters,
		int numberOfIterations,
		Vector dataPoints) {
		
		// Init the clusters array based on numberOfClusters (or parameter "k").
		this.clusters = new Cluster[numberOfClusters];
		
		for (int i = 0; i < numberOfClusters; ++i) {
			
		    clusters[i] = new Cluster("Cluster[" + i + "]");
		}
		
		// Set the other parameters.
		this.numberOfIterations = numberOfIterations;
		this.dataPoints = dataPoints;
	}
	
	/**
	 * @param args (arguments passed via command prompt)
	 */
	public static void main(String[] args) {
		
		
	}
}
