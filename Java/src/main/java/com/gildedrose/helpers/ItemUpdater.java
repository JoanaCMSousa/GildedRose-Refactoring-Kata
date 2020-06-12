package com.gildedrose.helpers;

import com.gildedrose.Item;

public class ItemUpdater {

    public void updateAgedBrieQuality(Item item){
        if(ItemChecker.isQualityBelowFifty(item))
            if(ItemChecker.hasSellInDaysFinished(item)) {
                QualitySellInUpdater.increaseQuality(item, 2);
            }
            else {
                QualitySellInUpdater.increaseQuality(item, 1);
            }

    }

    public void updateBackstagePassQuality(Item item){
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

    public void updateNormalItem(Item item){
        if(!ItemChecker.isQualityZero(item)) {
            if (ItemChecker.hasSellInDaysFinished(item)) {
                QualitySellInUpdater.decreaseQuality(item, 2);
            } else {
                QualitySellInUpdater.decreaseQuality(item, 1);
            }
        }

    }
}
