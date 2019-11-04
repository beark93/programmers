/**
 * level1_27
 */

import java.util.Arrays;
public class level1_27 {

    public static int[] solution(int n, int m) {
        int[] answer = {1,1};

        // 작은수 보다 작은 소수
        int min = (n<m) ? n : m;
        int[] sosu_arr = sosu(min);

        // 두 수가 각 소수로 나누어 떨어질 경우 다 곱해준다 (최대 공약수)
        for(int i=0;i<sosu_arr.length;i++) {
            while(n%sosu_arr[i] == 0 && m%sosu_arr[i] == 0) {
                n /= sosu_arr[i];
                m /= sosu_arr[i];
                
                answer[0] *= sosu_arr[i];
            }
        }

        // 최대공약수와 위 과정에서 남은 2수의 곱 (최소공배수)
        answer[1] = n*m*answer[0];

        return answer;
    }

    public static int[] sosu(int n) {
        int cnt = n-1;
        boolean sosu[] = new boolean[n+1];
        for (int i = 2; i*i <= n; i++) {
            if(sosu[i] == false) {
                for (int j = i*i; j <= n; j += i) {
                    if(sosu[j] == false) {
                        sosu[j] = true;
                        cnt--;
                    }
                }
            }
        }
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=2; i<=n;i++) {
            if(!sosu[i]) answer[idx++] = i;
        }
        return answer;
    }

    /**
     * 호제법을 이용한 풀이
     */
    public static int[] gcdlcm(int a, int b) {
        int[] answer = new int[2];

        answer[0] = gcd(a,b);
        answer[1] = (a*b)/answer[0];

        return answer;
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p%q);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24,36)));
        System.out.println(Arrays.toString(gcdlcm(24,36)));
    }
}