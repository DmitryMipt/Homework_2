public class MyList<Type> implements MyCollection<Type> {
    private int size=10;
    private Object [] array = new Object[size];
    private int index=0;
    private int default_size=16;

    public MyList(int size) {
        this.size = size;
    }

    public MyList() {
        this.array = array;
        this.size = default_size;
    }

    @Override
    public void clear() {
        for(int i=0;i<size;i++)
            array[i]=null;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Type item) {
        if(index==array.length-1) {
            resize(array);
        }
            array[index]= item;
            index++;
            size++;




           }


    private Object[] resize(Object[] array) {
        Object[] newArray = new Object[array.length*2];
        System.arraycopy(array, 0, newArray, 0, index - 1);
        return newArray;
    }

    @Override
    public void remove(int ind) {
        for (int i=ind; i<size-1 ;i++) array[i] = array[i + 1];
            array[size]=null;
             }

    @Override
    public boolean contains(Type item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                return true;
            }

        }
        return false;
    }

    public Type get(int index) {
        return (Type) array[index];

    }
}

