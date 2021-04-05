# TestCFT
## Новая версия задания - https://github.com/katerinavp/Currency с использованием Room, фрагментов,конвертация валюты.
1. Загрузка данных с сайта - https://www.cbr-xml-daily.ru/daily_json.js с помощью библиотеки Retrofit при нажатии на кнопку "Загрузить"
2. Для отображения списка используется RecyclerView и ListAdapter.   
3. Для сохранения данных при повороте экрана используется ViewModel и LiveData. В активити подписываемся на LiveData для получения данных.
