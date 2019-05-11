# jwtdemo

数据库表

```mysql
mysql> use test;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+----------------+
| Tables_in_test |
+----------------+
| user           |
+----------------+
1 row in set (0.00 sec)

mysql> select * from user;
+----+-------------+---------------------+----------+-----------+
| id | email       | last_login_time     | password | user_name |
+----+-------------+---------------------+----------+-----------+
| 1  | tom@163.com | 2019-05-11 12:09:02 | 123456   | tom       |
+----+-------------+---------------------+----------+-----------+
1 row in set (0.00 sec)

```

请求测试:

获取token

http://127.0.0.1:8080/user/login?userName=tom&password=123456

token测试

http://127.0.0.1:8080/hello?token=eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyTmFtZSI6InRvbSIsImdlbmVyYXRlVGltZSI6MTU1NzU0Nzc0MjE2NywiZXhwIjoxNTU3NTQ3ODAyfQ.bIiBbrlzLeI8zmnRvavVtsOO584G9lp9iV7yr3ynADDeR12Yc9hgqIetrWjmYGsxMmhf4oQD-99EjsG3bkT7fA