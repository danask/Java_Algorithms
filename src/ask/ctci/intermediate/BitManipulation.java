package ask.ctci.intermediate;

public class BitManipulation
{

	public static void main(String[] args)
	{
	}

}

/*

5.5 Write a function to determine the number of bits required to convert integer A to integer B.
EXAMPLE
Input: 31,14
Output: 2 pg 2 5 0

5.5
int a, b;
a -> b, bit change count ?

1011
1001
-> 1

1010
1001
-> 2
a, b 서로 다른 비트의 개수

int tmp = a ^ b;
int v = 1;
int count = 0;
for(int i=0; i<32; i++)
{
    count = v & tmp != 0 ? count + 1 : count;
    v = v << 1;
}


5.4 ((n & (n-1)) == 0)

1010101010
1010101001
1010101000

1111111111
1111111110

1111111110

1100000000
1011111111
1000000000

1000000000
0111111111
0000000000

10000000
-> 0

00000000
-> 0

100000
2의 제곱수


5.6

010110
-> 
 1 1 0
0 0 1
 ->
 0 0 1
1 1 0
101001

int odd = 10101010 & v -> 0xAAAAAAAA

int even = 01010101 & v -> 0x55555555

int output = odd >> 1 | even < 1



5.7 An array A contains all the integers from 0 to n, except for one number which is missing. In this problem, we cannot access an entire integer in A with a single operation. The elements of A are represented in binary, and the only operation we can use to access them is "fetch the jth bit of A[i]," which takes constant time. Write code to find the missing integer. Can you do it in 0(n) time?

5.7 
10진수 n

1 ~ 100
숫자 99개 주어질 경우,
o(N) 시간복잡도에서, 빠진 숫자를 찾아라.

숫자당 한번씩,정렬 안됨

int sum = 0;
int sum2 = 0;
int i = 1;
for(; i<=len; i++) {
    sum += i;
    sum2 += arr[i];   
}
sum += (len+1);
int v = sum - sum2;


/*
int v = 0;
for(imt i=0; i<len; i++) {
    v = v ^ arr[i];   
}
if(n %2 == 1)
    v = v ^ (N+1)
return v;
*/

