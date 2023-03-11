/************************************************************
 *  Name:         Alex Cruz
 *  Date:         3/8/23
 *  Assignment:
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/
val gameBoard = Array(8){ Array(8){"."}}
fun main() {
    var playerWin = false

    println("Player (X) is playing against the computer (O).")
    do {
        var userChoice = playerPrompt()
        playerPiece(userChoice)
        gameBoardPrint()
        playerWin = checkHorizontalWin("X")

    } while (!playerWin )


}

fun menu() : Int {
    println("1. Player vs. Player")
//    println("2. Player vs. Computer")
//    println("3. Computer vs. Computer")
    println("2. Quit")
    print("Please enter a selection: ")

    return readln()!!.toInt()
}

fun playerPrompt() : Int {
    print("Select a column to place your piece (X): ")
    return readln()!!.toInt()
}

fun gameBoardPrint() {
    println("\n1 2 3 4 5 6 7 8")
    println("-".repeat(16))
    for(row in 0 until gameBoard.size) {
        for (col in 0 until gameBoard[row].size) {
            print(gameBoard[row][col])
            print(" ")
        }
        println()
    }
    println()
}

fun playerPiece(col:Int) {
    val currentCol = col - 1

    if (currentCol <= 7) {
        if (gameBoard[7][currentCol] != "X" && gameBoard[7][currentCol] != "O") {
            gameBoard[7][currentCol] = "X"
        } else if (gameBoard[6][currentCol] != "X" && gameBoard[6][currentCol] != "O") {
            gameBoard[6][currentCol] = "X"
        } else if (gameBoard[5][currentCol] != "X" && gameBoard[5][currentCol] != "O") {
            gameBoard[5][currentCol] = "X"
        } else if (gameBoard[4][currentCol] != "X" && gameBoard[4][currentCol] != "O") {
            gameBoard[4][currentCol] = "X"
        } else if (gameBoard[3][currentCol] != "X" && gameBoard[3][currentCol] != "O") {
            gameBoard[3][currentCol] = "X"
        } else if (gameBoard[2][currentCol] != "X" && gameBoard[2][currentCol] != "O") {
            gameBoard[2][currentCol] = "X"
        } else if (gameBoard[1][currentCol] != "X" && gameBoard[1][currentCol] != "O") {
            gameBoard[1][currentCol] = "X"
        } else if (gameBoard[0][currentCol] != "X" && gameBoard[0][currentCol] != "O") {
            gameBoard[0][currentCol] = "X"
        }
        else {
            println("Piece is out of bounds.")
        }
    }
    else {
            println("Piece is out of bounds.")
        }
    }


fun checkHorizontalWin(char:String) : Boolean {
    var winCheck = false
    var charCounter = 0
    var col = 0

    while (col < gameBoard.size) {
        if (gameBoard[7][col] == char) {
            charCounter++
        }
        else if (gameBoard[6][col] == char) {
            charCounter++
        }
        else if (gameBoard[5][col] == char) {
            charCounter++
        }
        else if (gameBoard[4][col] == char) {
            charCounter++
        }
        else if (gameBoard[3][col] == char) {
            charCounter++
        }
        else if (gameBoard[2][col] == char) {
            charCounter++
        }
        else if (gameBoard[1][col] == char) {
            charCounter++
        }
        else if (gameBoard[0][col] == char) {
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


fun computerPiece(col:Int) {
    if (col <= 8) {
        if (gameBoard[7][col] == "." && gameBoard[7][col] != "X") {
            gameBoard[7][col] = "O"
        } else if (gameBoard[6][col] == "." && gameBoard[6][col] != "X") {
            gameBoard[6][col] = "O"
        } else if (gameBoard[5][col] == "." && gameBoard[5][col] != "X") {
            gameBoard[5][col] = "O"
        } else if (gameBoard[4][col] == "." && gameBoard[4][col] != "X") {
            gameBoard[4][col] = "O"
        } else if (gameBoard[3][col] == "." && gameBoard[3][col] != "X") {
            gameBoard[3][col] = "O"
        } else if (gameBoard[2][col] == "." && gameBoard[2][col] != "X") {
            gameBoard[2][col] = "O"
        } else if (gameBoard[1][col] == "." && gameBoard[1][col] != "X") {
            gameBoard[1][col] = "O"
        } else if (gameBoard[0][col] == "." && gameBoard[0][col] != "X") {
            gameBoard[0][col] = "O"
        }
    }
    else {
        return println("Choice is out of bounds")
    }
}

//fun checkHorizontalWin(row: Int, char: String) : Boolean {
//    var colCounter = 0
//    var charCounter = 0
//    var col = 0
//
//
//}


/*
      ****      Initial testing     *****
1 2 3 4 5 6 7 8
. . . . . . . .
. . . . . . . .
. . . . . . . .
. . . . . . . .
. . . . . . . .
. . . . . . . .
0 . . . . . . .
X . . . . . . .


// need to fix player piece placement now that a space is added ** Done

 */