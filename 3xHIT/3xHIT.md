## A01 - Baumfabrik
Beim MVC Pattern muss nicht immer mit einer GUI verwendet werden. Im beigelegten Programm findet sich ein Controller für welchen das Model und die View geschrieben werden müssen.

Das Programm selbst soll wie folgt Bäume bestimmter Größe in der Konsole ausgeben:
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

Die Controller Klasse darf zu diesem Zwecke NICHT bearbeitet werden!


## A02 - Entschlüsselung
In einem Verschlüsselungs-Virus findest du folgende Zeile:
```
Stringa(Stringd){Stringc="BCDEFGHIJKLMNOPQRSTUVWXYZA";Stringb="ABCDEFGHIJKLMNOPQRSTUVWXYZ";Stringe="";d=d.toUpperCase();for(inti=0;i<d.length();i++){charf=d.charAt(i);if(b.indexOf(f)>-1){e+=c.charAt(b.indexOf(f));}else{e+=f;}}returne;}"ZPV TPMWFE NZ QVAAMF"
```
Rekonstruiere das Programm und entschlüssle die versteckte Nachricht!


## A03 - Namensgebung
Es ist oft schwer sich einen guten Namen einfallen zu lassen, doch ein kleines Programm soll nun Abhilfe schaffen!

Ein Name besteht aus 3 Teilen:
* Adjektiv
* Brücke
* Nomen

Jedem dieser Teile wird pro Buchstabe ein Wort zugewiesen:
```
// Beispiel
adjectives = {
    "a": "Anonymous",
    "b": "Big",
    "c": "Classic,
    ...
}
```
Zu Beginn wird der Benutzer dazu aufgefordert seinen Namen einzugeben. Der erste Buchstabe wird verwendet um das Adjektiv zu besimmten, der letzte für das Nomen. Ist der Name länger als 8 Zeichen, so wird der mittlere Buchstabe verwendet um eine Brücke einzufügen.
```
// Beispiel
>> INPUT: Hannes
>> OUTPUT: Hilarous Snake

>> INPUT: Bartholomeo
>> OUTPUT: Big Octopus Ork
```

Auch Kreativität wird bewertet ;-)


## A04 - Zug um Zug
Es soll ein Programm entwickelt werden um einzelne Wagons eines Zuges zu kontrollieren.

Ein Zug besteht aus mindestens einem Wagon und kann Wagons an- und abhängen, jedoch keinen Wagon aus der Mitte entfernen.

Ein Wagon kann offen oder geschlossen sein und kann eine bestimmte Anzahl an Personen aufnehmen. Weiters kann ein Wagon entweder, Speise- oder Reisewagon sein, wobei der Speisewagon eine bestimmte Menge an Nahrungsmitteln beinhaltet und bei Bedarf Essen ausgeben kann.

Analysiere die Anforderungen aus der Aufgabenstellung und entwickle das Programm!

HILFE:
 - Bestimme eine passende Java Collection
 - Achte auf die Generizität
 
 
## A05 - Fibonacci
Die Fibonnacci Reihe ist eine der bekanntesten Zahlenfolgen. Im heutigen Beispiel soll ein Programm geschrieben werden mit folgenden Funktionen:
* Der Nutzer gibt eine Zahl ein und erhält die zugehörige Fibonacci Zahl
* Jede generierte Fibonacci Zahl soll in einer Liste gespeichert werden, falls diese noch nicht vorhanden ist
* Der Nutzer kann sich alle bereits generierten Zahlen ausgeben lassen
* Der Nutzer gibt eine Größe ein und erhält eine an Zahlen bis zu dieser und deren zugehörigen Fibonacci Zahlen
* Die Fibonacci Zahlen sollen bei der Ausgabe mittels toString() wie folgt ausgegeben werden:

```
0 : 0
1 : 1
2 : 1
3 : 2
4 : 3
5 : 5
. . .
```
Entwickle das Programm und gib alle zugehörigen Klassen ab. Die Funktionalität ist dabei in einer seperaten Klasse zu testen.

Achte besonders auf die Verwendung der richtigen Java Collection!


## A06 - Wörterbuch
Für diese Aufgabe werden Files benötigt, empfohlen wird dafür die java.io.File Bibliothek.

