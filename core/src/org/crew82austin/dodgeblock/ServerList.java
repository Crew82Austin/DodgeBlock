package org.crew82austin.dodgeblock;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ServerList {

	private float x;
	private float y;
	private float width;
	private float height;
	private ArrayList<String> servers;
	private String text;
	
	public ServerList(float listX, float listY, float listWidth, float listHeight){
		x = listX;
		y = listY;
		width = listWidth;
		height = listHeight;
		servers = new ArrayList<String>();
		text = "";
		updateText();
	}
	
	public void updateText(){
		text = "\n\n\n          this is the server list";
	}
	public String getText(){
		return text;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getHeight(){
		return height;
	}
	
	public float getWidth(){
		return width;
	}
}
