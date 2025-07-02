class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Event> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        
        for (String content : logs) {
            Event event = new Event(content);
            if (event.getIsStart()) {
                stack.push(event);
            } else {
                Event top = stack.pop();
                result.set(top.getId(), result.get(top.getId()) + (event.getTime() - top.getTime() + 1));
                if (!stack.isEmpty()) {
                    result.set(stack.peek().getId(),
                            result.get(stack.peek().getId()) - (event.getTime() - top.getTime() + 1));
                }
            }
        }
        
        int[] resultArray = new int[n];
        for (int i = 0; i < n; i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}

public class Event {
    private int id;
    private boolean isStart;
    private int time;

    public Event(String content) {
        String[] strs = content.split(":");
        this.id = Integer.parseInt(strs[0]);
        this.isStart = strs[1].equals("start");
        this.time = Integer.parseInt(strs[2]);
    }

    public int getId() {
        return this.id;
    }

    public boolean getIsStart() {
        return this.isStart;
    }

    public int getTime() {
        return this.time;
    }
}