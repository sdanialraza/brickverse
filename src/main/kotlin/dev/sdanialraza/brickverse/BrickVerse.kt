package dev.sdanialraza.brickverse

import org.slf4j.LoggerFactory

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger

class BrickVerse : ModInitializer {
    companion object {
        const val MOD_ID = "brickverse"
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }

    override fun onInitialize() {
        LOGGER.info("Hello, world!")
    }
}
