/home/seli/confluent-3.1.2/etc/kafka/server.properties  add IP
/home/seli/confluent-3.1.2/etc/schema-registry/connect-avro-distributed.properties, add IP



./bin/kafka-topics --zookeeper localhost:2181 --create --topic image-message --partitions 50 --replication-factor 1
./bin/kafka-topics --zookeeper localhost:2181 --create --topic image-tags --partitions 50 --replication-factor 1
./bin/kafka-topics --zookeeper localhost:2181 --create --topic image-fingerprints --partitions 50 --replication-factor 1
./bin/kafka-topics --zookeeper localhost:2181 --create --topic image-collection --partitions 50 --replication-factor 1
./bin/kafka-topics --zookeeper localhost:2181 --create --topic image-derivatives --partitions 50 --replication-factor 1
./bin/kafka-topics --zookeeper localhost:2181 --create --topic image-activity-log --partitions 50 --replication-factor 1

curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-media-int","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://NssqlintlodgingCatalogMaster01.karmalab.net;databaseName=LodgingCatalogMaster;user=TravCatalog;password=travel","query":"select * from vwChangesMedia","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-media-int","mode":"incrementing","poll.interval.ms":5000}}' http://10.2.91.11:8083/connectors
curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-catalog-item-media-int","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://NssqlintlodgingCatalogMaster01.karmalab.net;databaseName=LodgingCatalogMaster;user=TravCatalog;password=travel","query":"select * from vwChangesCatalogItemMedia","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-catalog-item-media-int","mode":"incrementing","poll.interval.ms":5000}}' http://localhost:8083/connectors


curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-media-stress","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://CHELLSSSQL25.karmalab.net;databaseName=LodgingCatalogMaster_Phoenix;user=TravCatalog;password=travel","query":"select * from vwChangesMedia","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-media-stress","mode":"incrementing","poll.interval.ms":5000}}' http://cs-confluent-platform-connect.test.expedia.com/connectors


curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-media","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://CHELLSSSQL23.karmalab.net;databaseName=LodgingCatalogMaster_Phoenix;user=TravCatalog;password=travel","query":"select * from vwChangesMedia","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-media-test","mode":"incrementing","poll.interval.ms":5000}}' http://localhost:8083/connectors


curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-catalog-item-media","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://CHELLSSSQL23.karmalab.net;databaseName=LodgingCatalogMaster_Phoenix;user=TravCatalog;password=travel","query":"select * from vwChangesCatalogItemMedia","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-catalog-item-media-test","mode":"incrementing","poll.interval.ms":5000}}' http://localhost:8083/connectors


curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-sku-group","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://CHELLSSSQL23.karmalab.net;databaseName=LodgingCatalogMaster_Phoenix;user=TravCatalog;password=travel","query":"select * from vwChangesSKUGroup","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-sku-group-test","mode":"incrementing","poll.interval.ms":5000}}' http://localhost:8083/connectors


curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-room","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://CHELLSSSQL23.karmalab.net;databaseName=LodgingCatalogMaster_Phoenix;user=TravCatalog;password=travel","query":"select * from vwChangesRoomType","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-room-test","mode":"incrementing","poll.interval.ms":5000}}' http://localhost:8083/connectors


curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-catalog-item","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://CHELLSSSQL23.karmalab.net;databaseName=LodgingCatalogMaster_Phoenix;user=TravCatalog;password=travel","query":"select * from vwChangesCatalogItem","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-catalog-item-test","mode":"incrementing","poll.interval.ms":5000}}' http://localhost:8083/connectors


curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-media-category-loc","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://CHELLSSSQL23.karmalab.net;databaseName=LodgingCatalogMaster_Phoenix;user=TravCatalog;password=travel","query":"select * from vwChangesMediaCategoryLoc","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-media-category-loc-test","mode":"incrementing","poll.interval.ms":5000}}' http://localhost:8083/connectors



curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-media-guid","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://CHELLSSSQL23.karmalab.net;databaseName=LodgingCatalogMaster_Phoenix;user=TravCatalog;password=travel","query":"select * from vwChangesMediaGUID","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-media-guid-test","mode":"incrementing","poll.interval.ms":5000}}' http://localhost:8083/connectors


curl -H "Content-Type: application/json" -X POST -d '{"name":"lcm-change-media-subcategory-loc","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector","connection.url":"jdbc:sqlserver://CHELLSSSQL23.karmalab.net;databaseName=LodgingCatalogMaster_Phoenix;user=TravCatalog;password=travel","query":"select * from vwChangesMediaSubcategoryLoc","incrementing.column.name":"SYS_CHANGE_VERSION","tasks.max":"5","topic.prefix":"lcm-change-media-subcategory-loc-test","mode":"incrementing","poll.interval.ms":5000}}' http://localhost:8083/connectors


./bin/kafka-topics --zookeeper 10.2.90.36:2181 --create --topic image-message-stress-partition-less --partitions 16 --replication-factor 1
./bin/kafka-topics --zookeeper 10.2.90.36:2181 --create --topic image-fingerprints-stress-partition-less --partitions 16 --replication-factor 1
./bin/kafka-topics --zookeeper 10.2.90.36:2181 --create --topic image-collection-stress-partition-less --partitions 16 --replication-factor 1
./bin/kafka-topics --zookeeper 10.2.90.36:2181 --create --topic image-derivatives-stress-partition-less --partitions 16 --replication-factor 1
./bin/kafka-topics --zookeeper 10.2.90.36:2181 --create --topic image-activity-log-stress-partition-less --partitions 16 --replication-factor 1

./bin/kafka-topics --zookeeper cs-confluent-platform-zookeeper.test.expedia.com:80 --create --topic lcm-change-media-1204 --partitions 16 --replication-factor 3





./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-message-stress-new-kafka --partitions 16 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-fingerprints-stress-new-kafka --partitions 16 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-collection-stress-new-kafka --partitions 16 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-derivatives-stress-new-kafka --partitions 16 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-activity-log-stress-new-kafka --partitions 16 --replication-factor 3


./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic ImageMessageTopicStringRetry --partitions 16 --replication-factor 3

./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-message-full-int --partitions 50 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-fingerprints-test0609 --partitions 50 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-collection-test0609 --partitions 50 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-derivatives-test0609 --partitions 50 --replication-factor 3


./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-message-test0610 --partitions 50 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-fingerprints-test0610 --partitions 50 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-collection-test0610 --partitions 50 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-derivatives-test0610 --partitions 50 --replication-factor 3


java -cp media-commons.jar  com.expedia.content.media.processing.pipeline.tool.KafkaImageReprocessor  groupdId cs-media-image-derivatives-retry cs-media-image-derivatives 2017-05-20 > reprocess_derivative_0520.log



./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-derivative-created-dev --partitions 50 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-derivative-created-int --partitions 50 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-derivative-created-stress --partitions 50 --replication-factor 3
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic image-derivative-created-test --partitions 50 --replication-factor 3


./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic lcm-image-derivative-created-dev-retry --partitions 1 --replication-factor 1
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic lcm-image-derivative-created-int-retry --partitions 1 --replication-factor 1
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic lcm-image-derivative-created-stress-retry --partitions 1 --replication-factor 1
./bin/kafka-topics --zookeeper 10.2.68.173:2181 --create --topic lcm-image-derivative-created-test-retry --partitions 1 --replication-factor 1



