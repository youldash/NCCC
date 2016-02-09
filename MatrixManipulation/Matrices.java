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

import java.lang.RuntimeException;
import java.lang.String;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.lang.NullPointerException;
import java.util.Scanner;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Arrays;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class is specifically written for performing matrix calculations (or manipulation).
 *
 * Created using TextMate version 2.0 on a Mac OS X 10.10.5 system.
 */
class Matrices {
	
	/**
	 * Properties.
	 */
	static final boolean DEBUG = true;
	
	static File inFile;
	
	/**
	 * Default constructor.
	 */
	public Matrices() {}
	
	/**
	 * An Exception class.
	 * Thrown when an invalid matrix manipulation (operation) is ever attempted.
	 */
	static class InvalidCalculationException extends RuntimeException {
		
		/**
		 * Default constructor.
		 * 
		 * @param message
		 */
		public InvalidCalculationException(String message) {
		
			super(message);
		}
	}
	
	/**
	 * Return the sum of the (left + right) operation.
	 *
	 * @param left double[][] matrix of values
	 * @param right	double[][] matrix of values
	 * @return the matrix difference (left + right)
	 */
	static double[][] add(double[][] left, double[][] right) {
		
		if (left.length != right.length ||
			left[0].length != right[0].length) {
			
			throw new InvalidCalculationException("Invalid operation: Matrices are not compatible!");
		}
		
		// Establish the result matrix.
		double[][] result = new double[left.length][left[0].length];
		
		for (int i = 0; i < result.length; ++i) {
			
			for (int j = 0; j < result[0].length; ++j) {
				
				// Perform the operation.
				result[i][j] = left[i][j] + right[i][j];
			}
		}
		
		// Return it.
		return result;
	}
	
	/**
	 * Return the difference of the (left - right) operation.
	 *
	 * @param left double[][] matrix of values
	 * @param right	double[][] matrix of values
	 * @return the matrix difference (left - right)
	 */
	static double[][] subtract(double[][] left, double[][] right) {
		
		if (left.length != right.length ||
			left[0].length != right[0].length) {
			
			throw new InvalidCalculationException("Invalid operation: Matrices are not compatible!");
		}
		
		// Establish the result matrix.
		double[][] result = new double[left.length][left[0].length];
		
		for (int i = 0; i < result.length; ++i) {
			
			for (int j = 0; j < result[0].length; ++j) {
				
				// Perform the operation.
				result[i][j] = left[i][j] - right[i][j];
			}
		}
		
		// Return it.
		return result;
	}
	
	/**
	 * Return the product of the (left * right) operation.
	 * Note that if the "horizontal" length of the left matrix is not equal to
	 * the "vertical" length of the right matrix, then an exception is thrown.
	 *
	 * @param left double[][] matrix of values
	 * @param right	double[][] matrix of values
	 * @return the matrix product (left * right)
	 */
	static double[][] multiply(double[][] left, double[][] right) {
		
		if (left.length != right[0].length) {
			
			throw new InvalidCalculationException("Invalid operation: Matrices are not compatible!");
		}
		
		// Establish the result matrix.
		double[][] result = new double[right.length][left[0].length];
		
		for (int i = 0; i < result.length; ++i) {
			
			for (int j = 0; j < result[0].length; ++j) {
				
				// Establish both row and column vectors from both left and right matrices, respectively.
				double[] row = getRow(left, j);
				double[] column = getColumn(right, i);
				
				// Perform the operation.
				result[i][j] = dotProduct(row, column);
			}
		}
		
		// Return it.
		return result;
	}
	
	/**
	 * Return a version of this matrix scaled by a constant (or coefficient).
	 *
	 * @param left double[][] matrix of values
	 * @param coefficient (constant) by which to scale.
	 * @return the matrix scaled by coefficient
	 */
	static double[][] multiplyScalar(double[][] matrix, double coefficient) {
		
		// Establish the result matrix.
		double[][] result = new double[matrix.length][matrix[0].length];
		
		for (int i = 0; i < result.length; ++i) {
			
			for (int j = 0; j < result[0].length; ++j) {
				
				// Perform the operation.
				result[i][j] = matrix[i][j] * coefficient;
			}
		}
		
		// Return it.
		return result;
	}
	
	/**
	 *	Return a clone (or deep copy) of the input double[][] matrix.
	 *
	 *  @return the cloned double[][] matrix
	 */
	static double[][] clone(double[][] matrix) {
		
		// Establish the clone matrix.
		double[][] clone = new double[matrix.length][matrix[0].length];
		
		for (int i = 0; i < clone.length; ++i) {
			
			for (int j = 0; j < clone[0].length; ++j) {
				
				// Copy each value.
				clone[i][j] = matrix[i][j];
			}
		}
		
		// Return it.
		return clone;
	}
	
	/**
	 * Return the i'th row array (vector) of the input double[][] matrix.
	 *
	 *  @param matrix the input double[][] matrix
	 *  @param i an index
	 *
	 *  @return the i'th row array of the input matrix
	 */
	static double[] getRow(double[][] matrix, int i) {
		
		// Establish the row array.
		double[] row = new double[matrix.length];
		
		for (int j = 0; j < row.length; j++) {
			
			// Copy each row value.
			row[j] = matrix[j][i];
		}
		
		// Return the row array.
		return row;
	}