Es soll ein Wörterbuch entwickelt werden welches eine Benutzereingabe übersetzt und ausgibt.
Die Übersetzungen selbst werden dabei aus einer Datei geladen und in einer Liste gespeichert. Ist noch keine Datei vorhanden, so wird eine erstellt.

Ist die Eingabe nicht bekannt, so soll der Nutzer nach einer Übersetzung gefragt und die neue Eingabe gespeichert werden.
```
AUSGABE: Word to translate?
EINGABE: cookie
AUSGABE: Keks
AUSGABE: Word to translate?
EINGABE: expertise
AUSGABE: Unbekannt! Hinzufügen? (y/n)
EINGABE: y
AUSGABE: Neues Wort für "expertise"
EINGABE: Sachverstand
AUSGABE: expertise now means: Sachverstand
```
Wird das Programm beendet, sollen neu gelernte Wörter in die Datei geladen werden, um das Wörterbuch zu erweitern.

Gib zusätzlich zu deinem Java Projekt auch die Datei(en) des Wörterbuchs ab!


## A07 - Kotlin
Diese Aufgabe erfordert etwas Konfigurationsaufwand. Die Seite https://kotlinlang.org bietet dabei alle nötigten Informationen.

Softwareentwickler werden häufig mit neuen Sprachen konfrontiert, viele sogar täglich. Kotlin ist unserem geliebten Java sehr ähnlich und nutzt sogar denselben Bytecode. Der Sinn dieser Aufgabe besteht darin die Hauptmerkmale dieser Programmiersprache zu testen und Differenzen zur Konkurrenz zu ziehen.

Es soll ein Schrank für Spielzeugladen gebaut werden um Spielzeuge zu verstauen.

Ein Spielzeug hat jeweils Name, Mindestalter, Alterslimit und kann Lego, Holzspielzeug, oder ein Kartenspiel sein.

Die Spielzeuglade hat eine Liste an Spielzeugen mit einer fixen Größe welche im Konstruktur übergeben wird. Mittels zweier Methoden können Spielzeuge hinzugefügt und der Inhalt der Lade angezeigt werden.

Der Schrank selbst hat mehrere Spielzeugladen und seine Größe ist ebenfalls im Konstruktur definiert.

Ein Schrank soll dabei jeweils nur EINEN Typen von Spielzeugen erlauben!

Bonus (> 18 Punkte):
Gib zusätzlich zu deinem Kotlin Projekt eine Datei ab, in welcher du signifikante Unterschiede zwischen Kotlin und Java aufzeigst.


## A08 - Plagiatcheck
Für diese Aufgabe werden Files benötigt, empfohlen wird dafür die java.io.File Bibliothek.

Es soll ein Programm entwickelt werden um die Ähnlichkeit zweier Dokumente zu vergleichen.
Da zum Beispiel Hausaufgaben jedoch gerne nur "leicht umgeschrieben" werden kann man nicht den gesamten Inhalt, sondern nur einzelne Teile einer Datei überprüfen. 
Der Plagiatcheck soll sich dabei nach der Ähnlichkeit des Inhalts und dessen Position im Quelltext richten.
Nach der Überprüfung soll die durchschnittliche Ähnlichkeit der Dateien in Prozent angegeben werden:
```
// Bsp.: A01_mm.txt und A01_mk.txt
>> Ähnlichkeit: 90% # Hierbei handelt es sich vermutlich um ein Plagiat
TIPP: Eine einfache Methode wäre es zum Beispiel nach Wörtern zu vergleichen.
```


## A09 - Rennen
Ein Programm soll entwickelt werden, welches dem Benutzer erlaubt ein Rennen zu erstellen.
Dieser bestimmt zu Beginn die Anzahl der Teilnehmer und die maximalen Runden.

Pro Runde wird jedem Teilnehmer eine simple Rechenaufgabe gestellt und die Zeit gemessen.
Diese wird dann dem Punktestand des Teilnehmers hinzugefügt.

Nach jeder Runde wird der Punktestand aller Teilnehmer in dieser angezeigt und nach der letzten Runde sollen alle dieser Punktestände und die Gesamtpunkte aller Runden aufgezeigt werden.

Achte auf eine saubere Trennung von Ausgabe, Daten und Steuerung!

Bonus (> 18 Punkte):
Benutze für die Kommunikation mit dem Benutzer eine grafische Oberfläche.


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
