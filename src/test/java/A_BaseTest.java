import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

class A_BaseTest extends DataGenerator {

    @BeforeClass
    public void setUp() {

    }

    @AfterMethod
    public void clearCookies() {

    }

    @AfterClass
    public void tearDown() {

    }
}
