import com.datastax.driver.core.*;
import com.datastax.driver.core.utils.UUIDs;
import twitter4j.GeoLocation;

public class HelloTweet {
    public static void main(String[] args) {
        System.out.println("Sup");
        Cluster cluster = null;
        try {
            cluster = Cluster.builder()
                    .addContactPoint("localhost")
                    .build();
            Session session = cluster.connect();
            ResultSet rs = session.execute("select release_version from system.local");
            Row row = rs.one();
            System.out.println(row.getString("release_version"));

            KeyspaceRepository sr = new KeyspaceRepository(session);
            sr.createKeyspace("tweets", "SimpleStrategy", 1);
            System.out.println("Creating Repository");

            sr.useKeyspace("tweets");
            System.out.println("Using repository tweets");

            TweetRepository tr = new TweetRepository(session);
            tr.createTable();
            System.out.println("Creating table Tweets");

            tr.createTableTweetsByCountry();
            System.out.println("Creating table TweetsByUser");

            Tweet tweet = new Tweet(UUIDs.timeBased(),"Jorgin", "coe lek",
                    LocalDate.fromYearMonthDay(19,02,03),"EUA", "lol", false,
                    new GeoLocation(10, 10), true, true, null);
            tr.insertTweet(tweet);
            Tweet tweet2 = new Tweet(UUIDs.timeBased(),"MrMan", "its lit",
                    LocalDate.fromYearMonthDay(19,02,04),"EUA", "lol", false,
                    new GeoLocation(10, 10), true, true, null);
            tr.insertTweet(tweet2);
            Tweet tweet3 = new Tweet(UUIDs.timeBased(),"penguinman", "i like penguins",
                    LocalDate.fromYearMonthDay(19,02,03),"EUA", "lol", false,
                    new GeoLocation(10, 10), true, true, null);
            tr.insertTweet(tweet3);
            Tweet tweet4 = new Tweet(UUIDs.timeBased(),"MrMan", "it really is lit",
                    LocalDate.fromYearMonthDay(19,02,05),"EUA", "lol", false,
                    new GeoLocation(10, 10), true, true, null);
            tr.insertTweet(tweet4);
            Tweet tweet5 = new Tweet(UUIDs.timeBased(),"Jorgin", "fomeeeee",
                    LocalDate.fromYearMonthDay(19,02,06),"EUA", "lol", false,
                    new GeoLocation(10, 10), true, true, null);

            tr.insertTweetByCountry(tweet5);
            tr.insertTweetByCountry(tweet);
            tr.insertTweetByCountry(tweet2);
            tr.insertTweetByCountry(tweet3);
            tr.insertTweetByCountry(tweet4);
            tr.insertTweetByCountry(tweet5);
            System.out.println("Inserting tweets by country");

            tr.selectAll();
            System.out.println("Fecthing all tweets");

            tr.selectAllByCountry();
            System.out.println("Fecthing all tweets by country");

            tr.selectTweetByCountry("EUA");
            System.out.println("Fecthing tweets from country X");

            //tr.deleteTweet("its lit");
            //System.out.println("Deleting tweet \"its lit\"");

            tr.deleteTable("Tweets");
            System.out.println("Deleting table Tweets");

            sr.deleteKeyspace("tweets");
            System.out.println("Deleting keyspace tweets");

        } finally {
            if (cluster != null) cluster.close();
        }
    }
}
