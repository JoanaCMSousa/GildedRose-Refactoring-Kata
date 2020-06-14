package com.gildedrose.helpers;

import com.gildedrose.Item;

public class QualityManager {

    public final static int QUALITY_MAX = 50;
    public final static int QUALITY_MIN = 0;

    private QualityManager(){}

    static void decreaseQuality(Item item, int decreaseBy){
        item.quality = item.quality - decreaseBy;

        if(isQualityMinOrBelow(item)){
            item.quality = QUALITY_MIN;
        }
    }

    static void increaseQuality(Item item, int increaseBy){
        item.quality = item.quality + increaseBy;

        if(!isQualityBelowMax(item)){
            item.quality = QUALITY_MAX;
        }
    }

    static void setQualityToMin(Item item){
        item.quality = 0;
    }

    static boolean isQualityBelowMax(Item item){
        return item.quality < QUALITY_MAX;
    }

    static boolean isQualityMinOrBelow(Item item){
        return item.quality <= QUALITY_MIN;
    }
}
