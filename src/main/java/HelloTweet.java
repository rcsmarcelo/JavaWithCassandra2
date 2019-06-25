import com.datastax.driver.core.*;

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

            Tweet tweet = new Tweet("Jorgin", "coe lek",
                    LocalDate.fromYearMonthDay(19,02,03));
            tr.insertTweet(tweet);
            Tweet tweet2 = new Tweet("MrMan", "its lit",
                    LocalDate.fromYearMonthDay(19,02,04));
            tr.insertTweet(tweet2);
            Tweet tweet3 = new Tweet("penguinman", "i like penguins",
                    LocalDate.fromYearMonthDay(19,02,03));
            tr.insertTweet(tweet3);
            Tweet tweet4 = new Tweet("MrMan", "it really is lit",
                    LocalDate.fromYearMonthDay(19,02,05));
            tr.insertTweet(tweet4);
            Tweet tweet5 = new Tweet("Jorgin", "fomeeeee",
                    LocalDate.fromYearMonthDay(19,02,06));
            tr.insertTweet(tweet5);
            System.out.println("Inserting tweets");

            tr.selectAll();
            System.out.println("Fecthing all tweets");

            tr.deleteTweet("its lit");
            System.out.println("Deleting tweet \"its lit\"");

            tr.deleteTable("Tweets");
            System.out.println("Deleting table Tweets");

            sr.deleteKeyspace("tweets");
            System.out.println("Deleting keyspace tweets");

        } finally {
            if (cluster != null) cluster.close();
        }
    }
}
