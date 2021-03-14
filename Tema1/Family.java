package Tema1;
/**	@author Vasilescu Alexandru Madalin 321CB
 *	Clasa Family extinde clasa Reuniuni
 */
public class Family extends Reuniuni{
// membri-vector de tip Pasager ce contine toti membri unei familii
	private Pasager[] membri;
// variabila pentru a retine numarul curent de membri dintr-o familie
	int index;
//constructor ce apeleaza constructorul superclasei cu numele si intializeaza vectorul membri cu maxim 100 de entitati 
	public Family(String nume) {
		super(nume);
		this.membri=new Pasager[100];
	}
/**	implementarea metodei addTo din superclasa;
 * 	se adauga pasagerul p in vectorul membri si se incrementeaza indexul ce retine numarul curent de membri.
 */
	public void addTo(Pasager p) {
		membri[index]=p;
		index++;
	}
/**	implementarea metodei prioritySum din superclasa;
 * 	se calculeaza suma pentru fiecare membru din familie.
 */
	public int prioritySum() {
// suma este initializata cu 10 datorita conditie de 10 puncte pentru familie
		int sum=10;
// for de la 0 la numarul curent de membri ce adauga punctele pentru fiecare pasager in functie de atribute(varsta,bilet, etc)
		for(int i=0;i<index;i++)
		{
			sum=sum+membri[i].pointsBilet();
			sum=sum+membri[i].pointsDizabilitati();
			sum=sum+membri[i].pointsVarsta();
			sum=sum+membri[i].pointsPriority();
		}
// Se returneaza suma finala
		return sum;
	}
}
