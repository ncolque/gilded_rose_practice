package com.gisoft.gildedrose.classes;

public class AgedBrieItemUpdateStrategy implements ItemUpdateStrategy{

    @Override
    public void updateQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0 && item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }    
}
