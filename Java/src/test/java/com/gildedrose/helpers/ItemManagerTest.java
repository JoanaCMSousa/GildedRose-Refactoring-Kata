package com.gildedrose.helpers;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemManagerTest {

    @Test
    public void isAgedBrieTest(){
        Item item = new Item("Aged Brie", 10, 10);
        assertTrue(ItemManager.isAgedBrie(item));
    }

    @Test
    public void isLegendaryItemTest(){
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        assertTrue(ItemManager.isLegendary(item));
    }

    @Test
    public void isBackstagePassItemTest(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        assertTrue(ItemManager.isBackstagePass(item));
    }

    @Test
    public void isConjuredItemTest(){
        Item item = new Item("Conjured Mana Cake", 10, 10);
        assertTrue(ItemManager.isConjured(item));
    }

    @Test
    public void isSellInDaysTenOrBelowTest(){
        Item item1 = new Item("Item", 9, 10);
        Item item2 = new Item("Item", 10, 10);
        Item item3 = new Item("Item", 11, 10);
        assertTrue(ItemManager.isSellInDaysTenOrBelow(item1));
        assertTrue(ItemManager.isSellInDaysTenOrBelow(item2));
        assertFalse(ItemManager.isSellInDaysTenOrBelow(item3));
    }

    @Test
    public void isSellInDaysFiveOrBelowTest(){
        Item item1 = new Item("Item", 4, 10);
        Item item2 = new Item("Item", 5, 10);
        Item item3 = new Item("Item", 6, 10);
        assertTrue(ItemManager.isSellInDaysFiveOrBelow(item1));
        assertTrue(ItemManager.isSellInDaysFiveOrBelow(item2));
        assertFalse(ItemManager.isSellInDaysFiveOrBelow(item3));
    }

    @Test
    public void hasItemExpiredTest(){
        Item item1 = new Item("Item", 1, 10);
        Item item2 = new Item("Item", 0, 10);
        Item item3 = new Item("Item", -1, 10);
        assertFalse(ItemManager.hasItemExpired(item1));
        assertFalse(ItemManager.hasItemExpired(item2));
        assertTrue(ItemManager.hasItemExpired(item3));
    }

    @Test
    public void updateAgedBrieQualityBeforeSellInIsDoneTest(){
        Item item = new Item("Aged Brie", 10,10);
        ItemManager.updateAgedBrieQuality(item);
        assertEquals(11, item.quality);
    }

    @Test
    public void updateAgedBrieQualityAfterSellInIsDoneTest(){
        Item item = new Item("Aged Brie", -1,10);
        ItemManager.updateAgedBrieQuality(item);
        assertEquals(12, item.quality);
    }

    @Test
    public void updateBackstagePassQualityBeforeTenDaysTest(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15,10);
        ItemManager.updateBackstagePassQuality(item);
        assertEquals(11, item.quality);
    }

    @Test
    public void updateBackstagePassQualityAfterTenDaysTest(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10,10);
        ItemManager.updateBackstagePassQuality(item);
        assertEquals(12, item.quality);
    }

    @Test
    public void updateBackstagePassQualityAfterFiveDaysTest(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5,10);
        ItemManager.updateBackstagePassQuality(item);
        assertEquals(13, item.quality);
    }

    @Test
    public void updateBackstagePassQualityAfterZeroDaysTest(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1,10);
        ItemManager.updateBackstagePassQuality(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void updateConjuredItemBeforeSellInZeroDaysTest(){
        Item item = new Item("Conjured Mana Cake", 10,10);
        ItemManager.updateConjuredItem(item);
        assertEquals(8, item.quality);
    }

    @Test
    public void updateConjuredItemAfterSellInZeroDaysTest(){
        Item item = new Item("Conjured Mana Cake", -1,10);
        ItemManager.updateConjuredItem(item);
        assertEquals(6, item.quality);
    }

    @Test
    public void updateNormalItemBeforeSellInZeroDaysTest(){
        Item item = new Item("Item", 10,10);
        ItemManager.updateNormalItem(item);
        assertEquals(9, item.quality);

    }

    @Test
    public void updateNormalItemAfterSellInZeroDaysTest(){
        Item item = new Item("Item", -1,10);
        ItemManager.updateNormalItem(item);
        assertEquals(8, item.quality);
    }

    @Test
    public void decreaseSellInTest(){
        Item item = new Item("Item", 10, 10);
        ItemManager.decreaseSellIn(item);
        assertEquals(9, item.sellIn);
    }

}
