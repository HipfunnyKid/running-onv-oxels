package com.scholarsmc.brokenplanet.block.BlockResources;

import com.scholarsmc.brokenplanet.BrokenPlanet;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import com.simibubi.create.foundation.block.render.SpriteShiftEntry;
import com.simibubi.create.foundation.block.render.SpriteShifter;
import com.simibubi.create.foundation.utility.Couple;

public class BrokenPlanetSpriteShifts {

	public static final CTSpriteShiftEntry
			VOXEL_CASING = omni("voxel_casing"),
			SPACESHIP_PADDING = omni("spaceship_padding")
	;



	private static CTSpriteShiftEntry omni(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
	}

	private static CTSpriteShiftEntry horizontal(String name) {
		return getCT(AllCTTypes.HORIZONTAL, name);
	}

	private static CTSpriteShiftEntry vertical(String name) {
		return getCT(AllCTTypes.VERTICAL, name);
	}

	private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
		return SpriteShifter.get(Create.asResource(originalLocation), Create.asResource(targetLocation));
	}

	private static Couple<CTSpriteShiftEntry> stockpile(String name) {
		final String prefixed = "block/stockpile/stockpile_" + name;
		return Couple.createWithContext(
				medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, BrokenPlanet.asResource(prefixed + "_small"),
						BrokenPlanet.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
	}

	private static Couple<CTSpriteShiftEntry> reservoir(String name) {
		final String prefixed = "block/reservoir/reservoir_" + name;
		return Couple.createWithContext(
				medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, BrokenPlanet.asResource(prefixed + "_small"),
						BrokenPlanet.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
	}
	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, BrokenPlanet.asResource("block/" + blockTextureName), BrokenPlanet.asResource("block/" + connectedTextureName + "_connected"));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}


	public static void register(){}
}
