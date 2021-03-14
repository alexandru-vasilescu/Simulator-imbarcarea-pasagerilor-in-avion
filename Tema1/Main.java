package Tema1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
/**	@author Vasilescu Alexandru Madalin 321CB
 * 	Clasa speciala care contine doar metoda main;
 * 	In clasa Main am deschis Fisierele si am citit datele din fisier;
 *	De aici se apeleaza principalele metode(insert, embark,list) precum si metode auxiliare realizate pentru a usura programul. 
 */
public class Main {

	public static void main(String[] args) {
	//  Se deschide fisierul pentru a citi din el
		try {
			Scanner sc=new Scanner(new File("queue.in"));
	/**	Se creeza un obiect pentru a stabili unde se vor scrie datele de iesire si se memoreaza intr-o variabila console
	 *	outputul original pentru a se putea reveni la el.
	 */
			PrintStream o = new PrintStream(new File("queue.out"));
			PrintStream console=System.out;
			System.setOut(o);
	// Obiectul f se foloseste pentru a se apela metodele auxiliare si metodele principale din cadrul clasei Operatii.
			Operatii f=new Operatii();
	// firstline are rolul de a verifica daca suntem la executie a metodei list(), pentru a sari peste instructiunea de newline.
			boolean firstline=false;
	// nrPasageri folosita pentru a memora numarul de pasageri.	
			int nrPasageri;
	// buffer folosita pentru a citi fiecare linie din fisier pe rand.
			String buffer;
			buffer=sc.nextLine();
			nrPasageri=Integer.parseInt(buffer);
	// for care citeste cate un pasager, pe rand, de nrPasageri ori, si apeleaza metoda setPasager() din cadrul clasei Operatii.
			for (int i=0;i<nrPasageri;i++) {
				buffer=sc.nextLine();
				f.setPasager(buffer);
			}
	// Se apeleaza metoda sortPasager() din clasa Operatii care pune fiecare pasager intr-o Reuniune(Grup, Family, Singur).
			f.sortPasager();
	// Se citeste din fisier in continuare pana cand nu se gaseste un nextline.
			while(sc.hasNextLine()) {
				buffer=sc.nextLine();
	// Se verifica daca s-a citit comanda embark si se apeleaza metoda.
				if(buffer.contains("embark"))
					f.embark();
	/** Se verifica daca s-a citit comanda list si se apeleaza metoda introducandu-se un newline inainte de fiecare apelare
	 *  mai putin prima.
	 */
				if(buffer.contains("list")) {
					if(firstline)
						System.out.println();
					else firstline=true;
					f.list();
				}
	/** Se verifica daca s-a citit comanda insert. Se imparte in 2 parti in functie de spatiul dintre cuvinte.
	 * 	Se foloseste o variabila locala p de tip pasager care este initilizata cu raspunsul metodei lookFor(...)
	 *  din cadrul clasei Operatii.
	 * 	Se foloseste o variabila locala priority de tip int care este initilaizata cu raspunsul metodei getPriority(p);
	 * 	din cadrul clasei Operatii.
	 * 	Se apeleaza metoda insert cu parametri p si priority
	 */
				if(buffer.contains("insert")) {
					String[] parametru=buffer.split(" ");
					Pasager p=f.lookFor(parametru[1]);
					if(p!=null) {
					int priority=f.getPriority(p);
					f.insert(p,priority);
					}
				}
			}
	// se inchide scannerul si se seteaza outputul ca cel initial.
			sc.close();
			System.setOut(console); 
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}


