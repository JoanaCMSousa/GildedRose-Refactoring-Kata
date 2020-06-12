package com.gildedrose;

import com.gildedrose.helpers.ItemChecker;
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
}
