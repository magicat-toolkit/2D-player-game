package enums;

public enum actions {

    UP('W'), DOWN('S'), LEFT('A'), RIGHT('D'), INVENTORY('I');

    private final char actionChar;

    actions(char actionChar) {
        this.actionChar = actionChar;
    }

    public char getActionChar(){
        return this.actionChar;
    }
}
