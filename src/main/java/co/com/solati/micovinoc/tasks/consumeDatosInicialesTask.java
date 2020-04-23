package co.com.solati.micovinoc.tasks;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class consumeDatosInicialesTask implements Task {
    private String tipo;
    private String token;
    private JsonObject object = new JsonObject();
    public consumeDatosInicialesTask(String tipo){
        this.tipo=tipo;
    }
    public static consumeDatosInicialesTask conTipo(String tipo){
        return instrumented(consumeDatosInicialesTask.class,tipo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        if(tipo.equals("exitoso")){
            token="Bearer "+theActorCalled("robot").recall("token");
        }else{
            token="fallido";
        }
        object.addProperty("label","NI");
        object.addProperty("tipo","N");
        actor.attemptsTo(Get.resource("/datosIniciales").with(requestSpecification -> requestSpecification
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .header("Authorization",token).body(object)));
    }
}
