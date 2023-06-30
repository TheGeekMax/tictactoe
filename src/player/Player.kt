package player

import GameMain

class Player(ist:GameMain):UserPlayer(ist){
    override val getPlayerType:String  = "Player"
    override fun play(plateau: Array<IntArray>){
        GameMain.touchable = true
        while(!GameMain.playing){
            try {
                Thread.sleep(5)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

}