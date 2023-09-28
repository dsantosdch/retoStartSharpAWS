package org.startsharp.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class pageMeeting {

    public static final Target DWN_MEETING = Target.the("Meetings Dropdown").located(By.xpath("//span[text()='Meeting']"));
    public static final Target BTN_MEETING = Target.the("Meeting Button").located(By.xpath("//span[contains(text(),'Meetings')]"));
    public static final Target BTN_NEW_MEETING = Target.the("New Meeting").located(By.xpath("//span[@class='button-inner']"));

    public static final Target TXT_NOMBRE = Target.the("Meeting Name").located(By.xpath("/html/body/main/section/div[2]/div[2]/div[1]/div[2]/form/div/div/div/div/div[1]/input"));

    public static final Target BTN_TIPO = Target.the("Meeting Type").located(By.xpath("//*[contains(@id, 's2id_Serenity_Pro_Meeting_MeetingDialog') and contains(@id, '_MeetingTypeId')]/a/span[2]"));

    public static final Target TXT_NUMERO = Target.the("Meeting Number").located(By.xpath("//*[contains(@id, 'Serenity_Pro_Meeting_MeetingDialog') and contains(@id, '_MeetingNumber')]"));

    public static final Target TXT_TIPO_REUNION = Target.the("Meeting Type Name").located(By.xpath("/html/body/div[6]/ul/li[4]"));

    public static final Target DWN_START_DATE_HOUR = Target.the("Start Date Hour Dropdown").located(By.xpath("//*[@id=\"Serenity_Pro_Meeting_MeetingDialog10_PropertyGrid\"]/div/div/div[4]/select"));

    public static final Target START_DATE_HOUR = Target.the("Start Date Hour").located(By.xpath("//*[@id=\"Serenity_Pro_Meeting_MeetingDialog10_PropertyGrid\"]/div/div/div[4]/select/option[109]"));

    public static final Target DWN_END_DATE_HOUR = Target.the("Start Date Hour Dropdown").located(By.xpath("//*[@id=\"Serenity_Pro_Meeting_MeetingDialog33_PropertyGrid\"]/div/div/div[5]/select"));

    public static final Target END_DATE_HOUR = Target.the("End Date Hour").located(By.xpath("//*[@id=\"Serenity_Pro_Meeting_MeetingDialog33_PropertyGrid\"]/div/div/div[5]/select/option[286]"));

    public static final Target DWN_LOCATION = Target.the("Location Dropdown").located(By.xpath("//*[@id=\"s2id_Serenity_Pro_Meeting_MeetingDialog10_LocationId\"]/a"));

    public static final Target LOCATION = Target.the("Location").located(By.xpath("//*[@id=\"select2-result-label-172\"]"));

    public static final Target TXT_VERIFY = Target.the("Verificar Resultado").located(By.xpath("//div[@class='slick-cell l1 r1']/a[@class='s-EditLink s-Pro-Meeting-MeetingLink']"));

    public static final Target BTN_ID_COLUMN = Target.the("Ordenar Columna").located(By.xpath("//*[contains(@id, 'sleekgrid') and contains(@id, 'MeetingId')]"));

    public static final Target BTN_SAVE = Target.the("Save Button").located(By.xpath("/html/body/main/section/div[2]/div[2]/div[1]/div[1]/div/div/div/div[1]"));
}


