import pygame
import random


class Weihnachsbaum:
    def __init__(self):
        pygame.init()
        self.rand_snow = []
        self.backgroundColor = 255, 255, 255
        self.size = [1000, 600]
        self.middle = [int(self.size[0] / 2), int(self.size[1] / 2)]
        self.screen = pygame.display.set_mode(self.size)
        self.update()
        self.random_snow()

    def random_snow(self):
        """
        Some snow
        """
        for i in range(100):
            self.rand_snow.append([random.randint(1, 1000), random.randint(1, 600)])

    def update(self):
        """
        Update screen
        """
        pygame.display.flip()
        self.screen.fill(self.backgroundColor)

    def draw_tree(self):
        """
        Chrismas tree
        """
        o_x = self.middle[0]
        o_y = 50
        l_x = o_x - 180
        l_y = o_y + 200
        r_x = o_x + 180
        r_y = l_y

        pygame.draw.polygon(self.screen, (0, 200, 0), [[o_x, o_y], [l_x + 20, l_y], [r_x - 20, r_y]])
        pygame.draw.polygon(self.screen, (0, 200, 0),
                            [[o_x + 50, o_y + 120], [o_x - 50, o_y + 120], [l_x, l_y + 120], [r_x, r_y + 120]])
        pygame.draw.polygon(self.screen, (0, 200, 0),
                            [[o_x + 50, o_y + 240], [o_x - 50, o_y + 240], [l_x, l_y + 240], [r_x, r_y + 240]])

        pygame.draw.rect(self.screen, (100, 100, 0), [[self.middle[0] - 30, 490], [60, 80]])

    def draw_ball(self):
        """
        Chrismas balls
        """
        pygame.draw.circle(self.screen, self.random_color(), [470, 150], 20)
        pygame.draw.circle(self.screen, self.random_color(), [550, 220], 20)
        pygame.draw.circle(self.screen, self.random_color(), [450, 250], 20)
        pygame.draw.circle(self.screen, self.random_color(), [530, 330], 20)
        pygame.draw.circle(self.screen, self.random_color(), [430, 420], 20)
        pygame.draw.circle(self.screen, self.random_color(), [570, 430], 20)

    def random_color(self):
        """
        Random color for the balls
        """
        return random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)

    def draw_star(self):
        """
        A star
        """
        pygame.draw.polygon(self.screen, (230, 230, 0),
                            [[self.middle[0], 25], [self.middle[0] - 20, 55], [self.middle[0] + 20, 55]])

        pygame.draw.polygon(self.screen, (230, 230, 0),
                            [[self.middle[0], 65], [self.middle[0] - 20, 35], [self.middle[0] + 20, 35]])

    def draw_snow(self):
        """
        Some snow
        """
        for index, i in enumerate(self.rand_snow):
            self.draw_snow_flake(i[0], i[1])
            self.rand_snow[index][1] += 2
            if self.rand_snow[index][1] > self.size[1]:
                self.rand_snow[index][1] = 0

    def draw_snow_flake(self, x, y):
        """
        Snow flakes
        """
        pygame.draw.line(self.screen, [0, 0, 0], [x, y], [x, y - 10], 1)
        pygame.draw.line(self.screen, [0, 0, 0], [x - 5, y - 5], [x + 5, y - 5], 1)
        pygame.draw.line(self.screen, [0, 0, 0], [x - 5, y - 9], [x + 5, y - 1], 1)
        pygame.draw.line(self.screen, [0, 0, 0], [x - 5, y - 1], [x + 5, y - 9], 1)

    def draw_presents(self):
        """
        2 presents
        """
        pygame.draw.rect(self.screen, (0, 100, 0), [[200, 470], [100, 100]])
        pygame.draw.rect(self.screen, (200, 0, 0), [[240, 470], [20, 100]])
        pygame.draw.rect(self.screen, (200, 0, 0), [[200, 510], [100, 20]])

        pygame.draw.rect(self.screen, (0, 50, 70), [[700, 470], [100, 100]])
        pygame.draw.rect(self.screen, (200, 0, 0), [[740, 470], [20, 100]])
        pygame.draw.rect(self.screen, (200, 0, 0), [[700, 510], [100, 20]])


if __name__ == '__main__':
    w = Weihnachsbaum()

    done = False
    clock = pygame.time.Clock()

    while not done:
        clock.tick(1000)
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                done = True

        w.draw_tree()
        w.draw_ball()
        w.draw_star()
        w.draw_presents()
        w.draw_snow()

        w.update()
        pygame.time.delay(300)
