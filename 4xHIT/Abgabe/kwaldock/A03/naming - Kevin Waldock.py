
adjectives = {
    "a": "Awesome",
    "b": "Beautiful",
    "c": "Cold",
    "d": "Drunk",
    "e": "Eager",
    "f": "Frighting",
    "g": "Giant",
    "h": "Hating",
    "i": "Iconic",
    "j": "Jealous",
    "k": "Kinetic",
    "l": "Lucky",
    "m": "Mold",
    "n": "Nice",
    "o": "Old",
    "p": "Painful",
    "q": "Quick",
    "r": "Rainy",
    "s": "Shining",
    "t": "Tearing",
    "u": "Useful",
    "v": "Valid",
    "w": "Wild",
    "x": "Xeric",
    "y": "Yummy",
    "z": "Zippy"
}

bridge = {
    "a": "Agile",
    "b": "Brown",
    "c": "Coffee",
    "d": "Dorky",
    "e": "Eagle",
    "f": "Frighting",
    "g": "Gold",
    "h": "High",
    "i": "Ironic",
    "j": "Jet",
    "k": "Knot",
    "l": "Lucky",
    "m": "Magic",
    "n": "Nightly",
    "o": "Owning",
    "p": "Pan",
    "q": "Quarky",
    "r": "Rusty",
    "s": "Strange",
    "t": "Towing",
    "u": "Unbelievable",
    "v": "Vault",
    "w": "Woody",
    "x": "Xian",
    "y": "Year",
    "z": "Zeal"
}

noun = {
    "a": "Ajax",
    "b": "Bridge",
    "c": "Computer",
    "d": "Dog",
    "e": "England",
    "f": "Foodstation",
    "g": "Gift",
    "h": "Hillary",
    "i": "Italy",
    "j": "Jawfish",
    "k": "Kid",
    "l": "Lasagna",
    "m": "Mine",
    "n": "Network",
    "o": "Oasis",
    "p": "Pool",
    "q": "Quads",
    "r": "Reed",
    "s": "Steel",
    "t": "Trump",
    "u": "Umbrella",
    "v": "Vladimir",
    "w": "Wlan",
    "x": "Xylophone",
    "y": "Yield",
    "z": "Zealot"
}


if __name__ == '__main__':
    print("Write 'Exit' for exit")
    while True:
        # Get the Input
        input_txt = input("INPUT: ").lower()
        if input_txt == "exit":
            break

        # Get the first letter
        out_txt = adjectives[input_txt[0]]

        # If the text is bigger than 8, then also insert the bridge
        if len(input_txt) > 8:
            out_txt += " " + bridge[input_txt[len(input_txt) // 2]]

        # Get the last letter and add a noun
        out_txt += " " + noun[input_txt[len(input_txt) - 1]]

        # Output!
        print("OUTPUT: %s" % out_txt)