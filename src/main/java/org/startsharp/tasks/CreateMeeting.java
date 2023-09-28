package org.startsharp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.startsharp.userinterface.pageMeeting;

public class CreateMeeting implements Task{

    public static CreateMeeting Fields(){
        return Tasks.instrumented(CreateMeeting.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(pageMeeting.DWN_MEETING),
                        Click.on(pageMeeting.BTN_MEETING),
                        Click.on(pageMeeting.BTN_ID_COLUMN),
                        Click.on(pageMeeting.BTN_ID_COLUMN),
                        Click.on(pageMeeting.BTN_NEW_MEETING));
    }
}
