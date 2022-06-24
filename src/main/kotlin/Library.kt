/**
 * The library class stores all the available items and other useful helper methods
 */
class Library {
    var items = mutableListOf<RentableItems>(
        Movie(101,"Titanic","Leonardo DiCaprio", true),
        Movie(105,"The Lord of the Rings: the Turn of the King","Elijah Wood", false),
        Movie(121,"Forrest Gump","Tom Hanks", false),
        Movie(124,"Back to the Future","Michael J. Fox", false),
        Movie(139,"The Avengers","Robert Downey Jr.", false),
        Music(230,"Blinding Light","The Weeknd", false),
        Music(215,"Good 4 U","Olivia Rodrigo", false),
        Music(214,"Memories","Maroon 5", false),
        Music(257,"Riptide","Vance Joy", false),
        Music(273,"Enemy","Imagine Dragons", false),
        Book(335,"Pride and Prejudice","Jane Austen", false),
        Book(317,"The Princess Bride","William Goldman", false),
        Book(303,"The Great Gatsby","F. Scott Fitzgerald", false),
        Book(304,"1984","George Orwell", false),
        Book(305,"The Outsiders","S. E. Hinton", false)

    )

    /**
     * Looks up the ID that is inputted and calls the changeStatus() method of the specific item
     * @param ID the uniqueIDNumber for each rentable item, allows for the search of the item and change its rent status
     */
    fun changeForID(ID : Int)
    {
        for(i in items)
        {
            if(i.getUniqueIDNumber() == ID) {
                i.changeRentStatus()
                break
            }
        }
    }


    /**
     * Helper method that returns a list that of a specific rent status (t/f)
     * @param rentStatus  T help denote if a list of all the rented items needs to be returned or all the available ones
     * @return retList List of either rented items or available items
      */
    fun filteredByStatus (rentStatus : Boolean) : MutableList<RentableItems>
    {
        var retList = mutableListOf<RentableItems>()
        for(i in items)
        {
            if(i.getRentStatus() == rentStatus)
                retList.add(i)
        }
        return retList
    }

    /**
     * Returns a list of all available items
     * @param type Denotes either a movie, music, or book
     * @return retList List of all available items of the specific type that is chosen by the user
     */
    fun filteredByTypeForRenting (type : Int) : MutableList<RentableItems>
    {
        var retList = mutableListOf<RentableItems>()
        for(i in filteredByStatus(false))
        {
            if((i.getUniqueIDNumber()/100) == type)
                retList.add(i)
        }
        return retList
    }


}