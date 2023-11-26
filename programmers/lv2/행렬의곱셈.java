class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int l1 = arr1.length;
        int l2 = arr2[0].length;
        int l3 = arr2.length;
        int[][] answer = new int[l1][l2];
        for(int i = 0; i < l1; i++) {
            for(int j = 0; j < l2; j++) {
                for(int k = 0; k < l3; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j]; 
                }
            }            
        }
        return answer;
    }
}