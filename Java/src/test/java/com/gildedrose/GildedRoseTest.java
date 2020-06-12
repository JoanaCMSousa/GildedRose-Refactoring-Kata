package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void nameFooTest() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void qualityDecreaseTest(){
        Item[] itemToTest = new Item[] {new Item("item", 5, 11)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(10, gildedRose.items[0].quality);
    }

    @Test
    public void qualityDecreaseTwiceTest(){
        Item[] itemToTest = new Item[]{new Item("test", -1, 10)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(8,gildedRose.items[0].quality);
    }

    @Test
    public void qualityIsNotNegativeTest(){
        Item[] itemToTest = new Item[]{new Item("test", 10, 0)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertTrue(gildedRose.items[0].quality >= 0);
    }

    @Test
    public void qualityIsNotMoreThanFifty(){
        Item[] itemToTest = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void sellInDecreaseTest(){
        Item[] itemToTest = new Item[] {new Item("test", 11, 10)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(10, gildedRose.items[0].sellIn);
    }

    @Test
    public void agedBrieQualityIncreaseTest(){
        Item[] itemToTest = new Item[] {new Item("Aged Brie", 6, 9)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(10, gildedRose.items[0].quality);
    }

    @Test
    public void agedBrieQualityIncreaseTwiceTest(){
        Item[] itemToTest = new Item[] {new Item("Aged Brie", -1, 8)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(10, gildedRose.items[0].quality);
    }

    @Test
    public void agedBrieSellInDecreaseTest(){
        Item[] itemToTest = new Item[] {new Item("Aged Brie", 6, 8)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(5, gildedRose.items[0].sellIn);
    }

    @Test
    public void sulfurasNotChangeSellInAndQuality(){
        Item[] itemToTest = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 10)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(10, gildedRose.items[0].sellIn);
        assertEquals(10, gildedRose.items[0].quality);
    }

    @Test
    public void backstagePassTenDaysQualityIncrease(){
        Item[] itemToTest = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(12, gildedRose.items[0].quality);
    }

    @Test
    public void backstagePassFiveDaysQualityIncrease(){
        Item[] itemToTest = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 12)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(15, gildedRose.items[0].quality);
    }

    @Test
    public void backstagePassZeroDaysQualityDecrease(){
        Item[] itemToTest = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 15)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void backstagePassSellInDecreaseTest(){
        Item[] itemToTest = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 15)};
        GildedRose gildedRose = new GildedRose(itemToTest);
        gildedRose.updateQuality();
        assertEquals(10, gildedRose.items[0].sellIn);
    }

}
