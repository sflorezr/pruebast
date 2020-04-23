package co.com.solati.micovinoc.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoRespuesta implements Question {
        public static Question<String> fue() {return new CodigoRespuesta();}
        @Override
        public Object answeredBy(Actor actor){
            /*System.out.println(SerenityRest.lastResponse().getStatusCode());
            System.out.println(SerenityRest.lastResponse().getStatusLine());*/
            return SerenityRest.lastResponse().statusCode();
        }
    }

