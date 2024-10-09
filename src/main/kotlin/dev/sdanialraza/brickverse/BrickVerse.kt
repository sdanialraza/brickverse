package dev.sdanialraza.brickverse

import org.slf4j.LoggerFactory
import org.slf4j.Logger

import net.fabricmc.api.ModInitializer

import dev.sdanialraza.brickverse.item.ModItems

class BrickVerse : ModInitializer {
    companion object {
        const val MOD_ID = "brickverse"
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }

    override fun onInitialize() {
        ModItems.registerModItems()
    }
}
