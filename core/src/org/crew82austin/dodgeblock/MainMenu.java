package org.crew82austin.dodgeblock;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenu implements Screen{
	
	private SpriteBatch batch;
	private TextButton startBtn;
	private Stage stage;
	private BitmapFont font;
	private Game myGame;
	
	
	public MainMenu(Game game){
		batch = new SpriteBatch();
		font = new BitmapFont();
		myGame = game;
	
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Show MainMenu screen");
		stage = new Stage();
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		
		TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
		
		style.font = font;
		
		startBtn = new TextButton("Start!", style);
		startBtn.setPosition(500f, 500f);
		startBtn.setSize(200f, 40f);
		startBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                 myGame.setScreen(new GameScreen());
            }
        });
		
		stage.addActor(startBtn);
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 0, 0, 1);


		stage.act();

		batch.begin();
		stage.draw();
		batch.end();
		
		

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
