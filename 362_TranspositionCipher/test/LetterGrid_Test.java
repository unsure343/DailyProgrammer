import org.junit.Assert;
import org.junit.Test;

public class LetterGrid_Test {

    public String testString;
    public String lgOutputString;
    public LetterGrid lg;

    public void PrintTestInfo() {
        System.out.println("message: " + testString);
        System.out.println("columns: " + lg.GetColumnString());
        System.out.println("rows: " + lg.GetRowString());
    }

    @Test
    public void LetterGrid_Test_BuildLetterGrid_4_4() throws Exception {
        testString = "hello garbage";
        lg = new LetterGrid(4, 4, testString);
        PrintTestInfo();
        lgOutputString = lg.PrintAndReturnLetterGrid();
        Assert.assertEquals("H E L L\nO G A R\nB A G E\nX X X X\n", lgOutputString);
    }

    @Test
    public void LetterGrid_Test_BuildLetterGrid_9_3() throws Exception {
        testString = "we are discovered. flee at once!";
        lg = new LetterGrid(9, 3, testString);
        PrintTestInfo();
        lgOutputString = lg.PrintAndReturnLetterGrid();
        Assert.assertEquals("W E A R E D I S C\nO V E R E D F L E\nE A T O N C E X X\n", lgOutputString);
    }

}
