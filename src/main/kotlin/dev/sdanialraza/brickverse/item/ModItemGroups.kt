package dev.sdanialraza.brickverse.item

import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup

import dev.sdanialraza.brickverse.BrickVerse
import dev.sdanialraza.brickverse.block.ModBlocks

class ModItemGroups {
    companion object {
        val BRICK_VERSE_BLOCKS: ItemGroup = Registry.register(
            Registries.ITEM_GROUP, Identifier.of(BrickVerse.MOD_ID, "brickverse_blocks"),
            FabricItemGroup.builder().icon({ ItemStack(ModBlocks.RUBY_ORE) })
                .displayName(Text.translatable("itemgroup.brickverse.blocks"))
                .entries { _, entries ->
                    entries.add(ModBlocks.RUBY_BLOCK)
                    entries.add(ModBlocks.RUBY_ORE)
                    entries.add(ModBlocks.DEEPSLATE_RUBY_ORE)
                }.build()
        )

        val BRICK_VERSE_ITEMS: ItemGroup = Registry.register(
            Registries.ITEM_GROUP, Identifier.of(BrickVerse.MOD_ID, "brickverse_items"),
            FabricItemGroup.builder().icon({ ItemStack(ModItems.RUBY) })
                .displayName(Text.translatable("itemgroup.brickverse.items"))
                .entries { _, entries -> entries.add(ModItems.RUBY) }.build()
        )

        fun registerModItemGroups() {
            BrickVerse.LOGGER.info("Registering mod item groups for ${BrickVerse.MOD_ID}")
        }
    }
}
