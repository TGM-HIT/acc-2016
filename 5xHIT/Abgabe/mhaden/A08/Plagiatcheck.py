from difflib import SequenceMatcher
import sys


class Checker:
    """
    Plagiarism check
    """

    def __init__(self, files):
        mean = 0
        output = ""

        try:
            for i in range(len(files)):
                for j in range(0 + i + 1, len(files)):
                    with open(files[i]) as a, open(files[j]) as b:
                        ratio = SequenceMatcher(None, a.read(), b.read()).ratio()
                        output += "%s : %s \t %.2f%%\n" % (files[i], files[j], ratio * 100)
                        mean += ratio * 100

        except FileNotFoundError:
            print('File doesn\'t exist!\n'
                  'Change the path in the program or start the program with the '
                  'arguments <path1> <path2> <path3>')
            sys.exit(1)

        print(output)
        print("Durchschnitt: %.2f%%" % (mean / (len(files) * (len(files) - 1) / 2)))


if __name__ == '__main__':
    input_files = []

    if len(sys.argv) < 3:
        """
        If no arguments are given, the default values are used
        """

        input_files = ["testfiles/test-file-1.py", "testfiles/test-file-2.py", "testfiles/test-file-3.py",
                       "testfiles/test-file-4.py", "testfiles/test-file-5.py"]
    else:
        for arg_nr in range(1, len(sys.argv)):
            input_files.append(sys.argv[arg_nr])

    Checker(input_files)