	/**
	 * Return the i'th column array (vector) of the input double[][] matrix.
	 *
	 *  @param matrix the input double[][] matrix
	 *  @param i an index
	 *
	 *  @return the i'th column array of the input matrix
	 */
	static double[] getColumn(double[][] matrix, int i) {
		
		// Return the i'th value.
		return matrix[i];
	}
	
	/**
	 * Return the sum of the (left + right) operation.
	 *
	 * @param left double[] vector of values
	 * @param right	double[] vector of values
	 * @return the vector difference (left + right)
	 */
	static double[] add(double[] left, double[] right) {
		
		if (left.length != right.length) {
			
			throw new InvalidCalculationException("Invalid operation: Vectors are not compatible!");
		}
		
		// Establish the result vector.
		double[] result = new double[left.length];
		
		for (int i = 0; i < result.length; ++i) {
			
			// Perform the operation.
			result[i] = left[i] + right[i];
		}
		
		// Return it.
		return result;
	}
	
	/**
	 * Return the difference of the (left - right) operation.
	 *
	 * @param left double[] vector of values
	 * @param right	double[] vector of values
	 * @return the vector difference (left - right)
	 */
	static double[] subtract(double[] left, double[] right) {
		
		if (left.length != right.length) {
			
			throw new InvalidCalculationException("Invalid operation: Vectors are not compatible!");
		}
		
		// Establish the result vector.
		double[] result = new double[left.length];
		
		for (int i = 0; i < result.length; ++i) {
			
			// Perform the operation.
			result[i] = left[i] - right[i];
		}
		
		// Return it.
		return result;
	}
		
	/**
	 *  Return the dot product of two vectors:
	 * {left[0]right[0], left[1]right[1], ..., left[n]right[n]}.
	 *
	 *  @param left double[] vector
	 *  @param right double[] vector
	 *  @return the dot product (double value) of the two double[] vectors
	 */
	static double dotProduct(double[] left, double[] right) {
		
		if (left.length != right.length) {
			
			throw new InvalidCalculationException(
				"Invalid operation: Vector lengths not equal: " +
				left.length + " =/= " + left.length + ".");
		}
		
		// Establish the product.
		double product = 0.0;
		
		for(int i = 0; i < left.length; ++i) {
			
			// Perform the operation.
			product += left[i] * right[i];
		}
		
		// Return it.
		return product;
	}
	
	/**
	 * Compute the norm (or length) of an input double[] vector
	 * @return ||vector||
	 */
	static double norm(double[] vector) {
		
		// Return the norm.
		return Math.sqrt(dotProduct(vector, vector));
	}
	
	/**
	 * Return the normalized version of the input double[] vector.
	 * In other words, scale the input vector so that ||vector|| = 1.
	 *
	 * @return vector / ||vector||
	 */
	static double[] normalize(double[] vector) {
		
		// Establish the result matrix.
		double[] result = new double[vector.length];
		
		// Compute the norm.
		double norm = norm(vector);
		
		// Avoid division by 0.
		if (norm > 0.0) {
			
			for (int i = 0; i < result.length; ++i) {
							
				// Perform the operation.
				result[i] = vector[i] / norm;
			}
		}
		
		// Return it.
		return result;
	}
	
	/**
	 * Returns the projection (or mapping) of the input double[] vector
	 * onto the subspace spanned by the projection double[] vector.
	 *
	 * @param vector the vector to be projected
	 * @param projection the spanning vector of the target subspace
	 * @return vector[] (projected onto projVector[])
	 */
	static double[] project(double[] vector, double[] projVector) {
		
		// Compute the Dot Product.
		double dotProduct = dotProduct(projVector, vector) / dotProduct(projVector, projVector);
		
		// Establish the projection vector.
		double[] projection = new double[vector.length];
		
		for (int i = 0; i < projection.length; ++i) {
			
			// Compute the i'th value of the new projection vector.
			projection[i] = projection[i] * dotProduct;
		}
		
		// Return the resulted projection.
		return projection;
	}
	
	/**
	 * Return the transpose of the input double[][] matrix.
	 *
	 * @param left double[][] matrix of values
	 * @return a transposed version of the input double[][] matrix
	 */
	static double[][] transpose(double[][] matrix) {
		
		// Establish the result matrix.
		double[][] result = new double[matrix[0].length][matrix.length];
		
		for (int i = 0; i < result.length; ++i) {
			
			for (int j = 0; j < result[0].length; ++j) {
				
				// Perform the operation.
				result[i][j] = matrix[j][i];
			}
		}
		
		// Return it.
		return result;
	}
	
	/**
	 * Produce an array of the diagonal entries in the input double[][] matrix.
	 *
	 * @param matrix
	 * @return the entries on the diagonal of the input double[][] matrix
	 */
	static double[] getDiagonalEntries(double[][] matrix) {
		
		// Establish the result vector.
		double[] result = new double[matrix.length];
		
		for (int i = 0; i < matrix.length; ++i) {
			
			// Extract the diagonal.
			result[i] = matrix[i][i];
		}
		
		// Return it.
		return result;
	}
	
