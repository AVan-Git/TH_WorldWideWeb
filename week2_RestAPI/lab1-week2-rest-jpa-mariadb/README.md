# BT thực hành www - tuần 2-3: Rest API - JPA - Mariadb

## Note
    - Cần rút ngắn repository lại  để tránh trường hợp khởi tạo nhiều entityManager
    - fix bang class ConnectJPA

## tài liệu

[Tài liệu](https://vovanhai.files.wordpress.com/2023/09/lab-week-2.pdf)

### persistence.xml
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">
        <persistence-unit name="default">
            <class>vn.edu.iuh.fit.models.Employee</class>
            <properties>
                <property name="jakarta.persistence.jdbc.driver" value="org.mariadb.jdbc.Driver"/>
                <property name="jakarta.persistence.jdbc.url" value="jdbc:mariadb://localhost:3307/mydb?createDatabaseIfNotExist=true"/>
                <property name="jakarta.persistence.jdbc.user" value="root"/>
                <property name="jakarta.persistence.jdbc.password" value="sapassword"/>
                <property name="jakarta.persistence.schema-generation.database.action" value="drop-and-create"/>
            </properties>
        </persistence-unit>
    </persistence>

### ảnh minh họa
#### Soure Code
![...](./tai_lieu/images/img_code.png)
#### Web
![...](./tai_lieu/images/img_code.png)
#### mariadb
![...](./tai_lieu/images/img_mariadb.png)

### data mariadb
[link](./tai_lieu/mySQL_mariadb/query.sql)

