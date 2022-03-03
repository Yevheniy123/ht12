import java.util.Arrays;
import java.util.Iterator;

public class MyObjectCollection implements Collection {
    private Object[] objectCollection;
    private int count;
    protected final int startSize = 10;

    public MyObjectCollection() {
        objectCollection = new Object[startSize];
        count = 0;
    }

    public MyObjectCollection(int size) {
        objectCollection = new Object[size];
        count = 0;
    }

    @Override
    public Iterator getIterator() {
        return null;
    }

    @Override
    public boolean add(Object object) {
        if (count + 1 > objectCollection.length) changeSize();
        objectCollection[count++] = object;
        return true;
    }

    @Override
    public boolean add(int index, Object object) {
        if (count + 2 > objectCollection.length) changeSize();
        if (index > count || index < 0) return false;
        if (count + 1 - index >= 0) System.arraycopy(objectCollection, index, objectCollection, index + 1,
                count + 1 - index);
        objectCollection[index] = object;
        count++;
        return true;
    }

    @Override
    public boolean delete(Object object) {
        int temp = -1;
        for (int i = 0; i <= count; i++) {
            try {
                if (objectCollection[i].equals(object)) {
                    temp = i;
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("This element is not existing!");
            }
        }
        try {
            delete(temp);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index > objectCollection.length) return false;
        else {
            if (count - index >= 0)
                try {
                    System.arraycopy(objectCollection, index + 1, objectCollection, index, count - index);
                    count--;
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
        }
        return true;
    }

    @Override
    public Object get(int index) {
        if (index > count || index < 0) throw new ArrayIndexOutOfBoundsException("Index cannot be more " +
                "than array size or have negative values!");
        else return objectCollection[index];
    }

    @Override
    public boolean contain(Object object) {
        for (Object el : objectCollection) if (object.equals(el)) return true;
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        if (this.getClass() != str.getClass()) return false;
        if (this.size() != str.size()) return false;
        if (str == this) return true;
        MyObjectCollection collection = (MyObjectCollection) str;
        return Arrays.equals(this.objectCollection, collection.objectCollection) && (this.count == collection.count);
    }

    @Override
    public boolean clear() {
        if (objectCollection.length == startSize) {
            objectCollection = new Object[startSize];
            count = 0;
        } else {
            objectCollection = new Object[objectCollection.length];
            count = 0;
        }
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    private void changeSize() {
        int sizeObject = objectCollection.length * 2 / 3 + 1;
        Object[] rescaledArray = new Object[objectCollection.length + sizeObject];
        System.arraycopy(objectCollection, 0, rescaledArray, 0, objectCollection.length);
        objectCollection = rescaledArray;
    }

    /*public void setObjectCollection(Object[] objectCollection) {
        this.objectCollection = objectCollection;
    }*/

    /*public Object[] getObjectCollection() {
        return objectCollection;
    }

    public void print() {
        for (Object el : objectCollection) System.out.println(el);
    }*/

    @Override
    public String toString() {
        return "MyObjectCollection {" +
                "objectCollection = " + Arrays.toString(objectCollection) +
                ", count = " + count +
                '}';
    }

}
