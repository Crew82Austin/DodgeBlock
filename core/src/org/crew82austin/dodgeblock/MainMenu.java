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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenu implements Screen{
	
	private SpriteBatch batch;
	private TextButton hostBtn;
	private TextButton joinBtn;
	private TextButton optionsBtn;
	private Texture logoTexture;
	private Image logo;
	private Stage stage;
	private BitmapFont font;
	private Game myGame;
	private TextField userName;
	private Dialog errorBox;
	private float timeSinceBox; //Time Since the Error Dialogue has appeared
	private float errorTime; //How long the Error Dialogue should be visible
	private boolean displayingError;//Is that box being displayed?
	
	public MainMenu(Game game){
		batch = new SpriteBatch();
		
		font = new BitmapFont();
		font.setColor(Color.CYAN);
		font.getData().scale(2f);
		
		Window.WindowStyle errorStyle = new Window.WindowStyle(font, Color.BLACK, null);
		errorBox = new Dialog("You Dun Goofed", errorStyle);
		timeSinceBox = 0f;
		errorTime = 2f;
		displayingError = false;
		
		logoTexture = new Texture(Gdx.files.internal("DB.png"));
		logo = new Image(logoTexture);
		logo.setPosition((Gdx.graphics.getWidth() / 2f) - 250f, 
				Gdx.graphics.getHeight() - 400f);
		
		myGame = game;
		
	
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Show MainMenu screen");
		stage = new Stage();
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		
		
		
		
		
		//Add Name Text Field
		userName = new TextField("", new TextField.TextFieldStyle(
				font, Color.BLACK, null, null, null));
		userName.setMessageText("         Username");//Spaces for Centering
		userName.setPosition(
				(Gdx.graphics.getWidth()/2) - 250f,
				(Gdx.graphics.getHeight() - 500f));
		userName.setSize(500f, 100f);
		stage.addActor(userName);
		
		//Add Host Button
		TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
				
		style.font = font;
				
		hostBtn = new TextButton("Host", style);
		hostBtn.setPosition(
				(Gdx.graphics.getWidth()/2) + 175f,
				(Gdx.graphics.getHeight()/3));
		hostBtn.setSize(200f, 40f);
		hostBtn.addListener(new ClickListener(){
		        @Override
		          public void clicked(InputEvent event, float x, float y) {
		            if(userName.getText().isEmpty()){
		            		
		            	userName.setMessageText("         Enter Name Here");//Spacing for Centering
		            	errorBox.show(stage);
		            	displayingError = true;
		            }
		            else{
		            	myGame.setScreen(new GameScreen());
		            }
		          }
		      });
				
		stage.addActor(hostBtn);
				
		//Add Join Button
		joinBtn = new TextButton("Join", style);
		joinBtn.setPosition(
				(Gdx.graphics.getWidth()/2) - 300f,
				(Gdx.graphics.getHeight()/3));
		joinBtn.setSize(200f, 40f);
		joinBtn.addListener( new ClickListener(){
			@Override
	          public void clicked(InputEvent event, float x, float y) {
	            if(userName.getText().isEmpty()){
	            		
	            	userName.setMessageText("         Enter Name Here");//Spacing for Centering
	            	errorBox.show(stage);
	            	displayingError = true;
	            }
	            else{
	            	myGame.setScreen(new JoinScreen(myGame));
	            }
	          }
		});
		
		stage.addActor(joinBtn);
				
		//Add Options Button 
		optionsBtn = new TextButton("Options", style);
		optionsBtn.setPosition(
				(Gdx.graphics.getWidth() / 2) - 100f,
				(5f));
		optionsBtn.setSize(200f, 40f);
		optionsBtn.addListener(new ClickListener(){
			@Override
	          public void clicked(InputEvent event, float x, float y) {
	           myGame.setScreen(new OptionsScreen(myGame));
			}
		});
		
		stage.addActor(optionsBtn);
		
		
		//Add Logo
		stage.addActor(logo);
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);


		stage.act();
		
		batch.begin();
		stage.draw();
		batch.end();
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
		
		//Handling of Error Dialogue
		if(displayingError){
			timeSinceBox += delta;
			System.out.println(timeSinceBox);
			if(timeSinceBox > errorTime){
				System.out.println("Hiding Error");
				errorBox.hide();
				displayingError = false;
			}
		}
		else{
			timeSinceBox = 0f;
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
