Clasa Pasager
Are ca variabile statusul(grup(g*),familie(f*),singur(s*)), varsta(int), numele(String),tipul de bilet(e,b,p), imbarcarea cu prioritate(true,false),nevoi speciale(true,false).
Constructor fara parametri, instantiere facandu-se cu ajutorul Setterilor pentru fiecare variabila a unui obiect de tip Pasager.
Metoda pointsVarsta() care returneaza un int cu numarul de puncte obtinut de fiecare pasager in functie de intervalul de varsta in care se afla.
Metoda pointsBilet() care returneaza un int cu numarul de puncte obtinut de fiecare pasager in functie de tipul de bilet(e=0,b=35,p=20).
Metoda pointsDizabilitati() care returneaza un int cu numarul de puncte obtinut in functie de nevoile speciale ale fiecarui pasager(true=100).
Metoda pointsPriority() care returneaza un int cu numarul de puncte obtinut daca pasagerul are bilet cu imbarcare cu prioritate(true=30).

Clasa Reuniuni(nu am avut inspiratie pentru alt nume) 
Este o clasa abstracta care are ca variabila doar numele Reuniunii(s*,g*,f*).
Constructor care seteaza numele cu un parametru dat.
Metoda abstracta addTo(Pasager) care adauga un pasager la reuniune. Este implementata in clasele care o mostenesc.
Metoda abstracta prioritySum() care intoarce numarul de puncte ale unei reuniuni. Este implementata in clasele care o mostenesc.

Clasa Family extinde clasa Reuniuni
Se foloseste cand numele Reuniunii este de forma f*.
Are ca variabile un vector de Pasageri(membri) si un int(index) ce reprezinta numarul curent de pasageri dintr-o familie.
Constructor care apeleaza constructorul superclasei si initializeaza vectorul cu 100 de elemente.
Metoda addTo(Pasager) care adauga pasagerul p in vectorul membri pe ultima pozitie(index) si incrementeaza indexul.
Metoda prioritySum() care seteaza suma initiala ca fiind 10(datorita conditie de familie) si aduna punctele pentru fiecare membru. Se folosesc metodele din clasa Pasager pentru fiecare membru(pointsVarsta(),pointsBilet(),etc.).

Clasa Grupa extinde clasa Reuniuni
Se foloseste cand numele Reuniunii este de forma g*.
Are ca variabile un vector de Pasageri(membri) si un int(index) ce reprezinta numarul curent de pasageri dintr-un grup.
Constructor care apeleaza constructorul superclasei si initializeaza vectorul cu 100 de elemente.
Metoda addTo(Pasager) care adauga pasagerul p in vectorul membri pe ultima pozitie(index) si incrementeaza indexul.
Metoda prioritySum() care seteaza suma initiala ca fiind 5(datorita conditie de grup) si aduna punctele pentru fiecare membru. Se folosesc metodele din clasa Pasager pentru fiecare membru(pointsVarsta(),pointsBilet(),etc.).

Clasa Single extinde clasa Reuniuni
Se foloseste cand numele Reuninii este de forma s*.
Are ca variabila un Pasager(p).
Constructorul apeleaza constructorul superclasei.
Metoda addTo(Pasager) seteaza Pasagerul clasei sa fie egal cu cel primit ca parametru.
Metoda Metoda prioritySum() care seteaza suma initiala ca fiind 0(datorita conditie de singur) si aduna punctele pentru fiecare membru. Se folosesc metodele din clasa Pasager pentru fiecare membru(pointsVarsta(),pointsBilet(),etc.).

