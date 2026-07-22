class Solution {
    
    private class Node{

        public int xcord;
        public int ycord;
        public double dist;

        Node(int x, int y){
            xcord = x;
            ycord = y;
            dist = Math.sqrt((xcord*xcord + ycord*ycord));
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> Double.compare(b.dist, a.dist));

        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            Node temp = new Node(x,y);
            pq.add(temp);
            System.out.println(pq.peek().xcord);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++){
            int x = pq.peek().xcord;
            int y = pq.peek().ycord;
            pq.poll();
            ans[i][0] = x;
            ans[i][1] = y;
        }

        return ans;

    }
}
