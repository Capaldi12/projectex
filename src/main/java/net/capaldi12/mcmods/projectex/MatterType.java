package net.capaldi12.mcmods.projectex;

import net.capaldi12.mcmods.projectex.item.Matter;
import net.minecraft.util.IStringSerializable;

/**
 * <h1>Enum for matter types</h1>
 *
 * Defines types of matter and blocks made with it
 * <p>
 * More values can be added to add more matter types.
 * Each type should have corresponding resources - model, texture, translation etc.
 *
 * @see Matter
 */
public enum MatterType implements IStringSerializable {
    MAGENTA("magenta"),
    PINK("pink"),
    PURPLE("purple"),
    VIOLET("violet"),
    BLUE("blue"),
    CYAN("cyan"),
    GREEN("green"),
    LIME("lime"),
    YELLOW("yellow"),
    ORANGE("orange"),
    WHITE("white"),
    FADING("fading");

    public static final MatterType[] VALUES = values();

    public static MatterType fromOrdinal(int ord) {
        // any invalid value defaults to magenta matter
        return ord < 0 || ord >= VALUES.length ? MAGENTA : VALUES[ord];
    }

    private final String name;

    MatterType(String n) {
        name = n;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
