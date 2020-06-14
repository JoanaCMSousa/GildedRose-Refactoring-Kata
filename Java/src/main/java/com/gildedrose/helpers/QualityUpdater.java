package com.gildedrose.helpers;

import com.gildedrose.Item;
import com.gildedrose.helpers.qualityvalues.QualityValues;

public class QualityUpdater {

    private QualityUpdater(){}

    static void decreaseQuality(Item item, int decreaseBy){
        item.quality = item.quality - decreaseBy;

        if(QualityChecker.isQualityMinOrBelow(item)){
            item.quality = QualityValues.QUALITY_MIN;
        }
    }

    static void increaseQuality(Item item, int increaseBy){
        item.quality = item.quality + increaseBy;

        if(!QualityChecker.isQualityBelowMax(item)){
            item.quality = QualityValues.QUALITY_MAX;
        }
    }

    static void setQualityToMin(Item item){
        item.quality = 0;
    }
}
