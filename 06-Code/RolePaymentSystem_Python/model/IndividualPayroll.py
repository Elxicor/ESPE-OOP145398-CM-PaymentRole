from model.Income import Income
from model.Expenses import Expenses
from datetime import datetime
from calendar import monthrange

class IndividualPayroll:
    def __init__(self, employee, start_month_date, end_month_date, total_income, total_expenses, total_to_pay):
        self.employee = employee
        self.start_month_date = start_month_date
        self.end_month_date = end_month_date
        self.income = Income(employee)
        self.expenses = Expenses(employee, self.income.get_total_income())
        self.total_income = self.income.get_total_income()
        self.total_expenses = self.expenses.get_total_expenses()
        self.total_to_pay = self.total_income - self.total_expenses
        
    def to_dict(self):
        return {
            'employee': self.employee.to_dict(),
            'start_month_date': self.start_month_date.isoformat() if hasattr(self.start_month_date, 'isoformat') else str(self.start_month_date),
            'end_month_date': self.end_month_date.isoformat() if hasattr(self.end_month_date, 'isoformat') else str(self.end_month_date),
            'total_income': self.total_income,
            'total_expenses': self.total_expenses,
            'total_to_pay': self.total_to_pay
        }
    
    def get_employee(self):
        return self.employee

    def set_employee(self, employee):
        self.employee = employee

    def set_start_month_date(self, start_month_date):
        self.start_month_date = start_month_date

    def set_end_month_date(self, end_month_date):
        self.end_month_date = end_month_date

    def get_income(self):
        return self.income

    def set_income(self, income):
        self.income = income

    def get_expenses(self):
        return self.expenses

    def set_expenses(self, expenses):
        self.expenses = expenses

    def get_total_income(self):
        return self.total_income

    def set_total_income(self, total_income):
        self.total_income = total_income

    def get_total_expenses(self):
        return self.total_expenses

    def set_total_expenses(self, total_expenses):
        self.total_expenses = total_expenses

    def get_total_to_pay(self):
        return self.total_to_pay

    def set_total_to_pay(self, total_to_pay):
        self.total_to_pay = total_to_pay

    @staticmethod
    def get_start_month_date():
        now = datetime.now()
        start_date = datetime(now.year, now.month, 1)
        return start_date

    @staticmethod
    def get_end_month_date():
        now = datetime.now()
        last_day = monthrange(now.year, now.month)[1]
        end_date = datetime(now.year, now.month, last_day, 23, 59, 59, 999000)
        return end_date
