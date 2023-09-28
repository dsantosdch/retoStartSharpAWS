package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.startsharp.questions.CheckMeeting;
import org.startsharp.tasks.*;
import org.startsharp.tasks.s3.S3CreateMeeting;
import org.startsharp.utils.s3.findObject;
import org.startsharp.utils.s3.jsonContent;
import org.startsharp.utils.s3.listObject;

public class S3StepDef {

    @Given("a bucket S3")
    public void aBucketS3() {
        listObject.listBucketObjects();
    }

    @Given("a json file in the bucket")
    public void aJsonFileInTheBucket() {

        findObject.CheckObject();
        jsonContent.getJsonContent();
    }


    @When("i login")
    public void iLogin() {

        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Dionisio").wasAbleTo(OpenPage.UrlApp());
        OnStage.theActorInTheSpotlight().attemptsTo(Login.credentials());

    }

    @When("try to create a meeting with the json data")
    public void tryToCreateAMeetingWithTheJsonData() {

        OnStage.theActorInTheSpotlight().attemptsTo(S3CreateMeeting.S3Fields(),
                                                    FillFields.FillFields());

    }

    @Then("the meeting should be created")
    public void theMeetingShouldBeCreated() {

        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CheckMeeting.result(), Matchers.equalTo("Una sola reunion de Prueba")));
    }

}
