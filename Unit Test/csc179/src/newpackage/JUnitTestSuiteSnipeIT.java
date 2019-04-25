package newpackage;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
// Demo of Junit Test Suite
// 
@RunWith(Suite.class)

@Suite.SuiteClasses(
		{
			JAssetTest.class,
			JLocationTest.class,
			JUserTest.class,
		})
public class JUnitTestSuiteSnipeIT {

}
