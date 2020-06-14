package com.gildedrose.helpers;

import com.gildedrose.Item;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

public class QualityManagerTest {

    Random random = new Random(); //TODO: NO RANDOM

    //TODO: Add more tests -> reaching 50 or 0

    @Test
    public void decreaseQualityTest(){
        Item item = new Item("Item", 10, 20);
        int valueToDecrease = random.nextInt(10);
        QualityManager.decreaseQuality(item, valueToDecrease);
        assertEquals(20 - valueToDecrease, item.quality);
    }

    @Test
    public void increaseQualityTest(){
        Item item = new Item("Item", 10, 20);
        int valueToIncrease = random.nextInt(10);
        QualityManager.increaseQuality(item, valueToIncrease);
        assertEquals(20 + valueToIncrease, item.quality);
    }

    @Test
    public void decreaseQualityToZeroTest(){
        Item item = new Item("Item", 10, 10);
        QualityManager.setQualityToMin(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void isQualityBelowMaxTest(){
        Item item = new Item("Item", 10, 49);
        assertTrue(QualityManager.isQualityBelowMax(item));
        //TODO: Check other limits (50, 51)
    }

//    @Test
//    public void isQualityZeroTest(){
//        Item item = new Item("Item", 10, 0);
//        assertTrue(ItemChecker.isQualityMinOrBelow(item));
//        //TODO: Check other value (-1, 1)
//    }
}
