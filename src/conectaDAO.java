
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
        Properties config = new Properties();

        try (FileInputStream arquivo = new FileInputStream("db.properties")) {
            config.load(arquivo);
            return DriverManager.getConnection(
                    config.getProperty("db.url"),
                    config.getProperty("db.user"),
                    config.getProperty("db.password"));
        } catch (IOException | SQLException erro) {
            throw new IllegalStateException(
                    "Não foi possível conectar ao banco. Configure o arquivo db.properties.", erro);
        }
    }
    
}
