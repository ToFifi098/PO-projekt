package com.example.poprojekt;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Settings {
    private static int size;
    private static int wolfs;
    private static int sheep;

    private static int grassRate = 15;

    private static int maxEnergySheep = 5;
    private static int maxEnergyWolf = 15;

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

    public static int getGrassRate() {
        return grassRate;
    }

    public static int getMaxEnergySheep() {
        return maxEnergySheep;
    }

    public static int getMaxEnergyWolf() {
        return maxEnergyWolf;
    }
}
