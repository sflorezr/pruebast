package co.com.solati.micovinoc.tasks;

import co.com.solati.micovinoc.models.Token;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class consumeAutenticarTask implements Task {

    JsonObject object = new JsonObject();

    public consumeAutenticarTask(String usuario,String contrasena){
        object.addProperty("usuario",usuario);
        object.addProperty("contrasena",contrasena);

    }
    public static consumeAutenticarTask conDatos(String usuario,String contrasena){
        return instrumented(consumeAutenticarTask.class,usuario,contrasena);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/autenticacion").with(requestSpecification -> requestSpecification
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation().body(object)));
        Token token = new Token();
        token=SerenityRest.lastResponse().jsonPath().getObject("datos", Token.class);
        if(SerenityRest.lastResponse().statusCode()==200){
            //token = SerenityRest.lastResponse().re;
            actor.remember("token",token.getToken());
        }
    }
}
