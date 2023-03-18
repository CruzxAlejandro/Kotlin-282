package connectfour_pvp

/************************************************************
 *  Name:         Alex Cruz
 *  Date:         3/14/23
 *  Assignment:   Connect Four Player VS Player
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/

val gameBoard = Array(8){ Array(8){"."}}
fun main() {
    var playerXWin = false
    var playerYWin = false
    println("Player (X) is playing against Player (Y)")

    do {
        var userChoice = playerPromptNew("Select a column to place your piece (X): ", 1..8)
        var playerXPiece = playerPieceX(userChoice)
        var validPlay = false

        while (!validPlay) {
            if (playerXPiece >= 0) {
                playerXWin = checkHorizontalWin(playerXPiece, "X")
                if (!playerXWin) {
                    playerXWin = checkVerticalWin(userChoice, "X")
                }
                if (!playerXWin) {
                    playerXWin = checkDiagonalWin("X")
                }
                gameBoardPrint()
                validPlay = true
            } else {
                userChoice = playerPromptNew("Select a column to place your piece (X): ", 1..8)
                playerXPiece = playerPieceX(userChoice)
            }
        }

        validPlay = false

        if(!playerXWin) {
            var playerYChoice = playerPromptNew("Select a column to place your piece (Y): ", 1..8)
            var playerYPiece = playerPieceY(playerYChoice)
            while (!validPlay) {
                if (playerYPiece >= 0) {
                    playerYWin = checkHorizontalWin(playerYPiece, "Y")
                    if (!playerYWin) {
                        playerYWin = checkVerticalWin(userChoice, "Y")
                    }
                    if (!playerYWin) {
                        playerYWin = checkDiagonalWin("Y")
                    }
                    gameBoardPrint()
                    validPlay = true
                } else {
                    userChoice = playerPromptNew("Select a column to place your piece (Y): ", 1..8)
                    playerYPiece = playerPieceY(userChoice)
                }
            }
        }

    } while (!playerXWin && !playerYWin)

    if(playerXWin) {
        println("Player(X) is the winner!")
    }
    else if (playerYWin){
        println("Player(Y) is the winner!")
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

fun playerPieceX(col:Int) : Int {
    val currentCol = col
    var rowSelected = 0

    if (currentCol <= 7 ) {
        if (gameBoard[7][currentCol] != "X" && gameBoard[7][currentCol] != "Y") {
            gameBoard[7][currentCol] = "X"
            rowSelected = 7
        } else if (gameBoard[6][currentCol] != "X" && gameBoard[6][currentCol] != "Y") {
            gameBoard[6][currentCol] = "X"
            rowSelected = 6
        } else if (gameBoard[5][currentCol] != "X" && gameBoard[5][currentCol] != "Y") {
            gameBoard[5][currentCol] = "X"
            rowSelected = 5
        } else if (gameBoard[4][currentCol] != "X" && gameBoard[4][currentCol] != "Y") {
            gameBoard[4][currentCol] = "X"
            rowSelected = 4
        } else if (gameBoard[3][currentCol] != "X" && gameBoard[3][currentCol] != "Y") {
            gameBoard[3][currentCol] = "X"
            rowSelected = 3
        } else if (gameBoard[2][currentCol] != "X" && gameBoard[2][currentCol] != "Y") {
            gameBoard[2][currentCol] = "X"
            rowSelected = 2
        } else if (gameBoard[1][currentCol] != "X" && gameBoard[1][currentCol] != "Y") {
            gameBoard[1][currentCol] = "X"
            rowSelected = 1
        } else if (gameBoard[0][currentCol] != "X" && gameBoard[0][currentCol] != "Y") {
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

fun playerPieceY(col:Int) : Int {
    var rowSelected = 0
    if (col <= 8) {
        if (gameBoard[7][col] != "Y" && gameBoard[7][col] != "X") {
            gameBoard[7][col] = "Y"
            rowSelected = 7
        } else if (gameBoard[6][col] != "Y" && gameBoard[6][col] != "X") {
            gameBoard[6][col] = "Y"
            rowSelected = 6
        } else if (gameBoard[5][col] != "Y" && gameBoard[5][col] != "X") {
            gameBoard[5][col] = "Y"
            rowSelected = 5
        } else if (gameBoard[4][col] != "Y" && gameBoard[4][col] != "X") {
            gameBoard[4][col] = "Y"
            rowSelected = 4
        } else if (gameBoard[3][col] != "Y" && gameBoard[3][col] != "X") {
            gameBoard[3][col] = "Y"
            rowSelected = 3
        } else if (gameBoard[2][col] != "Y" && gameBoard[2][col] != "X") {
            gameBoard[2][col] = "Y"
            rowSelected = 2
        } else if (gameBoard[1][col] != "Y" && gameBoard[1][col] != "X") {
            gameBoard[1][col] = "Y"
            rowSelected = 1
        } else if (gameBoard[0][col] != "Y" && gameBoard[0][col] != "X") {
            gameBoard[0][col] = "Y"
            rowSelected = 0
        }
        else {
            println("Player(Y) piece is out of bounds.")
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
