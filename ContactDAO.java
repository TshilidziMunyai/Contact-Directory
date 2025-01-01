import java.sql.*;

public class ContactDAO {
 
    public void addContact (String name, String phone, String email) throws SQLException {
        String query = "INSERT INTO Contacts (name, phone_number, email)";

        try (Connection connect = DatabaseConnector.getConnection();
            PreparedStatement prepared = connect.prepareStatement(query)){
                prepared.setString(1, name);
                prepared.setString(2, phone);
                prepared.setString(3, email);
                prepared.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void getAllContacts()throws SQLException{
        String query = "SELECT * FROM Contacts";

        try(Connection connect = DatabaseConnector.getConnection();
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(query)){
            while (result.next()) {
                System.out.println("ID" + result.getInt("id"));
                System.out.println("Name" + result.getString("name"));
                System.out.println("Phone" + result.getString("phone"));
                System.out.println("Email" + result.getString("email"));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
    }

    public void UpdateContact(int id, String newPhone) throws SQLException{
        String query = "UPDATE Contact SET phone_number = ? WHERE id = ?";

        try(Connection connect = DatabaseConnector.getConnection();
                PreparedStatement prepared = connect.prepareStatement(query)){
                    prepared.setString(1, newPhone);
                    prepared.setInt(1, id);
                    prepared.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
    }

    public void deleteContact(String id) throws SQLException{
        String query = "DELETE FROM CONTACT WHERE id = ?";
        
        try(Connection connect = DatabaseConnector.getConnection();
        PreparedStatement state = connect.prepareStatement(query)){
            state.setString(1, id);
            state.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }


}
