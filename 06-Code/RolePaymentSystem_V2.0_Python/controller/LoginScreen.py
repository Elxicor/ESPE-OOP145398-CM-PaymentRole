class LoginScreen:
    def __init__(self):
        self.users = {"admin": "admin"}

    def register_user(self):
        username = input("Ingrese el nombre de usuario: ")
        if username in self.users:
            print("El usuario ya existe.")
            return

        password = input("Ingrese la contraseña: ")
        self.users[username] = password
        print("Usuario registrado exitosamente.")

    def check_password(self, username):
        if username not in self.users:
            print("Usuario no encontrado.")
            return False

        entered_password = input("Ingrese la contraseña: ")
        if entered_password == self.users[username]:
            print("Contraseña correcta.")
            return True
        else:
            print("Contraseña incorrecta.")
            return False