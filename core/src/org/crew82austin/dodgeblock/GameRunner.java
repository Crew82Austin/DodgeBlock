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
	private Startup starter;
	private Player winner;
	
	public GameRunner(boolean hosting, Player localPlayer){
		starter = new Startup();
		starter.displayStart();
		
		status = State.PAUSED;
		players = new ArrayList<Player>();
		localPlayer.setID(0);
		players.add(localPlayer);
		isHosting = hosting;
		randomizer = new Random(System.currentTimeMillis());
		winner = null;
		if(hosting){
			setPlayers();
		}
	}
	
	public GameRunner(boolean hosting, Player localPlayer1, Player localPlayer2){
		starter = new Startup();
		starter.displayStart();
		
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
	
	
	public void newGame(){
		if(isHosting){
			winner = null;
			for(int a = 0; a < players.size(); a++){
				players.get(a).zeroAll();
			}
			setPlayers();
			
			status = State.RUNNING;
		}
	}
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
		
		winner = checkWin();
		if(winner != null){
			status = State.FINISHED;
		}
		
		if(status == State.RUNNING){
			for(int a = 0; a < players.size(); a++){
				players.get(a).update(time);
			}
		}
		
		
	}
	
	public Player getWinner(){
		return winner;
	}
	
	public Player checkWin(){
		Player player0 = null;
		Player player1 = null;
		
		for(int a = 0; a < players.size(); a++){
			if(players.get(a).getType() == 0){
				player0 = players.get(a);
			}
			else if(players.get(a).getType() == 1){
				player1 = players.get(a);
			}
		}
		
		float dX = Math.abs(player0.getCenterX() - player1.getCenterX());
		float dY = Math.abs(player0.getCenterY() - player1.getCenterY());
		
		float dSize = Math.abs(player0.getSize() + player1.getSize()) / 2;
		
		if(dX < dSize && dY < dSize){
			return player0;
		}
		else{
			return null;
		}
	}

	public double getAngle(Object a, Object b){
		double angle = 0;
		if(a instanceof Player && b instanceof Player){
			Player a1 = (Player)a;
			Player b1 = (Player)b;
			double dX = (double)(a1.getCenterX() - b1.getCenterX());
			double dY = (double)(a1.getCenterY() - b1.getCenterY());
			angle = Math.atan(dY/dX);
		}
		
		return angle;
	}
	public double getDistance2(Object a, Object b){
		double distance2 = 0;
		
		if(a instanceof Player && b instanceof Player){
			Player a1 = (Player)a;
			Player b1 = (Player)b;
			double dX = (double)(a1.getCenterX() - b1.getCenterX());
			double dY = (double)(a1.getCenterY() - b1.getCenterY());
			distance2 = (dX * dX) + (dY * dY);
		}
		
		return distance2;
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