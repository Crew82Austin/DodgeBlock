package org.crew82austin.dodgeblock;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;

public class GameRunner {

	
	public enum State{
		PAUSED, RUNNING, FINISHED
	}
	
	private State status;
	private ArrayList<Player> players;
	private boolean isHosting;
	private Random randomizer;
	
	public GameRunner(boolean hosting, Player localPlayer){
		status = State.PAUSED;
		players = new ArrayList<Player>();
		localPlayer.setID(0);
		players.add(localPlayer);
		isHosting = hosting;
		randomizer = new Random(System.currentTimeMillis());
		if(hosting){
			setPlayers();
		}
	}
	
	public GameRunner(boolean hosting, Player localPlayer1, Player localPlayer2){
		status = State.PAUSED;
		players = new ArrayList<Player>();
		localPlayer1.setID(0);
		localPlayer2.setID(1);
		players.add(localPlayer1);
		players.add(localPlayer2);
		isHosting = hosting;
		randomizer = new Random(System.currentTimeMillis());
		if(hosting){
			setPlayers();
		}
	}
	
	/*public GameRunner(State stat){
		players = new ArrayList<Player>();
		players.add(new Player(50f, 50f, 50f, 1000f));
		status = stat;
	}*/
	
	public State getState(){
		return status;
	}
	
	public void setState(State stat){
		status = stat;
		System.out.println("GameRunner set state to "+status);
	}
	
	public void setPlayers(){
		int[] types = new int[players.size()];
		int rands = 0;
		int next;
		for(int c = 0; c < types.length; c++){
			types[c] = -1;
		}
		for(int b = 0; b < types.length; b++){
				next = randomizer.nextInt(players.size());
				for(int c = 0; c < types.length; c++){
					while(types[c] == next){
						next = randomizer.nextInt(players.size());
					}
				}
				types[b] = next;
			rands++;
			System.out.println(types[b]);
		}
		
		for(int d = 0; d < players.size(); d++){
			players.get(d).setType(types[d]);
		}
	
		
		
		for(int a = 0; a < players.size(); a++){
			if(players.get(a).getType() == 0){
				players.get(a).setPlayer(50f, 50f, 40f, 200f);
			}
			else if(players.get(a).getType() == 1){
				players.get(a).setPlayer(500f, 500f, 10f, 300f);
			}
		}
	}
	public void update(float time){
		
		if(status == State.RUNNING){
			for(int a = 0; a < players.size(); a++){
				players.get(a).update(time);
			}
		}
		
	}

	public ArrayList<Player> getCurrentPlayers(){
		return players;
	}
	
	public void updateLocal(Player player){
		for(int a = 0; a < players.size(); a++){
			players.set(player.getID(), player);
	}
	}
	
	
}