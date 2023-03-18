package connectfour_cvc

/************************************************************
 *  Name:         Alex Cruz
 *  Date:         3/18/23
 *  Assignment:   Connect Four Computer VS Computer
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/

val gameBoardcvc = Array(8){ Array(8){"."}}
fun main() {
    var computerAWin = false
    var computerZWin = false
    println("Computer(X) is playing against Computer(O)")

    do {
        var cpuAChoice = generateRandom()
        var cpuAPiece = computerAPiece(cpuAChoice)
        var validPlay = false

        while (!validPlay) {
            if (cpuAPiece >= 0) {
                computerAWin = checkHorizontalWin(cpuAPiece, "X")
                if (!computerAWin) {
                    computerAWin = checkVerticalWin(cpuAChoice, "X")
                }
                if (!computerAWin) {
                    computerAWin = checkDiagonalWin("X")
                }
                println("Computer(X) selected column: ${cpuAChoice + 1}")
                gameBoardcvcPrint()
                validPlay = true
            } else {
                cpuAChoice = generateRandom()
                cpuAPiece = computerAPiece(cpuAChoice)
            }
        }

        validPlay = false

        if(!computerAWin) {
            var cpuZChoice = generateRandom()
            var cpuZPiece = computerZPiece(cpuZChoice)
            while (!validPlay){
                if (cpuZPiece >= 0){
                    computerZWin = checkHorizontalWin(cpuZPiece, "O")
                    if (!computerZWin){
                        computerZWin = checkVerticalWin(cpuZChoice, "O")
                    }
                    if (!computerZWin){
                        computerZWin = checkDiagonalWin("O")
                    }
                    println("Computer(O) selected column: ${cpuZChoice + 1}")
                    gameBoardcvcPrint()
                    validPlay = true
                }
                else {
                    cpuZChoice = generateRandom()
                    cpuZPiece = computerZPiece(cpuZChoice)
                }
            }
        }

    } while (!computerAWin && !computerZWin)

    if(computerAWin) {
        println("Player(X) is the winner!")
    }
    else if (computerZWin){
        println("Computer(O) is the winner!")
    }
}

fun gameBoardcvcPrint() {
    println("\n1 2 3 4 5 6 7 8")
    println("-".repeat(15))
    for(row in 0 until gameBoardcvc.size) {
        for (col in 0 until gameBoardcvc[row].size) {
            print(gameBoardcvc[row][col])
            print(" ")
        }
        println()
    }
    println()
}

fun computerAPiece(col:Int) : Int {
    val currentCol = col
    var rowSelected = 0

    if (currentCol <= 7 ) {
        if (gameBoardcvc[7][currentCol] != "X" && gameBoardcvc[7][currentCol] != "O") {
            gameBoardcvc[7][currentCol] = "X"
            rowSelected = 7
        } else if (gameBoardcvc[6][currentCol] != "X" && gameBoardcvc[6][currentCol] != "O") {
            gameBoardcvc[6][currentCol] = "X"
            rowSelected = 6
        } else if (gameBoardcvc[5][currentCol] != "X" && gameBoardcvc[5][currentCol] != "O") {
            gameBoardcvc[5][currentCol] = "X"
            rowSelected = 5
        } else if (gameBoardcvc[4][currentCol] != "X" && gameBoardcvc[4][currentCol] != "O") {
            gameBoardcvc[4][currentCol] = "X"
            rowSelected = 4
        } else if (gameBoardcvc[3][currentCol] != "X" && gameBoardcvc[3][currentCol] != "O") {
            gameBoardcvc[3][currentCol] = "X"
            rowSelected = 3
        } else if (gameBoardcvc[2][currentCol] != "X" && gameBoardcvc[2][currentCol] != "O") {
            gameBoardcvc[2][currentCol] = "X"
            rowSelected = 2
        } else if (gameBoardcvc[1][currentCol] != "X" && gameBoardcvc[1][currentCol] != "O") {
            gameBoardcvc[1][currentCol] = "X"
            rowSelected = 1
        } else if (gameBoardcvc[0][currentCol] != "X" && gameBoardcvc[0][currentCol] != "O") {
            gameBoardcvc[0][currentCol] = "X"
            rowSelected = 0
        }
        else {
            println("Computer(A) piece is out of bounds.")
            rowSelected = -1
        }
    }
    return rowSelected
}

fun checkHorizontalWin(row:Int, char:String) : Boolean {
    var winCheck = false
    var charCounter = 0
    var col = 0

    while (col < gameBoardcvc.size) {
        if (row <= 7 && col <= 7 && gameBoardcvc[row][col] == char) {
            charCounter++
        }
        else {
            charCounter = 0
        }
        col++
        if (charCounter >= 4) {
            winCheck = true
        }
    }
    return winCheck
}

fun checkVerticalWin(col:Int, char: String) : Boolean {

    var winCheck = false
    var charCounter = 0
    var row = 0

    while (row < gameBoardcvc.size) {
        if (row <= 7 && col <= 7 && gameBoardcvc[row][col] == char) {
            charCounter++
        }
        else {
            charCounter = 0
        }
        row++
        if(charCounter >= 4) {
            winCheck = true
        }
    }
    return winCheck
}

fun computerZPiece(col:Int) : Int {
    var rowSelected = 0

    if (col <= 7) {
        if (gameBoardcvc[7][col] != "O" && gameBoardcvc[7][col] != "X") {
            gameBoardcvc[7][col] = "O"
            rowSelected = 7
        } else if (gameBoardcvc[6][col] != "O" && gameBoardcvc[6][col] != "X") {
            gameBoardcvc[6][col] = "O"
            rowSelected = 6
        } else if (gameBoardcvc[5][col] != "O" && gameBoardcvc[5][col] != "X") {
            gameBoardcvc[5][col] = "O"
            rowSelected = 5
        } else if (gameBoardcvc[4][col] != "O" && gameBoardcvc[4][col] != "X") {
            gameBoardcvc[4][col] = "O"
            rowSelected = 4
        } else if (gameBoardcvc[3][col] != "O" && gameBoardcvc[3][col] != "X") {
            gameBoardcvc[3][col] = "O"
            rowSelected = 3
        } else if (gameBoardcvc[2][col] != "O" && gameBoardcvc[2][col] != "X") {
            gameBoardcvc[2][col] = "O"
            rowSelected = 2
        } else if (gameBoardcvc[1][col] != "O" && gameBoardcvc[1][col] != "X") {
            gameBoardcvc[1][col] = "O"
            rowSelected = 1
        } else if (gameBoardcvc[0][col] != "O" && gameBoardcvc[0][col] != "X") {
            gameBoardcvc[0][col] = "O"
            rowSelected = 0
        }
        else {
            println("Computer(Z) piece is out of bounds.")
            println("Computer is selecting a different choice.")
            rowSelected = -1
        }
    }
    return rowSelected
}

fun checkDiagonalWin(char:String) : Boolean {

    var winCheck = false
    var charCounter = 0
    var col = 0
    var rowIndexNe = 3

    // Diagonal checks going North East

    for (outerRow in 7 downTo 3) {
        for (row in rowIndexNe downTo 0) {
            if (row <= 7 && col <= 7 && gameBoardcvc[row][col] == char) {
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
        if (rowIndexNe < 7){
            rowIndexNe++
        }
    }

    for( colStart in 1..4) {
        var currentCol = colStart
        for( row in 7 downTo colStart){
            if (gameBoardcvc[row][currentCol] == char) {
                charCounter++
            } else {
                charCounter = 0
            }
            currentCol++
            if (charCounter >= 4) {
                winCheck = true
            }
        }
    }

    /// Diagonal checks going North West

    var rowIndexNW = 7
    var rowEnd = 1
    var colNe = 7

    for (outerRow in 7 downTo 3) {
        for (row in rowIndexNW downTo 0) {
            if (row <= 7 && gameBoardcvc[row][colNe] == char) {
                charCounter++
            } else {
                charCounter = 0
            }
            colNe--
            if (charCounter >= 4){
                winCheck = true
            }
        }
        colNe = 7
        if (rowIndexNW > 0) {
            rowIndexNW--
        }
    }

    for( colStart in 6 downTo 3) {
        var currentCol = colStart
        for( row  in  7 downTo rowEnd){
            if (gameBoardcvc[row][currentCol] == char) {
                charCounter++
            } else {
                charCounter = 0
            }
            currentCol--
            if (charCounter >= 4){
                winCheck = true
            }
        }
        rowEnd++
    }

    return winCheck
}

fun generateRandom() : Int{
    return (0..7).random()
}

