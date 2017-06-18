package org.crew82austin.dodgeblock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenu implements Screen {

  private Texture logoTexture;
  private Stage stage;
  private Skin skin;
  private DodgeBlock myGame;
  private TextField userName;
  private Dialog errorBox;
  private float timeSinceBox; // Time Since the Error Dialogue has appeared
  private float errorTime; // How long the Error Dialogue should be visible
  private boolean displayingError;// Is that box being displayed?
  private MainMenu self;
  private String user;

  public MainMenu(DodgeBlock game) {
    self = this;    // used in anonymous functions...
    myGame = game;
    user = "";

    stage = new Stage(myGame.getViewport());
    skin = new Skin(Gdx.files.internal("assets/uiskin.json"));

    errorBox = new Dialog("You Dun Goofed", skin);
    timeSinceBox = 0f;
    errorTime = 2f;
    displayingError = false;
    logoTexture = new Texture(Gdx.files.internal("assets/DB.png"));
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub
    System.out.println("Show MainMenu screen");
    stage.clear();
    Gdx.input.setInputProcessor(stage);

    VerticalGroup vg = new VerticalGroup();
    vg.space(20.0f);
    vg.setFillParent(true);

    // Add Logo
    Image logo = new Image(logoTexture);
    vg.addActor(logo);

    // Add Name Text Field
    userName = new TextField("", skin);
    userName.setMessageText("Username");
    if (!user.isEmpty()) {
      userName.setText(user);
    }
    vg.addActor(userName);

    // Add a Host button
    TextButton hostBtn = new TextButton("Host", skin);
    hostBtn.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        if (userName.getText().isEmpty()) {
          userName.setMessageText("Enter Name Here");
          errorBox.show(stage);
          displayingError = true;
        } else {
          user = userName.getText();
          myGame.setScreen(new HostScreen(myGame, self));
        }
      }
    });
    vg.addActor(hostBtn);

    // Add Join Button
    TextButton joinBtn = new TextButton("Join", skin);
    joinBtn.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        if (userName.getText().isEmpty()) {

          userName.setMessageText("Enter Name Here");
          errorBox.show(stage);
          displayingError = true;
        } else {
          user = userName.getText();
          myGame.setScreen(new JoinScreen(myGame, self));
        }
      }
    });
    vg.addActor(joinBtn);

    // Add Options Button
    TextButton optionsBtn = new TextButton("Options", skin);
    optionsBtn.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        myGame.setScreen(new OptionsScreen(myGame, self));
      }
    });
    vg.addActor(optionsBtn);

    // We're done! Now, just add the VerticalGroup as an Actor on the
    // Stage...
    stage.addActor(vg);
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(1, 1, 1, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.act(delta);
    stage.draw();

    if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
      Gdx.app.exit();
    }

    // Handling of Error Dialogue
    if (displayingError) {
      timeSinceBox += delta;
      System.out.println(timeSinceBox);
      if (timeSinceBox > errorTime) {
        System.out.println("Hiding Error");
        errorBox.hide();
        displayingError = false;
      }
    } else {
      timeSinceBox = 0f;
    }
  }

  @Override
  public void resize(int width, int height) {
    stage.getViewport().update(width, height, true);
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
    logoTexture.dispose();
    stage.dispose();
    skin.dispose();
  }

  public String getUser() {
    if (user.isEmpty()) {
      return "N/A";
    } else {
      return user;
    }
  }

}
