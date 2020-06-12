package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if(isSulfurasItem(item)) {
                break;
            }

            decreaseSellIn(item);

            if(isAgedBrieItem(item)){
                updateAgedBrieQuality(item);
            }
            else if(isBackstagePassItem(item)){
                updateBackstagePassQuality(item);
            }
            else {
                updateNormalItem(item);
            }
        }
    }

    private void updateAgedBrieQuality(Item item){
        if(isQualityBelowFifty(item))
            if(hasSellInDaysFinished(item)) {
                increaseQuality(item, 2);
            }
            else {
                increaseQuality(item, 1);
            }

    }

    private void updateBackstagePassQuality(Item item){
        if(hasSellInDaysFinished(item) && !isQualityZero(item)){
            decreaseQualityToZero(item);
        }
        else {
            if (isQualityBelowFifty(item)) {
                if (isSellInDaysFiveOrBelow(item)) {
                    increaseQuality(item, 3);
                } else if (isSellInDaysTenOrBelow(item)) {
                    increaseQuality(item, 2);
                } else {
                    increaseQuality(item, 1);
                }
            }
        }
    }

    private void updateNormalItem(Item item){
        if(!isQualityZero(item)) {
            if (hasSellInDaysFinished(item)) {
                decreaseQuality(item, 2);
            } else {
                decreaseQuality(item, 1);
            }
        }

    }

    private boolean isAgedBrieItem(Item item){
        return item.name.equalsIgnoreCase("Aged Brie");
    }

    private boolean isSulfurasItem(Item item){
        return item.name.equalsIgnoreCase("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePassItem(Item item){
        return item.name.equalsIgnoreCase("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isPositiveQualityItem(Item item){
        return item.quality > 0;
    }

    private void decreaseQuality(Item item, int decreaseDownTo){
        item.quality = item.quality - decreaseDownTo;
    }

    private void increaseQuality(Item item, int sumUpTo){
        item.quality = item.quality + sumUpTo;
    }

    private void decreaseSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }


    private boolean isQualityBelowFifty(Item item){
        return item.quality < 50;
    }

    private boolean isSellInDaysTenOrBelow(Item item){
        return item.sellIn <= 10;
    }

    private boolean isSellInDaysFiveOrBelow(Item item){
        return item.sellIn <= 5;
    }

    private boolean hasSellInDaysFinished(Item item){
        return item.sellIn < 0;
    }

    private void decreaseQualityToZero(Item item){
        item.quality = 0;
    }

    private boolean isQualityZero(Item item){
        return item.quality == 0;
    }
}