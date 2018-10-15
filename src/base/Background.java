package base;

import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(0,
                -(image.getHeight() - Settings.SCREEN_HEIGHT));
        this.anchor.set(0, 0);
    }

    @Override
    public void run() {
        if(this.position.y >= 0) {
            return;
        } else {
            this.position.y += 1/*speed*/;
        }
    }
}
