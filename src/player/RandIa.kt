package player

import GameMain
import kotlin.random.Random

class RandIa(ist:GameMain):UserPlayer(ist){
    override val getPlayerType:String  = "RandIA"
    override fun play(plateau: Array<IntArray>){
        GameMain.touchable = false
        var x:Int
        var y:Int
        do{
            x = Random.nextInt(0,3)
            y = Random.nextInt(0,3)
        }while(instance.plateau[x][y] != 0)
        instance.playAt(x,y)
    }
}