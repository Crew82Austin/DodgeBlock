package org.crew82austin.dodgeblock;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class DodgeBlock extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture img;
    ArrayList<Player> players;
    private float deltaT;
    GameRunner runner;
    Player localPlayer;
    BitmapFont font;
    
	@Override
	public void create () {
		batch = new SpriteBatch();
		deltaT = 0;
		localPlayer = new Player(true, "Justin");
		runner = new GameRunner(true, localPlayer);
		font = new BitmapFont();
		batch = new SpriteBatch();
		System.out.println("State is "+runner.getState());
		Gdx.input.setInputProcessor(this);
		players = new ArrayList<Player>();
		runner.setState(GameRunner.State.RUNNING);
	}

	@Override
	public void render () {
		deltaT = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		runner.update(deltaT);
		players = runner.getCurrentPlayers();
		batch.begin();
		for(int c = 0; c < players.size(); c++){
			float px = players.get(c).getX() + players.get(c).getSize() + 2;
			float py = players.get(c).getY() + players.get(c).getSize() + 2;
			font.draw(batch, players.get(c).getName(), px, py);
		}
		batch.end();
		for(int b = 0; b < players.size(); b++){
			players.get(b).draw();
		}
		runner.updateLocal(localPlayer);
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
	
	
	@Override
	public boolean keyDown(int keycode) {
		
		switch(keycode){
			case Input.Keys.ESCAPE:
				System.out.println("Escape Pressed");
				System.exit(0);
			case Input.Keys.A:
				localPlayer.left(true);
				break;
			case Input.Keys.D:
				localPlayer.right(true);
				break;
			case Input.Keys.W:
				localPlayer.up(true);
				break;
			case Input.Keys.S:
				localPlayer.down(true);
				break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		switch(keycode){
		case Input.Keys.A:
			localPlayer.left(false);
			break;
		case Input.Keys.D:
			localPlayer.right(false);
			break;
		case Input.Keys.W:
			localPlayer.up(false);
			break;
		case Input.Keys.S:
			localPlayer.down(false);
			break;
		}
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
