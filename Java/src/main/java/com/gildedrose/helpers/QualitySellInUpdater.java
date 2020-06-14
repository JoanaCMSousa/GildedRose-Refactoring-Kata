package com.gildedrose.helpers;

import com.gildedrose.Item;

public class QualitySellInUpdater {

    private final static int QUALITY_MAX = 50;
    private final static int QUALITY_MIN = 0;

    private QualitySellInUpdater(){}

    public static void decreaseQuality(Item item, int decreaseBy){
        item.quality = item.quality - decreaseBy;

        if(isQualityMinOrBelow(item)){
            item.quality = 0;
        }
    }

    public static void increaseQuality(Item item, int increaseBy){
        item.quality = item.quality + increaseBy;

        if(!isQualityBelowMax(item)){
            item.quality = 50;
        }
    }

    public static void decreaseSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }

    public static void setQualityToMin(Item item){
        item.quality = 0;
    }

    private static boolean isQualityBelowMax(Item item){
        return item.quality < QUALITY_MAX;
    }

    private static boolean isQualityMinOrBelow(Item item){
        return item.quality <= QUALITY_MIN;
    }
}
