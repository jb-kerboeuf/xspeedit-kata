import org.junit.Assert;
import org.junit.Test;

public class PackerTest {

    @Test
    public void acceptanceSmartPacker() {
        Packer packer = new Packer();
        packer.processArticlesChain("1638416895257736238");
        Assert.assertEquals("91/82/82/81/73/73/64/63/6/55", packer.toString());
        Assert.assertEquals(10, packer.getNumberOfPacks());
    }

    @Test
    public void shouldMakeOnePackage() {
        Packer packer = new Packer();
        packer.processArticlesChain("16");
        Assert.assertEquals("61", packer.toString());
        Assert.assertEquals(1, packer.getNumberOfPacks());
    }

    @Test
    public void shouldMakeTwoPackages() {
        Packer packer = new Packer();
        packer.processArticlesChain("93");
        Assert.assertEquals("9/3", packer.toString());
        Assert.assertEquals(2, packer.getNumberOfPacks());
    }

    @Test
    public void shouldMakeThreePackages() {
        Packer packer = new Packer();
        packer.processArticlesChain("62389");
        Assert.assertEquals("9/82/63", packer.toString());
        Assert.assertEquals(3, packer.getNumberOfPacks());
    }
}
