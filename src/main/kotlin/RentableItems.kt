

open class RentableItems(
    private val initUniqueIDNumber : Int,
    private val initTitle : String,
    private val initRentStatus : Boolean
    ){

    private val uniqueIDNumber: Int = initUniqueIDNumber
    private val title: String = initTitle
    open val info : String = "ID: $uniqueIDNumber \nTitle: $title\n"
    private var rentStatus : Boolean = initRentStatus

    /**
     * @return Strings together the uniqueIDNumber and title
     */
     open fun display() : String
     {
         return info
     }

    /**
     * Inverts the rentStatus of the specific item
     */
    fun changeRentStatus() {
        rentStatus = !rentStatus
    }

    /**
     * Getter
     */
     fun getUniqueIDNumber() : Int{
         return uniqueIDNumber
     }

    /**
     * Getter
     */
    fun getTitle() : String{
        return title
    }

    /**
     * Getter
     */
    fun getRentStatus() : Boolean{
         return rentStatus
     }

}