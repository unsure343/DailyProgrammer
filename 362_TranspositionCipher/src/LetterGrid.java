public class LetterGrid {
    protected int columns;
    protected int rows;
    protected RotationDirection direction;
    protected String inputMessage;
    protected char [][] letterGrid;
    

    public LetterGrid(int inCols, int inRows, String inMessage, RotationDirection inDir){
        letterGrid = new char [inCols] [inRows];
        columns = inCols;
        rows = inRows;
        inputMessage = ConvertStingFormat(inMessage);
        direction = inDir;
        BuildLetterGrid();
    }

    public void BuildLetterGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                InsertLetter(j, i);
            }
        }
    }

    private void InsertLetter(int column, int row) {
        char letter = 'X';
        if(column + row*columns < inputMessage.length()) {
            letter = inputMessage.charAt(column + row*columns);
        }
        letterGrid[column][row] = Character.toUpperCase(letter);
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

    public String GetDirectionString() {
        if (direction == RotationDirection.CLOCKWISE) {
            return "clockwise";
        }
        return "counterclockwise";
    }

    private String ConvertStingFormat(String inMessage) {
        String cleanString = inMessage.replaceAll("[^a-zA-Z]", "");
        return cleanString.toUpperCase();
    }


}
