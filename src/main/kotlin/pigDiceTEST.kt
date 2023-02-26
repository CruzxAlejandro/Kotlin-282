/*
fun main() {

    // Menu options
    // 1 Roll Dice - Call roll function
    // 2 Hold and pass - Add points, pass to computer
    // 3 Quit - End program

    //    println("1. Roll Dice:")
    //    println("2. Hold and pass")
    //    println("3. Quit")
    //    println("")
    //    print("Please enter your selection: ")
    //    var playerChoice = readLine()!! .toInt()


    // While loop that checks answers
    // While the user answer is not 3, run the program
    // If 1 is selected, roll dice
    // else 2 is selected, pass to computer (may need to add a function to return to user)

    var playerRoundScore = 0
    var playerTotalRoundScore = 0
    var playerGrandTotalScore = 0
    var computerRoundScore = 0
    var computerTotalRoundScore = 0
    var computerGrandTotalScore = 0

    do {
        println()
        println("*".repeat(65))
        println(" ".repeat(25) + "* Grand Total *" + " ".repeat(25))
        println("Player:${playerGrandTotalScore}".padStart(30) + "  |  " + "Computer:${computerGrandTotalScore}".padEnd(30))
        println("*".repeat(65))
        println("1. Roll Dice:")
        println("2. Hold and pass")
        println("3. Quit")
        println()
        print("Please select a menu option: ")
        var playerChoice = readLine()!!.toInt()

        if (playerChoice != 3) {

            if (playerChoice == 1) {
                println("Rolling dice")
                var roll = dice()
                println("Player rolled a ${roll}")
                playerRoundScore = roll

                if (roll != 1) {
                    println("Player round score ${playerRoundScore}")
                    playerTotalRoundScore = playerTotalRoundScore + playerRoundScore
                    println("Player total score ${playerTotalRoundScore}")

                } else {
                    playerRoundScore = 0
                    playerTotalRoundScore = 0
                    println("Player loses all round points and turn.")
                    println()

                    var computerChoice = decideToRoll()

                    if (computerChoice == true) {
                        var computerRoll = dice()
                        println("Computer decides to roll: ${computerRoll}")
                        computerRoundScore = computerRoll;
                        println("Computer round score ${computerRoundScore}")
                        if(computerRoll != 1) {
                            computerTotalRoundScore = computerTotalRoundScore + computerRoundScore
                            println("Computer total score ${computerTotalRoundScore}")

                            /* The computer earns points here, but I don't know how to get the computer to decide to play again */
                            computerChoice = decideToRoll()

                        } else {
                            computerRoundScore = 0
                            computerTotalRoundScore = 0
                            println("Computer loses all round points and turn.")
                        }
                    }
                    else {
                        println("Computer decides to pass.")
                        computerGrandTotalScore = computerGrandTotalScore + computerTotalRoundScore
                        computerRoundScore = 0
                        println("Computer grand total is now ${computerGrandTotalScore}")
                    }
                }
            }

            else if (playerChoice == 2) {
                playerGrandTotalScore = playerGrandTotalScore + playerTotalRoundScore;
                playerTotalRoundScore = 0
                println("Player grand total is now ${playerGrandTotalScore}")
                println()
                println("Computer's Turn to Roll")

                ///// ***  Turned off for now ***
                /*
                var computerChoice = decideToRoll()
                if (computerChoice) {
                    var computerRoll = dice()
                    println("Computer decides to roll: ${computerRoll}")
                    computerRoundScore = computerRoll;
                    println("Computer round score ${computerRoundScore}")
                    if(computerRoll != 1) {
                        computerTotalRoundScore = computerTotalRoundScore + computerRoundScore
                        println("Computer total score ${computerTotalRoundScore}")
                    } else {
                        computerRoundScore = 0
                        computerTotalRoundScore = 0
                        println("Computer loses all round points and turn.")
                    }

                } else {
                    println("Computer decides to pass.")
                    computerGrandTotalScore = computerGrandTotalScore + computerTotalRoundScore
                    computerRoundScore = 0
                    println("Computer grand total is now ${computerGrandTotalScore}")
                }    */
//                    cut out code lived here


            } else if (playerChoice == 3) {
                playerGrandTotalScore = playerGrandTotalScore + playerTotalRoundScore;
                println("Enter a valid option")
            }
        }


    } while (playerChoice != 3)


}



fun decideToRoll() : Boolean {
    var roll = (1..2).random()

    if (roll == 1) {
        return false
    }  else { return true }

}


fun dice() : Int {
    return (1..6).random()
}


 */
