## Crawl the Web
Diese Aufgabe nutzt die Python Bibliothek ``urllib``, welche beim Abrufen von Links unterstützt.
Folgender Ausschnitt aus der Dokumentation speichert den Quelltext von http://python.org in der Variable html.
```python
import urllib.request

with urllib.request.urlopen('http://python.org/') as response:
    html = response.read()
```
Die Aufgabe selbst ist es nun ein Programm zu schreiben welches Websites nach Links durchsucht
und diese öffnet, auf den verlinkten Websites wird dieses vorgehen wiederholft.

Der Nutzer soll dabei bestimmen können bis zu welcher Tiefe durchsucht wird.
Beachte, dass dies bei Großen Websites viel Zeit in Anspruch nehmen kann.
Die Laufzeit kann jedoch durch die Verwendung von Threads stark verbessert werden!

Alle gefundenen Links sollen am Ende, ohne Duplikate, in einer Datei gespeichert werden.

Teste dein Programm an einer beliebigen Website und gib sowohl das Projekt, als auch die Datei ab.


TIPP: Die Regex Bibliothek ``re`` bildet eine große Hilfe bei der Suche nach Links