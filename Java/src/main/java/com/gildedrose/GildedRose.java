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

            //TODO: Validate Item
            if(item == null){
                logger.info("Found an invalid item. Skipping item");
                continue;
            }

            if(ItemManager.isLegendaryItem(item)) {
                //Legendary items never changes in quality, and they never have to be sold
                continue;
            }

            ItemManager.decreaseSellIn(item);


            if(ItemManager.isAgedBrieItem(item)){
                ItemManager.updateAgedBrieQuality(item);
            }
            else if(ItemManager.isBackstagePassItem(item)){
                ItemManager.updateBackstagePassQuality(item);
            }
            else if(ItemManager.isConjuredItem(item)){
                ItemManager.updateConjuredItem(item);
            }
            else {
                ItemManager.updateNormalItem(item);
            }
        }
    }
}