package com.gildedrose.helpers;

import com.gildedrose.Item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QualityManagerTest {

    @Test
    public void decreaseQualityTest(){
        Item item = new Item("Item", 10, 10);
        int valueToDecrease = 5;
        QualityManager.decreaseQuality(item, valueToDecrease);
        assertEquals(5, item.quality);
    }

    @Test
    public void decreaseQualityBelowMinReturnMin(){
        Item item = new Item("Item", 10, 10);
        int valueToDecrease = 12;
        QualityManager.decreaseQuality(item, valueToDecrease);
        assertEquals(0, item.quality);
    }

    @Test
    public void increaseQualityTest(){
        Item item = new Item("Item", 10, 10);
        int valueToIncrease = 5;
        QualityManager.increaseQuality(item, valueToIncrease);
        assertEquals(15, item.quality);
    }

    @Test
    public void increaseQualityAboveMaxReturnMaxTest(){
        Item item = new Item("Item", 10, 10);
        int valueToIncrease = 42;
        QualityManager.increaseQuality(item, valueToIncrease);
        assertEquals(50, item.quality);
    }

    @Test
    public void decreaseQualityToZeroTest(){
        Item item = new Item("Item", 10, 10);
        QualityManager.setQualityToMin(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void isQualityBelowMaxTest(){
        Item item1 = new Item("Item", 10, 49);
        Item item2 = new Item("Item", 10, 50);
        Item item3 = new Item("Item", 10, 51);
        assertTrue(QualityManager.isQualityMaxOrBelow(item1));
        assertTrue(QualityManager.isQualityMaxOrBelow(item2));
        assertFalse(QualityManager.isQualityMaxOrBelow(item3));
    }

    @Test
    public void isQualityMinOrBelow(){
        Item item1 = new Item("Item", 10, 1);
        Item item2 = new Item("Item", 10, 0);
        Item item3 = new Item("Item", 10, -1);
        assertFalse(QualityManager.isQualityMinOrBelow(item1));
        assertTrue(QualityManager.isQualityMinOrBelow(item2));
        assertTrue(QualityManager.isQualityMinOrBelow(item3));
    }
}
