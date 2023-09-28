package org.startsharp.tasks.dynamo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import org.startsharp.userinterface.pageMeeting;
import org.startsharp.utils.dynamo.TableContentDynamo;

public class DynamoCreateMeeting implements Task {

    public static DynamoCreateMeeting DynamoFields(){
        return Tasks.instrumented(DynamoCreateMeeting.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String nombre_reunion = TableContentDynamo.tableContent().nombre_reunion;
        String numero_reunion = TableContentDynamo.tableContent().numero_reunion;

        OnStage.theActorInTheSpotlight().attemptsTo(Enter.theValue(nombre_reunion).into(pageMeeting.TXT_NOMBRE),
                                                    Enter.theValue(numero_reunion).into(pageMeeting.TXT_NUMERO));
    }
}
