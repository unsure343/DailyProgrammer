
public class TranspositionCipher {
    private String message;
    private int columns;
    private int rows;
    private RotationDirection direction;


    public TranspositionCipher(String InMessage, int InColumns, int InRows, RotationDirection dir){
        message = InMessage;
        columns = InColumns;
        rows = InRows;
        direction = dir;

    }

    public String Encrypt() {
        // while on the current side
        // concat until hit the boundary

        return message;
    }

    public String GetMessageString() {
        return message;
    }

    public String GetColumnString() {
        return String.valueOf(columns);
    }

    public String GetRowString() {
        return String.valueOf(rows);
    }

    public String GetDirectionString() {
        if (direction == RotationDirection.CLOCKWISE) {
            return "clockwise";
        }
        return "counterclockwise";
    }
}
