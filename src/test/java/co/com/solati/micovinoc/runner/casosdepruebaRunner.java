package co.com.solati.micovinoc.runner;


import co.com.solati.micovinoc.utils.ST_CambiarLogo;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src//test//resources//features//casodeprueba.feature",
        //tags = {"@Ejecutar"},
        glue = {"co.com.solati.micovinoc.stepdefinitions","co.com.solati.micovinoc.utils.hooks"},
        snippets = SnippetType.CAMELCASE
)
public class casosdepruebaRunner {
    static ST_CambiarLogo cambiarLogo;
    @AfterClass
    public static void finishTestExe(){
        cambiarLogo = new ST_CambiarLogo();
        cambiarLogo.changeLogo();
    }
}
