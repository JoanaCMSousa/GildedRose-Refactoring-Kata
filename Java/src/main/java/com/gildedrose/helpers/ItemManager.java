package com.gildedrose.helpers;

import com.gildedrose.Item;

public class ItemManager {

    private final static String AGED_BRIE_ITEM = "Aged Brie";
    private final static String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";
    private final static String BACKSTAGE_PASS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    private final static String CONJURED_ITEM = "conjured";

    private ItemManager(){}

    //TODO: Remove Item in method name
    public static boolean isAgedBrieItem(Item item){
        return item.name.equalsIgnoreCase(AGED_BRIE_ITEM);
    }

    public static boolean isLegendaryItem(Item item){
        return item.name.equalsIgnoreCase(LEGENDARY_ITEM);
    }

    public static boolean isBackstagePassItem(Item item){
        return item.name.equalsIgnoreCase(BACKSTAGE_PASS_ITEM);
    }

    public static boolean isConjuredItem(Item item){
        return item.name.toLowerCase().contains(CONJURED_ITEM);
    } //TODO: startsWith instead of contains (?)

    public static boolean isSellInDaysTenOrBelow(Item item){
        return item.sellIn <= 10;
    }

    public static boolean isSellInDaysFiveOrBelow(Item item){
        return item.sellIn <= 5;
    }

    public static boolean hasSellInDaysFinished(Item item){
        return item.sellIn < 0;
    }

    public static void updateAgedBrieQuality(Item item){
        if (ItemManager.hasSellInDaysFinished(item)) {
            QualityManager.increaseQuality(item, 2);
        } else {
            QualityManager.increaseQuality(item, 1);
        }

    }

    public static void updateBackstagePassQuality(Item item){
        if(ItemManager.hasSellInDaysFinished(item) ){
            QualityManager.setQualityToMin(item);
        }
        else {
            if (ItemManager.isSellInDaysFiveOrBelow(item)) {
                QualityManager.increaseQuality(item, 3);
            } else if (ItemManager.isSellInDaysTenOrBelow(item)) {
                QualityManager.increaseQuality(item, 2);
            } else {
                QualityManager.increaseQuality(item, 1);
            }
        }

    }

    public static void updateConjuredItem(Item item){
        if(ItemManager.hasSellInDaysFinished(item)){
            QualityManager.decreaseQuality(item, 4);
        } else {
            QualityManager.decreaseQuality(item, 2);
        }

    }

    public static void updateNormalItem(Item item){
        if (ItemManager.hasSellInDaysFinished(item)) {
            QualityManager.decreaseQuality(item, 2);
        } else {
            QualityManager.decreaseQuality(item, 1);
        }

    }

    public static void decreaseSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }
}
