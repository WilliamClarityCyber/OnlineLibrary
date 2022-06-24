data class Music(
    private val initUniqueIDNumber : Int,
    private val initTitle : String,
    private val initArtist : String,
    private val initStatus : Boolean
) : RentableItems(initUniqueIDNumber, initTitle, initStatus) {

    private val artist: String = initArtist

    override fun display(): String
    {
        return info + "Artist: $artist"
    }

}
