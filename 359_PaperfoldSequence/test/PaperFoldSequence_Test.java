import org.junit.Assert;
import org.junit.Test;

public class PaperFoldSequence_Test {
    public PaperFoldSequence paper;
    public String testString;

    @Test
    public void PaperFoldSequence_Test_n1() throws Exception{
        paper = new PaperFoldSequence();
        System.out.println("numFolds=1: " + paper.GetPaperFoldSequence(1));
        Assert.assertEquals("1", paper.GetPaperFoldSequence(1));
    }
    @Test
    public void PaperFoldSequence_Test_FindMiddleOfString_1() throws Exception{
        testString = "1";
        Assert.assertEquals("1", PaperFoldSequence.FindMiddleOfString(testString));
    }
    @Test
    public void PaperFoldSequence_Test_FindMiddleOfString_long() throws Exception {
        testString = "abcedfghijk";
        Assert.assertEquals("f", PaperFoldSequence.FindMiddleOfString(testString));
    }

    @Test
    public void PaperFoldSequence_Test_GetComplement_1()  throws Exception {
        testString = "1";
        Assert.assertEquals("0", PaperFoldSequence.GetComplement(testString));
    }

    @Test
    public void PaperFoldSequence_Test_GetComplement_0()  throws Exception {
        testString = "0";
        Assert.assertEquals("1", PaperFoldSequence.GetComplement(testString));
    }

    @Test
    public void PaperFoldSequence_Test_MakeComplementString() throws Exception {
        testString = "0010011";
        Assert.assertEquals("0011011", PaperFoldSequence.MakeComplementString(testString));
    }

    @Test
    public void PaperFoldSequence_Test_n2() throws Exception {
        paper = new PaperFoldSequence();
        System.out.println("numFolds=2: " + paper.GetPaperFoldSequence(2));
        Assert.assertEquals("110", paper.GetPaperFoldSequence(2));
    }
    @Test
    public void PaperFoldSequence_Test_n3() throws Exception {
        paper = new PaperFoldSequence();
        System.out.println("numFolds=3: " + paper.GetPaperFoldSequence(3));
        Assert.assertEquals("1101100", paper.GetPaperFoldSequence(3));
    }
    @Test
    public void PaperFoldSequence_Test_n9() throws Exception {
        paper = new PaperFoldSequence();
        String paperFold_n9 =
                "110110011100100111011000110010011101100111001000110110001100100111011001110010"+
                "011101100011001000110110011100100011011000110010011101100111001001110110001100"+
                "100111011001110010001101100011001000110110011100100111011000110010001101100111"+
                "001000110110001100100111011001110010011101100011001001110110011100100011011000"+
                "110010011101100111001001110110001100100011011001110010001101100011001000110110"+
                "011100100111011000110010011101100111001000110110001100100011011001110010011101"+
                "1000110010001101100111001000110110001100100";
        System.out.println("numFolds=9: " + paper.GetPaperFoldSequence(9));
        Assert.assertEquals(paperFold_n9, paper.GetPaperFoldSequence(9));
    }

}
