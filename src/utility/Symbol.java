package utility;

public enum Symbol {
    X('X'),
    O('O'),
    A('A'),
    B('B'),
    C('C'),
    D('D'),
    E('E'),
    EMPTY('_');

    private final char value;

    Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static Symbol fromChar(char symbol) {
        for (Symbol s : Symbol.values()) {
            if (Character.toUpperCase(symbol) == s.value) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid symbol: " + symbol);
    }
}
