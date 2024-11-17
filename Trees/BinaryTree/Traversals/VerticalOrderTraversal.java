class Solution {
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    static ArrayList<Integer> verticalOrder(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int hd = pair.getValue();

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            if (node.left != null) q.offer(new Pair<>(node.left, hd - 1));
            if (node.right != null) q.offer(new Pair<>(node.right, hd + 1));
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int key : map.keySet()) {
            result.addAll(map.get(key));
        }
        
        return result;
    }
}
