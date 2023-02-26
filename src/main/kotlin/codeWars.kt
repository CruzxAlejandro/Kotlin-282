/************************************************************
 *  Name:         Alex Cruz
 *  Date:         2/17/23
 *  Assignment:
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/

fun main() {
    println(isLeapYear(2020)
    )

}

fun isLeapYear(year: Int) : Boolean {

    return when {
        year % 400 == 0 -> true
        year % 100 == 0 -> false
        else -> year % 4 == 0
    }

}


