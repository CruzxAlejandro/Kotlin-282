/************************************************************
 *  Name:         Alex Cruz
 *  Date:         1/29/23
 *  Assignment:   Pig Dice Assignment
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/



fun main() {

    var playerRoundScore = 0
    var playerTotalRoundScore = 0
    var playerGrandTotalScore = 0
    var computerRoundScore = 0
    var computerTotalRoundScore = 0
    var computerGrandTotalScore = 0
    var playerWin = false
    var computerWin = false



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
                        println("Player round total score ${playerTotalRoundScore}")

                    } else {
                        playerRoundScore = 0
                        playerTotalRoundScore = 0
                        println("Player loses all round points and turn.")
                        println()
                        println("Computer's Turn")
                        var computerRoll = dice()
                        var computerLoss = false

                        do {
                           println("Computer decides to roll: ${computerRoll}")
                            if (computerRoll == 1) {
                                computerRoundScore = 0
                                computerTotalRoundScore = 0
                                println("Computer loses all round points and turn.")
                                println("Computer Grand Total: ${computerGrandTotalScore}")
                                computerLoss = true

                            }
                           else {
                               computerRoundScore = computerRoll;
                               computerTotalRoundScore = computerTotalRoundScore + computerRoundScore;
                               println("Computer Turn Total: ${computerTotalRoundScore}")
                                if(computerGrandTotalScore >= 50) {
                                    computerWin = true
                                }
                           }


                        } while (decideToRoll() != false && computerLoss != false)

                        if (computerLoss != true){
                            println("Computer decides to pass.")
                            computerGrandTotalScore = computerGrandTotalScore + computerTotalRoundScore
                            computerTotalRoundScore = 0
                            println("Computer Grand Total: ${computerGrandTotalScore}")
                        }

                    }

                }
                else if (playerChoice == 2) {
                    playerGrandTotalScore = playerGrandTotalScore + playerTotalRoundScore;
                    playerTotalRoundScore = 0
                    println("Player grand total is now ${playerGrandTotalScore}")
                    println()
                    println("Computer's Turn to Roll")
                    println("Computer's Turn")
                    var computerRoll = dice()
                    var computerLoss = false

                    do {
                        println("Computer decides to roll: ${computerRoll}")
                        if (computerRoll == 1) {
                            computerRoundScore = 0
                            computerTotalRoundScore = 0
                            println("Computer loses all round points and turn.")
                            println("Computer Grand Total: ${computerGrandTotalScore}")
                            computerLoss = true
                        }
                        else {
                            computerRoundScore = computerRoll;
                            computerTotalRoundScore = computerTotalRoundScore + computerRoundScore;
                            println("Computer Turn Total: ${computerTotalRoundScore}")
                            if(computerGrandTotalScore >= 50) {
                                computerWin = true
                            }

                        }


                    } while (decideToRoll() != false && computerLoss != false)

                    if (computerLoss != true){
                        println("Computer decides to pass.")
                        computerGrandTotalScore = computerGrandTotalScore + computerTotalRoundScore
                        computerTotalRoundScore = 0
                        println("Computer Grand Total: ${computerGrandTotalScore}")
                    }

                }

                else {
                    println("Enter a valid option")
                }
            }
        } while (playerChoice != 3)

    println()
    println("*".repeat(65))
    println(" ".repeat(25) + "* Grand Total *" + " ".repeat(25))
    println("Player:${playerGrandTotalScore}".padStart(30) + "  |  " + "Computer:${computerGrandTotalScore}".padEnd(30))
    println("*".repeat(65))

    if(computerGrandTotalScore >= 50) {
        println("Game over. Computer Wins!")
    }
    else if(playerGrandTotalScore >= 50) {
        println("Game over. Player Wins!")
    }
    else {
        println("Game has ended. No winner")
    }

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
