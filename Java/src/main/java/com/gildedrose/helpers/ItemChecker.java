package com.gildedrose.helpers;

import com.gildedrose.Item;

public class ItemChecker {

    public static boolean isAgedBrieItem(Item item){
        return item.name.equalsIgnoreCase("Aged Brie");
    }

    public static boolean isLegendaryItem(Item item){
        return item.name.equalsIgnoreCase("Sulfuras, Hand of Ragnaros");
    }

    public static boolean isBackstagePassItem(Item item){
        return item.name.equalsIgnoreCase("Backstage passes to a TAFKAL80ETC concert");
    }

    public static boolean isPositiveQualityItem(Item item){
        return item.quality > 0;
    }

    public static boolean isQualityBelowFifty(Item item){
        return item.quality < 50;
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

    public static boolean isQualityZero(Item item){
        return item.quality == 0;
    }
}
