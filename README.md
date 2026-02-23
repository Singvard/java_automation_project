# Проект по автоматизации тестовых сценариев для сайта Automation Exercise
## 📜 Содержание:

* Используемый стек
* Запуск автотестов
* Сборка в Jenkins
* Пример Allure-отчета
* Интеграция с Allure TestOps
* Интеграция с Jira
* Уведомления в Telegram
* Видео примера запуска тестов в Selenoid

## 💻 Используемый стек

<p>
<img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg" alt="IntelliJ IDEA">
<img width="6%" title="Java" src="media/logo/Java.svg" alt="Java">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg" alt="Selenide">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg" alt="Selenoid">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg" alt="Allure Report">
<img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg" alt="Allure TestOps">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg" alt="Gradle">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg" alt="JUnit5">
<img width="6%" title="GitHub" src="media/logo/GitHub.svg" alt="Github">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg" alt="Jenkins">
<img width="6%" title="Telegram" src="media/logo/Telegram.svg" alt="Telegram">
<img width="5%" title="Jira" src="media/logo/Jira.svg" alt="Jira">
</p>

Тесты в данном проекте написаны на языке `Java` с использованием фреймворка для тестирования [Selenide](https://selenide.org/), сборщик - `Gradle`. `JUnit 5` задействован в качестве фреймворка модульного тестирования. При прогоне тестов для запуска браузеров используется [Selenoid](https://aerokube.com/selenoid/). Для удаленного запуска реализована джоба в Jenkins с формированием Allure-отчета и отправкой результатов в `Telegram` при помощи бота. Так же реализована интеграция с `Allure TestOps` и `Jira`.

**Содержание Allure-отчета:**
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## ▶️ Запуск автотестов
Запуск тестов из терминала
```bash
gradle clean test -Dselenoid_url="selenoid.autotests.cloud/wd/hub" -Dbrowser_size="1920х1080" -Dbrowser="CHROME" -Dbrowser_version="128.0"
```
При выполнении данной команды в терминале IDE тесты запустятся удаленно в `Selenoid`.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Сборка в Jenkins

Для запуска сборки необходимо перейти в раздел `Собрать с параметрами` и нажать кнопку `Собрать`.