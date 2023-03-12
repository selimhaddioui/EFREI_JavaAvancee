public class Main {

    public static void main(String[] args) {
        // Loading Driver - Connecting Database - Creating Tables and tuples
        try {
            DatabaseManager.loadDriver();
            DatabaseManager.loadConnection();
            DatabaseManager.runScript();
        } catch (Exception e) {
            System.err.println("Cannot setup driver, connection\n" + e);
            DatabaseManager.unloadConnection();
            System.exit(EXIT_CODE.SETUP_DB_ERROR);
        }

        // Running queries
        String suppliers = "";
        String orderedProduct = "", availableProduct = "";
        String newProduct = "", newOrder = "";
        int idNewProduct = 0, idNewOrder = 0;
        boolean isPriceUpdated = false, isWeightUpdated = false, isDeleted = false;

        try {
            // Create
            idNewProduct = DatabaseManager.addProduct("chaise", 100, 4, "noir");
            idNewOrder = DatabaseManager.addOrder(10, idNewProduct, 10);

            // Read
            suppliers = DatabaseManager.getSuppliers();
            availableProduct = DatabaseManager.getProducts(true);
            orderedProduct = DatabaseManager.getProducts(false);
            newProduct = DatabaseManager.getProduct(idNewProduct);
            newOrder = DatabaseManager.getOrder(idNewOrder);

            // Update
            isPriceUpdated = DatabaseManager.updateProductPrice(101, 1111);
            isWeightUpdated = DatabaseManager.updateProductWeight(102, 11);

            // Delete
            isDeleted = DatabaseManager.deleteOrder(1029);

        } catch (Exception e) {
            System.err.println("A query did not pass\n" + e);
            DatabaseManager.unloadConnection();
            System.exit(EXIT_CODE.QUERY_ERROR);
        }

        // Closing database connection
        DatabaseManager.unloadConnection();

        // Printing results
        System.out.println("1.\n" + suppliers);
        System.out.println("2.1.\n" + availableProduct);
        System.out.println("2.2.\n" + orderedProduct);
        System.out.println("3.\nLe produit n°" + idNewProduct + " a ete ajoute\n"
                + "Nouveau produit :\n" + newProduct);
        System.out.println("4.\nLa commande n°" + idNewOrder + " a ete ajoute\n"
                + "Nouvelle commande :\n" + newOrder);
        System.out.println("5.1.\n isPriceUpdated -> " + isPriceUpdated);
        System.out.println("5.2.\n isWeightUpdated -> " + isWeightUpdated);
        System.out.println("6.\n isDeleted -> " + isDeleted);

        System.exit(EXIT_CODE.SUCCESS);
    }
}