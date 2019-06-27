import com.datastax.driver.core.LocalDate;

import java.util.UUID;
import twitter4j.*;

public class Tweet {
    private UUID        ID;
    private String      Username;
    private String      TweetText;
    private LocalDate   DateSent;
    private String      Country;
    private String      Source;
    private boolean     Truncated;
    private GeoLocation GeoLocation;
    private boolean     Favorited;
    private boolean     Retweeted;
    private long[]      Contributors;

    public Tweet() {}

    public Tweet(UUID id, String username, String tttext, LocalDate date, String country, String source,
                 boolean truncated, GeoLocation geolocation, boolean favorited, boolean retweeted,
                 long[] contributors) {
        ID = id;
        Username = username;
        TweetText = tttext;
        DateSent = date;
        Country = country;
        Source = source;
        Truncated = truncated;
        GeoLocation = geolocation;
        Favorited = favorited;
        Retweeted = retweeted;
        Contributors = contributors;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public void setTweetText(String tweetText) {
        this.TweetText = tweetText;
    }

    public void setDateSent(LocalDate dateSent) {
        this.DateSent = dateSent;
    }

    public void setID(UUID id) {
        this.ID = id;
    }

    public void setSource(String source) {
        Source = source;
    }

    public void setTruncated(boolean truncated) {
        Truncated = truncated;
    }

    public void setGeoLocation(twitter4j.GeoLocation geoLocation) {
        GeoLocation = geoLocation;
    }

    public void setFavorited(boolean favorited) {
        Favorited = favorited;
    }

    public void setRetweeted(boolean retweeted) {
        Retweeted = retweeted;
    }

    public void setCountry(String country) { Country = country; }

    public void setContributors(long[] contributors) { Contributors = contributors; }

    public String getUsername() {
        return Username;
    }

    public LocalDate getDateSent() {
        return DateSent;
    }

    public String getCountry() { return Country; }

    public String getTweetText() {
        return TweetText;
    }

    public UUID getID () {
        return ID;
    }

    public String getSource() {
        return Source;
    }

    public boolean isTruncated() {
        return Truncated;
    }

    public GeoLocation getGeoLocation() {
        return GeoLocation;
    }

    public boolean isFavorited() {
        return Favorited;
    }

    public boolean isRetweeted() {
        return Retweeted;
    }

    public long[] getContributors() { return Contributors; }

    public String toString() { return "@" + this.Username +
            ": " + this.TweetText; }
}