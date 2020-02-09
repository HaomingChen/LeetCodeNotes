package weekelyContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Input
 * ["TweetCounts","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency","recordTweet","getTweetCountsPerFrequency"]
 * [[],["tweet3",0],["tweet3",60],["tweet3",10],["minute","tweet3",0,59],["minute","tweet3",0,60],["tweet3",120],["hour","tweet3",0,210]]
 * <p>
 * Output
 * [null,null,null,null,[2],[2,1],null,[4]]
 * <p>
 * Explanation
 * TweetCounts tweetCounts = new TweetCounts();
 * tweetCounts.recordTweet("tweet3", 0);
 * tweetCounts.recordTweet("tweet3", 60);
 * tweetCounts.recordTweet("tweet3", 10);                             // All tweets correspond to "tweet3" with recorded times at 0, 10 and 60.
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // return [2]. The frequency is per minute (60 seconds), so there is one interval of time: 1) [0, 60> - > 2 tweets.
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // return [2, 1]. The frequency is per minute (60 seconds), so there are two intervals of time: 1) [0, 60> - > 2 tweets, and 2) [60,61> - > 1 tweet.
 * tweetCounts.recordTweet("tweet3", 120);                            // All tweets correspond to "tweet3" with recorded times at 0, 10, 60 and 120.
 * tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // return [4]. The frequency is per hour (3600 seconds), so there is one interval of time: 1) [0, 211> - > 4 tweets.
 *
 * @author Haoming Chen
 * Created on 2020/2/9
 */
class TweetCounts {

    int minute = 60;
    int hour = 3600;
    int day = 86400;
    HashMap<String, ArrayList<Integer>> tweets;

    public TweetCounts() {
        tweets = new HashMap<>(16);
    }

    public void recordTweet(String tweetName, int time) {
        if (tweetName == null || tweetName.length() == 0) {
            return;
        }
        if (tweets.containsKey(tweetName)) {
            tweets.get(tweetName).add(time);
        } else {
            ArrayList<Integer> pq = new ArrayList<>();
            pq.add(time);
            tweets.put(tweetName, pq);
        }
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<Integer>();
        int interval = 0;
        if (freq.equals("minute")) {
            interval = minute;
        } else if (freq.equals("hour")) {
            interval = hour;
        } else if (freq.equals("day")) {
            interval = day;
        } else {
            return res;
        }
        Integer[] itv = (Integer[]) (tweets.get(tweetName).toArray());
        Arrays.sort(itv);
        int start = 0;
        int index = 0;
        int current = 0;
        int curTime = interval;
        while (index != itv.length) {
            if (itv[index] > endTime) {
                return res;
            }
            if (itv[index] >= curTime) {
                if (current != 0) {
                    res.add(current);
                }
                current = 0;
                curTime = curTime + interval;
                continue;
            }
            if (itv[index] <= endTime && itv[index] >= startTime) {
                current++;
            }
            index++;
        }
        return res;
    }
}

