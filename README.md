# Домашнее задание к занятию 11 «Teamcity»

![answer1]()

## Подготовка к выполнению

1. В Yandex Cloud создайте новый инстанс (4CPU4RAM) на основе образа `jetbrains/teamcity-server`.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/1.png)  
2. Дождитесь запуска teamcity, выполните первоначальную настройку.  
3. Создайте ещё один инстанс (2CPU4RAM) на основе образа `jetbrains/teamcity-agent`. Пропишите к нему переменную окружения `SERVER_URL: "http://<teamcity_url>:8111"`.  
4. Авторизуйте агент.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/2.png)  
5. Сделайте fork [репозитория](https://github.com/aragastmatb/example-teamcity).  
6. Создайте VM (2CPU4RAM) и запустите [playbook](./infrastructure).  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/3.png)  

## Основная часть

1. Создайте новый проект в teamcity на основе fork.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/4.png)  
2. Сделайте autodetect конфигурации.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/5.png)    
3. Сохраните необходимые шаги, запустите первую сборку master.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/6.png)  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/7.png)  
4. Поменяйте условия сборки: если сборка по ветке `master`, то должен происходит `mvn clean deploy`, иначе `mvn clean test`.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/9.png)  
5. Для deploy будет необходимо загрузить [settings.xml](./teamcity/settings.xml) в набор конфигураций maven у teamcity, предварительно записав туда креды для подключения к nexus.  
6. В pom.xml необходимо поменять ссылки на репозиторий и nexus.  
7. Запустите сборку по master, убедитесь, что всё прошло успешно и артефакт появился в nexus.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/10.png)  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/11.png)  
8. Мигрируйте `build configuration` в репозиторий.  
При первоначальной настройке неправильно указал пароль от github, поля в настройках VCS Roots  недоступны. Создал новый проект. Жкспорт успешно завершен.
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/12.png)  
9. Создайте отдельную ветку `feature/add_reply` в репозитории.  
10. Напишите новый метод для класса Welcomer: метод должен возвращать произвольную реплику, содержащую слово `hunter`.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/13.png)   
11. Дополните тест для нового метода на поиск слова `hunter` в новой реплике.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/14.png)  
12. Сделайте push всех изменений в новую ветку репозитория.  
13. Убедитесь, что сборка самостоятельно запустилась, тесты прошли успешно.  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/15.png)  
Сборка запустилась, появились ошибки связанные с регистром слова `hunter`. Внес дополнения
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/16.png)  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/17.png)  
14. Внесите изменения из произвольной ветки `feature/add_reply` в `master` через `Merge`.  
15. Убедитесь, что нет собранного артефакта в сборке по ветке `master`.   
16. Настройте конфигурацию так, чтобы она собирала `.jar` в артефакты сборки.
17. Проведите повторную сборку мастера, убедитесь, что сбора прошла успешно и артефакты собраны.
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/22.png)  
![answer1](https://github.com/Vasiliy-Ser/example_teamcity_18.6/blob/6ee56b96b618a036bdb32fc976ef513bf37e734c/png/23.png)  
18. Проверьте, что конфигурация в репозитории содержит все настройки конфигурации из teamcity.
19. В ответе пришлите ссылку на репозиторий.

---

### Как оформить решение задания

Выполненное домашнее задание пришлите в виде ссылки на .md-файл в вашем репозитории.

---
