from datetime import date
class Employee:
    def __init__(self, name, last_name, id_number, hire_date, basic_salary, overtime_hours, absent_days, bonuses, iess_loans, company_loans, fines, bring_own_food):
        self.name = name
        self.last_name = last_name
        self.id_number = id_number
        self.hire_date = hire_date
        self.basic_salary = basic_salary
        self.overtime_hours = overtime_hours
        self.absent_days = absent_days
        self.bonuses = bonuses
        self.iess_loans = iess_loans
        self.company_loans = company_loans
        self.fines = fines
        self.bring_own_food = bring_own_food
        
    def to_dict(self):
        return {
            'name': self.name,
            'last_name': self.last_name,
            'id_number': self.id_number,
            'hire_date': self.hire_date.isoformat() if isinstance(self.hire_date, date) else str(self.hire_date),
            'basic_salary': self.basic_salary,
            'overtime_hours': self.overtime_hours,
            'absent_days': self.absent_days,
            'bonuses': self.bonuses,
            'iess_loans': self.iess_loans,
            'company_loans': self.company_loans,
            'fines': self.fines,
            'bring_own_food': self.bring_own_food
        }
    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def get_id_number(self):
        return self.id_number

    def set_id_number(self, id_number):
        self.id_number = id_number

    def get_hire_date(self):
        return self.hire_date

    def set_hire_date(self, hire_date):
        self.hire_date = hire_date

    def get_basic_salary(self):
        return self.basic_salary

    def set_basic_salary(self, basic_salary):
        self.basic_salary = basic_salary

    def get_overtime_hours(self):
        return self.overtime_hours

    def set_overtime_hours(self, overtime_hours):
        self.overtime_hours = overtime_hours

    def get_absent_days(self):
        return self.absent_days

    def set_absent_days(self, absent_days):
        self.absent_days = absent_days

    def get_bonuses(self):
        return self.bonuses

    def set_bonuses(self, bonuses):
        self.bonuses = bonuses

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

    def is_bring_own_food(self):
        return self.bring_own_food

    def set_bring_own_food(self, bring_own_food):
        self.bring_own_food = bring_own_food
