import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        // 숫자 담을 list
        List<Character> list = new ArrayList<>();
        list.add('0');
        
        int num = 1; // 1부터 셀 숫자
        // t*m 을 넘을 때까지 반복
        while(list.size() < t*m){
            String str = changeToN(n, num++);
            for(int i=str.length()-1;i>=0;i--){
                list.add(str.charAt(i));
            }
        }
        
        int next=1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t*m;i++){
            if(next%m == p%m){
                sb.append(list.get(i));
            }      
            next+=1;
        }
        
        return sb.toString();
    }
    
    public String changeToN(int n, int target){
        StringBuilder sb = new StringBuilder();        
        
        while(target > 0){
            int remain = target % n;
            if(target%n < 10) sb.append(target%n);
            else if(target%n == 10) sb.append('A');
            else if(target%n == 11) sb.append('B');
            else if(target%n == 12) sb.append('C');
            else if(target%n == 13) sb.append('D');
            else if(target%n == 14) sb.append('E');
            else if(target%n == 15) sb.append('F');
            target /= n;            
        }
        
        return sb.toString();
    }
}

/*
7
3 - 1
1 - 1
0 - 1
*/

/*
내 차례
p

다시 돌아오는 내 차례
현재 순서 변수 next=1
next%m == p%m 이면 내 차례.

내 차례일 때마다 리스트에 저장. t개 차면 return.

t*m 사이즈 리스트.
숫자 -> n진법으로 바꾸는 1번함수(){}

1번 함수 결과를 리스트에 추가.
리스트 사이즈가 t*m과 같아진다면 내 차례 숫자 모아서 return.

*/