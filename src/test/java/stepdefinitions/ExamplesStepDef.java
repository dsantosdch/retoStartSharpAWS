package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.startsharp.questions.CheckMeeting;
import org.startsharp.tasks.CreateMeeting;
import org.startsharp.tasks.FillFields;
import org.startsharp.tasks.Login;
import org.startsharp.tasks.OpenPage;
import org.startsharp.userinterface.pageMeeting;

public class ExamplesStepDef {

    private String nombre_reunion;

    @Given("login to StartSharp")
    public void loginToStartSharp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Dionisio").wasAbleTo(OpenPage.UrlApp());
        OnStage.theActorInTheSpotlight().attemptsTo(Login.credentials());
    }
    @When("entry the {string} and {string} of the meeting")
    public void entryTheAndOfTheMeeting(String nombre_reunion, String numero_reunion) {

        this.nombre_reunion = nombre_reunion;

        OnStage.theActorInTheSpotlight().attemptsTo(CreateMeeting.Fields(),
                Enter.theValue(nombre_reunion).into(pageMeeting.TXT_NOMBRE),
                Enter.theValue(numero_reunion).into(pageMeeting.TXT_NUMERO));

        OnStage.theActorInTheSpotlight().attemptsTo(FillFields.FillFields());

    }
    @Then("i should see the meeting created")
    public void iShouldSeeTheMeetingCreated() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CheckMeeting.result(), Matchers.equalTo(this.nombre_reunion)));
    }

}
