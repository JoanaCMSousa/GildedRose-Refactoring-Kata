package com.gildedrose;

import com.gildedrose.helpers.ItemChecker;
import com.gildedrose.helpers.ItemUpdater;
import com.gildedrose.helpers.QualitySellInUpdater;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if(ItemChecker.isLegendaryItem(item)) {
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