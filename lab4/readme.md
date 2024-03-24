Pentru homework am facut o clasa CarSharing in care am o lista de soferi si una de pasageri, iar dupa ce primesc numarul acestora in constructor,
folosesc un faker pentru a genera random numele, varsta si adresa persoanelor. Apoi folosind stream-uri returnez o lista de tip string cu destinatiile
distincte ale soferilor folosind .map si .collect, si folosind .groupingBy creez un map de tipul <destinatie, pasager>. La solutia greedy fac un map
in care pastrez perechile sofer-pasager cu aceeasi destinatie, parcurg lista de soferi iar folosind un stream creez o lista cu toti pasagerii care au
aceeasi destinatie cu soferul curent, il iau pe primul, il pun in map alaturi de sofer si il sterg din lista de pasageri. Daca map-ul nu e vid,
afisez perechile obtinute, chiar daca nu am gasit o potrivire astfel incat fiecare pasager sa fie luat de cate un sofer.
