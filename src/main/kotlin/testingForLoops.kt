import connectfourplayervplayer.gameBoard

/************************************************************
 *  Name:         Alex Cruz
 *  Date:         3/16/23
 *  Assignment:
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/

val gameBoard = Array(8){ Array(8){"."}}
fun main() {
    var winCheck = false
    var charCounter = 0
    var col = 0
    var rowIndex = 7
    var char = "x"


    var rowIndexNe = 3

    for (outerRow in 7 downTo 3) {
        for (row in rowIndexNe downTo 0) {
            println("$row,$col")
            col++
        }
        println()
        col = 0
        if (rowIndexNe < 7){
            rowIndexNe++
        }
    }

    println(rowIndexNe)
}


//    for (outerRow in 7 downTo 3) {
//        for (row in rowIndex downTo 0) {
//            println("$row,$col")
//            col--
//        }
//        println()
//        col = 7
//        rowIndex--
//    }

//    var rowEnd = 1
//
//    for( colStart in 6 downTo 3) {
//        var currentCol = colStart
//        for( row  in  7 downTo rowEnd){
//            println("$row,$currentCol")
//            currentCol--
//        }
//        rowEnd++
//        println()
//    }



/*
bug fixing

(Row index Ne came back as 8 )
var rowIndexNe = 3

for (outerRow in 7 downTo 3) {
    for (row in rowIndexNe downTo 0) {
        if (row <= 7 && outerRow <= 3 && gameBoard[row][col] == char) {
            charCounter++
        } else {
            charCounter = 0
        }
        col++
        if (charCounter >= 4) {
            winCheck = true
        }
    }
    col = 0
    rowIndexNe++
}


 */