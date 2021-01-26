package BDD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;



public class BDD {
	//methode d'insertion
		public void ajout(String classe,String regime,String externe,String age,String Prenom,String Nom, String autre) {
			
				String url="jdbc:mysql://localhost/hopitaljava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String user="root";
				String password ="";
				
				try {
					Connection cnx = DriverManager.getConnection(url,user,password);
					Statement stmt = cnx.createStatement();
			        ResultSet rs;    
			        stmt.executeUpdate("INSERT INTO student(nom,prenom,age,classe,regime,Externe,autre)" + "VALUES ('"+ Nom + "' ,'"+ Prenom + "','"+ age + "','"+ classe + "','"+ regime + "','"+ externe + "','"+ autre + "')");
			        
			            cnx.close();
				}catch (SQLException e) {
					System.out.println("Une erreur est survenue lors de la connexion a la base de données");
					e.printStackTrace();
					
				}
		}
		


			//cette methode sers a compter le nombre de ligne presente dans la table
			  public int defLigne() {
				  

			  try {
		          String url = "jdbc:mysql://localhost/projetcantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		          String user="root";
		  		String password ="";
		  		Connection conn = DriverManager.getConnection(url,user,password);
		          Statement stmt = conn.createStatement();
		          ResultSet rs;

		          rs = stmt.executeQuery("SELECT * FROM student");
		          
		          int a = 0;
		          int i = 0;
		          
		          while (rs.next()){
		          	
		        	  a++;
		          	
		          }
		       
		          return a;
		          
		      } catch (Exception e) {
		          System.err.println("Got an exception! ");
		          System.err.println(e.getMessage());
		      }
			return 0;
			  
		  }
			  
			  //avec cette methode on selectionne pour afficher
			  public Object[][] select(String choixClasse , int check) {
				  
				  
			  try {
				  
				    int i = 0;
		            int a = this.defLigne();
		            
		            Object[][] tab = new Object[a][7];
		            
		            String url = "jdbc:mysql://localhost/projetcantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		            String user="root";
		    		String password ="";
		    		Connection conn = DriverManager.getConnection(url,user,password);
		            Statement stmt = conn.createStatement();
		            ResultSet rs;
		            
		            if(check == 1) {
		            rs = stmt.executeQuery("SELECT * FROM student WHERE classe = ('"+ choixClasse +"') ORDER BY nom ASC");
		            
		            while (rs.next())
		            {
			            	
	            		tab[i][0] = rs.getString("nom");
	            		tab[i][1] = rs.getString("prenom");
	            		tab[i][2] = rs.getString("age");
	            		tab[i][3] = rs.getString("classe");
	            		tab[i][4] = rs.getString("regime");
	            		tab[i][5] = rs.getString("Externe");
	            		tab[i][6] = rs.getString("autre");
	            		
	                   i++;
	                 }
	            
	   
	                return tab;
		            
		            }else if (check == 0) 
		            
		            {
		            
		            rs = stmt.executeQuery("SELECT * FROM student WHERE classe = ('"+ choixClasse +"')");
		            
		            while (rs.next())
		            {
	            		tab[i][0] = rs.getString("nom");
	            		tab[i][1] = rs.getString("prenom");
	            		tab[i][2] = rs.getString("age");
	            		tab[i][3] = rs.getString("classe");
	            		tab[i][4] = rs.getString("regime");
	            		tab[i][5] = rs.getString("Externe");
	            		tab[i][6] = rs.getString("autre");
	            		
	                   i++;
	                 } 
	                 return tab;
		            }
		         
		            
		            
		            
		            //on rentre les informations dans un tableau pour les renvoye
		            
		        } catch (Exception e) {
		            System.err.println("Got an exception! ");
		            System.err.println(e.getMessage());
		        }
			
			return null;
			  
		    }
			  
			  
		public ResultSet connexion(String nom, String mdp) 
		{
			
			
			

			
			String url="jdbc:mysql://localhost/hopitaljava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user="root";
			String password ="";
			
			try {
				Connection cnx = DriverManager.getConnection(url,user,password);
				Statement stmt = cnx.createStatement();
		        ResultSet rs;    
		        
		        
				

		       return  rs = stmt.executeQuery("SELECT nom, mdp,type FROM user WHERE nom = '"+ nom +"' AND mdp = '"+ mdp +"'");
		        
		      
		        	
			}catch (SQLException e) {
				System.out.println("Une erreur est survenue lors de la connexion a la base de données");
				e.printStackTrace();
				
			}
			
			
			return null;
			  		
		}
		
		public ResultSet listUser() 
		{
			
			String url="jdbc:mysql://localhost/projetcantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user="root";
			String password ="";
			
			try {
				Connection cnx = DriverManager.getConnection(url,user,password);
				Statement stmt = cnx.createStatement();
		        ResultSet rs;    
		        
		       return  rs = stmt.executeQuery("Select nom FROM student");
		        
		         	
			}catch (SQLException e) {
				System.out.println("Une erreur est survenue lors de la connexion a la base de données");
				e.printStackTrace();
				
			}
			return null;
		}
		
		public void supprimer(String User) 
		{
		
			String url="jdbc:mysql://localhost/projetcantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user="root";
			String password ="";
			
			try {
				Connection cnx = DriverManager.getConnection(url,user,password);
				Statement stmt = cnx.createStatement();
		        ResultSet rs;    
		        
		        stmt.executeUpdate("Delete FROM student where prenom = '"+ User +"'");
		        
		         	
			}catch (SQLException e) {
				System.out.println("Une erreur est survenue lors de la connexion a la base de données");
				e.printStackTrace();
				
			}
			
			
			  
		}
}
