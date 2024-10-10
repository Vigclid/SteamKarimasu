package db;

public interface DatabaseInfo {
    String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=SteamKarimasu;encrypt=true;trustServerCertificate=true;";
    String user="sa";
    String password = "1234";

}
