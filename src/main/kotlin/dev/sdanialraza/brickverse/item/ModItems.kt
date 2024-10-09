package dev.sdanialraza.brickverse.item

import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents

import dev.sdanialraza.brickverse.BrickVerse

class ModItems {
    companion object {
        private val RUBY: Item = registerItem("ruby", Item(Item.Settings()))

        private fun registerItem(name: String, item: Item): Item {
            return Registry.register(Registries.ITEM, Identifier.of(BrickVerse.MOD_ID, name), item)
        }

        fun registerModItems() {
            BrickVerse.LOGGER.info("Registering mod items for" + BrickVerse.MOD_ID)

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { entries ->
                entries.add(RUBY)
            }
        }
    }
}