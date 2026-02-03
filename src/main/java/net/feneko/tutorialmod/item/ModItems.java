package net.feneko.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.feneko.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item THING_ITEM = registerItem("thing", new Item(new Item.Settings())); // Instanciando o objeto Item

    private static Item registerItem(String name, Item item) { //registrar o identificador do item (feneko.tutorialmod.thing)
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registring Mod Items for" + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> { //Adding to the Ingredients Group adds it to the creative tab
           entries.add(THING_ITEM);
        });
    }

    //For the assets that compose this item: Lang is for language, models is the 3D part of and textures just wrap it
}
