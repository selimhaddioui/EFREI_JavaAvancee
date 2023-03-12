import java.io.*;
import java.sql.*;
import java.util.Objects;

/**
 * Here to manage database interaction
 */
public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/BDCOMMANDES";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection con;


    /**
     * Loading singleton for DriverManager;
     *
     * @throws ClassNotFoundException if driver has not been found
     */
    public static void loadDriver() throws ClassNotFoundException {
        Class.forName(DRIVER); // #TODO put the driver in there
    }

    /**
     * Instance database's connection
     *
     * @throws SQLException if database connection failed
     */
    public static void loadConnection() throws SQLException {
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * Close the instance of database's connection
     */
    public static void unloadConnection() {
        if (con == null)
            return;
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Unable to close connection\n" + e);
            System.exit(EXIT_CODE.CLOSING_CONNECTION_ERROR);
        }
    }

    /**
     * Run a script that will initialize database.
     */
    public static void runScript() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (
                InputStream inputStream = classLoader.getResourceAsStream("script.sql");
                BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
                Statement stmt = con.createStatement()
        ) {
            String line, trimLine, query;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                trimLine = line.trim();
                sb.append(trimLine);
                if (trimLine.endsWith(";")) {
                    query = sb.toString();
                    stmt.execute(query);
                    sb.setLength(0);
                }else{
                    sb.append("\n");
                }
            }
        } catch (Exception e) {
            System.err.println("Unable to run the script correctly");
            unloadConnection();
        }
    }

    // Create

    /**
     * "
     * Add a new product to the database.
     *
     * @param design the product design
     * @param price  the product price
     * @param weight the product weight
     * @param color  the product color
     * @return the id of new created product
     */
    public static int addProduct(String design, int price, int weight, String color) throws SQLException {
        String query = QueryProvider.CREATE_PRODUCT;
        PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, design);
        preparedStatement.setInt(2, price);
        preparedStatement.setInt(3, weight);
        preparedStatement.setString(4, color);
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            int key = resultSet.getInt(1);
            resultSet.close();
            preparedStatement.close();
            return key;
        }
        resultSet.close();
        preparedStatement.close();
        throw new SQLException("Cannot retrieve new product's id");
    }

    /**
     * Add a new order to the database.
     *
     * @param supplierId the ID of the supplier who provided the order
     * @param productId  the ID of the product included in the order
     * @param quantity   the quantity of the product ordered
     * @return the id of new created order
     */
    public static int addOrder(int supplierId, int productId, int quantity) throws SQLException {
        String query = QueryProvider.CREATE_ORDER;
        PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, supplierId);
        preparedStatement.setInt(2, productId);
        preparedStatement.setInt(3, quantity);
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            int key = resultSet.getInt(1);
            resultSet.close();
            preparedStatement.close();
            return key;
        }
        resultSet.close();
        preparedStatement.close();
        throw new SQLException("Cannot retrieve new order's id");
    }

    // Read

    /**
     * Run a query that will return all suppliers.
     *
     * @return List of all suppliers
     */
    public static String getSuppliers() throws SQLException {
        String query = QueryProvider.READ_SUPPLIERS;
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if(!resultSet.next()) {
            resultSet.close();
            statement.close();
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fournisseurs :\n");
        do{
            sb.append("fno = '").append(resultSet.getInt(1));
            sb.append("' nom : '").append(resultSet.getString(2));
            sb.append("' adresse : '").append(resultSet.getString(3));
            sb.append("' ville : '").append(resultSet.getString(4));
            sb.append("'\n");
        }while(resultSet.next());
        resultSet.close();
        statement.close();
        return sb.toString();
    }

    /**
     * Retrieve a list of all products from the database based on their availability status.
     *
     * @param ordered false if available products should be returned, true if ordered products should be returned
     * @return a string representation of the list of products that match the specified criteria
     */
    public static String getProducts(boolean ordered) throws SQLException {
        String query = QueryProvider.READ_PRODUCT_FILTERED_ON_AVAILABILITY;
        String filter = ordered ? "commandé" : "disponible";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, ordered ? 1 : 0);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        if(!resultSet.next()){
            resultSet.close();
            preparedStatement.close();
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Produits ").append(filter).append(" :\n");
        do{
            sb.append("pno = '").append(resultSet.getInt(1));
            sb.append("' design : '").append(resultSet.getString(2));
            sb.append("' prix : '").append(resultSet.getInt(3));
            sb.append("' poids : '").append(resultSet.getInt(4));
            sb.append("' couleur : '").append(resultSet.getString(5));
            sb.append("'\n");
        }while(resultSet.next());
        resultSet.close();
        preparedStatement.close();
        return sb.toString();
    }

    /**
     * Retrieve information about a specific product from the database.
     *
     * @param idProduct the ID of the product to retrieve information about
     * @return a string representation of the product information
     */
    public static String getProduct(int idProduct) throws SQLException {
        String query = QueryProvider.READ_PRODUCT;
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, idProduct);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        if(!resultSet.next()) {
            resultSet.close();
            preparedStatement.close();
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Produit : ");
        do{
            sb.append("pno = '").append(resultSet.getInt(1));
            sb.append("' design : '").append(resultSet.getString(2));
            sb.append("' prix : '").append(resultSet.getInt(3));
            sb.append("' poids : '").append(resultSet.getInt(4));
            sb.append("' couleur : '").append(resultSet.getString(5));
            sb.append("'\n");
        }while(resultSet.next());
        resultSet.close();
        preparedStatement.close();
        return sb.toString();
    }

    /**
     * Retrieve information about a specific order from the database.
     *
     * @param idOrder the ID of the order to retrieve information about
     * @return a string representation of the order information
     */
    public static String getOrder(int idOrder) throws SQLException {
        String query = QueryProvider.READ_ORDER;
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, idOrder);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();

        if(!resultSet.next()) {
            resultSet.close();
            preparedStatement.close();
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Commande : ");
        do{
            sb.append("cno = '").append(resultSet.getInt(1));
            sb.append("' fno : '").append(resultSet.getInt(2));
            sb.append("' pno : '").append(resultSet.getInt(3));
            sb.append("' qute : '").append(resultSet.getInt(4));
            sb.append("'\n");
        }while(resultSet.next());
        resultSet.close();
        preparedStatement.close();
        return sb.toString();
    }

    /**
     * Update the price of a specific product in the database.
     *
     * @param productId the ID of the product to update
     * @param price     the new price of the product
     * @return true if the product was updated successfully, false otherwise
     */
    public static boolean updateProductPrice(int productId, int price) throws SQLException {
        String query = QueryProvider.UPDATE_PRODUCT_PRICE;
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, price);
        preparedStatement.setInt(2, productId);
        boolean success = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return success;
    }

    /**
     * Update the weight of a specific product in the database.
     *
     * @param productId the ID of the product to update
     * @param weight    the new weight of the product
     * @return true if the product was updated successfully, false otherwise
     */
    public static boolean updateProductWeight(int productId, int weight) throws SQLException {
        String query = QueryProvider.UPDATE_PRODUCT_WEIGHT;
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, weight);
        preparedStatement.setInt(2, productId);
        boolean success = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return success;
    }

    /**
     * Delete a specific order from the database.
     *
     * @param orderId the ID of the order to delete
     * @return true if the order was deleted successfully, false otherwise
     */
    public static boolean deleteOrder(int orderId) throws SQLException {
        String query = QueryProvider.DELETE_ORDER;
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, orderId);
        boolean success = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return success;
    }
}
