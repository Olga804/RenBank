package steps;


import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class Keys1Step {
    MainSteps mainSteps = new MainSteps();
    DepositSteps depositSteps = new DepositSteps();

    @Когда("^Навести курсор на пункт меню \"(.+)\".$")
    public void selectMainMenuItem(String menuItem){
        mainSteps.selectMainMenuItem(menuItem);
    }

    @Когда("^Дождаться появления \"(.+)\" и кликнуть по нему.$")
    public void selectSubMenu(String menuItem){
        mainSteps.selectSubMenu(menuItem);
    }

    @Когда("^Выбрать валюту \"(.+)\".$")
    public void selectMoney(String string){
        depositSteps.selectMoney(string);
    }

    @Когда("^Сумма вклада = \"(.+)\".$")
    public void selectField1(String string, String value){
        depositSteps.selectField1(string, value);
    }

    @Когда("^Срок - \"(.+)\".$")
    public void selectData(String string){
        depositSteps.selectData(string);
    }

    @Когда("^Ежемесячное пополнение = \"(.+)\".$")
    public void selectField2(String string, String value){
        depositSteps.selectField2(string, value);
    }

    @Тогда("^Проверить, что процентная ставка = \"(.+)\".$")
    public void assertDep(String string){
        depositSteps.assertDep(string);
    }

    @Тогда("^Проверить, что к снятию через 6 месяцев - \"(.+)\".$")
    public void assertDepResult(String string){
        depositSteps.assertDepResult(string);
    }

    @Тогда("^Проверить, что начислено  - \"(.+)\".$")
    public void assertResult(String string){
        depositSteps.assertResult(string);
    }

}
