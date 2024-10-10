package dev.sdanialraza.brickverse.block

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider

import dev.sdanialraza.brickverse.BrickVerse

class ModBlocks {
    companion object {
        private val RUBY_ORE: Block = registerBlock(
            "ruby_ore",
            ExperienceDroppingBlock(
                UniformIntProvider.create(2, 5),
                AbstractBlock.Settings.create().strength(3f).requiresTool()
            )
        )

        private val RUBY_DEEPSLATE_ORE: Block = registerBlock(
            "deepslate_ruby_ore",
            ExperienceDroppingBlock(
                UniformIntProvider.create(3, 6),
                AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)
            )
        )

        private val RUBY_BLOCK: Block = registerBlock(
            "ruby_block",
            Block(AbstractBlock.Settings.create().strength(4f).requiresTool())
        )

        private fun registerBlock(name: String, block: Block): Block {
            registerBlockItem(name, block)

            return Registry.register(Registries.BLOCK, Identifier.of(BrickVerse.MOD_ID, name), block)
        }

        private fun registerBlockItem(name: String, block: Block) {
            Registry.register(
                Registries.ITEM, Identifier.of(BrickVerse.MOD_ID, name),
                BlockItem(block, Item.Settings())
            )
        }

        fun registerModBlocks() {
            BrickVerse.LOGGER.info("Registering mod blocks for ${BrickVerse.MOD_ID}")

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(ModifyEntries { entries ->
                    entries.add(RUBY_ORE)
                    entries.add(RUBY_DEEPSLATE_ORE)
                    entries.add(RUBY_BLOCK)
                })
        }
    }
}
