package Tema1;

/**	@author Vasilescu Alexandru Madalin 321CB
 * 	Clasa Pasager speciala pentru obiecte de tip persoana.
 * 	Sunt implementate metode pentru obtinerea numerelor de puncte in functie de atribute
 */
public class Pasager {
// Variabila status de tip string care memoreaza numele Reuniuni din care face parte pasagerul
	private String status;
// Variabila varsta de tip int care memoreaza varsta pasagerului
	private int varsta;
// Variabila nume de tip String care memoreaza numele pasagerului
	private String nume;
// Variabila bilet de tip String care memoreaza tipul de bilet(economic=e, bussines=b, premium=p)
	private String bilet;
// Variabila priority de tip boolean care verifica daca pasagerul are imbaracare cu prioritate
	private boolean priority;
// Variabila dizabilitati de tip boolean care verifica daca pasagerul are nevoi speciale
	private boolean dizabilitati;
//Constructor fara parametri.Toti parametri unui obiect de tip Pasager se seteaza cu ajutorul Setterilor
	public Pasager() {
	}
//Getter si Setter pentru Status
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//Getter si Setter pentru Varsta
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
//Getter si Setter pentru Nume
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
//Getter si Setter pentru Tipul de Bilet
	public String getBilet() {
		return bilet;
	}
	public void setBilet(String bilet) {
		this.bilet = bilet;
	}
//Getter si Setter pentru Prioritate
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
//Getter si Setter pentru Nevoi Speciale
	public boolean isDizabilitati() {
		return dizabilitati;
	}
	public void setDizabilitati(boolean dizabilitati) {
		this.dizabilitati = dizabilitati;
	}
//Metoda ce returneaza numarul de puncte pentru fiecare categorie de varsta
	public int pointsVarsta() {
		if (varsta<2) return 20;
		if (varsta<5) return 10;
		if (varsta<10) return 5;
		if(varsta>=60) return 15;
		return 0;
	}
//Metoda ce returneaza numarul de puncte pentru fiecare tip de bilet
	public int pointsBilet() {
		if(bilet.contains("b")) return 35;
		if(bilet.contains("p")) return 20;
		return 0;
	}
//Metoda ce returneaza numarul de puncte in caz de Nevoi Speciale
	public int pointsDizabilitati() {
		if(dizabilitati) return 100;
		return 0;
	}
//Metoda ce returneaza numarul de puncte in caz de Imbarcare cu Prioritate
	public int pointsPriority() {
		if(priority) return 30;
		return 0;
	}
	
}
