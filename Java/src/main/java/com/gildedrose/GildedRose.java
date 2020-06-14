package com.gildedrose;

import com.gildedrose.helpers.ItemManager;

import java.util.logging.Logger;

class GildedRose {
    private final static Logger logger=Logger.getLogger("global");
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {

            if(!validateItem(item)){
                logger.info("Found an invalid item. Skipping item");
                continue;
            }

            if(ItemManager.isLegendary(item)) {
                //Legendary items never changes in quality, and they never have to be sold
                continue;
            }

            ItemManager.decreaseSellIn(item);


            if(ItemManager.isAgedBrie(item)){
                ItemManager.updateAgedBrieQuality(item);
            }
            else if(ItemManager.isBackstagePass(item)){
                ItemManager.updateBackstagePassQuality(item);
            }
            else if(ItemManager.isConjured(item)){
                ItemManager.updateConjuredItem(item);
            }
            else {
                ItemManager.updateNormalItem(item);
            }
        }
    }

    private boolean validateItem(Item item){
        return item != null && item.name != null && !item.name.isEmpty() && item.sellIn >= 0 && item.quality >= 0
                && isNormalItemAndQualityBelowMax(item) && isLegendaryAndQualityBelowMax(item);
    }

    private boolean isNormalItemAndQualityBelowMax(Item item){
        return !ItemManager.isLegendary(item) && item.quality <= 50;
    }

    private boolean isLegendaryAndQualityBelowMax(Item item){
        return ItemManager.isLegendary(item) && item.quality <= 80;
    }
}