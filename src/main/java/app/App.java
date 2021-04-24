package app;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

		ResultSet resultSet = null;
		try {
			Connection connection = getConnection();

			Statement statement = connection.createStatement();
			String selectSql = "SELECT * FROM Users";
			resultSet = statement.executeQuery(selectSql);
			System.out.println(resultSet.getRow());

			System.out.println(connection);
			System.out.println(connection.getClientInfo());
		}
		catch(Exception ex) {
			System.out.println("HERE");
			System.out.println(System.getenv("JDBC_DATABASE_URL"));
			System.out.println(ex);
		}
	}

	private static Connection getConnection() throws URISyntaxException, SQLException, SQLDataException {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		return DriverManager.getConnection(dbUrl);
	}
}
