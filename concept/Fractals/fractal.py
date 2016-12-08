import math
import pygame

pygame.init()
window = pygame.display.set_mode((600, 600))
pygame.display.set_caption("Fractal Tree")
screen = pygame.display.get_surface()


def draw_tree(x1, y1, angle, depth):
    if depth:
        x2 = x1 + int(math.cos(math.radians(angle)) * depth * 10.0)
        y2 = y1 + int(math.sin(math.radians(angle)) * depth * 10.0)
        pygame.draw.line(screen, (255, 255, 255), (x1, y1), (x2, y2), 2)
        draw_tree(x2, y2, angle - 20, depth - 1)
        draw_tree(x2, y2, angle + 20, depth - 1)

draw_tree(300, 550, -90, 10)
pygame.display.flip()

while True:
    if pygame.event.wait().type == pygame.QUIT:
        exit(0)
