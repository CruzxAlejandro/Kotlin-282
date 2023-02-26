/************************************************************
 *  Name:         Alex Cruz
 *  Date:         1/18/23
 *  Assignment:   Right Triangle
 *  Class Number: CIS 282
 *  Description:  Write a program that prints out a right triangle
 ************************************************************/

fun main() {


    print("Enter a number: ")
    var size = readLine()!!.toInt()

    // TOP
    // If size is greater than or equal to zero print a *


    if (size >= 0) {
        println("*")
    }

    // Right Side
    // Declare a new variable starting at 0
    // Outer FOR loop will print a "*" for the range 1 through size - 2
    // Inner boolean statement checks if 'count' is less than or equal to size - 2
    // If true, an empty space will print for the amount in counter, then increment by 1
    // a "*" is printed from the outer loop before ending
    // this will keep looping until the Outer loop reaches size - 2

    var count = 0
    for (i in 1..(size-2)) {
        print("*")
            if (count <= (size-2)) {
                print(" ".repeat(count))
                count++
            }
        println("*")
    }
    // Bottom
    // This for loop will print the range 1 through 'size' , in my test data I used 8
    for (i in 1..size) {
        print("*")
    }

    println()
    println()

    // Because we don't have to work about spacing or indenting, this nested FOR loop gives us our right triangle
    // The Outer loop is declaring that i will range through 'size' (# that user inputs). Currently it is i = 1
    // The inner loop is declaring that CountTwo = i, and printing. So everytime it loops through, 'countTwo' is printing all of the numbers in i until it reaches the end. The outer loop prints a new line and starts over
    // This full loop will keep going until i is reaches then end of 'size' (# that user inputs)


    for (i in 1..size) {
        for (countTwo in 1..i) {
            print(countTwo)
        }
        println()
    }



}


/*
<--! Examples Below -->

height and width determined by user

ex: 8

*           1
**          2   (0 spaces)
* *         3   (1 space)
*  *        4   (2 spaces)
*   *       5   (3 spaces)
*    *      6   (4 spaces)
*     *     7   (5 spaces)
********    8

ex: 5

*           1
**          2   (0 spaces)
* *         3   (1 space)
*  *        4   (2 spaces)
*****       5


ex: 8

1
12
123
1234
12345
123456
1234567
12345678

 */