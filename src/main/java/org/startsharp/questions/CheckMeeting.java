package org.startsharp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.startsharp.userinterface.pageMeeting;

public class CheckMeeting implements Question <Boolean>{

    public static CheckMeeting result() {
        return new CheckMeeting();
    }

    public Boolean answeredBy(Actor actor) {
        System.out.println(Text.of(pageMeeting.TXT_VERIFY).answeredBy(actor));
        System.out.println("Actor recall: " + actor.recall("nombre_reunion"));

        return Text.of(pageMeeting.TXT_VERIFY).answeredBy(actor).equals(actor.recall("nombre_reunion"));
    }

}
