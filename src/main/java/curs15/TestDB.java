package curs15;
import java.sql.Connection;


public class TestDB {
	
	static String URL = "jdbc:mysql://keytraining-demo.c050jeowbe1q.eu-central-1.rds.amazonaws.com:3306/KeyTraining";
	static String USER = "demouser";
	static String PASS = "demouser";

	public static void main(String[] args) {
		//obiect de tip Db Connection care deschide o conexiune la baza de date bazata pe credetialele de mai sus
		Connection conn = DbConnection.openDbConnection(URL, USER, PASS);
		//query
		String selectQuery = "select * from customers;";
		//metoda care primeste obiectul de tip conexiune si query-ul
		//executa query-ul pe conexiunea primita
		System.out.println(DBQuerys.dbSelectQuery(conn, selectQuery));
		String updateQuery = "update customers set CustomerName = 'TestAndrei12' where CustomerName = 'Test Andrei';";
		DBQuerys.dbUpdateQuery(conn, updateQuery);
		System.out.println(DBQuerys.dbSelectQuery(conn, selectQuery));
		String deleteQuery = "delete from customers where CustomerName = 'TestAndrei12'";
		DBQuerys.dbDeleteQuery(conn, deleteQuery);
		System.out.println(DBQuerys.dbSelectQuery(conn, deleteQuery));
		
		//inchidem obiectul de tip connection
		DbConnection.closeDbConnection(conn);

	}

}
