# Тестирование https://market.yandex.ru 
## Selenium, maven, Junit5, Allure, PageObject
```
Запуск тестов

mvn clean test

После тестирования запустить веб-сервер с результатами

mvn allure:serve

Отчет будет сгенерирован в директорию:target/site/allure-maven/index.html

mvn allure:report
```

## ТЕСТОВОЕ ЗАДАНИЕ

Необходимо:
- Необходимо создать maven проект и написать автотест по сценарию ниже
- Выложить проект на github

Рекомендуется:
- Использование паттерна Page Object
- Использование различных видов селекторов (css, xpath)
- Использование тестовых фреймворков TestNG или JUnit  
- Использование аннотаций из библиотеки Allure

Сценарий автотеста
1.  Перейти на https://market.yandex.ru
2.  Нажать на «Каталог»
3.  Навести курсор на «Зоотовары, в блоке «Для кошек» нажать на «Лакомства»
4.  Установить фильтры:  
    a. по цене: от 50 руб до 150 руб.

    b. способ доставки: «С учетом доставки курьером»  
    c. производитель: «Whiskas»
5.   Перейти в первый товар в списке, нажать на кнопку «Сравнить»
6.   Вернуться на предыдущую страницу

7. В фильтре снять галочку с производителя «Whiskas» и установить производителя «Мнямс»
8.   Перейти во второй товар в списке, нажать на кнопку «Сравнить»

9. Перейти в «Сравнение», проверить, что имена товаров в сравнении соответствуют именам товаров, добавленных на шагах 5 и 8
10.  Проверить, что сумма стоимостей товаров не превышает 300 руб
11. Удалить товар производителя «Whiskas» из сравнения и проверить, что товар производителя «Whiskas» не отображается
12. Нажать на «Удалить список» (значок мусорного бака), проверить, что товары не отображаются

P.S. Если указанные производители отсутствуют, использовать любые два на усмотрение.  



