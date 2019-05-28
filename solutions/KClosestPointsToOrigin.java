/*** K Closest Points to Origin https://leetcode.com/problems/k-closest-points-to-origin/ ***/
public class Solution {
	public int[][] kClosest(int[][] points, int K) {
		// Input: points = [[1,3],[-2,2]], K = 1
		// Output: [[-2,2]]
		int n = points.length;
		List<Points> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int d = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			Points p = new Points(d, points[i][0], points[i][1]);
            list.add(p);
		}
		Collections.sort(list, new Comparator<Points>() {
			@Override
			public int compare(Points a, Points b) {
				return a.d - b.d;
			}
		});
		int[][] result= new int[K][2];
		
		for(int i=0;i<K;i++) {
			result[i][0]=list.get(i).x;
			result[i][1]=list.get(i).y;
		}
		return result;
	}
}

class Points {
	int d;
	int x, y;

	public Points(int d, int x, int y) {
		this.d = d;
		this.x = x;
		this.y = y;
	}
}