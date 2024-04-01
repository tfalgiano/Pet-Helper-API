package org.opensource.pethelper.enums;

public enum Services {
    GROOMER,
    SHELTER,
    VETERINARIAN,
    PET_STORE {
        @Override
        public String toString() {
            return formatEnumName(super.toString());
        }
    };

    private static String formatEnumName(String name) {
        return name.replace('_', '-').toLowerCase();
    }
}