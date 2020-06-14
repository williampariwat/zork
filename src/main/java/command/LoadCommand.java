package command;

import Starter.Starter;
import com.sun.tools.javadoc.Start;

public class LoadCommand implements Command {

    private Starter starter;
    @Override
    public void execute(String s) {
        for(int i = 0; i < starter.getListOfSave().size(); i++){
            if(starter.getListOfSave().get(i).getName().equals(s)){
                starter = starter.getListOfSave().get(i);
            }
        }
    }
}
