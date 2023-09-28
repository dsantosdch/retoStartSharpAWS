package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import org.startsharp.questions.CheckMeeting;
import org.startsharp.tasks.s3.MultipleS3CreateMeeting;

public class MultipleS3StepDef {

    private String nombre_reunion;

    @When("i try to enter the {string} and {string}")
    public void iTryToEnterTheAnd(String nombre_reunion, String numero_reunion) {

        this.nombre_reunion = nombre_reunion;

        OnStage.theActorInTheSpotlight().attemptsTo(MultipleS3CreateMeeting.S3Fields());

    }


    @Then("the meeting should be created with the data from the json")
    public void theMeetingShouldBeCreatedWithTheDataFromTheJson() {



        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CheckMeeting.result()));

    }

}
