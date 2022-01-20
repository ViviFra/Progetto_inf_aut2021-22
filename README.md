README.md
https://github.com/ViviFra/Progetto_inf_aut2021-22

![TagAnalyzer](https://github.com/ViviFra/Progetto_inf_aut2021-22/blob/main/supporti%20multimediali/TagAnalyzer%20Logo%20Medium.jpeg)

**Introduzione**
L’applicazione TagAnalyzer ha come principale obiettivo quello di restituire un numero nell’intervallo da cinque a cento tra gli ultimi tweet nella timeline di un determinato utente passato come parametro, tramite l’id utente univoco.

Questi tweet verranno poi processati dal programma per elaborare statistiche relative agli hashtag:

  

**Statistiche**


-Numero di hashtag totali presenti nei tweet

-Numero medio di hashtag per tweet

-Hashtag più frequente



Sarà anche possibile filtrare i risultati della ricerca. Immettendo uno specifico hashtag infatti, il programma mostrerà soltanto i tweet dove compare quel tag:

**Filtri**


-Filtri per hashtag dei post

  
**come si usa?**
Una volta lanciata l’applicazione tramite SpringBoot App dal main (nella Class TagAnalyzerApplication.java), possiamo gestire le richieste e visualizzare i risultati tramite un client, come ad esempio Postman. È possibile anche utilizzare uno qualsiasi dei browser web più popolari, rendendo però l’utilizzo sicuramente più scomodo grazie all’interfaccia meno curata, ma non solo, di un client non dedicato.

  

**Le rotte** *(visualizzabili all’interno del programma in Controller.java)*



! ) tutte le rotte iniziano con  [http://localhost:8080](http://localhost:8080) e sono tutti metodi **GET**

> in caso di non funzionamento causato dall’occupazione della porta di default 8080, è possibile cambiare la porta andando, all’interno del programma, nella cartella _src->main->resources->application properties_ e scrivendo in quel file: 
> **_server.port = <numero>_** _(senza le < >)_






  

 - GET ***/tweet/get/timeline*** restituisce il numero specificato di tweet dalla timeline di un utente
 - GET ***/tweet/metadata*** restituisce il tipo di variabili che vengono visualizzate e elaborate
 - GET ***/tweet/data*** restituisce i dati veri e propri (tweet, id, hashtag nel testo)
 - GET ***/tweet/stats***  restituisce le statistiche sopracitate riguardo agli ultimi post restituiti
 - GET ***/tweet/filter*** permette di cercare solo i tweet tra quelli restituiti con un dato hashtag

  

importante: prima di richiedere statistiche sui tweet, filtrare risultati ecc, ricordarsi di effettuare la prima chiamata dell’elenco qui sopra,
infatti senza salvare i dati non sarà possibile effettuarci sopra delle statistiche.


Un tutorial sicuramente più esaustivo è disponibile in questo [video](https://github.com/ViviFra/Progetto_inf_aut2021-22/blob/main/supporti%20multimediali/JUnit%20and%20tutorial.mp4).

> Prima del tutorial vero e proprio ci sono dei test con JUnit, per chi non fosse interessato può saltare direttamente al minuto *00:30*

