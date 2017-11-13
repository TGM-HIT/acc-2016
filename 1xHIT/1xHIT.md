## A01 - Stern
Der Hamster startet mit 99 Körnern von oben links und soll eine Schneeflocke in ein 11 x 11 großes Territorium zeichnen.
Eine Vorlage befindet sich unten als stern.ter!
```
//    Bsp.: 9 x 9 Felder

      *       
   *  *  *    
    * * *     
     * *      
  *** * ***   
     * *      
    * * *     
   *  *  *    
      *
```


## A02 - Geschenke
Der Hamster startet mit 99 Körnern von oben links und soll zu jedem Korn auf dem Territorium ein weiteres Korn hinzulegen. Ist er mit dieser Aufgabe fertig geht er an seinen Ursprungsort zurück, legt die verbliebenen Körner ab und zählt sie.
Eine Vorlage befindet sich als koerner.ter im Anhang.


## A03 - Infoseite
In der Klasse werden noch viele Informationen zum Fest benötigt. Erstelle eine Website welche auf 3 Unterseiten Auskunft über folgende Themen gibt:

* Weihnachtslieder
* Backrezepte
* Geschichte des Weihnachtsbaums

Verlinke diese auf der Hauptseite und vergiss nicht den Link zurück zu setzen! Auch Kreativität wird bewertet.


## A04 - Formulare
Mit HTML5 wurden der Sprache zahlreiche Möglichkeiten zur einfachen Formulargestaltung gegeben.

Ein klassisches Formular könnte zum Beispiel so aussehen:
```
<form>
    Benutzername<br>
    <input type="text">
    Passwort<br>
    <input type="password">
    <input type="submit">
</form>
```
Erstelle ein Formular mit folgenden Eingaben:
* Benutzername
* Email
* Passwort
* Geburtsdatum
* Lieblingszahl
* Lieblingsfarbe
* Telefonnummer
* Link zur eigenen Website

Benutze dabei jeweils geeignete input Typen (Bsp.:Lieblingsfarbe: <input type="color">)

Auf http://www.w3schools.com/html/html_form_input_types.asp findest du zahlreiche Hilfestellungen zum erstellen von Formularen mittels HTML5!

Abzugeben ist deine index.html!


## A05 - Taschenrechner
Auch der Hamstersimulator kann als ein simpler Taschenrechner fungieren.

Der Hamster startet mit 9999 Körnern im Maul links oben im Territorium.

Bei Start beginnt der Hamster die Körner zu zählen und eine bestimmte Rechenoperation auszuführen.
Das Feld vor dem Hamster stellt eine Zahl dar, das Feld danach einen Operatoren und wieder ein Feld weiter steht die zweite Zahl.
```
Bsp.: Hamster | 3 Körner | 1 Korn | 4 Körner
```
Das Ergebnis der Rechnung wir dann auf dem Startfeld abgelegt.

Es soll sowohl Addition, als auch Multiplikation möglich sein.
1 Korn als Operator bedeutet eine Addition
2 Körner eine Multiplikation

Die Datei rechner.ter kann als Vorlage verwendet werden!
Abzugeben ist die .ham Datei.


## A06 - Eichhörnchen
Der Hamster startet ohne Körner links oben in einem Territorium. 

Zu Beginn soll er sowohl alle Körner im Territorium aufsammeln und zählen, als auch die Größe des Territoriums ermitteln. 

Danach soll er mit den gesammelten Körnern den größtmöglichen Baum auslegen. 
Hat dieser im Territorium keinen Platz, so soll eine Fehlermeldung ausgegeben werden.
```
Bsp.: Territorium mit 9 Körnern

  *
 ***
*****

Bsp.: Territorium mit 20 Körnern

   *
  ***
 *****
*******
```

## A07 - Adventskalender
In einem beliebigen Territorium mit 24 Feldern startet ein Hamster links oben. Auf einem der Felder befindet sich eine Mauer, welche den nächsten Tag symbolisiert. Der Hamster soll so lange Körner einsammeln bis er diese Mauer findet und dann die Anzahl der abgegangenen Felder als vergangene Tag, sowie die Anzahl der Körner ausgeben.
Zuletzt soll ausgegeben werden wie viele Tage bis Weihnachten (Feld 24) verbleiben.

Mögliche Ausgabe:
```
Heute ist der 13. Advent, nur noch 11 Tage bis Weihnachten und schon 20 Körner gefunden!
```
Ein Beispielterritorium ist als advent.ter beigelegt.


## A08 - Media
Mit HTML5 wurden der Sprache zahlreiche Möglichkeiten zur einfachen Einbindung von Medien gegeben. So können etwa Video- und Audiodatein, aber auch Streams und sogar andere Websites in der Browser eingebaut werden.

Diese Aufgabe beschäftigt sich dabei mit folgenden Medien:
* Audio
* Grafik
* Video
* YouTube
* HTML

Inkludiere in deine Website jeweils eine Audiodatei, ein Bild, ein Video, ein Youtube Video, sowie eine weitere HTML Seite.
Verwende für das Beispiel Medien deiner Wahl, beachte jedoch, dass die Dateien auch hochgeladen werden sollen!

Weitere Informationen zum Einbinden von Medien findest du zum Beispiel unter: http://www.w3schools.com/html/html_media.asp


## A09 - Semantics
Mit HTML5 wurden der Sprache zahlreiche Möglichkeiten zur einfachen Strukturierung von Websites gegeben. So können etwa schon im Vorhinein Abteile wie Seitennavigation, Sidebars, Kopf- und Fußzeile besimmt werden.

Bei dieser Aufgabe soll eine Seite in folgende Abschnitte unterteilt werden:
* Kopfzeile
    * Titel und Logo
* Navigation
    * 5 beliebige Links
* Übersicht
    * Kurzzusammenfassung des folgenden Artikels
* Artikel
    * Ein beliebiger Artikel wie etwa in einer Zeitung
* Seitenansicht
    * Weitere Informationen zur Website
* Fußzeile
    * Kontaktinformationen

Versuche bei der Unterteilung der Website vollständig auf die Verwendung von Divisionen (<div></div>) zu verzichten!

Alle benötigten Informationen zur Verwendung von Semantischen Elementen findest du unter: http://www.w3schools.com/html/html5_semantic_elements.asp


## A10 - Hamstertanz
Der Hamster muss in einem Territorium so viele Körner aufsammeln wie möglich, jedoch wird anstatt der vor() Methode immer die tanz() Methode aufgerufen welche lautet:
```
vor();
linksUm();
vor();
linksUm();
vor();
linksUm();
vor();
linksUm();
vor();
vor();
```
Fülle zum Test ein Territorium voll mit Körnern und versuche sie alle einzusammeln.
Achte auf die Begrenzung des Gebiets!
