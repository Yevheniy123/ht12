import java.util.Iterator;

public interface Collection {
    Iterator getIterator();
    boolean add(Object object);
    boolean add(int index, Object object);
    boolean delete(Object object) throws Exception;
    boolean delete(int index);
    Object get(int index);
    boolean contain(Object object);
    boolean equals(Collection str);
    boolean clear();
    int size();
}
