# Pasjans
Zadanie z konkursu Politechniki Śląskiej "Algorytmion".

Pasjans jest grą karcianą (najczęściej jednoosobową), której celem jest ułożenie krat wg
pewnego wzorca. W zdecydowanej większości pasjansów powodzenie gracza zależy od jego
umiejętności, istnieje jednak i taki, który zależy tylko od „szczęścia” gracza.
W pasjansie tym, po przetasowaniu talii 24 krat, układamy (koszulkami do góry) cztery
rzędy krat po sześć – z wyjątkiem rzędu czwartego, w którym ostatnią kartę zatrzymujemy w
dłoni. Celem gry jest ułożenie kart we właściwej kolejności: w pierwszym rzędzie kiery (9,
10, walet, dama, król i as), w kolejnych odpowiednie kolory to: karo, trefl i pik (kolejność
figur jak w kierach).

Gra kończy się, gdy w dłoni mieć będziemy asa pik. Jeśli kartą w dłoni nie jest as pik, to
kładziemy ją (obrazkiem do góry) na odpowiadające jej miejsce (np. gdyby była to dama tref,
to odłożylibyśmy ją do rzędu trzeciego do czwartej kolumny), biorąc w dłoń leżącą tam kartę.
Jeśli natrafimy ostatecznie na asa pik, to (o ile będzie taka potrzeba) odsłaniamy, nie
zmieniając ich położeń w układzie, pozostałe nieodsłonięte (leżące koszulkami do góry)
dotychczas karty. Jeżeli wszystkie karty leżeć będą we właściwej kolejności – wygraliśmy,
jeśli nie – przegraliśmy.

Napisz program, który generował będzie losowe rozłożenie kart, a następnie rozgrywał
będzie partie tego pasjansa. Program działał będzie do pierwszego zwycięstwa. Partie
przegrane nie interesują nas, chcemy jedynie wiedzieć, za którym razem wygraliśmy oraz
zobaczyć wizualizację zwycięskiej partii. Przez wizualizację rozumiemy tutaj kolejne ruchy
gracza począwszy od wejściowego układu, a skończywszy na asie pik „w dłoni” (łącznie z
ewentualnym odsłanianiem kart nieodsłoniętych). Sposób tej wizualizacji pozostawiamy w
gestii rozwiązującego.

Link do edycji konkursu zawierającej to zadanie: https://algorytmion.ms.polsl.pl/storage/files/Zadania2016.pdf
