package com.gildedrose.helpers;

import com.gildedrose.Item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QualityManagerTest {

    @Test
    public void decreaseQualityTest(){
        Item item = new Item("Item", 10, 10);
        QualityManager.decreaseQuality(item, 5);
        assertEquals(5, item.quality);
    }

    @Test
    public void decreaseQualityBelowMinReturnMin(){
        Item item = new Item("Item", 10, 10);
        QualityManager.decreaseQuality(item, 12);
        assertEquals(0, item.quality);
    }

    @Test
    public void increaseQualityTest(){
        Item item = new Item("Item", 10, 10);
        QualityManager.increaseQuality(item, 5);
        assertEquals(15, item.quality);
    }

    @Test
    public void increaseQualityAboveMaxReturnMaxTest(){
        Item item = new Item("Item", 10, 10);
        QualityManager.increaseQuality(item, 42);
        assertEquals(50, item.quality);
    }

    @Test
    public void setQualityToMinTest(){
        Item item = new Item("Item", 10, 10);
        QualityManager.setQualityToMin(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void isQualityMaxOrBelowTest(){
        Item item1 = new Item("Item", 10, 49);
        Item item2 = new Item("Item", 10, 50);
        Item item3 = new Item("Item", 10, 51);
        assertTrue(QualityManager.isQualityMaxOrBelow(item1));
        assertTrue(QualityManager.isQualityMaxOrBelow(item2));
        assertFalse(QualityManager.isQualityMaxOrBelow(item3));
    }

    @Test
    public void isQualityMinOrAbove(){
        Item item1 = new Item("Item", 10, 1);
        Item item2 = new Item("Item", 10, 0);
        Item item3 = new Item("Item", 10, -1);
        assertTrue(QualityManager.isQualityMinOrAbove(item1));
        assertTrue(QualityManager.isQualityMinOrAbove(item2));
        assertFalse(QualityManager.isQualityMinOrAbove(item3));
    }

    @Test
    public void isQualityBetweenMinAndMax(){
        Item item1 = new Item("Item", 10, 49);
        Item item2 = new Item("Item", 10, 1);
        Item item3 = new Item("Item", 10, 50);
        Item item4 = new Item("Item", 10, 0);
        Item item5 = new Item("Item", 10, 25);
        Item item6 = new Item("Item", 10, -1);
        Item item7 = new Item("Item", 10, 51);
        assertTrue(QualityManager.isQualityMinOrAbove(item1));
        assertTrue(QualityManager.isQualityMinOrAbove(item2));
        assertTrue(QualityManager.isQualityMinOrAbove(item3));
        assertTrue(QualityManager.isQualityMinOrAbove(item4));
        assertTrue(QualityManager.isQualityMinOrAbove(item5));
        assertFalse(QualityManager.isQualityMinOrAbove(item6));
        assertFalse(QualityManager.isQualityMinOrAbove(item7));
    }
}
