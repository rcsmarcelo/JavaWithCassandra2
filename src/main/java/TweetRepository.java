import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.util.ArrayList;
import java.util.List;

public class TweetRepository {
    private static final String TABLE_NAME = "Tweets";
    private Session session;

    public TweetRepository(Session session) {
        this.session = session;
    }

    public void createTable() {
        System.out.println("createTable – init");

        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(TABLE_NAME).append("(")
                .append("tweettext text PRIMARY KEY, ")
                .append("username text,")
                .append("datesent date);");
        final String query = sb.toString();
        session.execute(query);
    }

    public void insertTweet(Tweet tweet) {
        System.out.println("insetTweet – init");

        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append(TABLE_NAME).append("(username, tweettext, datesent) ")
                .append("VALUES ('").append(tweet.getUsername()).append("', '")
                .append(tweet.getTweetText()).append("', '")
                .append(tweet.getDateSent()).append("');");
        final String query = sb.toString();
        session.execute(query);
    }

    public List<Tweet> selectAll() {
        System.out.println("selectAll – init");

        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME);

        final String query = sb.toString();
        ResultSet rs = session.execute(query);
        List<Tweet> tweets = new ArrayList<Tweet>();
        for (Row r : rs) {
            Tweet tt = new Tweet(r.getString("username"),
                    r.getString("tweettext"), r.getDate("datesent"));
            System.out.println("@" + tt.getUsername() + ":" + " " + tt.getTweetText());
            tweets.add(tt);
        }
        return tweets;
    }

    public void deleteTweet(String tweettext) {
        System.out.println("deleteTweet – init");
        StringBuilder sb = new StringBuilder("DELETE FROM ")
                .append(TABLE_NAME).append(" WHERE tweettext = '")
                .append(tweettext).append("';");
        final String query = sb.toString();
        session.execute(query);
    }

    public void deleteTable(String tableName) {
        System.out.println("deleteTable – init");

        StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS ").append(tableName);

        final String query = sb.toString();
        session.execute(query);
    }
}
