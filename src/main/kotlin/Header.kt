/************************************************************
 *  Name:         Alex Cruz
 *  Date:         1/11/23
 *  Assignment:   Header
 *  Class Number: CIS 282
 *  Description:  Print out a header to put on each program
 ************************************************************/
fun main() {
    print("Name: ")
    var name = readLine()!!
    print("Date: ")
    var date = readLine()!!
    print("Assignment: ")
    var assignment = readLine()!!
    print("Class Number: ")
    var classNumber = readLine()!!
    print("Description: ")
    var description = readLine()!!


    println("/" + "*".repeat(60))
    println(" *  Name:         ${name}")
    println(" *  Date:         ${date}")
    println(" *  Assignment:   ${assignment}")
    println(" *  Class Number: ${classNumber}")
    println(" *  Description:  ${description}")
    println(" " + "*".repeat(60) + "/")

}