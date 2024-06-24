from model.Employee import Employee
from utils.Calculator import Calculator
class Expenses:
    def __init__(self, employee,total_income):
        reserve_funds = Calculator.calculate_reserve_funds(employee.get_basic_salary())
        self.iess_contribution = Calculator.calculate_iess_contribution(total_income, reserve_funds)
        self.biweekly_advance = Calculator.calculate_biweekly_advance(employee.get_basic_salary())
        self.iess_loans = employee.get_iess_loans()
        self.company_loans = employee.get_company_loans()
        self.fines = employee.get_fines()
        self.food_deduction = Calculator.calculate_food_deduction(employee.is_bring_own_food(), 25) 
        self.total_expenses = self.calculate_total_expenses()

    def calculate_total_expenses(self):
        total_expenses = (self.iess_contribution + self.biweekly_advance + self.iess_loans + self.company_loans + self.fines + self.food_deduction)
        return total_expenses

    def get_iess_contribution(self):
        return self.iess_contribution

    def set_iess_contribution(self, iess_contribution):
        self.iess_contribution = iess_contribution

    def get_biweekly_advance(self):
        return self.biweekly_advance

    def set_biweekly_advance(self, biweekly_advance):
        self.biweekly_advance = biweekly_advance

    def get_iess_loans(self):
        return self.iess_loans

    def set_iess_loans(self, iess_loans):
        self.iess_loans = iess_loans

    def get_company_loans(self):
        return self.company_loans

    def set_company_loans(self, company_loans):
        self.company_loans = company_loans

    def get_fines(self):
        return self.fines

    def set_fines(self, fines):
        self.fines = fines

    def get_food_deduction(self):
        return self.food_deduction

    def set_food_deduction(self, food_deduction):
        self.food_deduction = food_deduction

    def get_total_expenses(self):
        return self.calculate_total_expenses()
