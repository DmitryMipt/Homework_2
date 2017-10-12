public interface MyCollection<Type> {
    void add(Type i);
    void clear();
    void remove(int i);
    boolean contains(Type a);
    int size();

}
