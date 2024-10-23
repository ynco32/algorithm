package boj.gold.step5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2467 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] liquid = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(liquid);
		int left = 0;
		int right = N - 1;

		int ansS = left;
		int ansL = right;

		long res = Long.MAX_VALUE;

		while (left < right) {
			long cur = liquid[left] + liquid[right];

			if (Math.abs(cur) < res) {
				ansS = left;
				ansL = right;
				res = Math.abs(cur);
			}

			if (cur == 0)
				break;
			else if (cur < 0) {
				left++;
			} else if (cur > 0) {
				right--;
			}

		}

		System.out.println(liquid[ansS] + " " + liquid[ansL]);
	}

}
