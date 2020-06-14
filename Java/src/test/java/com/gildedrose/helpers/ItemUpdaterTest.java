package com.gildedrose.helpers;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemUpdaterTest {

    @Test
    public void updateAgedBrieQualityBeforeSellInIsDoneTest(){
        Item itemPositiveSellInDays = new Item("Aged Brie", 10,10);
        ItemUpdater.updateAgedBrieQuality(itemPositiveSellInDays);
        assertEquals(11, itemPositiveSellInDays.quality);
    }

    @Test
    public void updateAgedBrieQualityAfterSellInIsDoneTest(){
        Item itemNegativeSellInDays = new Item("Aged Brie", -1,10);
        ItemUpdater.updateAgedBrieQuality(itemNegativeSellInDays);
        assertEquals(12, itemNegativeSellInDays.quality);
    }

    @Test
    public void updateBackstagePassQualityBeforeTenDaysTest(){
        Item normalBackStageItem = new Item("Backstage passes to a TAFKAL80ETC concert", 15,10);
        ItemUpdater.updateBackstagePassQuality(normalBackStageItem);
        assertEquals(11, normalBackStageItem.quality);
    }

    @Test
    public void updateBackstagePassQualityAfterTenDaysTest(){
        Item item10DaysSellIn = new Item("Backstage passes to a TAFKAL80ETC concert", 10,10);
        ItemUpdater.updateBackstagePassQuality(item10DaysSellIn);
        assertEquals(12, item10DaysSellIn.quality);
    }

    @Test
    public void updateBackstagePassQualityAfterFiveDaysTest(){
        Item item5DaysSellIn = new Item("Backstage passes to a TAFKAL80ETC concert", 5,10);
        ItemUpdater.updateBackstagePassQuality(item5DaysSellIn);
        assertEquals(13, item5DaysSellIn.quality);
    }

    @Test
    public void updateBackstagePassQualityAfterZeroDaysTest(){
        Item item0DaysSellIn = new Item("Backstage passes to a TAFKAL80ETC concert", -1,10);
        ItemUpdater.updateBackstagePassQuality(item0DaysSellIn);
        assertEquals(0, item0DaysSellIn.quality);
    }

    @Test
    public void updateConjuredItemBeforeSellInZeroDaysTest(){
        Item itemPositiveSellInDays = new Item("Conjured Mana Cake", 10,10);
        ItemUpdater.updateConjuredItem(itemPositiveSellInDays);
        assertEquals(8, itemPositiveSellInDays.quality);
    }

    @Test
    public void updateConjuredItemAfterSellInZeroDaysTest(){
        Item itemNegativeSellInDays = new Item("Conjured Mana Cake", -1,10);
        ItemUpdater.updateConjuredItem(itemNegativeSellInDays);
        assertEquals(6, itemNegativeSellInDays.quality);
    }

    @Test
    public void updateNormalItemBeforeSellInZeroDaysTest(){
        Item itemPositiveSellInDays = new Item("Item", 10,10);
        ItemUpdater.updateNormalItem(itemPositiveSellInDays);
        assertEquals(9, itemPositiveSellInDays.quality);

    }

    @Test
    public void updateNormalItemAfterSellInZeroDaysTest(){
        Item itemNegativeSellInDays = new Item("Item", -1,10);
        ItemUpdater.updateNormalItem(itemNegativeSellInDays);
        assertEquals(8, itemNegativeSellInDays.quality);
    }
}
