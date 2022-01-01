package demon.base.function;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

/*
 * GenMo demon.base.function
 * @Author:Demon
 * @Date:2021/12/29 11:37
 * @Description:
 */
public enum Audio
{
    BACKGROUND("background.wav"),
    GOLEM_ATTACK("golemAttack.wav"),
    GOLEM_DEATH("golemDeath.wav"),
    GOLEM_HURT1("golemHurt1.wav"),
    GOLEM_HURT2("golemHurt2.wav"),
    GOLEM_RUN("golemRun.wav"),
    PLAYER_ATTACK1("playerAttack1.wav"),
    PLAYER_ATTACK2("playerAttack2.wav"),
    PLAYER_ATTACK3("playerAttack3.wav"),
    PLAYER_DEATH("playerDeath.wav"),
    PLAYER_FALL("playerFall.wav"),
    PLAYER_HURT("playerHurt.wav"),
    PLAYER_MAGIC1("playerMagic1.wav"),
    PLAYER_MAGIC2("playerMagic2.wav");

    private String name;
    Audio(String name)
    {
        this.name = name;
    }

    public void play() {
        AudioStream as = null;
        try {
            InputStream resourceAsStream = Audio.class.getClassLoader().getResourceAsStream(
                    "demon/resources/audio/" + name);
            as = new AudioStream(resourceAsStream);
            AudioPlayer.player.start(as);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
