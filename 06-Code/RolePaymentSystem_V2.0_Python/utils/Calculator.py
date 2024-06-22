from model.Constants import Constants
class Calculator:
    @staticmethod
    def calculate_basic_salary(annual_salary):
        return annual_salary / 12

    @staticmethod
    def calculate_overtime_hours(hours_worked, regular_hours, hourly_rate):
        overtime_hours = hours_worked - regular_hours
        overtime_value = overtime_hours * hourly_rate * Constants.OVERTIME_HOUR_INCREASE
        return overtime_value

    @staticmethod
    def calculate_reserve_funds(basic_salary):
        return basic_salary * Constants.RESERVE_FUNDS_PERCENTAGE

    @staticmethod
    def calculate_iess_contribution(total_income, reserve_funds):
        iess_contribution = (total_income - reserve_funds) * Constants.IESS_PERCENTAGE
        return iess_contribution

    @staticmethod
    def calculate_biweekly_advance(basic_salary):
        return basic_salary / 2

    @staticmethod
    def calculate_food_deduction(brings_own_food, food_deduction_amount):
        return 0 if brings_own_food else food_deduction_amount

    @staticmethod
    def calculate_total_income(basic_salary, overtime_payment, bonuses):
        return basic_salary + overtime_payment + bonuses

    @staticmethod
    def calculate_total_expenses(iess_contribution, biweekly_advance, iess_loans, company_loans, fines, food_deduction):
        return iess_contribution + biweekly_advance + iess_loans + company_loans + fines + food_deduction

    @staticmethod
    def calculate_net_payment(total_income, total_expenses):
        return total_income - total_expenses

    @staticmethod
    def calculate_employer_contribution(total_income, reserve_funds):
        return (total_income + reserve_funds) * Constants.EMPLOYER_CONTRIBUTION_PERCENTAGE

    @staticmethod
    def calculate_total_employee_cost(net_payment, employer_contribution):
        return net_payment + employer_contribution