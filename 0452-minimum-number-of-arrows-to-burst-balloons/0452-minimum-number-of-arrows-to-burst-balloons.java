class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int[][] balloons = new int[n][2];
        balloons[0] = points[0];
        int balloonIndex = 0;

        for (int i = 1; i < n; i++) {
            int currStartPoint = points[i][0];
            int currEndPoint = points[i][1];

            int prevStartPoint = balloons[balloonIndex][0];
            int prevEndPoint = balloons[balloonIndex][1];

            if (currStartPoint > prevEndPoint) {
                balloons[++balloonIndex] = points[i];
            } else {
                balloons[balloonIndex][0] = Math.max(prevStartPoint, currStartPoint);
                balloons[balloonIndex][1] = Math.min(prevEndPoint, currEndPoint);
            }
        }
        return balloonIndex + 1;

    }
}