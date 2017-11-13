import io


def read_words_as_set(filename):
    out = set()
    with io.open(filename, "r") as read_file:
        lines = read_file.readlines()
        for line in lines:
            out |= set(line.split(' ')) # Put all words into the set
    return out


def check(*args):
    for outer_index in range(0, len(args)):
        set_for_outer_index = read_words_as_set(args[outer_index])
        for inner_index in range(outer_index + 1, len(args)):
            if args[outer_index] != args[inner_index]:
                set_for_inner_index = read_words_as_set(args[inner_index])
                same_elems = len(set_for_outer_index & set_for_inner_index)

                # (float(len(set_for_outer_index) + len(set_for_inner_index)) / 2 --> nearly total number
                print("%s : %s   %d Prozent" % (
                    args[outer_index],
                    args[inner_index],
                    same_elems / (float(len(set_for_outer_index) + len(set_for_inner_index)) / 2) * 100)
                      )



if __name__ == '__main__':
    check("text1", "text2", "text3", "text4")
