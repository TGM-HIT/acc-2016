## A01 - Geschenke
Es ist an der Zeit die Geschenke zu bestellen. Die Fabrik steht bereit, doch es fehlen Arbeiter in der Herstellung.

Schreibe die Klassen PresentProducer und PresentConsumer. Der Producer fragt den Benutzer nach einem Geschenk und schickt es an den Consumer. Dieser schreibt das Geschenk in eine Datei. Gibt der Benutzer "nichts" ein wird der Ablauf beendet.

Die Ausgabe könnte dabei wie folgt aussehen:
```
/* Möglicher Ablauf */
>> PROGRAMM: Was wünscht du dir?
>> BENUTZER: Kekse
>> PROGRAMM: Was wünscht du dir?
>> BENUTZER: Geschenke
>> PROGRAMM: Was wünscht du dir?
>> BENUTZER: Nichts
>> PROGRAMM: Na gut

/* wunschliste.csv */
>> Kekse, Geschenke
Das Modul geschenke.py kann als Vorlage verwendet werden.
Achte auf eine saubere Ausführung!
```


## A02 - Entschlüsselung
Versteckt in einem Verschlüsselungs-Virus findest du folgende Zeile:
```
defa(b,c="advent",d=""):fore,finenumerate(b):d+=chr((ord(f)+ord(c[e%len(c)]))%int(0b1111110))returnd
<Um�ceO\]K�c\�h\jpOK�
```
Rekonstruiere das Programm und entschlüssle die Nachricht!
Sollten die Zeichen nicht richtig dargestellt werden liegt die Angabe in der Datei c:


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


## A04 - Markdown to HTML
Um Informationen schneller veröffentlichen zu können wird ein Dienst benötigt, welcher Markdown in HTML umwandeln und die exportierte Seite auf dem Server veröffentlichen soll.

Der Server dazu wird dabei von der server.Server Klasse simuliert, welche das Projekt über http://localhost:8000 bereitstellt.

Schreibe die convert Methode für die MDHTMLConverter Klasse und gib das converter Modul, sowie die exportierte .html Datei ab. Es müssen NUR die in der test.md verwendeten Stilisierungen verwendet werden!
```
<!-- Beispiele -->
# Titel     => <h1>Title</h1>
*bold*      => <b>bold</b>
* item      => <li>Item
- item      => <li>Item
```


## A05 - Web Crawler
Diese Aufgabe bevorzugt die Python Bibliothek urllib, welche beim Abrufen von Links unterstützt. Folgender Ausschnitt aus der Dokumentation speichert den Quelltext von http://python.org in der Variable html.
```
import urllib.request

with urllib.request.urlopen('http://python.org/') as response:
    html = response.read()
```
Die Aufgabe selbst ist es nun ein Programm zu schreiben welches Websites nach Links durchsucht und diese öffnet, auf den verlinkten Websites wird dieses vorgehen wiederholft.
Der Nutzer soll dabei bestimmen können bis zu welcher Tiefe durchsucht wird. Beachte, dass dies bei Großen Websites viel Zeit in Anspruch nehmen kann. Die Laufzeit kann jedoch durch die Verwendung von Threads stark verbessert werden!
Alle gefundenen Links sollen am Ende, ohne Duplikate, in einer Datei gespeichert werden.
Teste dein Programm an einer beliebigen Website und gib sowohl das Projekt, als auch die Datei ab.

TIPP: Die Regex Bibliothek re bildet eine große Hilfe bei der Suche nach Links


## A06 - Wörterbuch
Für diese Aufgabe soll ein Wörterbuch entwickelt werden, welches eine Benutzereingabe übersetzt und ausgibt.

Die Übersetzungen selbst werden dabei aus einer Datei bezogen. Ist noch keine Datei vorhanden, so wird eine erstellt.
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

Bonusaufgabe (> 18 Punkte):
Ein Wörterbuch kann Millionen von Wörter beinhalten und jedes mal eine Liste nach diesen zu durchsuchen kann die Laufzeit stark beeinträchtigen.
Unterteile dein Wörterbuch in einzelnde Bereiche welche leichter zu durchsuchen sind.


## A07 - Kotlin
Diese Aufgabe erfordert etwas Konfigurationsaufwand. Die Seite https://kotlinlang.org bietet dabei alle nötigten Informationen.

