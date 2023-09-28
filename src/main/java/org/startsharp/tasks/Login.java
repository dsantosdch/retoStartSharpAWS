package org.startsharp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.startsharp.userinterface.pageSharp;

public class Login implements Task {

    public static Login credentials() {
        return Tasks.instrumented(Login.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue("admin").into(pageSharp.TXT_USUARIO),
                Enter.theValue("serenity").into(pageSharp.TXT_CONTRASENA),
                Click.on(pageSharp.BTN_SIGN_IN));;
    }
}
