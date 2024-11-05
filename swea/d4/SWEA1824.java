package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1824 {

	static int R, C;
	static char[][] map;
	static int memory;
	static boolean ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];

			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}

			bfs();

		}

	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {

			int[] current = q.poll();
			int cr = current[0];
			int cc = current[1];

			if (map[cr][cc] == '<') {
				int nr = cr;
				int nc = cc - 1;

				if (cc < 0)
					cc = C - 1;

				q.offer(new int[] { nr, nc });

			}

			else if (map[cr][cc] == '>') {
				int nr = cr;
				int nc = cc + 1;
				
				if (cc == C)
					cc = 0;
				
				q.offer(new int[] { nr, nc });

			}

			else if (map[cr][cc] == '^') {
				int nr = cr-1;
				int nc = cc;
				
				if (cr < 0)
					cr = R - 1;
				
				q.offer(new int[] { nr, nc });

			}

			else if (map[cr][cc] == 'V') {
				int nr = cr + 1;
				int nc = cc;
				
				if (cr == R)
					cr = 0;
				
				q.offer(new int[] { nr, nc });

			}

			else if (map[cr][cc] == '_') {

			}

			else if (map[cr][cc] == '|') {

			}

			else if (map[cr][cc] == '?') {

			}

			else if (map[cr][cc] == '.') {

			} else if (map[cr][cc] == '@') {

			}

			else {

			}

		}

	}

}
