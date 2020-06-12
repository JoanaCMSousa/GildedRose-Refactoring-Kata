package com.gildedrose.helpers;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemUpdaterTest {

    @Test
    public void updateAgedBrieQualityTest(){
        Item itemPositiveSellInDays = new Item("Aged Brie", 10,10);
        Item itemNegativeSellInDays = new Item("Aged Brie", -1,10);
        ItemUpdater.updateAgedBrieQuality(itemPositiveSellInDays);
        ItemUpdater.updateAgedBrieQuality(itemNegativeSellInDays);
        assertEquals(11, itemPositiveSellInDays.quality);
        assertEquals(12, itemNegativeSellInDays.quality);
    }

    @Test
    public void updateBackstagePassQualityTest(){
        Item normalBackStageItem = new Item("Backstage passes to a TAFKAL80ETC concert", 15,10);
        Item item10DaysSellIn = new Item("Backstage passes to a TAFKAL80ETC concert", 10,10);
        Item item5DaysSellIn = new Item("Backstage passes to a TAFKAL80ETC concert", 5,10);
        Item item0DaysSellIn = new Item("Backstage passes to a TAFKAL80ETC concert", -1,10);
        ItemUpdater.updateBackstagePassQuality(normalBackStageItem);
        ItemUpdater.updateBackstagePassQuality(item10DaysSellIn);
        ItemUpdater.updateBackstagePassQuality(item5DaysSellIn);
        ItemUpdater.updateBackstagePassQuality(item0DaysSellIn);
        assertEquals(11, normalBackStageItem.quality);
        assertEquals(12, item10DaysSellIn.quality);
        assertEquals(13, item5DaysSellIn.quality);
        assertEquals(0, item0DaysSellIn.quality);
    }

    @Test
    public void updateConjuredItemTest(){
        Item itemPositiveSellInDays = new Item("Conjured Mana Cake", 10,10);
        Item itemNegativeSellInDays = new Item("Conjured Mana Cake", -1,10);
        ItemUpdater.updateConjuredItem(itemPositiveSellInDays);
        ItemUpdater.updateConjuredItem(itemNegativeSellInDays);
        assertEquals(8, itemPositiveSellInDays.quality);
        assertEquals(6, itemNegativeSellInDays.quality);
    }

    @Test
    public void updateNormalItemTest(){
        Item itemPositiveSellInDays = new Item("Item", 10,10);
        Item itemNegativeSellInDays = new Item("Item", -1,10);
        ItemUpdater.updateNormalItem(itemPositiveSellInDays);
        ItemUpdater.updateNormalItem(itemNegativeSellInDays);
        assertEquals(9, itemPositiveSellInDays.quality);
        assertEquals(8, itemNegativeSellInDays.quality);

    }
}
