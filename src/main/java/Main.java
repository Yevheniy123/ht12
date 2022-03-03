import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        final int amount = 25;

        MyObjectCollection objectCollection = new MyObjectCollection();
        MyObjectCollection objectCollectionSize = new MyObjectCollection(15);
        MyObjectCollection objectCollectionIndex = new MyObjectCollection();
        Random random = new Random();

        wrapper();

        /* ADDING OBJECTS WITHOUT DEFINING SIZE AND INDEX */
        for (int i = 0; i < amount; i++) {
            System.out.print(i+1 + ": ");
            validator(objectCollection.add("Object without size"));
            System.out.println("You have tried to add an element into collection!");
        }
        wrapper();
        System.out.println(objectCollection);
        wrapper();

        /* CREATING OBJECTS WITH DEFINING SIZE AND WITHOUT INDEX */
        for (int i = 0; i < amount; i++) {
            System.out.print(i+1 + ": ");
            validator(objectCollectionSize.add(i, "Object with size " + (i+1)));
            System.out.println("You have tried to add an element into collection!");
        }
        wrapper();
        System.out.println(objectCollectionSize);
        wrapper();

        /* ATTEMPT TO ADD AN OBJECT WITH INDEX */
        validator(objectCollectionIndex.add(0, "Object"));
        System.out.println(objectCollectionIndex);

        wrapper();

        /* ATTEMPT TO FIND OUT IF AN ELEMENT IS CONTAINED IN COLLECTION */
        validator(objectCollection.contain("Object without size"));
        System.out.println("You have tried to use contain method in collection!");

        wrapper();

        /* ATTEMPT TO DELETE AN ELEMENT */
        validator(objectCollection.delete("Object without size"));
        System.out.println("You have tried to delete an element from collection!");

        wrapper();

        /* ATTEMPT TO GET AN ELEMENT */
        validator(String.valueOf(objectCollection.get(random.nextInt(amount))));
        System.out.println("You have tried to get an element from collection!");
        wrapper();

        /* ATTEMPT TO COMPARE TWO COLLECTIONS */
        validator(objectCollection.equals(objectCollectionSize));
        System.out.println("You have tried to compare two collections!");

        wrapper();

        objectCollectionSize = objectCollection;
        validator(objectCollection.equals(objectCollectionSize));
        System.out.println("You have tried to compare two collections!");
        wrapper();

        /* ATTEMPT TO CLEAR THE COLLECTION */
        validator(objectCollection.clear());
        System.out.println("You have tried to clear the collection!");
        wrapper();

        System.out.println(objectCollection);
        wrapper();

        /* ATTEMPT TO FIND OUT THE COLLECTION SIZE */
        validator(String.valueOf(objectCollectionSize.size()));
        System.out.println("You have tried to find out the collection size!");
        wrapper();

    }

    public static void validator(boolean method) {
        if (!method) System.out.print("Failed. ");
        else System.out.print("Success! ");
    }

    public static void validator(String method) {
        if (method == null) System.out.print("Failed. ");
        else System.out.print("Success! ");
    }

    public static void wrapper() {
        for (int i = 0; i < 75; i++) System.out.print("-");
        System.out.println();
    }
}
