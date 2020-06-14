package com.gildedrose.helpers;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemCheckerTest {

    @Test
    public void isAgedBrieTest(){
        Item item = new Item("Aged Brie", 10, 10);
        assertTrue(ItemChecker.isAgedBrieItem(item));
    }

    @Test
    public void isLegendaryItemTest(){
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        assertTrue(ItemChecker.isLegendaryItem(item));
    }

    @Test
    public void isBackstagePassItemTest(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        assertTrue(ItemChecker.isBackstagePassItem(item));
    }

    @Test
    public void isConjuredItemTest(){
        Item item = new Item("Conjured Mana Cake", 10, 10);
        assertTrue(ItemChecker.isConjuredItem(item));
    }

    @Test
    public void isQualityBelowFiftyTest(){
        Item item = new Item("Item", 10, 49);
        assertTrue(ItemChecker.isQualityBelowMax(item));
    }

    @Test
    public void isSellInDaysTenOrBelowTest(){
        Item item = new Item("Item", 10, 10);
        assertTrue(ItemChecker.isSellInDaysTenOrBelow(item));
    }

    @Test
    public void isSellInDaysFiveOrBelowTest(){
        Item item = new Item("Item", 5, 10);
        assertTrue(ItemChecker.isSellInDaysFiveOrBelow(item));
    }

    @Test
    public void hasSellInDaysFinishedTest(){
        Item item = new Item("Item", -1, 10);
        assertTrue(ItemChecker.hasSellInDaysFinished(item));
    }

    @Test
    public void isQualityZeroTest(){
        Item item = new Item("Item", 10, 0);
        assertTrue(ItemChecker.isQualityMinOrBelow(item));
    }
}