	/**
	 * Log the input double[][] matrix with each value formatted (rounded to 2 significant decimals).
	 */
	static void log(double[][] matrix) {
		
		/*
		 * Real numbers are output to 2 decimal places using this DecimalFormat instance.
		 */
		DecimalFormat formatter = new DecimalFormat(".00");
		
		for (int i = 0; i < matrix.length; ++i) {
			
			for(int j = 0; j < matrix[0].length; j++) {
				
				// Log the current formatted value.
				System.out.print((Double.parseDouble(formatter.format(matrix[i][j]))) + "\t");
			}
			
			System.out.print("\n");
		}
		
		// System.out.println("");
	}
		
	/**
	 * Matrix addition test method.
	 *
	 * @param left double[][] matrix of values
	 * @param right	double[][] matrix of values
	 * @return a boolean value that indicates whether all the tests were successful or not
	 */
	static boolean testAdd(double[][] left, double[][] right) {
		
		// Log the result matrix.
		Matrices.log(Matrices.add(left, right));
		
		// Passed.
		return true;
	}
	
	/**
	 * Matrix subtraction test method.
	 *
	 * @param left double[][] matrix of values
	 * @param right	double[][] matrix of values
	 * @return a boolean value that indicates whether all the tests were successful or not
	 */
	static boolean testSubtract(double[][] left, double[][] right) {
		
		// Log the result matrix.
		Matrices.log(Matrices.subtract(left, right));
		
		// Passed.
		return true;
	}	
	
	/**
	 * Uses the file given by INFILE to construct a matrix.
	 * All numbers are expected to be space-delimited!
	 *
	 * @param fileString the input file name
	 */
	static void parseData(String fileString) {
		
		if (DEBUG)
			System.out.println("---- " + fileString + ":");
		
		try {
				
			inFile = new File(fileString);
			FileInputStream fis = new FileInputStream(inFile);
		
			Scanner fileScanner = new Scanner(fis);
			fileScanner.useLocale(Locale.US);
			fileScanner.useDelimiter(" ");
			
			/*
			 * Read the data file.
			 */
			if (fis != null) {
			
				if (DEBUG)
					System.out.println("Loading...");
			
				try {
					
					/*
					 * NOTE: The following code compiles with Java SDK version 1.7 and higher.
					 */								
					List lines = Files.readAllLines(
						Paths.get(fileString), /* Get the path of the input file. */
						Charset.defaultCharset()); /* Use the default charset. */
					
					// Pre-read in the number of rows/columns.
					int numberOfRows = lines.size();
					int numberOfColumns = lines.get(0).toString().trim().split("\\s+").length;
					int row = 0;
					
					// Establish the target matrix.
					double[][] matrix = new double[numberOfRows][numberOfColumns];
					
					for (Object line : lines) {
						
						// Establish the string tokens.
						String[] values = line.toString().trim().split("\\s+");
						
						// Update the number of columns in this row.
						numberOfColumns = values.length;
						
						for (int column = 0; column < numberOfColumns; ++column) {

							// Assign the new double value to be at matrix[row][column].
							matrix[row][column] = Double.parseDouble(values[column]);
						}
												
						// Move on to the next row in file.
						++row;
					}
					
					// Log the new matrix.
					Matrices.log(matrix);
					System.out.println();
					
					/*
					 * Perform testAdd().
					 */
					System.out.println("---- testAdd():");
					double[][] MEDIUM = {

						{4, 4.2, 3.9, 4.3, 4.1},
						{2, 2.1, 2, 2.1, 2.2},
						{0.6, 0.59, 0.58, 0.62, 0.63}
					};
											
					if (Matrices.testAdd(matrix, MEDIUM)) {
						
						System.out.println("PASSED.\n");
						
					} else
						System.err.println("FAILED.\n");
					
					/*
					 * Perform testSubtract().
					 */
					System.out.println("---- testSubtract():");
											
					if (Matrices.testSubtract(matrix, MEDIUM)) {
						
						System.out.println("PASSED.\n");
						
					} else
						System.err.println("FAILED.\n");
					
				} catch (IOException e) {

					e.printStackTrace();
					
				} catch (NoSuchElementException e) {
				
					e.printStackTrace();
					
				} catch (NumberFormatException e) {
				
					e.printStackTrace();
					
				} catch (NullPointerException e) {
				
					e.printStackTrace();
					
				} finally {
										
					if (DEBUG)
						System.out.println("Complete.");
						
					if (fis != null)
						fis.close();
					fis = null;
				
					if (fileScanner != null)
						fileScanner.close();
					fileScanner = null;
				}
			}
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
			
		} catch (EOFException e) {
		
			e.printStackTrace();
			
		} catch (StreamCorruptedException e) {
		
			e.printStackTrace();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args (arguments passed via command prompt)
	 */
	public static void main(String[] args) {
				
		// Unit testing.
		if (DEBUG) {
												
			/*
			 * Read from INFILE.
			 */
			Matrices.parseData("MEDIUM.in");
		}
	}
}
