package game;

import base.*;
import base.enemy.Enemy;
import base.enemy.EnemyType1;
import base.player.Player;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    Background background;
    Player player;

    public GameCanvas() {
        this.background = GameObject.recycle(Background.class);
        this.player = GameObject.recycle(Player.class);
        EnemyType1 enemy = GameObject.recycle(EnemyType1.class);
    }

    public void run() {
        GameObject.runAll();
    }

    public void render() {
        GameObject.renderAllToBackBuffer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        GameObject.renderBackBufferToGame(g);
    }
}
