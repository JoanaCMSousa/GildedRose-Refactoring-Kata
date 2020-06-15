package com.gildedrose.helpers;

import com.gildedrose.Item;

public class QualityManager {

    private final static int QUALITY_MAX = 50;
    private final static int QUALITY_MIN = 0;

    private QualityManager(){}

    static void decreaseQuality(Item item, int decreaseBy){
        item.quality = Math.max(item.quality - decreaseBy, QUALITY_MIN);
    }

    static void increaseQuality(Item item, int increaseBy){
        item.quality = Math.min(item.quality + increaseBy, QUALITY_MAX);

    }

    static void setQualityToMin(Item item){
        item.quality = QUALITY_MIN;
    }

    public static boolean isQualityMaxOrBelow(Item item){
        return item.quality <= QUALITY_MAX;
    }

    public static boolean isQualityMinOrAbove(Item item){
        return item.quality >= QUALITY_MIN;
    }

    public static boolean isQualityBetweenMinAndMax(Item item){
        return isQualityMaxOrBelow(item) && isQualityMinOrAbove(item);
    }
}
