package com.gildedrose.helpers;

import com.gildedrose.Item;

public class ItemUpdater {

    public static void updateAgedBrieQuality(Item item){
        if(ItemChecker.isQualityBelowFifty(item))
            if(ItemChecker.hasSellInDaysFinished(item)) {
                QualitySellInUpdater.increaseQuality(item, 2);
            }
            else {
                QualitySellInUpdater.increaseQuality(item, 1);
            }

    }

    public static void updateBackstagePassQuality(Item item){
        if(ItemChecker.hasSellInDaysFinished(item) && !ItemChecker.isQualityZero(item)){
            QualitySellInUpdater.decreaseQualityToZero(item);
        }
        else {
            if (ItemChecker.isQualityBelowFifty(item)) {
                if (ItemChecker.isSellInDaysFiveOrBelow(item)) {
                    QualitySellInUpdater.increaseQuality(item, 3);
                } else if (ItemChecker.isSellInDaysTenOrBelow(item)) {
                    QualitySellInUpdater.increaseQuality(item, 2);
                } else {
                    QualitySellInUpdater.increaseQuality(item, 1);
                }
            }
        }
    }

    public static void updateConjuredItem(Item item){
        if(!ItemChecker.isQualityZero(item)){
            if(ItemChecker.hasSellInDaysFinished(item)){
                QualitySellInUpdater.decreaseQuality(item, 4);
            } else {
                QualitySellInUpdater.decreaseQuality(item, 2);
            }
        }
    }

    public static void updateNormalItem(Item item){
        if(!ItemChecker.isQualityZero(item)) {
            if (ItemChecker.hasSellInDaysFinished(item)) {
                QualitySellInUpdater.decreaseQuality(item, 2);
            } else {
                QualitySellInUpdater.decreaseQuality(item, 1);
            }
        }

    }
}
