package org.startsharp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.startsharp.userinterface.pageSharp;

public class OpenPage implements Task {

    private pageSharp pageSharp;

    public static OpenPage UrlApp() {
    return Tasks.instrumented(OpenPage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(pageSharp));
    }
}
