package base.renderer;

import base.GameObject;
import base.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRenderer extends Renderer {
    BufferedImage image;

    public SingleImageRenderer(String url) {
        this.image = SpriteUtils.loadImage(url);
    }

    public SingleImageRenderer(BufferedImage image) {
        this.image = image;
    }
    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.image, (int)master.position.x
            ,(int)master.position.y, null);
    }
}
