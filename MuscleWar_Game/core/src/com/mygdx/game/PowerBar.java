
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class PowerBar {
    Texture redBar = new Texture("red.png");
    SpriteBatch batch;

    public PowerBar(SpriteBatch batch) {
        this.batch = batch;
    }
    
    
    public void Draw(int x){

        batch.draw(redBar, x, 20);
//        batch.draw(redBar, 20, 20);

    }
}