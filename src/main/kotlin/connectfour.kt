package connectfour

/************************************************************
 *  Name:         Alex Cruz
 *  Date:         3/8/23
 *  Assignment:   Connect Four Player VS Computer
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/
val gameBoard = Array(8){ Array(8){"."}}
fun main() {
    var playerWin = false
    var computerWin = false
    println("Player (X) is playing against the computer (O)")

    do {
        var userChoice = playerPromptNew("Select a column to place your piece (X): ", 1..8)
        var playerPiece = playerPiece(userChoice)
        var validPlay = false

        while (!validPlay) {
            if (playerPiece >= 0) {
                playerWin = checkHorizontalWin(playerPiece, "X")
                if (!playerWin) {
                    playerWin = checkVerticalWin(userChoice, "X")
                }
                if (!playerWin) {
                    playerWin = checkDiagonalWin("X")
                }
                gameBoardPrint()
                validPlay = true
            } else {
                userChoice = playerPromptNew("Select a column to place your piece (X): ", 1..8)
                playerPiece = playerPiece(userChoice)
            }
        }

        validPlay = false

        if(!playerWin) {
            var computerChoice = computerRandom()
            var computerPiece = computerPiece(computerChoice)
            while (!validPlay){
                if (computerPiece >= 0){
                    computerWin = checkHorizontalWin(computerPiece, "O")
                    if (!computerWin){
                        computerWin = checkVerticalWin(computerChoice, "O")
                    }
                    if (!computerWin){
                        computerWin = checkDiagonalWin("O")
                    }
                    println("Computer(O) selected column: ${computerChoice + 1}")
                    gameBoardPrint()
                    validPlay = true
                }
                else {
                    computerChoice = computerRandom()
                    computerPiece = computerPiece(computerChoice)
                }
            }
        }

    } while (!playerWin && !computerWin)

    if(playerWin) {
        println("Player(X) is the winner!")
    }
    else if (computerWin){
        println("Computer(O) is the winner!")
    }
}

fun playerPromptNew(prompt:String, intRange : IntRange = 1..8) : Int {
    var input : String? = ""
    var firsTime = true
    do {
        if (!firsTime){
            println("Invalid Number - must be a whole number between 1 and 8")
        }
        firsTime = false
        print(prompt)
        input = readLine()
    } while (input.isNullOrEmpty() || input.toInt() !in intRange)
    return input.toInt() - 1
}

fun gameBoardPrint() {
    println("\n1 2 3 4 5 6 7 8")
    println("-".repeat(15))
    for(row in 0 until gameBoard.size) {
        for (col in 0 until gameBoard[row].size) {
            print(gameBoard[row][col])
            print(" ")
        }
        println()
    }
    println()
}

fun playerPiece(col:Int) : Int {
    val currentCol = col
    var rowSelected = 0

    if (currentCol <= 7 ) {
        if (gameBoard[7][currentCol] != "X" && gameBoard[7][currentCol] != "O") {
            gameBoard[7][currentCol] = "X"
            rowSelected = 7
        } else if (gameBoard[6][currentCol] != "X" && gameBoard[6][currentCol] != "O") {
            gameBoard[6][currentCol] = "X"
            rowSelected = 6
        } else if (gameBoard[5][currentCol] != "X" && gameBoard[5][currentCol] != "O") {
            gameBoard[5][currentCol] = "X"
            rowSelected = 5
        } else if (gameBoard[4][currentCol] != "X" && gameBoard[4][currentCol] != "O") {
            gameBoard[4][currentCol] = "X"
            rowSelected = 4
        } else if (gameBoard[3][currentCol] != "X" && gameBoard[3][currentCol] != "O") {
            gameBoard[3][currentCol] = "X"
            rowSelected = 3
        } else if (gameBoard[2][currentCol] != "X" && gameBoard[2][currentCol] != "O") {
            gameBoard[2][currentCol] = "X"
            rowSelected = 2
        } else if (gameBoard[1][currentCol] != "X" && gameBoard[1][currentCol] != "O") {
            gameBoard[1][currentCol] = "X"
            rowSelected = 1
        } else if (gameBoard[0][currentCol] != "X" && gameBoard[0][currentCol] != "O") {
            gameBoard[0][currentCol] = "X"
            rowSelected = 0
        }
        else {
            println("Player(X) piece is out of bounds.")
            rowSelected = -1
        }
    }
    return rowSelected
    }

fun checkHorizontalWin(row:Int, char:String) : Boolean {
    var winCheck = false
    var charCounter = 0
    var col = 0

    while (col < gameBoard.size) {
        if (row <= 7 && col <= 7 && gameBoard[row][col] == char) {
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

    while (row < gameBoard.size) {
        if (row <= 7 && col <= 7 && gameBoard[row][col] == char) {
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

fun computerPiece(col:Int) : Int {
    var rowSelected = 0

    if (col <= 7) {
        if (gameBoard[7][col] != "O" && gameBoard[7][col] != "X") {
            gameBoard[7][col] = "O"
            rowSelected = 7
        } else if (gameBoard[6][col] != "O" && gameBoard[6][col] != "X") {
            gameBoard[6][col] = "O"
            rowSelected = 6
        } else if (gameBoard[5][col] != "O" && gameBoard[5][col] != "X") {
            gameBoard[5][col] = "O"
            rowSelected = 5
        } else if (gameBoard[4][col] != "O" && gameBoard[4][col] != "X") {
            gameBoard[4][col] = "O"
            rowSelected = 4
        } else if (gameBoard[3][col] != "O" && gameBoard[3][col] != "X") {
            gameBoard[3][col] = "O"
            rowSelected = 3
        } else if (gameBoard[2][col] != "O" && gameBoard[2][col] != "X") {
            gameBoard[2][col] = "O"
            rowSelected = 2
        } else if (gameBoard[1][col] != "O" && gameBoard[1][col] != "X") {
            gameBoard[1][col] = "O"
            rowSelected = 1
        } else if (gameBoard[0][col] != "O" && gameBoard[0][col] != "X") {
            gameBoard[0][col] = "O"
            rowSelected = 0
        }
        else {
            println("Computer(O) piece is out of bounds.")
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
            if (row <= 7 && col <= 7 && gameBoard[row][col] == char) {
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
            if (gameBoard[row][currentCol] == char) {
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
            if (row <= 7 && gameBoard[row][colNe] == char) {
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
            if (gameBoard[row][currentCol] == char) {
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

fun computerRandom() : Int{
    return (0..7).random()
}

