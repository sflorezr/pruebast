package co.com.solati.micovinoc.utils.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class consumeServicioHook {
    @Before
    public void preparaEndPoint(){
        setTheStage(new OnlineCast());
        theActorCalled("robot").whoCan(CallAnApi.at(System.getProperty("endpointAu"))); 
        theActorCalled("robot").remember("usuario", System.getProperty("usuario"));
        theActorCalled("robot").remember("clave", System.getProperty("clave"));
        theActorCalled("robotdatos").whoCan(CallAnApi.at(System.getProperty("endpointServ")));
        //SerenityRest.setDefaultProxy(new ProxySpecification("172.16.254.174",8000,"http"));
    }
    @After
    public void LiberarServicio(){drawTheCurtain();}
}
