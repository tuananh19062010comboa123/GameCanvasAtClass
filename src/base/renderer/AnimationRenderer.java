package base.renderer;

import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImage = 0;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
    }
    int frameCount = 0;
    @Override
    public void render(Graphics g, GameObject master) {
        if(images.size() > 0) {
            g.drawImage(images.get(currentImage),
                    (int)master.position.x,
                    (int)master.position.y, null);

            if(frameCount > 5) {
                currentImage++;
                if(currentImage >= images.size() - 1) {
                    currentImage = 0;
                }
                frameCount = 0;
            } else {
                frameCount++;
            }
        }
    }
}
