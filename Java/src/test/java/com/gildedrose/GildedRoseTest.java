package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    public void nameFooTest() {
        Item item = runGildedRose("foo", 0, 0);
        assertEquals("foo", item.name);
    }

    @Test
    public void qualityDecreaseTest(){
        Item item = runGildedRose("Item", 5, 11);
        assertEquals(10, item.quality);
    }

    @Test
    public void qualityDecreaseTwiceAsMuchTest(){
        Item item = runGildedRose("Item", -1, 10);
        assertEquals(8, item.quality);
    }

    @Test
    public void qualityIsNotBelowMinTest(){
        Item item = runGildedRose("Item", 10,0);
        assertTrue(item.quality >= 0);
    }

    @Test
    public void qualityIsNotAboveMaxTest(){
        Item item = runGildedRose("Aged Brie", 5, 50);
        assertEquals(50, item.quality);
    }

    @Test
    public void sellInDecreaseTest(){
        Item item = runGildedRose("Item", 11, 10);
        assertEquals(10, item.sellIn);
    }

    @Test
    public void agedBrieQualityIncreaseTest(){
        Item item = runGildedRose("Aged Brie", 6, 9);
        assertEquals(10, item.quality);
    }

    @Test
    public void agedBrieQualityIncreaseTwiceAsMuchTest(){
        Item item = runGildedRose("Aged Brie", -1, 8);
        assertEquals(10, item.quality);
    }

    @Test
    public void agedBrieSellInDecreaseTest(){
        Item item = runGildedRose("Aged Brie", 6, 8);
        assertEquals(5, item.sellIn);
    }

    @Test
    public void legendaryNoChangeSellInAndQuality(){
        Item item = runGildedRose("Sulfuras, Hand of Ragnaros", 10, 10);
        assertEquals(10, item.sellIn);
        assertEquals(10, item.quality);
    }

    @Test
    public void backstagePassQualityIncrease(){
        Item item = runGildedRose("Backstage passes to a TAFKAL80ETC concert", 15, 10);
        assertEquals(11, item.quality);
    }

    @Test
    public void backstagePassTenDaysQualityIncrease(){
        Item item = runGildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        assertEquals(12, item.quality);
    }

    @Test
    public void backstagePassFiveDaysQualityIncrease(){
        Item item = runGildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 12);
        assertEquals(15, item.quality);
    }

    @Test
    public void backstagePassZeroDaysQualityDecrease(){
        Item item = runGildedRose("Backstage passes to a TAFKAL80ETC concert", 0, 15);
        assertEquals(0, item.quality);
    }

    @Test
    public void backstagePassSellInDecreaseTest(){
        Item item = runGildedRose("Backstage passes to a TAFKAL80ETC concert", 11, 15);
        assertEquals(10, item.sellIn);
    }

    @Test
    public void conjuredItemQualityDecreaseTest(){
        Item item = runGildedRose("Conjured Mana Cake", 5, 10);
        assertEquals(8, item.quality);
    }

    @Test
    public void conjuredItemQualityDecreaseTwiceAsMuch(){
        Item item = runGildedRose("Conjured Mana Cake", -1, 8);
        assertEquals(4, item.quality);
    }

    @Test
    public void conjuredItemSellInDecreaseTest(){
        Item item = runGildedRose("Conjured Mana Cake", 11, 10);
        assertEquals(10, item.sellIn);
    }

    private Item runGildedRose(String name, int sellIn, int quality){
        Item[] itemToTest = new Item[] {new Item(name,sellIn,quality)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        return gildedRose.items[0];
    }

}
