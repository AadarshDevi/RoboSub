
from rclpy import Node
import rclpy

from src.pixhawk.pixhawk.MovementState import MovementState

class MovementNode(Node):

    def __init__(self):
        super().__init__('movement_node')
        self.__state: MovementState = MovementState.HOLDING

    def rotate(self, angle: float):
        self.__state = MovementState.ROTATING

    def move(self, distance: float):
        self.__state = MovementState.MOVING

    def strafe(self, angle: float, distance: float):
        self.__state = MovementState.STRAFING

    def dive(self, distance: float):
        self.__state = MovementState.DIVING

    def surface(self, distance: float):
        self.__state = MovementState.SURFACING

    def getMovementStatus() -> MovementState:
        return self.__state

    pass


def main():
    rclpy.init() # start ros2

    movementNode: MovementNode = MovementNode() # create movement node

    pass


if __name__ == '__main__':
    main()
