Pentru compulsory am clasa abstracta Attraction si clasele Church, Statue, Concert care o extind si implementeaza interfetele Payable si Visitable,
iar in Trip am o lista de tipul Attraction si folosesc LocalDate pentru perioada. Pentru Homework la interfata Visitable folosesc un Map<LocalDate, TimeInterval>
, iar clasa TimeInterval extinde o pereche generica implementata de mine. In Trip pentru a afisa locatiile vizitabile gratuit in ordine creez o lista noua,
pe care o sortez folosind sort si un Comparator. In clasa TravelPlan parcurg zilele in ordine si verific apoi care atractii pot fi vizitate in acea zi si 
le adaug intr-un HashMap.
