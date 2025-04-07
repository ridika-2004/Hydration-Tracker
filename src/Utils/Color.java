package Utils;

public enum Color {
    RESET("\u001B[0m"),
    MAGENTA("\u001B[35m"),
    BOLD("\u001B[1m"),
    DARK_BLUE("\u001B[34m"),
    RED("\u001B[31m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
