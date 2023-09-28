package org.startsharp.tasks.s3;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import org.startsharp.models.Meeting;
import org.startsharp.userinterface.pageMeeting;
import org.startsharp.utils.s3.multipleJson;

public class MultipleS3CreateMeeting implements Task {

    public static MultipleS3CreateMeeting S3Fields() {
        return Tasks.instrumented(MultipleS3CreateMeeting.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        String nombre_reunion;
        String numero_reunion;

        String jsonArrayString = multipleJson.getJsonContent();

        JsonArray jsonArray = JsonParser.parseString(jsonArrayString).getAsJsonArray();

        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(pageMeeting.DWN_MEETING));
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(pageMeeting.BTN_MEETING));


        for (JsonElement jsonElement : jsonArray) {

            OnStage.theActorInTheSpotlight().attemptsTo(Click.on(pageMeeting.BTN_NEW_MEETING));

            Meeting meeting = new Gson().fromJson(jsonElement, Meeting.class);

            nombre_reunion = meeting.getNombre_reunion();
            numero_reunion = meeting.getNumero_reunion();

            System.out.println("Nombre de la reunion: " + nombre_reunion);
            System.out.println("Numero de la reunion: " + numero_reunion);

            OnStage.theActorInTheSpotlight().attemptsTo(
                    Enter.theValue(nombre_reunion).into(pageMeeting.TXT_NOMBRE),
                    Enter.theValue(numero_reunion).into(pageMeeting.TXT_NUMERO)
            );

            OnStage.theActorInTheSpotlight().attemptsTo(Click.on(pageMeeting.BTN_TIPO));
            OnStage.theActorInTheSpotlight().attemptsTo(Click.on(pageMeeting.TXT_TIPO_REUNION));

            OnStage.theActorInTheSpotlight().attemptsTo(Click.on(pageMeeting.BTN_SAVE));

            actor.remember("nombre_reunion", nombre_reunion);

        }
    }
}
