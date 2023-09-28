package org.startsharp.tasks.s3;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import org.startsharp.models.Meeting;
import org.startsharp.tasks.CreateMeeting;
import org.startsharp.userinterface.pageMeeting;
import org.startsharp.utils.s3.jsonContent;

public class S3CreateMeeting implements Task {

    public static S3CreateMeeting S3Fields() {
        return Tasks.instrumented(S3CreateMeeting.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Meeting meeting = jsonContent.getJsonContent();

        String nombre_reunion = meeting.getNombre_reunion();
        String numero_reunion = meeting.getNumero_reunion();

        OnStage.theActorInTheSpotlight().attemptsTo(CreateMeeting.Fields(),
                Enter.theValue(nombre_reunion).into(pageMeeting.TXT_NOMBRE),
                Enter.theValue(numero_reunion).into(pageMeeting.TXT_NUMERO));
    }
}
