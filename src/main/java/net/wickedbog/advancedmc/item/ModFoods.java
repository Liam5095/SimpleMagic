package net.wickedbog.advancedmc.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
        .fast()
        .alwaysEat()
        .saturationMod(1.5f)
        .nutrition(2)
        .build(); //EXAMPLE

    //THIS IS HOW TO USE IN ModItems
    //    public static final RegistryObject<Item> ITEM = ITEMS.register("item",
    //            () -> new Item(new Item.Properties().food(ModFoods.FOODPROPS)));
}
