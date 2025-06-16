class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size(), m = forest.get(0).size();
        int count = 0;
        
        List<Integer> minList = new ArrayList<>();
        for (List<Integer> al: forest)
            for (int val: al) 
                if (val > 1) 
                    minList.add(val);
        
        Collections.sort(minList);
		
        int totalSteps = 0;
        int si = 0, sj = 0; 
        
        for (int i = 0; i < minList.size(); i++) {
            int target = minList.get(i);
            boolean hasFound = false;
            boolean[][] visited = new boolean[n][m];
			
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{si, sj});
        
            int steps = -1;
            while (!q.isEmpty() && !hasFound) {
                steps++;
				
				int size = q.size();
                while (size -- > 0) {
                    int[] curr = q.poll();
					
                    if (visited[curr[0]][curr[1]]) continue;
                    visited[curr[0]][curr[1]] = true;
                    
                    if (forest.get(curr[0]).get(curr[1]) == 0) continue;
                    
					if (forest.get(curr[0]).get(curr[1]) == target) {
                        si = curr[0];
                        sj = curr[1];
                        hasFound = true;
                        break;
                    }

                    for (int j = 0; j < dy.length; j++) {
                        int y = curr[0] + dy[j];
                        int x = curr[1] + dx[j];
						
                        if (y >= n || x >= m || y < 0 || x < 0 || visited[y][x] || forest.get(y).get(x) == 0)   
                            continue;
                        q.offer(new int[]{y, x});
                    }
                }
            }
            if (steps == -1 || !hasFound) return -1;

			totalSteps += steps;
        }
        return totalSteps;
    }
}