data class Book(
    private val initUniqueIDNumber : Int,
    private val initTitle : String,
    private val initAuthor : String,
    private val initStatus : Boolean
) : RentableItems(initUniqueIDNumber, initTitle, initStatus) {

    private val author: String = initAuthor

    override fun display(): String
    {
        return info + "Author: $author"
    }

}
