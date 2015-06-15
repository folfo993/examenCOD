/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examendetwitter;

import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author FOLFO
 */
    public class metodostwitter {
    

    Twitter twitter;

    /**
     * Constructor, da acceso a nuestra cuenta en twitter.
     */
    public metodostwitter() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
         cb.setDebugEnabled(true)
         .setOAuthConsumerKey("ttn86DHjTWZ21heKN6uQp9iy6")
         .setOAuthConsumerSecret("wQagAbytgoScb8UtCwY5nupQJkmW844MNrpMTVuQMFytxmceuP")
         .setOAuthAccessToken("3318200759-FsPeZSPibyDHgiPk7KllUBmvN5LarHeFpjH3JSv")
         .setOAuthAccessTokenSecret("z5I7uNEiIZH0ni9iNhKyUtASnHnGXN6puxjfQi6476RF0");
         twitter = new TwitterFactory(cb.build()).getInstance();
        twitter = new TwitterFactory("twitter4j.properties").getInstance();

    }

    /**
     * Nos da nuestro timeLine
     */
    public void verTL() throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }

    }

    /**
     * Busca tweets con el texto introducido
     */
    public void buscarTrending(String busqueda) throws TwitterException {

        Query query = new Query(busqueda);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }

    }

    /**
     * Crea y publica un tweet
     */
    public void tweetear(String tweet) throws TwitterException {

        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }
    }
