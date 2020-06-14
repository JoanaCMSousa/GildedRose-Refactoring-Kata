package com.gildedrose.helpers;

import com.gildedrose.Item;

public class ItemUpdater {

    private ItemUpdater(){}

    public static void updateAgedBrieQuality(Item item){
        if (ItemChecker.hasSellInDaysFinished(item)) {
            QualityUpdater.increaseQuality(item, 2);
        } else {
            QualityUpdater.increaseQuality(item, 1);
        }

    }

    public static void updateBackstagePassQuality(Item item){
        if(ItemChecker.hasSellInDaysFinished(item) ){
            QualityUpdater.setQualityToMin(item);
        }
        else {
            if (ItemChecker.isSellInDaysFiveOrBelow(item)) {
                QualityUpdater.increaseQuality(item, 3);
            } else if (ItemChecker.isSellInDaysTenOrBelow(item)) {
                QualityUpdater.increaseQuality(item, 2);
            } else {
                QualityUpdater.increaseQuality(item, 1);
            }
            }

    }

    public static void updateConjuredItem(Item item){
        if(ItemChecker.hasSellInDaysFinished(item)){
            QualityUpdater.decreaseQuality(item, 4);
        } else {
            QualityUpdater.decreaseQuality(item, 2);
        }

    }

    public static void updateNormalItem(Item item){
        if (ItemChecker.hasSellInDaysFinished(item)) {
            QualityUpdater.decreaseQuality(item, 2);
        } else {
            QualityUpdater.decreaseQuality(item, 1);
        }

    }

    public static void decreaseSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }
}
