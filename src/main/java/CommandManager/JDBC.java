package CommandManager;


import java.sql.*;

public class JDBC {

    private final static String DBURL = "";
    private final static String USER = "";
    private final static String PASSWORD = "";

    public static String myPlaylist(String userID) {
        try (  Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
               Statement statement =connection.createStatement()) {
            String getIDQuery = "SELECT URL FROM playlist WHERE ID ='" + userID + "'";
            ResultSet rs = statement.executeQuery(getIDQuery);
            while (rs.next()) {
                    return rs.getString("URL");
            }
            rs.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String playEvent(String eventName) {
        try (  Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
               Statement statement =connection.createStatement()) {
            String getIDQuery = "SELECT URL FROM event WHERE EVENTNAME ='" + eventName + "'";
            ResultSet rs = statement.executeQuery(getIDQuery);
            while (rs.next()) {
                return rs.getString("URL");
            }
            rs.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setPlaylist(String userID, String URL) {
        try ( Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
               Statement statement = connection.createStatement()) {
            String insertIdAndUrlQuery = "INSERT INTO playlist (ID,URL) VALUES('" + userID + "', '" + URL + "')";
            statement.executeUpdate(insertIdAndUrlQuery);

    } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePlaylist(String userID, String URL) {
        try ( Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
              Statement statement = connection.createStatement()) {
            String updatePlaylistQuery = "UPDATE playlist SET URL = '" + URL + "' WHERE ID = '" + userID + "'";
            statement.executeUpdate(updatePlaylistQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateEvent(String eventName, String URL) {
        try ( Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
              Statement statement = connection.createStatement()) {
            String updatePlaylistQuery = "UPDATE event SET URL = '" + URL + "' WHERE EVENTNAME = '" + eventName + "'";
            statement.executeUpdate(updatePlaylistQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEvent(String eventName) {
        try ( Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
              Statement statement = connection.createStatement()) {
            String updatePlaylistQuery = "DELETE FROM event WHERE EVENTNAME= '" + eventName + "'";
            statement.executeUpdate(updatePlaylistQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setEvent(String eventName, String url) {
        try ( Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
              Statement statement = connection.createStatement()) {
            String insertEventNameAndUrl = "INSERT INTO event (EVENTNAME,URL) VALUES('" + eventName + "', '" + url + "')";
            statement.executeUpdate(insertEventNameAndUrl);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

