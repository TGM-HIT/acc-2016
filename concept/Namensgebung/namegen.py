class NameGen:
    def __init__(self):
        self.first = {
            "A": "Almighty",
            "B": "Burning",
            "C": "Crying",
            "D": "Dark",
            "E": "Eccentric",
            "F": "Flaming",
            "G": "Great",
            "H": "Holy",
            "I": "Icy",
            "J": "Jade",
            "K": "Kind",
            "L": "Lazy",
            "M": "Marvelous",
            "N": "Northern",
            "O": "Old",
            "P": "Polite",
            "Q": "Qualitative",
            "R": "Rich",
            "S": "Super",
            "T": "Trendy",
            "U": "Useless",
            "V": "Vague",
            "W": "Wonderful",
            "X": "Xenophobic",
            "Y": "Young",
            "Z": "Zappy"
        }

        self.bridge = {
            "A": "Artistic",
            "B": "Bold",
            "C": "Chicken",
            "D": "Dumpster",
            "E": "Extra",
            "F": "Fire",
            "G": "Grass",
            "H": "Hurricane",
            "I": "Interlaced",
            "J": "Jurassic",
            "K": "Killer",
            "L": "Laser",
            "M": "Moon",
            "N": "North",
            "O": "Opposite",
            "P": "Premium",
            "Q": "Quality",
            "R": "Rodeo",
            "S": "Star",
            "T": "Throne",
            "U": "Underworld",
            "V": "Variety",
            "W": "Walker",
            "X": "Xenon",
            "Y": "Yield",
            "Z": "Zeus"
        }

        self.last = {
            "A": "Ant",
            "B": "Bear",
            "C": "Cheetah",
            "D": "Dragon",
            "E": "Eagle",
            "F": "Fox",
            "G": "Giraffe",
            "H": "Hibiscus",
            "I": "Insect",
            "J": "Jay",
            "K": "Knight",
            "L": "Lion",
            "M": "Monster",
            "N": "Narwhal",
            "O": "Observer",
            "P": "Panther",
            "Q": "Quiver",
            "R": "Rat",
            "S": "Snake",
            "T": "Turkey",
            "U": "Underdog",
            "V": "Viper",
            "W": "Wolf",
            "X": "Xerus",
            "Y": "Yak",
            "Z": "Zombie"
        }

        while True:
            name = input("Your name? (q for quit)")
            if name == "q":
                break

            print("Your are a " + self.generate(name) + "!")

    def generate(self, name):
        name = name.upper()
        nick = ""
        nick += self.first[name[0]] + " "

        if len(name) > 5:
            nick += self.bridge[name[int(len(name) / 2)]] + " "

        nick += self.last[name[len(name) - 1]]

        return nick


if __name__ == "__main__":
    ng = NameGen()