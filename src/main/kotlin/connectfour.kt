package connectfour

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
    var computerWin = false
    println("Player (X) is playing against the computer (O)")
    do {
        var userChoice = playerPromptNew("Select a column to place your piece (X): ", 1..8)
        var playerPiece = playerPiece(userChoice)
        playerWin = checkHorizontalWin(playerPiece,"X")
        if (!playerWin) {
            playerWin = checkVerticalWin(userChoice, "X")
        }
        if (!playerWin) {
            playerWin = checkDiagonalWin("X")
        }
        gameBoardPrint()
        if(!playerWin) {
        var computerChoice = computerRandom()
        var computerPiece = computerPiece(computerChoice)
        computerWin = checkHorizontalWin(computerPiece, "O")
        if (!computerWin) {
            computerWin = checkVerticalWin(computerChoice, "O")
        }
        if (!computerWin) {
            computerWin = checkDiagonalWin("O")
        }
        gameBoardPrint()
        }

    } while (!playerWin && !computerWin)

    if(playerWin) {
        println("Player(X) is the winner!")
    }
    else if (computerWin){
        println("Computer(O) is the winner!")
    }


}

fun menu() : Int {
    println("1. Player vs. Player")
//    println("2. Player vs. Computer")
//    println("3. Computer vs. Computer")
    println("2. Quit")
    print("Please enter a selection: ")

    return readln()!!.toInt()
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
//    val currentCol = col - 1
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
            println("Piece is out of bounds.")
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
    if (col <= 8) {
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
            println("(O) Piece is out of bounds.")
        }
    }
    return rowSelected
}

fun checkDiagonalWin(char:String) : Boolean{
    var winCheck = false
    var charCounter = 0
    var outerRow = 3
    var innerCol = 0

    for(i in outerRow downTo 0) {
        for (j in innerCol until 7) {
            if (innerCol <= 7 && gameBoard[i][innerCol] == char) {
                charCounter++
            } else {
                charCounter = 0
            }
            innerCol++
            if (charCounter >= 4){
                winCheck = true
            }
        }
    }
    return winCheck
}


fun computerRandom() : Int{
    return (0..7).random()
}

