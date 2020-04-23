package co.com.solati.micovinoc.tasks;

import co.com.solati.micovinoc.models.Token;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class consumeCodigoVerificacionTask implements Task {
    private String tipo;
    private String token;
    JsonObject object = new JsonObject();

    public consumeCodigoVerificacionTask(String tipo,String tipoiden, String documento,String idContacto){
        this.tipo=tipo;
        object.addProperty("tipoIdentificacion",tipoiden);
        object.addProperty("identificacion",documento);
        object.addProperty("idDatoContacto",idContacto);

    }
    public static consumeCodigoVerificacionTask conDatos(String tipo,String tipoiden, String documento,String idContacto){
        return instrumented(consumeCodigoVerificacionTask.class,tipo,tipoiden,documento,idContacto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        if(tipo.equals("exitoso")){
            token="Bearer "+theActorCalled("robot").recall("token");
        }else{
            token="fallido";
        }
        actor.attemptsTo(Post.to("/codigosVerificacion").with(requestSpecification -> requestSpecification
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .header("Authorization",token)
                .body(object)));
    }
}
