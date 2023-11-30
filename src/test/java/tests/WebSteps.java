package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps extends BaseTest {
    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("");
    }

    @Step("Ввести в поле поиска {repo}")
    public void searchForRepository(String repo) {
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Кликнуть по ссылке на репозиторий {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Кликнуть на Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить наличие Issues с номером {issueName}")
    public void shouldSeeIssueWithName(String issueName) {
        $(withText(issueName)).should(Condition.exist);
    }
}

