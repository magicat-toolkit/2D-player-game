package enums;

public enum Actions {

    UP('W'), DOWN('S'), LEFT('A'), RIGHT('D'), INVENTORY('I');

    private final char actionChar;

    Actions(char actionChar) {
        this.actionChar = actionChar;
    }

    public char getActionChar(){
        return this.actionChar;
    }
}
