package com.lomianki;

public class Player {
    private String name;

    public Player(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Pole name jest null'em lub puste");
        } else {
            this.name = name;
        }
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[<"+name+">]";
    }
}
