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
 * An Amalgamated Artichokes (AA) Solution...
 * Source: https://open.kattis.com/problems/artichoke
 *
 * Created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */
class AA {
	
	/**
	 * Properties.
	 */
	static final boolean DEBUG = true;
			
	/**
	 * Compute the stock price over any period of time (n) based on the following equation:
	 * price(n) = p · (sin(a · n + b) + cos(c · n + d) + 2).
	 *
	 * @param p
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param n
	 * @return price
	 */
	static double price(int p, int a, int b, int c, int d, int n) {
		
		// Establish the computed price.
		double price = (double)p * (Math.sin(a * n + b) + Math.cos(c * n + d) + 2.0);
		
		// Return it.
		return price;
	}
	
	/**
	 * Uses the file given by INFILE to construct a matrix.
	 * All numbers are expected to be space-delimited!
	 *
	 * @param fileString the input file name
	 */
	static void parseData(String fileString) {
				
		/*
		 * File IO.
		 */
		Scanner scanner = null;
		
		try {
			
			scanner = new Scanner(new FileInputStream(new File(fileString)));
			
			/*
			 * Assuming the input data set is consisted of one, and only one line.
			 */
			if (DEBUG)
				System.out.println("---- " + fileString + ":");
							
			/*
			 * Establish both max and resolved price values.
			 */
			double maxPrice = Double.MIN_VALUE;
			double resolvedPrice = Double.MIN_VALUE;
			
			/*
			 * The input consists of a single line containing 6 integers like so:
			 */
			
			// Read in "p" (1 ≤ p ≤ 1000).
			int p = scanner.nextInt();
									
			// Read in "a" (0 ≤ a ≤ 1000).
			int a = scanner.nextInt();
										
			// Read in "b" (0 ≤ a ≤ 1000).
			int b = scanner.nextInt();
								
			// Read in "c" (0 ≤ a ≤ 1000).
			int c = scanner.nextInt();
									
			// Read in "d" (0 ≤ a ≤ 1000).
			int d = scanner.nextInt();
			
			// Read in "n" (1 ≤ n ≤ 10^6).
			int n = scanner.nextInt();
		
			if (DEBUG)
				System.out.printf("(%d, %d, %d, %d, %d, %d)\n", p, a, b, c, d, n);
			
			/*
			 * Loop through the range of prices as determined by (n) i.e. 1 ≤ k ≤ n.
			 */
			for (int k = 1; k <= n; ++k) {
				
				// Compute the current price.
				double price = AA.price(p, a, b, c, d, k);
				
				// Find the maximum price over this period.
				if (price > maxPrice) {
					
					maxPrice = price;
					
					// if (DEBUG)
					// 	System.out.printf("MAX(%d) = %.6f\n", k, maxPrice);
				
				} else if (price < maxPrice && k > 1) { // Price is lower than max and in range.
					
					// Establish the difference in prices.
					double difference = maxPrice - price;
					
					// Find the lowest price drop over this period.
					if (difference > resolvedPrice) {
						
						resolvedPrice = difference;
						
						// if (DEBUG)
						// 	System.out.printf("MIN(%d) = %.6f\n", k, resolvedPrice);
					}
				}
			}
				
			// Resolve the output to 0.00 if resolvedPrice is determined 0.0.
			if (resolvedPrice == Double.MIN_VALUE) {
				
				System.out.printf("%.2f\n", 0.0);
			
			} else { // Display the output.
				
				System.out.printf("%.6f\n", resolvedPrice);
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
		AA.parseData(AA.class.getName() + "1.in");
		AA.parseData(AA.class.getName() + "2.in");
		AA.parseData(AA.class.getName() + "3.in");
		
		/*
		
		Wrong answers (if price() was used without the for-loop):
		
		---- AA1.in:
		(42, 1, 23, 4, 8, 10)
		99.1102
		---- AA2.in:
		(100, 7, 615, 998, 801, 3)
		398.419
		---- AA3.in:
		(100, 432, 406, 867, 60, 1000)
		242.707
			
		Correct answers (based on the code above):
			
		---- AA1.in:
		(42, 1, 23, 4, 8, 10)
		104.855110
		---- AA2.in:
		(100, 7, 615, 998, 801, 3)
		0.00
		---- AA3.in:
		(100, 432, 406, 867, 60, 1000)
		399.303813
		*/
	}
}
