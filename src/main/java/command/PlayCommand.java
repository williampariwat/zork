package command;

import Starter.Starter;
import Starter.Main;

public class PlayCommand implements Command {

    @Override
    public void execute(String s) {
        if(s.isEmpty()){
            Starter game = new Starter();
            game.Starter();
        }
    }
}
