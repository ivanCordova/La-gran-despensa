//Methods Sound
package Methods;

import java.applet.AudioClip;

public class Sound {

    public void clic() {
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Clic.wav"));
        sound.play();
    }

    public void executed() {
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Executed.wav"));
        sound.play();
    }

    public void input() {
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/input.wav"));
        sound.play();
    }

    public void error() {
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Error.wav"));
        sound.play();
    }

    public void information() {
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Information.wav"));
        sound.play();
    }

    public void login() {
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Login.wav"));
        sound.play();
    }

    public void minimize() {
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Minimize.wav"));
        sound.play();
    }

    public void close() {
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Close.wav"));
        sound.play();
    }

    public void warning() {
        AudioClip sound;
        sound = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/Warning.wav"));
        sound.play();
    }

}
