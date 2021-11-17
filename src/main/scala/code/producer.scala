package code.kafka
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import java.util.Properties
import code.random._
import scala.io.Source

object producer extends App {
    val props: Properties = new Properties()
    props.put("bootstrap.servers","localhost:9092")
    props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")
    props.put("acks","all")
    val producer = new KafkaProducer[String, String](props)
    val topic = "RandomWordList"
    val intervalEvent = 1 //in second
    val wordList = Source.fromFile("src/main/scala/data/data.txt").getLines().toSeq
    try {
        for (i <- Range(0, 100)) {

            val key = i.toString()
            val value = random.getRndWords(wordList).mkString(", ")
            val record = new ProducerRecord[String, String](topic, i.toString, value)
            println(record)
            val metadata = producer.send(record)


            printf(s"sent record(key=%s value=%s) " + "meta(partition=%d, offset=%d)\n",
                record.key(), record.value(), 
                metadata.get().partition(),
                metadata.get().offset())
            if(intervalEvent > 0){
                Thread.sleep(intervalEvent * 1000)
            }

        }
    }
    catch{
        case e:Exception => e.printStackTrace()
    }
    finally{
        producer.close()
    }






    // producer.close()
}

