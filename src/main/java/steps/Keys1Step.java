package steps;


import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class Keys1Step {
    MainSteps mainSteps = new MainSteps();
    DepositSteps depositSteps = new DepositSteps();

    @Когда("^Навести курсор на пункт меню \"(.+)\", дождаться появления \"(.+)\" и кликнуть по нему.$")
    public void selectMainMenuItem(String menuItem, String subMenu){
        mainSteps.selectMainMenuItem(menuItem, subMenu);
    }

    /*@Когда("^Дождаться появления \"(.+)\" и кликнуть по нему.$")
    public void selectSubMenu(String menuItem){
        mainSteps.selectSubMenu(menuItem);
    }

     */

    @И("^Выбрать валюту \"(.+)\".$")
    public void selectMoney(String string){
        depositSteps.selectMoney(string);
    }

    @И("^\"(.+)\" = \"(.+)\".$")
    public void selectField(String string, String value){
        depositSteps.selectField(string, value);
    }

    @И("^Срок - \"(.+)\".$")
    public void selectData(String string){
        depositSteps.selectData(string);
    }

    @И("^Нажать \"(.+)\".$")
    public void checkBox(String string){
        depositSteps.checkBox(string);
    }


    @Тогда("^Проверить, что процентная ставка - \"(.+)\".$")
    public void assertDep(String string){
        depositSteps.assertDep(string);
    }

    @И("^Проверить, что к снятию через 6 месяцев - \"(.+)\".$")
    public void assertDepResult(String string){
        depositSteps.assertDepResult(string);
    }

    @И("^Проверить, что начислено  - \"(.+)\".$")
    public void assertResult(String string){
        depositSteps.assertResult(string);
    }

}
