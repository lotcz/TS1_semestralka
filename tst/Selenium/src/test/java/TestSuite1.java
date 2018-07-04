import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

/**
 * Test suite for shopping process tests.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestCase1.class, TestCase2.class, TestCase3.class, TestCase4.class, TestCase5.class})
public class TestSuite1 {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
