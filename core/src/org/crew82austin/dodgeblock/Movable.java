package org.crew82austin.dodgeblock;

public interface Movable {

	public void update(float time);
	public void move(float x, float y);
	public float getX();
	public float getY();
	public void draw();
	public void up(boolean move);
	public void down(boolean move);
	public void right(boolean move);
	public void left(boolean move);
}
