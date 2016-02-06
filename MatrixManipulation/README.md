# NCCC Supplementary Material

## Fourth Task: Matrix Manipulation

Here, you are to develop a Java program (using [NetBeans](https://netbeans.org/)) to perform a selected number of [Matrix transformations and calculations](https://en.wikipedia.org/wiki/Matrix_multiplication) in Java.

In particular, you are expected to use the [sample code](https://raw.github.com/youldash/NCCC/master/MatrixManipulation/Matrices.java) (which is already written) to expand your knowledge in solving real-world applications and challenges that are related to problem domains like [Geometric Transformations (such as those performed in modern Computer Graphics)](https://en.wikipedia.org/wiki/Transformation_matrix), [Linear Mapping](https://en.wikipedia.org/wiki/Linear_map), and others.

By the time you accomplish this task, you should be able to:

* Have a descent understanding of Matrices, and perform Matrix manipulation operations in an Object-Oriented manner.
* Demonstrate the use of Static Methods in Java.
* Demonstrate the effectiveness and usefulness of the Java Math API.
* Parse data sets using new Java SDK libraries, such as Arrays, Files, Paths and more.

### Operations

To fully understand how [Matrices.java](https://raw.github.com/youldash/NCCC/master/MatrixManipulation/Matrices.java) can be used, take a closer look at the following:

| Item | Type | Description |
|:----:|:----:|:-----------:|
| `InvalidCalculationException` | class | Utility class. Useful for dealing with `RuntimeException` situations such as invalid Matrix and Vector calculation attempts. |
| `add()` | method | Two overloading methods: One for computing the sum of two input matrices, and another for two input vectors (i.e. one-dimensional arrays). |
| `subtract()` | method | Two overloading methods: One for computing the difference between two input matrices, and another for two input vectors (i.e. one-dimensional arrays). |
| `multiply()` | method | Useful for computing the product of two input matrices. |
| `multiplyScalar()` | method | Useful for scaling an input matrix by a factor (or coefficient). |
| `clone()` | method | Clones (or copies) an input matrix. |
| `getRow()` | method | Returns a row vector from an input matrix (at a given index). |
| `getColumn()` | method | Returns a column vector from an input matrix (at a given index). |
| `dotProduct()` | method | Returns the Dot Product of two input vectors. |
| `norm()` | method | Computes the norm (or length) of an input vector. |
| `normalize()` | method | Generates a normalized version of the input vector. |
| `project()` | method | Returns the projection (or mapping) of the input vector onto the subspace spanned by a projection vector. This method is particularly useful in carrying out [Linear Projection](https://en.wikipedia.org/wiki/Projection_(linear_algebra)) operations. |
| `transpose()` | method | Generates a transposed version of an input matrix. |
| `getDiagonalEntries()` | method | Extracts an array of the diagonal entries from an input matrix. |
| `log()` | method | Prints the formatted contents of an input matrix to screen. |
| `testAdd()` | method | Useful for testing the addition of matrices. |
| `testSubtract()` | method | Useful for testing the subtraction of matrices. |
| `parseData()` | method | Extracts the contents of an input data set  to construct a matrix. |

### Try This

Substitute [MEDIUM.in](https://raw.github.com/youldash/NCCC/master/MatrixManipulation/MEDIUM.in) with other sample data sets, like [SMALL.in](https://raw.github.com/youldash/NCCC/master/MatrixManipulation/SMALL.in), [LARGE.in](https://raw.github.com/youldash/NCCC/master/MatrixManipulation/LARGE.in), and your own.
