from model.OvertimeHours import OvertimeHours
from model.Employee import Employee
from model.Constants import Constants
from utils.Calculator import Calculator
class Income:
    def __init__(self, employee):
        self.basic_salary = employee.get_basic_salary()
        self.overtime_hours = OvertimeHours(employee.get_overtime_hours(),Calculator.calculate_overtime_hours(employee.get_overtime_hours(),Constants.REGULAR_HOURS_PER_MONTH,self.basic_salary / Constants.REGULAR_HOURS_PER_MONTH))
        self.bonuses = employee.get_bonuses()
        self.total_income = self.calculate_total_income()

    def calculate_total_income(self):
        total_income = self.basic_salary + self.overtime_hours.get_value() + self.bonuses
        return total_income

    def get_basic_salary(self):
        return self.basic_salary

    def set_basic_salary(self, basic_salary):
        self.basic_salary = basic_salary

    def get_overtime_hours(self):
        return self.overtime_hours

    def set_overtime_hours(self, overtime_hours):
        self.overtime_hours = overtime_hours

    def get_bonuses(self):
        return self.bonuses

    def set_bonuses(self, bonuses):
        self.bonuses = bonuses

    def get_total_income(self):
        return self.calculate_total_income()