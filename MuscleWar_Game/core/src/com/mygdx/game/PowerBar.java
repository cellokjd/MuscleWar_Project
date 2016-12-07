
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class PowerBar {
    Texture bar;
    SpriteBatch batch;

    public PowerBar(SpriteBatch batch,Texture bar) {
        this.batch = batch;
        this.bar = bar;
    }
    
    
    public void Draw(double x){

        batch.draw(bar, (float) x, 20);
//        batch.draw(redBar, 20, 20);

    }
}
