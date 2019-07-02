# JavaWithCassandra2
For a class assignment
/usr/java/jdk-9/bin/java -javaagent:/opt/idea-IC-182.4129.33/lib/idea_rt.jar=39443:/opt/idea-IC-182.4129.33/bin -Dfile.encoding=UTF-8 -classpath /home/treinamento/IdeaProjects/JavaWithCassandra2/target/classes:/home/treinamento/.m2/repository/com/datastax/cassandra/cassandra-driver-core/3.7.1/cassandra-driver-core-3.7.1.jar:/home/treinamento/.m2/repository/io/netty/netty-handler/4.0.56.Final/netty-handler-4.0.56.Final.jar:/home/treinamento/.m2/repository/io/netty/netty-buffer/4.0.56.Final/netty-buffer-4.0.56.Final.jar:/home/treinamento/.m2/repository/io/netty/netty-common/4.0.56.Final/netty-common-4.0.56.Final.jar:/home/treinamento/.m2/repository/io/netty/netty-transport/4.0.56.Final/netty-transport-4.0.56.Final.jar:/home/treinamento/.m2/repository/io/netty/netty-codec/4.0.56.Final/netty-codec-4.0.56.Final.jar:/home/treinamento/.m2/repository/com/google/guava/guava/19.0/guava-19.0.jar:/home/treinamento/.m2/repository/io/dropwizard/metrics/metrics-core/3.2.2/metrics-core-3.2.2.jar:/home/treinamento/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar:/home/treinamento/.m2/repository/com/github/jnr/jnr-ffi/2.1.7/jnr-ffi-2.1.7.jar:/home/treinamento/.m2/repository/com/github/jnr/jffi/1.2.16/jffi-1.2.16.jar:/home/treinamento/.m2/repository/org/ow2/asm/asm/5.0.3/asm-5.0.3.jar:/home/treinamento/.m2/repository/org/ow2/asm/asm-commons/5.0.3/asm-commons-5.0.3.jar:/home/treinamento/.m2/repository/org/ow2/asm/asm-analysis/5.0.3/asm-analysis-5.0.3.jar:/home/treinamento/.m2/repository/org/ow2/asm/asm-tree/5.0.3/asm-tree-5.0.3.jar:/home/treinamento/.m2/repository/org/ow2/asm/asm-util/5.0.3/asm-util-5.0.3.jar:/home/treinamento/.m2/repository/com/github/jnr/jnr-x86asm/1.0.2/jnr-x86asm-1.0.2.jar:/home/treinamento/.m2/repository/com/github/jnr/jnr-posix/3.0.44/jnr-posix-3.0.44.jar:/home/treinamento/.m2/repository/com/github/jnr/jnr-constants/0.9.9/jnr-constants-0.9.9.jar:/home/treinamento/.m2/repository/org/twitter4j/twitter4j-stream/4.0.6/twitter4j-stream-4.0.6.jar:/home/treinamento/.m2/repository/org/twitter4j/twitter4j-core/4.0.6/twitter4j-core-4.0.6.jar HelloTweet
Sup
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
3.11.4
createKeyspace – init
Creating Repository...

useKeyspace – init
Using repository tweets...

createTableTweets – init
CREATE TABLE IF NOT EXISTS Tweets(id uuid PRIMARY KEY, tweettext text, username text, datesent date, country text, source text, istruncated boolean, latitude double, longitude double, isfavorited boolean, isretweeted boolean, contributors list<bigint>);
createTableTweets – end
Creating table Tweets...

createTableTweetsByCountry – init
CREATE TABLE IF NOT EXISTS TweetsByCountry(id uuid,tweettext text, username text, datesent date, country text,source text, istruncated boolean, latitude double, longitude double, isfavorited boolean, isretweeted boolean, contributors list<bigint>, PRIMARY KEY ((id, country)));
createTableTweetByCountry – end
Creating table TweetsByUser...

