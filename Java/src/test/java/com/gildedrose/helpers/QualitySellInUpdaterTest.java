package com.gildedrose.helpers;

import com.gildedrose.Item;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;

public class QualitySellInUpdaterTest {

    Random random = new Random();

    @Test
    public void decreaseQualityTest(){
        Item item = new Item("Item", 10, 20);
        int valueToDecrease = random.nextInt(10);
        QualitySellInUpdater.decreaseQuality(item, valueToDecrease);
        assertEquals(20 - valueToDecrease, item.quality);
    }

    @Test
    public void increaseQualityTest(){
        Item item = new Item("Item", 10, 20);
        int valueToIncrease = random.nextInt(10);
        QualitySellInUpdater.increaseQuality(item, valueToIncrease);
        assertEquals(20 + valueToIncrease, item.quality);
    }

    @Test
    public void decreaseSellInTest(){
        Item item = new Item("Item", 10, 10);
        QualitySellInUpdater.decreaseSellIn(item);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void decreaseQualityToZeroTest(){
        Item item = new Item("Item", 10, 10);
        QualitySellInUpdater.decreaseQualityToZero(item);
        assertEquals(0, item.quality);
    }
}
