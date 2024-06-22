from controller.EmployeeManager import Employee
from datetime import datetime
from controller.EmployeeManager import EmployeeManager
from controller.PayrollGenerator import PayrollGenerator

class UserInterface:
    BASIC_SALARY = 460.0

    def __init__(self, employee_manager=EmployeeManager(), payroll_generator=PayrollGenerator()):
        self.employee_manager = employee_manager
        self.payroll_generator = payroll_generator

    def show_main_menu(self):
        exit_flag = False
        while not exit_flag:
            print("Seleccione una opción:")
            print("1. Agregar empleado")
            print("2. Ver empleados")
            print("3. Editar empleado")
            print("4. Eliminar empleado")
            print("5. Generar roles de pago")
            print("6. Salir")
            option = self.get_int_input("Opción inválida\n")

            if option == 1:
                self.add_employee()
            elif option == 2:
                self.view_employees()
            elif option == 3:
                self.edit_employee()
            elif option == 4:
                self.delete_employee()
            elif option == 5:
                self.payroll_generator.generate_payrolls(self.employee_manager.get_employees())
            elif option == 6:
                exit_flag = True

    def add_employee(self):
        employees = self.employee_manager.get_employees()
        try:
            print("Ingrese el nombre: ")
            name = self.get_user_input("Nombre vacío\n")

            print("Ingrese el apellido: ")
            last_name = self.get_user_input("Apellido vacío\n")

            print("Ingrese el número de identificación: ")
            id_number = self.get_user_input("Número de identificación vacío\n")

            print("Ingrese la fecha de contratación (dd/MM/yyyy): ")
            date_str = input()
            hire_date = datetime.strptime(date_str, "%d/%m/%Y").date()

            print("Ingrese las horas extras: ")
            overtime_hours = self.get_double_input("Horas extras vacías\n")

            print("Ingrese los días ausentes: ")
            absent_days = self.get_double_input("Días ausentes vacíos\n")

            print("Ingrese las bonificaciones: ")
            bonuses = self.get_double_input("Bonificaciones vacías\n")

            print("Ingrese los préstamos del IESS: ")
            iess_loans = self.get_double_input("Préstamos al IESS vacíos\n")

            print("Ingrese los préstamos de la empresa: ")
            company_loans = self.get_double_input("Préstamo de la empresa vacío\n")

            print("Ingrese las multas: ")
            fines = self.get_double_input("Multas vacías\n")

            print("El empleado trae su propia comida? (True/False): ")
            bring_own_food = self.get_boolean_input("Entrada inválida\n")

            employee = Employee(name, last_name, id_number, hire_date, self.BASIC_SALARY, overtime_hours, absent_days, bonuses, iess_loans, company_loans, fines, bring_own_food)
            
            employee_existing = any(emp.get_id_number() == employee.get_id_number() for emp in employees)

            if employee_existing:
                print("!!ESTE EMPLEADO YA FUE INGRESADO!!")
            else:
                self.employee_manager.add_employee(employee)
                print("Empleado agregado correctamente.")
        except ValueError as e:
            print("Error en el formato de la fecha. Por favor, ingrésela en el formato dd/MM/yyyy.")
        except Exception as e:
            print("Error al ingresar los datos. Inténtelo nuevamente.")

    def view_employees(self):
        employees = self.employee_manager.get_employees()
        if not employees:
            print("No hay empleados registrados.")
        else:
            print("Lista de empleados:")
            for i, employee in enumerate(employees, 1):
                print(f"{i}. {employee.get_name()} {employee.get_last_name()}")

    def edit_employee(self):
        self.view_employees()
        if self.employee_manager.get_employees():
            try:
                print("Ingrese el número del empleado a editar: ")
                employee_index = int(input()) - 1

                if 0 <= employee_index < len(self.employee_manager.get_employees()):
                    employee = self.employee_manager.get_employees()[employee_index]
                    print("Ingrese el nuevo nombre (presione Enter para mantener el actual): ")
                    new_name = self.get_user_input("Nombre vacío\n")
                    if new_name:
                        employee.set_name(new_name)

                    print("Ingrese el nuevo apellido (presione Enter para mantener el actual): ")
                    new_last_name = self.get_user_input("Apellido vacío\n")
                    if new_last_name:
                        employee.set_last_name(new_last_name)

                    self.employee_manager.update_employee(employee_index, employee)
                    print("Empleado editado correctamente.")
                else:
                    print("Número de empleado inválido.")
            except Exception as e:
                print("Error al editar el empleado. Inténtelo nuevamente.")

    def delete_employee(self):
        self.view_employees()
        if self.employee_manager.get_employees():
            try:
                print("Ingrese el número del empleado a eliminar: ")
                employee_index = int(input()) - 1

                if 0 <= employee_index < len(self.employee_manager.get_employees()):
                    self.employee_manager.remove_employee(employee_index)
                    print("Empleado eliminado correctamente.")
                else:
                    print("Número de empleado inválido.")
            except Exception as e:
                print("Error al eliminar el empleado. Inténtelo nuevamente.")

    @staticmethod
    def get_user_input(error_message):
        try:
            return input().lower().strip()
        except Exception:
            print(error_message)
            return ""

    @staticmethod
    def get_double_input(error_message):
        try:
            return float(input())
        except ValueError:
            print(error_message)
            return 0.0

    @staticmethod
    def get_boolean_input(error_message):
        try:
            return input().lower() == "true"
        except Exception:
            print(error_message)
            return False

    @staticmethod
    def get_int_input(error_message):
        try:
            return int(input())
        except ValueError:
            print(error_message)
            return 0