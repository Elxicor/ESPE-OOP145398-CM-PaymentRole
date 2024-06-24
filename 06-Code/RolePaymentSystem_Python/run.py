import sys
import os

# Añade el directorio actual al path de Python
current_dir = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, current_dir)

from view.MainWindow import MainWindow

if __name__ == "__main__":
    MainWindow.main()