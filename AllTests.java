package One.simple.Learn_Maven;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ day1.class, excel.class, windgets.class, windowsHandle.class })
public class AllTests {

}
