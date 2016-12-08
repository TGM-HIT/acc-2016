## GetSet
Getter und Setter werden benötigt um den Zugriff auf private Variablen zu ermöglichen.
Doch diese werden nicht nur genutzt um ``return var;`` aufzurufen, sondern können noch um einiges mehr!

Schreibe eine Klasse ``User`` mit den privaten Attributen ``username``, ``password``, ``firstname`` und ``lastname``.

Diese Werte sollen später geändert werden können.

Der Benutzername muss dabei mindestens 3 Zeichen lang sein und ist der neue Wert leer oder entspricht dem alten, 
wird eine Fehlermeldung ausgegeben.

Das Passwort muss mindestens 8 Zeichen lang sein und muss mindestens ein Hoch- und ein Tiefgestelltes Zeichen enthalten.
Zudem wird eine Meldung ausgegeben wenn das Passwort leer ist oder dem alten entspricht.

Vorname und Nachname dürfen keine Zahlen enthalten und auch nicht null sein.