package database;

import java.sql.*;
import java.util.Scanner;

public class main {

  public static void main(String[] args){
		Connection con;
		Statement stmt;
		ResultSet rs;

		//connect to db
		String url = "jdbc:mysql://localhost:3306/szhuge1";
		String dUsername = "";
		String dPassword = "";
		boolean checker = false;
		boolean checkLogin =false;
		boolean checkMenu = false;
		int times = 0;

		Scanner scanIn = new Scanner(System.in);

		try{
			con = DriverManager.getConnection(url, dUsername, dPassword);
			//login
			while(!checker){
				checkMenu =false;
				//user login
				while(!checkLogin){
					System.out.print("username: ");
					String username = scanIn.nextLine().trim();
					System.out.print("password: ");
					String password = scanIn.nextLine().trim();

					String sql = ("SELECT user_id FROM test01 WHERE username = '" + username + "' AND password = '" + password +"';");
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					times++;

					if(rs.next()){
						times = 0;
						checkLogin = true;
						System.out.println("Login Successfully!");
					}else {
						System.out.println("invalide username/password!");
						if(times == 3){
							System.out.println("You have provided invalide username/password more than 3 times!");
							return;
						}
					}
				}

				checkLogin =false;
				//menu
				while(!checkMenu){
					System.out.println("==========Menu==========");
					System.out.println("1) Add new user");
					System.out.println("2) Delete user");
					System.out.println("3) Logout");
					System.out.println("4) Exist");
					System.out.print("Please make your selection: ");

					String sel = scanIn.nextLine().trim();
					int selection  = Integer.parseInt(sel);
					switch(selection){
					//insert new record
					case 1:
						System.out.print("user id: ");
						String nUserId = scanIn.nextLine().trim();
						System.out.print("username: ");
						String nUsername = scanIn.nextLine().trim();
						System.out.print("password: ");
						String nPassword = scanIn.nextLine().trim();

						String sql1 = ("INSERT INTO test01 VALUES('" + nUserId + "','" + nUsername + "','" + nPassword + "');");
						stmt = con.createStatement();
						stmt.executeUpdate(sql1);
						break;

						//delete record
					case 2:
						System.out.print("user id: ");
						String dUserId = scanIn.nextLine();
						System.out.print("Do you confirm to delete this user? (YES/NO): ");
						String dConfirm = scanIn.nextLine();
						if(dConfirm.equalsIgnoreCase("yes")){
							String sql2 = ("DELETE FROM test01 WHERE user_id = '" + dUserId + "';");
							stmt = con.createStatement();
							stmt.executeUpdate(sql2);
						}
						break;

						//logout
					case 3:
						checkMenu = true;
						System.out.println("Loggin out!");
						break;
						//exist
					case 4:
						checkMenu = true;
						checker = true;
						System.out.println("Exist the system!");
						break;
					}
				}
			}


		}catch (SQLException err){
			System.out.println(err.getMessage());
		}finally{
			scanIn.close();
		}



	}
}
