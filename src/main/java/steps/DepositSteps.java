package steps;

import io.qameta.allure.Step;
import pages.DepositPage;

public class DepositSteps {

    @Step("Выбрать валюту {string}")
    public void selectMoney(String string){
        new DepositPage().selectMoney(string);
    }

    @Step ("{string} = {value}")
    public void selectField1(String string, String value){
        new DepositPage().selectField(string, value);
    }

    @Step ("Срок - {string}")
    public void selectData(String string){
        new DepositPage().selectData(string);
    }

    @Step ("{string} = {value}")
    public void selectField2(String string, String value){
        new DepositPage().selectField(string, value);
    }

    @Step ("Проверить, что процентная ставка = {string}")
    public void assertDep(String string){
        new DepositPage().assertDep(string);
    }

    @Step("Проверить, что к снятию через 6 месяцев - {string}")
    public void assertDepResult(String string){
        new DepositPage().assertDepResult(string);
    }

    @Step("Проверить, что начислено  - {string}")
    public void assertResult(String string){
        new DepositPage().assertResult(string);
    }

}
