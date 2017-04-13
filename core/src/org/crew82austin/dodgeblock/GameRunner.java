package org.crew82austin.dodgeblock;

import java.util.ArrayList;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class GameRunner implements InputProcessor {

	
	public enum State{
		PAUSED, RUNNING, FINISHED
	}
	
	private State status;
	private ArrayList<Player> players;
	private boolean isHosting;
	
	public GameRunner(boolean hosting){
		status = State.PAUSED;
		players = new ArrayList<Player>();
		players.add(new Player(50f, 50f, 50f, 1000f));
		isHosting = hosting;
	}
	
	/*public GameRunner(State stat){
		players = new ArrayList<Player>();
		players.add(new Player(50f, 50f, 50f, 1000f));
		status = stat;
	}*/
	
	public State getState(){
		return status;
	}
	
	public void update(float time){
		
		for(int a = 0; a < players.size(); a++){
			players.get(a).update(time);
		}
		for(int b = 0; b < players.size(); b++){
			players.get(b).draw();
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		
		switch(keycode){
			case Input.Keys.ESCAPE:
				System.out.println("Escape Pressed");
				System.exit(0);
			case Input.Keys.A:
				players.get(0).left(true);
				break;
			case Input.Keys.D:
				players.get(0).right(true);
				break;
			case Input.Keys.W:
				players.get(0).up(true);
				break;
			case Input.Keys.S:
				players.get(0).down(true);
				break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		switch(keycode){
		case Input.Keys.A:
			players.get(0).left(false);
			break;
		case Input.Keys.D:
			players.get(0).right(false);
			break;
		case Input.Keys.W:
			players.get(0).up(false);
			break;
		case Input.Keys.S:
			players.get(0).down(false);
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