Softwareentwickler werden häufig mit neuen Sprachen konfrontiert, viele sogar täglich. Kotlin ist unserem geliebten Java sehr ähnlich und nutzt sogar denselben Bytecode. Der Sinn dieser Aufgabe besteht darin die Hauptmerkmale dieser Programmiersprache zu testen und Differenzen zur Konkurrenz zu ziehen.

Es soll ein Programm entwickelt werden um einzelne Wagons eines Zuges zu kontrollieren. 
Ein Zug besteht aus mindestens einem Wagon und kann Wagons an- und abhängen, jedoch keinen Wagon aus der Mitte entfernen. 

Ein Wagon kann offen oder geschlossen sein und kann eine bestimmte Anzahl an Personen aufnehmen. 

Weiters kann ein Wagon, Speise-, Reise, und Transportwagon sein, wobei ein Wagon durchaus mehrere Typen gleichzeitig besitzen kann.
* Der Speisewagon beinhaltet eine bestimmte Menge an Nahrungsmitteln und kann bei Bedarf Essen ausgeben kann.
* Der Reisewagon kann eine bestimmte Menge an Passagieren aufnehmen und soll Gäste abweisen wenn er voll ist.
* Der Transportwagon kann eine Fracht aufnehmen und soll eine Fehlermeldung ausgeben wenn dieser voll ist.

Bonus (> 18 Punkte):
Gib zusätzlich zu deinem Kotlin Projekt eine Datei ab, in welcher du signifikante Unterschiede zwischen Kotlin und Java aufzeigst.


## A08 - Plagiatcheck
Es soll ein Programm entwickelt werden um die Ähnlichkeit verschiedener Dokumente zu vergleichen.
Da zum Beispiel Hausaufgaben jedoch gerne nur "leicht umgeschrieben" werden kann man nicht den gesamten Inhalt, sondern nur einzelne Teile einer Datei überprüfen.

Der Plagiatcheck soll sich dabei nach der Ähnlichkeit des Inhalts und dessen Position im Quelltext richten.
Nach der Überprüfung soll die durchschnittliche Ähnlichkeit der Dateien, sowie die Ähnlichkeit zwischen den einzelnen Dateien in Prozent angegeben werden.
```
// Bsp.: 3 Files
check(a01_mm.txt, a01_mf.txt, a01_mk.txt)

>> Durchschnittliche Ähnlichkeit: 50%
>> a01_mm.txt : a01_mf.txt    80%    # Hierbei handelt es sich vermutlich um ein Plagiat
>> a01_mm.txt : a01_mk.txt    30%
>> a01_mf.txt : a01_mk.txt    30%
```

TIPP: Eine einfache Methode wäre es zum Beispiel nach Wörtern zu vergleichen.


## A09 - Rennen
Bei diesem Beispiel wird die sogenannte Race Condition ausgenutzt.

Nur wird diese nicht vermieden sondern zu unserem Vorteil verwendet.

Mehrere Prozesse greifen auf dieselbe Liste zu, welche von einem weiteren Prozess mit zufälligen Zahlen gefüllt wird.
Die Prozesse nehmen sich eine Zahl aus dieser Liste und fügen diese ihrem Score hinzu.

Der Benutzer gibt an wie viele Prozesse am Rennen teilnehmen und wie hoch die zufällige Zahl maximal sein darf.

Während des Ablaufs kann der Benutzer entweder eigene Zahlen einwerfen oder das Rennen beenden.
In letzterem Fall soll eine Rangliste mit Punkten angezeigt werden.

Parallel zur Eingabe sollen zudem, in regelmäßigen Abständen, die Punkte der einzelnen Teilnehmer angezeigt werden.


## A10 - Tic Tac Toe
Es soll ein simples Tic Tac Toe Spiel mit einer grafischen Oberfläche entwickelt werden.
Der Benutzer kann auf einem 3 x 3 Raster jeweils abwechselnd für X und O setzen und wer zuerst 3 in einer Reihe hat gewinnt. In diesem Fall und wenn das gesamte Raster voll ist, soll eine Meldung ausgegeben und das Spiel neu gestartet werden.

Bonus(>18 Punkte):
Speichere den Spielstand falls die Partie zum schließen des Programms nicht fertiggespielt wurde und lade ihn dann erneut.
