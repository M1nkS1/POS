package repository;

import config.DatabaseConfig;
import exception.DatabaseException;
import model.Category;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    public void createTable()  { // benennung weil wir schon in catrep drinnen sind
        String sql = """
                CREATE TABLE IF NOT EXISTS category ( 
                    id      SERIAL PRIMARY KEY,
                    name    VARCHAR(100) NOT NULL
                    );
                """;

        try (Connection connection = DatabaseConfig.getConnection()){

            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Table 'category' created!");

            statement.close();
        } catch (SQLException e){
           throw new DatabaseException("Table 'category' could not be created", e);
        }


    }

    public Category insert(Category category){
        String sql = "INSERT INTO category(name)\n" +
                "VALUES (?) RETURNING id;"; // Fragezeichen steht für einen Wert

        try (Connection connection = DatabaseConfig.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, category.getName());

            // Resultset is autoclose, muss ich nicht mehr manuell closen
           try(ResultSet resultSet = statement.executeQuery(sql)){ // update immer wenn ich was verändere
            if (resultSet.next()){
                category.setId(resultSet.getLong("id"));
            }

            System.out.println("Category " + category + "inserted!");

            return category;

        } catch (SQLException e){
            throw new DatabaseException("Could not insert data into 'category'!", e);
        }
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Category> getAll() {
        String sql = """
                 SELECT id,category
                 FROM category
                 ORDER BY id;
                """;

        List<Category> categories = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                categories.add(new Category(resultSet.getLong("id"),
                            resultSet.getString(2)));
                }


                return categories;

            } catch(SQLException e){
                throw new DatabaseException("Categories could not be loaded", e);
            }


        }

        public Category getById(long id){
        return null;
        }

        public void update(Category category){
        // Update everything except ID
        }

        public void deleteById(long id){

        }




}
