class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int l1 = arr1.length;
        int l2 = arr1[0].length;
        answer = new int[l1][l2];
        for(int i = 0; i < l1; i++)
            for(int j = 0; j < l2; j++)
                answer[i][j] = arr1[i][j] + arr2[i][j];
        
        return answer;
    }
}