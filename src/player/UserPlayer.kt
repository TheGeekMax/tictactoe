package player

import GameMain

abstract class UserPlayer(ist:GameMain) {
    val instance: GameMain;
    init{
        instance = ist;
    }

    abstract val getPlayerType: String
    abstract fun play(plateau: Array<IntArray>)
}