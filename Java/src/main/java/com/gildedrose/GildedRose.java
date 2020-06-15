package com.gildedrose;

import com.gildedrose.helpers.ItemManager;
import com.gildedrose.helpers.QualityManager;

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
        if(item == null){
            logger.info("Invalid Item found. It is null. Item will be skipped");
            return false;
        } else if (item.name == null){
            logger.info("Invalid Item found. Its name is null. Item will be skipped");
            return false;
        } else if (item.name.isEmpty()){
            logger.info("Invalid Item found. Its name is empty. Item will be skipped");
            return false;
        } else if (!QualityManager.isQualityBetweenMinAndMax(item) && !ItemManager.isLegendary(item)){
            logger.info(String.format("Invalid Item found. Item %s quality is not between Min and Max values. " +
                    "Item will be skipped", item.name));
            return false;
        }

        return true;

    }
}