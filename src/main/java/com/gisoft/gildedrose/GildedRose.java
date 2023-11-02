package com.gisoft.gildedrose;

import com.gisoft.gildedrose.classes.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GildedRose {
    public static List<Item> items = new ArrayList<>();
    public static ItemUpdateStrategy defaultUpdateStrategy = new RegularItemUpdateStrategy();
    public static Map<String, ItemUpdateStrategy> updateStrategies = initializeUpdateStrategies();

    public static void main(String[] args) {

    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));

    updateQuality();

    System.out.println(items);
  }
    
    private static Map<String, ItemUpdateStrategy> initializeUpdateStrategies() {
        Map<String, ItemUpdateStrategy> strategies = new HashMap<>();
        strategies.put("Aged Brie", new AgedBrieItemUpdateStrategy());
        strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasItemUpdateStrategy());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesItemUpdateStrategy());
        strategies.put("Conjured Mana Cake", new ConjuredItemUpdateStrategy());
        strategies.put("Regular", new RegularItemUpdateStrategy());
        return strategies;
    }

    public static void updateQuality() {
        for (Item item : items) {
            ItemUpdateStrategy strategy = updateStrategies.getOrDefault(item.getName(), defaultUpdateStrategy);
            strategy.updateQuality(item);
        }
    }
}