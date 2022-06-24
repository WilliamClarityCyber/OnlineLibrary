/**
 * An online library that allows users to rent 15 total movies, music, and books
 *
 * @author  William Lin
 * @date 6/24/2022
 */

import java.util.Scanner
var option : Int = 0
val onlineLibrary : Library = Library()
val scan = Scanner(System.`in`)

/**
 * The main method calls the welcome message until the user wants to the quit
 */
fun main(args: Array<String>) {
    var quit = false
    do {
        when(welcome())
        {
             1, 2, 3-> {
                renting(option)
            }
            4 -> viewRented()
            5 -> quit = true

        }
    } while(!quit)
}


/**
 * Welcome message that takes in user input on if they would like to rent, view items, or quit the program.
 * Includes a do while loop that makes sure the user inputs a valid option
 */
fun welcome() : Int{
    var input : Int
    do {
        println("Welcome! What would you like to do? \n[1]Rent Movies\n[2]Rent Music\n[3]Rent Books\n[4]View " +
                "Rented Items\n[5]Quit")
        input = scan.nextInt()
    } while(input !in listOf(1, 2, 3, 4, 5))
    option = input
   return input
}

/**
 * Creates a list which contains all the available items of the specific type the user has chosen
 * Uses a for loop to display all the available items
 * Asks user to chose the item that they want to rent by asking for an ID number
 * Do While loop makes user the input is valid
 * If the input is valid, the confirmation method is also called
 *
 */
fun renting(type : Int){
    val rentableItems : List<RentableItems> = onlineLibrary.filteredByTypeForRenting(type)
    for (i in rentableItems)
    println(i.display() + "\n")

    var validChoice : Boolean = false
    var input : Int
    do {
        println("Enter the ID of the item you would like to rent.")
        input = scan.nextInt()
        for (m in rentableItems)
        {
            if(m.getUniqueIDNumber() == input)
                validChoice = true
        }
    } while(!validChoice)

    if(validChoice)
    {
        confirmation(input)
    }
}

/**
 * Called after a user has entered a valid choice asks them one last time if they wanted to rent the item that is
 * displayed
 * Calls a method that is inside the library class to change the status of the chosen item by entering its unique ID
 * Prompts the user when the item is successfully rented
 */
fun confirmation(ID : Int){
    var input : String
    do {
        println("Please confirm that you are renting the following (y/n): ")
        input = readln()
    } while(input !in listOf("y", "n"))

    if (input == "y")
    {
        onlineLibrary.changeForID(ID)
        println("\n\n Successfully rented \n\n")
    }

}

/**
 * Displays the rentable items that have been successfully rented already.
 */
fun viewRented()
{
    println("The following are rented: \n")
    for(i in onlineLibrary.filteredByStatus(true))
    println(i.display() + "\n")
}