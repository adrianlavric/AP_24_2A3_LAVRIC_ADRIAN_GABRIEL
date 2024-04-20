Pentru homework am adaugat functia endgame() in clasa game care verifica daca exista vreun player cu o secventa de cel putin lungime n, il afiseaza 
drept castigator, iar daca nu exista niciun jucator nu castiga, de asemenea am creat o clasa timekeeper in care atunci can se ajunge la o anumita 
limita de timp opresc jocul tot fara niciun castigator. Am atasat 2 screenshoturi, unul in care pun limita de 5 secunde si nun se caseste niciun castigator,
iar unulm in care pun limita de 500 secunde si se afiseaza castigatorul. Pentru logica gasire secventelor fac o lista de liste, iar apoi parcurg tokenii
creand o lista care incepe cu acel token pentru fiecare, apoi verific in restul tokenilor daca gasesc vreunul cu primul numar egal cu al doilea numar al tokenului
actual si al adaug si continui asa.(functia findsequences din player).
