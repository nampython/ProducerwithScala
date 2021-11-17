# ProducerwithScala
using the Kafka Producer to generate 10 random words

To run this App: 
- Start the ZooKeeper service: bin/zookeeper-server-start.sh config/zookeeper.properties. Open another terminal session
- Start the Kafka broker service: bin/kafka-server-start.sh config/server.properties
- To receive the data, run  another terminal consume: bin/kafka-console-consumer.sh --topic RandomWordList --from-beginning --bootstrap-server localhost:9092
- Finally, run this App: scala target/scala-2.12/wordcountgenerator_2.12-1.0.jar
