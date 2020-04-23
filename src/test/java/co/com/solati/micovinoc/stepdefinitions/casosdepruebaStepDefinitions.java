package co.com.solati.micovinoc.stepdefinitions;

import co.com.solati.micovinoc.questions.CodigoRespuesta;
import co.com.solati.micovinoc.tasks.consumeAutenticarTask;
import co.com.solati.micovinoc.tasks.consumeVerificarTask;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class casosdepruebaStepDefinitions {
    @Cuando("^Ejecuto servicio con dato1: \"([^\"]*)\" dato2: \"([^\"]*)\" dato3: \"([^\"]*)\"$")
    public void ejecutoServicioConDato1Dato2Dato3( String dato1, String dato2, String dato3) throws InterruptedException {
    }

    @Cuando("^Ejecuto servicio con usuario: \"([^\"]*)\" contrasena: \"([^\"]*)\"$")
    public void ejecutoServicioConUsuarioContrasena(String usuario, String contrasena) {
        theActorCalled("robot").attemptsTo(consumeAutenticarTask.conDatos(usuario,contrasena));
    }
    @Entonces("^Valido respuesta del servicio \"([^\"]*)\"$")
    public void validoRespuestaDelServicio(String resultado) throws InterruptedException {
        theActorCalled("robot").should(seeThat("Codigo de respuesta", CodigoRespuesta.fue(),equalTo(Integer.parseInt(resultado))));
    }
    @Cuando("^Ejecuto servicio verificar con tipo \"([^\"]*)\"$")
    public void ejecutoServicioVerificarConTipo(String tipo) {
        theActorCalled("robot").attemptsTo(consumeAutenticarTask.conDatos(theActorCalled("robot").recall("usuario"),theActorCalled("robot").recall("clave")));
        theActorInTheSpotlight().attemptsTo(consumeVerificarTask.conTipo(tipo));

    }

}