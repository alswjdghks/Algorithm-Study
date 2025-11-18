/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine()); // 834 덤프 횟수
            int[] dump_arr = new int[100];
            st = new StringTokenizer(br.readLine());
            
			for(int i = 0 ; i < 100 ; i++){
            	dump_arr[i] = Integer.parseInt(st.nextToken());
            }
			
            int min_value = 101;
            int max_value = 0;
            int max_idx = 0;
            int min_idx = 0;
                     
            while(N != 0 && (max_value - min_value != 1)){
            	 for(int i = 0 ; i < 100 ; i++){
            		if (dump_arr[i] > max_value ){
                		max_value = dump_arr[i];
                    	max_idx = i;
                	} else if (dump_arr[i] < min_value){
                		min_value = dump_arr[i];
                    	min_idx = i;
                	}
            	}
            	max_value = --(dump_arr[max_idx]);
                min_value = ++(dump_arr[min_idx]);
                 N--;
			}
            
            for(int i = 0 ; i < 100 ; i++){
            	if (dump_arr[i] > max_value ){
                	max_value = dump_arr[i];
                } else if (dump_arr[i] < min_value){
                	min_value = dump_arr[i];
                } 
        	}
            
            System.out.println("#" + test_case + " " + (max_value - min_value) );
        }
	}
}