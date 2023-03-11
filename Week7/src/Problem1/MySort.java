package Problem1;

public class MySort {
    private Sortable callback;

    public MySort(Sortable callback) {
        setCallback(callback);
    }

    public MySort() {
        this(new Sortable() {
            @Override
            public boolean greater(int a, int b) {
                return a > b; //upwards by default
            }
        });
    }

    public Sortable getCallback() {
        return callback;
    }

    public void setCallback(Sortable callback) {
        if(callback!=null) {
            this.callback = callback;
        } else {
            this.callback = new Sortable() {
                @Override
                public boolean greater(int a, int b) {
                    return a > b; //upwards by default
                }
            };
        }
    }

    public void sort(int[] numbers) {
        int swap;
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=0; j<numbers.length-i-1; j++) {
                if(callback.greater(numbers[j], numbers[j+1])) {
                    swap = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = swap;
                }
            }
        }
    }
}
