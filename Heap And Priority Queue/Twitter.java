import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

//Leetcode #355
//https://leetcode.com/problems/design-twitter/

public class Twitter {
    HashMap<Integer, List<int[]>> feedMap;
    HashMap<Integer, HashSet<Integer>> followMap;
    int tweetCount;
    
    public Twitter() {
        feedMap = new HashMap<Integer, List<int[]>>();
        followMap = new HashMap<Integer, HashSet<Integer>>();
        tweetCount = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> list = feedMap.getOrDefault(userId, new ArrayList<int[]>());
        tweetCount++;
        list.add(new int[]{tweetCount, tweetId});
        
        feedMap.put(userId, list);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        
        List<Integer> entireList = new ArrayList<>();
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        if(feedMap.containsKey(userId)){
            List<int[]> userFeedList = feedMap.get(userId);
            
            for(int i = 0; i < userFeedList.size(); i++)
            que.add(userFeedList.get(i));
        }    
        
        
        if(followMap.containsKey(userId)){
            HashSet<Integer> followingSet = followMap.get(userId);
        
            for(int id : followingSet){
                List<int[]> followFeedList = feedMap.get(id);
                
                if(followFeedList != null)
                    for(int i = 0; i < followFeedList.size(); i++)
                        que.add(followFeedList.get(i));
            }
        }
        
        while(!que.isEmpty() && entireList.size() < 10){
            entireList.add(que.poll()[1]);
        }
        
        return entireList;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId))
            followMap.put(followerId, new HashSet<Integer>());
      
        followMap.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId) && followMap.get(followerId).contains(followeeId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
