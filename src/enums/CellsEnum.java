package enums;

public enum CellsEnum {

    KEY('K'), LOCKEDDOOR('L'), DOOR('W'), AIR('.'), PORTAL1('O'), PORTAL2('o');

    private final char cellChar;

    CellsEnum(char cellChar) {
        this.cellChar = cellChar;
    }

    public char getCellChar(){
        return this.cellChar;
    }
}
