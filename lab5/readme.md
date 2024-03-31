Pentru homework, am facut o clasa abstracta Command avdn o singura metoda abstracta Execute, si alte 3 clase care o extind pentru cele 3 comenzi, 
in care dau override acelei metode. Cand citesc comanda verific sa nu fie vida si sa aiba numele corect, apoi la executare verific parametrii,
iar folosind try si catch, am o clasa CommandException care extinde clasa Exception si afisez mesajul de eroare corespunzator. 
Pentru comanda view verific existenta fisierului si il deschid folosind Desktop. Pentru report creez o configuratie, aleg un template
din folderul selectat, introduc datele in map si le scriu in report.html pe care il deschid in browser. Penrtru export folosesc ObjectMapper
ca sa scriu datele intr-un fisier json.
