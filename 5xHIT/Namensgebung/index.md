## Namensgebung
Es ist oft schwer sich einen guten Namen einfallen zu lassen, doch ein kleines Programm soll nun Abhilfe schaffen!

Ein Name besteht aus 3 Teilen:
- Adjektiv
- Brücke
- Nomen

Jedem dieser Teile wird pro Buchstabe ein Wort zugewiesen:
```
# Beispiel
adjectives = {
    "a": "Anonymous",
    "b": "Big",
    "c": "Classic,
    ...
}
```
Zu Beginn wird der Benutzer dazu aufgefordert seinen Namen einzugeben.
Der erste Buchstabe wird verwendet um das Adjektiv zu besimmten, der letzte für das Nomen. 
Ist der Name länger als 8 Zeichen, so wird der mittlere Buchstabe verwendet um eine Brücke einzufügen.
```
# Beispiel
>> INPUT: Hannes
>> OUTPUT: Hilarous Snake

>> INPUT: Bartholomeo
>> OUTPUT: Big Oktopus Ork
```