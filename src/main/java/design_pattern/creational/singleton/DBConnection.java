package design_pattern.creational.singleton;

public class DBConnection {
    String url;
    String password;

    private static volatile DBConnection instance = null;

    private DBConnection(String url, String password){
        this.url = url;
        this.password = password;
    }

    public static DBConnection getInstance(String url, String password){
        if(instance == null) {
            synchronized (DBConnection.class) {
                if(instance == null) {
                    instance = new DBConnection(url, password);
                }
            }
        }
        return instance;
    }

}
