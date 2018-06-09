public class PaperFoldSequence {
    public static String FindMiddleOfString(String inputString) {
        int len = inputString.length()/2;
        return inputString.substring(len, len+1);
    }

    public static String GetComplement(String inputString) {
        if (inputString.equals("1")) {
            return "0";
        }
        else if (inputString.equals("0")) {
            return "1";
        }
        return "zzzz";
    }

    public static String MakeComplementString(String inputString) {
        int midStringIndex = inputString.length()/2;
        return (inputString.substring(0,midStringIndex) +
                GetComplement(inputString.substring(midStringIndex, midStringIndex+1)) +
                inputString.substring(midStringIndex+1, inputString.length()));
    }

    public String GetPaperFoldSequence(int numFolds) {
        String paperFoldSequence = "1";
        for (int i=1; i<numFolds; i++){
            paperFoldSequence += "1" + MakeComplementString(paperFoldSequence);
        }
       return paperFoldSequence;
    }
}
