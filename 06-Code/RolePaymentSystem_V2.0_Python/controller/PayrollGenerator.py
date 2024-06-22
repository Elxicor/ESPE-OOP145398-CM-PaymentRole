import json
from model.GeneralPayroll import GeneralPayroll
from model.IndividualPayroll import IndividualPayroll
import json
from pathlib import Path
from datetime import date

class PayrollGenerator:
    PAYROLLS_FILE = 'payrolls.json'

    def __init__(self):
        pass

    def generate_payrolls(self, employees):
        individual_payrolls_json = []
        general_payrolls_json = []

        print("Roles de Pago:")
        print("%-20s %-20s %-20s %-20s %-20s %-20s" % ("Nombre", "Apellido", "Salario Básico", "Ingresos Totales", "Gastos Totales", "Pago Neto"))
        print("---------------------------------------------------------------------------------")

        for employee in employees:
            individual_payroll = self.generate_individual_payroll(employee, date.today(), date.today())
            individual_payrolls_json.append(individual_payroll.to_dict())

            general_payroll_list = self.generate_general_payrolls([employee])
            if general_payroll_list:
                general_payroll = general_payroll_list[0]
                general_payrolls_json.append(general_payroll.to_dict())

            nombre = employee.get_name()
            apellido = employee.get_last_name()
            salario_basico = employee.get_basic_salary()
            ingresos_totales = individual_payroll.get_total_income()
            gastos_totales = individual_payroll.get_total_expenses()
            pago_neto = individual_payroll.get_total_to_pay()

            print("%-20s %-20s %-20.2f %-20.2f %-20.2f %-20.2f" % (nombre, apellido, salario_basico, ingresos_totales, gastos_totales, pago_neto))

        payrolls_json = {
            "individualPayrolls": individual_payrolls_json,
            "generalPayrolls": general_payrolls_json
        }

        self.save_payrolls_to_file(payrolls_json)

    def generate_individual_payroll(self, employee, start_date, end_date):
        basic_salary = employee.get_basic_salary()
        overtime_hours_value = employee.get_overtime_hours() * 1.5 * (basic_salary / 240)
        bonuses = employee.get_bonuses()
        iess_contribution = basic_salary * 0.0935
        biweekly_advance = basic_salary / 2
        iess_loans = employee.get_iess_loans()
        company_loans = employee.get_company_loans()
        fines = employee.get_fines()
        food_deduction = 0 if employee.is_bring_own_food() else 25

        total_income = basic_salary + overtime_hours_value + bonuses
        total_expenses = iess_contribution + biweekly_advance + iess_loans + company_loans + fines + food_deduction
        net_payment = total_income - total_expenses
        
        return IndividualPayroll(employee, start_date, end_date, total_income, total_expenses, net_payment)
    
    def generate_general_payrolls(self, employees):
        general_payroll_list = []

        for employee in employees:
            name = employee.get_name()
            last_name = employee.get_last_name()
            hours_worked = 0
            days_worked = 0
            salary = employee.get_basic_salary()
            reserve_funds = 0
            bonuses = employee.get_bonuses()
            overtime_hours = employee.get_overtime_hours()

            general_payroll = GeneralPayroll(name, last_name, hours_worked, days_worked, salary, reserve_funds, bonuses, overtime_hours)
            general_payroll_list.append(general_payroll)

        return general_payroll_list

    def save_payrolls_to_file(self, payrolls_json):
        file_path = Path(self.PAYROLLS_FILE)
        try:
            with open(self.PAYROLLS_FILE, 'w', encoding='utf-8') as file:
                json.dump(payrolls_json, file, indent=4, ensure_ascii=False)
        except IOError as e:
            print("Error al guardar los roles de pago:", e)