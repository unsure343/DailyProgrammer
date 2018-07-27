import org.junit.Assert;
import org.junit.Test;
public class Mozart_Test {
    /*
    @Test

    public void Mozart_Test_ReadCompositionFile () throws Exception {
        Mozart comp = new Mozart();
        Assert.assertEquals(Boolean.FALSE, comp.ReadCompositionFile(".\\src\\original_composition.txt", 5));
    }
    */
    @Test
    public void Mozart_Test_CreateComposition () throws Exception {
        Mozart comp = new Mozart();
        Assert.assertEquals(Boolean.FALSE, comp.CreateComposition());
    }
}
