package org.crew82austin.dodgeblock.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.crew82austin.dodgeblock.DodgeBlock;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DodgeBlock(), config);
		config.height = 1080;
		config.width = 1920;
	}
}
