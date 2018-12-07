springboot-db
=======

This is a toy project using SpringBoot for connecting to a DB and do stuff.

Requirements
-------
- Gradle
- Java
- mariadb

This project requires a database `springbootdb` with user `root` and password `example`.

Use the following sql to create the database:

```sql
CREATE DATABASE IF NOT EXISTS springbootdb;
 
USE springbootdb;

CREATE TABLE `payee` (
  `payee_id` int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 
CREATE TABLE `money_transaction` (
   money_transaction_id int unsigned not null auto_increment primary key,
   value decimal(15,2) not null,
   payee_fk int unsigned not null,
   CONSTRAINT `fk_payee`
   FOREIGN KEY (payee_fk)
   REFERENCES payee(payee_id)
   ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `transaction_category` (
  `transaction_category_id` int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `categorized_transaction` (
   categorized_transaction_id int unsigned not null auto_increment primary key,
   
   money_transaction_fk  int unsigned not null,
   CONSTRAINT `fk_money_transaction`
   FOREIGN KEY (money_transaction_fk)
   REFERENCES `money_transaction`(money_transaction_id)
   ON UPDATE CASCADE ON DELETE RESTRICT,
   
   transaction_category_fk int unsigned not null,
   CONSTRAINT `fk_transaction_category`
   FOREIGN KEY (transaction_category_fk)
   REFERENCES transaction_category(transaction_category_id)
   ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```