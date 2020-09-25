#Opis działania programu
Program najpierw losuje listę 10000 liczb, którą zapisuje do pamięciowej bazy danych H2, a następnie jeśli w przeglądarce 
internetowej wybierzemy stronę `<adres serwera>:8080/input_number`, to pojawi się formularz w którym możemy wpisać liczbę, 
która informuje jak dużo liczb ma być pobranych z bazy danych. Następnie do tych liczb dolosowywana jest lista liczb z 
wykorzystaniem generatora liczb pseudolosowych Javy oraz elementy tych dwóch list są sumowane. Ostatecznie po kliknięciu w 
przycisk zatwierdzający tę wprowadzoną w formularzu liczbę pojawią się 3 kolumny liczb: jedna pobrana z bazy danych, druga 
dolosowana przez generator liczb pseudolosowych Javy oraz trzecia będąca ich sumą.  