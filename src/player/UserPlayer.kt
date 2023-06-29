package player

abstract class UserPlayer() {
    init{}
    abstract val getPlayerType: String
    abstract fun play(plateau: Array<IntArray>)
}