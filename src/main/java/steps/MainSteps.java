package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    @Step("Навести на пункт меню {menuItem}")
    public void selectMainMenuItem(String menuItem){
        new MainPage().selectMainMenuItem(menuItem);
    }
    @Step("Дождаться появления {subMenuItem} и кликнуть по нему")
    public void selectSubMenu(String menuItem){
        new MainPage().selectSubMenu(menuItem);
    }

}
