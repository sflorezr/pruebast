package co.com.solati.micovinoc.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class consumeVerificarTask implements Task {
    private String tipo;
    private String token;
    public consumeVerificarTask(String tipo){
        this.tipo=tipo;
    }
    public static consumeVerificarTask conTipo(String tipo){
        return instrumented(consumeVerificarTask.class,tipo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        if(tipo.equals("exitoso")){
            token="Bearer "+actor.recall("token");
        }else{
            token="fallido";
        }
        actor.attemptsTo(Get.resource("/verificacion").with(requestSpecification -> requestSpecification
                .relaxedHTTPSValidation().header("Authorization",token)));
    }
}
