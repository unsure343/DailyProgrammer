public class LetterGrid {
    protected int columns;
    protected int rows;
    protected String inputMessage;
    protected char[][] letterGrid;


    public LetterGrid(int inCols, int inRows, String inMessage) {
        letterGrid = new char[inCols][inRows];
        columns = inCols;
        rows = inRows;
        inputMessage = ConvertStingFormat(inMessage);
        BuildLetterGrid();
    }

    public void BuildLetterGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                InsertLetter(j, i);
            }
        }
    }

    public String Encrypt(RotationDirection direction) {

            String encryptedMessage = "";
            int currCol = columns-1;
            int currRow = 0;
            Side side = (direction == RotationDirection.CLOCKWISE ? Side.RIGHT : Side.TOP);
            while (encryptedMessage.length() < rows*columns) {
                encryptedMessage += encryptSide();
                side = GetNextSide(side, direction);

        }
        return encryptedMessage;
    }

    private String encryptSide() {
        return "";
    }


    public String PrintAndReturnLetterGrid() {
        String outputString = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                outputString += letterGrid[j][i];
                if (j == columns - 1) {
                    outputString += "\n";
                } else {
                    outputString += " ";
                }
            }
        }
        System.out.println(outputString);
        return outputString;
    }

    public String GetColumnString() {
        return String.valueOf(columns);
    }

    public String GetRowString() {
        return String.valueOf(rows);
    }

    private Side GetNextSide(Side currSide, RotationDirection dir) {
            switch (currSide) {
                case RIGHT:
                    return (dir == RotationDirection.CLOCKWISE? Side.BOTTOM : Side.TOP);
                case BOTTOM:
                    return (dir == RotationDirection.CLOCKWISE? Side.LEFT : Side.RIGHT);
                case LEFT:
                    return (dir == RotationDirection.CLOCKWISE? Side.TOP : Side.BOTTOM);
                case TOP:
                    return (dir == RotationDirection.CLOCKWISE? Side.RIGHT : Side.LEFT);
            }
        return Side.INVALID;
    }

    private void InsertLetter(int column, int row) {
        char letter = 'X';
        if(column + row*columns < inputMessage.length()) {
            letter = inputMessage.charAt(column + row*columns);
        }
        letterGrid[column][row] = Character.toUpperCase(letter);
    }

    private String ConvertStingFormat(String inMessage) {
        String cleanString = inMessage.replaceAll("[^a-zA-Z]", "");
        return cleanString.toUpperCase();
    }


}
