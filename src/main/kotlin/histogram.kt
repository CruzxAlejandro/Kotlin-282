
/************************************************************
 *  Name:         Alex Cruz
 *  Date:         2/5/23
 *  Assignment:   Arrays - Histogram
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/

fun main() {
    // Created variables for each range of numbers
    var setOne = 0
    var setTwo = 0
    var setThree = 0
    var setFour = 0
    var setFive = 0
    var setSix = 0
    var setSeven = 0
    var setEight = 0
    var setNine = 0
    var setTen = 0
    // my variable that holds my array of numbers
    var randomSet = arrayOf<Int>()
    // my loop that plugs those random numbers into my array above
    for (i in 1..200) {
        var numbers = (1..100).random()
        randomSet += numbers
    }
    // for loop that finds ranges I created and increments the variables I created earlier
    for (i in randomSet) {
        if (i in 1..10) {
            setOne++
        }
        else if (i in 11..20){
            setTwo++
        }
        else if(i in 21..30){
            setThree++
        }
        else if(i in 31..40){
            setFour++
        }
        else if(i in 41..50) {
            setFive++
        }
        else if(i in 51..60){
            setSix++
        }
        else if(i in 61..70){
            setSeven++
        }
        else if(i in 71..80){
            setEight++
        }
        else if(i in 81..90){
            setNine++
        }
        else {
            setTen++
        }

    }
    // My menu/map that prints out what was found in my variables

    println("Range".padEnd(8) + " ".repeat(5) + "# Found".padEnd(10) + " ".repeat(4) + "Chart")
    println("-".repeat(8) + " ".repeat(5) + "-".repeat(10) + " ".repeat(4) +"-".repeat(43) )
    println("1".padStart(2) + " - " + "10".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setOne}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setOne) )
    println("11".padStart(2) + " - " + "20".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setTwo}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setTwo) )
    println("21".padStart(2) + " - " + "30".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setThree}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setThree) )
    println("31".padStart(2) + " - " + "40".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setFour}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setFour) )
    println("41".padStart(2) + " - " + "50".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setFive}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setFive) )
    println("51".padStart(2) + " - " + "60".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setSix}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setSix) )
    println("61".padStart(2) + " - " + "70".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setSeven}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setSeven) )
    println("71".padStart(2) + " - " + "80".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setEight}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setEight) )
    println("81".padStart(2) + " - " + "90".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setNine}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setNine) )
    println("91".padStart(2) + " - " + "100".padStart(3) + " ".repeat(5) + " |".padEnd(4) + "${setTen}".padStart(2) + "| ".padStart(4) + " ".repeat(4) + "*".repeat(setTen) )

}







// my initial thought process when trying to solve the problem

/*
// #Found is zero, Loops through random integers and finds for i in 1..10, increment 1
the asterisks then print for the amount of integers found

 1 -  10      |  28  |     ****************************


Example to work with

Range        # Found       Chart
--------     ----------    -------------------------------------------
 1 -  10      |  28  |     ****************************
11 -  20      |  18  |     ******************
21 -  30      |  21  |     *********************
31 -  40      |  26  |     **************************
41 -  50      |  23  |     ***********************
51 -  60      |   7  |     *******
61 -  70      |  18  |     ******************
71 -  80      |  24  |     ************************
81 -  90      |  14  |     **************
91 - 100      |  22  |     **********************
 */