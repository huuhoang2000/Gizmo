package gR;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ManageInventory {
	
	static Scanner reader = new Scanner(System.in);
	
	static ArrayList<Gizmo> gmlist = new ArrayList<>();
	static ArrayList<Retail> rl = new ArrayList<>();

	
	public static void main (String[] args) throws IOException {
		//take in data from text file
		Boolean Rep = true;
		setGizmo();
		setSuppliers();
		
		while (Rep == true) {
		System.out.println("Welcome to Gizmo Retail:");
		System.out.println("1. Search entered data");
		System.out.println("2. Add data");
		System.out.println("3. Update entered data");
		System.out.println("4. Print gizmo list");
		System.out.println("0. exit");
		System.out.print("Please select your command:");
		String in = reader.next();
		
			switch (in) {
			case "1":
				System.out.println("Enter Gizmo name to be searched:");
				String in1 = reader.next();
				searchGizmoName(in1);
			break;
			case "2":
				addNewGizmo();
			break;
			case "3":
				System.out.println("enter Gizmo name for update:");
				String in2 = reader.next();
				updateGizmobyName(in2);
			break;
			case "4":
				printGizmo();
			break;
			case "0":
				System.out.println("Thank you for using the system.");
				Rep = false;
			break;
			default:
				System.out.println("Not a valid command");
		    break;		
			}
		System.out.println("Do you want to stop?");
		String in1 = reader.next();
			if (in1.equals("yes")||in1.equals("Yes")) {
				Rep = false;
			}
			else {
				Rep = true;
				in = null;
			}
		}
	}
	private static void setGizmo() {
		File file1 = new File("gizmos.txt");
		try (FileReader fr1 = new FileReader(file1)){
			BufferedReader br = new BufferedReader(fr1);
		String line = null;		
		while (!((line = br.readLine())== null)) {
			Gizmo g = new Gizmo();
			String tmp[] = line.split(";");
			
			g.setId(tmp[0]);
			g.setNameOfGizmo(tmp[1]);
			g.setStockqtt(Double.parseDouble(tmp[2]));
			g.setPrice(Double.parseDouble(tmp[3]));
			g.setSupplierId(tmp[4]);
			
//			System.out.println(g.toString());
			gmlist.add(g);
		}
//		System.out.println(gmlist.toString());
		br.close();	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	public static void setSuppliers() {
		File file2 = new File("suppliers.txt");
		try (FileReader fr2 = new FileReader(file2)) {
			BufferedReader br = new BufferedReader(fr2);
		String line = null;
		while ((line = br.readLine())!= null) {
			Retail r = new Retail();
			String tmp[] = line.split(";");
			r.setId(tmp[0]);
			r.setCompName(tmp[1]);
			r.setAddress(tmp[2]);
			r.setSalesContact(tmp[3]);
			r.setGizmolistbyID(tmp[4]);
			
			//System.out.println(r.toString());
			rl.add(r);
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static void searchGizmoName(String input) {
		for (Gizmo g : gmlist) {
			if (g.getNameOfGizmo().equals(input)) {
				System.out.println("Gizmo: " + g.getId() + ", " + g.getNameOfGizmo() 
				+ ", " + g.getPrice() + ", " + g.getStockqtt() + ", " + g.getSupplierId());
			}
		}
	}
	public static void addNewGizmo() throws IOException {
		System.out.print("Add new gizmo ID: ");
//		reader.nextLine();
		String NId = reader.next();
		
		System.out.print("Add the description or name of gizmo: ");
		String NDesc = reader.next();
		
		System.out.print("Add quantity in stock: ");
		String Nqut = reader.next();
		Double Nqutt = Double.parseDouble(Nqut);
		
		System.out.print("Add price: ");
		String Npr = reader.next();
		Double Nprice = Double.parseDouble(Npr);
		
		System.out.print("Add add supplier id number: ");
		String NspId = reader.next();

		Gizmo Ng = new Gizmo(NId, NDesc, Nqutt, Nprice, NspId);
		Ng.toString();
		gmlist.add(Ng);		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gizmos.txt",true)));
		//append to the next line in the file.
		pw.println(Ng.getId() + ";" + Ng.getNameOfGizmo() 
		+ ";" + Ng.getPrice() + ";" + Ng.getStockqtt() + ";" + Ng.getSupplierId());
		pw.close();
		
		
	}
	public static void updateGizmobyName(String input) {
		for (Gizmo g : gmlist) {
			if (g.getNameOfGizmo().equals(input)) {
				int inputIndex = gmlist.indexOf(g);
					System.out.println("Position of the gizmo name: " +inputIndex);
					
					System.out.println("Enter to update Gizmo Id:");
					String uId = reader.next();
					
					System.out.println("Enter to update description of Gizmo:");
					String udesc = reader.next();
					
					System.out.println("Enter to update Gizmo stock quantity:");
					String ustqt = reader.next();
					Double ustqtt = Double.parseDouble(ustqt);
					
					System.out.println("Enter to update Gizmo price:");
					String upr = reader.next();
					Double uprice = Double.parseDouble(upr);
					
					System.out.println("Enter to update Gizmo Supplier Id:");
					String usi = reader.next();
					
					Gizmo NewG = new Gizmo();
					NewG.setId(uId);
					NewG.setNameOfGizmo(udesc);
					NewG.setStockqtt(ustqtt);
					NewG.setPrice(uprice);
					NewG.setSupplierId(usi);
					
					gmlist.set(inputIndex, NewG);
					
					PrintWriter pw;
					try {
						pw = new PrintWriter(new BufferedWriter(new FileWriter("gizmos.txt")));
						for (Gizmo g2 : gmlist) {
							
							pw.println(g2.getId() + ";" + g2.getNameOfGizmo() 
							+ ";" + g2.getPrice() + ";" + g2.getStockqtt() + ";" + g2.getSupplierId());
							
						}
					pw.close();	
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			} 
		}
	public static void printGizmo() {
			for (Gizmo g : gmlist) {
				System.out.println("Gizmo: " + g.getId() + ", " + g.getNameOfGizmo() 
				+ ", " + g.getPrice() + ", " + g.getStockqtt() + ", " + g.getSupplierId());
				
			}
	}
}
