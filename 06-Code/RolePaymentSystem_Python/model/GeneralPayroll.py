class GeneralPayroll:
    def __init__(self, name, last_name, hours_worked, days_worked, salary, reserve_funds, bonuses, overtime_hours):
        self.name = name
        self.last_name = last_name
        self.hours_worked = hours_worked
        self.days_worked = days_worked
        self.salary = salary
        self.reserve_funds = reserve_funds
        self.bonuses = bonuses
        self.overtime_hours = overtime_hours
        self.overtime_payment = 0.0
        self.night_shift_surcharge = 0.0
        self.total_income = 0.0
        self.iess_contribution = 0.0
        self.iess_loans = 0.0
        self.fines = 0.0
        self.biweekly_advance = 0.0
        self.food_deduction = 0.0
        self.salary_advances = 0.0
        self.total_expenses = 0.0
        self.net_payment = 0.0
        self.employer_contribution = 0.0
        self.total_employee_cost = 0.0
        self.observations = ""
    def to_dict(self):
        return {
            'name': self.name,
            'last_name': self.last_name,
            'hours_worked': self.hours_worked,
            'days_worked': self.days_worked,
            'salary': self.salary,
            'reserve_funds': self.reserve_funds,
            'bonuses': self.bonuses,
            'overtime_hours': self.overtime_hours,
            'overtime_payment': self.overtime_payment,
            'night_shift_surcharge': self.night_shift_surcharge,
            'total_income': self.total_income,
            'iess_contribution': self.iess_contribution,
            'iess_loans': self.iess_loans,
            'fines': self.fines,
            'biweekly_advance': self.biweekly_advance,
            'food_deduction': self.food_deduction,
            'salary_advances': self.salary_advances,
            'total_expenses': self.total_expenses,
            'net_payment': self.net_payment,
            'employer_contribution': self.employer_contribution,
            'total_employee_cost': self.total_employee_cost,
            'observations': self.observations
        }

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def get_hours_worked(self):
        return self.hours_worked

    def set_hours_worked(self, hours_worked):
        self.hours_worked = hours_worked

    def get_days_worked(self):
        return self.days_worked

    def set_days_worked(self, days_worked):
        self.days_worked = days_worked

    def get_salary(self):
        return self.salary

    def set_salary(self, salary):
        self.salary = salary

    def get_reserve_funds(self):
        return self.reserve_funds

    def set_reserve_funds(self, reserve_funds):
        self.reserve_funds = reserve_funds

    def get_bonuses(self):
        return self.bonuses

    def set_bonuses(self, bonuses):
        self.bonuses = bonuses

    def get_overtime_hours(self):
        return self.overtime_hours

    def set_overtime_hours(self, overtime_hours):
        self.overtime_hours = overtime_hours

    def get_overtime_payment(self):
        return self.overtime_payment

    def set_overtime_payment(self, overtime_payment):
        self.overtime_payment = overtime_payment

    def get_night_shift_surcharge(self):
        return self.night_shift_surcharge

    def set_night_shift_surcharge(self, night_shift_surcharge):
        self.night_shift_surcharge = night_shift_surcharge

    def get_total_income(self):
        return self.total_income

    def set_total_income(self, total_income):
        self.total_income = total_income

    def get_iess_contribution(self):
        return self.iess_contribution

    def set_iess_contribution(self, iess_contribution):
        self.iess_contribution = iess_contribution

    def get_iess_loans(self):
        return self.iess_loans

    def set_iess_loans(self, iess_loans):
        self.iess_loans = iess_loans

    def get_fines(self):
        return self.fines

    def set_fines(self, fines):
        self.fines = fines

    def get_biweekly_advance(self):
        return self.biweekly_advance

    def set_biweekly_advance(self, biweekly_advance):
        self.biweekly_advance = biweekly_advance

    def get_food_deduction(self):
        return self.food_deduction

    def set_food_deduction(self, food_deduction):
        self.food_deduction = food_deduction

    def get_salary_advances(self):
        return self.salary_advances

    def set_salary_advances(self, salary_advances):
        self.salary_advances = salary_advances

    def get_total_expenses(self):
        return self.total_expenses

    def set_total_expenses(self, total_expenses):
        self.total_expenses = total_expenses

    def get_net_payment(self):
        return self.net_payment

    def set_net_payment(self, net_payment):
        self.net_payment = net_payment

    def get_employer_contribution(self):
        return self.employer_contribution

    def set_employer_contribution(self, employer_contribution):
        self.employer_contribution = employer_contribution

    def get_total_employee_cost(self):
        return self.total_employee_cost

    def set_total_employee_cost(self, total_employee_cost):
        self.total_employee_cost = total_employee_cost

    def get_observations(self):
        return self.observations

    def set_observations(self, observations):
        self.observations = observations
