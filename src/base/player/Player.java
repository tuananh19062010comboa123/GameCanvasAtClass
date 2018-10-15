package base.player;

import base.*;
import base.counter.FrameCounter;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider collider;
    int hp;
    Vector2D velocity;

    public Player() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X
                , Settings.START_PLAYER_POSITION_Y);
        this.fireCounter = new FrameCounter(10);
        this.collider = new BoxCollider(32, 48);
        this.hp = 20;
        this.velocity = new Vector2D(0, 0);
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress) {
            this.move(0, -1);
        }
        if(KeyEventPress.isDownPress) {
            this.move(0, 1);
        }
        if(KeyEventPress.isRightPress) {
            this.move(1, 0);
        }
        if(KeyEventPress.isLeftPress) {
            this.move(-1, 0);
        }
        //fire
        boolean fireCounterRun = this.fireCounter.run();
        if(KeyEventPress.isFirePress && fireCounterRun) {
            this.fire();
        }
        this.position.addThis(this.velocity);
    }

    public void fire() {
//        PlayerBullet bullet = new PlayerBullet();
//        GameCanvas.playerBullets.add(bullet);
        PlayerBulletType1 bullet = GameObject.recycle(PlayerBulletType1.class);
        PlayerBulletType1 bullet2 = GameObject.recycle(PlayerBulletType1.class);
        PlayerBulletType1 bullet3 = GameObject.recycle(PlayerBulletType1.class);

        bullet.velocity.set(0, -1);
        bullet2.velocity.set(1, -1);
        bullet3.velocity.set(-1, -1);

        bullet.position.set(this.position.x, this.position.y);        bullet.position.set(this.position.x, this.position.y);
        bullet2.position.set(this.position.x, this.position.y);
        bullet3.position.set(this.position.x, this.position.y);

        this.fireCounter.reset();
    }

    public void move(int velocityX, int velocityY) {
        this.velocity.addThis(velocityX, velocityY);
        this.velocity.set(clamp(velocity.x, -3, 3),
                clamp(velocity.y, -3, 3));
    }

    public float clamp(float number, float min, float max) {
        return number < min ? min : number > max ? max : number;
    }


    public void takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp <= 0) {
            this.destroy(); //this.isActive = false
            hp = 0;
            //...
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
