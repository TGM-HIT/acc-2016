#!/usr/bin/python

import sys
from difflib import SequenceMatcher
from itertools import combinations

if len(sys.argv) < 3:
    print('Cannot compare less than 2 files.')
    print('Usage: ./plagiatscheck.py  [files.. ]')
    print('Script was written in Python 3.5')


def check(*files):
    all_ratios = []

    for file_name1, file_name2 in combinations(files[0], 2):
        with open(file_name1) as file_1, open(file_name2) as file_2:
            file1_data = file_1.read()
            file2_data = file_2.read()

            # Sequence Matcher does all required tasks on it's one (only checks blocks and not whole file)
            similarity_ratio = SequenceMatcher(None, file1_data, file2_data).ratio() * 100
            all_ratios.append(similarity_ratio)
            print("{} : {} {}%{}".format(file_name1, file_name2, round(similarity_ratio, 2),
                                                 "" if similarity_ratio < 80 else "\t\tthis is probably  plagiarized"))

    print("Average similarity: {0:.2f}%".format(sum(all_ratios) / len(all_ratios)))


check(sys.argv[1::])
