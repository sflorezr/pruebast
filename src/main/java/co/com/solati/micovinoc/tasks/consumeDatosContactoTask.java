package co.com.solati.micovinoc.tasks;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class consumeDatosContactoTask implements Task {
    private String tipo;
    private String tipoiden;
    private String documento;
    private String campo1;
    private String campo2;
    private String token;
    private JsonObject object = new JsonObject();
    public consumeDatosContactoTask(String tipo,String tipoiden,String documento,String campo1, String campo2){
        this.tipo=tipo;
        this.tipoiden=tipoiden;
        this.documento=documento;
        this.campo1=campo1;
        this.campo2=campo2;
    }
    public static consumeDatosContactoTask conDatos(String tipo,String tipoiden,String documento,String campo1, String campo2){
        return instrumented(consumeDatosContactoTask.class,tipo,tipoiden, documento, campo1, campo2);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        if(tipo.equals("exitoso")){
            token="Bearer "+theActorCalled("robot").recall("token");
        }else{
            token="fallido";
        }
        actor.attemptsTo(Get.resource("/datosContacto").with(requestSpecification -> requestSpecification
                .relaxedHTTPSValidation()

                .header("Authorization",token)
                .param("tipoIdentificacion",tipoiden)
                .param("identificacion",documento)
                .param("campos[]",campo1)
                .param("campos[]",campo2)));
    }
}
