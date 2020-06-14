package com.gildedrose;

import com.gildedrose.helpers.ItemChecker;
import com.gildedrose.helpers.ItemUpdater;
import com.gildedrose.helpers.QualitySellInUpdater;

import java.util.logging.Logger;

class GildedRose {
    private final static Logger logger=Logger.getLogger("global");
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if(item == null){
                logger.info(String.format("Item with index %s is null. Skipping item", i));
                continue;
            }

            if(ItemChecker.isLegendaryItem(item)) {
                item.sellIn = 0;
                continue;
            }

            QualitySellInUpdater.decreaseSellIn(item);

            if(ItemChecker.isAgedBrieItem(item)){
                ItemUpdater.updateAgedBrieQuality(item);
            }
            else if(ItemChecker.isBackstagePassItem(item)){
                ItemUpdater.updateBackstagePassQuality(item);
            }
            else if(ItemChecker.isConjuredItem(item)){
                ItemUpdater.updateConjuredItem(item);
            }
            else {
                ItemUpdater.updateNormalItem(item);
            }
        }
    }
}