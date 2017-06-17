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

public class JoinScreen implements Screen {

	private TextButton joinBtn, backBtn;
	private Game myGame;
	private BitmapFont font;
	private SpriteBatch batch;
	private Stage stage;
	private MainMenu mainMenu;
	private TextField userName, serverText;
	private ServerList serverList;
	
	public JoinScreen(Game game, MainMenu backMenu){
		
		myGame = game;
		mainMenu = backMenu;
		font = new BitmapFont();
		batch = new SpriteBatch();
		serverList = new ServerList(
				Gdx.graphics.getWidth() * 0.15f, Gdx.graphics.getHeight() * 0.30f,
				Gdx.graphics.getWidth() * 0.50f, Gdx.graphics.getHeight() * 0.50f);
		
		
	}
	@Override
	public void show() {
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
		style.font = font;
		
		//Add user Name
		userName = new TextField(mainMenu.getUser(), new TextField.TextFieldStyle(
				font, Color.WHITE, null, null, null));
		userName.setPosition(
				Gdx.graphics.getWidth()* 0.95f,
				Gdx.graphics.getHeight() * 0.90f);
		userName.setSize(200f, 100f);
		
		stage.addActor(userName);
		
		//Add Server List Text
		serverText = new TextField(serverList.getText(), new TextField.TextFieldStyle(
				font, Color.WHITE, null, null, null));
		serverText.setPosition(serverList.getX(), serverList.getY() + serverList.getHeight());
		serverText.setBounds(serverList.getX(), serverList.getY(),
				serverList.getWidth(), serverList.getHeight());
		
		
		stage.addActor(serverText);
		
		//Set join button
		joinBtn = new TextButton("Join", style);
		joinBtn.setPosition(Gdx.graphics.getWidth() * 0.40f, 
				Gdx.graphics.getHeight() * 0.20f);
		joinBtn.setSize(40f, 200f);
		joinBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				if(true){
					//Go to the join screen of the server if a server is selected
					//Else do nothing
				}
			}
		});
		
		stage.addActor(joinBtn);
		
		//Add Back Button
		backBtn = new TextButton("Back", style);
		backBtn.setPosition(Gdx.graphics.getWidth() * 0.60f, 
				Gdx.graphics.getHeight() * 0.20f);
		backBtn.setSize(40f, 200f);
		backBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				myGame.setScreen(mainMenu);
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
