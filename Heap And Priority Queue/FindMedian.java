import java.util.PriorityQueue;

//Leetcode #295
//https://leetcode.com/problems/find-median-from-data-stream/
//Time Complexity: O(logn)
//Space Complexity: O(n)
public class FindMedian {
    PriorityQueue<Integer> smallQue;
    PriorityQueue<Integer> bigQue;
    
    
    public FindMedian() {
        smallQue = new PriorityQueue<>((a,b) -> b-a);
        bigQue = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(smallQue.isEmpty() || num <= smallQue.peek())
            smallQue.add(num);
        else bigQue.add(num);
        
    }
    
    public double findMedian() {
        if(Math.abs(smallQue.size() - bigQue.size()) > 1){
            if(smallQue.size() > bigQue.size()) balanceHeaps(smallQue, bigQue);
            else balanceHeaps(bigQue, smallQue);
        }
        
        if(smallQue.size() > bigQue.size())
            return smallQue.peek();
        else if(bigQue.size() > smallQue.size())
            return bigQue.peek();
        
        return (double) ((smallQue.peek()+bigQue.peek()))/2;
    }
    
    private void balanceHeaps(PriorityQueue<Integer> que1, PriorityQueue<Integer> que2){
        while(Math.abs(que1.size() - que2.size()) > 1){
            que2.add(que1.poll());
        }
    }
}
