# Settings
import random

quiz_questions = [
    {
        "question": "Wie heißt dieser operator '<<'?",  # Frage
        "answer_A": "Multiplikations-Operator",         # A
        "answer_B": "XOR-Operator",                     # B
        "answer_C": "Left-Shift-Operator",              # C
        "answer_D": "Right-Shift-Operator",             # D
        "answer_right": "C"                             # Richtiger Buchstabe
    },
    {
        "question": "Die Umkehrung der Integration ist die ...",
        "answer_A": "Differentiation",
        "answer_B": "Multiplikation",
        "answer_C": "Es gibt keine",
        "answer_D": "Division",
        "answer_right": "A"
    },
    {
        "question": "Welche Programmiersprache wird nativ kompiliert?",
        "answer_A": "Python",
        "answer_B": "Lua",
        "answer_C": "C++",
        "answer_D": "Java",
        "answer_right": "C"
    },
    {
        "question": "Welche Programmiersprache wird in den ersten 3 Jahre im TGM gelehrt?",
        "answer_A": "Python",
        "answer_B": "Lua",
        "answer_C": "C++",
        "answer_D": "Java",
        "answer_right": "D"
    },
    {
        "question": "Wann findet die Weihnachtsfeier der IT-Abteilung statt?",
        "answer_A": "24.12.2016",
        "answer_B": "23.12.2016",
        "answer_C": "22.12.2016",
        "answer_D": "21.12.2016",
        "answer_right": "B"
    }
]
max_questions = 3  # Wie viele Fragen gestellt werden soll




if __name__ == '__main__':
    print("Willkommen zum Quiz! %d Fragen werden dir gestellt. "
          "Wenn du früher aufhören willst, dann schreib 'exit' als Antwort." % max_questions)

    current_quiz = list(quiz_questions) # Kopieren
    right_answers = 0
    should_exit = False
    for i in range(0, max_questions):
        random_question = current_quiz.pop(random.randint(0, len(current_quiz) - 1)) # Einfache Möglichkeit um Duplikate zu vermeiden!
        print("Frage %d: %s" % (i, random_question["question"]))
        print("A: ", random_question["answer_A"])
        print("B: ", random_question["answer_B"])
        print("C: ", random_question["answer_C"])
        print("D: ", random_question["answer_D"])
        while True:
            selected = input("Antwort: ").lower()
            if selected == "exit":  # Quit verlassen
                should_exit = True
                break
            if selected != "a" and selected != "b" and selected != "c" and selected != "d":  # Valider Input?
                print("Ungültiger Buchstabe ", selected)
                continue
            if selected == random_question["answer_right"].lower():  # Richtige Antwort!
                print("Richtig!")
                right_answers += 1
            else:                                                    # Falsche Antwort!
                print("Leider Falsch!")
            break
        if should_exit:
            break

    if should_exit:
        print("Du hast %d Fragen richtig beantwortet!" % right_answers)
    else:
        if right_answers == max_questions:
            print("Gratulation! Du hast alle %d Fragen richtig beantwortet!" % max_questions)
        else:
            print("Du hast %d von %d Fragen richtig beantwortet!" % (right_answers, max_questions))




