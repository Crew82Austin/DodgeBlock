package org.crew82austin.dodgeblock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class OptionsScreen implements Screen{

	private Game myGame;
	private BitmapFont font;
	private SpriteBatch batch;
	private TextButton backBtn;
	private Stage stage;
	private MainMenu mainMenu;
	private TextField text;
	
	public OptionsScreen(Game game, MainMenu backMenu){
		
		myGame = game;
		font = new BitmapFont();
		batch = new SpriteBatch();
		mainMenu = backMenu;
		
	}
	@Override
	public void show() {
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		//Add Back Button
		TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
		style.font = font;
		
		backBtn = new TextButton("Back", style);
		backBtn.setPosition(0, Gdx.graphics.getHeight() * 0.05f);
		backBtn.setSize(200f, 40f);
		backBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				myGame.setScreen(mainMenu);
			}
		});
		
		stage.addActor(backBtn);
		
		text = new TextField("This is the Options Screen", new TextField.TextFieldStyle(font, Color.WHITE,
				null, null, null));
		text.setPosition(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f);
		text.setSize(200f, 40f);
		
		stage.addActor(text);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		stage.act();

		batch.begin();
		stage.draw();
		font.draw(batch, "This is the Options Screen ;)", 
				(Gdx.graphics.getWidth() / 2 ) - 100f,
				(Gdx.graphics.getHeight() / 2) - 10f);
		batch.end();
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
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
