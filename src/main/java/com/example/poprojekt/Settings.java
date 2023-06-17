package com.example.poprojekt;

/**
 * Ustawienia dla całej symulacji
 */

public class Settings {
    private static int size;
    private static int wolfs;
    private static int sheep;
    private static final int grassRate = 15;
    private static final int maxEnergySheep = 5;
    private static final int maxEnergyWolf = 10;
    private static final int multiplyChance= 20;

    /**
     * Zwraca szanse na rozmnożenie
     * @return multiplyChance
     */

    public static int getMultiplyChance() {
        return multiplyChance;
    }

    /**
     * Zwraca rozmiar mapy
     * @return size
     */
    public static int getSize() {
        return size;
    }

    /**
     * Ustawia rozmiar mapy
     * @param size rozmiar
     */
    public static void setSize(int size) {
        Settings.size = size;
    }

    /**
     * Zwraca początkową liczbę wilków
     * @return wolfs
     */
    public static int getWolfs() {
        return wolfs;
    }

    /**
     * Ustawia początkową liczbę wilków
     * @param wolfs liczba wilków
     */
    public static void setWolfs(int wolfs) {
        Settings.wolfs = wolfs;
    }

    /**
     * Zwraca początkową liczbę owiec
     * @return sheep
     */
    public static int getSheep() {
        return sheep;
    }

    /**
     * Ustawia początkową liczbę owiec
     * @param sheep liczba owiec
     */
    public static void setSheep(int sheep) {
        Settings.sheep = sheep;
    }

    /**
     * Zwraca liczbę rund po której odrasta trawa
     * @return grassRate
     */
    public static int getGrassRate() {
        return grassRate;
    }

    /**
     * Zwraca maksymalną energię dla Owiec
     * @return maxEnergySheep
     */
    public static int getMaxEnergySheep() {
        return maxEnergySheep;
    }

    /**
     * Zwraca maksymalną energię dla Wilków
     * @return maxEnergyWolf
     */
    public static int getMaxEnergyWolf() {
        return maxEnergyWolf;
    }
}
