# Demo Spring Kafka

Ceci est une application simple Spring Boot pour démontrer l'envoi et la réception de messages dans Kafka à l'aide de spring-kafka.

Comme les sujets Kafka ne sont pas créés automatiquement par défaut, cette application nécessite la création manuelle des sujets(topics).

Lancement de serveur Kafka :

docker-compose up -d

Création des topics :


`$ docker-compose exec kafka kafka-topics --create --topic demo --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1`<br>


Run de l'application :

mvn spring-boot:run

Lorsque l'application s'exécute correctement, la sortie suivante est connectée à la console (avec les journaux printaniers):


#### Message reçu du topic "demo" par le listener de base avec le groupe demogroup

ConsumerRecord(topic = demo, partition = 0, offset = 24, CreateTime = 1543883135172, serialized key size = -1, serialized value size = 4, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = foo1)<br>
ConsumerRecord(topic = demo, partition = 0, offset = 25, CreateTime = 1543883135182, serialized key size = -1, serialized value size = 4, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = foo2)<br>
ConsumerRecord(topic = demo, partition = 0, offset = 26, CreateTime = 1543883135182, serialized key size = -1, serialized value size = 4, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = foo3)<br>
ConsumerRecord(topic = demo, partition = 0, offset = 27, CreateTime = 1543883135182, serialized key size = -1, serialized value size = 4, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = foo4)
