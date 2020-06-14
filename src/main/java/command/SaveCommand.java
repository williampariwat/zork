package command;

import Starter.Starter;

import java.util.ArrayList;

public class SaveCommand implements Command {

    private Starter starter;
    @Override
    public void execute(String s) {
        Starter save = new Starter();
        save = starter;
        save.changeName(s);
        starter.getListOfSave().add(save);
    }
}
