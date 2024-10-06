class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if(s1.length() < s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        Deque<String> d1 = new LinkedList();
        Deque<String> d2 = new LinkedList();

        for(String s : s1.split(" ")){
            d1.offerFirst(s);
        }

        for(String s : s2.split(" ")){
            d2.offerFirst(s);
        }

        while(!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().equals(d2.peekLast())){
            d1.pollLast();
            d2.pollLast();
        }

        while(!d1.isEmpty() && !d2.isEmpty() && d1.peekFirst().equals(d2.peekFirst())){
            d1.pollFirst();
            d2.pollFirst();
        }

        return d2.isEmpty();

    }
}
