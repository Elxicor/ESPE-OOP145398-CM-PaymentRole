from datetime import datetime, date
from model.Employee import Employee
import json
from pathlib import Path
class EmployeeManager:
    EMPLOYEES_FILE = "employees.json"

    def __init__(self):
        self.employees = self.load_employees()

    def add_employee(self, employee):
        self.employees.append(employee)
        self.save_employees()

    def update_employee(self, index, employee):
        if 0 <= index < len(self.employees):
            self.employees[index] = employee
            self.save_employees()
        else:
            print("Índice fuera de rango.")

    def remove_employee(self, index):
        if 0 <= index < len(self.employees):
            self.employees.pop(index)
            self.save_employees()
        else:
            print("Índice fuera de rango.")

    def get_employees(self):
        return self.employees

    def load_employees(self):
        employees = []
        file_path = Path(self.EMPLOYEES_FILE)
        if file_path.exists():
            try:
                with open(self.EMPLOYEES_FILE, 'r', encoding='utf-8') as file:
                    json_data = file.read() 
                    json_data = json.loads(json_data) 
                    for employee_data in json_data:
                        if 'hire_date' in employee_data:
                            employee_data['hire_date'] = datetime.strptime(employee_data['hire_date'], "%Y-%m-%d").date()
                        employee = Employee(**employee_data)
                        employees.append(employee)
            except (IOError, json.JSONDecodeError) as e:
                print("Error al cargar los empleados:", e)
        return employees

    def save_employees(self):
        json_data = [employee.to_dict() for employee in self.employees]
        try:
            with open(self.EMPLOYEES_FILE, 'w', encoding='utf-8') as file:
                json.dump(json_data, file, indent=4, ensure_ascii=False)
        except IOError as e:
            print("Error al guardar los empleados:", e)