import com.datastax.driver.core.LocalDate;

import java.util.UUID;

public class Tweet {
    private String Username;
    private String TweetText;
    private LocalDate DateSent;

    public Tweet() {}

    public Tweet(String username, String tttext, LocalDate date) {
        Username = username;
        TweetText = tttext;
        DateSent = date;
    }

    public void setUsername(String username) { this.Username = username; }

    public void setTweetText(String tweetText) { this.TweetText = tweetText; }

    public void setDateSent(LocalDate dateSent) { this.DateSent = dateSent; }

    public String getUsername() { return Username; }

    public LocalDate getDateSent() { return DateSent; }

    public String getTweetText() { return TweetText; }

    public String toString() { return "@" + this.Username +
            ": " + this.TweetText; }
}