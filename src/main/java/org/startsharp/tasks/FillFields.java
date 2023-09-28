package org.startsharp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.startsharp.userinterface.pageMeeting;

public class FillFields implements Task {

    public FillFields() {
    }

    public static FillFields FillFields() {
        return Tasks.instrumented(FillFields.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(pageMeeting.BTN_TIPO),
                        Click.on(pageMeeting.TXT_TIPO_REUNION),
                        Click.on(pageMeeting.DWN_START_DATE_HOUR),
                        Click.on(pageMeeting.START_DATE_HOUR),
                        Click.on(pageMeeting.BTN_SAVE)
        );
    }
}
