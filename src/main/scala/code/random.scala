package code.random

import scala.io.Source
import scala.util.Random
import scala.collection.mutable.ListBuffer


object random{ 
    def getRndWords(wordList: Seq[String]): Seq[String] ={
        val rndWords =  new ListBuffer[String]()
        val rnd = new Random()
        for(i <- 0 until 10){
            rndWords += wordList(rnd.nextInt(wordList.length))
        }
        rndWords
    }   
}
