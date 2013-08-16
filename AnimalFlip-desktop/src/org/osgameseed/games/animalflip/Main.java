package org.osgameseed.games.animalflip;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Pixmap;

import org.lwjgl.opengl.Display;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "AnimalFlip";
		cfg.useGL20 = false;
		cfg.width = 800;
		cfg.height = 600;
        cfg.addIcon("data/ic_launcher_16.png", Files.FileType.Internal);
        cfg.addIcon("data/ic_launcher_32.png", Files.FileType.Internal);
        cfg.addIcon("data/ic_launcher_128.png", Files.FileType.Internal);

        new LwjglApplication(new AnimalFlipGame(), cfg);
	}
}
