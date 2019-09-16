import org.junit.Test;
import pages.DepositPage;
import pages.MainPage;

public class MyTest {

    @Test
    public void renCredit(){
        MainPage mainPage = new MainPage();
        mainPage.selectMainMenuItem("Вклады");
        mainPage.selectSubMenu("Открыть вклад");
        DepositPage depositPage = new DepositPage();
        depositPage.selectMoney("RUB");
        depositPage.selectField("Сумма вклада", "300000");
        depositPage.selectData("6 месяцев");

        depositPage.selectField("Ежемесячное пополнение", "50000");
        depositPage.assertDep("6.15%");
        depositPage.assertDepResult("562 961,34");
        depositPage.assertResult("12 961,34");


    }
}
