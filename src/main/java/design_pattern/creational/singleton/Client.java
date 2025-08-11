package design_pattern.creational.singleton;

public class Client {
    public static void main(String[] args) {
        DBConnection db1 = DBConnection.getInstance("http://dbconn:8000", "password");
        DBConnection db2 = DBConnection.getInstance("http://dbconn:8000", "password");
        DBConnection db3 = DBConnection.getInstance("http://dbconn:8000", "password");

        // Verify (db1 = db2 = db3) is same with hash codes
        System.out.println("db1 hashCode: " + System.identityHashCode(db1));
        System.out.println("db2 hashCode: " + System.identityHashCode(db2));
        System.out.println("db3 hashCode: " + System.identityHashCode(db3));
    }
}
