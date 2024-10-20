package gold.step2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ19236 {

	 static class Shark {
	        int x, y, dir;

	        public Shark(int x, int y, int dir) { //상어
	            this.x = x;
	            this.y = y;
	            this.dir = dir;
	        }
	    }
	
	static class Fish {
		int r, c, dir;

		public Fish(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
	}

	static int[] dr = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };

	static int[][] map;
	static boolean[] eaten;
	static Fish[] list;
	static int ans;
	static int sharkR, sharkC, sharkD;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[4][4];
		list = new Fish[17];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int fidx = Integer.parseInt(st.nextToken());
				int fdir = Integer.parseInt(st.nextToken());

				list[fidx] = new Fish(i, j, fdir);
				map[i][j] = fidx;
			}
		}
		System.out.println(Arrays.toString(list));

		sharkR = 0;
		sharkC = 0;
		sharkD = 0;
		int ans = 0;
		eaten = new boolean[17];
		eaten[map[0][0]] = true;
		eatFish(0, 0, 0, false);

		System.out.println(ans);
	}

	private static void eatFish(int r, int c, int cur, boolean isEmpty) {
		System.out.println("eat!!     " + r + " , " + c);
		int idx = map[r][c];

		int now = cur;
		sharkR = r;
		sharkC = c;
		if (!isEmpty) {
			now += idx;
			sharkD = list[idx].dir;
		}

		for (int i = 1; i <= 16; i++) {

			Fish fish = list[i];

			if (fish == null)
				continue;

			for (int d = 0; d < 8; d++) {
				int nd = fish.dir + d;
				if (nd > 8)
					nd -= 8;

				int nnr = fish.r + dr[nd];
				int nnc = fish.c + dc[nd];

				if (nnr < 0 || nnc < 0 || nnr >= 4 || nnc >= 4)
					continue;

				// 상어가 있는 칸이 아님
				if (nnr != r && nnc != c) {
					map[nnr][nnc] = i;
					fish.r = nnr;
					fish.c = nnc;
					fish.dir = nd;
					break;
				}
			}
		}

		int nr = sharkR + dr[sharkD];
		int nc = sharkC + dc[sharkD];

		while (nr >= 0 && nc >= 0 && nr < 4 && nc < 4) {
			if (!eaten[map[nr][nc]]) {
				eaten[map[nr][nc]] = true;
				eatFish(nr, nc, now, false);
				eaten[map[nr][nc]] = false;
			}
			else {
				eatFish(nr, nc, now, true);
			}
			nr += dr[sharkD];
			nc += dc[sharkD];
		}

		ans = Math.max(now, ans);

	}

}
