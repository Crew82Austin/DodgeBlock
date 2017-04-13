package org.crew82austin.dodgeblock;

import java.awt.Color;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Player implements Movable{

	private float posX; //Current x position of the player
	private float posY; //Current y position of the player
	private float pSize; //Length of each edge of the square
	private float pSpeed; //Amount the player moves per second
	private Texture img;
	private ShapeRenderer rend;
	private boolean up; //Movement booleans
	private boolean down;
	private boolean right;
	private boolean left;
	private float bX1; // Boundaries, player won't move left of x1 or right of x2
	private float bX2;
	private float bY1; //Player won't move below y1 or above y2
	private float bY2;
	private boolean local; //is the player playing on this machine
	private Color color;
	private int pType; //is the player player 1, 2, 3, etc.
	private String pName;
	
	
	//Called when the player is created, initializations
	public Player(boolean isLocal, String name){ 
		
		rend = new ShapeRenderer(200);
		
		rend.setAutoShapeType(false);
		pName = name;
		up = false;
		down = false;
		left = false;
		right = false;
		bX1 = 0;
		bX2 = Gdx.graphics.getWidth();
		bY1 = 0; 
		bY2 = Gdx.graphics.getHeight();
		local = isLocal;
		System.out.println("Created player "+pName+" at "+posX+","+posY+"\n size "+pSize+"\nspeed "+pSpeed+" \n"
				+ "boundries X "+bX1+"->"+bX2+", Y "+bY1+"->"+bY2);
	}

	public void setPlayer(float x, float y, float size, float speed){
		posX = x;
		posY = y;
		pSize = size;
		pSpeed = speed;
		if(pType == 0){
			color = Color.RED;
		}
		if(pType == 1){
			color = Color.GREEN;
		}
	}
	
	public void setType(int type){
		pType = type;
		
	}
	
	public int getType(){
		return pType;
	}
	
	@Override
	public void update(float time) {
		
		float speedAmount = pSpeed * time;
		if(up){
			if (posY + speedAmount + pSize < bY2)
				posY += speedAmount;
			else
				posY = bY2 - pSize;
		}
		if(down){
			if (posY - speedAmount > bY1)
				posY -= speedAmount;
			else
				posY = bY1;
		}
		
		if(right){
			if(posX + speedAmount + pSize < bX2)
				posX += speedAmount;
			else
				posX = bX2 - pSize;
		}
		if(left){
			if(posX - speedAmount > bX1)
				posX -= speedAmount;
			else
				posX = bX1;
		}
		
		//System.out.println(up+" "+down+" "+right+" "+left);
	}

	@Override
	public void move(float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return posX;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return posY;
	}
	
	public float getSize(){
		return pSize;
	}
	
	public String getName(){
		return pName;
	}

	@Override
	public void draw() {
		rend.setColor(1f, 0f, 0f, 1f);
		rend.begin(ShapeType.Filled);
		rend.rect(posX, posY, pSize, pSize);
		rend.end();
		
		return;
		
	}

	@Override
	public void up(boolean move) {
		up = move;
		return;
		
	}

	@Override
	public void down(boolean move) {
		down = move;
		return;
		
	}

	@Override
	public void right(boolean move) {
		right = move;
		return;
		
	}

	@Override
	public void left(boolean move) {
		left = move;
		return;
		
	}
	
	public void setBounds(int x1, int x2, int y1, int y2){
		bX1 = x1;
		bX2 = x2;
		bY1 = y1;
		bY2 = y2;
		return;
	}
	
	public boolean isLocal(){
		return local;
	}
}
