data class Movie(
    private val initUniqueIDNumber : Int,
    private val initTitle : String,
    private val initLeadActor : String,
    private val initStatus : Boolean
) : RentableItems(initUniqueIDNumber, initTitle, initStatus) {

    private val leadActor: String = initLeadActor

    override fun display(): String
    {
        return info + "Lead Actor: $leadActor"
    }

}
