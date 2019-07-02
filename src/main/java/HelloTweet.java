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
            System.out.println("Creating Repository...\n");

            sr.useKeyspace("tweets");
            System.out.println("Using repository tweets...\n");

            TweetRepository tr = new TweetRepository(session);
            tr.createTable();
            System.out.println("Creating table Tweets...\n");

            tr.createTableTweetsByCountry();
            System.out.println("Creating table TweetsByUser...\n");

            Tweet tweet = new Tweet(UUIDs.timeBased(),"Jorgin", "coe lek",
                    LocalDate.fromYearMonthDay(19,02,03),"Brazil", "lol", false,
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
                    LocalDate.fromYearMonthDay(19,02,06),"Brazil", "lol", false,
                    new GeoLocation(10, 10), true, true, null);
            tr.insertTweet(tweet5);

            tr.insertTweetByCountry(tweet5);
            tr.insertTweetByCountry(tweet);
            tr.insertTweetByCountry(tweet2);
            tr.insertTweetByCountry(tweet3);
            tr.insertTweetByCountry(tweet4);
            tr.insertTweetByCountry(tweet5);
            System.out.println("Inserting tweets by country\n");

            tr.selectAll();
            System.out.println("Fecthing all tweets\n");

            tr.selectAllByCountry();
            System.out.println("Fecthing all tweets by country\n");

            tr.selectTweetByCountry("EUA");
            System.out.println("Fecthing tweets from country X\n");

            tr.deleteTweet(tweet3.getID());
            System.out.println("Deleting tweet " + tweet3.getID() + " \n");

            tr.deleteTweetByCountry("EUA", tweet3.getID());
            System.out.println("Deleting tweet " + tweet3.getID() + " from \"EUA\"\n");

            tr.selectAll();
            System.out.println("Fecthing all tweets\n");

            tr.selectAllByCountry();
            System.out.println("Fecthing all tweets by country\n");

            tr.deleteTable("Tweets");
            System.out.println("Deleting table Tweets\n");

            tr.deleteTable("TweetsByCountry");
            System.out.println("Deleting table TweetsByCountry\n");

            sr.deleteKeyspace("tweets");
            System.out.println("Deleting keyspace tweets\n");

        } finally {
            if (cluster != null) cluster.close();
        }
    }
}
