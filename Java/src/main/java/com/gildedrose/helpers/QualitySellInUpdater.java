package com.gildedrose.helpers;

import com.gildedrose.Item;

public class QualitySellInUpdater {

    public static void decreaseQuality(Item item, int decreaseDownTo){
        item.quality = item.quality - decreaseDownTo;
    }

    public static void increaseQuality(Item item, int sumUpTo){
        item.quality = item.quality + sumUpTo;
    }

    public static void decreaseSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }

    public static void decreaseQualityToZero(Item item){
        item.quality = 0;
    }

}
