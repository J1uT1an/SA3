# C/S实现个人通讯录系统

## 简介

大三软件工程——软件体系结构实验3（任务3），采用B/S结构实现个人通讯录系统

## 开发环境

- JDK 1.8
- Maven 3.9.5
- Intellij IDEA 2023.2
- MySql 8.0.35

## 如何运行

1. clone到本地
2. 等待 Maven 下载依赖
3. CS2.view.Main 和 CS3.server.dao.DataBase 修改 jdbc 配置
4. 运行Main.java（2者都可）

## MySql配置

```sql
CREATE TABLE `contacts`
(
    `id`      int          NOT NULL AUTO_INCREMENT,
    `name`    varchar(50)  NOT NULL,
    `phone`   varchar(20)  NOT NULL,
    `address` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
