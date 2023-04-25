package com.lomianki;

public class Player implements Comparable<Player> {
    private String name;
    private int points;

    public Player(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Pole name jest null'em lub puste");
        } else {
            this.name = name;
        }
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint(int points){
        this.points+=points;
    }

    @Override
    public String toString() {
        return "[<" + name + ">]" + " zodobyl punktów: "+ points;
    }

    @Override
    public int compareTo(Player o) {
        if (points == 0 || o.points == 0) {
            return 0;
        }
        return Integer.compare(o.points,points);
    }
}
