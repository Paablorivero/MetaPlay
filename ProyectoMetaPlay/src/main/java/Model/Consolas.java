package Model;

public enum Consolas {
    PlayStation_5,
    Xbox_Series_X,
    Nintendo_Switch,
    PC,
    PlayStation_4;


    public static Consolas fromString(String text) {
        for (Consolas value : Consolas.values()) {
            if (value.name().equalsIgnoreCase(text)) {
                return value;
            }
        }
        throw new IllegalArgumentException(text);
    }

}
