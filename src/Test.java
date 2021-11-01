class Solution {
    public int rank(int num){
        switch(num){
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 6;
        }
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int cnt = 0;
        for( int i = 0 ; i < lottos.length; i++ ){
            if( lottos[i] == 0 ){
                zero++;
            }
            for( int j = 0 ; j < win_nums.length; j++ ){
                if( lottos[i] == win_nums[j] ){
                    cnt++;
                }
            }
        }

        answer[0] = rank(cnt+zero);
        answer[1] = rank(cnt);

        return answer;
    }
}