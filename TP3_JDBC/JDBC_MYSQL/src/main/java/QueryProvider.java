/**
 * Here to manage query
 */
public class QueryProvider {
    // CREATE
    public static final String CREATE_PRODUCT = "INSERT INTO Produits (design, prix, poids, couleur) VALUES (?, ?, ?, ?)";
    public static final String CREATE_ORDER = "INSERT INTO Commandes (fno, pno, qute) VALUES (?, ?, ?)";
    // READ
    public static final String READ_PRODUCT_FILTERED_ON_AVAILABILITY =
            "Select * FROM " +
                    "(SELECT DISTINCT Produits.*," +
                    "EXISTS(SELECT 1 FROM Commandes WHERE Commandes.pno = Produits.pno) AS ordered FROM Produits" +
                    ") As _ " +
                    "WHERE ordered = ?";
    public static final String READ_ORDER = "SELECT * FROM Commandes WHERE cno=?";
    public static final String READ_PRODUCT = "SELECT * FROM Produits WHERE pno=?";
    public static final String READ_SUPPLIERS = "SELECT * FROM Fournisseurs";

    // UPDATE
    public static final String UPDATE_PRODUCT_PRICE = "UPDATE Produits SET prix=? WHERE pno=?";
    public static final String UPDATE_PRODUCT_WEIGHT = "UPDATE Produits SET poids=? WHERE pno=?";

    // DELETE
    public static final String DELETE_ORDER = "DELETE FROM Commandes WHERE cno=?";

}
