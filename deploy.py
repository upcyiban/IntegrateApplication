import paramiko
import threading
import time

ip = '121.251.255.96'
deliverWater = 'root'
password = ''
jar = 'IntegrateApplication-0.0.1-SNAPSHOT.jar'
home='/root/Desktop/integrate'
current=home+"/current"
releases=home+"/releases"
test = home+"/test"

def execute_cmds(ip, deliverWater, passwd, cmd):
    try:
        ssh = paramiko.SSHClient()
        ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        ssh.connect(ip,22,deliverWater,passwd,timeout=5)
        for m in cmd:
            print (m)
            stdin, stdout, stderr = ssh.exec_command(m)
            #           stdin.write("Y")
            out = stdout.readlines()
            for o in out:
                print (o),
        print ('%s\tOK\n'%(ip))
        ssh.close()
    except :
        print ('%s\tError\n'%(ip))


if __name__=='__main__':
    print ('Start deploying %s to server %s'%(jar, ip))

    now = time.strftime("%Y%m%d%H%M%S")
    cmd = [
        'cp ' + current + '/' + jar + ' ' + test + '/' + jar,
        'echo Stop spring_integrate_test service... && service spring_integrate_test stop',
        'echo Start spring_integrate_test service... && service spring_integrate_test start',
        'echo Stop spring_integrate service... && service spring_integrate stop',
        'echo Use new jar... ' + \
        ' && mv ' + current + '/' + jar + ' ' + releases + '/' + now + '_' + jar ,
        'mv ' + home + '/' + jar + ' ' + current + '/' + jar,
        'echo Start spring_integrate service... && service spring_integrate start ' + \
        ' && echo All done.'
    ]
    a=threading.Thread(target=execute_cmds, args=(ip,deliverWater,password,cmd))
    a.start()