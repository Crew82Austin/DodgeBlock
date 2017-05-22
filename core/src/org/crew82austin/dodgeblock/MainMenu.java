package org.crew82austin.dodgeblock;

import java.awt.Button;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenu implements Screen{
	
	private SpriteBatch batch;
	private TextButton startBtn;
	private Stage stage;
	private BitmapFont font;
	private Game myGame;
	private TextField userName;
	private Dialog errorBox;
	private float timeSinceBox; //Time Since the Error Dialogue has appeared
	private float errorTime; //How long the Error Dialogue should be visible
	
	public MainMenu(Game game){
		batch = new SpriteBatch();
		
		font = new BitmapFont();
		font.getData().scale(2f);
		
		Window.WindowStyle errorStyle = new Window.WindowStyle(font, Color.WHITE, null);
		errorBox = new Dialog("You Dun Goofed", errorStyle);
	
		timeSinceBox = 0f;
		errorTime = 2000f;
		
		myGame = game;
	
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Show MainMenu screen");
		stage = new Stage();
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		
		
		
		
		
		//Add User Text Field
		userName = new TextField("", new TextField.TextFieldStyle(
				font, Color.BLACK, null, null, null));
		userName.setMessageText("Username");
		userName.setPosition(1920f/2, 40f);
		userName.setSize(300f, 40f);
		stage.addActor(userName);
		
		//Add Start Button
				TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
				
				style.font = font;
				
				startBtn = new TextButton("Start!", style);
				startBtn.setPosition(1920f/2, 500f);
				startBtn.setSize(200f, 40f);
				startBtn.addListener(new ClickListener(){
		            @Override
		            public void clicked(InputEvent event, float x, float y) {
		            	 if(userName.getText().isEmpty()){
		            		
		            		 userName.setMessageText("Enter Name Here");
		            		 errorBox.show(stage);
		            	 }
		            	 else{
		            		 myGame.setScreen(new GameScreen());
		            	 }
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
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
		
		//Handling of Error Dialogue
		if(errorBox.isVisible()){
			errorTime += delta;
			if(delta > errorTime){
				errorBox.hide();
			}
		}
		else{
			errorTime = 0f;
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
