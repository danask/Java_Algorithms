package ask.cetificate.advanced;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * 
Inversion Counting

1
5
4 1 3 2 5

4

*/

//http://m.blog.daum.net/rhaoslikesan/282

public class CountingInversions
//public class Solution
{     
         public static void main(String[] args)throws Exception {
                  int T, N;
                  long answer;
 
                 System.setIn(new FileInputStream("E:/WS_java/java_basic/src/ask/cetificate/advanced/inversion_input.txt"));
 
                  Scanner sc = new Scanner(System.in);
                 
                  long t1,t2;
                  T = sc.nextInt();
                  
                  for (int test_case = 1; test_case <= T; test_case++) 
                  {
                           N = sc.nextInt();
                           int[] a = new int[N];
                           for(int i=0;i<N;i++){
                                   a[i] = sc.nextInt();
                           }
                          
//                           t1 = System.currentTimeMillis();
                           answer = countingInversions(a);
//                           t2 = System.currentTimeMillis();
                           System.out.println("#"+test_case+" "+answer);// +" ("+(t2-t1)+" milliseconds)");
                  }
         }
 
         private static long countingInversions(int[] a) 
         {
                  int n = a.length;
                  int[] buf = new int[n];           
                  long cnt = count(a,0,n-1,buf);
                 
                  return cnt;
         }
        
         private static long count(int[] a, int s, int e, int[] buf)
         {
                  if((e-s)<1) {
                           return 0;
                  }       
                 
                  int m = (s+e) / 2;
                  long leftCount = count(a,s,m,buf);
                  long rightCount = count(a,m+1,e,buf);
                  long mergeCount = merge(a,s,m,e,buf);
                  
                  System.arraycopy(buf, s, a, s, (e-s)+1);
                 
                  return leftCount + rightCount + mergeCount;
         }
        
         private static long merge(int[]a,int s, int m, int e, int[] buf)
         {
                  //System.out.println("merge("+s+" "+e+")");
                  int left=s;
                  int right=m+1;
                  long count=0;
                  
                  for(int k=s;k<=e;k++){
                           if(left<=m && ( (right>e) || (a[left] <= a[right]) ) ){
                                   buf[k] = a[left++];                                 
                           }else{
                                   buf[k] = a[right++];
                                   count = count + (m-left+1);
                           }
                  }
                  return count;
         }
        
        
}