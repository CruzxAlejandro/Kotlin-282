import java.io.File
/************************************************************
 *  Name:         Alex Cruz
 *  Date:         2/20/23
 *  Assignment:   Hashmaps and Database Reporting
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/

const val weatherDBFile = "src/main/kotlin/weather.db"
data class Weather (val month : Int, val day : Int, val sunrise : String, val sunset : String, val mean : Int, val avgHi : Int, val avgLo : Int, val recHi : Int, val recHiYr : Int, val recLo : Int, val recLoYr : Int, val avgPrecip : Double)

fun main(){

    val weatherDB: MutableMap<String, Weather> = mutableMapOf()
    var firstLineArray = mutableListOf<String>()
    var arrayOfRecHi = mutableListOf<Int>()

    var lines = File(weatherDBFile).readLines()
//    println(lines)
    var firstLine = true

    for (line in lines) {
        if (firstLine) {
            var bits = line.split(",")
            firstLineArray += bits
            firstLine = false
        }
        else {
            var crumbs = line.split(",")
            var weatherRecord = Weather( crumbs[0].toInt(), crumbs[1].toInt(), crumbs[2], crumbs[3], crumbs[4].toInt(), crumbs[5].toInt(), crumbs[6].toInt(), crumbs[7].toInt(), crumbs[8].toInt(), crumbs[9].toInt(), crumbs[10].toInt(), crumbs[11].toDouble())
            weatherDB["${crumbs[0]} / ${crumbs[1]}"] = weatherRecord
            arrayOfRecHi += crumbs[7].toInt()
        }
    }
//\

//    println(arrayOfRecHi)
//    arrayOfRecHi.sort()
//    println(arrayOfRecHi.max())


// read database file and stores into hashmap
    var userChoice = 0
    while(userChoice != 8) {
        userChoice = menu()
        if (userChoice == 1) {

            //menu
            println(" ".repeat(61) + "${"All records in Spokane"}" + " ".repeat(61))
            println("")
            printHeader(firstLineArray)
            printAllRecords(weatherDB)
        }
        else if (userChoice == 2) {
            print("Please enter a month (1-12) to print: ")
            var userMonth = readLine()!!.toInt()
            println(" ".repeat(50) + "${"Records for a single month in Spokane"}" + " ".repeat(50))
            println("")
            printHeader(firstLineArray)
            printOneMonthRecord(weatherDB, userMonth)
        }
        else if (userChoice == 3) {

            println(" ".repeat(50) + "${"Highest recorded temperature in Spokane"}" + " ".repeat(50))
            println("")
            printHeader(firstLineArray)
            printHighestRecordTemp(weatherDB)
        }
    }



}

// function that contains menu options

fun menu() : Int {
    println("1. Print ALL Records")
    println("2. Print Only Records from a single month")
    println("3. Print Record with Highest Recorded Temperature")
    println("4. Print Record with Lowest Recorded Temperature")
    println("5. Print Record with Highest Recorded Temperature from a single month")
    println("6. Print Record with Lowest Recorded Temperature from a single month")
    println("7. Print Average of all precipitation from a single month")
    println()
    println("8. Quit \n")
    print("Please select an option: ")

return readLine()!!.toInt()

}

fun printAllRecords(weatherDB: MutableMap<String, Weather>) {

    for ((key, weatherRecord) in weatherDB) {
//        println("${key} : ${weatherRecord}")
        weatherRecord.month.toString()
        weatherRecord.day.toString()
        println(" ${weatherRecord.month}".padStart(12) + " ${weatherRecord.day}".padStart(12) + " ${weatherRecord.sunrise}".padStart(12) + " ${weatherRecord.sunset}".padStart(12) + " ${weatherRecord.mean}".padStart(12) + " ${weatherRecord.avgHi}".padStart(12) + " ${weatherRecord.avgLo}".padStart(12) + " ${weatherRecord.recHi}".padStart(12) + " ${weatherRecord.recHiYr}".padStart(12) + " ${weatherRecord.recLo}".padStart(12) + " ${weatherRecord.recLoYr}".padStart(12) + " ${weatherRecord.avgPrecip}".padStart(12) )
    }
}

fun printOneMonthRecord(weatherDB: MutableMap<String, Weather>, month: Int) {
    for ((key, weatherRecord) in weatherDB) {
        // this works, but it takes a look at the value instead of the key
        if ( weatherRecord.month == month) {
            println(" ${weatherRecord.month}".padStart(12) + " ${weatherRecord.day}".padStart(12) + " ${weatherRecord.sunrise}".padStart(12) + " ${weatherRecord.sunset}".padStart(12) + " ${weatherRecord.mean}".padStart(12) + " ${weatherRecord.avgHi}".padStart(12) + " ${weatherRecord.avgLo}".padStart(12) + " ${weatherRecord.recHi}".padStart(12) + " ${weatherRecord.recHiYr}".padStart(12) + " ${weatherRecord.recLo}".padStart(12) + " ${weatherRecord.recLoYr}".padStart(12) + " ${weatherRecord.avgPrecip}".padStart(12) )
        }
    }
}

fun printHighestRecordTemp(weatherDB: MutableMap<String, Weather>) {
    var listOfRecHi = mutableListOf<Int>()
    for((key, weatherRecord) in weatherDB) {
        listOfRecHi +=  weatherRecord.recHi.toInt()
    }

    var numMaxArray = listOfRecHi.max()
    for ((key, weatherRecord) in weatherDB) {
    if (weatherRecord.recHi == numMaxArray) {
        println(" ${weatherRecord.month}".padStart(12) + " ${weatherRecord.day}".padStart(12) + " ${weatherRecord.sunrise}".padStart(12) + " ${weatherRecord.sunset}".padStart(12) + " ${weatherRecord.mean}".padStart(12) + " ${weatherRecord.avgHi}".padStart(12) + " ${weatherRecord.avgLo}".padStart(12) + " ${weatherRecord.recHi}".padStart(12) + " ${weatherRecord.recHiYr}".padStart(12) + " ${weatherRecord.recLo}".padStart(12) + " ${weatherRecord.recLoYr}".padStart(12) + " ${weatherRecord.avgPrecip}".padStart(12) )
    }
    }
}


fun printHeader(firstLineArray: MutableList<String>) {
    return println("${firstLineArray[0]}".padStart(12) + " ${firstLineArray[1]}".padStart(12) + " ${firstLineArray[2]}".padStart(12) + " ${firstLineArray[3]}".padStart(12) + " ${firstLineArray[4]}".padStart(12) + " ${firstLineArray[5]}".padStart(12) + " ${firstLineArray[6]}".padStart(12) + " ${firstLineArray[7]}".padStart(12) + " ${firstLineArray[8]}".padStart(12) + " ${firstLineArray[9]}".padStart(12) + " ${firstLineArray[10]}".padStart(12) + " ${firstLineArray[11]}".padStart(12) +
            "\n" +"${" " + "-".repeat(11)}".repeat(12)
    )
}

// function that grabs a key for a specific month

//fun getKey() {
//
//}


// function that reads data from key

//fun readData() {
//
//}
