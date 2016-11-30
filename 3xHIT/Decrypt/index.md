## Decrypt
Versteckt in einem Verschlüsselungs Virus findest du folgende Zeile:
```
String a(String d){String c="BCDEFGHIJKLMNOPQRSTUVWXYZA";String b="ABCDEFGHIJKLMNOPQRSTUVWXYZ";String e="";d=d.toUpperCase();for (int i = 0; i < d.length(); i++){char f=d.charAt(i);if (b.indexOf(f) > -1) {e+=c.charAt(b.indexOf(f));}else{e+=f;}}return e;} \n "ZPV TPMWFE NZ QVAAMF"
```

Finde die versteckte Nachricht!
