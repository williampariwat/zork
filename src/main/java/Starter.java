import command.Command;
import command.CommandFactory;
import command.Introduction;

import java.util.Scanner;

public class Starter {
    public void Starter(){
        Scanner scanner = new Scanner(System.in);

        String cmd = "";

        Introduction welcome = new Introduction();
        welcome.shout();

        while(!"exit".equals(cmd)){
            System.out.println("> ");
            cmd = scanner.next();
            String[] words = cmd.split(" ");

            Command command = CommandFactory.getCommand(words[0]);

            if (command != null){
                if(words.length == 1){
                    command.execute(words.length == 1 ? null : words[1]);
                }
            }
        }
    }
}
