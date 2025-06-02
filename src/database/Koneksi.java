
package database;
    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String server = "LAPTOP-1SHQH616";
                String database = "Loketku";
                String user = "sa";
                String password = "hiinicandy";
                String url = "jdbc:sqlserver://" + server + ":1500;databaseName=" + database + ";encrypt=false";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi berhasil");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver tidak ditemukan: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return koneksi;
    }
}

