import sqlite3
import random


class Quiz:
    """
    Quiz mit 4 Antwortmoeglichkeiten
    """
    stat_counter = dict(correct=0, wrong=0)
    question_counter = 0

    def __init__(self):
        """
        Initialize
        """
        self.db = sqlite3.connect("quiz.db")
        self.cursor = self.db.cursor()
        self.create_db()

    def reset_db(self):
        """
        Reset the database
        """
        print("Database deleted!")

        self.cursor.execute("DROP TABLE IF EXISTS question")
        self.cursor.execute("DROP TABLE IF EXISTS answer")

        self.db.commit()

    def create_db(self):
        """
        Create the database
        """
        self.cursor.execute("CREATE TABLE IF NOT EXISTS question(id INTEGER PRIMARY KEY, text TEXT)")
        self.cursor.execute(
            "CREATE TABLE IF NOT EXISTS answer("
            "id INTEGER PRIMARY KEY, "
            "text TEXT, q_id INTEGER, correct BOOLEAN,"
            "FOREIGN KEY(q_id) REFERENCES question(id))"
            "")

    def get_question(self):
        """
        Get the questions with answers from the database

        :return: question with answers
        """
        self.cursor.execute("SELECT MAX(id) FROM question")

        max_id = self.cursor.fetchone()

        if max_id[0] is not None:
            if self.question_counter < max_id[0]:
                self.question_counter += 1
            else:
                print("No more questions!")
                return False

            self.cursor.execute("SELECT id, text FROM question WHERE id = ?", (self.question_counter,))

            result = self.cursor.fetchone()

            q_id, res_question = result

            res_answers = []
            self.cursor.execute("SELECT text FROM answer WHERE q_id = ?", (q_id,))
            for answer in self.cursor:
                res_answers.append(answer[0])

            return {"question": res_question, "correct": res_answers[0], "answer 2": res_answers[1],
                    "answer 3": res_answers[2], "answer 4": res_answers[3]}

        else:
            print("No questions in database!")
            return False

    def ask_user(self, question_answer_set):
        """
        Ask the user for an answer

        :param question_answer_set: the question with the answers
        :return: the users answer
        """
        random_answers = [question_answer_set["correct"], question_answer_set["answer 2"],
                          question_answer_set["answer 3"],
                          question_answer_set["answer 4"]]
        random.shuffle(random_answers)

        print("# Frage: %s\n"
              "1) %s\n"
              "2) %s\n"
              "3) %s\n"
              "4) %s\n"
              % tuple([question_answer_set["question"]] + random_answers))

        user_in = ""
        while True:
            user_in = input("Antwort (1-4): ")
            if user_in in ['1', '2', '3', '4']:
                break
            else:
                print("Invalid Input '%s'!" % user_in)

        return random_answers[int(user_in) - 1]

    def ask_add_question(self):
        """
        Ask user for new question input

        :return: the new added question and answers
        """
        question = input("Frage: ")
        antwort_1 = input("Richtige Antwort: ")
        antwort_2 = input("Antwort 2: ")
        antwort_3 = input("Antwort 3: ")
        antwort_4 = input("Antwort 4: ")
        return [question, antwort_1, antwort_2, antwort_3, antwort_4]

    def add_question(self, question, answer_1_correct, answer_2, answer_3, answer_4):
        """
        Add a new question to database

        :param question: the question
        :param answer_1_correct: answer 1
        :param answer_2: answer 2
        :param answer_3: answer 3
        :param answer_4: answer 4
        """
        self.cursor.execute("INSERT INTO question(text) VALUES (?)", (question,))

        self.cursor.execute("SELECT MAX(id) FROM question")
        a_id = int(self.cursor.fetchone()[0])

        self.cursor.execute("INSERT INTO answer(text, correct, q_id) VALUES (?,?,?)", (answer_1_correct, 0, a_id))
        self.cursor.execute("INSERT INTO answer(text, correct, q_id) VALUES (?,?,?)", (answer_2, 0, a_id))
        self.cursor.execute("INSERT INTO answer(text, correct, q_id) VALUES (?,?,?)", (answer_3, 0, a_id))
        self.cursor.execute("INSERT INTO answer(text, correct, q_id) VALUES (?,?,?)", (answer_4, 0, a_id))

        self.db.commit()

    def format_solution(self, solution):
        """
        Print the question solution

        :param solution: the solution
        """
        print("Question: %s\nAnswer 1: %s\nAnswer 2: %s\nAnswer 3: %s\nAnswer 4: %s" % (
            solution[0], solution[1], solution[2], solution[3], solution[4]))

    def edit_db(self):
        """
        Display database edit menu

        :return: menu number
        """
        print("DB Edit\n"
              "1) DELETE Database\n"
              "2) Back")

        user_in = ""
        while True:
            user_in = input("Select: ")
            if user_in in ['1', '2']:
                break
            else:
                print("Invalid Input '%s'!" % user_in)

        return int(user_in)

    def statistic(self, answer_correct):
        """
        Edit the quiz statistic

        :param answer_correct: question correct or not
        """
        if answer_correct:
            self.stat_counter["correct"] += 1
        else:
            self.stat_counter["wrong"] += 1

    def print_statistic(self):
        """
        Print the game statistic
        """
        print("\n"
              "Statistics:\n"
              "Correct: %i\n"
              "Wrong: %i\n"
              "Total: %i\n"
              % (self.stat_counter["correct"], self.stat_counter["wrong"],
                 self.stat_counter["correct"] + self.stat_counter["wrong"]))

    def check_answer(self, answer, solution):
        """
        Check if answer was correct

        :param answer: user answer
        :param solution: the solution
        :return:
        """
        if answer == solution:
            print("Correct!")
            return True
        else:
            print("False!")
            return False

    def ask_mode(self):
        """
        Display menu

        :return: menu number
        """
        print("# Modes:\n"
              "1) Add question\n"
              "2) Quiz Mode\n"
              "3) Exit\n"
              "4) DB Edit\n")

        user_in = ""

        while True:
            user_in = input("Choose Mode: ")
            if user_in in ['1', '2', '3', '4']:
                break
            else:
                print("Invalid Input '%s'!" % user_in)

        return int(user_in)

    def game_mode(self):
        """
        The main game mode
        """
        user_input = ""

        while True:
            resp_get_questions = self.get_question()
            if resp_get_questions:
                self.statistic(self.check_answer(self.ask_user(resp_get_questions), resp_get_questions["correct"]))
            else:
                break

            while True:
                user_input = input("Next? (y/n)")
                if user_input in ("y", "n"):
                    break
                else:
                    print("Invalid input!")

            if user_input == "n":
                break


if __name__ == '__main__':
    q = Quiz()

    while True:
        mode = q.ask_mode()

        if mode == 1:
            print("# Adding Question")
            q.add_question(*q.ask_add_question())
        elif mode == 2:
            print("# Quiz")
            if q.game_mode():
                break

        elif mode == 3:
            print("# Exit")
            q.print_statistic()
            break
        elif mode == 4:
            db_edit_mode = q.edit_db()
            if db_edit_mode == 1:
                q.reset_db()
                break
            elif db_edit_mode == 2:
                pass
