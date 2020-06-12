package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (!isAgedBrieItem(item) && !isBackstagePassItem(item)) {
                if (isPositiveQualityItem(item)) {
                    if (!isSulfurasItem(item)) {
                        decreaseQuality(item);
                    }
                }
            } else {
                if (isQualityBelowFifty(item)) {
                    increaseQuality(item);

                    if (isBackstagePassItem(item)) {
                        if (isSellInDaysTenOrBelow(item)) {
                            if (isQualityBelowFifty(item)) {
                                increaseQuality(item);
                            }
                        }

                        if (isSellInDaysFiveOrBelow(item)) {
                            if (isQualityBelowFifty(item)) {
                                increaseQuality(item);
                            }
                        }
                    }
                }
            }

            if (!isSulfurasItem(item)) {
                decreaseSellIn(item);
            }

            if (hasSellInDaysFinished(item)) {
                if (!isAgedBrieItem(item)) {
                    if (!isBackstagePassItem(item)) {
                        if (isPositiveQualityItem(item)) {
                            if (!isSulfurasItem(item)) {
                                decreaseQuality(item);
                            }
                        }
                    } else {
                        decreaseQualityToZero(item);
                    }
                } else {
                    if (isQualityBelowFifty(item)) {
                        increaseQuality(item);
                    }
                }
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

    private void decreaseQuality(Item item){
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item){
        item.quality = item.quality + 1;
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
}