package com.gildedrose.helpers;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemManagerTest {

    @Test
    public void isAgedBrieTest(){
        Item item = new Item("Aged Brie", 10, 10);
        assertTrue(ItemManager.isAgedBrieItem(item));
    }

    @Test
    public void isLegendaryItemTest(){
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        assertTrue(ItemManager.isLegendaryItem(item));
    }

    @Test
    public void isBackstagePassItemTest(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        assertTrue(ItemManager.isBackstagePassItem(item));
    }

    @Test
    public void isConjuredItemTest(){
        Item item = new Item("Conjured Mana Cake", 10, 10);
        assertTrue(ItemManager.isConjuredItem(item));
    }

    @Test
    public void isSellInDaysTenOrBelowTest(){
        Item item = new Item("Item", 10, 10);
        assertTrue(ItemManager.isSellInDaysTenOrBelow(item));
        //TODO: Check other limits (9, 11)
    }

    @Test
    public void isSellInDaysFiveOrBelowTest(){
        Item item = new Item("Item", 5, 10);
        assertTrue(ItemManager.isSellInDaysFiveOrBelow(item));
        //TODO: Check other limits (4, 6)
    }

    @Test
    public void hasSellInDaysFinishedTest(){
        Item item = new Item("Item", -1, 10);
        assertTrue(ItemManager.hasSellInDaysFinished(item));
        //TODO: Check other limits (1, 0)
    }

    @Test
    public void updateAgedBrieQualityBeforeSellInIsDoneTest(){
        Item itemPositiveSellInDays = new Item("Aged Brie", 10,10);
        ItemManager.updateAgedBrieQuality(itemPositiveSellInDays);
        assertEquals(11, itemPositiveSellInDays.quality);
    }

    @Test
    public void updateAgedBrieQualityAfterSellInIsDoneTest(){
        Item itemNegativeSellInDays = new Item("Aged Brie", -1,10);
        ItemManager.updateAgedBrieQuality(itemNegativeSellInDays);
        assertEquals(12, itemNegativeSellInDays.quality);
    }

    @Test
    public void updateBackstagePassQualityBeforeTenDaysTest(){
        Item normalBackStageItem = new Item("Backstage passes to a TAFKAL80ETC concert", 15,10);
        ItemManager.updateBackstagePassQuality(normalBackStageItem);
        assertEquals(11, normalBackStageItem.quality);
    }

    @Test
    public void updateBackstagePassQualityAfterTenDaysTest(){
        Item item10DaysSellIn = new Item("Backstage passes to a TAFKAL80ETC concert", 10,10);
        ItemManager.updateBackstagePassQuality(item10DaysSellIn);
        assertEquals(12, item10DaysSellIn.quality);
    }

    @Test
    public void updateBackstagePassQualityAfterFiveDaysTest(){
        Item item5DaysSellIn = new Item("Backstage passes to a TAFKAL80ETC concert", 5,10);
        ItemManager.updateBackstagePassQuality(item5DaysSellIn);
        assertEquals(13, item5DaysSellIn.quality);
    }

    @Test
    public void updateBackstagePassQualityAfterZeroDaysTest(){
        Item item0DaysSellIn = new Item("Backstage passes to a TAFKAL80ETC concert", -1,10);
        ItemManager.updateBackstagePassQuality(item0DaysSellIn);
        assertEquals(0, item0DaysSellIn.quality);
    }

    @Test
    public void updateConjuredItemBeforeSellInZeroDaysTest(){
        Item itemPositiveSellInDays = new Item("Conjured Mana Cake", 10,10);
        ItemManager.updateConjuredItem(itemPositiveSellInDays);
        assertEquals(8, itemPositiveSellInDays.quality);
    }

    @Test
    public void updateConjuredItemAfterSellInZeroDaysTest(){
        Item itemNegativeSellInDays = new Item("Conjured Mana Cake", -1,10);
        ItemManager.updateConjuredItem(itemNegativeSellInDays);
        assertEquals(6, itemNegativeSellInDays.quality);
    }

    @Test
    public void updateNormalItemBeforeSellInZeroDaysTest(){
        Item itemPositiveSellInDays = new Item("Item", 10,10);
        ItemManager.updateNormalItem(itemPositiveSellInDays);
        assertEquals(9, itemPositiveSellInDays.quality);

    }

    @Test
    public void updateNormalItemAfterSellInZeroDaysTest(){
        Item itemNegativeSellInDays = new Item("Item", -1,10);
        ItemManager.updateNormalItem(itemNegativeSellInDays);
        assertEquals(8, itemNegativeSellInDays.quality);
    }

    @Test
    public void decreaseSellInTest(){
        Item item = new Item("Item", 10, 10);
        ItemManager.decreaseSellIn(item);
        assertEquals(9, item.sellIn);
    }

}
