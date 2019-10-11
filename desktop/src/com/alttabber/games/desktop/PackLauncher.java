package com.alttabber.games.desktop;

import com.badlogicgames.packr.Packr;
import com.badlogicgames.packr.PackrConfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PackLauncher {

    public static void main(String[] args) throws IOException {
        PackrConfig config = new PackrConfig();
        config.platform = PackrConfig.Platform.Windows64;
        config.jdk = "C:\\Program Files\\Java\\jdk-9.0.4";
        config.executable = "Nothing";
        config.classpath = Arrays.asList("D:\\code\\gdx\\ludum-start\\desktop\\build\\libs\\desktop-1.0.jar");
        config.removePlatformLibs = config.classpath;
        config.mainClass = "com.alttabber.games.desktop.DesktopLauncher";
        config.vmArgs = Arrays.asList("Xmx1G");
        config.minimizeJre = "soft";
//        config.outDir = new File("D:\\code\\gdx");

        new Packr().pack(config);
    }
}
