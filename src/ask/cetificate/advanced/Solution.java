package ask.cetificate.advanced;

/*
어떤 단어가 뒤에서 앞으로 거꾸로 썼을 때 원래의 단어와 같으면 이를 팰린드롬이라고 한다.
콩순이는 알파벳 소문자로 이루어진 자리 단어를 가지고 있다.
콩순이는 팰린드롬을 좋아하기 때문에, 이 단어를 재구성하여 새로운 단어를 만들고
그 단어의 부분문자열 중에서 팰린드롬인 것들의 개수를 최대화하고 싶어한다.

부분문자열이란 어떤 문자열에서 연속한 일부분을 뽑아내 만든 문자열을 의미한다.
예를 들어 “abc”의 부분문자열은 “a”, “b”, “c”, “ab”, “bc”, “abc”의 6개가 있다.
단, 구성이 같은 부분문자열이더라도 팰린드롬의 개수를 셀 때는 다른 것으로 보고
그 개수를 세줘야 한다. 예를 들어 “aaa”의 부분 문자열은
“a”, “a”, “a”, “aa”, “aa”, “aaa”로 “a”가 3개,
“aa”가 2개이지만 서로 다른 것으로 보고 모두 개수를 세줘야 한다.


[입력]
각 테스트 케이스의 첫 번째 줄에는 단어 가 주어진다.
이 단어는 알파벳 소문자 만으로 이루어져 있고, 길이는 이상 10 이하이다.

[출력]
각 테스트 케이스마다 주어진 문자열을 재구성하였을 때
만든 단어의 부분문자열 중에서 팰린드롬인 것의 개수를 최대화하였을 때의 부분문자열 중
팰린드롬의 수를 출력하라.


3
abc
aaa
abcabc

3
6
9



*/

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int[] cnt;
	static String input;
	static int sum = 0;
         
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("E:/WS_java/java_basic/src/ask/cetificate/advanced/input.txt"));

		Scanner sc = new Scanner(System.in);
	    
		int T;
		T=sc.nextInt();
         
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			input = sc.next();                      
			char[] arr = new char[input.length()];
			cnt = new int[26];
			
			for(int i=0; i<arr.length;i++)
			{
				arr[i] = input.charAt(i);
			}
			             
			calculateDigitNumber(arr);
			
			for(int i=0;i<cnt.length;i++)
			{
				if(cnt[i]!=0)
				{
					sum+= cnt[i]*(cnt[i]+1)/2;
				}
			}
			             
			System.out.println(sum);
			sum = 0;
		}   
		sc.close();
	}
     
	public static void calculateDigitNumber(char[] arr)
	{
		for (int i = 0; i<arr.length; i++)
		{
			cnt[arr[i]-'a']++;
			//System.out.println("cnt[arr["+i+"] : "+arr[i]+" "+cnt[arr[i]]);
		}
	}
     
}





