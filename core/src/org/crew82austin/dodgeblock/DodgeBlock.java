package org.crew82austin.dodgeblock;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class DodgeBlock extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    ArrayList<Player> players;
    private float deltaT;
    GameRunner runner;
    
	@Override
	public void create () {
		batch = new SpriteBatch();
		deltaT = 0;
		runner = new GameRunner(true);
		System.out.println("State is "+runner.getState());
		Gdx.input.setInputProcessor(runner);
	}

	@Override
	public void render () {
		deltaT = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		runner.update(deltaT);
	
		
	}
	
	public void dispose(){
		img.dispose();
		batch.dispose();
	}
	
	public void updatePlayers(float deltaT){
		
		for(int a = 0; a < players.size(); a++){
			players.get(a).update(deltaT);
		}
	}
	
	

	
}
