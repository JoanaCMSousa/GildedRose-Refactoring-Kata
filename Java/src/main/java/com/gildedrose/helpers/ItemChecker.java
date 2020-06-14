package com.gildedrose.helpers;

import com.gildedrose.Item;

public class ItemChecker {

    private final static String AGED_BRIE_ITEM = "Aged Brie";
    private final static String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";
    private final static String BACKSTAGE_PASS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    private final static String CONJURED_ITEM = "conjured";
    private final static int QUALITY_MAX = 50;
    private final static int QUALITY_MIN = 0;

    private ItemChecker(){}

    public static boolean isAgedBrieItem(Item item){
        return item.name.equalsIgnoreCase(AGED_BRIE_ITEM);
    }

    public static boolean isLegendaryItem(Item item){
        return item.name.equalsIgnoreCase(LEGENDARY_ITEM);
    }

    public static boolean isBackstagePassItem(Item item){
        return item.name.equalsIgnoreCase(BACKSTAGE_PASS_ITEM);
    }

    public static boolean isConjuredItem(Item item){
        return item.name.toLowerCase().contains(CONJURED_ITEM);
    }

    public static boolean isQualityBelowMax(Item item){
        return item.quality < QUALITY_MAX;
    }

    public static boolean isSellInDaysTenOrBelow(Item item){
        return item.sellIn <= 10;
    }

    public static boolean isSellInDaysFiveOrBelow(Item item){
        return item.sellIn <= 5;
    }

    public static boolean hasSellInDaysFinished(Item item){
        return item.sellIn < 0;
    }

    public static boolean isQualityMinOrBelow(Item item){
        return item.quality <= QUALITY_MIN;
    }
}
