import org.junit.Assert;
import org.junit.Test;

public class PackerTest {
    @Test
    public void acceptanceNaivePacker() {
        Packer packer = new Packer();
        Assert.assertEquals("163/8/41/6/8/9/52/5/7/73", packer.pack("163841689525773"));
    }

    @Test
    public void shouldMakeOnePackage() {
        Packer packer = new Packer();
        Assert.assertEquals("16", packer.pack("16"));
    }
}
