import io.cucumber.java.it.Data;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


@CucumberOptions(
      features = {"src/test/resources/features/Login.feature"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
    public TestNGCucumberRunner testNGCucumberRunner;
    @BeforeTest(alwaysRun = true)
    public void setUpCucumber(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @DataProvider
    public Object[][] features() {
            return testNGCucumberRunner.provideScenarios();}
@AfterClass
    public void tearDownClass(){
        testNGCucumberRunner.finish();
}

}
