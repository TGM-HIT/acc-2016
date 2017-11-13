adjectives = {
    "a": "aggressive", "b": "big", "c": "calm", "d": "dirty", "e": "evil", "f": "fast", "g": "good",
    "h": "heavy", "i": "ill", "j": "joyful", "k": "kosher", "l": "large", "m": "mad", "n": "naive",
    "o": "optimistic", "p": "poor", "q": "quick", "r": "reliable", "s": "salty", "t": "tiny", "u": "ugly",
    "v": "vibrant", "w": "wet", "x": "xxx", "y": "young", "z": "zealous"
}

nouns = {
    "a": "apple", "b": "banana", "c": "cd", "d": "donut", "e": "elephant", "f": "frappe", "g": "gorilla", "h": "house",
    "i": "indian", "j": "jungle", "k": "knot", "l": "lama", "m": "monkey", "n": "nothing", "o": "oxygen", "p": "path",
    "q": "quiz", "r": "rice", "s": "snake", "t": "tiger", "u": "uniform", "v": "variable", "w": "window", "x": "xray",
    "y": "", "z": "zebra"
}

bridges = {
    "a": "atom", "b": "bridge", "c": "camel", "d": "donkey", "e": "email", "f": "finger", "g": "grape", "h": "hand",
    "i": "immigrant", "j": "justice", "k": "kilo", "l": "ladder", "m": "mountain", "n": "number", "o": "orange",
    "p": "pony", "q": "question", "r": "rabbit", "s": "sand", "t": "tide", "u": "ufo", "v": "vomit", "w": "water",
    "x": "x", "y": "y", "z": "zombie"
}

""" Read some input """
txt = input("INPUT: ")
try:
    """ Print some output """
    if len(txt) > 8:
        print("OUTPUT: " + adjectives[txt[0]] + " " + bridges[txt[int(len(txt) / 2)]] + " " + nouns[txt[len(txt) - 1]])
    else:
        print("OUTPUT: " + adjectives[txt[0]] + " " + nouns[txt[len(txt) - 1]])
except KeyError:
    print("Invalid symbol!")
