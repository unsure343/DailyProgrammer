import org.junit.Test;
import org.junit.Assert;

public class TranspositionCipher_Test {
    public TranspositionCipher cipher;

    public void PrintTestInfo(TranspositionCipher cipher) {
        System.out.println("message: " + cipher.GetMessageString());
        System.out.println("columns: " + cipher.GetColumnString());
        System.out.println("rows: " + cipher.GetRowString());
        System.out.println("direction: " + cipher.GetDirectionString());
    }

    @Test
    public void TranspositionCipher_Test_1_0() throws Exception {
        cipher = new TranspositionCipher("a",1,0, RotationDirection.CLOCKWISE);
        PrintTestInfo(cipher);
        Assert.assertEquals("A", cipher.Encrypt());
    }

    @Test
    public void TranspositionCipher_Test_BuildLetterGrid_4_4() throws Exception {
        String testString = "hello garbage";
        LetterGrid lg = new LetterGrid(4, 4, testString);
        lg.PrintLetterGrid();
    }

    // tests:
    // extra columns
    // extra rows
}
