package game;

import base.Background;
import base.Enemy;
import base.Player;
import base.PlayerBullet;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<PlayerBullet> playerBullets;

    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
        enemies = new ArrayList<>();
        playerBullets = new ArrayList<>();
    }

    public void run() {
        background.run();
        player.run();
        for(Enemy enemy : enemies) {
            enemy.run();
        }
        for(PlayerBullet playerBullet : playerBullets) {
            playerBullet.run();
        }
    }

    public void render(Graphics g) {
        background.render(g);
        player.render(g);
        for(Enemy enemy : enemies) {
            enemy.render(g);
        }
        for(PlayerBullet playerBullet : playerBullets) {
            playerBullet.render(g);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}
