from controller.LoginScreen import LoginScreen
from controller.EmployeeManager import EmployeeManager
from controller.PayrollGenerator import PayrollGenerator
from view.UserInterface import UserInterface

class MainWindow:
    @staticmethod
    def main():
        login_screen = LoginScreen()
        exit_flag = False
        while not exit_flag:
            try:
                print("Desea registrar un nuevo usuario? (s/n) o presione 0 para salir: ")
                response = input()
                if response == "0":
                    exit_flag = True
                    continue
                if response.lower() == "s":
                    login_screen.register_user()
                username = input("Ingrese el nombre de usuario: ")
                if login_screen.check_password(username):
                    employee_manager = EmployeeManager()
                    payroll_generator = PayrollGenerator()
                    user_interface = UserInterface(employee_manager, payroll_generator)
                    user_interface.show_main_menu()
                    exit_flag = True  
                else:
                    print("Credenciales incorrectas. Intente nuevamente.")
            except Exception as e:
                print(f"Se produjo un error: {str(e)}")
                print("Intente nuevamente.")
        print("Saliendo del sistema...")
        
