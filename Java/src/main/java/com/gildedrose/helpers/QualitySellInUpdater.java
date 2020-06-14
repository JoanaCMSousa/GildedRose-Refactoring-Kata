package com.gildedrose.helpers;

import com.gildedrose.Item;

public class QualitySellInUpdater {

    private QualitySellInUpdater(){}

    public static void decreaseQuality(Item item, int decreaseDownTo){
        item.quality = item.quality - decreaseDownTo;

        if(ItemChecker.isQualityMinOrBelow(item)){
            item.quality = 0;
        }

    }

    public static void increaseQuality(Item item, int sumUpTo){
        item.quality = item.quality + sumUpTo;

        if(!ItemChecker.isQualityBelowMax(item)){
            item.quality = 50;
        }

    }

    public static void decreaseSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }

    public static void decreaseQualityToZero(Item item){
        item.quality = 0;
    }

}
