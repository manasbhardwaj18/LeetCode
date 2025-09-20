// Last updated: 9/20/2025, 1:04:20 PM
public class Router {

    int limit;
    HashSet<Packet> packets = new HashSet<>();
    Queue<Packet> q = new LinkedList<>();
    HashMap<Integer, List<Integer>> destinationCount = new HashMap<>();

    public Router(int memoryLimit) {
        limit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        boolean flag = packets.add(packet);
        if (!flag) return false;
    
        if (packets.size() > limit) forwardPacket();
    
        q.add(packet);
        if (!destinationCount.containsKey(destination)) {
            destinationCount.put(destination, new ArrayList<>());
        }
        destinationCount.get(destination).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if(packets.isEmpty()) return new int[] {};

        Packet packet = q.poll();
        packets.remove(packet);
        destinationCount.get(packet.destination).remove(0);

        return new int[] {packet.source, packet.destination, packet.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = destinationCount.get(destination);
        if (list == null || list.isEmpty()) {
            return 0;
        }

        int left = 0, right = list.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < startTime) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int startIdx = (list.get(left) >= startTime) ? left : left + 1;

        left = 0;
        right = list.size() - 1;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (list.get(mid) > endTime) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int endIdx = (list.get(left) <= endTime) ? left : left - 1;

        return (startIdx <= endIdx) ? (endIdx - startIdx + 1) : 0;
    }

    static class Packet {
        int source;
        int destination;
        int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet packet = (Packet) o;
            return source == packet.source && destination == packet.destination && timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }
}