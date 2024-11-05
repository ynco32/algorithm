package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA8382 {

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int x1, x2, y1, y2;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;

			ans = Integer.MAX_VALUE;
			if (x1 == x2 && y1 == y2)
				ans = 0;
			else {
				bfs(x1, y1, 0);
				bfs(x1, y1, 1);
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	static void bfs(int r, int c, int dir) {
		boolean[][][] visited = new boolean[201][201][2];
		visited[r][c][dir] = true;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c, dir, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int nd;

			if (cur[2] == 0)
				nd = 1;
			else
				nd = 0;

			for (int d = 0; d < 4; d++) {
				if (d % 2 == cur[2])
					continue;

				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (nr > 200 || nc > 200 || nr < 0 || nc < 0 || visited[nr][nc][nd])
					continue;

				if (nr == x2 && nc == y2)
					ans = Math.min(ans, cur[3] + 1);

				visited[nr][nc][nd] = true;
				q.offer(new int[] { nr, nc, nd, cur[3] + 1 });

			}

		}

	}

}
