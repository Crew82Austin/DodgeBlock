package org.crew82austin.dodgeblock;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class HostScreen implements Screen {

	private Game myGame;
	private TextField ipField;
	private TextField portField;
	private TextButton backBtn, startBtn;
	private Stage stage;
	private BitmapFont font;
	private MainMenu back;
	private SpriteBatch batch;
	
	public HostScreen(Game game, MainMenu backMenu){
		
		font = new BitmapFont();
		back = backMenu;
		batch = new SpriteBatch();
		myGame = game;
		
	}
	@Override
	public void show() {
	
		//Add Stage
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
		style.font = font;
		
		//Add IP Field
		ipField = new TextField("127.0.0.___", new TextField.TextFieldStyle(font, Color.WHITE,
				null, null, null));
		ipField.setPosition(Gdx.graphics.getWidth() * 0.25f, Gdx.graphics.getHeight() * 0.85f);
		ipField.setSize(200f, 40f);
		
		stage.addActor(ipField);
		
		//Add Port Field
		portField = new TextField("", new TextField.TextFieldStyle(font, Color.WHITE,
				null, null, null));
		portField.setMessageText("Enter Port Number Here");
		portField.setPosition(ipField.getX(), ipField.getY() - ipField.getHeight()*2f);
		portField.setSize(ipField.getWidth(), ipField.getHeight());
		
		stage.addActor(portField);
		
		//Add Start Button
		startBtn = new TextButton("Start", style);
		startBtn.setPosition(Gdx.graphics.getWidth() * 0.50f, Gdx.graphics.getHeight() * 0.05f);
		startBtn.setSize(200f, 40f);
		startBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				if(portField.getText().isEmpty()){
					portField.setMessageText("ENTER THE PORT!!!");
				}
				else{
					myGame.setScreen(new GameScreen());
				}
			}
		});
		
		stage.addActor(startBtn);
		
		//Add Back Button
		backBtn = new TextButton("Back", style);
		backBtn.setPosition(0f, Gdx.graphics.getHeight() * 0.05f);
		backBtn.setSize(200f, 40f);
		backBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				myGame.setScreen(back);
			}
		});
		
		stage.addActor(backBtn);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);

		stage.act();
		
		batch.begin();
		stage.draw();
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
