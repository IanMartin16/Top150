import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    private Queue<Integer> requestQueue;

    public RecentCounter() {
        requestQueue = new LinkedList<>();
    }

    public int ping(int t) {
        requestQueue.add(t);
        while (!requestQueue.isEmpty() && requestQueue.peek() < t - 3000) {
            requestQueue.poll();
        }
        return requestQueue.size();
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));    // 1
        System.out.println(counter.ping(100));  // 2
        System.out.println(counter.ping(3001)); // 3
        System.out.println(counter.ping(3002)); // 3
    }
}


//You have a RecentCounter class which counts the number of recent requests within a certain time frame.

//Implement the RecentCounter class:

//RecentCounter() Initializes the counter with zero recent requests.
//int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, 
//and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). 
//Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
//It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.