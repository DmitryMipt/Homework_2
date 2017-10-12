import java.util.HashSet;
import java.util.Set;

public class MyStructure {
    private int size;
    private int[] set;
    private int index;

    public MyStructure() {
        this.size = 1;
        this.index = 0;
        this.set = new int[size];
        }

    public void add(int x) {
      //  System.out.println(set.length-1);

        if (index == size) {
            resize(set);
        }
        set[index] = x;
        index++;
        set=moreSize(set);

    }
    private int[] moreSize (int[] array) {
        size+=1;
        int[] newArray = new int[size];
        System.arraycopy(array, 0, newArray, 0, size-1);
        return newArray;
    }

    public int getSize() {
        return size;
    }

    private int[] resize(int[] array) {
        int[] newSet = new int[size * 2];
        size = size*2;
        System.arraycopy(set, 0, newSet, 0, index - 1);
        return newSet;
    }

    public int delete() {
      //for (int i = 1; i <= set.length - 1; i++) System.out.println(set[i]);
        int min = findMin(set);
        //System.out.println(size);
        for (int i = 0; i < size - 1; i++) {
            if (set[i] == min) {
                for (int j = i; j < size - 1; j++) {
                    set[j] = set[j + 1];
                }
                size--;
                index--;
                break;
            }
       //     for (int l = 1; l <= set.length - 1; l++) System.out.println(set[l]);

        }
        return min;
    }


    private int findMin(int[] mas) {
        int min = mas[0];
        for (int i = 1; i <= size - 2; i++) {
            if (mas[i] < min) min = mas[i];
        }

        return min;
    }
}













