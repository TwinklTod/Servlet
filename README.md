Первая часть ДЗ (дополнение к видео):

1. Изменить проект таким образом, чтобы обращение ко всем сервлетам было через json, и отвечали они тем же форматом

2. Реализовать сервлет с методом doDelete(), который будет удалять записи о пользователях по id

3. Реализовать сервлет с методом doPut(), который будет обновлять (изменять) записи о пользователях (необходимо передавать id, имя, фамилию и зарплату пользователей).

4. Страница по добавлению пользователей в браузере http://localhost:8080/*/addUser.html должна работать корректно.



Вторая часть ДЗ:

Написать сервлет-калькулятор, который будет принимать в формате json 3 параметра: число а, b и арифметическое действие, например:

{
"a": 10,
"b": 5,
"math": "*"
}

В качестве ответа сервлет должен возвращать json с выполненным арифметическим действием, т.е. в нашем случае:

{
"result": 50
}