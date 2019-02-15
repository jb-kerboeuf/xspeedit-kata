import org.junit.Assert;
import org.junit.Test;

public class PackerTest {
    @Test
    public void acceptanceNaivePacker() {
        Packer packer = new Packer();
        Assert.assertEquals("163/8/41/6/8/9/52/5/7/73", packer.standardPacking("163841689525773"));
    }

    @Test
    public void shouldMakeOnePackage() {
        Packer packer = new Packer();
        Assert.assertEquals("16", packer.standardPacking("16"));
    }

    @Test
    public void shouldMakeTwoPackages() {
        Packer packer = new Packer();
        Assert.assertEquals("9/6", packer.standardPacking("96"));
    }

    @Test
    public void acceptanceOptimizedPacker() {
        Packer packer = new Packer();
        Assert.assertEquals("19/64/37/82/163/8/55/7", packer.optimizedPacking("163841689525773"));
    }
}