/*

#include <stdio.h>
#define NMAX 20
#define SIZE 2000

char inputWord_org[NMAX] = { 0 };
char inputWord[NMAX] = { 0 };

int N = 0;
int chosen[NMAX] = { 0 };
//char input[3] = { 'a', 'b', 'c'};

char testWords[SIZE][NMAX] = { 0 };

int cases = 1;
int flag = 0;

void powerset(int chosen[], int count)
{
	if (count == N + 1)
	{
		for (int i = 1, j = 1; i <= count; i++)
		{
			if (chosen[i] && inputWord[i] != NULL)
			{
				//printf("%d %d\n", count, chosen[i - 1]);
				//printf("%d %d %d %c\n", count, j, chosen[i - 1], inputWord[i]);

				if (j == 1 || j > 1 && chosen[i - 1])
				{
					//printf(" %d : %c ", i, inputWord[i]);
					testWords[cases][j] = inputWord[i];
					//printf("1> %d : %d %c \n", cases, j, testWords[cases][j]);
					//printf("2> %d : %s \n", cases, testWords[cases]);

					flag = 1;
					j++;
				}
				//else
					//flag = 0;
			}
		}

		if (flag)
		{
			cases++;
			flag = 0;
		}

		//puts("");

	}
	else
	{
		chosen[count] = 0;
		powerset(chosen, count + 1);

		chosen[count] = 1;
		powerset(chosen, count + 1);
	}
}


int getCount(char word[])
{
	int count = 0;

	while (word[count] != NULL)
	{
		count++;
	}
	return count;
}


int getCount_testWords(int x)
{
	int count = 1;

	while (testWords[x][count] != NULL)
	{
		//printf("%c", testWords[x][count]);
		count++;
	}
	//printf("\n");

	return count - 1;
}


int main(void)
{
	int test_case;
	int T;

	freopen("input.txt", "r", stdin);

	setbuf(stdout, NULL);
	scanf("%d", &T);

	for (test_case = 1; test_case <= T; ++test_case)
	{
		// INIT
		int count = 0;
		int flag = 0;
		int sum = 0;
		N = 0;
		cases = 1;

		for (int x = 0; x < NMAX; x++)
		{
			inputWord[x] = 0;
			inputWord_org[x] = 0;
			chosen[x] = 0;

			for (int y = 0; y < NMAX; y++)
				testWords[x][y] = 0;
		}

		int countAtoZ['z' + 1] = { 0 };

		for (int i = 'a'; i <= 'z'; i++)
			countAtoZ[i] = 0;



		// INPUT
		scanf("%s", inputWord_org);
		//printf("%s\n", inputWord_org);


		// LOGIC
		N = getCount(inputWord_org);
		//printf("inputWord_org : %d\n", N);


		for (int i = 0; i < N; i++)
		{
			inputWord[i + 1] = inputWord_org[i];
		}

		//printf("%s %d\n", inputWord, count);

#if 1
		// powerset
		powerset(chosen, 1);


		// powerset result

		for (int x = 1; x < cases; x++)
		{
			count = getCount_testWords(x);
			flag = 0;
			//printf("count : %d\n", count);

			if (count == 1)
				;

			else if (count % 2) // odd number
			{
				int med = (int)count / 2 + 1; // 5/2 + 1 = 3

				for (int i = 1, j = count; i < med, j >= med + 1; i++, j--) // 1 2
				{
					//printf("odd : %c == %c\n", testWords[x][i], testWords[x][j]);
					//if (testWords[x][i] != '?' && testWords[x][j] != '?')
					{
						if (testWords[x][i] != testWords[x][j])
						{
							flag = 1;
							break;
						}

						if (flag)
							break;
					}
				}
			}
			else
			{
				int med = (int)count / 2; // 4/2 = 2

				for (int i = 1, j = count; i <= med, j >= med + 1; i++, j--) // 1 2
				{
					//printf("even : %c == %c\n", testWords[x][i], testWords[x][j]);
					//if (testWords[x][i] != '?' && testWords[x][j] != '?')
					{
						if (testWords[x][i] != testWords[x][j])
						{
							flag = 1;
							break;
						}

						if (flag)
							break;
					}
				}
			}

			if (flag == 0 && count != 0)
			{
				//printf("Exist\n");
				sum++;
			}
		}
#else
		
		for (int i = 1; i <= N; i++)
		{
			if (inputWord[i])
				countAtoZ[inputWord[i]]++;
		}

		for (int j = 'a'; j <= 'z'; j++)
		{
			int n = countAtoZ[j];

			//printf("%c %d\n", j, countAtoZ[j]);
			sum += n * (n + 1) / 2;
		}
#endif


		// RESULT
		printf("%d\n", sum);

	}
	return 0;
}
*/


/*

abba
aaaaaaaaaa
qewjhgposf
fqqetlynpp
xwefalxngr
aabc
abac
abca
x
lcdctglrtr
dwshfesktg
rnlsrlgpgw
nptftgtytg
kkrtxxxxtr
dcjjqmutdd
tckchckcgc
nolpeuvssc
nzzwmmwuxs
uturfuqmns
duxtiiaait
eaxvpiyjhu
hzkzjzkzqz
lcvxjqazgp
tldlyldlvl
cmmjkxlnat

6
55
10
12
11
5
5
5
1
14
11
13
17
19
14
21
11
13
13
15
10
21
10
21
11

*/