package com.example.poprojekt;

public class Settings {
    private static int size;
    private static int wolfs;
    private static int sheep;

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Settings.size = size;
    }

    public static int getWolfs() {
        return wolfs;
    }

    public static void setWolfs(int wolfs) {
        Settings.wolfs = wolfs;
    }

    public static int getSheep() {
        return sheep;
    }

    public static void setSheep(int sheep) {
        Settings.sheep = sheep;
    }
}