insertTweet – init
INSERT INTO Tweets(id, tweettext, username, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985b2df0-9cca-11e9-bc4e-29b5b8de091d, 'Jorgin', 'coe lek', '19-02-03', 'Brazil', 'lol', false, 10.0, 10.0, true, true, null);
insertTweet – end
insertTweet – init
INSERT INTO Tweets(id, tweettext, username, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985c1850-9cca-11e9-bc4e-29b5b8de091d, 'MrMan', 'its lit', '19-02-04', 'EUA', 'lol', false, 10.0, 10.0, true, true, null);
insertTweet – end
insertTweet – init
INSERT INTO Tweets(id, tweettext, username, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985cb490-9cca-11e9-bc4e-29b5b8de091d, 'penguinman', 'i like penguins', '19-02-03', 'EUA', 'lol', false, 10.0, 10.0, true, true, null);
insertTweet – end
insertTweet – init
INSERT INTO Tweets(id, tweettext, username, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985d77e0-9cca-11e9-bc4e-29b5b8de091d, 'MrMan', 'it really is lit', '19-02-05', 'EUA', 'lol', false, 10.0, 10.0, true, true, null);
insertTweet – end
insertTweet – init
INSERT INTO Tweets(id, tweettext, username, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985f2590-9cca-11e9-bc4e-29b5b8de091d, 'Jorgin', 'fomeeeee', '19-02-06', 'Brazil', 'lol', false, 10.0, 10.0, true, true, null);
insertTweet – end
insertTweetByCountry – init
INSERT INTO TweetsByCountry(id, username, tweettext, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985f2590-9cca-11e9-bc4e-29b5b8de091d, 'Jorgin', 'fomeeeee', '19-02-06', 'Brazil', 'lol', false, 10.0, 10.0, true, true, null);
insertTweetByCountry – end
insertTweetByCountry – init
INSERT INTO TweetsByCountry(id, username, tweettext, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985b2df0-9cca-11e9-bc4e-29b5b8de091d, 'Jorgin', 'coe lek', '19-02-03', 'Brazil', 'lol', false, 10.0, 10.0, true, true, null);
insertTweetByCountry – end
insertTweetByCountry – init
INSERT INTO TweetsByCountry(id, username, tweettext, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985c1850-9cca-11e9-bc4e-29b5b8de091d, 'MrMan', 'its lit', '19-02-04', 'EUA', 'lol', false, 10.0, 10.0, true, true, null);
insertTweetByCountry – end
insertTweetByCountry – init
INSERT INTO TweetsByCountry(id, username, tweettext, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985cb490-9cca-11e9-bc4e-29b5b8de091d, 'penguinman', 'i like penguins', '19-02-03', 'EUA', 'lol', false, 10.0, 10.0, true, true, null);
insertTweetByCountry – end
insertTweetByCountry – init
INSERT INTO TweetsByCountry(id, username, tweettext, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985d77e0-9cca-11e9-bc4e-29b5b8de091d, 'MrMan', 'it really is lit', '19-02-05', 'EUA', 'lol', false, 10.0, 10.0, true, true, null);
insertTweetByCountry – end
insertTweetByCountry – init
INSERT INTO TweetsByCountry(id, username, tweettext, datesent, country, source, istruncated, latitude, longitude, isfavorited, isretweeted, contributors) VALUES (985f2590-9cca-11e9-bc4e-29b5b8de091d, 'Jorgin', 'fomeeeee', '19-02-06', 'Brazil', 'lol', false, 10.0, 10.0, true, true, null);
insertTweetByCountry – end
Inserting tweets by country

selectAll – init
SELECT * FROM Tweets
EUA  985c1850-9cca-11e9-bc4e-29b5b8de091d @its lit: MrMan
Brazil  985b2df0-9cca-11e9-bc4e-29b5b8de091d @coe lek: Jorgin
EUA  985d77e0-9cca-11e9-bc4e-29b5b8de091d @it really is lit: MrMan
Brazil  985f2590-9cca-11e9-bc4e-29b5b8de091d @fomeeeee: Jorgin
EUA  985cb490-9cca-11e9-bc4e-29b5b8de091d @i like penguins: penguinman
selectAll – end
Fecthing all tweets

selectAllyCountry – init
SELECT * FROM TweetsByCountry
EUA  985cb490-9cca-11e9-bc4e-29b5b8de091d @penguinman: i like penguins
Brazil  985b2df0-9cca-11e9-bc4e-29b5b8de091d @Jorgin: coe lek
Brazil  985f2590-9cca-11e9-bc4e-29b5b8de091d @Jorgin: fomeeeee
EUA  985d77e0-9cca-11e9-bc4e-29b5b8de091d @MrMan: it really is lit
EUA  985c1850-9cca-11e9-bc4e-29b5b8de091d @MrMan: its lit
selectAllyCountry – end
Fecthing all tweets by country

selectTweetByCountry – init
SELECT * FROM TweetsByCountry WHERE country = 'EUA' ALLOW FILTERING;
EUA  985cb490-9cca-11e9-bc4e-29b5b8de091d @penguinman: i like penguins
EUA  985d77e0-9cca-11e9-bc4e-29b5b8de091d @MrMan: it really is lit
EUA  985c1850-9cca-11e9-bc4e-29b5b8de091d @MrMan: its lit
selectTweetByCountry – end
Fecthing tweets from country X

deleteTweet – init
DELETE FROM Tweets WHERE id = 985cb490-9cca-11e9-bc4e-29b5b8de091d;
deleteTweet – end
Deleting tweet 985cb490-9cca-11e9-bc4e-29b5b8de091d 

deleteTweetByCountry – init
DELETE FROM TweetsByCountry WHERE country = 'EUA' AND id =985cb490-9cca-11e9-bc4e-29b5b8de091d;
deleteTweetByCountry – end
Deleting tweet 985cb490-9cca-11e9-bc4e-29b5b8de091d from "EUA"

selectAll – init
SELECT * FROM Tweets
EUA  985c1850-9cca-11e9-bc4e-29b5b8de091d @its lit: MrMan
Brazil  985b2df0-9cca-11e9-bc4e-29b5b8de091d @coe lek: Jorgin
EUA  985d77e0-9cca-11e9-bc4e-29b5b8de091d @it really is lit: MrMan
Brazil  985f2590-9cca-11e9-bc4e-29b5b8de091d @fomeeeee: Jorgin
selectAll – end
Fecthing all tweets

selectAllyCountry – init
SELECT * FROM TweetsByCountry
Brazil  985b2df0-9cca-11e9-bc4e-29b5b8de091d @Jorgin: coe lek
Brazil  985f2590-9cca-11e9-bc4e-29b5b8de091d @Jorgin: fomeeeee
EUA  985d77e0-9cca-11e9-bc4e-29b5b8de091d @MrMan: it really is lit
EUA  985c1850-9cca-11e9-bc4e-29b5b8de091d @MrMan: its lit
selectAllyCountry – end
Fecthing all tweets by country

deleteTable – init
DROP TABLE IF EXISTS Tweets
deleteTable – end
Deleting table Tweets

deleteTable – init
DROP TABLE IF EXISTS TweetsByCountry
deleteTable – end
Deleting table TweetsByCountry

deleteKeyspace– init
Deleting keyspace tweets


Process finished with exit code 0
