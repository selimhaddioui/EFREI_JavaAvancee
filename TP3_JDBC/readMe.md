# Discovering JDBC (Java Database Connectivity)   

---

## Pre-requirement  

This repository will not speak about how to start a database instance but you will need to do it so you might want to see [how docker handle it](https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/docker-mysql-getting-started.html#docker-starting-mysql-server).
Docker make it easier so you also might want to [install it](https://www.docker.com/).

## Configuration

In our example we are going to use a MySql database and all configurations can be see [there](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/JDBC/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L9) into static attributs.

### Exercise  

* Create the database *BDCOMMANDES* using [sql script](./JDBC_MYSQL/src/main/resources/script.sql).  

  [DatabaseManager.runScript()](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L48) read from [script.sql](./JDBC_MYSQL/src/main/resources/script.sql) and execute each query one by one.  
  It appends each lines until it found one that end by `;` then it execute the query.  
  This method will only work if a connection with the database has already been set.

* Set up a connection to the database

   To set up a connection we first need to load the driver and [DatabaseManager.loadDriver()](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L16).  
   Then we can set up the connection using [DatabaseManager.loadConnection()](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L25).  
   Connection is loaded based on `jdbc:mysql://localhost:3306/BDCOMMANDES` as url, `root` as username and password.

* List all suppliers

  [DatabaseManager.getSuppliers()](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L138)

* Print products available

  [DatabaseManager.getProducts(boolean ordered)](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L166)

* Add a product

  [DatabaseManager.addProduct(String design, int price, int weight, String color)](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L79)

* Add an order

  [DatabaseManager.addOrder(int supplierId, int productId, int quantity)](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L109)

* Update a product's price

  [DatabaseManager.updateProductPrice(int productId, int price)](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L263)

* Update a product's weight

  [DatabaseManager.updateProductWeight(int productId, int weight)](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L280)

* Delete an order

  [DatabaseManager.deleteOrder(int orderId)](https://github.com/selimhaddioui/EFREI_JavaAvancee/blob/main/TP3_JDBC/JDBC_MYSQL/src/main/java/DatabaseManager.java#L297)

---  

[Preview](../README.md)

[Next](../README.md)
