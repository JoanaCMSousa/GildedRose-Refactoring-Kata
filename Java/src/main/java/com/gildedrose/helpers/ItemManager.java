package com.gildedrose.helpers;

import com.gildedrose.Item;

public class ItemManager {

    private final static String AGED_BRIE_ITEM = "Aged Brie";
    private final static String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";
    private final static String BACKSTAGE_PASS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    private final static String CONJURED_ITEM = "conjured";

    private ItemManager(){}

    public static boolean isAgedBrie(Item item){
        return item.name.equalsIgnoreCase(AGED_BRIE_ITEM);
    }

    public static boolean isLegendary(Item item){
        return item.name.equalsIgnoreCase(LEGENDARY_ITEM);
    }

    public static boolean isBackstagePass(Item item){
        return item.name.equalsIgnoreCase(BACKSTAGE_PASS_ITEM);
    }

    public static boolean isConjured(Item item){
        return item.name.toLowerCase().startsWith(CONJURED_ITEM);
    }

    static boolean isSellInDaysTenOrBelow(Item item){
        return item.sellIn <= 10;
    }

    static boolean isSellInDaysFiveOrBelow(Item item){
        return item.sellIn <= 5;
    }

    static boolean hasItemExpired(Item item){
        return item.sellIn < 0;
    }

    public static void updateAgedBrieQuality(Item item){
        if (hasItemExpired(item)) {
            QualityManager.increaseQuality(item, 2);
        } else {
            QualityManager.increaseQuality(item, 1);
        }

    }

    public static void updateBackstagePassQuality(Item item){
        if(hasItemExpired(item) ){
            QualityManager.setQualityToMin(item);
        } else if (ItemManager.isSellInDaysFiveOrBelow(item)) {
            QualityManager.increaseQuality(item, 3);
        } else if (ItemManager.isSellInDaysTenOrBelow(item)) {
            QualityManager.increaseQuality(item, 2);
        } else {
            QualityManager.increaseQuality(item, 1);
        }

    }

    public static void updateConjuredItem(Item item){
        if(hasItemExpired(item)){
            QualityManager.decreaseQuality(item, 4);
        } else {
            QualityManager.decreaseQuality(item, 2);
        }

    }

    public static void updateNormalItem(Item item){
        if (hasItemExpired(item)) {
            QualityManager.decreaseQuality(item, 2);
        } else {
            QualityManager.decreaseQuality(item, 1);
        }

    }

    public static void decreaseSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }
}
