package Tema1;

import java.util.Arrays;
/** @author Vasilescu Alexandru Madalin 321CB
 * 	Clasa Operatii este cea mai importanta din cadrul proiectului.
 * 	Aici sunt implementate majoritatea metodelor.
 *	
 */

public class Operatii {
// membri- vector de tip Pasager unde se retin toti pasagerii cititi de la tastatura
	private Pasager[] membri;
// variabila index pentru a retine numarul curent de pasageri din vectorul membri
	private int index;
/** variabila indexMax pentru a retine numarul maxim de pasageri din vectorul membri, initializat cu 100
 * 	se poate modifica in cazul introduceri a mai mult de 100 de pasageri
 */
	private int indexMax=100;
// tipuri- vector de tip Reuniuni unde se retin toate grupele, familiile si obiectele de tip singur
	private Reuniuni[] tipuri;
// variabila indextip pentru a retine numarul curent de reuniuni din vectorul tipuri
	private int indextip;
/**	variabila indexTipMax pentru a retine numarul maxim de obiecte din vectorul tipuri, initializat cu 100
 * 	se poate modifica in cazul creeri a mai mult de 100 de reuniuni
 */
	private int indexTipMax=100;
// heap- vector de tip Reuniuni unde sunt introduse obiecte in functie de suma de prioritate
	private Reuniuni[] heap;
//variabila indexheap pentru a retine numarul curent de reuniuni din vectorul heap
	private int indexheap;
/**	variabila indexHeapMax pentru a retine numarul maxim de obiecte din vectorul heap, initializat cu 100 
 * 	se poate modifica in cazul creeri a mai mult de 100 de reuniuni
 */
	private int indexHeapMax=100;
/** Contructor pentru obiecte de tip Operatii
 * 	Se initializeaza fiecare vector (membri, tipuri,heap) cu numarul maxim de elemente
 */
	public Operatii() {
		this.membri=new Pasager[indexMax];
// Vectorii tipuri si heap sunt creati ca Reuniune dar vor fi initializati cu o clasa copil cand se vor adauga elemente in vector
		this.tipuri=new Reuniuni[indexTipMax];
		this.heap=new Reuniuni[indexHeapMax];
	}
/**	Metoda setPasager primeste un string. Se verifica daca numarul de persoane adaugate pana acum depaseste numarul maxim.
 * In acest caz se realoca vectorul membri si se dubleaza numarul maxim.Se da split la string.
 * Fiecare substring se seteaza ca atribut a unui pasager p.
 * La final referinta obiectului p se copiaza in elementrul membri[index] si indexul creste cu 1  
 * @param str=string citit de la tastatura cu date despre pasager.
 */
	void setPasager(String str) {
		
		if (index==indexMax) {
			indexMax=indexMax*2;
			membri=Arrays.copyOf(membri, indexMax);
		}
		String[] retval=str.split(" ");
		Pasager p=new Pasager();
		p.setStatus(retval[0]);
		p.setNume(retval[1]);
		p.setVarsta(Integer.parseInt(retval[2]));
		p.setBilet(retval[3]);
		p.setPriority(Boolean.parseBoolean(retval[4]));
		p.setDizabilitati(Boolean.parseBoolean(retval[5]));
		this.membri[index]=p;
		index++;
	}
/**	Metoda sortPasager pune fiecare obiect din vectorul membri intr-un obiect de tip Reuniune(intr-o familie, grup sau singur)
 */
	public void sortPasager() {

		int j=0;
// Se parcurge vectorul membri si adauga fiecare Pasager intr-o familie grup sau singur
		for (int i=0;i<this.index;i++) {
//Se verifica daca vectorul tipuri este plin si in acest caz numarul maxim de Reuniuni se dubleaza si se realoca memorie
			if(indextip==indexTipMax) {
				indexTipMax=indexTipMax*2;
				tipuri=Arrays.copyOf(tipuri, indexTipMax);
				}
//Daca nu exista nici un element in vectorul tipuri se adauga in functie de statusul persoanei g,f sau s
				if (this.indextip==0) {
//Daca se statusul membrului este g*, elementul tipuri se converteste la grup 
					if(membri[i].getStatus().contains("g")) 
						tipuri[indextip]=new Grup(membri[i].getStatus());
//Daca se statusul membrului este f*, elementul tipuri se converteste la familie
					if(membri[i].getStatus().contains("f")) 
						tipuri[indextip]=new Family(membri[i].getStatus());
//Daca se statusul membrului este s*, elementul tipuri se converteste la singur
					if (membri[i].getStatus().contains("s"))
						tipuri[indextip]=new Single(membri[i].getStatus());
					indextip++;
					
				}
				else 
//In caz ca exista elemente in vectorul tipuri se cauta grupul, familia sau singur care corespune statusului Pasagerului
					for (j=0;j<this.indextip;j++) {
						if (tipuri[j].getNume().contentEquals(membri[i].getStatus()))
							 break;
					}
//Daca nu s-a gasit se construieste un nou element in vector ca in cazul in care acesta era gol
						if(j==indextip) {
							if(membri[i].getStatus().contains("g")) 
								tipuri[indextip]=new Grup(membri[i].getStatus());
							if(membri[i].getStatus().contains("f")) 
								tipuri[indextip]=new Family(membri[i].getStatus());
							if (membri[i].getStatus().contains("s"))
								tipuri[indextip]=new Single(membri[i].getStatus());
							indextip++;
						}
//Daca se gaseste familia se aplica metoda clasei Reuniuni(implementata diferite de clasele copil) addTo
				tipuri[j].addTo(membri[i]);
		}
	}
/**	Metoda care cauta in vectorul membri primul Pasager care are statusul str
 * @param str-statusul cautat
 * @return primul Pasager care are statusul str sau null daca nu se gaseste
 */
	public Pasager lookFor(String str) {
		for(int i=0;i<index;i++)
//Se verifica str sa fie identic cu statusul membrului i
			if(str.contentEquals(membri[i].getStatus()))
				return membri[i];
		return null;
	}
/**
 * 	Metoda care cauta in vectorul tipuri reuniunea specifica unui pasager p si intoarce prioritatea
 * @param p-Pasager a carui prioritate se calculeaza in functie de Reuniunea sa
 * @return Prioritatea pasagerului cu metoda prioriySum() sau -1 daca pasagerul nu exista
 */
	public int getPriority(Pasager p) {
		for (int i=0;i<indextip;i++) 
//Se verifica statusul pasagerului p sa fie identic cu numele reuniunii i
			if(p.getStatus().contentEquals(tipuri[i].getNume()))
				return tipuri[i].prioritySum();
		return -1;
	}
/**
 * Metoda care intoarce Reuniunea unui anumit pasager
 * @param p-Pasagerul a carui reuniune se cauta
 * @return Reuniunea(grup,familie sau singur) sau null daca nu se gaseste 
 */
	public Reuniuni getReuniune(Pasager p) {
		for (int i=0;i<indextip;i++) 
//Se verifica statusul pasagerului p sa fie identic cu numele reuniunii i
			if(p.getStatus().contentEquals(tipuri[i].getNume()))
				return tipuri[i];
		return null;
	}
/**
 * Metoda insert care primeste un Pasager si prioritatea aceastuia si il introduce in heap
 * @param p-Pasagerul ce trebuie introdus in heap
 * @param priority-prioritatea de imbarcare a Pasagerului
 */
	public void insert(Pasager p, int priority) {
//Se verifica daca vectorul heap este plin. Se dubleaza indexul maxim si se realoca vectorul
		if(indexheap==indexHeapMax) {
			indexHeapMax=indexHeapMax*2;
			heap=Arrays.copyOf(heap,indexHeapMax);
		}
//In heap se memoreaza reuniunea specifica lui p cu metoda getReuniuni
		heap[indexheap]=getReuniune(p);
//Constanta auxiliara pentru a interschimba 2 elemente
		Reuniuni aux;
		int i=indexheap;
		indexheap++;
/** Se verifica daca elementul a fost adaugat corect, adica daca suma lui este mai mica ca a radacinii
 * 	Parintele oricarui element i dintr-un vector este elementul de (i-1)/2
 * 	In cazul in care prioritatea elementului este mai mare decat prioritatea parintelui, acestia se interschimba in vector
 * 	Se continua cautarea pana cand elementul nu mai are parinte sau suma parintelui este mai mare ca a copilului
 */
		while((i-1)/2>=0 && priority>heap[(i-1)/2].prioritySum()) {
			aux=heap[(i-1)/2];
			heap[(i-1)/2]=heap[i];
			heap[i]=aux;
			i=(i-1)/2;
		}
	}
/**	Metoda embark elimina elementul cu prioritate maxima din vectorul Heap
 */
	public void embark() {
//Se verifica daca exista elemente in heap
		if(indexheap>0) {
//Marimea vectorului este decrementata
		indexheap--;
//Elementul de pe pozitia 0 are cea mai mare prioritate si valoare lui este inlocuita cu elementul de pe ultima pozitie
		heap[0]=heap[indexheap];
		int i=0,iaux;
//Element auxiliar folosit pentru interschimbare
		Reuniuni aux;
/**	Se verifica daca elementul este pozitionat bine in vectorul heap,adica suma lui sa fie mai mare decat a copiilor
 *	Copii oricarui element i au indecsii 2*i+1 si 2*i+2
 *	In cazul in care prioritatea elementului parinte este mai mica decat a oricaruia dintre cei 2 copii, se interschimba
 *	Parintele se interschimba cu copilul cu prioritate maxima.
 *	Se continua procedeul pana cand indicele copiilor depaseste indexheap(numarul curent de elemente de heap) sau
 *	prioritatea parintelui este mai mare decat ambii copii 
 */
		while(2*i+2<=indexheap && (heap[i].prioritySum()<heap[2*i+1].prioritySum() || heap[i].prioritySum()<heap[2*i+2].prioritySum())){
			if(heap[2*i+1].prioritySum()<heap[2*i+2].prioritySum())
				iaux=2*i+2;
			else iaux=2*i+1;
			aux=heap[iaux];
			heap[iaux]=heap[i];
			heap[i]=aux;
			i=iaux;
		}
		}
	}
//Metoda auxiliara de afisare recursiva a unui heap in preordine in functie de indice(Radacina(i)-Stanga(2i+1)-Dreapta(2i+2)
	public void afisareRecursiva(int i) {
		if(i<indexheap) {
		System.out.print(' '+heap[i].getNume());
		afisareRecursiva(2*i+1);
		afisareRecursiva(2*i+2);
		}
	}
//Metoda list care afiseaza tot heapul in preordine
	public void list() {
//se verifica daca exista elemente in vector
		if(indexheap>=0) {
//Se afiseaza Radacina adica primul element
		System.out.print(heap[0].getNume());
//Se apeleaza metoda afisareRecursiva pentru copii primul element, adica 2*0+1 si 2*0+2
		afisareRecursiva(1);
		afisareRecursiva(2);
		}

	}
}
