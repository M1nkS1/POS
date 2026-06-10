import config.DatabaseConfig;
import model.Category;
import service.CategoryService;

public class Main {

    public static void main(String[] args) {

       try{
           CategoryService categoryService = new CategoryService();
           categoryService.initDatabase();

           Category hardware = categoryService.insertCategory("Hardware");
           Category software = categoryService.insertCategory("Software'); DELETE FROM category; --");
           Category accessories = categoryService.insertCategory("Accessories");

           categoryService.getAllCategories().forEach(System.out::println);

       }finally {
           DatabaseConfig.closePool(); // getrennt von Datenbank - kann nicht passieren#


       }

    }

}
