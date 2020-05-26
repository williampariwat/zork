package command;

public class getterCommand {
    private CommandWord firstWord;
    private String secondWord;

    public getterCommand(CommandWord first, String second){
        this.firstWord = first;
        this.secondWord = second;
    }

    public CommandWord getFirstWord(){ return this.firstWord;}

    public String getSecondWord(){return this.secondWord;}

    public boolean isUnknown() {return this.firstWord == null; }

    public boolean hasSecondWord() { return this.secondWord != null; }


}
