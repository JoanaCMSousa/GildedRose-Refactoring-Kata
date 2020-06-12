package com.gildedrose;

import com.gildedrose.helpers.ItemChecker;
import com.gildedrose.helpers.ItemUpdater;
import com.gildedrose.helpers.QualitySellInUpdater;

class GildedRose {
    Item[] items;
    ItemUpdater itemUpdater;

    public GildedRose(Item[] items) {
        this.items = items;
        itemUpdater = new ItemUpdater();
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if(ItemChecker.isLegendaryItem(item)) {
                break;
            }

            QualitySellInUpdater.decreaseSellIn(item);

            if(ItemChecker.isAgedBrieItem(item)){
                itemUpdater.updateAgedBrieQuality(item);
            }
            else if(ItemChecker.isBackstagePassItem(item)){
                itemUpdater.updateBackstagePassQuality(item);
            }
            else {
                itemUpdater.updateNormalItem(item);
            }
        }
    }
}