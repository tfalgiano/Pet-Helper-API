package org.opensource.pethelper.utility;

public class Utility {
    public static <T extends Enum<T>> String formatEnumName(T enumValue) {
        return enumValue.toString().replace('_', ' ').toLowerCase();
    }
}
