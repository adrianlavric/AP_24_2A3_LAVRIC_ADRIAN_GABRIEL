Pentru homework verific ca parametrii sa fie nr intregi care respecta cerintele, apoi parcurg numerele din interval intr-un for de la a la b in care pentru 
fiecare numar de cel putin 2 cifre fac suma pataratelor cifrelor, iar apoi inlocuiesc numarul cu acea suma pana ajung la un nr de o cifra, iar numerele valide le
adaug intr-un stringbuilder pe care il afisez.
La bonus creez matricea astfel incat nodul 0 este cel din mijloc si se invecineaza cu toti vecinii, apoi creez ciclul care nu il contine pe el legand nodurile
consecutive, dar si nodul 1 cu nodul n-1. Apoi folosesc o functie recursiva in care vizitez nodurile care nu sunt marcate, au visited[i] false, pornind din fiecare
nod pe rand, pana am lungimea ciclului curent cel putin 2, iar daca ultimul nod se invecineaza cu primul afisez. La final ramane ciclul care nu contine nodul din mijloc 
si il afisez si numar si pe acela. Apoi verific daca numarul calculat de mine e egal cu cel din formula.
