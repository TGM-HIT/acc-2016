## Markdown to HTML

Um Informationen schneller veröffentlichen zu können wird ein Dienst benötigt,
welcher Markdown in HTML umwandeln und die exportierte Seite auf dem Server veröffentlichen soll.

Der Server dazu wird dabei von der server.Server Klasse simuliert,
welche das Projekt über http://localhost:8000 bereitstellt.

Schreibe die convert Methode für die MDHTMLConverter Klasse und gib das converter Modul,
sowie die exportierte .html Datei ab. Es müssen NUR die in der test.md verwendeten Stilisierungen verwendet werden!

```
<!-- Beispiele -->
# Titel     => <h1>Title</h1>
*bold*      => <b>bold</b>
* item      => <li>Item
- item      => <li>Item
```