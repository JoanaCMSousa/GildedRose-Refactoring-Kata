package com.gildedrose.helpers;

import com.gildedrose.Item;
import com.gildedrose.helpers.qualityvalues.QualityValues;

public class QualityChecker {

    private QualityChecker(){}

    static boolean isQualityBelowMax(Item item){
        return item.quality < QualityValues.QUALITY_MAX;
    }

    static boolean isQualityMinOrBelow(Item item){
        return item.quality <= QualityValues.QUALITY_MIN;
    }
}
