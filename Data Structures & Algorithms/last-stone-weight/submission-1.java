class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b,a));

        for(int i : stones){
            pq.add(i);
        }

        while(pq.size()!=1){
            int x = pq.remove();
            // pq.remove();
            int y = pq.remove();
            // pq.remove();
            pq.add(Math.abs(x-y));
        }
        return pq.peek();

    }
}
