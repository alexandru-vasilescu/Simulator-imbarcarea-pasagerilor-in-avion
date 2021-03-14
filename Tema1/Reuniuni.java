package Tema1;

/** @author Vasilescu Alexandru Madalin 321CB
 * 	Clasa abstracta Reuniuni este extinsa de 3 clase Grup, Family, Single.
 * 	Aceasta este clasa parinte, folosita pentru a crea doi vectori(tipuri si heap) in cadrul clasei operatii.
 *	(Am folosit numele Reuniuni din lipsa de inspiratie(sorry))
 */
public abstract class Reuniuni {
//un singur parametru de tip String-nume care reprezinta numele obiectului (ex: g1,f2,s3,etc.)
	private String nume;
//constructor cu parametru pentru a seta numele
	public Reuniuni(String nume) {
		this.nume=nume;
	}
//Getter pentru nume
	public String getNume() {
		return nume;
	}
//Setter pentru nume
	public void setNume(String nume) {
		this.nume = nume;
	}
/** Metoda abstracta addTo, implementata in toate clasele mostenite.
 * 	Adauga un pasager la un obiect de tip Grup, Family sau Single
 * @param p-Pasagerul ce trebuie adaugat 
 */
	public abstract void addTo(Pasager p);
/** Metoda abstracta prioritySum, implementata in toate clasele mostenite.
 * 	Calculeaza suma de puncte de prioritate pentru un obiect de tip Grup, Family sau Single. 
 * @return Suma de puncte al unei Reuniuni.
 */
	public abstract int prioritySum();
}
