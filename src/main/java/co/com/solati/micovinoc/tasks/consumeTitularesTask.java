package co.com.solati.micovinoc.tasks;

import com.google.gson.JsonObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class consumeTitularesTask implements Task {
    private String tipo;
    private String tipoiden;
    private String documento;
    private String campo1;
    private String campo2;
    private String campo3;
    private String campo4;
    private String campo5;
    private String token;
    public consumeTitularesTask(String tipo, String tipoiden, String documento, String campo1, String campo2,String campo3,String campo4,String campo5){
        this.tipo=tipo;
        this.tipoiden=tipoiden;
        this.documento=documento;
        this.campo1=campo1;
        this.campo2=campo2;
        this.campo3=campo3;
        this.campo4=campo4;
        this.campo5=campo5;
    }
    public static consumeTitularesTask conDatos(String tipo, String tipoiden, String documento, String campo1, String campo2,String campo3,String campo4,String campo5){
        return instrumented(consumeTitularesTask.class,tipo,tipoiden, documento, campo1, campo2, campo3, campo4, campo5);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        if(tipo.equals("exitoso")){
            token="Bearer "+theActorCalled("robot").recall("token");
        }else{
            token="fallido";
        }
        actor.attemptsTo(Get.resource("/titulares").with(requestSpecification -> requestSpecification
                .relaxedHTTPSValidation()

                .header("Authorization",token)
                .param("tipoIdentificacion",tipoiden)
                .param("identificacion",documento)
                .param("campos[]",campo1)
                .param("campos[]",campo2)
                .param("campos[]",campo3)
                .param("campos[]",campo4)
                .param("campos[]",campo5)));
    }
}
