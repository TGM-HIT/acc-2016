"""
Author: TEKIN Abdurrahim Burak
Version: 22.12.2016
"""

import re

#Dictionaries für das Programm
adjectives = {
    'a' : 'Autistic',
    "b" : "Big",
    "c" : "Cool",
    "d" : "Derpy",
    "e" : "Elegant",
    "f" : "Fly",
    "g" : "Gentle",
    "h" : "Holy",
    "i" : "Irish",
    "j" : "Jewish",
    "k" : "Kek",
    "l" : "Long",
    "m" : "Massive",
    "n" : "Naive",
    "o" : "Odd",
    "p" : "Passionate",
    "q" : "Quick",
    "r" : "Radical",
    "s" : "Slow",
    "t" : "Trendy",
    "u" : "Useful",
    "v" : "Vanished",
    "w" : "Wide",
    "x" : "Xeric",
    "y" : "Yummy",
    "z" : "Zonal"
}

bridge = {
    "a" : "Animal",
    "b" : "Brooklyn",
    "c" : "Crap",
    "d" : "Donkey",
    "e" : "Eternity",
    "f" : "flying",
    "g" : "growing",
    "h" : "high",
    "i" : "irregular",
    "j" : "Java",
    "k" : "Kek",
    "l" : "Lion",
    "m" : "Monkey",
    "n" : "Normal",
    "o" : "Oglum",
    "p" : "Party",
    "q" : "Queen",
    "r" : "Razor",
    "s" : "slimy",
    "t" : "traditional",
    "u" : "ultraviolett",
    "v" : "Vendetta",
    "w" : "World",
    "x" : "Xavier",
    "y" : "Yolo",
    "z" : "Zero"
}

nouns = {
    "a": "Artist",
    "b": "Bear",
    "c": "Crown",
    "d": "Derp",
    "e": "Elephant",
    "f": "Fly",
    "g": "Gargoyle",
    "h": "Horse",
    "i": "Interpret",
    "j": "Joy",
    "k": "Kek",
    "l": "Lizardman",
    "m": "Moose",
    "n": "Neo-Spacian",
    "o": "Orange",
    "p": "Pool",
    "q": "Qatar",
    "r": "Rod",
    "s": "Sloth",
    "t": "Turkey",
    "u": "Ufo",
    "v": "Victim",
    "w": "Waffle",
    "x": "Xenon",
    "y": "Yeti",
    "z": "Zombie"
}

while True:
    #Eingabe
    text = input("Type in your name! / Type -x- for closing!" + "\n")
    text = text.lower()
    #Char Anfang, Mitte und Ende
    charstart = text[0]
    charend = text[len(text)-1]
    charmid = text[round((len(text)-1)/2)]

    if text == "x":
        print("==============")
        print("Shutting down!")
        print("==============")
        break
    elif charstart == " " or charend == " ":
        print("=========================================")
        print("No spaces at the beginning or at the end!")
        print("=========================================")
        continue
    #Wenn Eingabe aus Buchstaben und Leerzeichen besteht -> Programm wird weiter ausgeführt
    elif any(c.isalpha() or c.isspace() for c in text):
        #re.sub -> Mehrere Leerzeichen in der Mitte werden zu 1 Leerzeichen
        text = re.sub("\s\s+", " ", text)
        #Wenn String länger als 8 Zeichen -> Bridge wird verwendet
        if len(text) >= 8:
            if charmid == ' ':
                charmid = text[(round((len(text) - 1) / 2)) + 1]
            print(adjectives[charstart] + " " + bridge[charmid] + " " + nouns[charend])
            print("=========================================")
        else:
            #Wenn eingabe kleiner als 8 Zeichen -> Adjektiv und Nomen werden verwendet
            print(adjectives[charstart] + " " + nouns[charend])
            print("=========================================")
    else:
        #Wenn Programm Sonderzeichen enthält -> Programmneustart
        print("=========================================")
        print("Don't use special characters!")
        print("=========================================")
        continue
