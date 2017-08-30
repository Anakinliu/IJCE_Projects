package Essay;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Anakinliu on 2017/8/12.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class MyAudio {
    public static void main(String[] args) {
        try {
            System.out.println(
                    AudioSystem.getAudioFileFormat(
                            new File("H:/CloudMusic/Linkin Park - Numb.mp3")));
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
}
