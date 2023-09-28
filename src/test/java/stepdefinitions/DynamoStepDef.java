package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import org.startsharp.questions.CheckMeeting;
import org.startsharp.tasks.CreateMeeting;
import org.startsharp.tasks.dynamo.DynamoCreateMeeting;
import org.startsharp.tasks.FillFields;
import org.startsharp.utils.dynamo.CheckTableExist;
import org.startsharp.utils.dynamo.GetItem;
import org.startsharp.utils.dynamo.ListTable;

public class DynamoStepDef {

    String key = "nombre_reunion";
    String keyVal = "reunion_dynamodb";
    String tableName = "retorest";

    @Given("a dynamoDB table")
    public void aDynamoDBTable() {
        ListTable.listAllTables();
        CheckTableExist.doesTableExist(tableName);
    }

    @When("i get the data from the table")
    public void iGetTheDataFromTheTable() {
        GetItem.getDynamoDBItem(tableName, key, keyVal);
    }


    @When("fill the meeting fields")
    public void fillTheMeetingFields() {

        OnStage.theActorInTheSpotlight().attemptsTo(CreateMeeting.Fields(),
                                                    DynamoCreateMeeting.DynamoFields(),
                                                    FillFields.FillFields());

    }


    @Then("i should see the meeting")
    public void iShouldSeeTheMeeting () {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CheckMeeting.result(), Matchers.equalTo("reunion_dynamodb")));
    }
}
