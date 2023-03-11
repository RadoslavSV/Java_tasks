package Problem2;

import java.util.Random;

public class Sequence {
    private Object[] obs;
    private int next = 0;

    public Sequence(int size) {
        obs = new Object[size];
    }
    public void add(Object x) {
        if(next < obs.length) {
            obs[next] = x;
            next++;
        }
    }

    private class SSelectorForward implements SelectorForward {
        private int i = 0;
        public boolean end() {
            return i == obs.length;
        }
        public Object current() {
            return obs[i];
        }
        public void next() {
            if(i < obs.length) i++;
        }
    } // end of inner class

    public SelectorForward getSelectorForward() {
        return new SSelectorForward();
    }

    private class SSelectorBackward implements SelectorBackward {
        private int i = obs.length - 1;
        public boolean begin() {
            return i == -1;
        }
        public Object current() {
            return obs[i];
        }
        public void previous() {
            if(i > -1) i--;
        }
    } // end of inner class

    public SelectorBackward getSelectorBackward() {
        return new SSelectorBackward();
    }

    private class SSelectorTwoWay implements SelectorTwoWay {
        private int i;

        public SSelectorTwoWay(int idx) {
            if(idx>=0 && i<obs.length) this.i = idx;
            else i = 0;
        }

        public Object current() {
            return obs[i];
        }
        public boolean end() {
            return i == obs.length;
        }
        public void next() {
            if(i < obs.length) i++;
        }
        public boolean begin() {
            return i == -1;
        }
        public void previous() {
            if(i > -1) i--;
        }
    }

    public SelectorTwoWay getSelectorTwoWay(int index) {
        return new SSelectorTwoWay(index);
    }

    public static void main(String[] args) {
// (1)създайте Sequence последователност от 8 елемента
        final int SIZE = 8;
        Sequence sequence = new Sequence(SIZE);
// (2)инициализирайте Sequence елементите със случайни цели числа от интервала [10, 100]
        Random random = new Random();
        for(int i=0; i<SIZE; i++) {
            sequence.add(random.nextInt(10,101));
        }
// (3)използвайте метода getSelectorForward(),за да разпечатате тези числа на конзолата
// от първия до последния елемент на последователността
        System.out.println("First to last:");
        SelectorForward forward = sequence.getSelectorForward();
        while(!forward.end()) {
            System.out.printf("%s ", forward.current());
            forward.next();
        }
        System.out.println();
// (4)използвайте метода getSelectorBackward(),за да разпечатате на конзолата тези числа
// от последния елемент до първия на последователността
        System.out.println("Last to first:");
        SelectorBackward backward = sequence.getSelectorBackward();
        while(!backward.begin()) {
            System.out.printf("%s ", backward.current());
            backward.previous();
        }
        System.out.println();
//Two-way
        System.out.println("First to last:");
        SelectorTwoWay way = sequence.getSelectorTwoWay(5);
        while(!way.end()) {
            System.out.printf("%s ", way.current());
            way.next();
        }
        System.out.println();

        System.out.println("Last to first:");
        way.previous();
        while(!way.begin()) {
            System.out.printf("%s ", way.current());
            way.previous();
        }
        System.out.println();
    }
}
