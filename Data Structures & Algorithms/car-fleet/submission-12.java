class Solution {

    public boolean catchup(int pos1, int pos2, int speed1, int speed2, int target){

        float time1 = ((float) (target-pos1)) / speed1;
        float time2 = ((float) (target-pos2)) / speed2;

        if(time1<=time2)return true;
        return false;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        int fleece = 1;
        int tocompare = n-1;
        for(int i = n-2; i>=0; i--){

            if(!catchup(arr[i][0], arr[tocompare][0], arr[i][1], arr[tocompare][1], target)){
                fleece++;
                tocompare = i;
            }
        }

        return fleece;
    }
}