Clasa Main este o clasa care contine doar metoda main. In aceasta clasa am deschis fisierul pentru a citi si cel in care se vor scrie informatiile. Din clasa main se apeleaza principalele metode(insert,embark,list) precum si altele.
Am creat un Scanner care are ca input fisierul queue.in.
Am creat un obiect de tip PrintStream care are ca output fisierul queue.out.
Am setat comanda System.out sa duca la fisierul queue.in
Am creat un element f de tip Operatii(clasa unde se regasesc toate metodele folosite
Se citesc pe rand linii din fisierul queue.in. Prima data se citeste numarul de persoane nrPasageri. Apoi se citesc pe rand toti pasagerii si se apeleaza metoda setPasager din cadrul clasei Operatii(f). Se apeleaza metoda sortPasager() tot din cadrul clasei Operatii(f).
Dupa citirea pasagerilor se citesc instructiunile pe rand pana se termina fisierul(nu mai exista nextLine).
Se verifica ce intstructiune s-a citit(List,Embark,Insert) si se apeleaza metodele din cadrul clasei Operatii(f).
La final se inchide Scannerul si se seteaza outputul sa fie consola.

Clasa Operatii este cea mai importanta din cadrul proiectului, in cadrul acesteia fiind implementate majoritatea metodelor.
Are ca variabile 3 vectori fiecare cu un numar curent de elemente si un numar maxim initializat cu 100.
Vectorul membri(cu index-numarul curent de pasageri si indexMax-numarul maxim de pasageri) este folosit pentru a memora toti Pasagerii cititi de la tastatura.
Vectorul tipuri(cu indexTip-numarul curent de reuniuni si indexMaxTip-numarul maxim de reuniuni) este folosit pentru a tine fiecare Pasager organizat dupa statusul sau(Grup, Familie sau Singur).
Vectorul heap(cu indexheap-numarul curent de elemente din heap si indexMaxheap-numarul maxim de elemente din heap) este folosit pentru a simula Heapul si a organiza Reuniunile.
Constructor fara parametri care intializeaza toti vectorii numarul maxim de elemente.
Metoda setPasager(String) primeste un String ca parametru. Verifica daca s-a depasit numarul maxim de elemente din vector. In acest caz dubleaza numarul maxim de elemente si realoca vectorul. Stringul se separa in substringuri in functie de " "(spatiu). Fiecare substring se pune intr-o variabila a unui Pasager p. La final Pasagerul p se adauga la vectorul membri si indexul se incrementeaza.
Metoda sortPasager() verifica daca numarul maxim de reuniuni a fost atins. in acest caz se dubleaza numarul maxim si se realoca vectorul. Se verifica pentru ficare Pasager din vectorul membri statusul(daca este f,g sau s). Se aloca un element de tip familie,grup sau single in functie de status si se adauga pasagerul in reuniune folosind metoda addTo(). Inainte de a se adauga se cauta grupul,familia sau single unde trebuie adaugat.
Metoda lookFor(String) primeste un String care reprezinta statusul. Cauta in vectorul membri primul pasager care are acel status si il returneaza. Daca nu se gaseste se intoarce null.
Metoda getPriority(Pasager) primeste un pasager. Il cauta in vectorul de reuniuni si intoarce Suma de prioritate a acelei reuniuni folosind metoda prioritySum(). Daca nu se gaseste reuniunea se intoarce -1.
Metoda getReuniune(Pasager) primeste un pasager. Il cauta in vectorul de reuniuni si se intoarce reuniunea unde a fost gasit. Daca nu se gaseste reuniunea se intoarce null.
Metoda insert(Pasager,int). Verifica daca s-a depasit numarul maxim de elemente din heap. In acest caz indexul maxim se dubleaza si se realoca vectorul heap. Se adauga pe ultima pozitie(indexheap) reuniunea din care face parte Pasagerul p folosindu-se de metoda getReuniune. Se verifica daca elementul a fost adaugat corect in heap, adica suma lui de prioritate sa fie mai mica ca suma parintelui((i-1)/2). Se interschimba elementele din heap pana cand conditiile sunt indeplinite.
Metoda embark(). Verifica daca exista elemente in heap. Primul element se pierde si informatia lui este inlocuita cu informatia din ultimul element. Numarul curent de elemente din heap se decrementeaza. Se verifica daca elementul este pozitionat bine(suma lui de prioritate sa fie mai mare decat a ambilor copii).Se inteschimba parintele cu copilul cu suma de prioritate mai mare pana cand sunt indeplinite conditiile.
Metoda afisareRecursiva(int) este o metoda auxiliara de afisare folosita pentru a afisa vectorul heap in preordine(Radacina-i,Stanga-2i+1,Dreapta-2i+2).Se afiseaza radacina si apoi se apeleza din nou metoda pentru copii elementului.
Metoda list(). Verifica daca exista elemente in heap. Se afiseaza primul element si apoi se apleaza metoda afisareRecursiva pentru copii primului element adica, 2*0+1=1 si 2*0+2=2.