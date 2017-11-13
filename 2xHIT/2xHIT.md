## A01 - Baumfabrik
Ein Programm soll Bäume bestimmter Größe als # in der Konsole ausgeben.

Eine Mögliche Ausgabe könnte so aussehen:
```
/* Baum der Größe 5 */
>>
>>      #
>>     ###
>>    #####
>>   #######
>>  #########
>>

/* Baum der Größe 7 */
>>
>>        #
>>       ###
>>      #####
>>     #######
>>    #########
>>   ###########
>>  #############
>>
```

Hinweis: Achte besonders auf die Größe der Ebenen!


## A02 - Entschlüsselung
In einem Verschlüsselungs-Virus findest du folgende Zeile:
```
Stringa(Stringd){Stringc="BCDEFGHIJKLMNOPQRSTUVWXYZA";Stringb="ABCDEFGHIJKLMNOPQRSTUVWXYZ";Stringe="";d=d.toUpperCase();for(inti=0;i<d.length();i++){charf=d.charAt(i);if(b.indexOf(f)>-1){e+=c.charAt(b.indexOf(f));}else{e+=f;}}returne;}"ZPV TPMWFE NZ QVAAMF"
```
Rekonstruiere das Programm und entschlüssle die versteckte Nachricht!


## A03 - Infoseite
Eine erste Klasse hat Websites über das Weihnachtsfest erstellt, nur fehlt noch etwas Inhalt und es wurden keine Stylesheets verwendet. 
Nutze die Vorlagen, erweitere sie gegebenenfalls und gestalte sie mit CSS.

Anforderungen sind:
* Mindestens zwei eigene Schriftarten
* Mindestens eine Animation (auch Hover-Effekte erlaubt)
* Eigene Hintergrundbilder für jede Unterseite

Auch Kreativität wird bewertet ;)


- baum.html baum.html
- index.html index.html
- lieder.html lieder.html 
- rezepte.html rezepte.html


## A04 - Spielzeuglade
Es soll eine Spielzeuglade gebaut werden um Spielzeuge zu verstauen.

Ein Spielzeug hat jeweils Name, Mindestalter, Alterslimit.

Die Spielzeuglade hat eine Liste an Spielzeugen mit einer fixen Größe welche im Konstruktur übergeben wird. Mittels zweier Methoden können Spielzeuge hinzugefügt und der Inhalt der Lade angezeigt werden.

Beachte, dass eine Spielzeuglade schnell voll werden kann!


## A05 - Getter und Setter
Getter und Setter werden benötigt um den Zugriff auf private Variablen zu ermöglichen.
Doch diese werden nicht nur genutzt um return var; aufzurufen, sondern können noch um einiges mehr!


Schreibe eine Klasse User mit den privaten Attributen username, password, firstname und lastname. 
Diese Werte sollen später geändert werden können. Der Benutzername muss dabei mindestens 3 Zeichen lang sein und ist der neue Wert leer oder entspricht dem alten, wird eine Fehlermeldung ausgegeben. 

Das Passwort muss mindestens 8 Zeichen lang sein und muss mindestens ein Hoch- und ein Tiefgestelltes Zeichen enthalten. Zudem wird eine Meldung ausgegeben wenn das Passwort leer ist oder dem alten entspricht. 

Vorname und Nachname dürfen keine Zahlen enthalten und auch nicht null sein.

Zum Schluss teste jeden dieser Fälle in einer weiteren Klasse!


## A06 - CSS Pseudo Klassen
Viele werden bereits ein :hover verwendet haben, vielleicht sogar ein :active oder :visited.
Diese Selektoren nennt man Pseudo Klassen. 

Eine Liste dieser findet ihr zum Beispiel unter:
http://tympanus.net/codrops/css_reference/#section_css-pseudo-class

Bei dieser Aufgabe geht es darum mit dieser Methode der Gestaltung vertraut zu werden und die richtigen Selektoren zum richtigen Zeitpunkt zu wählen.

Die gewünschte Website besteht dabei nur aus:
* 1x Link
* 2x Buttons
* 1x Formular (min. 3 Eingaben)

