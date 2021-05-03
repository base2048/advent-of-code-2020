package day23;

import java.util.*;

public class CupList implements Iterable<Integer> {

    public static class Cup {
        public int label;
        public Cup nextCup;

        private Cup(int label) {
            this.label = label;
        }
    }

    private Cup head = null;
    private Cup tail = null;
    private final Map<Integer, Cup> cupByLabel = new HashMap<>();

    public CupList() {
    }

    public CupList(CupList initial) {
        addAll(initial);
    }

    public CupList addAll(CupList list) {
        list.forEach(this::add);
        return this;
    }

    public void add(int label) {
        Cup newCup = new Cup(label);

        if (head == null) head = newCup;
        else tail.nextCup = newCup;

        tail = newCup;
        tail.nextCup = head;
        cupByLabel.put(label, newCup);
    }

    public void insert(Cup firstCup, Cup lastCup, Cup destinationCup) {
        if (destinationCup == tail) {
            tail.nextCup = firstCup;
            tail = lastCup;
            lastCup.nextCup = head;
            return;
        }

        lastCup.nextCup = destinationCup.nextCup;
        destinationCup.nextCup = firstCup;
    }

    public void removeNextThree(Cup openChainLeftCup) {
        boolean isHeadRemoved = isHeadRemoved(openChainLeftCup.nextCup);
        boolean isTailRemoved = isTailRemoved(openChainLeftCup.nextCup);

        Cup openChainRightCup = openChainLeftCup.nextCup.nextCup.nextCup.nextCup;

        if (isHeadRemoved) {
            tail = isTailRemoved ? openChainLeftCup : tail;
            tail.nextCup = head = openChainRightCup;
            return;
        }

        if (isTailRemoved) {
            tail = openChainLeftCup;
            tail.nextCup = head;
            return;
        }

        openChainLeftCup.nextCup = openChainRightCup;
    }

    private boolean isHeadRemoved(Cup firstCup) {
        return firstCup == head || firstCup.nextCup == head || firstCup.nextCup.nextCup == head;
    }

    private boolean isTailRemoved(Cup firstCup) {
        return firstCup == tail || firstCup.nextCup == tail || firstCup.nextCup.nextCup == tail;
    }

    public int size() {
        return cupByLabel.size();
    }

    public Cup getHead() {
        return head;
    }

    public Cup getTail() {
        return tail;
    }

    public Cup getCupByLabel(int label) {
        return cupByLabel.get(label);
    }

    public CupList clone() {
        CupList clone = new CupList();
        for (Integer label : this)
            clone.add(label);

        return clone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Integer> it = this.iterator();

        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int ctr = 0;
            private Cup currentCup = head;

            @Override
            public boolean hasNext() {
                return ctr < cupByLabel.size();
            }

            @Override
            public Integer next() {
                ctr++;
                int label = currentCup.label;
                currentCup = currentCup.nextCup;
                return label;
            }
        };
    }
}
