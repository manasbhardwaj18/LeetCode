class Solution {
    public int[] operateJug(String action, int maxX, int maxY, int curX, int curY) {
        switch (action) {
            case "fill_x":
                return new int[] {maxX, curY};
            case "fill_y":
                return new int[] {curX, maxY};
            case "pour_x":
                return new int[] {0, curY};
            case "pour_y":
                return new int[] {curX, 0};
            case "x_to_y":
                return new int[] {Math.max(curX - Math.min(maxY - curY, maxX), 0), Math.min(curX + curY, maxY)};
            case "y_to_x":
                return new int[] {Math.min(curX + curY, maxX), Math.max(curY - Math.min(maxX - curX, maxY), 0)};
        }
        return new int[] {0, 0};
    }

    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y == target || x == target || y == target) {
            return true;
        }

        String[] operations = {"fill_x", "fill_y", "pour_x", "pour_y", "y_to_x", "x_to_y"};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int x1 = state[0], y1 = state[1];

            String currentState = x1 + "-" + y1;
            if (visited.contains(currentState)) {
                continue;
            }

            if (x1 == target || y1 == target || x1 + y1 == target) {
                return true;
            }

            visited.add(currentState);

            for (String operation : operations) {
                int[] next = operateJug(operation, x, y, x1, y1);
                queue.offer(next);
            }
        }

        return false;
    }
}