Der Link soll, wenn von der Maus berührt, seine Farbe ändern und während des Klicks seine Größe ändern. Wurde der Link bereits besucht, soll er ausgeblendet werden.
Bei den Buttons handelt es sich um einen aktiven und einen deaktivierten Button. Der erste soll grün gefärbt sein und wenn er von der Maus berührt wird seine Farbe ändern. Der zweite ist ausgegraut und reagiert nicht auf den Benutzer.
Das Formular zuletzt soll 3 Eingaben haben. Alle leeren Eingaben sollen rot, alle befüllten grün eingerahmt werden. Das jeweils aktive Eingabefeld soll zudem gelb umrahmt werden.

Für die Lösung dieser Aufgabe ist kein JavaScript vorgesehen, zudem müssen keine eigenen CSS Klassen definiert werden!


## A07 - Adventskalender
Diese Aufgabe nutzt die Bibliothek java.util.Calendar, eine ausführliche Dokumentation zu dieser findet sich unter https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html.

Es soll ein Adventskalender entwickelt werden, welcher den aktuellen Adventstag mit Wochentag und dann die verbleibende Zeit bis Weihnachten anzeigt.
Zusätzlich soll ein Kalender in der Konsole ausgegeben werden welche den Dezember mit Wochentagen anzeigt und den heutigen Tag, sowie Weihnachten markiert.

Ein Beispiel für die Ausgabe des Programms:
```
Heute ist der 13. Dezember, nur noch 10 Tage 11 Stunden 12 Minuten und 13 Sekunden bis Weihnachten!

Mo | Di | Mi | Do | Fr | Sa | So
   |    |    | 01 | 02 | 03 | 04
05 | 06 | 07 | 08 | 09 | 10 | 11
12 |-13-| 14 | 15 | 16 | 17 | 18
19 | 20 | 21 | 22 | 23 |*24*| 25
26 | 27 | 28 | 29 | 30 | 31
```

TIPP: Sieh dir die Konstanten der Calendar Klasse in der Java Dokumentation an!


## A08 - Hangman
Beim Hangman Spiel denkt sich jemand ein Wort aus und gibt den Spielern nur die Anzahl der Buchstaben.
Die Spieler versuchen das Wort anhand einzelner Buchstaben zu erraten und ist einer von diesen im Wort enthalten, so sollen alle Vorkommnisse dieses Buchstaben angegeben werden. Ist dem nicht der Fall, so wird ein Teil des Hangmans gezeichnet und ist dieser voll ist das Spiel verloren.

Entwickle ein simples Hangman Spiel in der Konsole, bei welchem der Benutzer erst ein Wort eingibt welches erraten werden muss und dann einzelne Buchstaben raten kann. Anstelle des Hangmans werden jedoch nur die Fehler gezählt und ab 10 Fehlern wird das Wort aufgelöst.

Beispiel: Hangman
```
Welches Wort wird gesucht?
>> Hangman
FORTSCHRITT: _ _ _ _ _ _ _ 0 Fehler
Rate!
>> a
FORTSCHRITT: _ a _ _ _ a _ 0 Fehler
>> b
FORTSCHRITT: _ a _ _ _ a _ 1 Fehler
Bonus (> 18 Punkte):
Zeige zusätzlich welche Buchstaben bereits geraten worden und wiederhole die Eingabe ohne Fehler, falls dieser bereits einmal eingegeben wurde.
```


## A09 - Rennen
Ein Programm soll entwickelt werden, welches dem Benutzer erlaubt ein Rennen zu erstellen.
Dieser bestimmt zu Beginn die Anzahl der Teilnehmer und die maximalen Runden.

Pro Runde wird jedem Teilnehmer eine simple Rechenaufgabe gestellt und die Zeit gemessen.
Diese wird dann dem Punktestand des Teilnehmers hinzugefügt.

Nach jeder Runde wird der Punktestand aller Teilnehmer in dieser angezeigt und nach der letzten Runde sollen alle dieser Punktestände und die Gesamtpunkte aller Runden aufgezeigt werden.

Benutze für den Ablauf des Rennens, sowie für die Teilnehmer jeweils eigene Klassen!


## A10 - Rasterdrehung
Es soll ein Programm entwickelt werden, welches ein Raster mit zufälligen Werten optisch dreht.
So wird etwa ein Raster wie dieses um 90 Grad nach rechts gedreht:
```
---o-
-o---
---o-
-o---
```
Zu diesem:
```
----
o-o-
----
-o-o
----
```
Teste dein Programm indem du ein zufälliges Raster einmal im Kreis drehst und jeden Schritt einzeln in der Konsole ausgibst.
