public class LetterGrid {
    protected int columns;
    protected int rows;
    protected String message;
    public char [][] letterGrid;
    public LetterGrid(int inCols, int inRows, String inMessage){
        letterGrid = new char [inCols] [inRows];
        columns = inCols;
        rows = inRows;
        message = ConvertStingFormat(inMessage);
        BuildLetterGrid();
    }

    private String ConvertStingFormat(String inMessage) {
        String cleanString = inMessage.replaceAll("[^a-zA-Z]", "");
        return cleanString.toUpperCase();
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
        if(column + row*columns < message.length()) {
            letter = message.charAt(column + row*columns);
        }
        letterGrid[column][row] = Character.toUpperCase(letter);
    }

    public void PrintLetterGrid() {
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
    }
}
