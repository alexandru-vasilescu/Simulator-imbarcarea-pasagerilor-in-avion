package Tema1;
/**	@author Vasilescu Alexandru Madalin 321CB
 *	Clasa Single extinde clasa Reuniuni.
 */
public class Single extends Reuniuni {
//variabila de tip Pasager.
	private Pasager p;
//constructor ce apeleaza costructorul din superclasa pentru a adauga numele.
	public Single(String nume) {
		super(nume);
	}
//implementarea metodei addTo(...) din superclasa care memoreaza in variabila clasei Pasagerul p.
	public void addTo(Pasager p) {
		this.p=p;
	}
//implementarea metodei prioritySum() din superclasa.
	public int prioritySum() {
//suma initial este egala cu 0 deoarece Pasagerii single au puncte 0.
		int sum=0;
//se verifica fiecare atribut al pasagerului p(varsta, tip bilet,prioritate, nevoi speciale) si se aduna punctele la suma.
			sum=sum+p.pointsBilet();
			sum=sum+p.pointsDizabilitati();
			sum=sum+p.pointsVarsta();
			sum=sum+p.pointsPriority();
//se returneaza suma.
		return sum;
	}
}
