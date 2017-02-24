# sshTemplate
一个整合好的SSH模板（struts+spring+hibernate）。
## 运行环境
- JDK版本号 java-SE 1.7
- Tomcat版本号 Apache Tomcat v9.0
- Spring版本号 4.3.4.RELEASE
- Struts版本号 2.5.10
- Hibernate版本号 5.2.7.Final
- Windows版本号 Microsoft Windows10
- MySQL版本号 mysql-5.7.16-winx64
- Eclips版本号 eclipse Java EE IDE Version: Neon.1 Release

## 数据库配置
```
CREATE SCHEMA `test ` ;
CREATE TABLE `enzyme_library`.`user` (
`username` VARCHAR(40) NOT NULL,
`password` VARCHAR(40) NULL,
PRIMARY KEY (`username`));
INSERT INTO `test`.`user` (`username`, `password`) VALUES ('test', 'test');
```