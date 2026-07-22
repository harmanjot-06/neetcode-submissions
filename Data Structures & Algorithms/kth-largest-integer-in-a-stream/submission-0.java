class KthLargest {

    PriorityQueue<Integer> pq;
    int size = 0;
    int kl;
    public KthLargest(int k, int[] nums) {
        kl=k;
        pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i);
            size++;
            if(size>k){
                pq.poll();
                size--;
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        size++;
        if(size>kl){
            pq.poll();
            size--;
        }
        return pq.peek();
    }
}
