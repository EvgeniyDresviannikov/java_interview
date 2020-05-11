package first.two;

import java.util.Objects;

public class FruitCounter {
    public static void main(String[] strings) {
        FruitCounter fruitCounter = new FruitCounter();
        Apple apple1 = new AppleClass();
        Apple apple2 = new AppleClass();
        Banana banana1 = new BananaClass();
        Banana banana2 = new BananaClass();
        Banana banana3 = new BananaClass();

        Object[] objects = new Object[6];
        objects[0] = apple1;
        objects[1] = banana1;
        objects[2] = 5L;
        objects[3] = banana2;
        objects[4] = banana3;
        objects[5] = apple2;

        fruitCounter.checkFruitCount(objects);

    }

    void checkFruitCount(Object[] objects) {
        int appleCounter = 0;
        int bananaCounter = 0;
        for (Object obj : objects) {
            if (obj instanceof Apple) {
                appleCounter++;
            }
            if (obj instanceof Banana) {
                bananaCounter++;
            }
        }
        System.out.println("banana=" + bananaCounter + ", apple=" + appleCounter);
    }
}




interface Apple {

}

interface Banana {

}

class AppleClass implements Apple {

}

class BananaClass implements Banana {

}