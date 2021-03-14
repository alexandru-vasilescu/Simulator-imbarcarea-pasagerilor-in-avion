package Tema1;
/**	@author Vasilescu Alexandru Madalin 321CB
 *	Clasa Grup extinde clasa Reuniuni
 */
public class Grup extends Reuniuni {
// membri-vector de tip Pasager ce contine toti membri unui grup
	private Pasager[] membri;
// variabila pentru a retine numarul curent de membri dintr-un grup
	private int index;
//constructor ce apeleaza constructorul superclasei cu numele si intializeaza vectorul membri cu maxim 100 de entitati 
	public Grup(String nume) {
		super(nume);
		this.membri= new Pasager[100];
	}
/**	implementarea metodei addTo din superclasa;
 * 	se adauga pasagerul p in vectorul membri si se incrementeaza indexul ce retine numarul curent de membri.
 */
	public void addTo(Pasager p) {
		membri[index]=p;
		index++;
	}
/**	implementarea metodei prioritySum din superclasa;
 * 	se calculeaza suma pentru fiecare membru din grup.
 */
	public int prioritySum() {
// suma este initializata cu 5 datorita conditie de 5 puncte pentru grup
		int sum=5;
// for de la 0 la numarul curent de membri care adauga punctele pentru fiecare pasager in functie de atribute(varsta, bilet etc)
		for(int i=0;i<index;i++)
		{
			sum=sum+membri[i].pointsBilet();
			sum=sum+membri[i].pointsDizabilitati();
			sum=sum+membri[i].pointsVarsta();
			sum=sum+membri[i].pointsPriority();
		}
//se returneaza suma finala
		return sum;
	}
}
